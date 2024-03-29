# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class UnionFind(object):
    def __init__(self, n: int):
        self.uf = [i for i in range(n)]
        self.size = [1] * n

    def find(self, x):
        while x != self.uf[x]:
            self.uf[x] = self.uf[self.uf[x]]
            x = self.uf[x]
        return self.uf[x]

    def union(self, x, y):
        x_root = self.find(x)
        y_root = self.find(y)
        if x_root == y_root:
            return
        elif self.size[x_root] > self.size[y_root]:
            self.uf[y_root] = x_root
            self.size[x_root] += self.size[y_root]
            self.size[y_root] = 0
        else:
            self.uf[x_root] = y_root
            self.size[y_root] += self.size[x_root]
            self.size[x_root] = 0

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

        result = 0
        for i in range(len(comp)):
            for j in range(i + 1, len(comp)):
                result += comp[i] * comp[j]
        return result

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()