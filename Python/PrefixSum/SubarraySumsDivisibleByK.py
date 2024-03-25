# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class SubarraySumsDivisibleByK(unittest.TestCase):

    def subarraysDivByK(self, A: List[int], K: int) -> int:
        prefixSum = 0
        prefixSumModToNum = defaultdict(int)
        prefixSumModToNum[0] = 1

        result = 0
        for i in range(len(A)):
            prefixSum += A[i]
            prefixSumMod = prefixSum % K
            result += prefixSumModToNum[prefixSumMod]
            prefixSumModToNum[prefixSumMod] += 1

        return result

    def test_Leetcode(self):
        self.assertEqual(7, self.subarraysDivByK([4, 5, 0, -2, -3, 1], 5))


if __name__ == '__main__':
    unittest.main()