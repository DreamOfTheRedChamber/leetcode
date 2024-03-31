from collections import deque
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class CBTInserter:

    def __init__(self, root: Optional[TreeNode]):
        self.root = root
        bfsQueue = deque()
        bfsQueue.append(root)
        self.size = 0
        while bfsQueue:
            head = bfsQueue.popleft()
            self.size += 1
            if head.left:
                bfsQueue.append(head.left)
            if head.right:
                bfsQueue.append(head.right)

    def insert(self, val: int) -> int:
        currIndex = self.size + 1
        rpath = []
        while currIndex != 1:
            if currIndex % 2 == 1:
                rpath.append('r')
            else:
                rpath.append('l')
            currIndex = currIndex // 2

        path = reversed(rpath)
        parent = None
        curr = self.root
        for index, step in enumerate(path):
            parent = curr
            if index < len(rpath) - 1:
                if step == 'r':
                    curr = curr.right
                else:
                    curr = curr.left
            else:
                newNode = TreeNode(val)
                if step == 'r':
                    curr.right = newNode
                else:
                    curr.left = newNode

        return parent.val

    def get_root(self) -> Optional[TreeNode]:
        return self.root
