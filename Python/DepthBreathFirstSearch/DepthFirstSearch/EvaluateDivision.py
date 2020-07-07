# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List, Tuple

class EvaluateDivision(unittest.TestCase):

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:

        ## TODO: Type hint for dictionary
        def buildGraph(equations: List[List[str]], values: List[float]) -> dict:
            graph = defaultdict(list)
            for i in range(len(equations)):
                nodeA, nodeB = equations[i][0], equations[i][1]
                graph[nodeA].append([nodeB, values[i]])
                graph[nodeB].append([nodeA, 1 / values[i]])
            return graph

        def dfs(graph: dict, start: str, end: str, value: float, visited: set) -> float:
            if start not in graph:
                return -1

            if start == end: ## TODO: python string equal
                return value

            for neighbor in graph[start]:
                node, price = neighbor[0], neighbor[1]
                if node not in visited:
                    visited.add(node)
                    reachable = dfs(graph, node, end, value * price, visited)
                    if reachable != -1:
                        return reachable

            return -1

        graph = buildGraph(equations, values)
        result = []
        for query in queries:
            result.append(dfs(graph, query[0], query[1], 1, set()))
        return result

    def test_Leetcode(self):
        equations = [["a", "b"], ["b", "c"]]
        values = [2.0, 3.0]
        queries = [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]]
        print(self.calcEquation(equations, values, queries))

    def test_Edgecase(self):
        # how to handle 0
        return

if __name__ == '__main__':
    unittest.main()