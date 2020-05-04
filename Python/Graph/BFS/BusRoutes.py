# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class BusRoutes(unittest.TestCase):

    def numBusesToDestination(self, routes: List[List[int]], S: int, T: int) -> int:
        """
        :type routes: List[List[int]]
        :type S: int
        :type T: int
        :rtype: int
        """
        if S == T:
            return 0

        nodeToRoutes = defaultdict(list)
        for index, route in enumerate(routes):
            for node in route:
                nodeToRoutes[node].append(index)

        discovered = set()
        bfsQueue = deque()
        bfsQueue.append(S)

        levelSize = 1
        nextLevelSize = 0
        depth = 0
        while bfsQueue:
            for i in range(levelSize):
                queueTop = bfsQueue.popleft()
                if queueTop == T:
                    return depth

                for routeIndex in nodeToRoutes[queueTop]:
                    if routeIndex in discovered:
                        continue

                    discovered.add(routeIndex)
                    for node in routes[routeIndex]:
                            bfsQueue.append(node)
                            nextLevelSize += 1

            levelSize = nextLevelSize
            nextLevelSize = 0
            depth += 1

        return -1

    def test_Leetcode(self):
        self.assertEqual(2, self.numBusesToDestination([[1, 2, 7], [3, 6, 7]], 1, 6))

    def test_EdgeCase(self):
        self.assertEqual(-1, self.numBusesToDestination([[1, 2, 7], [3, 6, 4]], 1, 6))

        self.assertEqual(1, self.numBusesToDestination([[1, 6, 7], [3, 6, 7]], 1, 6))
        self.assertEqual(2, self.numBusesToDestination([[1, 2, 3], [2, 4, 5], [3, 5, 6]], 1, 6))
        self.assertEqual(0, self.numBusesToDestination([[1, 2, 3], [2, 4, 5]], 1, 1))

    def test_ErrorCase(self):
        self.assertEqual(1, self.numBusesToDestination([[3,6,15,37,40,41,49,50,53],[5,13,34,38,46,56,58],[50],[12,17,18,24,26,27],[3,11,16,18,23,26,36,46,50,54,56,58],[0,1,7,12,14,18,26,38,42,48],[5,54],[54],[8,17,20,31,35,37,39],[2,5,13,17,24,47,59],[4,12,25,27,44],[1,3,7,19,22,23,36,47,48,49,53,58]], 37, 8))

if __name__ == '__main__':
    unittest.main()