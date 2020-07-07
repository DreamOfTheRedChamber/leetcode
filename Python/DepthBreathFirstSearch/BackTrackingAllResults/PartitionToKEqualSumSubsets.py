# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class PartitionToKEqualSumSubsets(unittest.TestCase):

    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        
        return False

    def test_Leetcode(self):
        self.assertTrue(self.canPartitionKSubsets([4, 3, 2, 3, 5, 2, 1], 4))

if __name__ == '__main__':
    unittest.main()