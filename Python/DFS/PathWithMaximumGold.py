# Definition for a binary tree node.
import unittest
from typing import List

# Read about enumerate in python

class PathWithMaximumGold(unittest.TestCase):

    def getMaximumGold(self, grid: List[List[int]]) -> int:
        maximumGold = 0
        visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]

        for row in range(len(grid)):
            for col in range(len(grid[row])):
                if grid[row][col] != 0:
                    maximumGold = max(maximumGold, self.dfs(row, col, grid, visited))
        return maximumGold

    def dfs(self, row: int, col: int, grid: List[List[int]], visited: List[List[bool]]) -> int:
        visited[row][col] = True

        maxFromCurrent = grid[row][col]
        for nextRow, nextCol in (row, col-1), (row, col+1), (row+1, col), (row-1, col):
            if 0 <= nextRow < len(grid) and 0 <= nextCol < len(grid[nextRow]) and grid[nextRow][nextCol] != 0 and visited[nextRow][nextCol] is False:
                maxFromCurrent = max(maxFromCurrent, self.dfs(nextRow, nextCol, grid, visited) + grid[row][col])

        visited[row][col] = False
        return maxFromCurrent

    def testCase(self):
        self.assertEqual(8, self.getMaximumGold([[8]]))
        self.assertEqual(24, self.getMaximumGold([[8, 7], [9, 0]]))
        self.assertEqual(24, self.getMaximumGold([[0, 6, 0], [5, 8, 7], [0, 9, 0]]))
        self.assertEqual(28, self.getMaximumGold([[1, 0, 7], [2, 0, 6], [3, 4, 5], [0, 3, 0], [9, 0, 20]]))

if __name__ == '__main__':
    unittest.main()