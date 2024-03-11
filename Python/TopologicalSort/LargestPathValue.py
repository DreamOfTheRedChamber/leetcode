# Definition for a binary tree node.
import sys
import unittest
from collections import defaultdict, deque
from typing import List

class LargestColorValue(unittest.TestCase):

    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        inNum = defaultdict(lambda: 0)
        outEdges = defaultdict(set)
        for edge in edges:
            inNum[edge[1]] += 1
            outEdges[edge[0]].add(edge[1])

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

            for neighbor in list(outEdges[head]):
                for j in range(26):
                    diff = ord(colors[neighbor]) - ord('a')
                    if diff == j:
                        pathValue[neighbor][j] = max(pathValue[head][j] + 1, pathValue[neighbor][j])
                    else:
                        pathValue[neighbor][j] = max(pathValue[head][j], pathValue[neighbor][j])

                inNum[neighbor] -= 1
                if inNum[neighbor] == 0:
                    bfsQueue.append(neighbor)

        return maxValue if visitedNum == len(colors) else -1

    def test_example1(self):
        colors = "abaca"
        edges = [[0, 1], [0, 2], [2, 3], [3, 4]]
        self.assertEqual(3, self.largestPathValue(colors, edges))

    def test_example2(self):
        colors = "a"
        edges = [[0, 0]]
        self.assertEqual(-1, self.largestPathValue(colors, edges))

    def test_example3(self):
        colors = "aabbac"
        edges = [[0, 1], [2, 3], [1, 3], [3, 4], [4, 5]]
        self.assertEqual(3, self.largestPathValue(colors, edges))

    def test_example4(self):
        colors = "iiiiii"
        edges = [[0, 1], [1, 2], [2, 3], [3, 4], [4, 5]]
        self.assertEqual(6, self.largestPathValue(colors, edges))

if __name__ == '__main__':
    unittest.main()