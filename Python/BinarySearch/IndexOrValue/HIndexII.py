# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class HIndexII(unittest.TestCase):

    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0

        left = 0
        right = len(citations) - 1

        while left + 1 < right:
            mid = (right - left) // 2 + left
            if citations[mid] >= len(citations) - mid:
                right = mid
            else:
                left = mid

        leftResult = min(citations[left], len(citations) - left) if citations[left] >= len(citations) - left else 0
        rightResult = min(citations[right], len(citations) - right) if citations[right] >= len(citations) - right else 0
        return max(leftResult, rightResult)

    def hIndexByValue(self, citations: List[int]) -> int:

        def countBiggerOrEqual(target: int) -> int:
            leftIndex = bisect.bisect_left(citations, target)
            return len(citations) - leftIndex

        if not citations:
            return 0

        left = 0
        right = min(len(citations), citations[-1])

        while left + 1 < right:
            mid = (right - left) // 2 + left
            numOfBiggerOrEqual = countBiggerOrEqual(mid)
            if numOfBiggerOrEqual >= mid:
                left = mid
            else:
                right = mid

        if countBiggerOrEqual(right) >= right:
            return right
        else:
            return left

    def test_Leetcode(self):
        self.assertEqual(3, self.hIndex([0, 1, 3, 5, 6]))
        self.assertEqual(3, self.hIndex([0, 1, 4, 5, 6]))

    def test_Edgecase(self):
        # self.assertEqual(0, self.hIndex([0, 0, 0, 0]))
        self.assertEqual(4, self.hIndex([7, 7, 7, 7]))

if __name__ == '__main__':
    unittest.main()