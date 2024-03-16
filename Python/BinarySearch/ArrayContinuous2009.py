# Definition for a binary tree node.
import bisect
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ArrayContinuous(unittest.TestCase):

    def minOperations(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0

        unique = set()
        for i in range(len(nums)):
            if nums[i] not in unique:
                unique.add(nums[i])
            else:
                nums[i] = sys.maxsize

        replacedNum = len(nums) - 1
        sortedNums = sorted(nums)
        for i in range(len(sortedNums)):
            if nums[i] != sys.maxsize:
                pos = bisect.bisect_right(sortedNums, sortedNums[i] + len(sortedNums) - 1)
                replacedNum = min(replacedNum, i + len(sortedNums) - pos)

        return replacedNum

    @unittest.skip
    def test_example1(self):
        self.assertEqual(0, self.minOperations([4, 2, 5, 3]))
        self.assertEqual(1, self.minOperations([3, 5, 6, 1, 2]))
        self.assertEqual(3, self.minOperations([1, 10, 100, 1000]))
        self.assertEqual(2, self.minOperations([10, 4, 7, 9, 7]))
        self.assertEqual(0, self.minOperations([10]))

    def test_example2(self):
        self.assertEqual(2, self.minOperations([5, 5, 5]))
        self.assertEqual(6, self.minOperations([8, 10, 16, 18, 10, 10, 16, 13, 13, 16]))

    @unittest.skip
    def test_example3(self):
        # The minimum way is to change 8, 9 to 6, 7.
        # However, if calculating this in two steps (unique and replace), this will not work.
        self.assertEqual(2, self.minOperations([8, 5, 9, 9, 8, 4]))

if __name__ == '__main__':
    unittest.main()