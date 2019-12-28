# Definition for a binary tree node.

import unittest

# Non-threadsafe imports
from collections import deque
import heapq

# Threadsafe imports
try:
    # Python2
    import queue
except ImportError:
    # Python3
    import Queue as queue

class TestDataStructuresCollections(unittest.TestCase):

    @unittest.skip
    def test_Stack_NonThreadSafe(self):
        stack = deque()
        stack.append('a')
        stack.append('b')
        stack.append('c')

        print(stack.pop())
        print(stack.pop())
        print(stack.pop())

    @unittest.skip
    def test_Stack_ThreadSafe(self):
        stack = queue.LifoQueue()
        stack.put('a')
        stack.put('b')
        stack.put('c')

        print(stack.get())
        print(stack.get())
        print(stack.get())

    @unittest.skip
    def test_Queue_NonThreadSafe(self):
        queue = deque()
        queue.append('a')
        queue.append('b')
        queue.append('c')

        print(queue.popleft())
        print(queue.popleft())
        print(queue.popleft())

    @unittest.skip
    def test_Queue_ThreadSafe(self):
        q = queue.Queue()
        for i in range(5):
            q.put(i)

        while not q.empty():
            print(q.get())

    @unittest.skip
    def test_PriorityQueue_NonThreadSafe(self):
        li = [5, 7, 9, 1, 3]
        heapq.heapify(li)
        heapq.heappush(li, 4)
        print(heapq.heappop(li))
        print(heapq.heappop(li))
        print(heapq.heappop(li))
        print(heapq.heappop(li))
        print(heapq.heappop(li))

    @unittest.skip
    def test_PriorityQueue_ThreadSafe(self):
        li = [5, 7, 9, 1, 3]
        maxQueue = queue.PriorityQueue()
        maxQueue.put(5)
        maxQueue.put(7)
        maxQueue.put(9)
        maxQueue.put(1)
        maxQueue.put(3)

        while not maxQueue.empty():
            print(maxQueue.get())


if __name__ == '__main__':
    unittest.main()