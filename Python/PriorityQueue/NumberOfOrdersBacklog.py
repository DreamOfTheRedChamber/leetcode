# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumberOfOrdersBacklog(unittest.TestCase):

    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        return 1

    def test_example1(self):
        orders = [[10, 5, 0], [15, 2, 1], [25, 1, 1], [30, 4, 0]]
        self.assertEqual(6, self.getNumberOfBacklogOrders(orders))

    def test_example2(self):
        orders = [[7, 1000000000, 1], [15, 3, 0], [5, 999999995, 0], [5, 1, 1]]
        self.assertEqual(6999999984, self.getNumberOfBacklogOrders(orders))

if __name__ == '__main__':
    unittest.main()