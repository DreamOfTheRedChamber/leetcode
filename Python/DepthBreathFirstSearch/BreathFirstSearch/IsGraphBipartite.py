# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class IsGraphBipartite(unittest.TestCase):

    def isBipartite(self, graph: List[List[int]]) -> bool:

        def bfsComponent(start: int, visited: List[int], graph: List[List[int]]) -> bool:
            bfsQueue = deque()
            bfsQueue.append(start)
            visited[start] = 0

            if start >= len(graph):
                return True

            while bfsQueue:
                head = bfsQueue.popleft()
                for neighbor in graph[head]:
                    if visited[neighbor] == -1:
                        visited[neighbor] = 1 - visited[head]
                        bfsQueue.append(neighbor)
                    else:
                        if visited[neighbor] == visited[head]:
                            return False

            return True

        if len(graph) == 0:
            return True

        visited = [-1 for i in range(len(graph))]
        for i in range(len(visited)):
            if visited[i] == -1:
                if not bfsComponent(i, visited, graph):
                    return False

        return True

    def test_Leetcode(self):
        self.assertTrue(self.isBipartite([[1,3], [0,2], [1,3], [0,2]]))
        self.assertFalse(self.isBipartite([[1,2,3], [0,2], [0,1,3], [0,2]]))

    def test_Edgecase(self):
        self.assertTrue(self.isBipartite([]))
        # self.assertTrue(self.isBipartite([[1, 2, 3, 4]]))

if __name__ == '__main__':
    unittest.main()