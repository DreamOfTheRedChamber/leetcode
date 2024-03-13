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

    def findNodeDepth(self, root: Optional[TreeNode], start: int, depth: int) -> tuple:
        if root is None:
            return (depth, None)
        elif root.val == start:
            return (depth, root)
        else:
            leftDepth, leftNode = self.findNodeDepth(root.left, start, depth + 1)
            rightDepth, rightNode = self.findNodeDepth(root.right, start, depth + 1)
            if leftNode is None and rightNode is None:
                return (max(leftDepth, rightDepth), None)
            else:
                resultNode = leftNode if leftNode is not None else rightNode
                return (max(leftDepth, rightDepth), resultNode)

    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        if root is None:
            return 0

        leftDepth, leftNode = self.findNodeDepth(root.left, start, 0)
        rightDepth, rightNode = self.findNodeDepth(root.right, start, 0)

        if leftNode is None and rightNode is None:
            return 0
        elif root.val == start:
            return max(leftDepth, rightDepth)
        else:
            childNode = leftNode if leftNode is not None else rightNode
            subLeftDepth, subLeftNode = self.findNodeDepth(childNode.left, start, 0)
            subRightDepth, subRightNode = self.findNodeDepth(childNode.right, start, 0)

            result = leftDepth + rightDepth
            if subLeftNode is None and subRightNode is None:
                return result
            else:
                return result + max(subLeftDepth, subRightDepth) + 1

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()