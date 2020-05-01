# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ArithmeticSlicesII(unittest.TestCase):

    def numberOfArithmeticSlices(self, A: List[int]) -> int:
        listOfDisToNumMap = [defaultdict(int) for item in A]
        totalCount = 0
        for i in range(1, len(A)):
            for j in range(i):
                dis = A[i] - A[j]
                listOfDisToNumMap[i][dis] += 1
                if dis in listOfDisToNumMap[j]:
                    listOfDisToNumMap[i][dis] += listOfDisToNumMap[j][dis]
                    totalCount += listOfDisToNumMap[j][dis]

        return totalCount

    def test_Leetcode(self):
        self.assertEqual(7, self.numberOfArithmeticSlices([2, 4, 6, 8, 10]))

    def test_EdgeCase(self):
        self.assertEqual(0, self.numberOfArithmeticSlices([1, 4]))
        self.assertEqual(0, self.numberOfArithmeticSlices([1, 4, 8]))
        self.assertEqual(3, self.numberOfArithmeticSlices([1, 4, 7, 10]))

        self.assertEqual(2, self.numberOfArithmeticSlices([0, 2, 2, 4]))


if __name__ == '__main__':
    unittest.main()