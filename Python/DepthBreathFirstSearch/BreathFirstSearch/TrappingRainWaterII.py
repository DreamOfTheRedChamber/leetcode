# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class TrappingRainWaterII(unittest.TestCase):

    def trapRainWater(self, heightMap: List[List[int]]) -> int:

        if len(heightMap) <= 1 or len(heightMap[0]) <= 1:
            return 0

        height = len(heightMap)
        width = len(heightMap[0])

        # initialize
        seaShore = []
        visited = [[False for j in range(width)] for i in range(height)]
        for j in range(width):
            heapq.heappush(seaShore, (heightMap[0][j], 0, j))
            visited[0][j] = True
            heapq.heappush(seaShore, (heightMap[height-1][j], height-1, j))
            visited[height-1][j] = True
        for i in range(height):
            heapq.heappush(seaShore, (heightMap[i][0], i, 0))
            visited[i][0] = True
            heapq.heappush(seaShore, (heightMap[i][width-1], i, width-1))
            visited[i][width-1] = True

        totalWater = 0
        while seaShore:
            minHeight, xStart, yStart = heapq.heappop(seaShore)
            bfsQueue = deque([(xStart, yStart)])
            while bfsQueue:
                xCor, yCor = bfsQueue.popleft()
                for dir in [[-1,0], [0,-1], [0,1], [1,0]]:
                    nextX = xCor + dir[0]
                    nextY = yCor + dir[1]
                    if 0 <= nextX < height and 0 <= nextY < width and not visited[nextX][nextY]:
                        if heightMap[nextX][nextY] < minHeight:
                            totalWater += minHeight - heightMap[nextX][nextY]
                            bfsQueue.append((nextX, nextY))
                        else:
                            heapq.heappush(seaShore, (heightMap[nextX][nextY], nextX, nextY))
                        visited[nextX][nextY] = True

        return totalWater

    def test_Leetcode(self):
        self.assertEqual(4, self.trapRainWater([[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]))

    def test_WrongAnswer(self):
        self.assertEqual(14, self.trapRainWater([[12,13,1,12],[13,4,13,12],[13,8,10,12],[12,13,12,12],[13,13,13,13]]))

if __name__ == '__main__':
    unittest.main()