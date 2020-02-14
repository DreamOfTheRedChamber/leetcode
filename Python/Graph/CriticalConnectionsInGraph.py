# Definition for a binary tree node.
import unittest
import collections
from collections import defaultdict

# Read about enumerate in python
# https://www.youtube.com/watch?v=aZXi1unBdJA

class CriticalConnectionsInGraph(unittest.TestCase):

    def test_normalGraph(self):
        print(self.criticalConnections(4, [[0, 1], [1, 2], [2, 0], [1, 3]]))

    def test_tree(self):
        print(self.criticalConnections(3, [[0, 1], [1, 2], [2, 3]]))

    def criticalConnections(self, n: int, connections: list) -> list:
        discovered = dict()
        low = dict()
        criticalConnections = []

        graph = defaultdict(list)
        for connection in connections:
            graph[connection[0]].append(connection[1])
            graph[connection[1]].append(connection[0])

        for i in range(n):
            if i not in discovered:
                self.dfs(graph, i, -1, low, discovered, criticalConnections)

        return criticalConnections

    sequence = 0

    def dfs(self, graph: dict, curNode: int, parent: int, low: dict, discovered: dict, criticalConnections: list):
        if curNode in discovered:
            return

        self.sequence += 1
        low[curNode] = self.sequence
        discovered[curNode] = self.sequence

        for neighbor in graph[curNode]:
            if parent == neighbor:
                continue
            elif neighbor not in discovered:
                self.dfs(graph, neighbor, curNode, low, discovered, criticalConnections)

                if low[neighbor] > discovered[curNode]:
                    criticalConnections.append([curNode, neighbor])

                low[curNode] = min(low[curNode], low[neighbor])
            else:
                low[curNode] = min(low[curNode], discovered[neighbor])

    def criticalConnections2(self, n: int, connections: list) -> list:
        g = collections.defaultdict(list)
        for a, b in connections:
            g[a].append(b)
            g[b].append(a)
        low = [0] * n

        def dfs(rank, cur, parent):
            low[cur] = rank
            ans = []
            for child in g[cur]:
                if child == parent: continue
                if low[child] == 0:
                    ans += dfs(rank + 1, child, cur)
                low[cur] = min(low[cur], low[child])

                if low[child] > rank:
                    ans.append([child, cur])
            return ans

        return dfs(1, 0, -1)

if __name__ == '__main__':
    unittest.main()