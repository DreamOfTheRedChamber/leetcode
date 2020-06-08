# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MaxChunksToMakeSortedII(unittest.TestCase):

    def maxChunksToSorted(self, arr: List[int]) -> int:
        incStack = []

        for value in arr:
            if len(incStack) == 0 or incStack[-1] <= value:
                incStack.append(value)
            else:
                maxStack = incStack.pop()
                while incStack and incStack[-1] > value:
                    incStack.pop()
                incStack.append(maxStack)

        return len(incStack)

    def test_Leetcode(self):
        self.assertEqual(1, self.maxChunksToSorted([5, 4, 3, 2, 1]))
        self.assertEqual(4, self.maxChunksToSorted([2, 1, 3, 4, 4]))

    def test_EdgeCase(self):
        self.assertEqual(3, self.maxChunksToSorted([0, 0, 0]))
        self.assertEqual(0, self.maxChunksToSorted([]))

    def test_WrongCase(self):
        self.assertEqual(2, self.maxChunksToSorted([1, 1, 0, 0, 1]))

    def test_WrongCase2(self):
        self.assertEqual(3, self.maxChunksToSorted([3, 7, 8, 4, 6, 5, 9]))

if __name__ == '__main__':
    unittest.main()