# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MinimumCostTreeFromLeafValues(unittest.TestCase):

    def mctFromLeafValues(self, arr: List[int]) -> int:
        prevBiggerValue = {}
        decStack = []
        for i in range(len(arr)):
            while decStack and decStack[-1] < arr[i]:
                decStack.pop()

            if decStack:
                prevBiggerValue[i] = decStack[-1]
            else:
                prevBiggerValue[i] = sys.maxsize

            decStack.append(arr[i])

        decStack = []
        nextBiggerValue = {}
        for i in reversed(range(len(arr))):
            while decStack and decStack[-1] <= arr[i]:
                decStack.pop()

            if decStack:
                nextBiggerValue[i] = decStack[-1]
            else:
                nextBiggerValue[i] = sys.maxsize

            decStack.append(arr[i])

        result = 0
        for i in range(len(arr)):
            if prevBiggerValue[i] == sys.maxsize and nextBiggerValue[i] == sys.maxsize:
                continue
            result += min(prevBiggerValue[i], nextBiggerValue[i]) * arr[i]

        return result

    def test_Leetcode(self):
        self.assertEqual(32, self.mctFromLeafValues([6, 2, 4]))

    @unittest.skip
    def test_Edgecase(self):
        self.assertEqual(18, self.mctFromLeafValues([3, 2, 2, 1]))

if __name__ == '__main__':
    unittest.main()