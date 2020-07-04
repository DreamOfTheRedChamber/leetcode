# Definition for a binary tree node.
import heapq
import unittest

class SegNode:
    def __init__(self, start: int, end: int, status: int):
        self.start = start
        self.end = end
        self.status = status
        self.left = None
        self.right = None

    def remove(self, node):
        if not node:
            return
        self.remove(node.left)
        self.remove(node.right)
        node.left = None
        node.right = None
        node = None
        return

    def setStatus(self, a: int, b: int, status: int) -> int:
        if self.start >= b or self.end <= a:
            return self.status
        if a <= self.start and self.end <= b:
            self.remove(self.left)
            self.remove(self.right)
            self.status = status
            return self.status
        if not self.left:
            mid = (self.end - self.start) // 2 + self.start
            self.left = SegNode(self.start, mid, status)
            self.right = SegNode(mid, self.end, status)

        leftStatus = self.left.setStatus(a, b, status)
        rightStatus = self.right.setStatus(a, b, status)

        self.status = leftStatus + rightStatus
        return self.status

    def getStatus(self, a: int, b: int) -> int:
        if self.start >= b or self.end <= a:
            return 0
        if a <= self.start and self.end <= b:
            return self.status
        if not self.left:
            return self.status

        leftStatus = self.left.getStatus(a, b)
        rightStatus = self.right.getStatus(a, b)
        return leftStatus + rightStatus

class NumArray:
    def __init__(self, nums: list):
        self.root = SegNode(0, len(nums), 0)
        for i in range(0, len(nums)):
            self.root.setStatus(i, i+1, nums[i])

    def update(self, i: int, val: int) -> None:
        self.root.setStatus(i, i+1, val)

    def sumRange(self, i: int, j: int) -> int:
        return self.root.getStatus(i, j+1)

class RangeSumQuery(unittest.TestCase):

    def test_Leetcode(self):
        numArray = NumArray([1, 3, 5])
        self.assertEqual(9, numArray.sumRange(0, 2))
        numArray.update(1, 2)
        self.assertEqual(8, numArray.sumRange(0, 2))

    def test_Edgecase(self):
        numArray = NumArray([1, 2, 3, 4, 5, 6, 7, 8])
        self.assertEqual(15, numArray.sumRange(3, 5))
        numArray.update(3, 7)
        self.assertEqual(18, numArray.sumRange(3, 5))

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