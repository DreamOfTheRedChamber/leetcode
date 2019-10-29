# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class PathSumII(unittest.TestCase):
    def hasPathSum(self, root: TreeNode, sum: int) -> list:
        validPaths = []
        self.hasPathSumRecursive(root, sum, [], validPaths)
        return validPaths

    def hasPathSumRecursive(self, root: TreeNode, sum: int, currentPath: list, validPaths: list):
        if root is None:
            return
        elif root.left is None and root.right is None:
            if root.val == sum:
                currentPath.append(root.val)
                validPaths.append(currentPath.copy())
                currentPath.pop(len(currentPath) - 1)
        else:
            currentPath.append(root.val)
            self.hasPathSumRecursive(root.left, sum - root.val, currentPath, validPaths)
            self.hasPathSumRecursive(root.right, sum - root.val, currentPath, validPaths)
            currentPath.pop(len(currentPath) - 1)

    def test_NormalTree(self):
        node1 = TreeNode(5)
        node2 = TreeNode(4)
        node3 = TreeNode(8)
        node4 = TreeNode(11)
        node5 = TreeNode(13)
        node6 = TreeNode(4)
        node7 = TreeNode(7)
        node8 = TreeNode(2)
        node9 = TreeNode(1)
        node10 = TreeNode(5)
        node1.left = node2
        node1.right = node3
        node2.left = node4
        node3.left = node5
        node3.right = node6
        node4.left = node7
        node4.right = node8
        node6.right = node9
        node6.left = node10
        result = self.hasPathSum(node1, 22)
        print('result')

    def test_SingleNode(self):
        node1 = TreeNode(5)
        result = self.hasPathSum(node1, 5)
        print('result')

if __name__ == '__main__':
    unittest.main()