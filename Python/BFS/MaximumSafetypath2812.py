# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class MaximumSafetyPath(unittest.TestCase):

    def calculateSafety(self, grid: List[List[int]]) -> List[List[int]]:
        height = len(grid)
        width = len(grid[0])

        visited = set()
        bfsQueue = deque()
        for i in range(height):
            for j in range(width):
                if grid[i][j] == 1:
                    bfsQueue.append((i, j))
                    visited.add((i, j))

        cellSafety = [[0 for j in range(width)] for i in range(height)]
        depth = 1
        levelSize = len(bfsQueue)
        direcs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        while bfsQueue:
            for i in range(levelSize):
                x, y = bfsQueue.popleft()

                for direc in direcs:
                    neighX = x + direc[0]
                    neighY = y + direc[1]
                    if 0 <= neighX < height and 0 <= neighY < width and (neighX, neighY) not in visited:
                        visited.add((neighX, neighY))
                        cellSafety[neighX][neighY] = depth
                        bfsQueue.append((neighX, neighY))

            levelSize = len(bfsQueue)
            depth += 1

        return cellSafety

    def dfs(self, grid: List[List[int]], cellSafety: List[List[int]], target: int) -> bool:
        height = len(grid)
        width = len(grid[0])
        visited = {(0, 0)}
        bfsQueue = deque([(0, 0)])
        direcs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        while bfsQueue:
            x, y = bfsQueue.popleft()
            if x == height - 1 and y == width - 1:
                return True

            for direc in direcs:
                neighX = x + direc[0]
                neighY = y + direc[1]
                if 0 <= neighX < height and 0 <= neighY < width and (neighX, neighY) not in visited and cellSafety[x][y] >= target:
                    visited.add((neighX, neighY))
                    bfsQueue.append((neighX, neighY))

        return False

    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:

        # calculate the safety for every cell
        cellSafety = self.calculateSafety(grid)

        # binary search safetyness
        height = len(grid)
        width = len(grid[0])
        end = 0
        for i in range(height):
            end = max(end, max(cellSafety[i]))
        start = 0
        while start + 1 < end:
            mid = (end - start) // 2 + start
            if self.dfs(grid, cellSafety, mid):
                start = mid
            else:
                end = mid

        if self.dfs(grid, cellSafety, start):
            return start
        else:
            return end

    def test_example1(self):
        self.assertEqual(0, self.maximumSafenessFactor([[1,0,0],[0,0,0],[0,0,1]]))

    def test_example2(self):
        self.assertEqual(2, self.maximumSafenessFactor([[0,0,1],[0,0,0],[0,0,0]]))

    def test_example3(self):
        self.assertEqual(2, self.maximumSafenessFactor([[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]))

if __name__ == '__main__':
    unittest.main()