# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumOfGoodSubarrays(unittest.TestCase):

    def countGood(self, nums: List[int], k: int) -> int:
        result = 0
        numOfP = 0
        j = 0
        freqMap = defaultdict(lambda: 0)
        for i in range(len(nums)):
            while numOfP < k and j < len(nums):
                freqMap[nums[j]] += 1
                numOfP += freqMap[nums[j]] - 1
                j += 1

            if numOfP >= k:
                result += len(nums) - j

            freqMap[nums[i]] -= 1
            numOfP -= freqMap[nums[i]] - 1

        return result

    def test_example1(self):
        nums = [1, 1, 1, 1, 1]
        k = 10
        self.assertEqual(1, self.countGood(nums, k))

    def test_example2(self):
        nums = [3,1,4,3,2,2,4]
        k = 2
        self.assertEqual(4, self.countGood(nums, k))

if __name__ == '__main__':
    unittest.main()