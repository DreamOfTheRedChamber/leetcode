# Definition for a binary tree node.
import collections
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ReplaceTheSubstringForBalancedString(unittest.TestCase):

    def balancedString(self, s: str) -> int:

        histogram = collections.Counter(s)
        result = n = len(s)
        left = 0
        for right, rightValue in enumerate(s):
            histogram[rightValue] -= 1
            while left < n and all(n / 4 >= histogram[value] for value in "QWER"):
                result = min(result, right - left + 1)
                histogram[s[left]] += 1
                left += 1

        return result

    def test_Leetcode(self):
        self.assertEqual(0, self.balancedString("QWER"))
        self.assertEqual(1, self.balancedString("QQWE"))
        self.assertEqual(2, self.balancedString("QQQW"))
        self.assertEqual(3, self.balancedString("QQQQ"))

if __name__ == '__main__':
    unittest.main()