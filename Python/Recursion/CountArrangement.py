# Definition for a binary tree node.

import unittest

# Non-threadsafe imports
from collections import deque
import heapq

# Threadsafe imports
from typing import List

try:
    # Python2
    import queue
except ImportError:
    # Python3
    import Queue as queue

class CountArrangement(unittest.TestCase):

    def countArrangement(self, N: int) -> int:
        def swap(i: int, j: int, candidates: List[int]):
            temp = candidates[i]
            candidates[i] = candidates[j]
            candidates[j] = temp

        def countRecursion(pos: int, candidates: List[int]) -> int:
            if pos == N:
                return 1

            result = 0
            for i in range(pos, len(candidates)):
                if candidates[i] % (pos + 1) == 0 or (pos + 1) % candidates[i] == 0:
                    swap(i, pos, candidates)
                    result += countRecursion(i + 1, candidates)
                    swap(i, pos, candidates)

            return result

        candidates = [i for i in range(1, N + 1)]
        result = countRecursion(0, candidates)
        return result

    def test_errorCase(self):
        # self.assertEqual(2, self.countArrangement(2))
        # self.assertEqual(1, self.countArrangement(1))
        # self.assertEqual(3, self.countArrangement(3))
        self.assertEqual(8, self.countArrangement(4))
