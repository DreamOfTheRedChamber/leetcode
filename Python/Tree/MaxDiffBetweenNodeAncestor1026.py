# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
      self.val = val
      self.left = left
      self.right = right

class MaxDiffBetweenNodeAncestor(unittest.TestCase):

    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:

        def dfs(self, root: TreeNode, maxV: int, minV: int):
            if root is None:
                return

            diffV = max(abs(maxV - root.val), abs(minV - root.val))
            self.maxDiff = max(self.maxDiff, diffV)
            dfs(root.left, max(root.val, maxV), min(root.val, minV))
            dfs(root.right, max(root.val, maxV), min(root.val, minV))
            return

        if root is None:
            return 0

        self.maxDiff = 0
        dfs(root, root.val, root.val)
        return self.maxDiff

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()