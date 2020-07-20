# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class DecodedStringAtIndex(unittest.TestCase):

    def decodeAtIndex(self, S: str, K: int) -> str:

        count = 0
        i = 0
        curr = ""
        while i < len(S):
            if count == K:
                return S[i-1]
            elif S[i].isalpha():
                curr += S[i]
                i += 1
                count += 1
            elif S[i].isdigit():
                j = i
                while j < len(S) and S[j].isdigit():
                    j += 1
                number = int(S[i:j])
                multiplyLength = i * number
                if multiplyLength > K:
                    return self.decodeAtIndex(S[:i], K % i)
                elif multiplyLength == K:
                    return curr[-1]
                else:
                    curr = curr * number
                    i = j
                    count = multiplyLength

        return ""

    def test_Leetcode(self):
        self.assertEqual("o", self.decodeAtIndex("leet2code3", 10))
        self.assertEqual("h", self.decodeAtIndex("ha22", 5))
        self.assertEqual("a", self.decodeAtIndex("a2345678999999999999999", 1))

    def test_Edgecase(self):
        self.assertEqual("t", self.decodeAtIndex("leet2code3", 8))
        return

if __name__ == '__main__':
    unittest.main()