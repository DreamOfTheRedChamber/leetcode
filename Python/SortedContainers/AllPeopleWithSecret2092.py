# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

from sortedcontainers import SortedDict


class AllPeopleWithSecret(unittest.TestCase):

    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        timeToPeople = SortedDict(lambda a: {})
        for meeting in meetings:
            a, b, ts = meeting
            if ts not in timeToPeople:
                timeToPeople[ts] = set()
            timeToPeople[ts].add(a)
            timeToPeople[ts].add(b)

        initial = {0, firstPerson}
        for key, val in timeToPeople.items():
            intersect = initial.intersection(val)
            if intersect:
                initial = initial.union(val)

        return initial

    def test_example1(self):
        n = 6
        meetings = [[1, 2, 5], [2, 3, 8], [1, 5, 10]]
        firstPerson = 1
        # [0,1,2,3,5]
        print(self.findAllPeople(n, meetings, firstPerson))

    def test_example2(self):
        n = 4
        meetings = [[3, 1, 3], [1, 2, 2], [0, 3, 3]]
        firstPerson = 3
        # [0,1,3]
        print(self.findAllPeople(n, meetings, firstPerson))

    def test_example3(self):
        n = 5
        meetings = [[3, 4, 2], [1, 2, 1], [2, 3, 1]]
        firstPerson = 1
        # [0,1,2,3,4]
        print(self.findAllPeople(n, meetings, firstPerson))


if __name__ == '__main__':
    unittest.main()