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

class BottomLeftTreeValue(unittest.TestCase):

    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        bfsQueue = deque()
        bfsQueue.append(root)
        levelSize = len(bfsQueue)
        result = -1
        while bfsQueue:
            for i in range(levelSize):
                head = bfsQueue.popleft()
                if i == 0:
                    result = head.val

                if head.left is not None:
                    bfsQueue.append(head.left)
                if head.right is not None:
                    bfsQueue.append(head.right)

            levelSize = len(bfsQueue)

        return result


    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()