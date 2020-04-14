# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class PalindromeRemoval(unittest.TestCase):

    def minimumMoves(self, arr: List[int]) -> int:
        dp = [[len(arr) for x in range(len(arr))] for y in range(len(arr))]

        for i in range(len(arr)):
            dp[i][i] = 1
        for i in range(len(arr) - 1):
            dp[i][i + 1] = 1 if arr[i] == arr[i + 1] else 2

        for length in range(3, len(arr) + 1):
            for start in range(0, len(arr) - length + 1):
                end = start + length - 1
                if arr[start] == arr[end]:
                    dp[start][end] = dp[start + 1][end - 1]

                for mid in range(start, end):
                    dp[start][end] = min(dp[start][end], dp[start][mid] + dp[mid + 1][end])

        return dp[0][len(arr) - 1]

    def test_leetcode(self):
        self.assertEqual(2, self.minimumMoves([1, 2]))
        self.assertEqual(3, self.minimumMoves([1, 3, 4, 1, 5]))

if __name__ == '__main__':
    unittest.main()