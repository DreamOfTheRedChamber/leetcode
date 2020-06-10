# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class SumOfSubarrayMinimums(unittest.TestCase):

    def sumSubarrayMins(self, A: List[int]) -> int:
        prevSmallerIndex = {}
        incStack = []
        for i in range(len(A)):
            while incStack and A[incStack[-1]] > A[i]:
                incStack.pop()
            prevSmallerIndex[i] = incStack[-1] if incStack else -1
            incStack.append(i)

        incStack = []
        nextSmallerIndex = {}
        for i in reversed(range(len(A))):
            while incStack and A[incStack[-1]] >= A[i]:
                incStack.pop()
            nextSmallerIndex[i] = incStack[-1] if incStack else len(A)
            incStack.append(i)

        result = 0
        for i in range(len(A)):
            result += (i - prevSmallerIndex[i]) * (nextSmallerIndex[i] - i) * A[i]

        return result % (10**9+7)

    def test_Leetcode(self):
        self.assertEqual(17, self.sumSubarrayMins([3, 1, 2, 4]))

    def test_Edgecase(self):
        self.assertEqual(13, self.sumSubarrayMins([3, 1, 1, 2]))

if __name__ == '__main__':
    unittest.main()