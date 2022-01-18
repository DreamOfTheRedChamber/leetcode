# https://www.1point3acres.com/bbs/thread-819383-1-1.html.
#
# // A trade is defined as a fixed-width string containing the 4 properties given below separated by commas:
#
# // Symbol (4 alphabetical characters, left-padded by spaces)
# // Type (either "B" or "S" for buy or sell)
# // Quantity (4 digits, left-padded by zeros)
# // ID (6 alphanumeric characters)
# // e.g.
# // "AAPL,B,0100,ABC123"
#
# // which represents a trade of a buy of 100 shares of AAPL with ID "ABC123"
#
# // Given two lists of trades - called "house" and "street" trades, write code to filter out groups of matches
# between trades and return a list of unmatched house and street trades sorted alphabetically. There are many ways to
# match trades, the first and most important way is an exact match (Tests 1-5):
#
# // An exact match is a house_trade+street_trade pair with identical symbol, type, quantity, and ID
# // Note: Trades are distinct but not unique
#
# // For example, given the following input:
#
# // // house_trades:
# // [
#    // "AAPL,B,0080,ABC123",
# // "AAPL,B,0050,ABC123",
# // "GOOG,S,0050,CDC333"
#    // ]
#
# // // street_trades:
# // [
#    // " FB,B,0100,GBGGGG",
# // "AAPL,B,0100,ABC123"
#    // ]
#
# // We would expect the following output:
#
# // [
#    // " FB,B,0100,GBGGGG",
# // "AAPL,B,0100,ABC123",
# // "GOOG,S,0050,CDC333"
#    // ]
#
# // Because the first (or second) house trade and second street trade form an exact match, leaving behind three
# unmatched trades.
#
# // Follow-up 1 (Test 6,7,8,9): A "fuzzy" match is a house_trade+street_trade pair with identical symbol, type,
# and quantity ignoring ID. Prioritize exact matches over fuzzy matches. Prioritize matching the earliest
# alphabetical house trade with the earliest alphabetical street trade in case of ties.
#
# // Follow-up 2: (Test 10) An offsetting match is a house_trade+house_trade or street_trade+street_trade pair where
# the symbol and quantity of both trades are the same, but the type is different (one is a buy and one is a sell).
# Prioritize exact and fuzzy matches over offsetting matches. Prioritize matching the earliest alphabetical buy with
# the earliest alphabetical sell.
#

import bisect
import collections
import unittest
from collections import defaultdict
from typing import List

class HouseStreetTrade(unittest.TestCase):

    def findUnmatchedExactTrades(self, houseTrades: List[str], streetTrades: List[str]) -> List[str]:
        houseHisto = collections.Counter(houseTrades)

        result = []
        for trade in streetTrades:
            if trade in houseHisto:
                houseHisto[trade] -= 1
                if houseHisto[trade] == 0:
                    del houseHisto[trade]
            else:
                result.append(trade)

        for key, value in houseHisto.items():
            result.append(key)

        return sorted(result)

    def buildTradeDict(self, trades: List[str]) -> dict:
        # build map "symbol+quantity" => "type+ID"
        symbolQuanToTypeId = defaultdict(lambda: [])
        for trade in trades:
            symbol, type, quantity, id = trade.split(",")
            symbolQuanToTypeId[(symbol, quantity)].append((type, id))
        return symbolQuanToTypeId

    def buildUnmatchedResult(self, tradeDict: dict) -> List[str]:
        result = []
        for key, valueList in tradeDict.items():
            symbol, quantity = key
            for item in valueList:
                type, id = item
                result.append(",".join([symbol, type, quantity, id]))
        return result

    def removeEntries(self, originalList: List, indexesToRemove: set) -> List:
        result = []
        for index, value in enumerate(originalList):
            if index not in indexesToRemove:
                result.append(value)
        return result

    def removeMatch(self, houseToTypeId: dict, streetToTypeId: dict, type: str):
        intersectKeys = houseToTypeId.keys() & streetToTypeId.keys()
        for key in intersectKeys:
            houseList = sorted(houseToTypeId[key])
            streetList = sorted(streetToTypeId[key])
            hIndexToRemove = set()
            sIndexToRemove = set()
            for i in range(len(houseList)):
                for j in range(len(streetList)):
                    if j in sIndexToRemove:
                        continue

                    if type == "exact" and houseList[i] == streetList[j]:
                        hIndexToRemove.add(i)
                        sIndexToRemove.add(j)
                        break
                    elif type == "fuzzy" and houseList[i][0] == streetList[j][0]:
                        hIndexToRemove.add(i)
                        sIndexToRemove.add(j)
                        break
            houseToTypeId[key] = self.removeEntries(houseList, hIndexToRemove)
            streetToTypeId[key] = self.removeEntries(streetList, sIndexToRemove)
        return

    def findUnmatchedExactFuzzyTrades(self, houseTrades: List[str], streetTrades: List[str]) -> List[str]:

        # build map "symbol+quantity" => "type+ID"
        houseTradeMap = self.buildTradeDict(houseTrades)
        streetTradeMap = self.buildTradeDict(streetTrades)

        self.removeMatch(houseTradeMap, streetTradeMap, "exact")
        self.removeMatch(houseTradeMap, streetTradeMap, "fuzzy")
        # removeMatch(houseTradeMap, streetTradeMap, "offset")

        result = self.buildUnmatchedResult(houseTradeMap)
        result.extend(self.buildUnmatchedResult(streetTradeMap))
        return sorted(result)

    @unittest.skip
    def test_FindExactMatch(self):
        houseTrades = ["AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"]
        streetTrades = ["  FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"]

        print(self.findUnmatchedExactTrades(houseTrades, streetTrades))
        return

    @unittest.skip
    def test1_FindExactFuzzyMatch(self):
        houseTrades = ["AAPL,S,0010,ZYX444", "AAPL,S,0010,ZYX444", "AAPL,B,0010,ABC123", "GOOG,S,0050,GHG545"]
        streetTrades = ["GOOG,S,0050,GHG545", "AAPL,S,0010,ZYX444", "AAPL,B,0010,TTT222"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

    def test2_FindExactFuzzyMatch(self):
        # houseTrades = ["AAPL,B,0010,ABC123", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "GOOG,S,0050,GHG545"]
        # streetTrades = ["GOOG,S,0050,GHG545", "AAPL,S,0015,ZYX444", "AAPL,B,0010,TTT222"]
        houseTrades = ["AAPL,B,0010,ABC123",  "AAPL,S,0015,ZYX444"]
        streetTrades = ["AAPL,B,0010,TTT222"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

    @unittest.skip
    def test3_FindExactFuzzyMatch(self):
        houseTrades = ["AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"]
        streetTrades = ["  FB,B,0100,GBGGG", "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

    @unittest.skip
    def test4_FindExactFuzzyMatch(self):
        houseTrades = ["AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"]
        streetTrades = ["  FB,B,0100,GBGGG", "AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333", "AAPL,S,0100,ABC124"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

    @unittest.skip
    def test5_FindExactFuzzyMatch_offset(self):
        houseTrades = ["AAPL,B,0010,ABC123", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "GOOG,S,0050,GHG545"]
        streetTrades = ["GOOG,S,0050,GHG545", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "AAPL,B,0500,TTT222"]
        houseTrades2 = ["AAPL,B,0010,ABC123", "AAPL,S,0015,ZYX444"]
        streetTrades2 = ["AAPL,B,0500,TTT222"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

if __name__ == '__main__':
    unittest.main()