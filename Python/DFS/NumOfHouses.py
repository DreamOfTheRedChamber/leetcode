# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class UnionFind(object):
    def __init__(self, n: int):
        self.parents = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x):
        while x != self.parents[x]:
            self.parents[x] = self.parents[self.parents[x]]
            x = self.parents[x]
        return self.parents[x]

    def union(self, x, y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            return
        self.parents[x_root] = y_root
        self.size[y_root] += self.size[x_root]
        self.size[x_root] = 0

class NumOfHouses(unittest.TestCase):

    def dfs(self, xStart: int, yStart: int, grid: List[List[int]], visited: List[List[bool]]):
        if grid[xStart][yStart] == 0 or visited[xStart][yStart]:
            return

        visited[xStart][yStart] = True
        numRows = len(grid)
        numCols = len(grid[0])
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        for xDir, yDir in dirs:
            xNeigh = xDir + xStart
            yNeigh = yDir + yStart
            if 0 <= xNeigh < numRows and 0 <= yNeigh < numCols and grid[xNeigh][yNeigh] == 1:
                self.dfs(xNeigh, yNeigh, grid, visited)


    def countHousesDFS(self, grid: List[List[int]]) -> int:
        numRows = len(grid)
        numCols = len(grid[0])
        visited = [[False for j in range(numCols)] for i in range(numRows)]
        numComp = 0
        for i in range(numRows):
            for j in range(numCols):
                if grid[i][j] == 1 and not visited[i][j]:
                    self.dfs(i, j, grid, visited)
                    numComp += 1
        return numComp

    def countHouses(self, grid: List[List[int]]) -> int:
        numRows = len(grid)
        numCols = len(grid[0])
        uf = UnionFind(numRows * numCols)
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        for i in range(numRows):
            for j in range(numCols):
                index = i * numCols + j
                if grid[i][j] != 1:
                    continue

                for xDir, yDir in dirs:
                    xNeigh = i + xDir
                    yNeigh = j + yDir
                    neighIndex = xNeigh * numCols + yNeigh
                    if 0 <= xNeigh < numRows and 0 <= yNeigh < numCols:
                        if grid[xNeigh][yNeigh] != 1:
                            continue
                        uf.union(index, neighIndex)

        numHouses = set()
        for i in range(numRows):
            for j in range(numCols):
                index = i * numRows + j
                if grid[i][j] == 1:
                    root = uf.find(index)
                    print(root)
                    numHouses.add(root)

        return len(numHouses)

    def test_example1(self):
        grid = [[0, 1, 0, 1, 1], [0, 1, 0, 0, 0], [1, 0, 0, 1, 0], [0, 0, 0, 1, 1]]
        self.assertEqual(4, self.countHousesDFS(grid))

if __name__ == '__main__':
    unittest.main()