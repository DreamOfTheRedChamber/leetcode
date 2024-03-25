# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import deque
from typing import List

class SlidingWindowMaximum(unittest.TestCase):

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        maxQueue = deque()
        for i in range(k-1):
            while maxQueue and nums[maxQueue[-1]] < nums[i]:
                maxQueue.pop()
            maxQueue.append(i)

        result = []
        for i in range(k-1, len(nums)):
            while maxQueue and nums[maxQueue[-1]] < nums[i]:
                maxQueue.pop()
            maxQueue.append(i)

            while maxQueue and maxQueue[0] <= i - k:
                maxQueue.popleft()

            result.append(nums[maxQueue[0]])

        return result

    def test_Leetcode(self):
        print(self.maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3))

if __name__ == '__main__':
    unittest.main()