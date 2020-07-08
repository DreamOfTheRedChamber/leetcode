# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class SudokuSolver(unittest.TestCase):

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def isValid(board: List[List[str]], i: int, j: int, value: str) -> bool:
            for row in range(10):
                if board[row][j] == value:
                    return False

            for col in range(10):
                if board[i][col] == value:
                    return False

            rowStart = i // 3 * 3
            colStart = j // 3 * 3
            for i in range(3):
                row = rowStart + i
                for j in range(3):
                    col = colStart + j
                    if board[row][col] == value:
                        return False

            return True

        def dfs(board: List[List[str]], i: int, j: int) -> bool:
            if i == 9:
                return True
            if j == 9:
                return dfs(board, i + 1, 0)
            if board[i][j] != ".":
                return dfs(board, i, j + 1)

            for k in range(1, 10):
                if not isValid(board, i, j, str(k)):
                    continue
                board[i][j] = str(k)
                if dfs(board, i, j + 1):
                    return True

            board[i][j] = "."
            return False

        dfs(board, 0, 0)
        return

if __name__ == '__main__':
    unittest.main()