# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List
import random

class RandomPointInNonOverlappingRectangles(unittest.TestCase):

    def __init__(self, rects: List[List[int]]):
        self.accumSum = [0]
        self.rects = rects
        sum = 0
        for rect in rects:
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1)
            self.accumSum.append(sum)

    def pick(self) -> List[int]:
        n = random.randint(0, self.ranges[-1] - 1)
        i = bisect.bisect(self.ranges, n)
        x1, y1, x2, y2 = self.rects[i - 1]
        n -= self.ranges[i - 1]
        return [x1 + n % (x2 - x1 + 1), y1 + n / (x2 - x1 + 1)]

    def test_LeetCode(self):
        instance = RandomPointInNonOverlappingRectangles([[1,1,5,5]])
        print(instance.pick())



if __name__ == '__main__':
    unittest.main()