# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BinaryTreeMaximumPathSum(unittest.TestCase):

    def testPassThroughRoot(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node1.left = node2
        node1.right = node3
        self.assertEqual(6, self.maxPathSum(node1))

    def testNotPassThroughRoot(self):
        node1 = TreeNode(-10)
        node2 = TreeNode(9)
        node3 = TreeNode(20)
        node4 = TreeNode(15)
        node5 = TreeNode(7)
        node1.left = node2
        node1.right = node3
        node3.left = node4
        node3.right = node5
        self.assertEqual(42, self.maxPathSum(node1))

    def testNegativeNode(self):
        node1 = TreeNode(-3)
        self.assertEqual(-3, self.maxPathSum(node1))

    def testSecond(self):
        node1 = TreeNode(2)
        node2 = TreeNode(-1)
        node1.left = node2
        self.assertEqual(2, self.maxPathSum(node1))

    def testBinaryTreeMaximumPathSum(self):
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
        node4.left = node7
        node4.right = node8
        node3.left = node5
        node3.right = node6
        node6.right = node9
        self.assertEqual(48, self.maxPathSum(node1))

    def maxPathSum(self, root: TreeNode) -> int:
        globalMax, passThroughRootMax = self.maxPathSumRecursive(root)
        return globalMax

    def maxPathSumRecursive(self, root: TreeNode) -> (int, int):
        if root is None:
            return (float('-inf'), 0)

        if root.left is None and root.right is None:
            return root.val, root.val

        (leftGlobalMax, leftChildRootedMax) = self.maxPathSumRecursive(root.left)
        (rightGlobalMax, rightChildRootedMax) = self.maxPathSumRecursive(root.right)

        passThroughRootMax = root.val + max(max(leftChildRootedMax, 0), max(rightChildRootedMax, 0))
        globalMax = max(root.val + max(leftChildRootedMax, 0) + max(rightChildRootedMax, 0), leftGlobalMax, rightGlobalMax)

        return (globalMax, passThroughRootMax)

if __name__ == '__main__':
    unittest.main()