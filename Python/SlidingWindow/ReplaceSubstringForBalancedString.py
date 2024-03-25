# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class Template(unittest.TestCase):

    def balancedString(self, s: str) -> int:

        return 0

    def test_Leetcode(self):
        self.assertEqual(0, self.balancedString("QWER"))
        self.assertEqual(1, self.balancedString("QQWE"))
        self.assertEqual(2, self.balancedString("QQQW"))
        self.assertEqual(3, self.balancedString("QQQQ"))

    def test_Edgecase(self):
        self.assertEqual()

if __name__ == '__main__':
    unittest.main()