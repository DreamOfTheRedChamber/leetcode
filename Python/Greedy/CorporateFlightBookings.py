# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class CorporateFlightBookings(unittest.TestCase):

    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        res = [0] * (n + 1)
        for i, j, k in bookings:
            res[i-1] += k
            res[j] -= k
        for i in range(1, n + 1):
            res[i] += res[i-1]
        return res[:-1]

    def test_Test1(self):
        print(self.corpFlightBookings([[1,2,10],[2,3,20],[2,5,25]], 5))

if __name__ == '__main__':
    unittest.main()