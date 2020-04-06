# Definition for a binary tree node.
import heapq
import queue
import unittest

# Read about enumerate in python
from cmath import inf
from typing import List

class SkylineProblem(unittest.TestCase):

    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        # By splitting the input to start and end, the algorithm will remove the l,h,r after r if h is the highest in the priority queue
        events = sorted([(l, -h, r) for l, r, h in buildings] + list({(r, 0, 0) for l, r, h in buildings}))
        result = [[0, 0]]
        minHeap = [(0, float('inf'))]

        for l, neg_h, r in events:
            # Even there are residual ones who end later than l, we only care about the highest at position l
            # The highest at position l determines whether we have a corresponding entry in result
            while l >= minHeap[0][1]:
                heapq.heappop(minHeap)

            if neg_h:
                heapq.heappush(minHeap, (neg_h, r))

            if result[-1][1] != -minHeap[0][0]:
                result.append([l, -minHeap[0][0]])

        return result[1:]

    @unittest.skip
    def test_leetcodeTest(self):
        print(self.getSkyline([[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]))

    @unittest.skip
    def test_normalTest(self):
        print(self.getSkyline([[0, 3, 2], [1, 2, 1], [4, 6, 3]]))
        print(self.getSkyline([[0, 3, 2], [2, 4, 1], [5, 6, 1]]))
        print(self.getSkyline([[0, 3, 1], [1, 2, 2], [5, 6, 2]]))
        print(self.getSkyline([[0, 3, 1], [2, 4, 2], [5, 6, 1]]))



if __name__ == '__main__':
    unittest.main()