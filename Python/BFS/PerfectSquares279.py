# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from math import sqrt, floor
from typing import List

class PerfectSquares(unittest.TestCase):

    def numSquares(self, n: int) -> int:
        high = floor(sqrt(n))
        if n == high * high:
            return 1

        bfsQueue = deque()
        bfsQueue.append(n)
        levelSize = 1
        depth = 1

        while bfsQueue:
            for i in range(levelSize):
                head = bfsQueue.popleft()

                for j in range(1, high + 1):
                    residual = head - j * j
                    if residual == 0:
                        return depth
                    elif residual > 0:
                        bfsQueue.append(residual)
                    else:
                        break

            levelSize = len(bfsQueue)
            depth += 1

        return depth

    def test_Leetcode(self):
        self.assertEqual(3, self.numSquares(12))
        self.assertEqual(2, self.numSquares(13))

if __name__ == '__main__':
    unittest.main()