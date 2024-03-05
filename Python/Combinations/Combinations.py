# Definition for a binary tree node.
import unittest
from typing import List

"""
77. Combinations
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
"""

class TestCombinations(unittest.TestCase):


    def dfs(self, k: int, visited: List[bool], oneResult: List[int], allResults: List[List[int]]):
        if len(oneResult) > k:
            return
        elif len(oneResult) == k:
            allResults.append(oneResult.copy())
            return

        for i in range(len(oneResult), len(visited)):
            if not visited[i]:
                visited[i] = True
                oneResult.append(i + 1)
                self.dfs(k, visited, oneResult, allResults)
                oneResult.pop()
                visited[i] = False

        return

    def combine(self, n: int, k: int) -> List[List[int]]:
        allResults = []
        self.dfs(k, [False] * n, [], allResults)
        return allResults

    def test_combinations(self):

        abc = self.combine(4, 2)
        print(abc)

if __name__ == '__main__':
    unittest.main()