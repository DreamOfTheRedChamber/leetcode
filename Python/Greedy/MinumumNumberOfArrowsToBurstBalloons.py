# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List

class MinimumNumberOfArrowToBurstBalloons(unittest.TestCase):

    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if len(points) == 0:
            return 0

        sortedPoints = sorted(points)
        minHeap = []
        totalNum = 0
        for point in sortedPoints:
            if minHeap and minHeap[0] >= point[0]:
                heapTop = minHeap[0]
                heapq.heapreplace(minHeap, min(point[1], heapTop))
            else:
                totalNum += 1
                while minHeap:
                    heapq.heappop(minHeap)
                heapq.heappush(minHeap, point[1])

        return totalNum

    def test_LeetcodeTest(self):
        self.assertEqual(2, self.findMinArrowShots([[10,16], [2,8], [1,6], [7,12]]))
        self.assertEqual(2, self.findMinArrowShots([[3, 9], [7, 12], [3, 8], [6, 8], [9, 10], [2, 9], [0, 9], [3, 9], [0, 6], [2, 8]]))

        self.assertEqual(2, self.findMinArrowShots([[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]))


if __name__ == '__main__':
    unittest.main()