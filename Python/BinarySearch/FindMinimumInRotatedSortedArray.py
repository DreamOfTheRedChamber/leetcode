# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class FindMinimumInRotatedSortedArray(unittest.TestCase):

    def findMin(self, nums: List[int]) -> int:
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

        minIndex = (findPeak(nums) + 1) % len(nums)
        return nums[minIndex]

    def test_Leetcode(self):
        self.assertEqual(1, self.findMin([3, 4, 5, 1, 2]))
        self.assertEqual(0, self.findMin([4, 5, 6, 7, 0, 1, 2]))

if __name__ == '__main__':
    unittest.main()