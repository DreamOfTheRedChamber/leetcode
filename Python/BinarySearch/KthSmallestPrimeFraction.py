# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class KthSmallestPrimeFraction(unittest.TestCase):

    def kthSmallestPrimeFraction(self, A: List[int], K: int) -> List[int]:
        def count(tar):
            res,tmp = 0, [0,A[-1]]
            for i in range(len(A)):
                loc = bisect.bisect_left(A,A[i]/tar)
                res += len(A) - loc
                if loc < len(A) and A[i]/A[loc] > tmp[0]/tmp[1]:
                    tmp = [A[i],A[loc]]
            return res, tmp

        right = 1
        left = 0

        result = [0, A[-1]]
        while left < right:
            mid = (left + right) / 2
            totalCount, result = count(mid)
# Always wrong for test case 3)
#            totalCount = 0
#            for i in range(len(A)):
#                insertPos = bisect.bisect_left(A, A[i] / mid)
#                totalCount += len(A) - insertPos
#                if insertPos < len(A) and A[i]/A[insertPos] > result[0] / result[1]:
#                    result = [A[i], A[insertPos]]

            if totalCount == K:
                break
            elif totalCount < K:
                left = mid
            else:
                right = mid

        return result

    @unittest.skip
    def test_Leetcode(self):
        print(self.kthSmallestPrimeFraction([1, 2, 3, 5], 3))
        print(self.kthSmallestPrimeFraction([1, 7], 1))

    @unittest.skip
    def test_WrongAnswer1(self):
        print(self.kthSmallestPrimeFraction([1, 2, 3, 5], 3))

    def test_WrongAnswer2(self):
        print(self.kthSmallestPrimeFraction([1, 13, 17, 59], 6))  # [13,17] expected

    def test_WrongAnswer3(self):
        print(self.kthSmallestPrimeFraction([1, 29, 47], 1)) # [1, 47] expected

if __name__ == '__main__':
    unittest.main()