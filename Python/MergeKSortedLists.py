# Definition for singly-linked list.

from queue import PriorityQueue
from typing import List

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        dummyHead = tail = ListNode(0)
        minHeap = PriorityQueue()

        for i in range(len(lists)):
            if lists[i] is not None:
                minHeap.put((lists[i].val, i, lists[i]))

        while not minHeap.empty():
            val, index, node = minHeap.get()
            if node.next is not None:
                minHeap.put((node.next.val, index, node.next))

            newNode = ListNode(node.val)
            tail.next = newNode
            tail = newNode

        return dummyHead.next

    def test_threeListSameSize(self):
        node1 = ListNode(1)
        node2 = ListNode(4)
        node3 = ListNode(5)
        node1.next = node2
        node2.next = node3

        node4 = ListNode(1)
        node5 = ListNode(3)
        node6 = ListNode(4)
        node4.next = node5
        node5.next = node6

        node7 = ListNode(2)
        node8 = ListNode(6)
        node7.next = node8

        result = self.mergeKList([node1, node4, node7])

        self.assertEqual(1, result.val)
        self.assertEqual(1, result.next.val)
        self.assertEqual(2, result.next.next.val)
        self.assertEqual(3, result.next.next.next.val)

    def test_threeListOneEmpty(self):
        node1 = ListNode(1)
        node2 = ListNode(4)
        node3 = ListNode(5)
        node1.next = node2
        node2.next = node3

        node4 = ListNode(1)
        node5 = ListNode(3)
        node6 = ListNode(4)
        node4.next = node5
        node5.next = node6

        node7 = None

        result = self.mergeKList([node1, node4, node7])

        self.assertEqual(1, result.val)
        self.assertEqual(1, result.next.val)
        self.assertEqual(3, result.next.next.val)
        self.assertEqual(4, result.next.next.next.val)