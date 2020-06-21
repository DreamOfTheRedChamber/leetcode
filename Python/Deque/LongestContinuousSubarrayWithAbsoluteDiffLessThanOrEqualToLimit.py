# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List


class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit(unittest.TestCase):

    def longestSubarray(self, nums: List[int], limit: int) -> int:
        minIncDeque = deque([nums[0]])
        maxDecDeque = deque([nums[0]])

        start = 0
        end = 1
        result = 1
        maxDiff = 0
        while end < len(nums):
            while end < len(nums) and maxDiff <= limit:
                while maxDecDeque and maxDecDeque[-1] < nums[end]:
                    maxDecDeque.pop()
                maxDecDeque.append(nums[end])
                while minIncDeque and minIncDeque[-1] > nums[end]:
                    minIncDeque.pop()
                minIncDeque.append(nums[end])
                end += 1
                maxDiff = maxDecDeque[0] - minIncDeque[0]
                if maxDiff <= limit:
                    result = max(result, end - start)

            while start < end and maxDiff > limit:
                if nums[start] == maxDecDeque[0]:
                    maxDecDeque.popleft()
                if nums[start] == minIncDeque[0]:
                    minIncDeque.popleft()
                start += 1
                maxDiff = maxDecDeque[0] - minIncDeque[0]
                if maxDiff <= limit:
                    result = max(result, end - 1 - start)

        return result

    def test_Leetcode(self):
        self.assertEqual(2, self.longestSubarray([8, 2, 4, 7], 4))
        self.assertEqual(4, self.longestSubarray([10, 1, 2, 4, 7, 2], 5))
        self.assertEqual(3, self.longestSubarray([4, 2, 2, 2, 4, 4, 2, 2], 0))

if __name__ == '__main__':
    unittest.main()