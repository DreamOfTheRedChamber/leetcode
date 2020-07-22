# Definition for a binary tree node.
import heapq
import unittest

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MaximumWidthOfBinaryTree(unittest.TestCase):

    def widthOfBinaryTree(self, root: TreeNode) -> int:
        def helper(root: TreeNode, nodeId: int, levelToStartId: dict, level: int, result: List[int]):
            if root is None:
                return

            if level not in levelToStartId:
                levelToStartId[level] = nodeId
                result[0] = 1
            else:
                result[0] = max(result[0], nodeId - levelToStartId[level] + 1)

            helper(root.left, nodeId * 2, levelToStartId, level + 1, result)
            helper(root.right, nodeId * 2 + 1, levelToStartId, level + 1, result)

            return

        result = [0]
        helper(root, 1, dict(), 0, result)
        return result[0]

    def test_Leetcode(self):
        node1 = TreeNode(1)
        node2 = TreeNode(3)
        node3 = TreeNode(2)
        node4 = TreeNode(5)
        node5 = TreeNode(3)
        node6 = TreeNode(9)
        node1.left = node2
        node1.right = node3
        node2.left = node4
        node2.right = node5
        node3.right = node6
        self.assertEqual(4, self.widthOfBinaryTree(node1))

if __name__ == '__main__':
    unittest.main()