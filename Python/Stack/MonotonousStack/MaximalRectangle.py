# Definition for a binary tree node.
import unittest
from typing import List

class MaximalRectangle(unittest.TestCase):

    def test_MonoIncreasing(self):
        self.assertEqual(12, self.largestRectangleArea([1, 2, 3, 4, 5, 6]))

    def test_Leetcode(self):
        result = [
            ["1","0","1","0","0"],
            ["1","0","1","1","1"],
            ["1","1","1","1","1"],
            ["1","0","0","1","0"]
        ]
        self.assertEqual(6, self.maximalRectangle(result))

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0

        histogram = [[0 for i in range(len(matrix[0]))] for j in range(len(matrix))]
        for j in range(len(matrix[0])):
            histogram[0][j] = 0 if matrix[0][j] == "0" else 1

        for j in range(len(matrix[0])):
            for i in range(1, len(matrix)):
                histogram[i][j] = 1 + histogram[i-1][j] if matrix[i][j] == "1" else 0

        result = 0
        for i in range(0, len(matrix)):
            result = max(result, self.largestRectangleArea(histogram[i][:]))

        return result

    def largestRectangleArea(self, heights: list) -> int:
        incStack = []
        heights.append(0)

        result = 0
        for i in range(len(heights)):
            while incStack and heights[incStack[-1]] > heights[i]:
                head = incStack.pop()
                if not incStack:
                    result = max(result, i * heights[head])
                else:
                    result = max(result, (i - 1 - incStack[-1]) * heights[head])
            incStack.append(i)

        return result

if __name__ == '__main__':
    unittest.main()