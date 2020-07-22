# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MinTimeToCollectApplesInATree(unittest.TestCase):

    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:

        def helper(start: int, graph: dict, hasApple: List[bool], visited: set) -> int:
            visited.add(start)

            result = 0
            for neighbor in graph[start]:
                if neighbor in visited:
                    continue

                cost = helper(neighbor, graph, hasApple, visited)
                if hasApple[neighbor] or cost > 0:
                    result += cost + 2

            return result

        graph = defaultdict(list)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        return helper(0, graph, hasApple, set())

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()