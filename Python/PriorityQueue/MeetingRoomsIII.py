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
            heapq.heappush(available, (i, 0))

        # rank by ts first, and then room index
        unavailable = []
        freqMap = defaultdict(lambda: 0)
        for start, end in meetings:
            while unavailable and start >= unavailable[0][0]:
                ts, index = heapq.heappop(unavailable)
                heapq.heappush(available, (index, start))

            if not available:
                ts, index = heapq.heappop(unavailable)
                currTime = max(ts, start)
                heapq.heappush(unavailable, (currTime + end - start, index))
                freqMap[index] += 1
            else:
                index, ts = heapq.heappop(available)
                heapq.heappush(unavailable, (end, index))
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

    def test_example3(self):
        n = 4
        meetings = [[18,19],[3,12],[17,19],[2,13],[7,10]]
        self.assertEqual(0, self.mostBooked(n, meetings))


if __name__ == '__main__':
    unittest.main()