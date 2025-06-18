"""
"""

import bisect
import heapq
import unittest
from collections import defaultdict
from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class TreeMaxProduct(unittest.TestCase):

    def test_Normal(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)
        node6 = TreeNode(6)
        node7 = TreeNode(7)

        node1.left = node2
        node1.right = node3

        node2.left = node4
        node2.right = node5

        node3.left = node6
        node3.right = node7

        print(self.calcTreeMaxProduct(node1))

    def calcTreeMaxProduct(self, rootNode: TreeNode) -> (int, int):

        if rootNode is None:
            return 0, 0

        if rootNode.left is None and rootNode.right is None:
            return rootNode.val, rootNode.val

        leftToLeafMax, leftSubtreeMax = 0, 0
        if rootNode.left is not None:
            leftToLeafMax, leftSubtreeMax = self.calcTreeMaxProduct(rootNode.left)

        rightToLeafMax, rightSubtreeMax = 0, 0
        if rootNode.right is not None:
            rightToLeafMax, rightSubtreeMax = self.calcTreeMaxProduct(rootNode.right)

        rootIncludedMax = leftToLeafMax * rightToLeafMax * rootNode.val
        maxInTree = max(rootIncludedMax, leftSubtreeMax, rightSubtreeMax)

        rootIncludeMaxToLeaf = max(leftToLeafMax, rightToLeafMax) * rootNode.val

        return rootIncludeMaxToLeaf, maxInTree