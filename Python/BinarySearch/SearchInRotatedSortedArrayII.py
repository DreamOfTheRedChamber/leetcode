# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class SearchInRotatedSortedArrayII(unittest.TestCase):

    def search(self, nums: List[int], target: int) -> bool:
        if len(nums) == 0:
            return False

        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = (right - left) // 2 + left
            if nums[mid] == nums[left]:
                left += 1
            elif nums[mid] > nums[left]:
                if target >= nums[left] and target <= nums[mid]:
                    right = mid
                else:
                    left = mid
            else:
                if target >= nums[mid] and target <= nums[right]:
                    left = mid
                else:
                    right = mid

        if nums[left] == target:
            return True
        elif nums[right] == target:
            return True
        else:
            return False

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