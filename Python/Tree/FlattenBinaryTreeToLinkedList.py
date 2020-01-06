# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class FlattenBinaryTreeToLinkedList(unittest.TestCase):
    def flatten(self, root: TreeNode) -> None:
        self.flattenRecursive(root)
        print('result')

    def flattenRecursive(self, root: TreeNode) -> (TreeNode, TreeNode):
        if root is None:
            return None, None
        elif root.left is None and root.right is None:
            return root, root
        elif root.left is None and root.right is not None:
            rightListHead, rightListTail = self.flattenRecursive(root.right)
            root.right = rightListHead
            root.left = None
            return root, rightListTail
        elif root.left is not None and root.right is None:
            leftListHead, leftListTail = self.flattenRecursive(root.left)
            root.right = leftListHead
            root.left = None
            return root, leftListTail
        else:
            leftListHead, leftListTail = self.flattenRecursive(root.left)
            rightListHead, rightListTail = self.flattenRecursive(root.right)

            root.left = None
            root.right = leftListHead
            leftListTail.right = rightListHead

            return root, rightListTail

    def test_ErrorTree(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node1.left = node2
        node2.left = node3

        self.flatten(node1)
        print('result')

    def test_NormalTree(self):
        node1 = TreeNode(1)
        node2 = TreeNode(2)
        node3 = TreeNode(3)
        node4 = TreeNode(4)
        node5 = TreeNode(5)
        node6 = TreeNode(6)
        node1.left = node2
        node1.right = node5
        node2.left = node3
        node2.right = node4
        node5.right = node6

        self.flatten(node1)
        print('result')

    def test_SingleNode(self):
        node1 = TreeNode(5)

        self.flatten(node1)
        print('result')

if __name__ == '__main__':
    unittest.main()