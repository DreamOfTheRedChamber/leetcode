# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class ValidateBinaryTreeNodes(unittest.TestCase):

    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:

        def dfs(start: int, discovered: set, leftChild: List[int], rightChild: List[int]) -> (bool, int):
            if start in discovered:
                return False, 0
            if start == -1:
                return True, 0

            discovered.add(start)
            leftChildValid, leftChildCount = dfs(leftChild[start], discovered, leftChild, rightChild)
            rightChildValid, rightChildCount = dfs(rightChild[start], discovered, leftChild, rightChild)

            return leftChildValid and rightChildValid, leftChildCount + rightChildCount + 1

        rootCandidates = set(range(n))
        for i in range(len(leftChild)):
            if leftChild[i] in rootCandidates:
                rootCandidates.remove(leftChild[i])
            if rightChild[i] in rootCandidates:
                rootCandidates.remove(rightChild[i])
        if len(rootCandidates) != 1:
            return False
        root = rootCandidates.pop()

        isValidTree, nodeCount = dfs(root, set(), leftChild, rightChild)
        return isValidTree and nodeCount == n


    def test_Leetcode(self):
        self.assertTrue(self.validateBinaryTreeNodes(4, [1, -1, 3, -1], [2, -1, -1, -1]))
        self.assertFalse(self.validateBinaryTreeNodes(4, [1, -1, 3, -1], [2, 3, -1, -1]))
        self.assertFalse(self.validateBinaryTreeNodes(2, [1, 0], [-1, -1]))
        self.assertFalse(self.validateBinaryTreeNodes(6, [1, -1, -1, 4, -1, -1], [2, -1, -1, 5, -1, -1]))


    def test_ErrorCase(self):
        self.assertFalse(self.validateBinaryTreeNodes(4, [1, 2, 0, -1], [-1, -1, -1, -1]))

if __name__ == '__main__':
    unittest.main()