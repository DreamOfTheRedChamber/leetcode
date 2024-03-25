# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class ConstrainedSubsequenceSum(unittest.TestCase):

    def printVertically(self, s: str) -> list:
        return []

    def test_Test1(self):
        str1 = "TO BE OR NOT TO BE"
        print(self.printVertically(str1))

        str2 = "HOW ARE YOU"
        print(self.printVertically(str2))


    def test_Test1(self):
        self.assertEqual(2, self.longestSubarray([8, 2, 4, 7], 4))


if __name__ == '__main__':
    unittest.main()