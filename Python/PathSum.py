# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class PathSum(unittest.TestCase):
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root is None:
            return False
        elif sum == root.val and root.left is None and root.right is None:
            return True
        else:
            return self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)

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
        node1.left = node2
        node1.right = node3
        node2.left = node4
        node3.left = node5
        node3.right = node6
        node4.left = node7
        node4.right = node8
        node6.right = node9

        self.assertTrue(self.hasPathSum(node1, 22))

    def test_SingleNode(self):
        node1 = TreeNode(5)

        self.assertTrue(self.hasPathSum(node1, 5))

if __name__ == '__main__':
    unittest.main()