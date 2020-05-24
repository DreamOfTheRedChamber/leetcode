# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class SurroundedRegions(unittest.TestCase):

    def solve(self, board: List[List[str]]) -> None:

        def find(a: int) -> int:
            if a != parents[a]:
                parents[a] = find(parents[a])
            return parents[a]

        def union(a: int, b: int):
            aRoot = find(a)
            bRoot = find(b)

            if aRoot != bRoot:
                if islandSize[aRoot] > islandSize[bRoot]:
                    parents[bRoot] = parents[aRoot]
                    islandSize[aRoot] += islandSize[bRoot]
                else:
                    parents[aRoot] = parents[bRoot]
                    islandSize[bRoot] += islandSize[aRoot]

        if len(board) == 0 or len(board[0]) == 0:
            return

        rowSize = len(board)
        colSize = len(board[0])
        dummyIndex = rowSize * colSize
        parents = [i for i in range(rowSize * colSize + 1)]
        islandSize = [1 for i in range(rowSize * colSize + 1)]

        directions = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        for i in range(0, rowSize):
            for j in range(0, colSize):
                if board[i][j] == 'O':
                    if i == 0 or i == rowSize - 1 or j == 0 or j == colSize - 1:
                        union(i * colSize + j, dummyIndex)
                    for direction in directions:
                        neighborX = i + direction[0]
                        neighborY = j + direction[1]
                        if neighborX >= 0 and neighborX < rowSize and neighborY >= 0 and neighborY < colSize and board[neighborX][neighborY] == 'O':
                            union(i * colSize + j, neighborX * colSize + neighborY)

        dummyIndexRoot = find(dummyIndex)
        for i in range(0, rowSize):
            for j in range(0, colSize):
                if board[i][j] == 'O' and find(i * colSize + j) != dummyIndexRoot:
                    board[i][j] = 'X'

        return board

    def test_Leetcode(self):
        xoArray = [['X', 'X', 'X', 'X'], ['X', 'O', 'O', 'X'], ['X', 'X', 'O', 'X'], ['X', 'O', 'X', 'X']]
        print(self.solve(xoArray))

    def test_Errorcase(self):
        print(self.solve([['O', 'O'], ['O', 'O']]))
        print(self.solve([]))


if __name__ == '__main__':
    unittest.main()