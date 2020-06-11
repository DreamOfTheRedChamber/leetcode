# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MaximumWidthRamp(unittest.TestCase):

    def maxWidthRamp(self, A: List[int]) -> int:
        decStack = []
        for i in range(len(A)):
            if not decStack or A[decStack[-1]] > A[i]:
                decStack.append(i)

        result = 0
        for i in reversed(range(len(A))):
            while decStack and A[i] >= A[decStack[-1]]:
                result = max(result, i - decStack[-1])
                decStack.pop()

        return result

    def test_Leetcode(self):
        self.assertEqual(4, self.maxWidthRamp([6,0,8,2,1,5]))
        self.assertEqual(7, self.maxWidthRamp([9,8,1,0,1,9,4,0,4,1]))

    def test_Edgecase(self):
        self.assertEqual(0, self.maxWidthRamp([9, 8, 6, 4, 1]))
        self.assertEqual(0, self.maxWidthRamp([]))

if __name__ == '__main__':
    unittest.main()