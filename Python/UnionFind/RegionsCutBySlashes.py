# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class RegionsCutBySlashes(unittest.TestCase):

    def regionsBySlashes(self, grid: List[str]) -> int:
        def find(a: int) -> int:
            if parents[a] != a:
                parents[a] = find(parents[a])
            return parents[a]

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

        def index(row: int, col: int) -> int:
            return row * (len(grid) + 1) + col

        numPoints = (len(grid) + 1) * (len(grid) + 1)
        parents = [i for i in range(numPoints)]
        islandSize = [1 for i in range(numPoints)]
        numSegments = 1
        for i in range(0, len(grid) + 1):
            union(0, index(i, 0))
            union(0, index(i, len(grid)))
            union(0, index(0, i))
            union(0, index(len(grid), i))

        for i in range(0, len(grid)):
            for j in range(0, len(grid)):
                if grid[i][j] == "/":
                    aRoot = find(index(i, j+1))
                    bRoot = find(index(i+1, j))
                    if aRoot != bRoot:
                        union(aRoot, bRoot)
                    else:
                        numSegments += 1
                elif grid[i][j] == "\\":
                    aRoot = find(index(i, j))
                    bRoot = find(index(i+1, j+1))
                    if aRoot != bRoot:
                        union(aRoot, bRoot)
                    else:
                        numSegments += 1

        return numSegments

    def test_Leetcode(self):
        self.assertEqual(2, self.regionsBySlashes([" /", "/ "]))
        self.assertEqual(1, self.regionsBySlashes([" /", "  "]))
        self.assertEqual(4, self.regionsBySlashes(["\\/", "/\\"]))
        self.assertEqual(5, self.regionsBySlashes(["/\\", "\\/"]))
        self.assertEqual(3, self.regionsBySlashes(["//", "/ "]))

    def test_Edgecase(self):
        self.assertEqual(1, self.regionsBySlashes([" "]))

if __name__ == '__main__':
    unittest.main()