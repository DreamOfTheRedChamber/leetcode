# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class MinimumNumberOfTapsToOpen(unittest.TestCase):

    def minTaps(self, n: int, ranges: List[int]) -> int:
        sortedRanges = sorted([[i - r, i + r] for i, r in enumerate(ranges)])
        ans = start = end = i = 0
        while start < n:
            # find for current start point, if a tap could cover it, what's the farthest point it could reach to the right
            while i <= n and sortedRanges[i][0] <= start:
                end = max(end, sortedRanges[i][1])
                i += 1

            # if could not find right position which extends our current selection, it means that there is a gap and the start point is not covered
            if start == end:
                return -1

            # we found the section which covers the current point to the right, picked one from the list of solutions
            start = end
            ans += 1

        return ans

    def test_leetcode(self):
        # self.assertEqual(1, self.minTaps(5, [3,4,1,1,0,0]))
        # self.assertEqual(-1, self.minTaps(3, [0,0,0,0]))
        self.assertEqual(3, self.minTaps(7, [1,2,1,0,2,1,0,1]))

if __name__ == '__main__':
    unittest.main()