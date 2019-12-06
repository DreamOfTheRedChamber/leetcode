# Definition for a binary tree node.
import unittest
from typing import List

class ThreeSum(unittest.TestCase):

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        allThreeSums = []
        sortedNums = sorted(nums)
        for index in range(len(sortedNums)):
            if index > 0 and sortedNums[index] == sortedNums[index - 1]:
                continue

            allTwoSumsComb = self.twoSum(index + 1, sortedNums, -sortedNums[index])
            for oneComb in allTwoSumsComb:
                oneComb.append(sortedNums[index])
                allThreeSums.append(oneComb)

        return allThreeSums

    def twoSum(self, zeroIndex: int, sortedNums: List[int], target: int) -> List[List[int]]:
        allTwoSums = []
        start = zeroIndex
        end = len(sortedNums) - 1

        while start < end:
            if start > zeroIndex and sortedNums[start] == sortedNums[start - 1]:
                start += 1
                continue

            sum = sortedNums[start] + sortedNums[end]
            if sum > target:
                end -= 1
            elif sum < target:
                start += 1
            else:
                allTwoSums.append([sortedNums[start], sortedNums[end]])
                start += 1

        return allTwoSums

    def test_TwoSumAllCombination(self):
        nums = [-1, 0, 1, 2, -1, -4]
        result = self.twoSum(0, sorted(nums), 1)
        print(result)

    def test_ThreeSumNormal(self):
        nums = [-1, 0, 1, 2, -1, -4]
        result = self.threeSum(nums)
        print(result)

if __name__ == '__main__':
    unittest.main()