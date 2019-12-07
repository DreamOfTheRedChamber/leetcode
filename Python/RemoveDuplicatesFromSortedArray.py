# Definition for a binary tree node.
import unittest
from typing import List

class RemoveDuplicatesFromSortedArray(unittest.TestCase):

    def removeDuplicates(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        while fast < len(nums):
            if nums[slow] == nums[fast]:
                fast += 1
            else:
                slow += 1
                nums[slow] = nums[fast]
                fast += 1

        return slow + 1

    def test_ArrayWithDuplicates(self):
        self.assertEqual(self.removeDuplicates([1, 1, 2]), 2)
        self.assertEqual(self.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]), 5)

    def test_OriginalArray(self):
        self.assertEqual(self.removeDuplicates([1, 2, 3]), 3)

if __name__ == '__main__':
    unittest.main()