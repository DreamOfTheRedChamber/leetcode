# Definition for a binary tree node.
import collections
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

    def union(self, a: int, b: int, parents: List[int], ranks: List[int]):
        rootA = self.find(parents, a)
        rootB = self.find(parents, b)
        if rootA == rootB:
            return
        else:
            if ranks[rootA] > ranks[rootB]:
                parents[rootB] = rootA
                ranks[rootA] = ranks[rootB] + ranks[rootA]
            else:
                parents[rootA] = rootB
                ranks[rootB] = ranks[rootB] + ranks[rootA]

        return

    def find(self, parents: List[int], target: int) -> int:
        if parents[target] == target:
            return target
        else:
            return self.find(parents, parents[target])

    def findAllPeopleWithUnionFind(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        meetings.sort(key=lambda x: x[2])
        histogram = SortedDict()
        for a, b, ts in meetings:
            if ts not in histogram:
                histogram[ts] = 0
            histogram[ts] += 1

        parents = [i for i in range(n)]
        ranks = [1 for i in range(n)]
        self.union(0, firstPerson, parents, ranks)

        known = {0, firstPerson}
        pos = 0
        for key, val in histogram.items():
            keySet = set()
            for i in range(pos, pos + val):
                a, b, ts = meetings[i]
                keySet.add(a)
                keySet.add(b)

            if keySet.intersection(known):
                known = keySet.union(known)
                for i in range(pos, pos + val):
                    a, b, ts = meetings[i]
                    self.union(a, b, parents, ranks)

            pos += val

        result = []
        source = self.find(parents, firstPerson)
        for i in range(n):
            if self.find(parents, i) == source:
                result.append(i)

        return result

    def test_example1(self):
        n = 6
        meetings = [[1, 2, 5], [2, 3, 8], [1, 5, 10]]
        firstPerson = 1
        # [0,1,2,3,5]
        print(self.findAllPeople(n, meetings, firstPerson))
        print(self.findAllPeopleWithUnionFind(n, meetings, firstPerson))

    def test_example2(self):
        n = 4
        meetings = [[3, 1, 3], [1, 2, 2], [0, 3, 3]]
        firstPerson = 3
        # [0,1,3]
        print(self.findAllPeople(n, meetings, firstPerson))
        print(self.findAllPeopleWithUnionFind(n, meetings, firstPerson))

    def test_example3(self):
        n = 5
        meetings = [[3, 4, 2], [1, 2, 1], [2, 3, 1]]
        firstPerson = 1
        # [0,1,2,3,4]
        print(self.findAllPeople(n, meetings, firstPerson))
        print(self.findAllPeopleWithUnionFind(n, meetings, firstPerson))

    def test_example4(self):
        n = 6
        meetings = [[0,2,1],[1,3,1],[4,5,1]]
        firstPerson = 1
        # [0,1,2,3]
        print(self.findAllPeople(n, meetings, firstPerson))
        print(self.findAllPeopleWithUnionFind(n, meetings, firstPerson))

if __name__ == '__main__':
    unittest.main()