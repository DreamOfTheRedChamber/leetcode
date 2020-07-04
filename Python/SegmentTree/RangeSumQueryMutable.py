# Definition for a binary tree node.
import heapq
import unittest

class SegNode:
    def __init__(self, nums: list, start: int, end: int):
        if len(nums) == 0:
            return

        self.start = start
        self.end = end
        self.nums = nums

        if start == end:
            self.sum = nums[start]
            self.mid = start
            self.left = None
            self.right = None
        else:
            self.mid = (end - start) // 2 + start
            self.left = SegNode(nums, start, self.mid)
            self.right = SegNode(nums, self.mid + 1, end)
            self.sum = self.left.sum + self.right.sum

    def update(self, i: int, val: int) -> None:
        diff = val - self.nums[i]
        self.sum += diff

        if self.start == self.end and self.start == i:
            self.nums[i] = val
        else:
            if i > self.mid:
                self.right.update(i, val)
            else:
                self.left.update(i, val)

    def sumRange(self, i: int, j: int) -> int:
        if i > self.end or j < self.start:
            return 0
        elif i == j and i == self.start and self.start == self.end:
            return self.sum
        elif i <= self.mid <= j:
            return self.left.sumRange(i, self.mid) + self.right.sumRange(self.mid + 1, j)
        elif self.mid > j:
            return self.left.sumRange(i, j)
        else:
            return self.right.sumRange(i, j)

class NumArray:
    def __init__(self, nums: list):
        self.root = SegNode(nums, 0, len(nums) - 1)
        return

    def update(self, i: int, val: int) -> None:
        self.root.update(i, val)
        return None

    def sumRange(self, i: int, j: int) -> int:
        return self.root.sumRange(i, j)

class RangeSumQuery(unittest.TestCase):

    @unittest.skip
    def test_Leetcode(self):
        numArray = NumArray([1, 3, 5])
        self.assertEqual(9, numArray.sumRange(0, 2))
        numArray.update(1, 2)
        self.assertEqual(8, numArray.sumRange(0, 2))

    @unittest.skip
    def test_Edgecase(self):
        numArray = NumArray([1, 2, 3, 4, 5, 6, 7, 8])
        self.assertEqual(15, numArray.sumRange(3, 5))
        numArray.update(3, 7)
        self.assertEqual(18, numArray.sumRange(3, 5))

    @unittest.skip
    # should consider the empty array case
    def test_ErrorCase(self):
        numArray = NumArray([])

    def test_ErrorCase2(self):
        numArray = NumArray([0,9,5,7,3])
        # self.assertEqual(3, numArray.sumRange(4, 4))
        # self.assertEqual(15, numArray.sumRange(2, 4))
        self.assertEqual(7, numArray.sumRange(3, 3))

    def test_TimeLimitExceeded(self):
        return

# Input
# ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
# [[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
# Output
# [null,3,15,10,null,null,null,12,null,5,null]
# Expected
# [null,3,15,7,null,null,null,12,null,5,null]

if __name__ == '__main__':
    unittest.main()