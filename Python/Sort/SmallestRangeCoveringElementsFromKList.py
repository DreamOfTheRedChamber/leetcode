# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List


class SmallestRangeCoveringElementsFromKList(unittest.TestCase):

    def smallestRange(self, nums: List[List[int]]) -> List[int]:

        heap = []
        kMax = float('-inf')
        for index, oneList in enumerate(nums):
            if len(oneList) <= 0:
                raise Exception("illegal argument exception")
            else:
                heapq.heappush(heap, (oneList[0], index, 0))
                kMax = max(kMax, oneList[0])

        resultRange = (0, float('inf'))
        while heap:
            kMin, rowIndex, colIndex = heapq.heappop(heap)
            if kMax - kMin < resultRange[1] - resultRange[0]:
                resultRange = (kMin, kMax)
            if colIndex + 1 < len(nums[rowIndex]):
                kMax = max(nums[rowIndex][colIndex + 1], kMax)
                heapq.heappush(heap, (nums[rowIndex][colIndex + 1], rowIndex, colIndex + 1))
            else:
                break

        return resultRange

    def test_Leetcode(self):
        print(self.smallestRange([[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]))

if __name__ == '__main__':
    unittest.main()