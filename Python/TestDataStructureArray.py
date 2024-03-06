# Definition for a binary tree node.
import bisect
import unittest
from dataclasses import dataclass

class TestDataStructureArray(unittest.TestCase):

    def test_createArray(self):

        # create 1d array
        oneD = [0] * 10

        # create 2d array
        visited = [[False for j in range(2)] for i in range(2)]
        visited[0][0] = [True]

        # !!! ERROR PRONE: don't use
        visited2 = [[False] * 2] * 2
        visited2[0][0] = [True]

        # range with different values
        diffValues = [x for x in range(10)]

        return

if __name__ == '__main__':
    unittest.main()