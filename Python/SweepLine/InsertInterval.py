# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List

class InsertInterval(unittest.TestCase):

    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        boundaryPoints = []
        for interval in intervals:
            boundaryPoints.append((interval[0], 1))
            boundaryPoints.append((interval[1], -1))
        boundaryPoints.append((newInterval[0], 1))
        boundaryPoints.append((newInterval[1], -1))
        boundaryPoints.sort(key=lambda x: (x[0], -x[1]))

        result = []
        start, end = 0, 0
        count = 0
        for point in boundaryPoints:
            if point[1] == 1:
                count += 1
                if count == 1:
                    start = point[0]
            else:
                count -= 1
                if count == 0:
                    end = point[0]
                    result.append([start, end])

        return result

    def test_Leetcode(self):
        print(self.insert([[1,3],[6,9]], [2, 5]))
        print(self.insert([[1,2],[3,5],[6,7],[8,10],[12,16]], [4, 8]))

if __name__ == '__main__':
    unittest.main()