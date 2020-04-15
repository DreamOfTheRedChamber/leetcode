# Definition for a binary tree node.
import bisect
import unittest

# Read about enumerate in python
from typing import List


class MaximumProfitInJobScheduling(unittest.TestCase):

    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        def findLastNonConflict(jobs, i):
            # Todo: optimize with bisect search
            # rightMostPos = bisect.bisect(jobs, (0, jobs[i][1], 0)) # look for the first job whose starting time >= i-th finishing time
            for j in range(i - 1, -1, -1):
                if jobs[j][1] <= jobs[i][0]:
                    return j
            return -1

        if not startTime or not endTime or not profit:
            return 0

        jobs = sorted(zip(startTime, endTime, profit), key=lambda v: v[1])
        maxProfit = [0] * len(profit)
        maxProfit[0] = jobs[0][2]
        for i in range(1, len(profit)):
             includeProfit = jobs[i][2]

             lastNonConflict = findLastNonConflict(jobs, i)
             if lastNonConflict != -1:
                 includeProfit += maxProfit[lastNonConflict]

             maxProfit[i] = max(includeProfit, maxProfit[i-1])

        return maxProfit[len(profit) - 1]

    def test_Leetcode(self):
        self.assertEqual(120, self.jobScheduling([1, 2, 3, 3], [3, 4, 5, 6], [50, 10, 40, 70]))
        self.assertEqual(150, self.jobScheduling([1, 2, 3, 4, 6], [3, 5, 10, 6, 9], [20, 20, 100, 70, 60]))
        self.assertEqual(6, self.jobScheduling([1, 1, 1], [2, 3, 4], [5, 6, 4]))

    def test_WrongAnswer(self):
        self.assertEqual(20, self.jobScheduling([24,24,7,2,1,13,6,14,18,24], [27,27,20,7,14,22,20,24,19,27], [6,1,4,2,3,6,5,6,9,8]))

if __name__ == '__main__':
    unittest.main()