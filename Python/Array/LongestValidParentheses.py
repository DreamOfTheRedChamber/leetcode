# Definition for a binary tree node.
import unittest
from collections import deque


class LongestValidParentheses(unittest.TestCase):

    def longestValidParentheses(self, s: str) -> int:

        if len(s) <= 1:
            return 0

        invalid = set()
        stack = deque()
        for i in range(len(s)):
            if s[i] == ')':
                if len(stack) == 0:
                    invalid.add(i)
                else:
                    stack.pop()
            else:
                stack.append(i)

        invalid |= set(stack)
        longest = 0
        currentCount = 0
        for i in range(len(s)):
            if i in invalid:
                currentCount = 0
            else:
                currentCount += 1
                longest = max(longest, currentCount)

        return longest

    def test_Leetcode(self):
        self.assertEqual(2, self.longestValidParentheses("(()"))
        self.assertEqual(4, self.longestValidParentheses(")()())"))

    def test_SelfEdgeCase(self):
        self.assertEqual(0, self.longestValidParentheses(")"))
        self.assertEqual(4, self.longestValidParentheses(")(()()(()"))

if __name__ == '__main__':
    unittest.main()