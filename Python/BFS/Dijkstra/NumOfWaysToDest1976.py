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
            for neighborDist, neighborNode in graph[node]:
                if dists[neighborNode] > dist + neighborDist:
                    numWays[neighborNode] = numWays[node]
                    dists[neighborNode] = dists[node] + dist
                    heapq.heappush(bfsQueue, (neighborDist, neighborNode))
                elif dists[neighborNode] == dist + neighborDist:
                    numWays[neighborNode] = (numWays[node] + numWays[neighborNode]) % (pow(10, 9) + 7)

        return numWays[n-1]

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()