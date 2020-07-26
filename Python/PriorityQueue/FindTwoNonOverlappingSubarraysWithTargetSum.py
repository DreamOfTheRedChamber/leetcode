# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class FindTwoNonOverlappingSubarraysWithTargetSum(unittest.TestCase):

    def minSumOfLengths(self, arr: List[int], target: int) -> int:
        if len(arr) == 0:
            return -1

        slidingWindowSum = 0
        minLengthEndingBefore = [float('inf') for i in range(len(arr))]
        start = 0
        result = float('inf')
        for end in range(len(arr)):
            slidingWindowSum += arr[end]
            if slidingWindowSum >= target:
                while slidingWindowSum > target:
                    slidingWindowSum -= arr[start]
                    start += 1
                if slidingWindowSum == target:
                    currSubarrayLen = end - start + 1
                    if minLengthEndingBefore != float('inf'):
                        if start - 1 >= 0:
                            result = min(result, currSubarrayLen + minLengthEndingBefore[start-1])
                    minLengthEndingBefore[end] = min(minLengthEndingBefore[end], currSubarrayLen)

            if end >= 1:
                minLengthEndingBefore[end] = min(minLengthEndingBefore[end - 1], minLengthEndingBefore[end])

        return result if result != float('inf') else -1

    def test_Leetcode(self):
        self.assertEqual(2, self.minSumOfLengths([3, 2, 2, 4, 3], 3))
        self.assertEqual(2, self.minSumOfLengths([7, 3, 4, 7], 7))
        self.assertEqual(-1, self.minSumOfLengths([4, 3, 2, 6, 2, 3, 4], 6))
        self.assertEqual(-1, self.minSumOfLengths([5, 5, 4, 4, 5], 3))
        self.assertEqual(3, self.minSumOfLengths([3, 1, 1, 1, 5, 1, 2, 1], 3))

    def test_Wrongcase(self):
        self.assertEqual(-1, self.minSumOfLengths([1, 6, 1], 7))

if __name__ == '__main__':
    unittest.main()