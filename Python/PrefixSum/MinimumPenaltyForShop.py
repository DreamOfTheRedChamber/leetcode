# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class MinimumPenaltyForShop(unittest.TestCase):

    def bestClosingTime(self, customers: str) -> int:
        openPenalty = [0 for i in range(len(customers) + 1)]
        for i in range(len(customers)):
            currPenalty = 1 if customers[i] == "N" else 0
            openPenalty[i+1] = openPenalty[i] + currPenalty

        closePenalty = [0 for i in range(len(customers) + 1)]
        for j in reversed(range(len(customers))):
            currPenalty = 1 if customers[j] == "Y" else 0
            closePenalty[j] = closePenalty[j+1] + currPenalty

        minPenalty = sys.maxsize
        minTs = 0
        for i in range(len(customers)):
            currPenalty = openPenalty[i] + closePenalty[i]
            if currPenalty < minPenalty:
                minPenalty = currPenalty
                minTs = i

        return minTs

    def test_example1(self):
        self.assertEqual(2, self.bestClosingTime("YYNY"))
        self.assertEqual(0, self.bestClosingTime("NNNNN"))
        self.assertEqual(4, self.bestClosingTime("YYYY"))

if __name__ == '__main__':
    unittest.main()