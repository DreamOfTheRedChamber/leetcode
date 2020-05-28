# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class SimilarStringGroups(unittest.TestCase):

    def numSimilarGroups(self, A: List[str]) -> int:

        def find(a: int) -> int:
            if ancestors[a] != a:
                ancestors[a] = find(ancestors[a])

            return ancestors[a]

        def union(a: int, b: int):
            rootA, rootB = find(a), find(b)
            if rank[rootA] > rank[rootB]:
                ancestors[rootB] = ancestors[rootA]
            else:
                ancestors[rootA] = ancestors[rootB]
                if rank[rootA] == rank[rootB]:
                    rank[rootB] += 1

        def isConnected(a: str, b: str) -> bool:
            numOfDiff = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    numOfDiff += 1

            return True if numOfDiff == 2 or numOfDiff == 0 else False

        ancestors = [i for i in range(len(A))]
        rank = [0 for i in range(len(A))]
        numGroups = len(A)
        for i in range(len(A)):
            for j in range(i + 1, len(A)):
                if isConnected(A[i], A[j]):
                    rootI, rootJ = find(i), find(j)
                    if rootI != rootJ:
                        union(rootI, rootJ)
                        numGroups -= 1

        return numGroups

    def test_Leetcode(self):
        self.assertEqual(2, self.numSimilarGroups(["tars","rats","arts","star"]))

    def test_Edgecase(self):
        self.assertEqual(1, self.numSimilarGroups(["tars","tars","tars"]))

if __name__ == '__main__':
    unittest.main()