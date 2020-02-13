# Definition for a binary tree node.
import unittest
from collections import defaultdict

# Read about enumerate in python

class CriticalConnectionsInGraph(unittest.TestCase):

    def test_normalGraph(self):
        print(self.criticalConnections(4, [[0, 1], [1, 2], [2, 0], [1, 3]]))

    def test_tree(self):
        print(self.criticalConnections(3, [[0, 1], [1, 2], [2, 3]]))

    def criticalConnections(self, n: int, connections: list) -> list:
        discovered = dict()
        low = dict()
        parents = defaultdict(lambda: -1)
        criticalConnections = []

        graph = self.buildGraph(connections)

        for i in range(n):
            if i not in discovered:
                self.dfs(graph, i, parents, low, discovered, criticalConnections)

        return criticalConnections

    sequence = 0

    def dfs(self, graph: dict, curNode: int, parents: dict, low: dict, discovered: dict, criticalConnections: list):
        if curNode in discovered:
            return

        self.sequence += 1
        low[curNode] = self.sequence
        discovered[curNode] = self.sequence

        for neighbor in graph[curNode]:
            if neighbor not in discovered:
                parents[neighbor] = curNode
                self.dfs(graph, neighbor, parents, low, discovered, criticalConnections)

                if low[neighbor] > discovered[curNode]:
                    criticalConnections.append([curNode, neighbor])

                low[curNode] = min(low[curNode], low[neighbor])
            elif parents[curNode] != neighbor:
                low[curNode] = min(low[curNode], discovered[neighbor])

    def buildGraph(self, connections: list) -> dict:
        graph = defaultdict(lambda: [])
        for connection in connections:
            graph[connection[0]].append(connection[1])
            graph[connection[1]].append(connection[0])
        return graph

if __name__ == '__main__':
    unittest.main()