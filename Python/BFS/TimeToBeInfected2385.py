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

class TimeToBeInfected(unittest.TestCase):

    def traverse(self, root: TreeNode, graph: dict):
        if root is None:
            return

        if root.left is not None:
            graph[root.val].append(root.left.val)
            graph[root.left.val].append(root.val)

        if root.right is not None:
            graph[root.val].append(root.right.val)
            graph[root.right.val].append(root.val)

        return

    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        # build graph while traversing tree
        graph = defaultdict(list)
        self.traverse(root, graph)

        # perform bfs on the graph, depth is answer
        bfsQueue = deque()
        bfsQueue.append(start)
        visited = set()
        visited.add(start)

        depth = 0
        levelSize = len(bfsQueue)
        while bfsQueue:
            for i in range(levelSize):
                head = bfsQueue.popleft()
                for neighbor in graph[head]:
                    if neighbor not in visited:
                        visited.add(neighbor)
                        bfsQueue.append(neighbor)
            levelSize = len(bfsQueue)
            if levelSize > 0:
                depth += 1

        return depth

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
