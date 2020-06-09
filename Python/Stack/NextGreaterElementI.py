# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class NextGreaterElementI(unittest.TestCase):

    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        decStack = []
        valueToNextGreater = {}
        for i in reversed(range(len(nums2))):
            while decStack and decStack[-1] <= nums2[i]:
                decStack.pop()
            if not decStack:
                valueToNextGreater[nums2[i]] = -1
            else:
                valueToNextGreater[nums2[i]] = decStack[-1]
            decStack.append(nums2[i])
        
        result = []
        for value in nums1:
            result.append(valueToNextGreater[value])
        return result

    def test_Leetcode(self):
        print(self.nextGreaterElement([4, 1, 2], [1, 3, 4, 2]))

if __name__ == '__main__':
    unittest.main()