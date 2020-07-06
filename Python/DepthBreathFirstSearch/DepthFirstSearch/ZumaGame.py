# Definition for a binary tree node.
import collections
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ZumaGame(unittest.TestCase):

    def findMinStep(self, board: str, hand: str) -> int:

        def removeTriplet(board: str) -> str:
            newboard = board
            board = ""
            while newboard != board:
                board = newboard
                for i in range(len(board)):
                    j = i
                    while j+1 < len(board) and board[j+1] == board[j]:
                        j += 1
                    if j-i+1 >= 3:
                        newboard = board[0:i] + board[j+1:]
                        break
            return newboard

        def dfs(board: str, handMap: dict, result: List[int], currStep: int):
            # edge condition
            if len(board) == 0:
                result[0] = min(result[0], currStep)
                return

            # prune
            if currStep >= result[0]:
                return

            # dfs with backtrack
            for key, value in handMap.items():
                if value == 0:
                    continue

                handMap[key] -= 1

                for i in range(len(board)):
                    if board[i] != key:
                        continue
                    if i > 0 and board[i] == board[i-1]:
                        continue

                    newBoard = removeTriplet(board[0:i] + key + board[i:])
                    dfs(newBoard, handMap, result, currStep + 1)

                handMap[key] += 1

            return

        result = [sys.maxsize]
        dfs(board, collections.Counter(hand), result, 0)
        return -1 if result[0] == sys.maxsize else result[0]

    def test_Leetcode(self):
        self.assertEqual(-1, self.findMinStep("WRRBBW", "RB"))
        self.assertEqual(2, self.findMinStep("WWRRBBWW", "WRBRW"))
        self.assertEqual(2, self.findMinStep("G", "GGGGG"))
        self.assertEqual(3, self.findMinStep("RBYYBBRRB", "YRBGB"))

if __name__ == '__main__':
    unittest.main()