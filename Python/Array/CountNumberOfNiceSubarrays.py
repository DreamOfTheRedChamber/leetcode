# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class CountNumberOfNiceSubArrays(unittest.TestCase):

    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        numOfOddsToCount = defaultdict(int)
        numOfOddsToCount[0] = 1
        numOfOdds = 0
        result = 0

        for i in range(len(nums)):
            if nums[i] % 2 == 1:
                numOfOdds += 1
            if numOfOddsToCount[numOfOdds - k] != 0:
                result += numOfOddsToCount[numOfOdds - k]

            numOfOddsToCount[numOfOdds] += 1

        return result

    def test_Leetcode(self):
        self.assertEqual(2, self.numberOfSubarrays([1, 1, 2, 1, 1], 3))
        self.assertEqual(0, self.numberOfSubarrays([2, 4, 6], 1))
        self.assertEqual(16, self.numberOfSubarrays([2, 2, 2, 1, 2, 2, 1, 2, 2, 2], 2))

if __name__ == '__main__':
    unittest.main()