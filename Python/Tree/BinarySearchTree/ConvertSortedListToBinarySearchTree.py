# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class ConvertSortedListToBinarySearchTree(unittest.TestCase):
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if head is None:
            return None
        elif head.next is None:
            return TreeNode(head.val)
        elif head.next.next is None:
            root = TreeNode(head.val)
            root.right = TreeNode(head.next.val)
            return root
        else:
            medianNode = self.findMedianAndBreak(head)
            root = TreeNode(medianNode.val)
            root.left = self.sortedListToBST(head)
            root.right = self.sortedListToBST(medianNode.next)
            return root

    def findMedianAndBreak(self, head: ListNode):
        fast = head
        slow = head
        prev = None

        while fast.next is not None and fast.next.next is not None:
            prev = slow
            slow = slow.next
            fast = fast.next.next

        prev.next = None
        return slow


    def test_NormalTree(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node5 = ListNode(5)
        node6 = ListNode(6)
        node7 = ListNode(7)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        result = self.sortedListToBST(node1)

        print(result.val)

if __name__ == '__main__':
    unittest.main()