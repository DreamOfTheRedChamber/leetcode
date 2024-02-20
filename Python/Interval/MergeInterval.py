# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MergeInterval(unittest.TestCase):

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        boundaryPoints = []
        for interval in intervals:
            boundaryPoints.append((interval[0], 1))
            boundaryPoints.append((interval[1], -1))
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
        print(self.merge([[1,3],[2,6],[8,10],[15,18]]))
        print(self.merge([[1,4],[4,5]]))

    def test_Edgecase(self):
        print(self.merge([[1,4],[4,7],[4,5],[5,8]]))
        print(self.merge([[1,1]]))
        print(self.merge([]))

if __name__ == '__main__':
    unittest.main()