# Definition for a binary tree node.
import unittest


class TwoSum(unittest.TestCase):

    def twoSumArraySorted(self, nums: list, target: int) -> list:
        start = 0
        end = len(nums) - 1

        while start < end and nums[start] + nums[end] != target:
            if nums[start] + nums[end] < target:
                start += 1
            elif nums[start] + nums[end] > target:
                end -= 1
            else:
                break

        return [start, end]

    def twoSum(self, nums: list, target: int) -> list:
        valueToIndex = {}
        for i in range(len(nums)):
            if target - nums[i] not in valueToIndex:
                valueToIndex[nums[i]] = i
            else:
                return [valueToIndex[target - nums[i]], i]

        raise ValueError("Invalid input")

    def test_SortedNormal(self):
        nums = [2, 7, 11, 15]
        result = self.twoSum(nums, 9)

        self.assertEqual(result[0], 0)
        self.assertEqual(result[1], 1)

    def test_UnsortedNode(self):
        nums = [11, 7, 15, 2]
        result = self.twoSum(nums, 13)

        self.assertEqual(result[0], 0)
        self.assertEqual(result[1], 3)

if __name__ == '__main__':
    unittest.main()