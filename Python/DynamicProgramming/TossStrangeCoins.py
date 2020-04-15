# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class TossStrangeCoins(unittest.TestCase):

    def probabilityOfHeads(self, prob: List[float], target: int) -> float:
        dpLength = len(prob) + 1
        dp = [[0] * dpLength for i in range(dpLength)]

        dp[0][0] = 1
        for i in range(1, dpLength):
            dp[i][0] = dp[i - 1][0] * (1 - prob[i-1])

        for i in range(1, dpLength):
            for j in range(1, i + 1):
                dp[i][j] = dp[i-1][j] * (1 - prob[i-1]) + dp[i-1][j-1] * prob[i-1]

        return dp[dpLength-1][target]

    def test_Leetcode(self):
        self.assertEqual(0.4, self.probabilityOfHeads([0.4], 1))
        self.assertEqual(0.03125, self.probabilityOfHeads([0.5, 0.5, 0.5, 0.5, 0.5], 0))

if __name__ == '__main__':
    unittest.main()