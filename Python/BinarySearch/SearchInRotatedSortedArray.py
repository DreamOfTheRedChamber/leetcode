# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class SearchInRotatedSortedArray(unittest.TestCase):

    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 0:
            return -1

        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = (right - left) // 2 + left
            if nums[mid] > nums[left]:
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
            return left
        elif nums[right] == target:
            return right
        else:
            return -1

    def test_Leetcode(self):
        self.assertEqual(4, self.search([4, 5, 6, 7, 0, 1, 2], 0))
        self.assertEqual(-1, self.search([4, 5, 6, 7, 0, 1, 2], 3))

    def test_WrongAnswer(self):
        # always use low = mid / high = mid in the if else condition
        # self.assertEqual(1, self.search([5, 1, 3], 1))

        self.assertEqual(1, self.search([1, 3], 3))

    def test_TimeLimitExceeded(self):
        # use low + 1 < high in find peak function
        self.assertEqual(-1, self.search([1, 3], 0))

    def test_WrongAnswer2(self):
        self.assertEqual(0, self.search([1, 3, 5], 1))


if __name__ == '__main__':
    unittest.main()