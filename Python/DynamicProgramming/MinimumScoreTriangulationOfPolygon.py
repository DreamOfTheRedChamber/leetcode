# Definition for a binary tree node.
import math
import unittest

# Read about enumerate in python
from typing import List

class MinScoreTriangulation(unittest.TestCase):

    def minScoreTriangulation(self, A: List[int]) -> int:

        dp = [[0] * len(A) for i in range(len(A))]

        for length in range(2, len(A)):
            for start in range(0, len(A) - length):
                end = start + length

                dp[start][end] = math.inf
                for mid in range(start + 1, end):
                    dp[start][end] = min(dp[start][end], dp[start][mid] + dp[mid][end] + A[start] * A[end] * A[mid])

        return dp[0][-1]

    def test_Test1(self):
        self.assertEqual(6, self.minScoreTriangulation([1, 2, 3]))
        self.assertEqual(144, self.minScoreTriangulation([3, 7, 4, 5]))
        self.assertEqual(13, self.minScoreTriangulation([1, 3, 1, 4, 1, 5]))

if __name__ == '__main__':
    unittest.main()