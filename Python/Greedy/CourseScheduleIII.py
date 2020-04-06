# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List


class CourseScheduleIII(unittest.TestCase):

    def scheduleCourse(self, courses: List[List[int]]) -> int:
        minHeap = []
        courses.sort(key=lambda x: x[1])

        current = 0
        for t, d in courses:
            heapq.heappush(minHeap, -t)
            current += t
            if current > d:
                current += heapq.heappop(minHeap)

        return len(minHeap)

    def test_Test1(self):
        self.assertEqual(3, self.scheduleCourse([[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]))

if __name__ == '__main__':
    unittest.main()