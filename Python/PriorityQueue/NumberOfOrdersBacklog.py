# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumberOfOrdersBacklog(unittest.TestCase):

    def getNumberOfBacklogOrders(self, orders: List[List[int]]) -> int:
        sellMinHeap = []
        buyMaxHeap = []
        for price, amount, orderType in orders:
            if orderType == 0: # buy order
                
            else:

        result = 0
        while sellMinHeap:
            price, amount = heapq.heappop(sellMinHeap)
            result += amount
            result = result % 1000000007
        while buyMaxHeap:
            price, amount = heapq.heappop(buyMaxHeap)
            result += amount
            result = result % 1000000007

        return result

    @unittest.skip
    def test_example1(self):
        # third digit is orderType, 0 for buy and 1 for sell
        orders = [[10, 5, 0], [15, 2, 1], [25, 1, 1], [30, 4, 0]]
        self.assertEqual(6, self.getNumberOfBacklogOrders(orders))

    @unittest.skip
    def test_example2(self):
        orders = [[7, 1000000000, 1], [15, 3, 0], [5, 999999995, 0], [5, 1, 1]]
        self.assertEqual(999999984, self.getNumberOfBacklogOrders(orders))

    def test_example3(self):
        orders = [[6,27,0], [13,7,1], [4,7,1], [19,7,1], [4,22,1]]
        self.assertEqual(16, self.getNumberOfBacklogOrders(orders))


if __name__ == '__main__':
    unittest.main()