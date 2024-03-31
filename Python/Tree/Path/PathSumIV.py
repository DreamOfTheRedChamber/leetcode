# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class PathSumIV(unittest.TestCase):

    def pathSum(self, nums: List[int]) -> int:
        indexToValue = dict()
        leafNodes = []
        for num in reversed(nums):
            numStr = str(num)
            depth, pos, val = int(numStr[0]), int(numStr[1]), int(numStr[2])
            indexToValue[(depth, pos)] = val
            leftChildIndex = (depth + 1, pos * 2 - 1)
            rightChildIndex = (depth + 1, pos * 2)
            if leftChildIndex not in indexToValue and rightChildIndex not in indexToValue:
                leafNodes.append((depth, pos))

        result = 0
        for depth, pos in leafNodes:
            pathSum = 0
            while (depth, pos) in indexToValue:
                pathSum += indexToValue[(depth, pos)]
                (depth, pos) = (depth - 1, (pos + 1) // 2)
            result += pathSum
        return result

    def test_example1(self):
        self.assertEqual(12, self.pathSum([113, 215, 221]))

    def test_example2(self):
        self.assertEqual(4, self.pathSum([113, 221]))

if __name__ == '__main__':
    unittest.main()