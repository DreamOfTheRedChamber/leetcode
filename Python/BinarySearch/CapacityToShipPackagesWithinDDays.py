# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class CapacityToShipPackagesWithinDDays(unittest.TestCase):

    def shipWithinDays(self, weights: List[int], D: int) -> int:

        def couldShip(capacity: int, days: int) -> bool:
            usedDays = 0
            used = 0
            i = 0
            while i < len(weights):
                if weights[i] > capacity:
                    return False
                elif used + weights[i] > capacity:
                    usedDays += 1
                    used = 0
                else:
                    used += weights[i]
                    i += 1

            if used > 0:
                usedDays += 1

            return True if usedDays <= days else False

        left = max(weights)
        right = sum(weights)

        while left + 1 < right:
            mid = (right - left) // 2 + left
            if couldShip(mid, D):
                right = mid
            else:
                left = mid

        return left if couldShip(left, D) else right

    def test_Leetcode(self):
        self.assertEqual(15, self.shipWithinDays([1,2,3,4,5,6,7,8,9,10], 5))
        self.assertEqual(6, self.shipWithinDays([3,2,2,4,1,4], 3))
        self.assertEqual(3, self.shipWithinDays([1,2,3,1,1], 4))

if __name__ == '__main__':
    unittest.main()