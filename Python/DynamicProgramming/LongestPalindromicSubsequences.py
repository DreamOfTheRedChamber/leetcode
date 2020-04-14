# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class LongestPalindromicSubsequences(unittest.TestCase):

    def longestPalindromeSubseq(self, s: str) -> int:
        longestLength = [[0 for x in range(len(s) + 1)] for y in range(len(s) + 1)]

        for length in range(1, len(s) + 1):
            for start in range(1, len(s) + 1 - length + 1):
                end = start + length - 1

                if length == 1:
                    longestLength[start][start] = 1
                elif s[start - 1] == s[end - 1]:
                    longestLength[start][end] = longestLength[start + 1][end - 1] + 2
                else:
                    longestLength[start][end] = max(longestLength[start][end - 1], longestLength[start + 1][end])

        return longestLength[1][len(s)]

    def test_Leetcode(self):
        self.assertEqual(4, self.longestPalindromeSubseq("bbbab"))
        self.assertEqual(2, self.longestPalindromeSubseq("cbbd"))

if __name__ == '__main__':
    unittest.main()