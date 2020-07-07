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

class AllNodesDistanceKInBinaryTree(unittest.TestCase):

    def distanceK(self, root: TreeNode, target: TreeNode, K: int) -> List[int]:

        def kDistanceChildren(target: TreeNode, k: int, childrens: List[int]):
            if not target or k < 0:
                return

            # base case
            if k == 0:
                childrens.append(target.val)
                return

            # recursion
            kDistanceChildren(target.left, k - 1, childrens)
            kDistanceChildren(target.right, k - 1, childrens)

            return

        def recursion(root: TreeNode, target: TreeNode, K: int, kDistanceNodes: List[int]) -> int:
            if not root:
                return -1

            if root == target:
                children = []
                kDistanceChildren(root, K, children)
                kDistanceNodes.extend(children)
                return 0
            else:
                leftDepth = recursion(root.left, target, K, kDistanceNodes)
                if leftDepth != -1:
                    if leftDepth >= K:
                        return K+1
                    elif leftDepth == K-1:
                        kDistanceNodes.append(root.val)
                        return K
                    else:
                        disToRightChild = K - leftDepth - 2
                        children = []
                        kDistanceChildren(root.right, disToRightChild, children)
                        kDistanceNodes.extend(children)
                        return leftDepth + 1

                rightDepth = recursion(root.right, target, K, kDistanceNodes)
                if rightDepth != -1:
                    if rightDepth >= K:
                        return K+1
                    elif rightDepth == K-1:
                        kDistanceNodes.append(root.val)
                        return K
                    else:
                        disToLeftChild = K - rightDepth - 2
                        children = []
                        kDistanceChildren(root.left, disToLeftChild, children)
                        kDistanceNodes.extend(children)
                        return  rightDepth + 1

            return -1

        results = []
        recursion(root, target, K, results)
        return results

    def distanceK2(self, root: TreeNode, target: TreeNode, K: int) -> List[int]:

        def findPath(target: TreeNode, currNode: TreeNode, currPath: List[TreeNode], resultPath: List[TreeNode]):

            if not currNode:
                return

            currPath.append(currNode)

            if currNode.val == target.val:
                for node in currPath:
                    resultPath.append(node)
                return

            findPath(target, currNode.left, currPath, resultPath)
            findPath(target, currNode.right, currPath, resultPath)

            currPath.pop()

        def kDistanceChildren(target: TreeNode, k: int, childrens: List[int]):
            if not target or k < 0:
                return

            # base case
            if k == 0:
                childrens.append(target.val)
                return

            # recursion
            kDistanceChildren(target.left, k - 1, childrens)
            kDistanceChildren(target.right, k - 1, childrens)

            return

        pathToTarget = []
        findPath(target, root, [], pathToTarget)
        result = []
        for i in range(len(pathToTarget)):
            distanceToTarget = len(pathToTarget) - i - 1
            if distanceToTarget == K:
                result.append(pathToTarget[i].val)
            elif distanceToTarget == 0:
                childrens = []
                kDistanceChildren(pathToTarget[i], K, childrens)
                result.extend(childrens)
            else:
                childrens = []
                if pathToTarget[i+1] == pathToTarget[i].right:
                    kDistanceChildren(pathToTarget[i].left, K - distanceToTarget - 1, childrens)
                else:
                    kDistanceChildren(pathToTarget[i].right, K - distanceToTarget - 1, childrens)
                result.extend(childrens)

        return result

    def test_Leetcode(self):
        node0 = TreeNode(0)
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)
        node6 = TreeNode(6)
        node7 = TreeNode(7)
        node8 = TreeNode(8)

        node3.left = node5
        node3.right = node1
        node5.left = node6
        node5.right = node2
        node2.left = node7
        node2.right = node4
        node1.left = node0
        node1.right = node8

        print(self.distanceK(node3, node5, 2)) # 1, 7, 4
        print(self.distanceK(node3, node7, 3)) # 3, 6
        print(self.distanceK(node3, node6, 4)) # 0, 8
        print(self.distanceK(node3, node6, 5)) # []

        # edge case 1: root is target node
        # edge case 2: 0 distance

if __name__ == '__main__':
    unittest.main()