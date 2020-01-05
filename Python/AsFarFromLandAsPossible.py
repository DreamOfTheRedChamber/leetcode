# Definition for a binary tree node.
import unittest
from collections import deque

class AsFarFromLandAsPossible(unittest.TestCase):

    def maxDistance(self, grid: list) -> int:
        bfsQueue = deque()
        discovered = [[False for col in range(len(grid[0]))] for row in range(len(grid))]
        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] == 1:
                    bfsQueue.append((row, col))

        depth = 0
        farestDis = -1
        while len(bfsQueue) > 0:
            levelSize = len(bfsQueue)

            for i in range(levelSize):
                xCor, yCor = bfsQueue.popleft()

                for direction in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    neighborX = xCor + direction[0]
                    neighborY = yCor + direction[1]
                    if 0 <= neighborX < len(grid) and 0 <= neighborY < len(grid[0]) and discovered[neighborX][neighborY] is False and grid[neighborX][neighborY] == 0:
                        discovered[neighborX][neighborY] = True
                        bfsQueue.append((neighborX, neighborY))
                        farestDis = depth + 1
            depth += 1

        return farestDis

    def maxDistanceSolution2(self, grid: list) -> int:
        maxDis = -1

        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] == 0:
                    maxDis = max(maxDis, self.bfs(grid, row, col))

        return maxDis

    def bfsSolution2(self, grid: list, row: int, col: int) -> int:
        bfsQueue = deque()
        bfsQueue.append((row, col))
        discovered = [[False for col in range(len(grid[0]))] for row in range(len(grid))]

        depth = 0
        closestDis = -1
        while len(bfsQueue) > 0:
            levelSize = len(bfsQueue)

            for i in range(levelSize):
                xCor, yCor = bfsQueue.popleft()

                if closestDis == -1 and grid[xCor][yCor] == 1:
                    closestDis = depth
                    return closestDis

                for direction in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    neighborX = xCor + direction[0]
                    neighborY = yCor + direction[1]
                    if 0 <= neighborX < len(grid) and 0 <= neighborY < len(grid[0]) and discovered[neighborX][neighborY] is False:
                        discovered[neighborX][neighborY] = True
                        bfsQueue.append((neighborX, neighborY))

            depth += 1

        return closestDis



    def test_NoWaterOrLand(self):
        self.assertEqual(-1, self.maxDistance([[1, 1, 1]]))
        self.assertEqual(-1, self.maxDistance([[0, 0, 0]]))

    def test_NormalTestCases(self):
        self.assertEqual(2, self.maxDistance([[1, 0, 1], [0, 0, 0], [1, 0, 1]]))
        self.assertEqual(4, self.maxDistance([[1, 0, 0], [0, 0, 0], [0, 0, 0]]))

if __name__ == '__main__':
    unittest.main()