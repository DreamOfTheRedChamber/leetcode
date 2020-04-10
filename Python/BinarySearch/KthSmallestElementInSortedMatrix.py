# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class KthSmallestElementInSortedMatrix(unittest.TestCase):

    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        def countLessEqual(matrix: List[List[int]], mid: int, smaller: int, larger: int) -> int:
            count, n = 0, len(matrix)
            row, col = n - 1, 0

            while row >= 0 and col < n:
                if matrix[row][col] > mid:
                    larger = min(larger, matrix[row][col])
                    row -= 1
                else:
                    smaller = max(smaller, matrix[row][col])
                    count += row + 1
                    col += 1

            return count, smaller, larger

        n = len(matrix)
        start, end = matrix[0][0], matrix[n-1][n-1]
        while start < end:
            mid = start + (end - start) / 2
            smaller, larger = (matrix[0][0], matrix[n-1][n-1])

            count, smaller, larger = countLessEqual(matrix, mid, smaller, larger)

            if count == k:
                return smaller
            if count < k:
                start = larger # search higher
            else:
                end = smaller # search lower

        return start

    def test_Test1(self):
        matrix = [
                     [1, 5, 9],
                     [10, 11, 13],
                     [12, 13, 15]
                 ]
        k = 8
        self.assertEqual(13, self.kthSmallest(matrix, 8))



if __name__ == '__main__':
    unittest.main()