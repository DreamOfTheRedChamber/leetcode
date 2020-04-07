# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List


class MaxNumberOfEventsToAttend(unittest.TestCase):

    def maxEvents(self, events: List[List[int]]) -> int:
        events = sorted(events)
        minHeap = []
        lastDay = max(event[1] for event in events)
        eventId = 0
        result = 0

        for currentDay in range(1, lastDay + 1):

            while eventId < len(events) and currentDay >= events[eventId][0]:
                heapq.heappush(minHeap, events[eventId][1])
                eventId += 1

            while minHeap and currentDay > minHeap[0]:
                heapq.heappop(minHeap)

            if minHeap:
                heapq.heappop(minHeap)
                result += 1

        return result

    def test_Leetcode(self):
        self.assertEqual(3, self.maxEvents([[1, 2], [2, 3], [3, 4]]))
        self.assertEqual(4, self.maxEvents([[1, 2], [2, 3], [3, 4], [1, 2]]))
        self.assertEqual(4, self.maxEvents([[1, 4], [4, 4], [2, 2], [3, 4], [1, 1]]))
        self.assertEqual(1, self.maxEvents([[1, 100000]]))
        self.assertEqual(7, self.maxEvents([[1,1], [1,2], [1,3], [1,4], [1,5], [1,6], [1,7]]))

    def test_Leetcode(self):
        self.assertEqual(5, self.maxEvents([[1,2], [1,2], [3,3], [1,5], [1,5]]))

if __name__ == '__main__':
    unittest.main()