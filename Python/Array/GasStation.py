# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List

# Todo: Find a one pass solution

class GasStation(unittest.TestCase):

    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        total = 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]
        if total < 0:
            return -1

        result = 0
        total = 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]
            if total < 0:
                result = i + 1
                total = 0

        return result

    def test_Leetcode(self):
        self.assertEqual(3, self.canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2]))
        self.assertEqual(-1, self.canCompleteCircuit([2, 3, 4], [3, 4, 3]))

    def test_EdgeAnswer(self):
        # multiple answers, first one to return?
        self.assertEqual(0, self.canCompleteCircuit([4, 2, 1], [2, 4, 1]))

        self.assertEqual(2, self.canCompleteCircuit([1, 1, 5], [4, 2, 1]))

if __name__ == '__main__':
    unittest.main()