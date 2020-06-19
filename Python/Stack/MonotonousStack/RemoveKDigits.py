# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class RemoveKDigits(unittest.TestCase):

    def removeKdigits(self, num: str, k: int) -> str:

        incStack = []
        for i in range(len(num)):
            while incStack and incStack[-1] > num[i] and k > 0:
                incStack.pop()
                k -= 1
            incStack.append(num[i])

        while k > 0 and incStack:
            incStack.pop()
            k -= 1

        result = ""
        while incStack:
            result = incStack.pop() + result

        start = 0
        while start < len(result) and result[start] == "0":
            start += 1

        return "0" if result[start:] == "" else result[start:]

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual("1219", self.removeKdigits("1432219", 3))
        self.assertEqual("200", self.removeKdigits("10200", 1))
        self.assertEqual("0", self.removeKdigits("10", 2))

    def test_WrongAnswer(self):
        self.assertEqual("0", self.removeKdigits("10", 1))

if __name__ == '__main__':
    unittest.main()