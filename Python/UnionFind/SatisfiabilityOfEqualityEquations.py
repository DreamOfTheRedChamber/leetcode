# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class SatisfiabilityOfEqualityEquations(unittest.TestCase):

    def equationsPossible(self, equations: List[str]) -> bool:
        def find(a: str) -> str:
            if a not in ancestor:
                ancestor[a] = a
                return a
            if a != ancestor[a]:
                ancestor[a] = find(ancestor[a])
            return ancestor[a]

        def union(a: str, b: str):
            aRoot, bRoot = find(a), find(b)
            if aRoot != bRoot:
                ancestor[aRoot] = ancestor[bRoot]
            return

        ancestor = {}

        for equation in equations:
            if equation[1:3] == "==":
                rootA, rootB = find(equation[0]), find(equation[3])
                if rootA != rootB:
                    union(rootA, rootB)

        for equation in equations:
            if equation[1:3] == "!=":
                rootA, rootB = find(equation[0]), find(equation[3])
                if rootA == rootB:
                    return False

        return True

    def test_Leetcode(self):
        self.assertFalse(self.equationsPossible(["a==b","b!=a"]))
        self.assertTrue(self.equationsPossible(["b==a","a==b"]))
        self.assertTrue(self.equationsPossible(["a==b","b==c","a==c"]))
        self.assertFalse(self.equationsPossible(["a==b","b!=c","c==a"]))
        self.assertTrue(self.equationsPossible(["c==c","b==d","x!=z"]))

    def test_Edgecase(self):
        self.assertTrue(self.equationsPossible([]))

if __name__ == '__main__':
    unittest.main()