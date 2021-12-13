# Definition for a binary tree node.
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


            return []

        def buildUnmatchedTrades(houseToTypeId: dict, streetToTypeId: dict) -> List[str]:

            return []

        # build map "symbol+quantity" => "type+ID"
        houseToTypeId = defaultdict(lambda: [])
        for symbol, type, quantity, id in houseTrades:
            houseToTypeId[symbol+","+quantity].append(type+","+id)

        streetToTypeId = defaultdict(lambda: [])
        for symbol, type, quantity, id in streetTrades:
            streetToTypeId[symbol+","+quantity].append(type+","+id)

        result = buildUnmatchedTrades(houseToTypeId, streetToTypeId)
        return result

    def test_FindExactMatch(self):
        houseTrades = ["AAPL,B,0100,ABC123", "AAPL,B,0100,ABC123", "GOOG,S,0050,CDC333"]
        streetTrades = ["  FB,B,0100,GBGGGG", "AAPL,B,0100,ABC123"]
        print(self.findUnmatchedExactTrades(houseTrades, streetTrades))
        return

    @unittest.skip
    def test_MultiMatchWithSameDis(self):
        return

if __name__ == '__main__':
    unittest.main()