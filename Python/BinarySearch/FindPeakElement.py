# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class FindPeakElement(unittest.TestCase):

    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = (right - left) // 2 + left
            if nums[mid] < nums[mid+1]:
                left = mid
            else:
                right = mid

        if nums[left] > nums[right]:
            return left
        else:
            return right

    def test_Leetcode(self):
        self.assertEqual(2, self.findPeakElement([1, 2, 3, 1]))
        print(self.findPeakElement([1, 2, 1, 3, 5, 6, 4]))

if __name__ == '__main__':
    unittest.main()