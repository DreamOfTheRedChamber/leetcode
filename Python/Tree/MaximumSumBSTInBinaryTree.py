# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class MaximumSumBstInBinaryTree(unittest.TestCase):

    def maxSumBST2(self, root: TreeNode) -> int:
        # returns {lo, hi, sum, valid}
        def dfs(node):
            if not node: return (1e9, -1e9, 0, True)
            ll, lh, ls, lv = dfs(node.left)
            rl, rh, rs, rv = dfs(node.right)
            v = lv and rv and node.val > lh and node.val < rl
            s = ls + rs + node.val if v else -1
            self.ans = max(self.ans, s)
            return (min(ll, node.val), max(rh, node.val), s, v)

        self.ans = 0
        dfs(root)
        return self.ans

    def maxSumBST(self, root: TreeNode) -> int:
        def helper(node: TreeNode) -> (bool, int, int, int):  # isBST, sum, maxValue, minValue
            if not node:
                return True, 0, -1e9, 1e9

            isBSTLeft, leftSum, leftMaxValue, leftMinValue = helper(node.left)
            isBSTRight, rightSum, rightMaxValue, rightMinValue = helper(node.right)

            isBST = isBSTLeft and isBSTRight and leftMaxValue < root.val < rightMinValue
            sumValue = leftSum + rightSum + node.val if isBST else -1
            maxValue = max(leftMaxValue, rightMaxValue, node.val)
            minValue = min(leftMinValue, rightMinValue, node.val)
            self.ans = max(self.ans, sumValue)
            return isBST, sumValue, maxValue, minValue

        self.ans = 0
        isBST, sumValue, maxValue, minValue = helper(root)
        return self.ans

    def test_Leetcode(self):
        node1 = TreeNode(5)
        node2 = TreeNode(4)
        node3 = TreeNode(8)
        node4 = TreeNode(3)
        node5 = TreeNode(6)
        node6 = TreeNode(3)
        node1.left = node2
        node1.right = node3
        node2.left = node4
        node2.right = None
        node3.left = node5
        node3.right = node6
        self.assertEqual(7, self.maxSumBST(node1))

if __name__ == '__main__':
    unittest.main()