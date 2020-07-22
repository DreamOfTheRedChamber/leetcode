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

class BalanceABinarySearchTree(unittest.TestCase):

    def balanceBST(self, root: TreeNode) -> TreeNode:

        def inorderTraversal(root: TreeNode, inorderSeq: List[int]):

            if root is None:
                return

            inorderTraversal(root.left, inorderSeq)
            inorderSeq.append(root.val)
            inorderTraversal(root.right, inorderSeq)

            return

        def buildBST(inorderSeq: List[int], start: int, end: int) -> TreeNode:
            if end < start:
                return None

            if start == end:
                return TreeNode(inorderSeq[start])

            mid = (end - start) // 2 + start
            currNode = TreeNode(inorderSeq[mid])
            leftChild = buildBST(inorderSeq, start, mid - 1)
            rightChild = buildBST(inorderSeq, mid + 1, end)
            currNode.left = leftChild
            currNode.right = rightChild

            return currNode

        inorderSeq = []
        inorderTraversal(root, inorderSeq)
        return buildBST(inorderSeq, 0, len(inorderSeq) - 1)

    def test_Leetcode(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node1.right = node2
        node2.right = node3
        node3.right = node4
        self.balanceBST(node1)

if __name__ == '__main__':
    unittest.main()