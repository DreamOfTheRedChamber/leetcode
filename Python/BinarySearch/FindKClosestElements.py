# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class FindKClosestElement(unittest.TestCase):

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        left = 0
        right = len(arr) - k

        while left + 1 < right:
            mid = (right - left) // 2 + left
            if x - arr[mid] > arr[mid+k] - x:
                left = mid
            else:
                right = mid

        startPos = left if abs(x - arr[left]) <= abs(x - arr[right+k-1]) else right

        result = []
        for i in range(startPos, startPos+k):
            result.append(arr[i])

        return result

    def test_Leetcode(self):
        print(self.findClosestElements([1, 2, 3, 4, 5], 4, 3))
        print(self.findClosestElements([1, 2, 3, 4, 5], 4, -1))

if __name__ == '__main__':
    unittest.main()