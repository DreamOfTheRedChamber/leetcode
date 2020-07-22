# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class SubarraysWithKDifferentIntegers(unittest.TestCase):

    def subarraysWithKDistinct(self, A: List[int], K: int) -> int:

        def subarrayWithAtMostKDistinct(A: List[int], K: int) -> int:

            result = 0
            left = 0
            windowHisto = defaultdict(lambda: 0)
            for right in range(len(A)):
                windowHisto[A[right]] += 1

                if len(windowHisto) <= K:
                    result += right - left + 1
                else:
                    while len(windowHisto) > K:
                        windowHisto[A[left]] -= 1
                        if windowHisto[A[left]] == 0:
                            windowHisto.pop(A[left])
                        left += 1
                    result += right - left + 1

            return result

        answerK = subarrayWithAtMostKDistinct(A, K)
        answerKMinusOne = subarrayWithAtMostKDistinct(A, K - 1)

        return answerK - answerKMinusOne

    def test_Leetcode(self):
        # self.assertEqual(3, self.subarraysWithKDistinct([1, 4, 3], 2))
        self.assertEqual(7, self.subarraysWithKDistinct([1, 2, 1, 2, 3], 2))
        # self.assertEqual(3, self.subarraysWithKDistinct([1, 2, 1, 3, 4], 3))

    @unittest.skip
    def test_Edgecase(self):
        self.assertEqual(0, self.subarraysWithKDistinct([1, 2, 3, 4, 5], 6))
        self.assertEqual(2, self.subarraysWithKDistinct([1, 5, 8], 2))
        self.assertEqual(7, self.subarraysWithKDistinct([1, 5, 8, 7, 4, 6], 6))

if __name__ == '__main__':
    unittest.main()