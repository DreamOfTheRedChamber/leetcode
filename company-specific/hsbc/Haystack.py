"""
You are given a non-empty list of positive integers. You can sum any two consecutive elements to form a single element. The result thus obtained be
"""

import unittest
from collections import defaultdict, Counter
from typing import List

class HayStack(unittest.TestCase):

    def calculateFreqNum(self, hay: str, stack: str) -> int:
        historgram = Counter(stack)
        print(historgram[hay])

    def test_Normal(self):
        hay = "2"
        stack = "132228"
        self.calculateFreqNum(hay, stack)

        return
