# Definition for a binary tree node.
import heapq
import math
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumOfWaysToDest(unittest.TestCase):

    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        graph = defaultdict(list)
        for a, b, time in roads:
            graph[a].append((time, b))
            graph[b].append((time, a))

        numWays = [0 for i in range(n)]
        dists = [math.inf for i in range(n)]
        numWays[0] = 1
        dists[0] = 0
        bfsQueue = [(0, 0)]
        while bfsQueue:
            dist, node = heapq.heappop(bfsQueue)
            if dist > dists[node]:
                continue
            for neighborDist, neighborNode in graph[node]:
                if dists[neighborNode] > dist + neighborDist:
                    numWays[neighborNode] = numWays[node]
                    dists[neighborNode] = neighborDist + dist
                    heapq.heappush(bfsQueue, (dists[neighborNode], neighborNode))
                elif dists[neighborNode] == dist + neighborDist:
                    numWays[neighborNode] = (numWays[node] + numWays[neighborNode]) % 1_000_000_007

        return numWays[n-1]

    def test_Leetcode(self):
        n = 7
        roads = [[0, 6, 7], [0, 1, 2], [1, 2, 3], [1, 3, 3], [6, 3, 3], [3, 5, 1], [6, 5, 1], [2, 5, 1],
                        [0, 4, 5], [4, 6, 2]]
        self.assertEqual(4, self.countPaths(n, roads))

if __name__ == '__main__':
    unittest.main()