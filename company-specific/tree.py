# Definition for a binary tree node.
import unittest
from typing import List


class TreeNode:

    def __init__(self, key: str, val: str):
        self.key = key
        self.val = val
        self.children = []

    def addChild(self, child):
        self.children.append(child)
        return

class Tree(unittest.TestCase):

    def test_keySameValDiff(self):
        node1 = TreeNode("1", "A")
        node2 = TreeNode("2", "B")
        node3 = TreeNode("3", "C")
        node1.addChild(node2)
        node2.addChild(node3)

        node4 = TreeNode("1", "A")
        node5 = TreeNode("2", "D")
        node6 = TreeNode("3", "C")
        node4.addChild(node5)
        node5.addChild(node6)

        self.assertEqual(self.compute_diff(node1, node4), 1)

    def test_keyDiffValSame(self):
        node1 = TreeNode("1", "A")
        node2 = TreeNode("2", "B")
        node3 = TreeNode("3", "C")
        node1.addChild(node2)
        node2.addChild(node3)

        node4 = TreeNode("1", "A")
        node5 = TreeNode("4", "B")
        node6 = TreeNode("3", "C")
        node4.addChild(node5)
        node5.addChild(node6)

        self.assertEqual(self.compute_diff(node1, node4), 4)

    def test_NullCase(self):
        node1 = TreeNode("1", "A")
        node2 = TreeNode("2", "B")
        node3 = TreeNode("3", "C")
        node1.addChild(node2)
        node2.addChild(node3)

        self.assertEqual(self.compute_diff(node1, None), 3)

        return None

    def test_keyComplicatedCase(self):
        node1 = TreeNode("1", "A")
        node2 = TreeNode("2", "B")
        node3 = TreeNode("3", "C")
        node4 = TreeNode("4", "D")
        node5 = TreeNode("8", "E")
        node6 = TreeNode("6", "F")
        node7 = TreeNode("7", "G")
        node1.addChild(node2)
        node1.addChild(node3)
        node2.addChild(node4)
        node2.addChild(node5)
        node4.addChild(node7)
        node3.addChild(node6)

        node1_2 = TreeNode("1", "A")
        node2_2 = TreeNode("2", "B")
        node3_2 = TreeNode("3", "C")
        node4_2 = TreeNode("5", "D")
        node5_2 = TreeNode("8", "E")
        node6_2 = TreeNode("9", "F")
        node1_2.addChild(node2_2)
        node1_2.addChild(node3_2)

        node2_2.addChild(node4_2)
        node2_2.addChild(node5_2)
        node2_2.addChild(node6_2)

        self.assertEqual(6, self.compute_diff(node1, node1_2))

    def compute_diff(self, root1: TreeNode, root2: TreeNode) -> int:

        def countNodes(node: TreeNode) -> int:
            if node is None:
                return 0
            else:
                result = 1
                for child in node.children:
                    result += countNodes(child)
                return result

        if root1 is None:
            return countNodes(root2)
        elif root2 is None:
            return countNodes(root1)
        elif root1.key != root2.key:
            return countNodes(root1) + countNodes(root2)
        else:
            result = 0
            if root1.val != root2.val:
                result += 1

            root1Children = {x.key: x for x in root1.children}
            root2Children = {x.key: x for x in root2.children}
            for key, value in root1Children.items():
                if key in root2Children:
                    result = result + self.compute_diff(root1Children[key], root2Children[key])

            for key, value in root1Children.items():
                if key not in root2Children:
                    result = result + countNodes(root1Children[key])

            for key, value in root2Children.items():
                if key not in root1Children:
                    result = result + countNodes(root2Children[key])

            return result

if __name__ == '__main__':
    unittest.main()