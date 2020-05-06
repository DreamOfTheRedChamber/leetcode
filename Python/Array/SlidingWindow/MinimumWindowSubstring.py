# Definition for a binary tree node.
import collections
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MinimumWindowSubstring(unittest.TestCase):

    def minWindow(self, s: str, t: str) -> str:
        freqMap = collections.Counter(t)
        missing = len(t)
        minLength = float('inf')
        result = ""
        windowStart = 0
        windowEnd = 0

        while windowEnd < len(s):
            if s[windowEnd] in freqMap:
                if freqMap[s[windowEnd]] > 0:
                    missing -= 1
                freqMap[s[windowEnd]] = freqMap[s[windowEnd]] - 1

            while missing == 0 and windowStart <= windowEnd:
                if minLength > windowEnd - windowStart:
                    result = s[windowStart:windowEnd + 1]
                    minLength = min(windowEnd - windowStart + 1, minLength)
                if s[windowStart] in freqMap:
                    if freqMap[s[windowStart]] >= 0:
                        missing += 1
                    freqMap[s[windowStart]] = freqMap[s[windowStart]] + 1
                windowStart += 1

            windowEnd += 1

        return result

    def test_Leetcode(self):
        self.assertEqual("BANC", self.minWindow("ADOBECODEBANC", "ABC"))

    def test_Edgecase(self):
        self.assertEqual("AKKCB", self.minWindow("AAKKCBB", "ACB"))
        self.assertEqual("", self.minWindow("AAKKCBB", "AD"))

    def test_WrongAnswer(self):
        self.assertEqual("cwae", self.minWindow("cabwefgewcwaefgcf", "cae"))

if __name__ == '__main__':
    unittest.main()