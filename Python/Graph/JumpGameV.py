# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class JumpGameV(unittest.TestCase):

    def maxJumps(self, arr: List[int], d: int) -> int:
        def buildGraph(arr: List[int], d: int) -> dict:

            graph = defaultdict(lambda: [])
            for index, value in enumerate(arr):
                for i in range(1, d + 1):
                    leftIndex = index - i
                    if leftIndex >= 0 and arr[leftIndex] < arr[index]:
                        graph[index].append(leftIndex)
                    else:
                        break

                for i in range(1, d + 1):
                    rightIndex = index + i
                    if rightIndex < len(arr) and arr[rightIndex] < arr[index]:
                        graph[index].append(rightIndex)
                    else:
                        break

            return graph

        def dfs(start: int, nodeNeighbors: dict, longestPathFromNode: dict) -> int:
            if start in longestPathFromNode:
                return longestPathFromNode[start]

            longestLength = 1
            for neighbor in nodeNeighbors[start]:
                if neighbor in longestPathFromNode:
                    longestLength = max(longestLength, 1 + longestPathFromNode[neighbor])
                else:
                    longestLength = max(longestLength, 1 + dfs(neighbor, nodeNeighbors, longestPathFromNode))

            longestPathFromNode[start] = longestLength
            return longestLength

        nodeNeighbors = buildGraph(arr, d)
        longestPathFromNode = dict()
        result = 0
        for index in range(len(arr)):
            result = max(result, dfs(index, nodeNeighbors, longestPathFromNode))

        return result

    def test_Leetcode(self):
        self.assertEqual(4, self.maxJumps([6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12], 2))
        self.assertEqual(1, self.maxJumps([3, 3, 3, 3, 3], 3))
        self.assertEqual(7, self.maxJumps([7, 6, 5, 4, 3, 2, 1], 1))
        self.assertEqual(2, self.maxJumps([7, 1, 7, 1, 7, 1], 2))
        self.assertEqual(1, self.maxJumps([66], 1))

if __name__ == '__main__':
    unittest.main()