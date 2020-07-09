# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class MineSweeper(unittest.TestCase):

    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        if board[click[0]][click[1]] == "M":
            board[click[0]][click[1]] = "X"
            return board

        directions = [[0, 1], [1, 0], [-1, 0], [0, -1], [1, 1], [-1, 1], [1, -1], [-1, -1]]

        # build numMine matrix
        height = len(board)
        width = len(board[0])
        numMines = [[0 for j in range(width)] for i in range(height)]
        for i in range(height):
            for j in range(width):
                if board[i][j] == "M":
                    for dir in directions:
                        nextX = i + dir[0]
                        nextY = j + dir[1]
                        if 0 <= nextX < height and 0 <= nextY < width:
                            numMines[nextX][nextY] += 1

        # use bfs to traverse
        visited = [[False for j in range(width)] for i in range(height)]
        bfsQueue = deque([(click[0], click[1])])
        visited[click[0]][click[1]] = True
        while bfsQueue:
            xCor, yCor = bfsQueue.popleft()
            if numMines[xCor][yCor] > 0:
                board[xCor][yCor] = str(numMines[xCor][yCor])
            else:
                board[xCor][yCor] = "B"
                for dir in directions:
                    nextX = xCor + dir[0]
                    nextY = yCor + dir[1]
                    if 0 <= nextX < height and 0 <= nextY < width and not visited[nextX][nextY] and not ("1" <= board[nextX][nextY] <= "9"):
                        bfsQueue.append((nextX, nextY))
                        visited[nextX][nextY] = True

        return board


if __name__ == '__main__':
    unittest.main()