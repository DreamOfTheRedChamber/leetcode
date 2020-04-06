# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class BrickWall(unittest.TestCase):

    def leastBricks(self, wall: List[List[int]]) -> int:

        edgePos = defaultdict(lambda: 0)
        for row in wall:
            length = 0
            for brick in row[:-1]:
                length += brick
                edgePos[length] += 1
        if not edgePos:
            return len(wall)

        return len(wall) - max(edgePos.values())

    @unittest.skip
    def test_Test1(self):
        self.assertEqual(2, self.leastBricks([[1,2,2,1], [3,1,2], [1,3,2], [2,4], [3,1,2], [1,3,1,1]]))

    def test_Error(self):
        self.assertEqual(3, self.leastBricks([[1], [1], [1]]))

if __name__ == '__main__':
    unittest.main()