# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MaxTastiness(unittest.TestCase):

    def isPossible(self, dis: int, price: List[int], k: int) -> bool:
        numCand = 1
        start = price[0]
        for item in price:
            if item >= start + dis:
                start = item
                numCand += 1

        if numCand >= k:
            return True
        else:
            return False

    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()
        end = max(price) - min(price)
        start = 1
        while start + 1 < end:
            mid = (end - start) // 2 + start
            if self.isPossible(mid, price, k):
                start = mid
            else:
                end = mid

        if self.isPossible(end, price, k):
            return end
        else:
            return start

    def test_example1(self):
        price = [13, 5, 1, 8, 21, 2]
        k = 3
        self.assertEqual(8, self.maximumTastiness(price, k))

    def test_example2(self):
        price = [1, 3, 1]
        k = 2
        self.assertEqual(2, self.maximumTastiness(price, k))

    def test_example3(self):
        price = [7, 7, 7, 7]
        k = 2
        self.assertEqual(0, self.maximumTastiness(price, k))

if __name__ == '__main__':
    unittest.main()