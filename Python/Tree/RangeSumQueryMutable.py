# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class NumArray:
    def __init__(self, nums: list):
        self.nums = nums
        self.segmentTree = [0 for x in range(len(nums) * 2)]
        for i in range(len(nums)):
            self.segmentTree[i + len(nums)] = nums[i]
        for i in reversed(range(len(nums))):
            self.segmentTree[i] = self.segmentTree[i * 2] + self.segmentTree[i * 2 + 1]

    def update(self, i: int, val: int) -> None:
        self.nums[i] = val
        self.segmentTree[i + len(self.nums)] = self.nums[i]
        i = i + len(self.nums)

        while i > 0:
            i = i // 2
            self.segmentTree[i] = self.segmentTree[i * 2] + self.segmentTree[i * 2 + 1]

        return None

    def sumRange(self, i: int, j: int) -> int:

        i += len(self.nums)
        j += len(self.nums)

        sum = 0
        while i <= j:
            if i % 2 == 1:
                sum += self.segmentTree[i]
                i += 1
            if j % 2 == 0:
                sum += self.segmentTree[j]
                j -= 1

            i = i // 2
            j = j // 2

        return sum

class RangeSumQueryMutable(unittest.TestCase):


    def test_Normal(self):
        # Your NumArray object will be instantiated and called as such:
        nums = [1, 3, 5]

        obj = NumArray(nums)
        # self.assertEqual(9, obj.sumRange(0, 2))

        obj.update(1, 2)
        self.assertEqual(8, obj.sumRange(0, 2))

if __name__ == '__main__':
    unittest.main()