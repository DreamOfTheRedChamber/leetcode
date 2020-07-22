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

class PseudoPalindromicPathsInABinaryTree(unittest.TestCase):

    def pseudoPalindromicPaths(self, root: TreeNode) -> int:

        def helper(root: TreeNode, states: int, result: List[int]):
            if root is None:
                return

            states ^= 1 << (root.val - 1)
            if root.left is None and root.right is None:
                if states & (states - 1) == 0:
                    result[0] += 1
                else:
                    return

            helper(root.left, states, result)
            helper(root.right, states, result)

            return

        result = [0]
        helper(root, 0, result)
        return result[0]

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()