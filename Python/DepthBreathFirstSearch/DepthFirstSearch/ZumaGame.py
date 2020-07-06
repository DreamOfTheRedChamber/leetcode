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
            stack = []
            for char in board:
                if not stack:
                    stack.append((char, 1))
                elif stack[-1][1] != char:
                    stack.append((char, 1))
                else:
                    value, freq = stack.pop()
                    if freq == 2:
                        continue
                    else:
                        stack.append((value, freq+1))

            result = ""
            while stack:
                value, freq = stack.pop()
                result += value * freq

            return result[::-1]

        def dfs(board: str, handMap: dict, handMapSize: int, result: List[int], currStep: int):
            # edge condition
            if len(board) == 0:
                result[0] = min(result[0], currStep)
                return

            # prune
            if currStep >= handMapSize or currStep >= result[0]:
                return

            # dfs with backtrack
            for key, value in handMap.items():
                if value == 0:
                    continue
                if 


                handMap[key] -= 1

                for i in range(len(board)):
                    newBoard = removeTriplet(board[0:i] + key + board[i:])
                    dfs(newBoard, handMap, handMapSize, result, currStep + 1)

                handMap[key] += 1

            return

        result = [sys.maxsize]
        dfs(board, collections.Counter(hand), len(hand), result, 0)
        return -1 if result[0] == sys.maxsize else result[0]

    def test_Leetcode(self):
        # self.assertEqual(-1, self.findMinStep("WRRBBW", "RB"))
        self.assertEqual(2, self.findMinStep("WWRRBBWW", "WRBRW"))
        # self.assertEqual(2, self.findMinStep("G", "GGGGG"))
        # self.assertEqual(3, self.findMinStep("RBYYBBRRB", "YRBGB"))

if __name__ == '__main__':
    unittest.main()