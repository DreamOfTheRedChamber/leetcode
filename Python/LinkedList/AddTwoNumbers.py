import unittest

class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None

class AddTwoNumbers(unittest.TestCase):

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        node1 = l1
        node2 = l2
        dummyHead = ListNode(0)
        dummyTail = dummyHead

        while node1 is not None and node2 is not None:
            sum = node1.val + node2.val + carry
            currentNode = ListNode(sum % 10)
            carry = sum // 10
            dummyTail.next = currentNode
            dummyTail = currentNode
            node1 = node1.next
            node2 = node2.next

        while node1 is not None:
            sum = node1.val + carry
            currentNode = ListNode(sum % 10)
            carry = sum // 10
            dummyTail.next = currentNode
            dummyTail = currentNode
            node1 = node1.next

        while node2 is not None:
            sum = node2.val + carry
            currentNode = ListNode(sum % 10)
            carry = sum // 10
            dummyTail.next = currentNode
            dummyTail = currentNode
            node2 = node2.next

        if carry != 0:
            currentNode = ListNode(1)
            dummyTail.next = currentNode
            dummyTail = currentNode

        return dummyHead.next

    def test_LastBitCarry(self):
        node1 = ListNode(5)
        node2 = ListNode(5)

        result = self.addTwoNumbers(node1, node2)

        self.assertEqual(0, result.val)
        self.assertEqual(1, result.next.val)

    def test_EqualLength(self):
        node1 = ListNode(2)
        node2 = ListNode(4)
        node3 = ListNode(3)
        node1.next = node2
        node2.next = node3

        node4 = ListNode(5)
        node5 = ListNode(6)
        node6 = ListNode(4)
        node4.next = node5
        node5.next = node6

        result = self.addTwoNumbers(node1, node4)

        self.assertEqual(7, result.val)
        self.assertEqual(0, result.next.val)
        self.assertEqual(8, result.next.next.val)

    def test_UnequalLength(self):
        node1 = ListNode(0)

        node2 = ListNode(2)
        node3 = ListNode(3)
        node4 = ListNode(4)
        node2.next = node3
        node3.next = node4

        result = self.addTwoNumbers(node1, node2)

        self.assertEqual(2, result.val)
        self.assertEqual(3, result.next.val)
        self.assertEqual(4, result.next.next.val)

if __name__ == '__main__':
    unittest.main()