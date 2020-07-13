# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class PreviousPermutationWithOneSwap(unittest.TestCase):

    def prevPermOpt1(self, A: List[int]) -> List[int]:
        i = len(A) - 2
        while i >= 0 and A[i] <= A[i+1]:
            i -= 1
        if i == -1:
            return A

        j = len(A) - 1
        while j >= 0 and A[i] <= A[j]:
            j -= 1
        while j >= 1 and A[j] >= A[j-1]:
            j -= 1

        temp = A[i]
        A[i] = A[j]
        A[j] = temp

        return A

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()