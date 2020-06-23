# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class ConstraintSubsequenceSum(unittest.TestCase):

    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:

        return 0

    def test_Leetcode(self):
        self.assertEqual(37, self.constrainedSubsetSum([10,2,-10,5,20], 2))
        self.assertEqual(-1, self.constrainedSubsetSum([-1,-2,-3], 1))
        self.assertEqual(23, self.constrainedSubsetSum([10,-2,-10,-5,20], 2))

if __name__ == '__main__':
    unittest.main()