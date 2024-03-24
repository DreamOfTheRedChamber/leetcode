# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class LongestRepeatingCharacterRep(unittest.TestCase):

    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        result = 0
        freqMap = defaultdict(lambda: 0)
        for right in range(len(s)):
            freqMap[s[right]] += 1
            replNum = right - left - max(freqMap.values())

            while replNum > k:
                freqMap[s[left]] -= 1
                left += 1
                replNum = right - left - max(freqMap.values())

            result = max(result, right - left + 1)

        return result

    def test_example1(self):
        s = "ABAB"
        k = 2
        self.assertEqual(4, self.characterReplacement(s, k))

    def test_example2(self):
        s = "AABABBA"
        k = 1
        self.assertEqual(4, self.characterReplacement(s, k))

if __name__ == '__main__':
    unittest.main()