# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python

class LongestValidParentheses(unittest.TestCase):

    def longestValidParentheses(self, s: str) -> int:
        stack = []

        longest = 0
        for i in range(len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if stack and s[stack[-1]] == "(":
                    stack.pop()
                    length = i - stack[-1] if stack else i + 1
                    longest = max(longest, length)
                else:
                    stack.append(i)

        return longest

    def test_Leetcode(self):
        self.assertEqual(2, self.longestValidParentheses("(()"))
        self.assertEqual(4, self.longestValidParentheses(")()())"))

    def test_Edgecase(self):
        self.assertEqual(4, self.longestValidParentheses("()()"))
        self.assertEqual(0, self.longestValidParentheses(")("))

if __name__ == '__main__':
    unittest.main()