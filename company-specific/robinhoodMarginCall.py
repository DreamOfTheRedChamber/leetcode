# Enable margin to have larger buying power. Pending orders / options collaterals are deducted from buying power build they are not counting towards your
# **margin used**.

# Arbitrage 操作一： Sell Put <==>有償Limit Order
# 示範操作
# Limit Order：Buy 100 Shares AT&T (symbol:T) @ limit 28 expired until 3 months.
# Sell Put Option: Sell 1 contract Put T@28, Expiry after 3 months. 帳戶Credit(獲得) $1.09 (option premium) * 100 = $109
# 從風險角度 這二操作一樣。但Sell Put Option 要Collateral(28*100 ＝2800） 相當借出 2800 collateral 三個月 獲利 109刀。 漏洞是 Robinhood 免費幫你借出 （collateral doesn't count towards margin used） 但獲利的是你。
# 這

# 补充内容 (2021-1-2 06:38):
# 我現在用這策略賣不同stocks put options 賺premium. Stocks 一般比較穩 不會是fubo tv 這種，而且strike price 是我自己會肯掛limit buy 買進的價位。 几個月後看看收益如何。

# Definition for a binary tree node.
import bisect
import heapq
import math
import unittest
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList


class MarginCall(unittest.TestCase):

    def getPortfolio(self, portfolioMap: dict) -> List[List[str]]:
        # return sorted result
        result = []
        result.append(["cash", str(portfolioMap["cash"])])
        for key in sorted(portfolioMap.keys()):
            if key != "cash":
                result.append([key, str(portfolioMap[key])])
        return result

    def calculatePortfolio(self, tradeLists: List[str]) -> List[str]:
        # dict and initialize
        portfolio = defaultdict(lambda: 0)
        portfolio["cash"] = 1000

        # loop through trade
        for ts, symbol, type, quantity, price in tradeLists:
            start = 1 if type == "B" else -1
            portfolio[symbol] += start * int(quantity)
            portfolio["cash"] += -start * int(quantity) * int(price)

        # return sorted result
        return self.getPortfolio(portfolio)

    def calculatePortfolioWithMargin(self, tradeLists: List[str]) -> List[str]:
        def getHighestPrice(symbolToPrice: dict) -> str:
            reverseSorted = sorted(symbolToPrice.keys(), key=lambda k: symbolToPrice[k], reverse=True)
            return reverseSorted[0] if reverseSorted[0] != "cash" else reverseSorted[1]

        # use heap to find margin call target
        symbolToNum = defaultdict(lambda: 0)
        cs = "cash"
        symbolToNum[cs] = 1000
        symbolToPrice = {}

        # loop through trade
        for ts, symbol, type, quantity, price in tradeLists:
            start = 1 if type == "B" else -1
            priceInt = int(price)
            quantityInt = int(quantity)

            symbolToNum[cs] += -start * quantityInt * priceInt

            while symbolToNum[cs] < 0:
                toSell = getHighestPrice(symbolToPrice)
                numToSell = min(math.ceil(abs(symbolToNum[cs]) / symbolToPrice[toSell]), symbolToNum[toSell])
                symbolToNum[cs] += numToSell * symbolToPrice[toSell]
                symbolToNum[toSell] -= numToSell
                if symbolToNum[toSell] == 0:
                    del symbolToNum[toSell]
                    del symbolToPrice[toSell]

            symbolToNum[symbol] += start * quantityInt
            symbolToPrice[symbol] = priceInt

        # return sorted result
        return self.getPortfolio(symbolToNum)

    @unittest.skip
    def test_original(self):
        tradeLists = [["1", "AAPL", "B", "10", "10"], ["3", "GOOG", "B", "20", "5"], ["10", "AAPL", "S", "5", "15"]]
        print(self.calculatePortfolio(tradeLists))

    @unittest.skip
    def test_margin_1(self):
        tradeLists = [["1", "APPL", "B", "10", "100"], ["2", "APPL", "S", "2", "80"], ["3", "GOOG", "B", "15", "20"]]

        print(self.calculatePortfolioWithMargin(tradeLists))

    @unittest.skip
    def test_margin_2(self):
        # special test by myself
        tradeLists = [["1", "APPL", "B", "10", "100"], ["2", "APPL", "S", "2", "80"], ["3", "APPL", "B", "15", "20"]]

        print(self.calculatePortfolioWithMargin(tradeLists))

    @unittest.skip
    def test_margin_3(self):
        # has tie on price, take alpha first
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "ABPL", "B", "5", "100"], ["3", "AAPL", "S", "2", "80"], ["4", "ABPL", "S", "2", "80"], ["5", "GOOG", "B", "15", "30"]]
        print(self.calculatePortfolioWithMargin(tradeLists))

    @unittest.skip
    def test_margin_4(self):
        # pick high price first
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "ABPL", "B", "5", "100"], ["3", "AAPL", "S", "2", "80"], ["4", "ABPL", "S", "2", "120"], ["5", "GOOG", "B", "15", "30"]]
        print(self.calculatePortfolioWithMargin(tradeLists))

    @unittest.skip
    def test_margin_5(self):
        # need to sell multiple stocks
        tradeLists = [["1", "AAPL", "B", "5", "100"], ["2", "ABPL", "B", "5", "100"], ["3", "AAPL", "S", "2", "80"], ["4", "ABPL", "S", "2", "120"], ["5", "GOOG", "B", "10", "80"]]
        print(self.calculatePortfolioWithMargin(tradeLists))

    @unittest.skip
    def test_collateral(self):
        return

if __name__ == '__main__':
    unittest.main()