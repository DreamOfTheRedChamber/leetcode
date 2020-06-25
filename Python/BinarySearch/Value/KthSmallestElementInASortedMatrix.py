# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class KthSmallestElementInASortedMatrix(unittest.TestCase):

    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        def countNotBigger(target: int) -> int:
            totalCount = 0

            for i in range(len(matrix)):
                totalCount += bisect.bisect_right(matrix[i], target)

            return totalCount

        left = matrix[0][0]
        right = matrix[-1][-1]
        while left < right:
            mid = (right - left) // 2 + left
            numOfNotBigger = countNotBigger(mid)
            if numOfNotBigger < k:
                left = mid + 1
            else:
                right = mid

        return left

    def test_Leetcode(self):
        self.assertEqual(13, self.kthSmallest([[1, 5, 9], [10, 11, 13], [12, 13, 15]], 8))

if __name__ == '__main__':
    unittest.main()