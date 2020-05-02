# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class ContinuousArray(unittest.TestCase):

    def findMaxLength(self, nums: List[int]) -> int:
        prefixSumToIndex = dict()
        prefixSumToIndex[0] = -1

        longest = 0
        prefixSum = 0
        for i in range(len(nums)):
            prefixSum += -1 if nums[i] == 0 else 1
            if prefixSum in prefixSumToIndex:
                longest = max(longest, i - prefixSumToIndex[prefixSum])
            else:
                prefixSumToIndex[prefixSum] = i

        return longest

    def test_Leetcode(self):
        self.assertEqual(2, self.findMaxLength([0, 1]))
        self.assertEqual(2, self.findMaxLength([0, 1, 0]))

    def test_Edgecase(self):
        self.assertEqual(8, self.findMaxLength([0, 0, 1, 0, 1, 1, 0, 0, 1]))

if __name__ == '__main__':
    unittest.main()