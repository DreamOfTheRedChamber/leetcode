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

class DeleteNodesAndReturnForests(unittest.TestCase):
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:

        def helper(root: TreeNode, to_delete: set, result: List[int]) -> TreeNode:
            if root is None:
                return None

            root.left = helper(root.left, to_delete, result)
            root.right = helper(root.right, to_delete, result)

            if root.val in to_delete:
                if root.left:
                    result.append(root.left)
                if root.right:
                    result.append(root.right)
                return None
            else:
                return root

        to_deleteSet = set(to_delete)
        result = []
        root = helper(root, to_deleteSet, result)
        if root:
            result.append(root)
        return result

    def test_Leetcode(self):
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
        print(self.delNodes(node1, [3, 5]))

if __name__ == '__main__':
    unittest.main()