# Definition for a binary tree node.
import heapq
import unittest

class ListNode:

    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.next = None
        self.prev = None
        return

class LRUCache:

    def __init__(self, capacity: int):
        self.capa = capacity
        self.cache = {}

        self.dummyHead = ListNode(0, 0)
        self.dummyTail = ListNode(0, 0)
        self.dummyHead.next = self.dummyTail
        self.dummyTail.prev = self.dummyHead
        return

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.deleteFromList(node)
            self.cache[key] = ListNode(node.key, node.val)
            self.insertToHead(self.cache[key])
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if len(self.cache) == self.capa and key not in self.cache:
            tailNode = self.dummyTail.prev
            self.deleteFromList(tailNode)
            del self.cache[tailNode.key]

        newNode = ListNode(key, value)
        if key in self.cache:
            self.deleteFromList(self.cache[key])
            del self.cache[key]
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
        if nodePrev is not None:
            nodePrev.next = nodeNext
        if nodeNext is not None:
            nodeNext.prev = nodePrev
        node.prev = None
        node.next = None

        return

class LRUCacheTest(unittest.TestCase):

    @unittest.skip
    def test_Leetcode1(self):
#        ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
#        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
#        Expected: [null,null,null,1,null,-1,null,-1,3,4]
        cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        self.assertEqual(1, cache.get(1))
        cache.put(3, 3)
        self.assertEqual(-1, cache.get(2))
        cache.put(4, 4)
        self.assertEqual(-1, cache.get(1))
        self.assertEqual(3, cache.get(3))
        self.assertEqual(4, cache.get(4))
        print([1])

    def test_Leetcode2(self):

#        ["LRUCache", "put", "put", "put", "put", "get", "get"]
#        [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
#        Expected: [null, null, null, null, null, -1, 3]

        cache = LRUCache(2)
        cache.put(2, 1)
        cache.put(1, 1)
        cache.put(2, 3)
        cache.put(4, 1)
        self.assertEqual(-1, cache.get(1))
        self.assertEqual(3, cache.get(2))
        print([1])


if __name__ == '__main__':
    unittest.main()