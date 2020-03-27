# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List


class TreeDiameter(unittest.TestCase):

    def treeDiameter(self, edges: List[List[int]]) -> int:
        def breathFirstSearch(start: int, graph: defaultdict) -> (int, int):
            queue = deque()
            queue.append(start)
            levelSize = 1
            level = 1
            lastNode = start
            visited = set()
            visited.add(start)
            while queue:
                head = queue.popleft()
                lastNode = head
                levelSize -= 1
                for neighbor in graph[head]:
                    if neighbor not in visited:
                        queue.append(neighbor)
                        visited.add(neighbor)

                if levelSize == 0:
                    levelSize = len(queue)
                    level += 1

            return lastNode, level

        graph = defaultdict(list)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        endNode, level = breathFirstSearch(edges[0][0], graph)
        endNode, level = breathFirstSearch(endNode, graph)
        return level - 2

    def test_refactor(self):
        self.assertEqual(2, self.treeDiameter([[0, 1], [0, 2]]))
        self.assertEqual(4, self.treeDiameter([[0, 1], [1, 2], [2, 3], [1, 4], [4, 5]]))

if __name__ == '__main__':
    unittest.main()