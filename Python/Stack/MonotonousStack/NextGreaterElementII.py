# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NextGreaterElementII(unittest.TestCase):

    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        decStack = []
        for i in reversed(range(len(nums))):
            while decStack and decStack[-1] <= nums[i]:
                decStack.pop()
            decStack.append(nums[i])

        result = []
        for i in reversed(range(len(nums))):
            while decStack and decStack[-1] <= nums[i]:
                decStack.pop()
            if decStack:
                result.append(decStack[-1])
            else:
                result.append(-1)
            decStack.append(nums[i])

        return reversed(result)

    def test_Leetcode(self):
        print(self.nextGreaterElements([1, 2, 1]))

    @unittest.skip
    def test_Edgecase(self):
        print(self.nextGreaterElements([3, 9, 2, 5, 7, 8]))

if __name__ == '__main__':
    unittest.main()