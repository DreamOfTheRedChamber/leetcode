# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class PreimageSizeofFactorialZeroesFunction(unittest.TestCase):

    def preimageSizeFZF(self, K: int) -> int:
        def countTrailZeros(k: int) -> int:
            result = 0
            radix = 5
            while k >= radix:
                result += k // radix
                radix *= 5

            return result

        left = 0
        right = 5 * (K + 1)
        while left + 1 < right:
            mid = (right - left) // 2 + left
            midTrailZeroes = countTrailZeros(mid)
            if midTrailZeroes > K:
                right = mid
            elif midTrailZeroes < K:
                left = mid
            else:
                return 5

        if countTrailZeros(left) == K or countTrailZeros(right) == K:
            return 5
        else:
            return 0

    def test_Leetcode(self):
        self.assertEqual(5, self.preimageSizeFZF(0))
        self.assertEqual(0, self.preimageSizeFZF(5))

    @unittest.skip
    def test_WrongAnswer(self):
        self.assertEqual(5, self.preimageSizeFZF(1000000000))

if __name__ == '__main__':
    unittest.main()