"""
You are given a non-empty list of positive integers. You can sum any two consecutive elements to form a single element. The result thus obtained be
"""

import unittest
from collections import defaultdict
from typing import List

class PalindromicList(unittest.TestCase):

    def getPalindromicList(self, inputArray: List[int], arrayLen: int):
        leftP = 0
        rightP = len(inputArray) - 1
        leftResult = []
        rightResult = []
        while leftP <= rightP:
            if inputArray[leftP] == inputArray[rightP]:
                leftResult.append(inputArray[leftP])
                if leftP != rightP:
                    rightResult.insert(0, inputArray[rightP])
                leftP += 1
                rightP -= 1
            elif inputArray[leftP] < inputArray[rightP]:
                leftResult.append(inputArray[rightP])
                rightResult.insert(0, inputArray[rightP])
                leftSum = inputArray[leftP]
                while leftSum < inputArray[rightP]:
                    leftP += 1
                    leftSum += inputArray[leftP]
                leftP += 1
                rightP -= 1
            else:
                leftResult.append(inputArray[leftP])
                rightResult.insert(0, inputArray[rightP])
                rightSum = inputArray[rightP]
                while inputArray[leftP] > rightSum:
                    rightP -= 1
                    rightSum += inputArray[rightP]
                leftP += 1
                rightP -= 1

        for i in range(len(rightResult)):
            leftResult.append(rightResult[i])
        return leftResult

    def test_Normal(self):
        testArray = [15, 10, 15, 34, 25, 15]
        print(self.getPalindromicList(testArray, 6))
        return
