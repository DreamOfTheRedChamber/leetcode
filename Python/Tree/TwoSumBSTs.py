# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# 1. T: NLogN.
# 2. T: N. S: N
# 3. Average T: LogN, S: LogN; Worst T: N, S: N
# 4. Algo3 time limit exceeded Worst case: 2^n; Try algorithm 3

class TwoSumBSTs(unittest.TestCase):
    def twoSumBSTs(self, root1: TreeNode, root2: TreeNode, target: int) -> bool:
        # traverse one binary tree and put into hashset
        firstTreeNodes = set()
        self.inorderBuildNodes(root1, firstTreeNodes)

        # traverse second binary tree and check against hashset
        return self.inorderFindTarget(root2, firstTreeNodes, target)

    def inorderBuildNodes(self, root: TreeNode, firstTreeNodes: set):
        if root is None:
            return

        self.inorderBuildNodes(root.left, firstTreeNodes)
        if root is not None:
            firstTreeNodes.add(root.val)
        self.inorderBuildNodes(root.right, firstTreeNodes)

    def inorderFindTarget(self, root: TreeNode, existNodes: set, target: int) -> bool:
        if root is None:
            return False
        elif target - root.val in existNodes:
            return True
        else:
            leftresult = self.inorderFindTarget(root.left, existNodes, target)
            rightresult = self.inorderFindTarget(root.right, existNodes, target)
            return leftresult or rightresult

    def twoSumBSTsRecursion(self, root1: TreeNode, root2: TreeNode, target: int) -> bool:
        if root1 is None or root2 is None:
            return False
        elif root1.val + root2.val == target:
            return True
        elif root1.val + root2.val < target:
            return self.twoSumBSTsRecursion(root1.right, root2, target) or self.twoSumBSTsRecursion(root1, root2.right, target)
        else:
            return self.twoSumBSTsRecursion(root1.left, root2, target) or self.twoSumBSTsRecursion(root1, root2.left, target)

    def test_existPair(self):
        node1 = TreeNode(2)
        node2 = TreeNode(1)
        node3 = TreeNode(4)
        node2.left = node1
        node2.right = node3

        node4 = TreeNode(1)
        node5 = TreeNode(0)
        node6 = TreeNode(3)
        node4.left = node5
        node4.right = node6

        self.assertTrue(self.twoSumBSTs(node2, node4, 5))
        self.assertTrue(self.twoSumBSTs(node2, node5, 3))

    @unittest.skip
    def test_notExistPair(self):
        node1 = TreeNode(-10)
        node2 = TreeNode(0)
        node3 = TreeNode(10)
        node2.left = node1
        node2.right = node3

        node4 = TreeNode(0)
        node5 = TreeNode(1)
        node6 = TreeNode(2)
        node7 = TreeNode(5)
        node8 = TreeNode(7)
        node7.left = node5
        node7.right = node8
        node5.left = node4
        node5.right = node6

        self.assertFalse(self.twoSumBSTs(node2, node7, 18))

if __name__ == '__main__':
    unittest.main()