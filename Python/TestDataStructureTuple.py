# Definition for a binary tree node.
import re
import unittest

# Read about enumerate in python
from collections import namedtuple


class TestDataStructuresTuple(unittest.TestCase):

    @unittest.skip
    def test_CreateNamedTuple(self):
        Point = namedtuple("Point", "x y")
        point = Point(2, 4)
        point

if __name__ == '__main__':
    unittest.main()