# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class SearchInRotatedSortedArray(unittest.TestCase):

    def search(self, nums: List[int], target: int) -> int:
        def findPeak(nums: List[int]) -> int:
            if len(nums) == 0:
                return -1

            low = 0
            high = len(nums) - 1
            while low + 1 < high:
                mid = (high - low) // 2 + low
                if nums[mid] >= nums[low]:
                    low = mid
                else: # nums[mid] > nums[high]
                    high = mid

            return low if nums[low] > nums[high] else high

        def findTarget(nums: List[int], target: int, low: int, high: int) -> int:
            if len(nums) == 0 or low > high:
                return -1

            while low + 1 < high:
                mid = (high - low) // 2 + low
                if nums[mid] == target:
                    return mid
                elif nums[mid] > target:
                    high = mid
                else:
                    low = mid

            if nums[low] == target:
                return low
            elif nums[high] == target:
                return high
            else:
                return -1

        if len(nums) == 0:
            return -1
        peakIndex = findPeak(nums)
        if target >= nums[0]:
            return findTarget(nums, target, 0, peakIndex)
        else:
            return findTarget(nums, target, peakIndex + 1, len(nums) - 1)

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


if __name__ == '__main__':
    unittest.main()