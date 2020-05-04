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
        discovered.add(S)

        levelSize = 1
        nextLevelSize = 0
        depth = 0
        while bfsQueue:
            for i in range(levelSize):
                queueTop = bfsQueue.popleft()
                if queueTop != T:
                    return depth

                for routeIndex in nodeToRoutes[queueTop]:
                    for node in routes[routeIndex]:
                        if node not in discovered:
                            bfsQueue.append(node)
                            discovered.add(node)
                            nextLevelSize += 1

            levelSize = nextLevelSize
            nextLevelSize = 0
            depth += 1

        return depth

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual(2, self.numBusesToDestination([[1, 2, 7], [3, 6, 7]], 1, 6))

    def test_EdgeCase(self):
        self.assertEqual(-1, self.numBusesToDestination([[1, 2, 7], [3, 6, 4]], 1, 6))

        # self.assertEqual(1, self.numBusesToDestination([[1, 2, 7], [3, 6, 7]], 1, 6))
        # self.assertEqual(2, self.numBusesToDestination([[1, 2, 3], [2, 4, 5], [3, 5, 6]], 1, 6))
        # self.assertEqual(0, self.numBusesToDestination([[1, 2, 3], [2, 4, 5]], 1, 1))

if __name__ == '__main__':
    unittest.main()