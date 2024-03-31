# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MinSizeSubarray(unittest.TestCase):

    def minSizeSubarray(self, nums: List[int], target: int) -> int:
        aSum = sum(nums)
        numEntire = target // aSum
        remainder = target % aSum

        if remainder == 0:
            return numEntire * len(nums)

        twoNums = nums * 2
        prefixSum = [0 for i in range(len(twoNums) + 1)]
        for i in range(1, len(twoNums) + 1):
            prefixSum[i] = prefixSum[i-1] + twoNums[i-1]

        result = sys.maxsize
        j = 1
        for i in range(0, len(twoNums)):
            while j < len(twoNums) and prefixSum[j] - prefixSum[i] < remainder:
                j += 1
            if prefixSum[j] - prefixSum[i] == remainder:
                result = min(result, j - i)

        if result != sys.maxsize:
            return numEntire * len(nums) + result
        else:
            return -1

    def test_example1(self):
        nums = [1, 2, 3]
        target = 5
        self.assertEqual(2, self.minSizeSubarray(nums, target))

    def test_example2(self):
        nums = [1, 1, 1, 2, 3]
        target = 4
        self.assertEqual(2, self.minSizeSubarray(nums, target))

    def test_example3(self):
        nums = [2, 4, 6, 8]
        target = 3
        self.assertEqual(-1, self.minSizeSubarray(nums, target))

if __name__ == '__main__':
    unittest.main()