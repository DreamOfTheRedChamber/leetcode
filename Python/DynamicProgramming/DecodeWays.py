# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class DecodeWays(unittest.TestCase):

    def numDecodings(self, s: str) -> int:
        if not s:
            return 0

        dp = [0 for x in range(len(s) + 1)]
        dp[0] = 1
        dp[1] = 1 if 0 < int(s[0]) <= 9 else 0

        for i in range(2, len(s) + 1):
            if s[i-1] != '0':
                dp[i] += dp[i - 1]
            if 10 <= int(s[i-2: i]) <= 26:
                dp[i] += dp[i-2]

        return dp[len(s)]

    def test_Test1(self):
        self.assertEqual(3, self.numDecodings("226"))

if __name__ == '__main__':
    unittest.main()