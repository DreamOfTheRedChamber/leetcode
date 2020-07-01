# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class CountCompleteTreeNodes(unittest.TestCase):

    def countNodes(self, root: TreeNode) -> int:

        def hasK(target: int) -> bool:
            nodePath = []
            while target > 1:
                nodePath.append(target)
                target = target // 2

            currNode = root
            for i in reversed(nodePath):
                if i % 2 == 0:
                    currNode = currNode.left
                else:
                    currNode = currNode.right

            return False if currNode is None else True

        if not root:
            return 0

        height = 0
        currNode = root
        while currNode:
            height += 1
            currNode = currNode.left

        left = 2 ** (height - 1)
        right = 2 ** height - 1
        while left + 1 < right:
            mid = (right - left) // 2 + left
            if hasK(mid):
                left = mid
            else:
                right = mid

        if hasK(right):
            return right
        else:
            return left

if __name__ == '__main__':
    unittest.main()