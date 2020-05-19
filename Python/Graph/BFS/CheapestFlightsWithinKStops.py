# Definition for a binary tree node.

import unittest
from collections import deque, defaultdict
from typing import List


class CheapestFlightsWithinKStops(unittest.TestCase):

    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, K: int) -> int:

        if K <= -1:
            return -1

        graph = defaultdict(list)
        for start, end, price in flights:
            graph[start].append((end, price))

        bfsQueue = deque()
        priceQueue = deque()
        nodeToCheapest = defaultdict(lambda: float('inf'))

        bfsQueue.append(src)
        priceQueue.append(0)
        depth = 0

        result = float('inf')
        while bfsQueue and depth <= K + 1:
            for i in range(len(bfsQueue)):
                head = bfsQueue.popleft()
                headPrice = priceQueue.popleft()
                if head == dst:
                    result = min(result, headPrice)
                else:
                    if headPrice >= nodeToCheapest[head]:
                        continue
                    else:
                        nodeToCheapest[head] = headPrice
                        for nextDst, flightPrice in graph[head]:
                            bfsQueue.append(nextDst)
                            priceQueue.append(headPrice + flightPrice)

            depth += 1

        return result if result < float('inf') else -1

    def test_Leetcode(self):
        self.assertEqual(200, self.findCheapestPrice(3, [[0, 1, 100], [1, 2, 100], [0, 2, 500]], 0, 2, 1))
        self.assertEqual(500, self.findCheapestPrice(3, [[0, 1, 100], [1, 2, 100], [0, 2, 500]], 0, 2, 0))

    def test_Edgecase(self):
        self.assertEqual(-1, self.findCheapestPrice(4, [[0, 1, 100], [1, 2, 100], [0, 2, 500]], 0, 3, 1))


if __name__ == '__main__':
    unittest.main()