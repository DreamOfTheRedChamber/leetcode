# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class CountNegativeNumbersInASortedMatrix(unittest.TestCase):

    def countNegatives(self, grid: List[List[int]]) -> int:
        return 0

    def test_Leetcode(self):
        self.assertEqual(8, self.countNegatives([[4, 3, 2, -1], [3, 2, 1, -1], [1, 1, -1, -2], [-1, -1, -2, -3]]))
        self.assertEqual(0, self.countNegatives([[3, 2], [1, 0]]))
        self.assertEqual(3, self.countNegatives([[1, -1], [-1, -1]]))
        self.assertEqual(1, self.countNegatives([[-1]]))

if __name__ == '__main__':
    unittest.main()