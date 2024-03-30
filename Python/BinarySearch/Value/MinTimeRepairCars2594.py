# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from math import sqrt, floor
from typing import List

class MinTimeRepairCars(unittest.TestCase):

    def isPossible(self, minTime: int, ranks: List[int], cars: int) -> bool:
        totalNum = 0
        for r in ranks:
            madeNum = floor(sqrt(minTime / r))
            totalNum += madeNum
        return True if madeNum >= cars else False

    def repairCars(self, ranks: List[int], cars: int) -> int:
        end = max(ranks) * cars * cars
        start = 1
        while start + 1 < end:
            mid = (end - start) // 2 + start
            if self.isPossible(mid, ranks, cars):
                end = mid
            else:
                start = mid

        if self.isPossible(start, ranks, cars):
            return start
        else:
            return end

    def test_example1(self):
        ranks = [4, 2, 3, 1]
        cars = 10
        self.assertEqual(16, self.repairCars(ranks, cars))

    def test_example2(self):
        ranks = [5,1,8]
        cars = 6
        self.assertEqual(16, self.repairCars(ranks, cars))

if __name__ == '__main__':
    unittest.main()