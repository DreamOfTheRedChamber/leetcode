# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class FindKthSmallestPairDistance(unittest.TestCase):

    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        def countsmallernum(mid: int) -> (int, List[int]):
            totalcount = 0
            result = [nums[0], nums[0]]

            for i in range(len(nums)):
                # whether to use bisect_left or bisect?
                # both will work
                insertpos = bisect.bisect_right(nums, nums[i] + mid, i + 1)

                # which one to use? insertpos or len(nums) - insertpos
                # find a[j] >= a[i] - m, because a is sorted all elements after j are valid
                totalcount += insertpos - i - 1

                # what does it mean when insertpos == len(nums):
                # no number in this line satisfy the condition so no need to update
                if insertpos > i and nums[insertpos-1] - nums[i] > result[1] - result[0]:
                    result = [nums[i], nums[insertpos-1]]

            return totalcount, result

        nums = sorted(nums)
        left = float('inf')
        right = nums[-1] - nums[0]
        for i in range(1, len(nums)):
            left = min(left, nums[i] - nums[i-1])

        while left + 1 < right:
            mid = (right - left) // 2 + left
            numOfSmaller, result = countsmallernum(mid)
            if numOfSmaller == k:
                return abs(result[0] - result[1])
            elif numOfSmaller < k:
                left = mid
            else:
                right = mid

        numOfSmaller, result = countsmallernum(left)
        if numOfSmaller >= k:
            return abs(result[0] - result[1])
        else:
            numOfSmaller, result = countsmallernum(right)
            return abs(result[0] - result[1])

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual(0, self.smallestDistancePair([1, 3, 1], 1))

    @unittest.skip
    def test_TLE(self):
        self.assertEqual(2, self.smallestDistancePair([9,10,7,10,6,1,5,4,9,8], 18))

    @unittest.skip
    def test_WrongAnswer(self):
        self.assertEqual(5, self.smallestDistancePair([1, 6, 1], 3))
        self.assertEqual(58, self.smallestDistancePair([62, 100, 4], 2))

    def testWrongAnswer2(self):
        self.assertEqual(0, self.smallestDistancePair([2,2,0,1,1,0,0,1,2,0], 2))

if __name__ == '__main__':
    unittest.main()