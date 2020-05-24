# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class LongestConsecutiveSequence(unittest.TestCase):

    def longestConsecutive(self, nums: List[int]) -> int:

        def find(a: int) -> int:
            if a != parents[a]:
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

        if len(nums) == 0:
            return 0

        valueToIndex = dict()
        index = 0
        for value in nums:
            if value not in valueToIndex:
                valueToIndex[value] = index
                index += 1

        parents = [i for i in range(len(valueToIndex))]
        islandSize = [1 for i in range(len(valueToIndex))]
        for value in nums:
            if value + 1 in valueToIndex:
                union(valueToIndex[value + 1], valueToIndex[value])
            if value - 1 in valueToIndex:
                union(valueToIndex[value - 1], valueToIndex[value])

        return max(islandSize[i] for i in range(len(valueToIndex)))

    def test_Leetcode(self):
        self.assertEqual(4, self.longestConsecutive([100, 4, 200, 1, 3, 2]))

    def test_Edgecase(self):
        self.assertEqual(1, self.longestConsecutive([1, 3, 5, 7, 9]))

    def test_ErrorCase1(self):
        # Test against empty array
        self.assertEqual(0, self.longestConsecutive([]))

    def test_ErrorCase2(self):
        self.assertEqual(4, self.longestConsecutive([100, 4, 200, 1, 3, 2, 4]))
        self.assertEqual(1, self.longestConsecutive([0, 0]))
        self.assertEqual(3, self.longestConsecutive([1, 2, 0, 1]))

    def test_ErrorCase3(self):
        self.assertEqual(2, self.longestConsecutive([0, 0, -1]))

if __name__ == '__main__':
    unittest.main()