# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class Pattern132(unittest.TestCase):

    def find132pattern(self, nums: List[int]) -> bool:
        if len(nums) < 3:
            return False

        stack = [[nums[0], nums[0]]]
        minimum = nums[0]
        for num in nums[1:]:
            if num <= minimum:
                minimum = num
            else:
                # Pay attention to the second condition
                while stack:
                    if num > stack[-1][0]:
                        if num < stack[-1][1]:
                            return True
                        else:
                            stack.pop()
                    else:
                        break

                stack.append([minimum, num])

        return False

    @unittest.skip
    def test_Leetcode(self):
        self.assertFalse(self.find132pattern([1, 2, 3, 4]))
        self.assertTrue(self.find132pattern([3, 1, 4, 2]))
        self.assertTrue(self.find132pattern([-1, 3, 2, 0]))

    @unittest.skip
    def test_Edgecase(self):
        self.assertFalse(self.find132pattern([1, 2]))
        self.assertTrue(self.find132pattern([3, 2, 4, 1, 3]))
        self.assertFalse(self.find132pattern([3, 3, 2, 4, 4]))

        self.assertTrue(self.find132pattern([1, 3, -3, -1, -2]))

    def test_Debug(self):
        self.assertTrue(self.find132pattern([1, 3, -3, -1, 2]))

    @unittest.skip
    def test_WrongAnswer(self):
        self.assertFalse(self.find132pattern([1, 0, 1, -4, -3]))

if __name__ == '__main__':
    unittest.main()