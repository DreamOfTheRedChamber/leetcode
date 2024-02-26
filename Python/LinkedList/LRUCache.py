# Definition for a binary tree node.
import heapq
import unittest

class ListNode:

    def __init__(self, val: int):
        self.val = val
        self.next = None
        self.prev = None
        return

class LRUCache:

    def __init__(self, capacity: int):
        self.capa = capacity
        self.cache = {}

        self.dummyHead = ListNode(0)
        self.dummyTail = ListNode(0)
        return

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.deleteFromList(node)
            self.cache[key] = ListNode(node.val)
            self.insertToHead(self.cache[key])
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if len(self.cache) == self.capa and key not in self.cache:
            tailNode = self.dummyTail.prev
            self.deleteFromList(tailNode)

        newNode = ListNode(value)
        if key in self.cache:
            self.deleteFromList(newNode)
        self.cache[key] = newNode
        self.insertToHead(newNode)
        return

    def insertToHead(self, node: ListNode):
        originalHead = self.dummyHead.next

        # between first and second
        originalHead.prev = node
        node.next = originalHead

        # between dummy head and first
        node.prev = self.dummyHead
        self.dummyHead.next = node

        return

    def deleteFromList(self, node: ListNode):
        nodePrev = node.prev
        nodeNext = node.next
        nodePrev.next = nodeNext
        nodeNext.prev = nodePrev
        node.prev = None
        node.next = None

        return

class LRUCacheTest(unittest.TestCase):

    def test_Leetcode(self):

        print([1])

    # Your LRUCache object will be instantiated and called as such:
    # obj = LRUCache(capacity)
    # param_1 = obj.get(key)
    # obj.put(key,value)

if __name__ == '__main__':
    unittest.main()