# Definition for a binary tree node.
import bisect
import unittest
from dataclasses import dataclass
from typing import List

class TestPermutations(unittest.TestCase):

    def dfs(self, nums: List[int], visited: List[bool], oneResult: List[int], allResults: List[List[int]]):
        if len(oneResult) == len(nums):
            allResults.append(oneResult.copy())
            return

        for i in range(len(visited)):
            if not visited[i]:
                visited[i] = True
                oneResult.append(nums[i])
                self.dfs(nums, visited, oneResult, allResults)
                oneResult.pop()
                visited[i] = False

        return

    def permute(self, nums: List[int]) -> List[List[int]]:
        allResults = []
        self.dfs(nums, [False] * len(nums), [], allResults)
        return allResults

    def test_permutations(self):
        result = self.permute([1, 2, 3])
        print(result)

if __name__ == '__main__':
    unittest.main()