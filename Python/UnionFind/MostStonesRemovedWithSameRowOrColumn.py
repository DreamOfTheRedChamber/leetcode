# Definition for a binary tree node.
import collections
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MostStonesRemovedWithSameRowOrColumn(unittest.TestCase):

    def removeStones(self, stones: List[List[int]]) -> int:

        def union(a: int, b: int):
            aRoot = find(a)
            bRoot = find(b)
            if aRoot != bRoot:
                if islandSize[aRoot] > islandSize[bRoot]:
                    parents[bRoot] = parents[aRoot]
                    islandSize[aRoot] += islandSize[bRoot]
                else:
                    parents[aRoot] = parents[bRoot]
                    islandSize[bRoot] += islandSize[aRoot]

        def find(a: int) -> int:
            if a != parents[a]:
                parents[a] = find(parents[a])
            return parents[a]

        def isConnect(a: int, b: int) -> bool:
            return stones[a][0] == stones[b][0] or stones[a][1] == stones[b][1]

        numStone = len(stones)
        parents = [i for i in range(numStone)]
        islandSize = [1 for i in range(numStone)]
        for i in range(numStone):
            for j in range(i + 1, numStone):
                if isConnect(i, j):
                    union(i, j)

        stoneToSize = collections.Counter([find(x) for x in range(numStone)])
        return numStone - len(stoneToSize)

    def test_Leetcode(self):
        self.assertEqual(5, self.removeStones([[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]))
        self.assertEqual(3, self.removeStones([[0,0],[0,2],[1,1],[2,0],[2,2]]))

        # It is a test against the edge case
        self.assertEqual(0, self.removeStones([[0,0]]))

    def test_Edgecase(self):
        self.assertEqual(0, self.removeStones([[0, 0], [1, 1]]))

if __name__ == '__main__':
    unittest.main()