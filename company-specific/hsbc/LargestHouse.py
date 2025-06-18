"""
"""


import bisect
import heapq
import unittest
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList

class LargestHouse(unittest.TestCase):

    def test_Normal(self):
        area = [[1, 0, 0, 0, 0, 1, 0, 0],
                [1, 1, 1, 0, 0, 1, 0, 0],
                [1, 0, 1, 0, 0, 1, 0, 0],
                [1, 1, 1, 0, 0, 1, 0, 0]]
        height = len(area)
        width = len(area[0])
        visited = [[False for j in range(width)] for i in range(height)]
        maxArea = 0
        for i in range(height):
            for j in range(width):
                maxArea = max(maxArea, self.dfs(area, visited, i, j))

        print(maxArea)
        return maxArea

    def dfs(self, area: List[List[int]], visited:List[List[bool]], startX: int, startY: int):
        if startX < 0 or startX >= len(area):
            return 0
        if startY < 0 or startY >= len(area[0]):
            return 0

        if visited[startX][startY]:
            return 0
        if area[startX][startY] == 0:
            return 0

        visited[startX][startY] = True
        result = 1 + self.dfs(area, visited, startX + 1, startY) + self.dfs(area, visited, startX, startY + 1) + self.dfs(area, visited, startX - 1, startY) + self.dfs(area, visited, startX, startY - 1)

        return result

    @unittest.skip
    def test_MultiMatchWithSameDis(self):

        return