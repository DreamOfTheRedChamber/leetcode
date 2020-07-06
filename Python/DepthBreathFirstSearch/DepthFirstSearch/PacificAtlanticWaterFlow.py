# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class PacificAtlanticWaterFlow(unittest.TestCase):

    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        def dfs(i: int, j: int, reachable: List[List[int]]):
            reachable[i][j] = True

            directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
            for direction in directions:
                nextX = i + direction[0]
                nextY = j + direction[1]
                if 0 <= nextX < height and 0 <= nextY < width and matrix[nextX][nextY] >= matrix[i][j] and not reachable[nextX][nextY]:
                    dfs(nextX, nextY, matrix)

            return

        if len(matrix) == 0:
            return []

        height = len(matrix)
        width = len(matrix[0])
        atlanticArea = [[False for i in range(width)] for j in range(height)]
        pacificArea = [[False for i in range(width)] for j in range(height)]

        for j in range(width):
            dfs(0, j, pacificArea)

        for i in range(height):
            dfs(i, 0, pacificArea)

        for j in range(width):
            dfs(height-1, j, atlanticArea)

        for j in range(height):
            dfs(j, width-1, atlanticArea)

        result = []
        for i in range(height):
            for j in range(width):
                if atlanticArea[i][j] and pacificArea[i][j]:
                    result.append([i, j])

        return result

    def test_Errorcase(self):
        # empty input
        print(self.pacificAtlantic([]))

if __name__ == '__main__':
    unittest.main()