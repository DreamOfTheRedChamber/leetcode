# Definition for a binary tree node.
import sys
import unittest
from collections import defaultdict, deque
from typing import List

class ParallelCourseIII(unittest.TestCase):

    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        outdegreeMap = defaultdict(set)
        indegreeNumMap = defaultdict(lambda: 0)
        for relation in relations:
            outdegreeMap[relation[0]].add(relation[1])
            indegreeNumMap[relation[1]] += 1


        minTimeDict = defaultdict(lambda: 0)
        for i in range(len(time)):
            minTimeDict[i+1] = time[i]

        bfsQueue = deque()
        for i in range(1, n+1):
            if i not in indegreeNumMap:
                bfsQueue.append(i)

        while bfsQueue:
            index = bfsQueue.popleft()
            neighbors = outdegreeMap[index]
            for neigh in neighbors:
                indegreeNumMap[neigh] -= 1
                minTimeDict[neigh] = max(minTimeDict[index] + time[neigh-1], minTimeDict[neigh])
                if indegreeNumMap[neigh] == 0:
                    bfsQueue.append(neigh)

        return max(minTimeDict.values())

    def test_example1(self):
        n = 3
        relations = [[1, 3], [2, 3]]
        time = [3, 2, 5]
        self.assertEqual(8, self.minimumTime(n, relations, time))

    def test_example2(self):
        n = 5
        relations = [[1, 5], [2, 5], [3, 5], [3, 4], [4, 5]]
        time = [1, 2, 3, 4, 5]
        self.assertEqual(12, self.minimumTime(n, relations, time))


if __name__ == '__main__':
    unittest.main()