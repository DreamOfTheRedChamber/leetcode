import sys

# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NowCoderTemplate(unittest.TestCase):

    @unittest.skip
    def test_Leetcode(self):
        seq = input()
        winSize = int(input())

# read array matrix
# 5 5
# 0 1 0 0 0
# 0 1 1 1 0
# 0 0 0 0 0
# 0 1 1 1 0
# 0 0 0 1 0

    def test_readMatrix(self):
        [N, M] = map(int, input().strip().split(' '))
        maze = []
        for i in range(N):
            # return a map object, which could be passed to List/Set, etc
            line = map(int, input().strip().split(' '))
            maze.append(list(line))
        for line in maze:
            print(line)

if __name__ == '__main__':
    unittest.main()

