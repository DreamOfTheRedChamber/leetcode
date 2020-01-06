# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class RecoverBinarySearchTree(unittest.TestCase):

    def isSymmetricTree(self, root: TreeNode) -> bool:
        if root is None:
            return True

        return self.isSymmetricTreeTwoNodes(root.left, root.right)

    def isSymmetricTreeTwoNodes(self, p: TreeNode, q: TreeNode):
        if p is None and q is None:
            return True
        elif p is None and q is not None:
            return False
        elif p is not None and q is None:
            return False
        else:
            return p.val == q.val and self.isSymmetricTreeTwoNodes(p.left, q.right) and self.isSymmetricTreeTwoNodes(p.right, q.left)

    def test_SymmetricTree(self):
        pNode1 = TreeNode(1)
        pNode2 = TreeNode(2)
        pNode3 = TreeNode(2)
        pNode4 = TreeNode(3)
        pNode5 = TreeNode(4)
        pNode6 = TreeNode(4)
        pNode7 = TreeNode(3)

        pNode1.left = pNode2
        pNode1.right = pNode3
        pNode2.left = pNode4
        pNode2.right = pNode5
        pNode3.left = pNode6
        pNode3.right = pNode7

        self.assertTrue(self.isSymmetricTree(pNode1))

    def test_NonSymmetricTree(self):
        pNode1 = TreeNode(1)
        pNode2 = TreeNode(2)
        pNode3 = TreeNode(3)
        pNode4 = TreeNode(4)
        pNode5 = TreeNode(5)

        pNode1.left = pNode2
        pNode1.right = pNode3
        pNode2.right = pNode4
        pNode3.right = pNode5

        self.assertFalse(self.isSymmetricTree(pNode1))

if __name__ == '__main__':
    unittest.main()