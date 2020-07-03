# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class Heaters(unittest.TestCase):

    def findRadius(self, houses: List[int], heaters: List[int]) -> int:

        if not heaters:
            return -1

        heaters.sort()
        result = float('-inf')
        for house in houses:
            index = bisect.bisect_left(heaters, house)
            if index == 0:
                result = max(result, heaters[0] - house)
            elif index == len(heaters):
                result = max(result, house - heaters[-1])
            else:
                result = max(result, min(heaters[index] - house, house - heaters[index - 1]))

        return result

    def test_Leetcode(self):
        self.assertEqual(1, self.findRadius([1, 2, 3], [2]))
        self.assertEqual(1, self.findRadius([1, 2, 3, 4], [1, 4]))

    def test_WrongAnswer(self):
        self.assertEqual(3, self.findRadius([1, 5], [2]))

if __name__ == '__main__':
    unittest.main()