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
            right = 0
            windowHisto = defaultdict(lambda: 0)
            for left in range(len(A)):

                while right < len(A) and len(windowHisto) <= K:
                    windowHisto[A[right]] += 1
                    if len(windowHisto) <= K:
                        result += 1
                    right += 1

                if windowHisto[A[left]] == 1:
                    windowHisto.pop(A[left])
                else:
                    windowHisto[A[left]] -= 1


            return result

        return subarrayWithAtMostKDistinct(A, K) - subarrayWithAtMostKDistinct(A, K - 1)

    def test_Leetcode(self):
        self.assertEqual(7, self.subarraysWithKDistinct([1, 2, 1, 2, 3], 2))
        # self.assertEqual(3, self.subarraysWithKDistinct([1, 2, 1, 3, 4], 3))

    @unittest.skip
    def test_Edgecase(self):
        self.assertEqual(0, self.subarraysWithKDistinct([1, 2, 3, 4, 5], 6))
        self.assertEqual(2, self.subarraysWithKDistinct([1, 5, 8], 2))
        self.assertEqual(7, self.subarraysWithKDistinct([1, 5, 8, 7, 4, 6], 6))

if __name__ == '__main__':
    unittest.main()