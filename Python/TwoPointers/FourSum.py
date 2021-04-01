import unittest
from typing import List

class FourSum(unittest.TestCase):
    def fourSum(self, nums: List[int], fourSumTarget: int) -> List[List[int]]:
        def twoSum(nums: List[int], target: int, start: int) -> List[List[int]]:
            end = len(nums) - 1
            result = []
            pos = start
            while pos < end:
                if pos > start and nums[pos] == nums[pos - 1]:
                    pos += 1
                    continue

                currSum = nums[pos] + nums[end]
                if currSum > target:
                    end -= 1
                elif currSum < target:
                    pos += 1
                else:
                    result.append([nums[pos], nums[end]])
                    pos += 1
                    end -= 1
            return result

        def threeSum(nums: List[int], threeSumTarget: int) -> List[List[int]]:
            result = []
            for i in range(len(nums)):
                if i > 0 and nums[i] == nums[i - 1]:
                    continue

                allTwoSums = twoSum(nums[i + 1:], threeSumTarget - nums[i], 0)
                for oneTwoSum in allTwoSums:
                    result.append([nums[i]] + oneTwoSum)
            return result

        nums = sorted(nums)
        result = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            allThreeSums = threeSum(nums[i + 1:], fourSumTarget - nums[i])
            for oneThreeSum in allThreeSums:
                result.append([nums[i]] + oneThreeSum)

        return list(result)

    def test_FourSum(self):
        nums = [1,0,-1,0,-2,2]
        result = self.fourSum(sorted(nums), 0)
        print(result)