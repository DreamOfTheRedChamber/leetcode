import unittest

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class MergeTwoSortedLists(unittest.TestCase):

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:

        dummyHead = ListNode(0)
        dummyTail = dummyHead

        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                dummyTail.next = l1
                dummyTail = l1
                l1 = l1.next
            else:
                dummyTail.next = l2
                dummyTail = l2
                l2 = l2.next

        if l1 is not None:
            dummyTail.next = l1

        if l2 is not None:
            dummyTail.next = l2

        return dummyHead.next

    def test_oneListEmpty(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(4)
        node1.next = node2
        node2.next = node3

        result = self.mergeTwoLists(node1, None)

        self.assertEqual(1, result.val)
        self.assertEqual(2, result.next.val)
        self.assertEqual(4, result.next.next.val)

    def test_twoListSameSize(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(4)
        node1.next = node2
        node2.next = node3

        node4 = ListNode(1)
        node5 = ListNode(3)
        node6 = ListNode(4)
        node4.next = node5
        node5.next = node6

        result = self.mergeTwoLists(node1, node4)

        self.assertEqual(1, result.val)
        self.assertEqual(1, result.next.val)
        self.assertEqual(2, result.next.next.val)
        self.assertEqual(3, result.next.next.next.val)

    def test_twoListDifferentSize(self):
        node1 = ListNode(1)
        node2 = ListNode(2)
        node3 = ListNode(2)
        node6 = ListNode(6)
        node1.next = node2
        node2.next = node3
        node3.next = node6

        node4 = ListNode(1)
        node5 = ListNode(3)
        node6 = ListNode(4)
        node4.next = node5
        node5.next = node6

        result = self.mergeTwoLists(node1, node4)

        self.assertEqual(1, result.val)
        self.assertEqual(1, result.next.val)
        self.assertEqual(2, result.next.next.val)
        self.assertEqual(2, result.next.next.next.val)

if __name__ == '__main__':
    unittest.main()