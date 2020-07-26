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

class TestDataStructuresPriorityQueue(unittest.TestCase):

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

    def test_PeekHeapTop(self):
        pq = []
        heapq.heappush(pq, 3)
        heapq.heappush(pq, 1)
        heapq.heappush(pq, 4)
        print(pq[0])
        print(heapq.heappop(pq))

    def test_PriorityQueue_Tuple(self):
        pq = []
        heapq.heappush(pq, (3, 25))
        heapq.heappush(pq, (20, 3))
        heapq.heappush(pq, (5, 5))


if __name__ == '__main__':
    unittest.main(