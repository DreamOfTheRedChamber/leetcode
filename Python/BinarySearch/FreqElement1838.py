# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class FreqElement(unittest.TestCase):

    def maxFrequency(self, nums: List[int], k: int) -> int:
        if len(nums) <= 1:
            return len(nums)

        nums.sort()

        prefixSum = [0 for i in range(len(nums) + 1)]
        prefixSum[0] = 0
        for i in range(len(nums)):
            prefixSum[i+1] = prefixSum[i] + nums[i]

        lPos = len(prefixSum) - 2
        result = 0
        for rPos in reversed(range(len(prefixSum))):
            winSum = prefixSum[rPos] - prefixSum[lPos]
            while lPos >= 0 and winSum + k >= nums[rPos-1] * (rPos - lPos):
                result = max(result, rPos - lPos)
                lPos -= 1
                winSum = prefixSum[rPos] - prefixSum[lPos]

        return result

    def test_ex1(self):
        self.assertEqual(3, self.maxFrequency([1, 2, 4], 5))
        self.assertEqual(2, self.maxFrequency([1, 4, 8, 13], 5))
        self.assertEqual(1, self.maxFrequency([3, 9, 6], 2))

if __name__ == '__main__':
    unittest.main()