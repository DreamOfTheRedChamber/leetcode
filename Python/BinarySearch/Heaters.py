# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class Heaters(unittest.TestCase):

    def findRadius(self, houses: List[int], heaters: List[int]) -> int:

        heaters = sorted(heaters) + [float('inf')]
        i = r = 0
        for x in sorted(houses):
            while x >= sum(heaters[i:i + 2]) / 2.:
                i += 1
            r = max(r, abs(heaters[i] - x))
        return r

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual(1, self.findRadius([1, 2, 3], [2]))
        self.assertEqual(1, self.findRadius([1, 2, 3, 4], [1, 4]))

    def test_WrongAnswer(self):
        self.assertEqual(3, self.findRadius([1, 5], [2]))

if __name__ == '__main__':
    unittest.main()