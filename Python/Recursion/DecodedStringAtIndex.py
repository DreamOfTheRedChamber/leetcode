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
        while i < len(S):
            if S[i].isalpha():
                count += 1
                if count == K:
                    return S[i]
                i += 1
            else: # S[i].isdigit():
                number = int(S[i])
                if count * number < K:
                    i += 1
                    count = count * number
                elif K % count == 0:
                    return self.decodeAtIndex(S[:i], count)
                else: # if K % multiplyLength == 0:
                    return self.decodeAtIndex(S[:i], K % count)

        return ""

    def test_Leetcode(self):
        self.assertEqual("o", self.decodeAtIndex("leet2code3", 10))
        self.assertEqual("h", self.decodeAtIndex("ha22", 5))
        self.assertEqual("a", self.decodeAtIndex("a2345678999999999999999", 1))

    def test_Edgecase(self):
        self.assertEqual("t", self.decodeAtIndex("leet2code3", 8))
        return

    def test_WrongAnswer(self):
        self.assertEqual("c", self.decodeAtIndex("abc", 3))

    def test_WrongAnswer2(self):
        self.assertEqual("c", self.decodeAtIndex("a2b3c4d5", 40))

    def test_WrongAnswer3(self):
        self.assertEqual("x", self.decodeAtIndex("ixm5xmgo78", 711))

    def test_WrongAnswer4(self):
        self.assertEqual("z", self.decodeAtIndex("vzpp636m2y", 2920))

    @unittest.skip
    def test_Leetcode5(self):
        self.assertEqual("a", self.decodeAtIndex("abcde2", 6))
        self.assertEqual("b", self.decodeAtIndex("abcde2", 7))
        self.assertEqual("c", self.decodeAtIndex("abcde2", 8))
        self.assertEqual("d", self.decodeAtIndex("abcde2", 9))
        self.assertEqual("e", self.decodeAtIndex("abcde2", 10))

if __name__ == '__main__':
    unittest.main()