# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class ValidateBinaryTreeNodes(unittest.TestCase):

    def validateBinaryTreeNodes(self, n: int, leftChild: List[int], rightChild: List[int]) -> bool:

        def dfs(start: int, discovered: set, leftChild: List[int], rightChild: List[int]) -> bool:
            if start in discovered:
                return False
            if start == -1:
                return True

            discovered.add(start)
            return dfs(leftChild[start], discovered, leftChild, rightChild) and dfs(rightChild[start], discovered, leftChild, rightChild)

        rootCandidates = set(range(1, n + 1))
        for i in range(len(leftChild)):
            if leftChild[i] in rootCandidates:
                rootCandidates.remove(leftChild[i])
            if rightChild[i] in rootCandidates:
                rootCandidates.remove(rightChild[i])
        if len(rootCandidates) != 1:
            return False
        root = rootCandidates.pop()

        return dfs(root, set(), leftChild, rightChild)

    def test_Leetcode(self):
        self.assertTrue(self.validateBinaryTreeNodes(4, [1, -1, 3, -1], [2, -1, -1, -1]))
        self.assertTrue(self.validateBinaryTreeNodes(4, [1, -1, 3, -1], [2, 3, -1, -1]))
        self.assertTrue(self.validateBinaryTreeNodes(2, [1, 0], [-1, -1]))
        self.assertTrue(self.validateBinaryTreeNodes(6, [1, -1, -1, 4, -1, -1], [2, -1, -1, 5, -1, -1]))

if __name__ == '__main__':
    unittest.main()