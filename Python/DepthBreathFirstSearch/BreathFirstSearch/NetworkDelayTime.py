# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class NetworkDelayTime(unittest.TestCase):

    def networkDelayTime(self, times: List[List[int]], N: int, K: int) -> int:

        # build graph
        graph = defaultdict(list)
        for time in times:
            graph[time[0]].append((time[1], time[2]))

        leastDisToNodes = [sys.maxsize for i in range(N + 1)]

        # bfs queue
        bfsQueue = deque([(K, 0)])
        leastDisToNodes[K] = 0
        while bfsQueue:
            currNode, price = bfsQueue.popleft()
            for node, routePrice in graph[currNode]:
                if leastDisToNodes[node] > price + routePrice:
                    bfsQueue.append((node, price + routePrice))
                    leastDisToNodes[node] = price + routePrice

        # process results
        maxValue = max(leastDisToNodes[1:])
        if maxValue == sys.maxsize:
            return -1
        else:
            return maxValue

    def test_Leetcode(self):
        self.assertEqual(2, self.networkDelayTime([[2,1,1],[2,3,1],[3,4,1]], 4, 2))

    def test_Edgecase(self):
        self.assertEqual(2, self.networkDelayTime([[2, 1, 1], [2, 4, 5], [2, 3, 1], [3, 4, 1]], 4, 2))
        self.assertEqual(-1, self.networkDelayTime([[2, 1, 1], [2, 4, 5], [2, 3, 1], [3, 4, 1]], 4, 1))
        self.assertEqual(-1, self.networkDelayTime([[2, 1, 1], [2, 3, 1]], 4, 1))

if __name__ == '__main__':
    unittest.main()