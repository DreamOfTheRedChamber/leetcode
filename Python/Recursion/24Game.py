import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class TwentyFourGame(unittest.TestCase):

    def judgePoint24(self, nums: List[int]) -> bool:
        def recursion(nums: List[int]) -> bool:
            if len(nums) == 1:
                return True if nums[0] == 24 else False

            for i, a in enumerate(nums):
                for j, b in enumerate(nums):
                    possibleComb = [a+b, a*b, abs(a-b)]
                    if a != 0:
                        possibleComb.append(b/a)
                    if b != 0:
                        possibleComb.append(a/b)

                    for newNum in possibleComb:
                        newNums = []
                        for k in range(len(nums)):
                            if k != i and k != j:
                                newNums.append(nums[k])
                        newNums.append(newNum)

                        if recursion(newNums):
                            return True

            return False

        return recursion(nums)

    def test_Leetcode(self):
        self.assertTrue(self.judgePoint24([4,1,8,7]))
        # self.assertFalse(self.judgePoint24([1,2,1,2]))

if __name__ == '__main__':
    unittest.main()