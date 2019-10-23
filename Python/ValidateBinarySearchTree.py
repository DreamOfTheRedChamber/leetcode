# Definition for a binary tree node.
import unittest

# TODO:
# 1. Understand how polymorphism works in python
# 2. Try other two methods to solve the problem

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ValidateBinarySearchTree(unittest.TestCase):
    def isValidBST(self, root: TreeNode) -> bool:
        return self.isValidBSTWithBound(root, float('-inf'), float('inf'))

    def isValidBSTWithBound(self, node, lower, upper):
        if not node:
            return True

        if node.val >= upper or node.val <= lower:
            return False
        else:
            return self.isValidBSTWithBound(node.left, lower, node.val) and self.isValidBSTWithBound(node.right, node.val, upper)

    def test_SingleNodeTest(self):
        node1 = TreeNode(3)
        self.assertEqual(True, self.isValidBST(node1))

    def test_NormalTree(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)

        node2.left = node1
        node2.right = node4
        node4.left = node3
        node4.right = node5

        self.assertEqual(True, self.isValidBST(node2))

    


if __name__ == '__main__':
    unittest.main()