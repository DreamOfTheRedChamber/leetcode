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

    def find_safeness(self, n, safeness_grid):
        safeness = min(safeness_grid[0][0], safeness_grid[-1][-1])
        h = [(-safeness, 0, 0)]
        visited = {(0, 0)}

        while h:
            current_safeness, i, j = heapq.heappop(h)
            current_safeness *= -1
            if current_safeness < safeness:
                safeness = current_safeness

            for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                x = i + dx
                y = j + dy
                if 0 <= x < n and 0 <= y < n and (x, y) not in visited:
                    if x == y == n - 1:
                        return safeness
                    visited.add((x, y))
                    new_safeness = safeness_grid[x][y]
                    heapq.heappush(h, (-new_safeness, x, y))

    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:

        # calculate the safety for every cell
        cellSafety = self.calculateSafety(grid)

        # binary search safetyness
        height = len(grid)
        width = len(grid[0])
        if grid[0][0] == 1 or grid[height - 1][width - 1] == 1:
            return 0

        return self.find_safeness(height, cellSafety)

    def test_example1(self):
        self.assertEqual(0, self.maximumSafenessFactor([[1,0,0],[0,0,0],[0,0,1]]))

    def test_example2(self):
        self.assertEqual(2, self.maximumSafenessFactor([[0,0,1],[0,0,0],[0,0,0]]))

    def test_example3(self):
        self.assertEqual(2, self.maximumSafenessFactor([[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]))

    def test_example4(self):
        self.assertEqual(0, self.maximumSafenessFactor([[0,1,1],[0,1,1],[0,0,1]]))

    def test_example5(self):
        self.assertEqual(1, self.maximumSafenessFactor([[0,1,1],[0,0,1],[1,0,0]]))

    def test_example6(self):
        self.assertEqual(2, self.maximumSafenessFactor([[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]))


if __name__ == '__main__':
    unittest.main()