# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class MaximumSizeSubarraySumEqualsK(unittest.TestCase):

    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        prefixSumToIndex = dict()
        prefixSumToIndex[0] = -1
        prefixSum = 0
        longest = 0

        for i in range(len(nums)):
            prefixSum += nums[i]
            if prefixSum - k in prefixSumToIndex:
                longest = max(longest, i - prefixSumToIndex[prefixSum - k])
            if prefixSum not in prefixSumToIndex:
                prefixSumToIndex[prefixSum] = i

        return longest

    def test_Leetcode(self):
        self.assertEqual(4, self.maxSubArrayLen([1, -1, 5, -2, 3], 3))
        self.assertEqual(2, self.maxSubArrayLen([-2, -1, 2, 1], 1))

    def test_EdgeCase(self):
        self.assertEqual(1, self.maxSubArrayLen([-1, 3, 2, 5], 3))
        self.assertEqual(0, self.maxSubArrayLen([-2, 4, 4, 9], 3))
        self.assertEqual(6, self.maxSubArrayLen([1, -1, 5, -2, 2, 3], 8))

if __name__ == '__main__':
    unittest.main()