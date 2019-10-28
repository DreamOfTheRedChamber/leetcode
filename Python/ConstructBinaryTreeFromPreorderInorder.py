# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ConstructBinaryTreeFromPreorderInorder(unittest.TestCase):

    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode:
        inorderMap = {}
        for index, val in enumerate(inorder):
            inorderMap[val] = index

        return TreeNode(1)

    def buildTreeRecursive(self, preorder: list[int], preStart: int, preEnd: int, inorderMap: dict, inStart: int):
        if preStart > preEnd:
            return None
        elif preStart == preEnd:
            return TreeNode(preorder[preStart])
        else:
            indexInorder = inorderMap[preorder[preStart]]
            numLeftTree = indexInorder - inStart
            rootNode = TreeNode(preorder[preStart])
            rootNode.left = self.buildTreeRecursive(preorder, preStart + 1, preStart + numLeftTree, inorderMap, inStart)
            rootNode.right = self.buildTreeRecursive(preorder, preStart + numLeftTree + 1, preEnd, inorderMap, indexInorder + 1)
            return rootNode

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