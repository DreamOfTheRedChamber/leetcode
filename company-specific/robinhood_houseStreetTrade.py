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

    def findUnmatchedExactFuzzyTrades(self, houseTrades: List[str], streetTrades: List[str]) -> List[str]:

        def removeMatch(houseToTypeId: dict, streetToTypeId: dict, type: str):
            intersectKeys = houseToTypeId.keys() & streetToTypeId.keys()
            for key in intersectKeys:
                houseList = sorted(houseToTypeId[key])
                streetList = sorted(streetToTypeId[key])
                houseAfterRemoving = []
                streetAfterRemoving = []
                i = 0
                j = 0
                while i < len(houseList) and j < len(streetList):
                    if houseList[i] == streetList[j] and type == "exact":
                        i += 1
                        j += 1
                    elif houseList[i][0] == streetList[j][0] and type == "fuzzy":
                        i += 1
                        j += 1
                    elif houseList[i][0] == "B" and streetList[j][0] == "S":
                        houseAfterRemoving.append(houseList[i])
                        i += 1
                    else:
                        streetAfterRemoving.append(streetList[j])
                        j += 1
                while i < len(houseList):
                    houseAfterRemoving.append(houseList[i])
                    i += 1
                while j < len(streetList):
                    streetAfterRemoving.append(streetList[j])
                    j += 1

                houseToTypeId[key] = houseAfterRemoving
                streetToTypeId[key] = streetAfterRemoving

            return

        def buildUnmatchedTrades(houseToTypeId: dict, streetToTypeId: dict) -> List[str]:
            result = []

            for key, valueList in houseToTypeId.items():
                symbol, quantity = key.split(",")
                for item in valueList:
                    type, id = item.split(",")
                    result.append(symbol+","+type+","+quantity+","+id)
            for key, valueList in streetToTypeId.items():
                symbol, quantity = key.split(",")
                for item in valueList:
                    type, id = item.split(",")
                    result.append(symbol+","+type+","+quantity+","+id)

            sortedResult = sorted(result)
            return sortedResult

        # build map "symbol+quantity" => "type+ID"
        houseToTypeId = defaultdict(lambda: [])
        for trade in houseTrades:
            symbol, type, quantity, id = trade.split(",")
            houseToTypeId[symbol+","+quantity].append(type+","+id)

        streetToTypeId = defaultdict(lambda: [])
        for trade in streetTrades:
            symbol, type, quantity, id = trade.split(",")
            streetToTypeId[symbol+","+quantity].append(type+","+id)

        removeMatch(houseToTypeId, streetToTypeId, "exact")
        removeMatch(houseToTypeId, streetToTypeId, "fuzzy")

        result = buildUnmatchedTrades(houseToTypeId, streetToTypeId)
        return result

    @unittest.skip
    def test_FindExactMatch(self):
        houseTrades = ["AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"]
        streetTrades = ["  FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"]

        print(self.findUnmatchedExactTrades(houseTrades, streetTrades))
        return

    def test1_FindExactFuzzyMatch(self):
        houseTrades = ["AAPL,S,0010,ZYX444", "AAPL,S,0010,ZYX444", "AAPL,B,0010,ABC123", "GOOG,S,0050,GHG545"]
        streetTrades = ["GOOG,S,0050,GHG545", "AAPL,S,0010,ZYX444", "AAPL,B,0010,TTT222"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

    @unittest.skip
    def test2_FindExactFuzzyMatch(self):
        houseTrades = ["AAPL,B,0010,ABC123", "AAPL,S,0015,ZYX444", "AAPL,S,0015,ZYX444", "GOOG,S,0050,GHG545"]
        streetTrades = ["GOOG,S,0050,GHG545", "AAPL,S,0015,ZYX444", "AAPL,B,0500,TTT222"]

        print(self.findUnmatchedExactFuzzyTrades(houseTrades, streetTrades))
        return

if __name__ == '__main__':
    unittest.main()