# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class PartitionEqualSubsetSum(unittest.TestCase):

    def canPartition(self, nums: List[int]) -> bool:

        def depthFirstSearch(index: int, visited: List[int], currSum: int, targetSum: int) -> bool:
            if currSum > targetSum or index >= len(sortedNums):
                return False

            if currSum == targetSum:
                return True

            for i in range(index, len(sortedNums)):
                if i > 0 and sortedNums[i] == sortedNums[i-1] and not visited[i-1]:
                    continue

                visited[i] = True
                if depthFirstSearch(i+1, visited, currSum+sortedNums[i], targetSum):
                    return True
                visited[i] = False

            return False

        sortedNums = sorted(nums, reverse=True)
        totalSum = sum(sortedNums)
        if totalSum % 2 == 1:
            return False
        else:
            return depthFirstSearch(0, [False for i in range(len(nums))], 0, totalSum // 2)

    def test_Leetcode(self):
        self.assertTrue(self.canPartition([1, 5, 11, 5]))
        self.assertTrue(self.canPartition([2, 6, 6, 10]))

    def test_TimeLimitExceeded(self):
        # Pruning
        self.assertTrue(self.canPartition([1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100]))

if __name__ == '__main__':
    unittest.main()