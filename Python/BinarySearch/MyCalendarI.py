# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MyCalendarI(unittest.TestCase):

    def __init__(self):
        self.starts = []
        self.ends = []

    def book(self, start, end):
        i = bisect.bisect_left(self.starts, start)
        if i - 1 >= 0:
            if start < self.ends[i - 1]:
                return False
        if i < len(self.starts):
            if end > self.starts[i]:
                return False
        self.starts.insert(i, start)
        self.ends.insert(i, end)
        return True

    def test_Leetcode(self):
        myCalendar = MyCalendarI()
        self.assertTrue(myCalendar.book(10, 20))
        self.assertFalse(myCalendar.book(15, 25))
        self.assertTrue(myCalendar.book(20, 30))

if __name__ == '__main__':
    unittest.main()