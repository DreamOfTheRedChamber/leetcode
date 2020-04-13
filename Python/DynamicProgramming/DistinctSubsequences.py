# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class DistinctSubsequences(unittest.TestCase):

    def numDistinct(self, s: str, t: str) -> int:
        numWays = [[0 for x in range(len(t) + 1)] for y in range(len(s) + 1)]
        for row in range(len(s) + 1):
            numWays[row][0] = 1

        for row in range(1, len(s) + 1):
            for col in range(1, len(t) + 1):
                if s[row - 1] == t[col - 1]:
                    numWays[row][col] = numWays[row - 1][col - 1] + numWays[row - 1][col]
                else:
                    numWays[row][col] = numWays[row - 1][col]

        return numWays[len(s)][len(t)]

    def test_Leetcode(self):
        self.assertEqual(3, self.numDistinct("rabbbit", "rabbit"))
        self.assertEqual(5, self.numDistinct("babgbag", "bag"))

if __name__ == '__main__':
    unittest.main()