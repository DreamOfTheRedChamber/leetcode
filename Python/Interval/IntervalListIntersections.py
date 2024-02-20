# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class IntervalListIntersections(unittest.TestCase):

    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:

        boundaryPoints = []
        for point in A:
            boundaryPoints.append((point[0], 1))
            boundaryPoints.append((point[1], -1))
        for point in B:
            boundaryPoints.append((point[0], 1))
            boundaryPoints.append((point[1], -1))
        boundaryPoints.sort(key=lambda x: (x[0], -x[1]))

        result = []
        count = 0
        start = 0
        for point in boundaryPoints:
            if point[1] == 1:
                count += 1
                if count > 1:
                    start = point[0]
            else:
                count -= 1
                if count == 1:
                    result.append([start, point[0]])

        return result

    def test_Leetcode(self):
        print(self.intervalIntersection([[0,2],[5,10],[13,23],[24,25]], [[1,5],[8,12],[15,24],[25,26]]))

if __name__ == '__main__':
    unittest.main()