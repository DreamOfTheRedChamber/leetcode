# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class DeleteTreeNodes(unittest.TestCase):

    def deleteTreeNodes(self, nodes: int, parent: List[int], value: List[int]) -> int:

        def traverseSubtree(root: int, directedGraph: defaultdict(set), value: List[int]) -> (int, int):
            if len(directedGraph[root]) == 0:
                return value[root], 1

            totalSum = value[root]
            totalCount = 1
            for child in directedGraph[root]:
                subtreeSum, subtreeCount = traverseSubtree(child, directedGraph, value)
                if subtreeSum != 0:
                    totalSum += subtreeSum
                    totalCount += subtreeCount
            #    else:
            #        directedGraph[root].remove(child)

            return totalSum, totalCount

        directedGraph = defaultdict(set)
        root = 0
        for index, val in enumerate(parent):
            if value != -1:
                directedGraph[val].add(index)
            else:
                root = index

        totalSum, totalCount = traverseSubtree(root, directedGraph, value)
        return totalCount

    def test_NormalTest(self):
        self.assertEqual(2, self.deleteTreeNodes(7, [-1, 0, 0, 1, 2, 2, 2], [1, -2, 4, 0, -2, -1, -1]))

if __name__ == '__main__':
    unittest.main()