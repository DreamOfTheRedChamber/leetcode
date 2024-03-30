# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class LargestEvenSum(unittest.TestCase):

    def largestEvenSum(self, nums: List[int], k: int) -> int:
        sortedNums = sorted(nums)
        sumK = sum(sortedNums[len(nums) - k:])
        if sumK % 2 == 0:
            return sumK
        else:
            smallestEven = -1
            smallestOdd = -1
            for i in range(len(nums) - k, len(nums)):
                if sortedNums[i] % 2 == 0 and smallestEven == -1:
                    smallestEven = sortedNums[i]
                if sortedNums[i] % 2 == 1 and smallestOdd == -1:
                    smallestOdd = sortedNums[i]
                if smallestEven != -1 and smallestOdd != -1:
                    break

            biggestOdd = -1
            biggestEven = -1
            for j in reversed(range(len(nums) - k)):
                if sortedNums[j] % 2 == 0 and biggestEven == -1:
                    biggestEven = sortedNums[j]
                if sortedNums[j] % 2 == 1 and biggestOdd == -1:
                    biggestOdd = sortedNums[j]
                if biggestEven != -1 and biggestOdd != -1:
                    break

            replaceOdd = -1
            replaceEven = -1
            if smallestEven != -1 and biggestOdd != -1:
                replaceEven = sumK + biggestOdd - smallestEven
            if smallestOdd != -1 and biggestEven != -1:
                replaceOdd = sumK + biggestEven - smallestOdd
            if replaceOdd != -1 or replaceEven != -1:
                return max(replaceOdd, replaceEven)
            else:
                return -1

    def test_example1(self):
        nums = [4, 1, 5, 3, 1]
        k = 3
        self.assertEqual(12, self.largestEvenSum(nums, k))

    def test_example2(self):
        nums = [4, 6, 2]
        k = 3
        self.assertEqual(12, self.largestEvenSum(nums, k))

    def test_example3(self):
        nums = [1, 3, 5]
        k = 1
        self.assertEqual(-1, self.largestEvenSum(nums, k))

    def test_example4(self):
        nums = [1, 5, 5, 5, 4]
        k = 4
        self.assertEqual(16, self.largestEvenSum(nums, k))

if __name__ == '__main__':
    unittest.main()