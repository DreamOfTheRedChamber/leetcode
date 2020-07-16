# Definition for a binary tree node.
import random
import unittest
from collections import defaultdict


class LinkedListNode:
    def __init__(self, value: int):
        self.value = value
        self.keySet = set()
        self.prev = None
        self.next = None

    def remove(self):
        if self.prev:
            self.prev.next = self.next
        if self.next:
            self.next.prev = self.prev

    def insertAfter(self, target: int):
        newNode = LinkedListNode(target)
        originNext = self.next
        if originNext:
            originNext.prev = newNode
        self.next = newNode
        newNode.prev = self
        newNode.next = originNext

    def insertBefore(self, target: int):
        newNode = LinkedListNode(target)
        originPrev = self.prev
        newNode.prev = originPrev
        newNode.next = self
        self.prev = newNode
        originPrev.next = newNode

class AllOne:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dummyHead = LinkedListNode(0)
        self.tail = self.dummyHead
        self.keyToNodeMap = defaultdict(lambda: LinkedListNode(0))
        return

    def inc(self, key: str) -> None:
        """
        Inserts a new key <Key> with value 1. Or increments an existing key by 1.
        """
        if key not in self.keyToNodeMap:
            if not self.dummyHead.next or self.dummyHead.next.value != 1:
                self.dummyHead.insertAfter(1)
            self.keyToNodeMap[key] = self.dummyHead.next
            self.keyToNodeMap[key].keySet.add(key)
            if self.tail == self.dummyHead:
                self.tail = self.dummyHead.next
        else:
            currValue = self.keyToNodeMap[key].value

            # insert new node if not exist
            if not self.keyToNodeMap[key].next or self.keyToNodeMap[key].next.value != currValue + 1:
                self.keyToNodeMap[key].insertAfter(currValue + 1)

                # update tail pointer
                if self.keyToNodeMap[key] == self.tail:
                    self.tail = self.keyToNodeMap[key].next

            # remove the node from current node
            self.keyToNodeMap[key].keySet.remove(key)
            if not self.keyToNodeMap[key].keySet:
                self.keyToNodeMap[key].remove()

            # add the key to target node keySet
            self.keyToNodeMap[key].next.keySet.add(key)

            # change the mapping of key -> node
            self.keyToNodeMap[key] = self.keyToNodeMap[key].next

    def dec(self, key: str) -> None:
        """
        Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
        """

        if key not in self.keyToNodeMap:
            return

        # insert new node if not exist
        currValue = self.keyToNodeMap[key].value
        if self.keyToNodeMap[key].prev.value != currValue - 1:
            self.keyToNodeMap[key].insertBefore(currValue - 1)

        # remove the node from the current node
        self.keyToNodeMap[key].keySet.remove(key)
        if not self.keyToNodeMap[key].keySet:

            # update tail pointer
            if self.keyToNodeMap[key] == self.tail:
                self.tail = self.keyToNodeMap[key].prev

            self.keyToNodeMap[key].remove()

        # add the key to target node keySet
        self.keyToNodeMap[key].prev.keySet.add(key)

        # change the mapping of key -> node
        self.keyToNodeMap[key] = self.keyToNodeMap[key].prev

    def getMaxKey(self) -> str:
        """
        Returns one of the keys with maximal value.
        """
        if self.dummyHead == self.tail:
            return ""
        else:
            result = self.tail.keySet.pop()
            self.tail.keySet.add(result)
            return result

    def getMinKey(self) -> str:
        """
        Returns one of the keys with Minimal value.
        """
        if self.dummyHead == self.tail:
            return ""
        else:
            result = self.dummyHead.next.keySet.pop()
            self.dummyHead.next.keySet.add(result)
            return result

# Your AllOne object will be instantiated and called as such:
# obj = AllOne()
# obj.inc(key)
# obj.dec(key)
# param_3 = obj.getMaxKey()
# param_4 = obj.getMinKey()

class AllOoneDataStructure(unittest.TestCase):

    @unittest.skip
    def test_ErrorCase1(self):
        newClass = AllOne()
        newClass.inc("hello")
        self.assertEqual("hello", newClass.getMaxKey())
        self.assertEqual("hello", newClass.getMinKey())

    @unittest.skip
    def test_ErrorCase2(self):
        newClass = AllOne()
        newClass.inc("hello")
        newClass.inc("hello")
        self.assertEqual("hello", newClass.getMaxKey())
        self.assertEqual("hello", newClass.getMinKey())
        newClass.inc("leet")
        self.assertEqual("leet", newClass.getMinKey())
        self.assertEqual("hello", newClass.getMaxKey())

    @unittest.skip
    def test_ErrorCase3(self):
        newClass = AllOne()
        newClass.inc("hello")
        newClass.inc("goodbye")
        newClass.inc("hello")
        newClass.inc("hello")
        self.assertEqual("hello", newClass.getMaxKey())
        newClass.inc("leet")
        newClass.inc("code")
        newClass.inc("leet")
        newClass.dec("hello")
        self.assertEqual("leet", newClass.getMaxKey())
# input
# ["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
# [[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]

# Output
# [null,null,null,null,null,"hello",null,null,null,null,null,null,null,"hello"]
# Expected
# [null,null,null,null,null,"hello",null,null,null,null,null,null,null,"leet"]

    @unittest.skip
    def test_Errorcase4(self):
        newClass = AllOne()
        newClass.dec("hello")
        self.assertEqual("", newClass.getMaxKey())

    def tes

if __name__ == '__main__':
    unittest.main()