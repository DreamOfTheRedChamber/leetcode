# Definition for a binary tree node.
import bisect
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MajorityChecker:

    def __init__(self, arr: List[int]):
        self.valueToAppear = defaultdict(list)
        for i in range(len(arr)):
            self.valueToAppear[arr[i]].append(i)

    def query(self, left: int, right: int, threshold: int) -> int:
        totalElement = right - left + 1
        for key, value in self.valueToAppear.items():
            if totalElement < threshold:
                return -1
            leftPos = bisect.bisect_left(value, left)
            rightPos = bisect.bisect_right(value, right)

            if rightPos - leftPos >= threshold:
                return key
            else:
                totalElement -= (rightPos - leftPos)

        return -1

class OnlineMajorityElementInASubarray(unittest.TestCase):

    # Error case: left boundary inclusive search using bisect.bisect_left
    #             right boundary search using bisect.bisect_right
    def test_Leetcode(self):
        major = MajorityChecker([1,1,2,2,1,1])
        self.assertEqual(1, major.query(0, 5, 4))
        self.assertEqual(-1, major.query(0, 3, 3))
        self.assertEqual(2, major.query(2, 3, 2))

if __name__ == '__main__':
    unittest.main()