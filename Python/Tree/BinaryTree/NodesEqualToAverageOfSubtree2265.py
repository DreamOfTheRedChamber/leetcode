# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class CountNodesEqualToAverageSubtree(unittest.TestCase):

    def dfs(self, root: TreeNode, result: List[int]) -> (int, int):
        if root is None:
            return (0, 0)

        leftSum, leftNum = self.dfs(root.left, result)
        rightSum, rightNum = self.dfs(root.right, result)
        if (leftSum + rightSum + root.val) // (leftNum + rightNum + 1) == root.val:
            result.append(root.val)

        return (leftSum + rightSum + root.val, leftNum + rightNum + 1)

    def averageOfSubtree(self, root: TreeNode) -> int:
        result = []
        self.dfs(root, result)
        return len(result)

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()