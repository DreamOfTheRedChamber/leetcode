# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List, OrderedDict

from sortedcontainers import SortedDict


class AllPeopleWithSecret(unittest.TestCase):

    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        personToMeets = defaultdict(list)
        for a, b, ts in meetings:
            personToMeets[a].append((b, ts))
            personToMeets[b].append((a, ts))

        personToMeets[0].append((firstPerson, 0))
        personToMeets[firstPerson].append((0, 0))
        bfsQueue = deque([(0, 0), (firstPerson, 0)])
        knowTs = [sys.maxsize for i in range(n)]
        while bfsQueue:
            person, ts = bfsQueue.popleft()
            for neighbor, neighborTs in personToMeets[person]:
                if neighborTs >= ts and knowTs[neighbor] > neighborTs:
                    bfsQueue.append((neighbor, neighborTs))
                    knowTs[neighbor] = neighborTs

        result = []
        for i in range(n):
            if knowTs[i] != sys.maxsize:
                result.append(i)

        return result

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

    def test_example4(self):
        n = 6
        meetings = [[0,2,1],[1,3,1],[4,5,1]]
        firstPerson = 1
        # [0,1,2,3]
        print(self.findAllPeople(n, meetings, firstPerson))


if __name__ == '__main__':
    unittest.main()