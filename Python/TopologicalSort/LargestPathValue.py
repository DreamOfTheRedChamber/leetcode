# Definition for a binary tree node.
import sys
import unittest
from collections import defaultdict, deque
from typing import List

class LargestColorValue(unittest.TestCase):

    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        inNum = defaultdict(lambda: 0)
        outEdges = defaultdict(lambda: [])
        for edge in edges:
            inNum[edge[1]] += 1
            outEdges[edge[0]].append(edge[1])

        pathValue = [[0 for j in range(26)] for i in range(len(colors))]
        bfsQueue = deque()
        for i in range(len(colors)):
            if i not in inNum:
                bfsQueue.append(i)
                colorIndex = ord(colors[i]) - ord('a')
                pathValue[i][colorIndex] = 1

        visitedNum = 0
        maxValue = 0
        while bfsQueue:
            visitedNum += 1
            head = bfsQueue.pop()
            colorIndex = ord(colors[head]) - ord('a')
            maxValue = max(maxValue, pathValue[head][colorIndex])

            for neighbor in outEdges[head]:
                for j in range(26):
                    diff = ord(colors[neighbor]) - ord('a')
                    if diff == 0:
                        pathValue[neighbor][j] = max(pathValue[head][j] + 1, pathValue[neighbor][j])
                    else:
                        pathValue[neighbor][j] = max(pathValue[head][j], pathValue[neighbor][j])

        return maxValue if visitedNum == len(colors) else -1

    def test_example1(self):
        colors = "abaca"
        edges = [[0, 1], [0, 2], [2, 3], [3, 4]]
        self.assertEqual(3, self.largestPathValue(colors, edges))

    @unittest.skip
    def test_example2(self):
        colors = "a"
        edges = [[0, 0]]
        self.assertEqual(-1, self.largestPathValue(colors, edges))

    @unittest.skip
    def test_example3(self):
        colors = "aabbac"
        edges = [[0, 1], [2, 3], [1, 3], [3, 4], [4, 5]]
        self.assertEqual(3, self.largestPathValue(colors, edges))

if __name__ == '__main__':
    unittest.main()