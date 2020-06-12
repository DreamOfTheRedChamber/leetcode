# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class LongestWellPerformingInterval(unittest.TestCase):

    def longestWPI(self, hours: List[int]) -> int:
        prefixSum = [0 for i in range(len(hours) + 1)]
        for i in range(1, len(hours) + 1):
            isWell = 1 if hours[i-1] > 8 else -1
            prefixSum[i] = prefixSum[i-1] + isWell

        decStack = [0]
        for i in range(len(prefixSum)):
            if decStack and prefixSum[decStack[-1]] > prefixSum[i]:
                decStack.append(i)

        result = 0
        for i in reversed(range(len(prefixSum))):
            while decStack and prefixSum[i] > prefixSum[decStack[-1]]:
                result = max(result, i - decStack[-1])
                decStack.pop()

        return result

    def test_Leetcode(self):
        self.assertEqual(3, self.longestWPI([9, 9, 6, 0, 6, 6, 9]))

    def test_WrongAnswer(self):
        self.assertEqual(1, self.longestWPI([6, 6, 9]))

if __name__ == '__main__':
    unittest.main()