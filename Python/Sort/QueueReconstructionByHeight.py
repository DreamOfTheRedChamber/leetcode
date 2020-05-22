# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class QueueReconstructionByHeight(unittest.TestCase):

    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))

        result = []
        for p in people:
            result.insert(p[1], p)

        return result

    def test_Leetcode(self):
        print(self.reconstructQueue([[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]))

if __name__ == '__main__':
    unittest.main()