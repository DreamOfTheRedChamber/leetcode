# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class Search2DMatrixII(unittest.TestCase):

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False

        xCor = 0
        yCor = len(matrix[0]) - 1
        while xCor < len(matrix) and yCor >= 0:
            if matrix[xCor][yCor] > target:
                yCor -= 1
            elif matrix[xCor][yCor] < target:
                xCor += 1
            else:
                return True

        return False

    def test_Leetcode(self):
        array = [[1,   4,  7, 11, 15],
                 [2,   5,  8, 12, 19],
                 [3,   6,  9, 16, 22],
                 [10, 13, 14, 17, 24],
                 [18, 21, 23, 26, 30]]
        self.assertTrue(self.searchMatrix(14, array))
        self.assertTrue(self.searchMatrix(30, array))
        self.assertTrue(self.searchMatrix(18, array))

        self.assertFalse(self.searchMatrix(27, array))
        self.assertFalse(self.searchMatrix(34, array))
        self.assertFalse(self.searchMatrix(0, array))

    def test_edgecase(self):
        array = [[0, 3]]
        self.assertFalse(self.searchMatrix(5, array))

        array2 = [[0], [3]]
        self.assertTrue(self.searchMatrix(3, array2))

        array3 = [[1]]
        self.assertTrue(self.searchMatrix(1, array3))


if __name__ == '__main__':
    unittest.main()