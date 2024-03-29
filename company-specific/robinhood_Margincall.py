# Our goal is to build a simplified version of a real Robinhood system that reads a customer's trades from a stream,
# maintains what they own, and rectifies running

# out of cash (through a process called a "margin call", which we'll define later). We’re looking for clean code,
# good naming, testing, etc. We're not particularly looking for the most performant solution. **Step 1 (tests 1-4):
# Parse trades and build a customer portfolio** Your input will be a list of trades, each of which is itself a list
# of strings in the form
# [timestamp, symbol, B/S (for buy/sell), quantity, price], e.g.
# [["1", "AAPL", "B", "10","10"],
# ["3", "GOOG", "B", "20", "5"],
# ["10", "AAPL", "S", "5", "15"]] is equivalent to buying 10 shares
# (i.e. units) of AAPL for 5 each at timestamp 3, and selling 5 shares of AAPL for $15 at timestamp 10.
# **Input assumptions:**
# - The input is sorted by timestamp
# - All numerical values are nonnegative integers
# - Trades will always be valid (i.e. a customer will never sell more of a stock than they own).

# From the provided list of trades, our goal is to maintain the customer's resulting portfolio (meaning
# everything they own), **assuming they begin with $1000**. For instance, in the above example, the customer would
# end up with $875, 5 shares of AAPL, and 20 shares of GOOG. You should return a list representing this portfolio,
# formatting each individual position as a list of strings in the form [symbol, quantity], using 'CASH' as the symbol
# for cash and sorting the remaining stocks alphabetically based on symbol. For instance, the above portfolio would
# be represented as

# [["CASH", "875"], ["AAPL", "5"], ["GOOG", "20"]]

# **Step 2 (tests 5-7): Margin calls**

# If the customer ever ends up with a negative amount of cash **after a buy**, they then enter a process known as a
# **margin call** to correct the situation. In this process, we forcefully sell stocks in the customer's portfolio (
# sometimes including the shares we just bought) until their cash becomes non-negative again.

# We sell shares from the most expensive to least expensive shares (based on each symbol's most-recently-traded
# price) with ties broken by preferring the alphabetically earliest symbol. Assume we're able to sell any number of
# shares in a symbol at that symbol's most-recently-traded price.

# For example, for this input:

# ```
# [["1", "AAPL", "B", "10", "100"],
# ["2", "AAPL", "S", "2", "80"],
# ["3", "GOOG", "B", "15", "20"]]

# ```

# The customer would be left with 8 AAPL shares, 15 GOOG shares, and 80 a share) to cover the deficit. Afterwards,
# they would have 6 shares of AAPL, 15 shares of GOOG, and a cash balance of $20.

# The expected output would be

# [["CASH", "20"], ["AAPL", "6"], ["GOOG", "15"]]

# **Step 3/Extension 1 (tests 8-10): Collateral**

# Certain stocks have special classifications, and require the customer to also own another "collateral" stock,
# meaning it cannot be sold during the margin call process. Our goal is to handle a simplified version of this
# phenomenon.

# Formally, we'll consider stocks with symbols ending in "O" to be special, with the remainder of the symbol
# identifying its collateral stock. For example, AAPLO is special, and its collateral stock is AAPL. **At all
# times**, the customer must hold at least as many shares of the collateral stock as they do the special stock; e.g.
# they must own at least as many shares of AAPL as they do of AAPLO.

# As a result, the margin call process will now sell the most valuable **non-collateral** share until the balance is
# positive again. Note that if this sells a special stock, some of the collateral stock may be freed up to be sold.

# For example, if the customer purchases 5 shares of AAPL for 75 each, then finally 5 shares of AAPLO for 125,
# but their shares of AAPL can no longer be used to cover the deficit (since they've become collateral for AAPLO). As
# a result, 2 shares of GOOG would be sold back (again at 25, 5 AAPL, 5 AAPLO, and 3 GOOG. Thus, with an input of

# [["1", "AAPL", "B", "5", "100"], ["2", "GOOG", "B", "5", "75"], ["3", "AAPLO", "B", "5", "50"]]

# the corresponding output would be

# [["CASH", "25"], ["AAPL", "5"], ["AAPLO", "5"], ["GOOG", "3"]

import bisect
import heapq
import math
import sys
import unittest
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList

class MarginCall(unittest.TestCase):

    def tradeWithoutMargin(self, orderList: List[str]) -> List[str]:
        # dict and initialize
        portfolio = defaultdict(lambda: 0)
        currBalance = 1000

        for _, symbol, type, quantity, price in orderList:
            start = 1 if type == "B" else -1
            portfolio[symbol] += start * int(quantity)
            currBalance += -start * int(quantity) * int(price)

        return self.buildPortfolio(portfolio, currBalance)

    def buildPortfolio(self, symbolToShareNum: dict, cashBalance: int) -> List[List[str]]:
        result = []
        result.append(["cash", str(cashBalance)])
        for key in sorted(symbolToShareNum.keys()):
            result.append([key, str(symbolToShareNum[key])])
        return result

    def maxSellableWithCollateral(self, symbol: str, symbolToShareNum: dict) -> int:
        collateral = symbol + "O"
        if symbol.endswith("O") or collateral not in symbolToShareNum:
            return symbolToShareNum[symbol]
        elif collateral in symbolToShareNum and symbolToShareNum[collateral] < symbolToShareNum[symbol]:
            return symbolToShareNum[symbol] - symbolToShareNum[collateral]
        else:
            return 0

    def getSymbolToSell(self, negBalance: int, symbolToLastPrice: dict, symbolToShareNum: dict, supportCollateral: bool) -> (str, int):
        symbolInPriceDescOrder = sorted(symbolToLastPrice.keys(), key=lambda k: symbolToLastPrice[k], reverse=True)
        symbolToSell = symbolInPriceDescOrder[0]
        numToSell = sys.maxsize

        if supportCollateral == True:
            # Find symbol to sell / num of shares according to collateral rule
            for symbol in symbolInPriceDescOrder:
                maxUnderCollateral = self.maxSellableWithCollateral(symbol, symbolToShareNum)
                if maxUnderCollateral != 0:
                    symbolToSell = symbol
                    numToSell = maxUnderCollateral
                    break

        neededNum = math.ceil(abs(negBalance) / symbolToLastPrice[symbolToSell])
        availableNum = symbolToShareNum[symbolToSell]
        numToSell = min(neededNum, availableNum, numToSell)
        return (symbolToSell, numToSell)

    def marginCall(self, cashBalance: int, symbolToLastPrice: dict, symbolToShareNum: dict, supportCollateral: bool) -> int:
        while cashBalance < 0:
            symbolToSell, numToSell = self.getSymbolToSell(cashBalance, symbolToLastPrice, symbolToShareNum, supportCollateral)
            cashBalance += numToSell * symbolToLastPrice[symbolToSell]
            symbolToShareNum[symbolToSell] -= numToSell
            if symbolToShareNum[symbolToSell] == 0:
                del symbolToShareNum[symbolToSell]
                del symbolToLastPrice[symbolToSell]
        return cashBalance

    def placeOrder(self, cashBalance: int, order: List[str], symbolToShareNum: dict) -> int:
        symbol, category, quantity, price = order[1], order[2], int(order[3]), int(order[4])
        if category == "B":
            cashBalance -= quantity * price
            symbolToShareNum[symbol] += quantity
        else:
            cashBalance += quantity * price
            symbolToShareNum[symbol] -= quantity
        return cashBalance

    # Assume input is always valid
    def tradeWithMargin(self, orderList: List[List[str]], supportCollateral: bool) -> List[str]:
        symbolToShareNum = defaultdict(lambda: 0)
        cashBalance = 1000
        symbolToLastPrice = {}

        for index, order in enumerate(orderList):
            cashBalance = self.placeOrder(cashBalance, order, symbolToShareNum)
            cashBalance = self.marginCall(cashBalance, symbolToLastPrice, symbolToShareNum, supportCollateral)

            symbol, lastPrice = order[1], int(order[-1])
            symbolToLastPrice[symbol] = lastPrice

        return self.buildPortfolio(symbolToShareNum, cashBalance)

    @unittest.skip
    def test_original(self):
        orderList = [["1", "AAPL", "B", "10", "10"], ["3", "GOOG", "B", "20", "5"], ["10", "AAPL", "S", "5", "15"]]
        print(self.tradeWithoutMargin(orderList))

    @unittest.skip
    def test_margin_1(self):
        orderList = [["1", "APPL", "B", "10", "100"], ["2", "APPL", "S", "2", "80"], ["3", "GOOG", "B", "15", "20"]]
        print(self.tradeWithMargin(orderList, False))

    @unittest.skip
    def test_margin_2(self):
        # special test by myself
        # Assumption: When buy one stock A, if not enough cash, it could even sell A according to the past price
        #             Whether a margin call could happen on a stock itself, NO.

        orderList = [["1", "APPL", "B", "10", "100"], ["2", "APPL", "S", "2", "80"], ["3", "APPL", "B", "15", "20"]]
        print(self.tradeWithMargin(orderList, False))

    @unittest.skip
    def test_margin_3(self):
        # has tie on price, take alpha first
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "ABPL", "B", "5", "100"], ["3", "AAPL", "S", "2", "80"],
                      ["4", "ABPL", "S", "2", "80"], ["5", "GOOG", "B", "15", "30"]]
        print(self.tradeWithMargin(tradeLists, False))

    @unittest.skip
    def test_margin_4(self):
        # pick high price first
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "ABPL", "B", "5", "100"], ["3", "AAPL", "S", "2", "80"],
                      ["4", "ABPL", "S", "2", "120"], ["5", "GOOG", "B", "15", "30"]]
        print(self.tradeWithMargin(tradeLists, False))

    @unittest.skip
    def test_margin_5(self):
        # need to sell multiple stocks
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "ABPL", "B", "5", "100"], ["3", "AAPL", "S", "2", "80"],
                      ["4", "ABPL", "S", "2", "120"], ["5", "GOOG", "B", "10", "80"]]
        print(self.tradeWithMargin(tradeLists, False))

    def test_collateral(self):
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "GOOG", "B", "5", "75"], ["3", "AAPLO", "B", "5", "50"]]
        print(self.tradeWithMargin(tradeLists, True))
        return

if __name__ == '__main__':
    unittest.main()
