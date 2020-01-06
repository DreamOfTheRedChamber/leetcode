# Definition for a binary tree node.
import unittest

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class ReverseNodesInKGroup(unittest.TestCase):

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummyHead = ListNode(0)
        dummyTail = dummyHead

        kGroupHead = head
        kGroupTail = head
        while kGroupTail is not None:
            for i in range(k - 1):
                kGroupTail = kGroupTail.next
                if kGroupTail is None:
                    break

            nextGroupHead = kGroupTail
            if kGroupTail is not None:
                nextGroupHead = kGroupTail.next
                kGroupTail.next = None
            resultHead, resultTail = self.reverseKNodes(kGroupHead, kGroupTail)

            dummyTail.next = resultHead
            dummyTail = resultTail

            kGroupHead = kGroupTail = nextGroupHead

        return dummyHead.next

    def reverseKNodes(self, listHead: ListNode, listTail: ListNode) -> (ListNode, ListNode):
        if listTail is None:
            return listHead, listTail

        prev = None
        current = listHead
        while current is not None:
            temp = current.next
            current.next = prev
            prev = current
            current = temp

        return listTail, listHead

    def test_reverseInTwoGroup(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        result = self.reverseKGroup(node1, 2)

        self.assertEqual(2, result.val)
        self.assertEqual(1, result.next.val)
        self.assertEqual(4, result.next.next.val)
        self.assertEqual(3, result.next.next.next.val)
        self.assertEqual(5, result.next.next.next.next.val)

    def test_reverseInSixGroup(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        result = self.reverseKGroup(node1, 6)

        self.assertEqual(1, result.val)
        self.assertEqual(2, result.next.val)
        self.assertEqual(4, result.next.next.val)
        self.assertEqual(3, result.next.next.next.val)
        self.assertEqual(5, result.next.next.next.next.val)

    def test_reverseInSixGroup(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node1.next = node2
        node2.next = node3
        node3.next = node4

        result = self.reverseKGroup(node1, 2)

        self.assertEqual(2, result.val)
        self.assertEqual(1, result.next.val)
        self.assertEqual(4, result.next.next.val)
        self.assertEqual(3, result.next.next.next.val)

if __name__ == '__main__':
    unittest.main()