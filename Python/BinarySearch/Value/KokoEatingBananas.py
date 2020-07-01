# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class KokoEatingBananas(unittest.TestCase):

    def minEatingSpeed(self, piles: List[int], H: int) -> int:

        def couldFinish(speed: int, totalHours: int) -> bool:
            usedHours = 0
            for i in piles:
                if i <= speed:
                    usedHours += 1
                else:
                    usedHours += i // speed
                    usedHours += 1 if i % speed != 0 else 0

            return True if usedHours <= totalHours else False

        left = 1
        right = sum(piles)
        while left + 1 < right:
            mid = (right - left) // 2 + left
            if couldFinish(mid, H):
                right = mid
            else:
                left = mid

        if couldFinish(left, H):
            return left
        else:
            return right

    def test_Leetcode(self):
        self.assertEqual(4, self.minEatingSpeed([3, 6, 7, 11], 8))
        self.assertEqual(30, self.minEatingSpeed([30, 11, 23, 4, 20], 5))
        self.assertEqual(23, self.minEatingSpeed([30, 11, 23, 4, 20], 6))

    def test_WrongAnswer(self):
        self.assertEqual(2, self.minEatingSpeed([312884470], 312884469))

if __name__ == '__main__':
    unittest.main()