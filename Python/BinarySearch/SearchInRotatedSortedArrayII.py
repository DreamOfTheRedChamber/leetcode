# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class SearchInRotatedSortedArrayII(unittest.TestCase):

    def search(self, nums: List[int], target: int) -> bool:
        def findPeak(nums: List[int]) -> int:
            if len(nums) == 0:
                return -1

            low = 0
            high = len(nums) - 1
            while low + 1 < high:
                mid = (high - low) // 2 + low
                if nums[mid] == nums[low]:
                    low += 1
                elif nums[mid] > nums[low]:
                    low = mid
                else: # nums[mid] > nums[high]
                    high = mid

            return low if nums[low] > nums[high] else high

        def findTarget(nums: List[int], target: int, low: int, high: int) -> bool:
            if len(nums) == 0 or low > high:
                return False

            while low + 1 < high:
                mid = (high - low) // 2 + low
                if nums[mid] == target:
                    return mid
                elif nums[mid] > target:
                    high = mid
                else:
                    low = mid

            if nums[low] == target or nums[high] == target:
                return True
            else:
                return False

        if len(nums) == 0:
            return False
        peakIndex = findPeak(nums)
        if target >= nums[0]:
            return findTarget(nums, target, 0, peakIndex)
        else:
            return findTarget(nums, target, peakIndex + 1, len(nums) - 1)

    @unittest.skip
    def test_Leetcode(self):
        self.assertTrue(self.search([2, 5, 6, 0, 0, 1, 2], 0))
        self.assertFalse(self.search([2, 5, 6, 0, 0, 1, 2], 3))
        self.assertTrue(self.search([2, 2, 2, 2, 3], 2))
        self.assertTrue(self.search([5, 1, 1, 1, 1, 3], 1))
        self.assertTrue(self.search([1, 3], 3))
        self.assertFalse(self.search([1, 3], 0))

    def test_WrongAnswer(self):
        self.assertTrue(self.search([1, 3, 1, 1, 1], 3))

if __name__ == '__main__':
    unittest.main()