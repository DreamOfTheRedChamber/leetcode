# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from typing import List

class FindKPairsWithSmallestSums(unittest.TestCase):

    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:

        def countNotBigger(target: int) -> (int, List[List[int]]):
            result = []
            totalCount = 0

            for i in range(len(nums1)):
                insertPos = bisect.bisect_right(nums2, target - nums1[i])
                totalCount += insertPos

                for j in range(insertPos):
                    result.append([nums1[i], nums2[j]])

            return totalCount, result

        if len(nums1) * len(nums2) <= k:
            result = []
            for i in range(len(nums1)):
                for j in range(len(nums2)):
                    result.append([nums1[i], nums2[j]])
            return result

        left = nums1[0] + nums2[0]
        right = nums1[-1] + nums2[-1]
        result = [[nums1[0], nums2[0]]]

        while left < right:
            mid = (right - left) // 2 + left
            numOfNotBiggerThanMid, result = countNotBigger(mid)
            if numOfNotBiggerThanMid < k:
                left = mid + 1
            else:
                right = mid

        numOfNotBiggerThanMid, result = countNotBigger(left)
        return sorted(result[0:k], key=lambda x: x[0] + x[1])

    @unittest.skip
    def test_Leetcode(self):
        print(self.kSmallestPairs([1, 7, 11], [2, 4, 6], 3))
        print(self.kSmallestPairs([1, 1, 2], [1, 2, 3], 2))
        print(self.kSmallestPairs([1, 2], [3], 3))

    @unittest.skip
    def test_WrongAnswer(self):
        print(self.kSmallestPairs([1,2,4,5,6], [3,5,7,9], 3)) # expected [1, 3], [2, 3], [1, 5]

    @unittest.skip
    def test_WrongAnswer2(self):
        # expected [[-10,3],[-10,5],[-10,6],[-10,7],[-10,8],[-4,3],[-4,5],[-4,6],[0,3],[0,3]]
        # actual   [[-10,3],[-10,5],[-10,6],[-10,7],[-10,8],[-4,3],[-4,5],[-4,6],[-4,7],[0,3],[0,3]]
        print(self.kSmallestPairs([-10,-4,0,0,6], [3,5,6,7,8,100], 10))

    def test_WrongAnswer3(self):
        # expected [[0,-3],[0,-3],[0,-3],[0,-3],[0,-3],[0,22],[0,22],[0,22],[0,22],[0,22],[0,35],[0,35],[0,35],[0,35],[0,35],[0,56],[0,56],[0,56],[0,56],[0,56],[0,76],[0,76]]
        # output   [[0,-3],[0,22],[0,35],[0,56],[0,76],[0,-3],[0,22],[0,35],[0,56],[0,76],[0,-3],[0,22],[0,35],[0,56],[0,76],[0,-3],[0,22],[0,35],[0,56],[0,76],[0,-3],[0,22]]
        print(self.kSmallestPairs([0,0,0,0,0], [-3,22,35,56,76], 22))

if __name__ == '__main__':
    unittest.main()