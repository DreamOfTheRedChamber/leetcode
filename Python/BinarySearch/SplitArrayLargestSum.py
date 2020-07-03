# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class SplitArrayLargestSum(unittest.TestCase):

    def splitArray(self, nums: List[int], m: int) -> int:

        def countNumOfSplit(target: int) -> int:
            currSum = 0
            count = 1
            for num in nums:
                if currSum + num <= target:
                    currSum += num
                else:
                    currSum = num
                    count += 1

            return count

        left = max(nums)
        right = sum(nums)
        while left + 1 < right:
            mid = (right - left) // 2 + left
            if countNumOfSplit(mid) > m:
                left = mid
            else:
                right = mid

        return left if countNumOfSplit(left) <= m else right

    def test_Leetcode(self):
        self.assertEqual(18, self.splitArray([7, 2, 5, 10, 8], 2))

if __name__ == '__main__':
    unittest.main()