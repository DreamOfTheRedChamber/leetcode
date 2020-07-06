# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class Combinations(unittest.TestCase):

    def combine(self, n: int, k: int) -> List[List[int]]:
        def dfs(start: int, end: int, targetCount: int, path: List[int], results: List[List[int]]):
            # edge case
            if len(path) == targetCount:
                results.append(path.copy())
                return

            # recursion
            for i in range(start, end+1):
                path.append(i)
                dfs(i+1, end, targetCount, path, results)
                path.pop()

            return

        if k == 0 or k > n:
            return []

        results = []
        dfs(1, n, k, [], results)
        return results

    def test_Leetcode(self):
        print(self.combine(4, 2))

    def test_Edgecase(self):
        print(self.combine(4, 4))
        print(self.combine(4, 5))
        print(self.combine(4, 0))

if __name__ == '__main__':
    unittest.main()