# Definition for a binary tree node.
import collections
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class SmallestSubsequence(unittest.TestCase):

    def smallestSubsequence(self, text: str) -> str:
        freqMap = collections.Counter(text)
        visitedChar = set()

        decStack = []
        for char in text:
            if char in visitedChar:
                freqMap[char] -= 1
                continue

            while decStack and decStack[-1] > char and freqMap[decStack[-1]] > 0:
                top = decStack.pop()
                visitedChar.remove(top)

            decStack.append(char)
            visitedChar.add(char)
            freqMap[char] -= 1

        return "".join(decStack)

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual("adbc", self.smallestSubsequence("cdadabcc"))
        self.assertEqual("abcd", self.smallestSubsequence("abcd"))
        self.assertEqual("eacb", self.smallestSubsequence("ecbacba"))
        self.assertEqual("letcod", self.smallestSubsequence("leetcode"))

    def test_WrongAnswer(self):
        self.assertEqual("bca", self.smallestSubsequence("bcbcbcababa"))

if __name__ == '__main__':
    unittest.main()