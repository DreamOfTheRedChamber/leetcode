# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class DecodeString(unittest.TestCase):

    def decodeString(self, s: str) -> str:
        tokenStack = []
        numStack = []

        i = 0
        curr = ""
        while i < len(s):
            if s[i].isnumeric():
                end = i + 1
                while end < len(s) and s[end].isnumeric():
                    end += 1
                numStack.append(s[i:end])
                tokenStack.append(curr)
                curr = ""
                i = end
            elif s[i].isalpha():
                curr += s[i]
                i += 1
            elif s[i] == "]":
                number = numStack.pop()
                curr = int(number) * curr
                curr = tokenStack.pop() + curr
                i += 1
            else:
                i += 1

        return curr

    def test_Leetcode(self):
        self.assertEqual("aaabcbc", self.decodeString("3[a]2[bc]"))
        self.assertEqual("accaccacc", self.decodeString("3[a2[c]]"))
        self.assertEqual("abcabccdcdcdef", self.decodeString("2[abc]3[cd]ef"))
        self.assertEqual("abccdcdcdxyz", self.decodeString("abc3[cd]xyz"))
        self.assertEqual("abcd", self.decodeString("abcd"))

if __name__ == '__main__':
    unittest.main()