# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class LongestArithmeticSequence(unittest.TestCase):

    def longestArithSeqLength(self, A: List[int]) -> int:
        longest = 0
        diffToLengthAtIndex = [{} for x in range(len(A))]
        for i in range(1, len(A)):
            for j in range(0, i):
                diff = A[i] - A[j]
                if diff in diffToLengthAtIndex[j]:
                    diffToLengthAtIndex[i][diff] = diffToLengthAtIndex[j][diff] + 1
                else:
                    diffToLengthAtIndex[i][diff] = 2
                longest = max(longest, diffToLengthAtIndex[i][diff])

        return longest

    def test_Leetcode(self):
        self.assertEqual(4, self.longestArithSeqLength([3, 6, 9, 12]))
        self.assertEqual(3, self.longestArithSeqLength([9, 4, 7, 2, 10]))
        self.assertEqual(4, self.longestArithSeqLength([20, 1, 15, 3, 10, 5, 8]))

if __name__ == '__main__':
    unittest.main()