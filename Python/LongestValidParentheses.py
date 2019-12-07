import unittest

class LongestValidParentheses(unittest.TestCase):

import unittest

class LongestSubstringWithoutRepeatingCharacters(unittest.TestCase):

    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        # use 1D DP
        # dp[i] records the longestValidParenthese EXACTLY ENDING at s[i]
        dp = [0 for x in range(len(s))]
        max_to_now = 0
        for i in range(1,len(s)):
            if s[i] == ')':
                # case 1: ()()
                if s[i-1] == '(':
                    # add nearest parentheses pairs + 2
                    dp[i] = dp[i-2] + 2
                # case 2: (()) 
                # i-dp[i-1]-1 is the index of last "(" not paired until this ")"
                elif i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1] == '(':
                    if dp[i-1] > 0: # content within current matching pair is valid 
                    # add nearest parentheses pairs + 2 + parentheses before last "("
                        dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
                    else:
                    # otherwise is 0
                        dp[i] = 0
                max_to_now = max(max_to_now, dp[i])
        return max_to_now

if __name__ == '__main__':
    unittest.main()

    def test_empty(self):
        self.assertEqual(0, self.lengthOfLongestSubstring(""))

    def test_repeatingSingleCharacter(self):
        self.assertEqual(1, self.lengthOfLongestSubstring("bbbbbb"))

    def test_longestAtTheEnd(self):
        self.assertEqual(3, self.lengthOfLongestSubstring("pwwkew"))

    def test_longestAtTheMiddle(self):
        self.assertEqual(3, self.lengthOfLongestSubstring("abcabcbb"))

if __name__ == '__main__':
    unittest.main()