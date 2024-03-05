# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class CutOffTreesForGolfEvent(unittest.TestCase):

    def cutOffTree(self, forest: List[List[int]]) -> int:

        def shortestDistance(forest: [List[List[int]]], xStart: int, yStart: int, xEnd: int, yEnd: int):
            if xStart == xEnd and yStart == yEnd:
                return 0

            height = len(forest)
            width = len(forest[0])
            visited = [[False for j in range(width)] for i in range(height)]
            bfsQueue = deque([(xStart, yStart)])
            visited[xStart][yStart] = True
            distance = 1
            while bfsQueue:
                levelSize = len(bfsQueue)
                for i in range(levelSize):
                    xCor, yCor = bfsQueue.popleft()
                    directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
                    for dir in directions:
                        xNext = xCor + dir[0]
                        yNext = yCor + dir[1]
                        if xNext == xEnd and yNext == yEnd:
                            return distance
                        if 0 <= xNext < height and 0 <= yNext < width and forest[xNext][yNext] != 0 and not visited[xNext][yNext]:
                            bfsQueue.append((xNext, yNext))
                            visited[xNext][yNext] = True
                distance += 1

            return -1

        # build priorityQueue
        targetTrees = []
        height = len(forest)
        width = len(forest[0])
        for i in range(height):
            for j in range(width):
                if forest[i][j] != 0 and forest[i][j] != 1:
                    heapq.heappush(targetTrees, (forest[i][j], i, j))

        xStart = 0
        yStart = 0
        totalDistance = 0
        while targetTrees:
            height, xEnd, yEnd = heapq.heappop(targetTrees)
            distance = shortestDistance(forest, xStart, yStart, xEnd, yEnd)
            if distance == -1:
                return -1
            else:
                totalDistance += distance
            xStart = xEnd
            yStart = yEnd

        return totalDistance

    def test_Leetcode(self):
        self.assertEqual(6, self.cutOffTree([[1,2,3],[0,0,4],[7,6,5]]))
        self.assertEqual(-1, self.cutOffTree([[1,2,3],[0,0,0],[7,6,5]]))
        self.assertEqual(6, self.cutOffTree([[2,3,4],[0,0,5],[8,7,6]]))

    def test_Edgecase(self):
        self.assertEqual(11, self.cutOffTree([[1,8,7],[2,0,0],[3,5,6]]))
        # self.assertEqual(-1, self.cutOffTree([[1,8,7],[9,0,0],[3,5,6]]))

if __name__ == '__main__':
    unittest.main()