# Definition for a binary tree node.
import heapq
import unittest

# Please look at the circlesQuestion.jpg for details. 
# Math explanation:
# 1. https://mathworld.wolfram.com/Circle-CircleIntersection.html
# 2. https://www.geeksforgeeks.org/area-of-intersection-of-two-circles/

# Read about enumerate in python
from collections import defaultdict
from math import floor, sin, acos, sqrt
from typing import List

class IntersectionOfCircles(unittest.TestCase):

    # Function to return area of intersection
    def intersectionArea(self, X1, Y1, R1, X2, Y2, R2):

        Pi = 3.14

        # Calculate the euclidean distance
        # between the two points
        d = sqrt(((X2 - X1) * (X2 - X1)) + ((Y2 - Y1) * (Y2 - Y1)))
        result = 0

        if d > R1 + R2:
            result = 0

        elif d <= (R1 - R2) and R1 >= R2:
            result = Pi * R2 * R2

        elif d <= (R2 - R1) and R2 >= R1:
            result = Pi * R1 * R1

        else:
            alpha = acos(((R1 * R1) + (d * d) - (R2 * R2)) / (2 * R1 * d)) * 2
            beta = acos(((R2 * R2) + (d * d) - (R1 * R1)) / (2 * R2 * d)) * 2

            a1 = (0.5 * beta * R2 * R2) - (0.5 * R2 * R2 * sin(beta))
            a2 = (0.5 * alpha * R1 * R1) - (0.5 * R1 * R1 * sin(alpha))
            result = a1 + a2

        return round(result, 6)

    def test_example2(self):
        # input
        # 0
        # 0
        # 2
        # 3
        # 0
        # 2
        # output:
        # 1.813247
        self.assertEqual(7.252988, self.intersectionArea(0, 0, 4, 6, 0, 4))
        return

    def test_example1(self):
        # input
        # 0
        # 0
        # 2
        # 3
        # 0
        # 2
        # output:
        # 1.813247
        self.assertEqual(1.813247, self.intersectionArea(0, 0, 2, 3, 0, 2))
        return

    def test_getInput(self):
        x1 = int(input().strip())
        y1 = int(input().strip())
        r1 = int(input().strip())
        x2 = int(input().strip())
        y2 = int(input().strip())
        r2 = int(input().strip())
        self.assertEqual(1.813247, self.intersectionArea(x1, y1, r1, x2, y2, r2))

if __name__ == '__main__':
    unittest.main()