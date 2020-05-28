# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class NumberOfOperationsToMakeNetworkConnected(unittest.TestCase):

    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        def find(a: int) -> int:
            if a != ancestors[a]:
                ancestors[a] = find(ancestors[a])
            return ancestors[a]

        def union(a: int, b: int):
            ancestors[find(a)] = ancestors[find(b)]

        ancestors = [i for i in range(n)]
        numComponents = n
        if len(connections) < n - 1:
            return -1

        for connection in connections:
            aRoot, bRoot = find(connection[0]), find(connection[1])
            if aRoot != bRoot:
                union(aRoot, bRoot)
                numComponents -= 1

        return numComponents - 1

    def test_Leetcode(self):
        self.assertEqual(1, self.makeConnected(4, [[0,1],[0,2],[1,2]]))
        self.assertEqual(2, self.makeConnected(6, [[0,1],[0,2],[0,3],[1,2],[1,3]]))
        self.assertEqual(-1, self.makeConnected(6, [[0,1],[0,2],[0,3],[1,2]]))
        self.assertEqual(0, self.makeConnected(5, [[0,1],[0,2],[3,4],[2,3]]))

if __name__ == '__main__':
    unittest.main()