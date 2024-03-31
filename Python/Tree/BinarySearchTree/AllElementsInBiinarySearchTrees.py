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

class AllElementsInBinarySearchTrees(unittest.TestCase):

    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        def pushStack(root: TreeNode, stack: List[int]):
            while root is not None:
                stack.append(root)
                root = root.left

        result = []
        stack1, stack2 = [], []
        pushStack(root1, stack1)
        pushStack(root2, stack2)

        while stack1 and stack2:
            if stack1[-1].val <= stack2[-1].val:
                top = stack1.pop()
                result.append(top.val)
                pushStack(top.right, stack1)
            else:
                top = stack2.pop()
                result.append(top.val)
                pushStack(top.right, stack2)

        while stack1:
            top = stack1.pop()
            result.append(top.val)
            pushStack(top.right, stack1)

        while stack2:
            top = stack2.pop()
            result.append(top.val)
            pushStack(top.right, stack2)

        return result

    def test_Leetcode(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(4)
        node2.left = node1
        node2.right = node3

        node4 = TreeNode(0)
        node5 = TreeNode(1)
        node6 = TreeNode(3)
        node5.left = node4
        node5.right = node6

        print(self.getAllElements(node2, node5))


if __name__ == '__main__':
    unittest.main()