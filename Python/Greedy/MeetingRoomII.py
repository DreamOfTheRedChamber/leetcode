# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List


class MeetingRoomII(unittest.TestCase):

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0:
            return 0

        sortedIntervals = sorted(intervals)

        minQueue = []
        for interval in sortedIntervals:
            if minQueue and minQueue[0] <= interval[0]:
                heapq.heapreplace(minQueue, interval[1])
            else:
                heapq.heappush(minQueue, interval[1])

        return len(minQueue)

    def test_leetcode(self):
        self.assertEqual(2, self.minMeetingRooms([[0, 30], [5, 10], [15, 20]]))
        self.assertEqual(1, self.minMeetingRooms([[7, 10], [2, 4]]))

if __name__ == '__main__':
    unittest.main()