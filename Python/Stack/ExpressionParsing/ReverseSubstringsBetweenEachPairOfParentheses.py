# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class ReverseSubstringsBetweenEachPairOfParentheses(unittest.TestCase):

    def reverseParentheses(self, s: str) -> str:
        tokenStack = []
        curr = ""
        i = 0
        while i < len(s):
            if s[i] == "(":
                tokenStack.append(curr)
                curr = ""
                i += 1
            elif s[i].isalpha():
                curr += s[i]
                i += 1
            else:
                curr = curr[::-1]
                curr = tokenStack.pop() + curr
                i += 1

        return curr

    def test_Leetcode(self):
        self.assertEqual("dcba", self.reverseParentheses("(abcd)"))
        self.assertEqual("iloveu", self.reverseParentheses("(u(love)i)"))
        self.assertEqual("leetcode", self.reverseParentheses("(ed(et(oc))el)"))
        self.assertEqual("apmnolkjihgfedcbq", self.reverseParentheses("a(bcdefghijkl(mno)p)q"))

if __name__ == '__main__':
    unittest.main()