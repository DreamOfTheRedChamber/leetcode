# Definition for a binary tree node.
import bisect
import unittest
from collections import defaultdict
from typing import List

class CandleStick(unittest.TestCase):

    def calcCandleStick(self, input: str) -> List[List[int]]:
        class Interval:

            def __init__(self):
                self.maxV = float('-inf')
                self.minV = float('inf')
                self.firstPrice = (float('inf'), 0)
                self.lastPrice = (-float('inf'), 0)

            def add(self, timestamp: int, price: int):
                self.maxV = max(self.maxV, price)
                self.minV = min(self.minV, price)
                if timestamp < self.firstPrice[0]:
                    self.firstPrice = (timestamp, price)
                if timestamp > self.lastPrice[0]:
                    self.lastPrice = (timestamp, price)

        def recordEntries(priceToPairs: str) -> dict:
            priceTsPairs = input.split(",")
            startToInterval = defaultdict(lambda: Interval())

            for pair in priceTsPairs:
                price, time = pair.split(":")
                price = int(price)
                time = int(time)
                floorS = time // 10
                startToInterval[floorS].add(time, price)

            return startToInterval

        startToInterval = recordEntries(input)

        start = min(startToInterval.keys())
        end = max(startToInterval.keys())
        result = []
        lastPrice = None
        for i in range(start, end + 1):
            if i in startToInterval:
                lastPrice = startToInterval[i].lastPrice[1]
                result.append([i * 10, startToInterval[i].maxV, startToInterval[i].minV, startToInterval[i].firstPrice[1], startToInterval[i].lastPrice[1]])
            else:
                result.append([i * 10, lastPrice, lastPrice, lastPrice, lastPrice])

        return result

    def test_CandleStick(self):
        print(self.calcCandleStick("1:2,3:4,9:8,5:10,13:18,34:32,55:44"))

        return

if __name__ == '__main__':
    unittest.main()