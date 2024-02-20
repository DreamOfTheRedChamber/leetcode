# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List
from sortedcontainers import SortedSet, SortedList


class MyCalendarThree:
    def __init__(self):
        self.sortedBoundaries = SortedList(key=lambda x: (x[0], x[1]))
        return

    def book(self, start: int, end: int) -> int:
        self.sortedBoundaries.add((start, 1))
        self.sortedBoundaries.add((end, -1))

        count = 0
        maxIntersect = 0
        for point in self.sortedBoundaries:
            if point[1] == 1:
                count += 1
                maxIntersect = max(maxIntersect, count)
            else:
                count -= 1
        return maxIntersect

class MyCalendarIII(unittest.TestCase):

    def test_Leetcode(self):
        myCalendar = MyCalendarThree()
        print(myCalendar.book(10, 20))
        print(myCalendar.book(50, 60))
        print(myCalendar.book(10, 40))
        print(myCalendar.book(5, 15))
        print(myCalendar.book(5, 10))
        print(myCalendar.book(25, 55))

if __name__ == '__main__':
    unittest.main()