# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import deque
from typing import List

class SlidingWindowMaximum(unittest.TestCase):

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        decDeque = deque()
        for i in range(k-1):
            while decDeque and decDeque[-1] < nums[i]:
                decDeque.pop()
            decDeque.append(nums[i])

        result = []
        for i in range(k-1, len(nums)):
            while decDeque and decDeque[-1] < nums[i]:
                decDeque.pop()
            decDeque.append(nums[i])
            result.append(decDeque[0])
            if nums[i-k+1] == decDeque[0]:
                decDeque.popleft()

        return result

    @unittest.skip
    def test_Leetcode(self):
        print(self.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))

    def test_WrongAnswer(self):
        print(self.maxSlidingWindow([1, -1], 1))

if __name__ == '__main__':
    unittest.main()