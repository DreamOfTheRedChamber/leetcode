# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class SoupServings(unittest.TestCase):

    def soupServings(self, N: int) -> float:
        self.dp = dict()

        if N > 5000:
            return 1

        def recursion(A: int, B: int) -> float:

            if A <= 0 and B > 0:
                return 1
            if A <= 0 and B <= 0:
                return 0.5
            if A > 0 and B <= 0:
                return 0

            if (A,B) in self.dp:
                return self.dp[(A,B)]

            result = 0.25 * (recursion(A-100, B) + recursion(A-75, B-25) + recursion(A-50, B-50) + recursion(A-25,B-75))
            self.dp[(A,B)] = result
            return result

        return recursion(N, N)

    def test_Leetcode(self):
        self.assertTrue(0.625, self.soupServings(50))

if __name__ == '__main__':
    unittest.main()