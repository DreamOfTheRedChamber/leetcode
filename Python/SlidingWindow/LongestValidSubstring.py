# https://algo.monster/liteproblems/2781

# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class LongestValidSubstring(unittest.TestCase):

    def longestValidSubstringBruteForce(self, word: str, forbidden: List[str]) -> int:
        forbiddenSet = set(forbidden)
        start = 0
        result = 0
        for end in range(0, len(word)):
            for checkedStart in range(max(start, end - 9), end + 1):
                if word[checkedStart:end + 1] in forbiddenSet:
                    start = checkedStart + 1
                    break
            result = max(result, end - start + 1)

        return result

    def test_example1(self):
        word = "cbaaaabc"
        forbidden = ["aaa", "cb"]
        self.assertEqual(4, self.longestValidSubstringBruteForce(word, forbidden))

    def test_example2(self):
        word = "leetcode"
        forbidden = ["de", "le", "e"]
        self.assertEqual(4, self.longestValidSubstringBruteForce(word, forbidden))

if __name__ == '__main__':
    unittest.main()