# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class RedundantConnectionII(unittest.TestCase):

    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        def find(a: int):
            if a not in ancestors:
                ancestors[a] = a
                groupSize[a] = 1
            if ancestors[a] != a:
                ancestors[a] = find(ancestors[a])
            return ancestors[a]

        def union(a: int, b: int):

            if groupSize[aRoot] < groupSize[bRoot]:
                ancestors[aRoot] = ancestors[bRoot]
                groupSize[bRoot] += groupSize[aRoot]
            else:
                ancestors[bRoot] = ancestors[aRoot]
                groupSize[aRoot] += groupSize[bRoot]

        if len(edges) == 0:
            return []

        ancestors = {}
        groupSize = {}
        nodeToIndegreeEdge = {}
        candidateA, candidateB = [], []
        for edge in edges:
            if edge[1] in nodeToIndegreeEdge:
                candidateA, candidateB = edge, nodeToIndegreeEdge[edge[1]]
            else:
                nodeToIndegreeEdge[edge[1]] = edge

        result = candidateA
        for edge in edges:
            if edge == candidateA:
                continue
            aRoot, bRoot = find(edge[0]), find(edge[1])
            if aRoot != bRoot:
                union(aRoot, bRoot)
            else:
                result = candidateB if candidateB != [] else edge
                break

        return result

    def test_Leetcode(self):
        self.assertEqual([2, 3], self.findRedundantConnection([[1,2], [1,3], [2,3]]))
        self.assertEqual([4, 1], self.findRedundantConnection([[1,2], [2,3], [3,4], [4,1], [1,5]]))

    def test_Edgecase(self):
        # when there is a cycle
        self.assertEqual([3, 5], self.findRedundantConnection([[1, 2], [5, 1], [1, 3], [3, 4], [3, 5]]))

        # any edge could be deleted, depending on the order
        self.assertEqual([5, 2], self.findRedundantConnection([[1, 2], [1, 3], [2, 4], [5, 2], [3, 5], [3, 6]]))
        self.assertEqual([1, 2], self.findRedundantConnection([[5, 2], [1, 3], [2, 4], [1, 2], [3, 5], [3, 6]]))

        # only one edge should be deleted
        self.assertEqual([3, 2], self.findRedundantConnection([[1, 2], [3, 2], [2, 3]]))

        # what if empty array
        self.assertEqual([], self.findRedundantConnection([]))

if __name__ == '__main__':
    unittest.main()