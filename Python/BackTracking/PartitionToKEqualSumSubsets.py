# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class PartitionToKEqualSumSubsets(unittest.TestCase):

    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:

        # Optimize with next round index. Within each round, nextIndex could grow mononically
        def dfs(currGroup: int, targetGroup: int, currSum: int, targetSum: int, nums: List[int], visited: List[bool], nextIndex: int) -> bool:


            # Edge case
            if currSum == targetSum:
                currGroup += 1
                if currGroup == targetGroup:
                    return True
                else:
                    return dfs(currGroup, targetGroup, 0, targetSum, nums, visited, 0)

            # Recursion
            for i in range(nextIndex, len(nums)):
                if visited[i]:
                    continue

                if currSum + nums[i] <= targetSum:
                    if i > nextIndex and nums[i] == nums[i-1] and not visited[i-1]:
                        continue

                    visited[i] = True
                    if dfs(currGroup, targetGroup, currSum + nums[i], targetSum, nums, visited, i + 1):
                        return True
                    visited[i] = False

            return False

        if k == 0:
            return False
        if k == 1:
            return True

        sorted(nums, reverse=True)
        totalSum = sum(nums)
        if totalSum % k != 0:
            return False
        else:
            return dfs(0, k, 0, totalSum // k, nums, [False for i in range(len(nums))], 0)

    def test_Leetcode(self):
        self.assertTrue(self.canPartitionKSubsets([4, 3, 2, 3, 5, 2, 1], 4))

    def test_Edgecase(self):
        self.assertTrue(self.canPartitionKSubsets([1, 1, 1], 3))
        self.assertTrue(self.canPartitionKSubsets([1, 2, 3], 0))

if __name__ == '__main__':
    unittest.main()