# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ArrayContinuous(unittest.TestCase):

    def minOperations(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return 0

        unique = set(nums)

        replacedNum = len(unique) - 1
        sortedNums = sorted(unique)
        for i in range(len(sortedNums)):
            pos = bisect.bisect_right(sortedNums, sortedNums[i] + len(sortedNums) - 1)
            replacedNum = min(replacedNum, i + len(sortedNums) - pos)

        return len(nums) - len(unique) + replacedNum

    def test_example1(self):
        self.assertEqual(0, self.minOperations([4, 2, 5, 3]))

    def test_example2(self):
        self.assertEqual(1, self.minOperations([3, 5, 6, 1, 2]))

    def test_example3(self):
        self.assertEqual(3, self.minOperations([1, 10, 100, 1000]))

    def test_example4(self):
        self.assertEqual(2, self.minOperations([5, 5, 5]))

    def test_example5(self):
        self.assertEqual(2, self.minOperations([10, 4, 7, 9, 7]))

    def test_example6(self):
        self.assertEqual(0, self.minOperations([10]))

if __name__ == '__main__':
    unittest.main()