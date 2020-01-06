# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class SameTree(unittest.TestCase):

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p is None and q is None:
            return True
        elif p is None and q is not None:
            return False
        elif p is not None and q is None:
            return False
        else:
            return p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    def test_SkewedTree(self):
        pNode1 = TreeNode(1)
        pNode2 = TreeNode(3)
        pNode3 = TreeNode(2)
        pNode4 = TreeNode(4)
        pNode1.left = pNode2
        pNode2.left = pNode3
        pNode3.left = pNode4

        qNode1 = TreeNode(1)
        qNode2 = TreeNode(3)
        qNode3 = TreeNode(2)
        qNode4 = TreeNode(4)
        qNode1.right = qNode2
        qNode2.right = qNode3
        qNode3.right = qNode4

        self.assertFalse(self.isSameTree(pNode1, qNode1))

    def test_NormalTree(self):
        pNode1 = TreeNode(1)
        pNode2 = TreeNode(2)
        pNode1.right = pNode2

        qNode1 = TreeNode(1)
        qNode2 = TreeNode(3)
        qNode1.right = qNode2

        self.assertFalse(self.isSameTree(pNode1, qNode1))

if __name__ == '__main__':
    unittest.main()