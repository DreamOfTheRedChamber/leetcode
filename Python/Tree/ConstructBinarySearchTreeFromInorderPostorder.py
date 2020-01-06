# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ConstructBinaryTreeFromPreorderInorder(unittest.TestCase):
    def buildTree(self, inorder: list, postorder: list) -> TreeNode:
        inorderMap = {}
        for index, val in enumerate(inorder):
            inorderMap[val] = index

        result = self.buildTreeRecursive(postorder, 0, len(postorder) - 1, inorderMap, 0)
        return result

    def buildTreeRecursive(self, postorder: list, postStart: int, postEnd: int, inorderMap: dict, inStart: int):
        if postStart > postEnd:
            return None
        elif postStart == postEnd:
            return TreeNode(postorder[postStart])
        else:
            indexInorder = inorderMap[postorder[postEnd]]
            numLeftTree = indexInorder - inStart
            rootNode = TreeNode(postorder[postEnd])
            rootNode.left = self.buildTreeRecursive(postorder, postStart, postStart + numLeftTree - 1, inorderMap, inStart)
            rootNode.right = self.buildTreeRecursive(postorder, postStart + numLeftTree, postEnd - 1, inorderMap, indexInorder + 1)
            return rootNode

    def test_NormalTree(self):
        preorder = [3, 9, 20, 15, 7]
        inorder = [9, 3, 15, 20, 7]

        self.buildTree(preorder, inorder)


if __name__ == '__main__':
    unittest.main()