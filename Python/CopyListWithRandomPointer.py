# Definition for a binary tree node.
import unittest

# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random



class CopyListWithRandomPointer(unittest.TestCase):

    def copyRandomList(self, head: 'Node') -> 'Node':
        # Create nodes and mappings
        currentNode = head
        mapping = {}
        dummyListHead = Node(0)
        dummyListTail = dummyListHead
        while currentNode is not None:
            newNode = Node(currentNode.val)
            mapping[currentNode] = newNode
            currentNode = currentNode.next
            dummyListTail.next = newNode
            dummyListTail = newNode

        # Copy next and random pointer
        currentNode = head
        while currentNode is not None:
            copiedNode = mapping[currentNode]
            if currentNode.random is not None:
                copiedNodeRandom = mapping[currentNode.random]
                copiedNode.random = copiedNodeRandom

            currentNode = currentNode.next

        return dummyListHead.next


    def testNormalCase(self):
        node0 = Node(7)
        node1 = Node(13)
        node2 = Node(11)
        node3 = Node(10)
        node4 = Node(1)
        node0.next = node1
        node0.random = None
        node1.next = node2
        node1.random = node0
        node2.next = node3
        node2.random = node4
        node3.next = node4
        node3.random = node2
        node4.random = node0

        result = self.copyRandomList(node0)
        print(result)


if __name__ == '__main__':
    unittest.main()