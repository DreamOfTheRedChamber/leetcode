# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class CheapestFlightWithKStops(unittest.TestCase):

    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:
        nodeToNeighbors = defaultdict(list)
        for flight in flights:
            nodeToNeighbors[flight[0]].append((flight[1], flight[2]))

        cheapestPrices = defaultdict(lambda: float('inf'))
        bfsQueue = deque()
        bfsQueue.append((src, 0))
        depth = 0
        while bfsQueue:
            if depth > K:
                break

            for i in range(len(bfsQueue)):
                node, accumulatedPrice = bfsQueue.popleft()
                for neighbor in nodeToNeighbors[node]:
                    neighborPrice = accumulatedPrice + neighbor[1]
                    if neighborPrice < cheapestPrices[neighbor[0]]:
                        cheapestPrices[neighbor[0]] = neighborPrice
                        bfsQueue.append(((neighbor[0], neighborPrice)))

            depth += 1

        return cheapestPrices[dst] if cheapestPrices[dst] < float('inf') else -1

    def test_Leetcode(self):
        self.assertEqual(200, self.findCheapestPrice(3, [[0,1,100], [1,2,100], [0,2,500]], 0, 2, 1))
        self.assertEqual(500, self.findCheapestPrice(3, [[0,1,100], [1,2,100], [0,2,500]], 0, 2, 0))

    def test_EdgeCase(self):
        self.assertEqual(200, self.findCheapestPrice(3, [[0,1,100], [1,2,100], [0,2,500]], 0, 2, 2))
        self.assertEqual(-1, self.findCheapestPrice(3, [[0,1,100], [1,2,100], [0,2,500]], 2, 1, 2))

if __name__ == '__main__':
    unittest.main()