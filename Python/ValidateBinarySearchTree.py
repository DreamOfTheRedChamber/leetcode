# Definition for a binary tree node.
import unittest

# TODO:
# 1. Understand how polymorphism works in python, needs external libraries
# 2. Try other two methods to solve the problem, done

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ValidateBinarySearchTree(unittest.TestCase):

    def isValidBST(self, root: TreeNode) -> bool:
        return self.isValidBSTWithBound(root, float('-inf'), float('inf'))

    # worst case space O(n), average case space O(logn), time O(n)
    def isValidBSTWithBound(self, node, lower, upper):
        if not node:
            return True

        if node.val >= upper or node.val <= lower:
            return False
        else:
            return self.isValidBSTWithBound(node.left, lower, node.val) and self.isValidBSTWithBound(node.right, node.val, upper)

    # worst case space O(n), average case space O(logn) time O(n)
    def isValidBSTInOrder(self, root: TreeNode) -> bool:
        prev = float('-inf')
        stack = [(root, True)]

        while stack:
            node, isFirstTime = stack.pop()
            if not node:
                continue
            if not isFirstTime:
                if node.val <= prev:
                    return False
                else:
                    prev = node.val
            else:
                stack.append((node.right, True))
                stack.append((node, False))
                stack.append((node.left, True))

        return True

    def test_SingleNodeTest(self):
        node1 = TreeNode(3)
        self.assertEqual(True, self.isValidBSTInOrder(node1))
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

        self.assertEqual(True, self.isValidBSTInOrder(node2))
        self.assertEqual(True, self.isValidBST(node2))

    def test_TreeWithMaximumNode(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)

        node3.left = node1
        node3.right = node4
        node4.left = node2
        node4.right = node5

        self.assertEqual(False, self.isValidBSTInOrder(node3))
        self.assertEqual(False, self.isValidBST(node3))

    def test_SkewedTree(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)

        node1.right = node2
        node2.right = node3
        node3.right = node4
        node4.right = node5

        self.assertEqual(True, self.isValidBSTInOrder(node3))
        self.assertEqual(True, self.isValidBST(node3))

if __name__ == '__main__':
    unittest.main()