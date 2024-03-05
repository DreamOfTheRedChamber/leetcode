# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class IncreasingSubsequences(unittest.TestCase):

    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        def dfs(nums: List[int], start: int, path: List[int], result: List[List[int]]):
            if len(path) >= 2:
                # TODO: how to clone a list in python
                result.append(path.copy())

            uniqueNum = set()

            # recursion
            for i in range(start, len(nums)):

                if nums[i] in uniqueNum:
                    continue
                if len(path) > 0 and nums[i] < path[-1]:
                    continue

                uniqueNum.add(nums[i])
                path.append(nums[i])
                dfs(nums, i+1, path, result)
                path.pop()

            return

        if len(nums) == 0:
            return []

        result = []
        path = []
        # TODO: max and min integer for python
        dfs(nums, 0, path, result)

        return result

    def test_Leetcode(self):
        print(self.findSubsequences([4, 6, 7, 7]))

    def test_Edgecase(self):
        # whether empty counts
        print(self.findSubsequences([]))

    def test_Edgecase2(self):
        print(self.findSubsequences([7, 7, 7]))

    def test_Edgecase3(self):
        print(self.findSubsequences([4, 5, 6]))

    def test_Edgecase4(self):
        print(self.findSubsequences([7, 7, 4, 7, 7]))

if __name__ == '__main__':
    unittest.main()