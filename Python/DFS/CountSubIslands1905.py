# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class CountSubIslands(unittest.TestCase):

    def dfs(self, xCor: int, yCor: int, visited: List[List[bool]], grid1: List[List[int]], grid2: List[List[int]]):
        visited[xCor][yCor] = True
        height = len(grid2)
        width = len(grid2[0])

        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        for xDir, yDir in dirs:
            xNeigh, yNeigh = xDir + xCor, yDir + yCor
            if 0 <= xNeigh < height and 0 <= yNeigh < width and not visited[xNeigh][yNeigh] and grid2[xNeigh][yNeigh] == 1 and grid1[xNeigh][yNeigh] == 1:
                self.dfs(xNeigh, yNeigh, visited, grid1, grid2)

    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        height = len(grid2)
        width = len(grid2[0])
        visited = [[False for j in range(width)] for i in range(height)]
        numComp = 0
        for i in range(height):
            for j in range(width):
                if not visited[i][j] and grid2[i][j] == 1 and grid1[i][j] == 1:
                    self.dfs(i, j, visited, grid1, grid2)
                    numComp += 1
        return numComp

    def test_example1(self):
        grid1 = [[1, 1, 1, 0, 0], [0, 1, 1, 1, 1], [0, 0, 0, 0, 0], [1, 0, 0, 0, 0], [1, 1, 0, 1, 1]]
        grid2 = [[1, 1, 1, 0, 0], [0, 0, 1, 1, 1], [0, 1, 0, 0, 0], [1, 0, 1, 1, 0], [0, 1, 0, 1, 0]]
        self.assertEqual(3, self.countSubIslands(grid1, grid2))

    def test_example2(self):
        grid1 = [[1, 0, 1, 0, 1], [1, 1, 1, 1, 1], [0, 0, 0, 0, 0], [1, 1, 1, 1, 1], [1, 0, 1, 0, 1]]
        grid2 = [[0, 0, 0, 0, 0], [1, 1, 1, 1, 1], [0, 1, 0, 1, 0], [0, 1, 0, 1, 0], [1, 0, 0, 0, 1]]
        self.assertEqual(2, self.countSubIslands(grid1, grid2))

if __name__ == '__main__':
    unittest.main()