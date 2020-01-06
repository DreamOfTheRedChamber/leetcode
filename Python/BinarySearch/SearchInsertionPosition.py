import unittest
from typing import List


class SearchInsertPosition(unittest.TestCase):

    def searchInsert(self, nums: List[int], target: int) -> int:

        if len(nums) == 0:
            return 0

        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid

        if target > nums[left]:
            return left + 1
        else:
            return right

    def test_empty(self):
        self.assertEqual(0, self.searchInsert([], 9))

    def test_middle(self):
        self.assertEqual(2, self.searchInsert([1, 3, 5, 6], 5))
        self.assertEqual(1, self.searchInsert([1, 3, 5, 6], 2))

    def test_duplicates(self):
        self.assertEqual(2, self.searchInsert([1, 3, 5, 5, 5, 6], 5))
        self.assertEqual(0, self.searchInsert([1, 1, 1, 4, 6], 1))
        self.assertEqual(1, self.searchInsert([1, 4, 4, 4, 4], 4))

    def test_tailPos(self):
        self.assertEqual(4, self.searchInsert([1, 3, 5, 6], 7))

    def test_headPos(self):
        self.assertEqual(0, self.searchInsert([1, 3, 5, 6], 0))

if __name__ == '__main__':
    unittest.main()