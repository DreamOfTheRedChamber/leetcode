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

class BSTIterator:

    def __init__(self, root: TreeNode):
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def next(self) -> int:
        result = self.stack.pop()
        current = result.right
        while current:
            self.stack.append(current)
            current = current.left
        return result.val

    def hasNext(self) -> bool:
        return True if self.stack else False

class BinarySearchTreeIterator(unittest.TestCase):

    def test_Leetcode(self):
        node1 = TreeNode(7)
        node2 = TreeNode(3)
        node3 = TreeNode(15)
        node4 = TreeNode(9)
        node5 = TreeNode(20)
        node1.left = node2
        node1.right = node3
        node3.left = node4
        node3.right = node5
        iterator = BSTIterator(node1)
        self.assertEqual(3, iterator.next())
        self.assertEqual(7, iterator.next())
        self.assertTrue(iterator.hasNext())
        self.assertEqual(9, iterator.next())
        self.assertTrue(iterator.hasNext())


if __name__ == '__main__':
    unittest.main()