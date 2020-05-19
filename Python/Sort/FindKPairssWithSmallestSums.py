# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class FindKPairsWithSmallestSums(unittest.TestCase):

    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []

        pq = []
        for index in range(min(len(nums1), k)):
            heapq.heappush(pq, (nums1[index] + nums2[0], index, 0))

        result = []
        for i in range(k):
            if len(pq) == 0:
                break

            sum, index1, index2 = heapq.heappop(pq)
            if index2 + 1 < len(nums2):
                heapq.heappush(pq, (nums1[index1] + nums2[index2 + 1], index1, index2 + 1))

            result.append([nums1[index1], nums2[index2]])

        return result

    def test_Leetcode(self):
        print(self.kSmallestPairs([1, 1, 2], [1, 2, 3], 2))
        print(self.kSmallestPairs([1, 2], [3], 3))

    def test_Edgecase(self):
        print(self.kSmallestPairs([], [2, 4, 6], 3))

    def test_Errorcase(self):
        print(self.kSmallestPairs([1, 7, 11], [2, 4, 6], 3))

if __name__ == '__main__':
    unittest.main()