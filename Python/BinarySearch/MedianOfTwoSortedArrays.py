# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MedianOfTwoSortedArrays(unittest.TestCase):

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        def findKthNum(nums1: List[int], nums2: List[int], start1: int, end1: int, start2: int, end2: int, k: int) -> float:
            if end1 - start1 > end2 - start2:
                return findKthNum(nums2, nums1, start2, end2, start1, end1, k)

            if start1 > end1:
                return nums2[start2 + k - 1]

            if k == 1:
                return min(nums1[start1], nums2[start2])

            k1 = min(k//2, end1-start1+1)
            k2 = k - k1
            if nums1[start1 + k1 - 1] < nums2[start2 + k2 - 1]:
                return findKthNum(nums1, nums2, start1 + k1, end1, start2, end2, k - k1)
            else:
                return findKthNum(nums1, nums2, start1, end1, start2 + k2, end2, k - k2)

        if (len(nums1) + len(nums2)) % 2 == 1:
            return findKthNum(nums1, nums2, 0, len(nums1) - 1, 0, len(nums2) - 1, (len(nums1) + len(nums2)) // 2 + 1)
        else:
            sum = findKthNum(nums1, nums2, 0, len(nums1) - 1, 0, len(nums2) - 1, (len(nums1) + len(nums2)) // 2) + findKthNum(nums1, nums2, 0, len(nums1) - 1, 0, len(nums2) - 1, (len(nums1) + len(nums2)) // 2 + 1)
            return sum / 2

    def test_Leetcode(self):
        self.assertEqual(2.0, self.findMedianSortedArrays([1, 3], [2]))
        self.assertEqual(2.5, self.findMedianSortedArrays([1, 2], [3, 4]))

    def test_Edgecase(self):
        self.assertEqual(3, self.findMedianSortedArrays([1, 3, 5], []))

if __name__ == '__main__':
    unittest.main()