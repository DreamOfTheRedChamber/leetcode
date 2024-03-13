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


class TimeToBeInfected(unittest.TestCase):

    def findNodeDepth(self, root: Optional[TreeNode], start: int) -> tuple:
        if root is None:
            return (0, None)
        elif root.val == start:
            return (1, root)
        else:
            leftDepth, leftNode = self.findNodeDepth(root.left, start)
            rightDepth, rightNode = self.findNodeDepth(root.right, start)
            resultNode = leftNode if leftNode is not None else rightNode
            return (max(leftDepth, rightDepth) + 1, resultNode)

    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        if root is None:
            return 0

        leftDepth, leftNode = self.findNodeDepth(root.left, start)
        rightDepth, rightNode = self.findNodeDepth(root.right, start)

        result = leftDepth + rightDepth
        if root.val == start:
            return max(leftDepth, rightDepth)
        else:
            childNode = leftNode if leftNode is not None else rightNode
            subLeftDepth, subLeftNode = self.findNodeDepth(childNode.left, start)
            subRightDepth, subRightNode = self.findNodeDepth(childNode.right, start)

            return max(result, max(subLeftDepth, subRightDepth) + 1)

    def test_example1(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)
        node6 = TreeNode(6)
        node9 = TreeNode(9)
        node10 = TreeNode(10)
        node1.left = node5
        node1.right = node3
        node5.right = node4
        node4.left = node9
        node4.right = node2
        node3.left = node10
        node3.right = node6
        self.assertEqual(4, self.amountOfTime(node1, 3))

        print([1])

    def test_example2(self):
        # [1,2,null,3,null,4,null,5]
        # 3
        # expected: 2
        return

    def test_example3(self):
        # [1,2,null,3,null,4,null,5]
        # 2
        # expected: 3
        return


if __name__ == '__main__':
    unittest.main()
