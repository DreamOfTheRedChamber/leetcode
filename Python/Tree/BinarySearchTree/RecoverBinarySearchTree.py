# Definition for a binary tree node.
import unittest

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class RecoverBinarySearchTree(unittest.TestCase):

    def recoverTree(self, root: TreeNode) -> None:
        curNode = root
        prevNode = None
        firstNode = None
        secondNode = None
        while curNode:
            if not curNode.left:
                print(curNode.val)
                if prevNode is not None and prevNode.val > curNode.val:
                    if firstNode is None:
                        firstNode = prevNode
                    secondNode = curNode

                prevNode = curNode
                curNode = curNode.right
            else:
                rightMostChild = self.findRightMostChild(curNode)
                if rightMostChild.right == curNode:
                    rightMostChild.right = None
                    print(curNode.val)
                    if prevNode is not None and prevNode.val > curNode.val:
                        if firstNode is None:
                            firstNode = prevNode
                        secondNode = curNode

                    prevNode = curNode
                    curNode = curNode.right
                else:
                    rightMostChild.right = curNode
                    curNode = curNode.left
        self.swapIfNotInOrder(firstNode, secondNode)

    def swapIfNotInOrder(self, node1: TreeNode, node2: TreeNode):
        temp = node1.val
        node1.val = node2.val
        node2.val = temp

    def findRightMostChild(self, root: TreeNode) -> TreeNode:
        curNode = root.left
        while curNode.right is not None and curNode.right != root:
            curNode = curNode.right
        return curNode

    def test_SkewedTree(self):
        node1 = TreeNode(1)
        node2 = TreeNode(3)
        node3 = TreeNode(2)
        node4 = TreeNode(4)

        node1.left = node2
        node2.left = node3
        node3.left = node4

        self.recoverTree(node1)
        self.recoverTree(node1)

    def test_NormalTree(self):
        node1 = TreeNode(1)
        node2 = TreeNode(4)
        node3 = TreeNode(3)
        node4 = TreeNode(2)
        node5 = TreeNode(5)
        node6 = TreeNode(6)
        node7 = TreeNode(7)

        node3.left = node1
        node3.right = node5
        node1.right = node2
        node5.left = node4
        node5.right = node6
        node6.right = node7

        self.recoverTree(node3)
        self.recoverTree(node3)

if __name__ == '__main__':
    unittest.main()