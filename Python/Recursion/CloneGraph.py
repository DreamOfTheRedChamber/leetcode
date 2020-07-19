# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class CloneGraph(unittest.TestCase):

    def cloneGraph(self, node: 'Node') -> 'Node':

        def cloneGraphRecursion(node: 'Node', clonedNodes: dict) -> 'Node':
            # error case 1
            if node is None:
                return None

            if node.val in clonedNodes:
                return clonedNodes[node.val]

            newNode = Node(node.val)
            clonedNodes[newNode.val] = newNode
            for neighbor in node.neighbors:
                newNode.neighbors.append(cloneGraphRecursion(neighbor, clonedNodes))

            return newNode

        return cloneGraphRecursion(node, {})

    def test_Errorcase(self):
        print(self.cloneGraph(None))

if __name__ == '__main__':
    unittest.main()