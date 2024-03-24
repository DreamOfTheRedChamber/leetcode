# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MeetingRoomsIII(unittest.TestCase):

    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x: x[0])
        # min heap by room index
        available = []
        for i in range(n):
            heapq.heappush(available, (0, i))

        freqMap = defaultdict(lambda: 0)
        for start, end in meetings:
            ts, index = heapq.heappop(available)
            delayedStart = max(ts, start)
            heapq.heappush(available, (delayedStart + end - start, index))
            freqMap[index] += 1

        maxFreq = max(freqMap.values())
        for i in range(n):
            if freqMap[i] == maxFreq:
                return i

        return -1

    def test_example1(self):
        n = 2
        meetings = [[0, 10], [1, 5], [2, 7], [3, 4]]
        self.assertEqual(0, self.mostBooked(n, meetings))

    def test_example2(self):
        n = 3
        meetings = [[1, 20], [2, 10], [3, 5], [4, 9], [6, 8]]
        self.assertEqual(1, self.mostBooked(n, meetings))

if __name__ == '__main__':
    unittest.main()