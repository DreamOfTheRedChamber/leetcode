# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class WiggleSubsequence(unittest.TestCase):

    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        longestUp = [1 for x in range(len(nums))]
        longestDown = [1 for x in range(len(nums))]
        for i in range(1, len(nums)):
            if nums[i] > nums[i-1]:
                longestUp[i] = longestDown[i-1] + 1
                # it does not contribute to the longest wiggle down sequence
                longestDown[i] = longestDown[i-1]
            elif nums[i] < nums[i-1]:
                longestDown[i] = longestUp[i-1] + 1
                longestUp[i] = longestUp[i-1]
            else:
                longestUp[i] = longestUp[i-1]
                longestDown[i] = longestDown[i-1]

        return max(longestUp[len(nums) - 1], longestDown[len(nums) - 1])

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual(6, self.wiggleMaxLength([1, 7, 4, 9, 2, 5]))
        self.assertEqual(7, self.wiggleMaxLength([1, 17, 5, 10, 13, 15, 10, 5, 16, 8]))
        self.assertEqual(2, self.wiggleMaxLength([1, 2, 3, 4, 5, 6, 7, 8, 9]))

    @unittest.skip
    def test_Edgecase(self):
        self.assertEqual(5, self.wiggleMaxLength([6, 2, 7, 1, 8]))
        self.assertEqual(1, self.wiggleMaxLength([1]))
        self.assertEqual(0, self.wiggleMaxLength([]))

    def test_Errorcase(self):
        self.assertEqual(3, self.wiggleMaxLength([1, 17, 5]))

    def test_Illustrativecase(self):
        self.assertEqual(3, self.wiggleMaxLength([1, 17, 5]))
        self.assertEqual(3, self.wiggleMaxLength([6, 17, 5]))

if __name__ == '__main__':
    unittest.main()