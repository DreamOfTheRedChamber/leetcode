# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ConstructBinaryTreeFromPreorderInorder(unittest.TestCase):
    def buildTree(self, preorder: list, inorder: list) -> TreeNode:
        inorderMap = {}
        for index, val in enumerate(inorder):
            inorderMap[val] = index

        result = self.buildTreeRecursive(preorder, 0, len(preorder) - 1, inorderMap, 0)
        return result

    def buildTreeRecursive(self, preorder: list, preStart: int, preEnd: int, inorderMap: dict, inStart: int):
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

    def test_NormalTree(self):
        preorder = [3, 9, 20, 15, 7]
        inorder = [9, 3, 15, 20, 7]

        self.buildTree(preorder, inorder)


if __name__ == '__main__':
    unittest.main()