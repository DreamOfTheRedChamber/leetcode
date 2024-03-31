# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class ZigZagTraversal(unittest.TestCase):

    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root is None:
            return result
        bfsQueue = deque()
        bfsQueue.append(root)
        levelSize = len(bfsQueue)
        depth = 0
        while bfsQueue:
            oneLevel = []
            for i in range(levelSize):
                head = bfsQueue.popleft()
                oneLevel.append(head.val)
                if head.left:
                    bfsQueue.append(head.left)
                if head.right:
                    bfsQueue.append(head.right)

            if depth % 2 == 0:
                result.append(oneLevel)
            else:
                result.append(reversed(oneLevel))
            levelSize = len(bfsQueue)
            depth += 1

        return result

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()