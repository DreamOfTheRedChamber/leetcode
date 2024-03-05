# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class EscapeLargeMaze(unittest.TestCase):

    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:

        def enclosed(limit: int, size: int, blocked: set, source: (int, int), target: (int, int)) -> bool:

            bfsQueue = deque([source])
            visited = {source}
            while bfsQueue:
                xCor, yCor = bfsQueue.popleft()
                for dir in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
                    xNext = xCor + dir[0]
                    yNext = yCor + dir[1]
                    if 0 <= xNext < size and 0 <= yNext < size and (xNext, yNext) not in visited and (xNext, yNext) not in blocked:
                        visited.add((xNext, yNext))
                        bfsQueue.append((xNext, yNext))
                        if (xNext, yNext) == target:
                            return False
                        if len(visited) > limit:
                            return False

            return len(bfsQueue) > 0

        convertedBlocks = set()
        for oneBlock in blocked:
            convertedBlocks.add((oneBlock[0], oneBlock[1]))
        convertedSource = (source[0], source[1])
        convertedTarget = (target[0], target[1])

        if enclosed(19900, 10 ** 6, convertedBlocks, convertedSource, convertedTarget) or enclosed(19900, 10 ** 6, convertedBlocks, convertedTarget, convertedSource):
            return False

        return True

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()