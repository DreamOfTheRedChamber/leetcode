# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from typing import List


class MajorityElement(unittest.TestCase):

    def majorityElement(self, nums: List[int]) -> int:
        result = nums[0]
        count = 1
        for i in range(1, len(nums)):
            if nums[i] == result:
                count += 1
            else:
                if count == 0:
                    count = 1
                    result = nums[i]
                else:
                    count -= 1
        return result

    def test_Leetcode(self):
        self.assertEqual(3, self.majorityElement([3, 2, 3]))
        self.assertEqual(2, self.majorityElement([2, 2, 1, 1, 1, 2, 2]))


if __name__ == '__main__':
    unittest.main()