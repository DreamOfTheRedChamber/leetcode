# Definition for a binary tree node.
import collections
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ConvertTo2DArray(unittest.TestCase):

    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        freqMap = collections.Counter(nums)
        totalNum = len(nums)
        result = []
        while totalNum > 0:
            newLine = []
            for key, value in freqMap.items():
                if value > 0:
                    newLine.append(key)
                    freqMap[key] -= 1
                    totalNum -= 1
            result.append(newLine)
        return result

    def test_example1(self):
        nums = [1, 3, 4, 1, 2, 3, 1]
        # [[1,3,4,2],[1,3],[1]]
        print(self.findMatrix(nums))

    def test_example2(self):
        nums = [1, 2, 3, 4]
        # [[4,3,2,1]]
        print(self.findMatrix(nums))

if __name__ == '__main__':
    unittest.main()