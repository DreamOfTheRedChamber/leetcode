# Definition for a binary tree node.
import collections
import unittest

# Non-threadsafe imports
from collections import deque
import heapq

# Threadsafe imports
from typing import List

try:
    # Python2
    import queue
except ImportError:
    # Python3
    import Queue as queue

class TaskScheduler(unittest.TestCase):

    def leastInterval(self, tasks: List[str], n: int) -> int:
        if n == 0:
            return len(tasks)

        taskCounter = collections.Counter(tasks)
        pq = []
        for task, count in taskCounter.items():
            heapq.heappush(pq, (-count, task))

        result = 0

        while pq:
            currSlot, tempList = 0, []
            while currSlot != n + 1 and pq:
                pqHead = heapq.heappop(pq)
                if pqHead[0] + 1 < 0:
                    tempList.append((pqHead[0] + 1, pqHead[1]))
                currSlot += 1

            if not tempList:
                result += currSlot
            else:
                result += n + 1

            for entry in tempList:
                heapq.heappush(pq, entry)

        return result

    def test_normalCase(self):
        tasks = ["A", "A", "A", "B", "B", "B"]
        n = 2
        print(self.leastInterval(tasks, 2))

    def test_wrongCase(self):
        tasks = ["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"]
        print(self.leastInterval(tasks, 2))

if __name__ == '__main__':
    unittest.main()