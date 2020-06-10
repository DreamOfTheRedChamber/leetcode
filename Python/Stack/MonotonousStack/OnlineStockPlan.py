# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class StockSpanner:
    def __init__(self):
        self.decStack = []
        self.value = []
        self.index = 0
        return

    def next(self, price: int) -> int:

        while self.decStack and self.value[self.decStack[-1]] <= price:
            self.decStack.pop()

        if len(self.decStack) == 0:
            result = self.index + 1
        else:
            result = self.index - self.decStack[-1]

        self.decStack.append(self.index)
        self.value.append(price)
        self.index += 1

        return result

class OnlineStockPlan(unittest.TestCase):

    def test_Leetcode(self):
        spanner = StockSpanner()
        print([spanner.next(100), spanner.next(80), spanner.next(60), spanner.next(70), spanner.next(60), spanner.next(75), spanner.next(85)])

    def test_Edgecase1(self):
        spanner = StockSpanner()
        print([spanner.next(70), spanner.next(60), spanner.next(40), spanner.next(20), spanner.next(10), spanner.next(80), spanner.next(85)])

    def test_Edgecase2(self):
        spanner = StockSpanner()
        print([spanner.next(10), spanner.next(20), spanner.next(40), spanner.next(60), spanner.next(70), spanner.next(10)])

    def test_ErrorCase(self):
        spanner = StockSpanner()
        print([spanner.next(85), spanner.next(76), spanner.next(43), spanner.next(26), spanner.next(52)])

if __name__ == '__main__':
    unittest.main()