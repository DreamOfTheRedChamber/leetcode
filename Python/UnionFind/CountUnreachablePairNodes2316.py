# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class UnionFind(object):
    def __init__(self, n: int):
        self.parent = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x: int) -> int:
        if x == self.parent[x]:
            return x
        else:
            return self.find(self.parent[x])

    def union(self, x: int, y: int):
        xRoot = self.find(x)
        yRoot = self.find(y)
        if xRoot == yRoot:
            return
        elif self.size[xRoot] > self.size[yRoot]:
            self.parent[yRoot] = xRoot
            self.size[xRoot] += self.size[yRoot]
        else:
            self.parent[xRoot] = yRoot
            self.size[yRoot] += self.size[xRoot]

    def getSize(self, x):
        root = self.find(x)
        return self.size[root]

class CountUnreachablePairsNodes(unittest.TestCase):

    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        uf = UnionFind(n)
        for begin, end in edges:
            uf.union(begin, end)

        comp = []
        for i in range(n):
            if uf.find(i) == i:
                compSize = uf.getSize(i)
                comp.append(compSize)

        suffixSum = [0 for i in range(len(comp))]
        for i in reversed(range(len(comp))):
            if i == len(comp) - 1:
                suffixSum[i] = comp[i]
            else:
                suffixSum[i] = comp[i] + suffixSum[i + 1]
                
        result = 0
        for i in range(len(comp) - 1):
            result += comp[i] * suffixSum[i + 1]
        return result

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()