# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class FindFirstAndLastPositionOfElementInSortedArray(unittest.TestCase):

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findFirst(nums: List[int], target: int) -> int:
            if not nums:
                return -1

            left = 0
            right = len(nums) - 1

            while left + 1 < right:
                mid = (right - left) // 2 + left
                if nums[mid] >= target:
                    right = mid
                else:
                    left = mid

            if nums[left] == target:
                return left
            elif nums[right] == target:
                return right
            else:
                return -1

        def findLast(nums: List[int], target: int) -> int:
            if not nums:
                return -1

            left = 0
            right = len(nums) - 1

            while left + 1 < right:
                mid = (right - left) // 2 + left
                if nums[mid] <= target:
                    left = mid
                else:
                    right = mid

            if nums[right] == target:
                return right
            elif nums[left] == target:
                return left
            else:
                return -1

        return [findFirst(nums, target), findLast(nums, target)]

    def test_Leetcode(self):
        self.assertEqual([3, 4], self.searchRange([5, 7, 7, 8, 8, 10], 8))
        self.assertEqual([-1, -1], self.searchRange([5, 7, 7, 8, 8, 10], 6))

if __name__ == '__main__':
    unittest.main()