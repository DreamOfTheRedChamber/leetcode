# Definition for a singly-linked list.

# 55 min

import unittest

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class RemoveNthNodeFromEndOfList(unittest.TestCase):

    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if head is None:
            return head

        dummyHead = ListNode(0)
        dummyHead.next = head
        fast = dummyHead
        slow = dummyHead

        for i in range(n):
            fast = fast.next

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next

        slow.next = slow.next.next

        return dummyHead.next

    def test_EmptyList(self):
        result = self.removeNthFromEnd(None, 0)

        self.assertTrue(result is None)

    def test_ListHead(self):
        node1 = ListNode(5)

        result = self.removeNthFromEnd(node1, 1)

        self.assertTrue(result is None)

    def test_ListTail(self):
        node1 = ListNode(2)
        node2 = ListNode(4)
        node3 = ListNode(3)
        node1.next = node2
        node2.next = node3

        result = self.removeNthFromEnd(node1, 3)

        self.assertTrue(result.next.next is None)

    def test_MiddleNode(self):
        node1 = ListNode(0)
        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node1.next = node2
        node2.next = node3
        node3.next = node4

        result = self.removeNthFromEnd(node1, 2)

        self.assertTrue(4, result.next.val)

if __name__ == '__main__':
    unittest.main()