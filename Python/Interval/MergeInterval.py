# Definition for a binary tree node.
import unittest
# Read about enumerate in python
from typing import List

class MergeInterval(unittest.TestCase):

    def test_Normal(self):
        # expect [1, 9], [10, 12]
        result = self.merge([[1, 3], [2, 6], [6, 9], [10, 12]])

        # expect [-1, 9], [10, 12]
        result = self.merge([[1, 3], [-1, 7], [6, 9], [10, 12]])
        return

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        points = []
        for interval in intervals:
            points.append((interval[0], 1))
            points.append((interval[1], -1))
        points.sort(key=lambda x: (x[0], -x[1]))

        result = []
        count = 0
        left = 0
        right = 0
        for point in points:
            if point[1] == 1:
                count += 1
                if count == 1:
                    left = point[0]
            else:
                count -= 1
                if count == 0:
                    right = point[1]
                    result.append([left, right])

        return result

if __name__ == '__main__':
    unittest.main()