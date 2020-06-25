# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class KthSmallestNumberInMultiplicationTable(unittest.TestCase):

    def findKthNumber(self, m: int, n: int, k: int) -> int:
        def smallOrEqualTo(k: int) -> int:
            finalCount = 0

            for i in range(1, m + 1):
                finalCount += min(k // i, n)

            return finalCount

        left = 1
        right = m * n
        while left < right:
            mid = (right - left) // 2 + left
            notBiggerThanMid = smallOrEqualTo(mid)
            if notBiggerThanMid < k:
                left = mid + 1
            else:
                right = mid

        return left

    def test_Leetcode(self):
        self.assertEqual(3, self.findKthNumber(3, 3, 5))
        self.assertEqual(6, self.findKthNumber(2, 3, 6))

if __name__ == '__main__':
    unittest.main()