import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class TwentyFourGame(unittest.TestCase):

    def judgePoint24(self, nums: List[int]) -> bool:
        def recursion(numArray: List[int]) -> bool:
            if len(numArray) == 1:
                # error case 1
                return True if (abs(numArray[0]-24.0) < 1e-6) else False

            for i, a in enumerate(numArray):
                for j, b in enumerate(numArray):
                    if i == j:
                        continue
                    possibleComb = [a+b, a*b, abs(a-b)]
                    if a != 0:
                        possibleComb.append(b/a)
                    if b != 0:
                        possibleComb.append(a/b)

                    for newNum in possibleComb:
                        newNums = []
                        for k in range(len(numArray)):
                            if k != i and k != j:
                                newNums.append(numArray[k])
                        newNums.append(newNum)

                        # print("current recursioin")
                        # print(newNum)
                        # print(newNums)
                        if recursion(newNums):
                            return True

            return False

        return recursion(nums)

    @unittest.skip
    def test_Leetcode(self):
        self.assertTrue(self.judgePoint24([4,1,8,7]))
        self.assertFalse(self.judgePoint24([1,2,1,2]))

    def test_WrongAnswer(self):
        self.assertTrue(self.judgePoint24([3,3,8,8]))

if __name__ == '__main__':
    unittest.main()