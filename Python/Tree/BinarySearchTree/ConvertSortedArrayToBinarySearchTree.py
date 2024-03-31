# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class ConvertSortedArrayToBinarySearchTree(unittest.TestCase):
    def sortedArrayToBST(self, nums: list) -> TreeNode:
        result = self.sortedArrayToBSTRecursive(nums, 0, len(nums) - 1)
        return result

    def sortedArrayToBSTRecursive(self, nums: list, start: int, end: int):
        if start > end:
            return None
        elif start == end:
            return TreeNode(nums[start])
        else:
            middle = (int)((start + end) / 2)
            root = TreeNode(nums[middle])
            root.left = self.sortedArrayToBSTRecursive(nums, start, middle - 1)
            root.right = self.sortedArrayToBSTRecursive(nums, middle + 1, end)
            return root

    def test_NormalTree(self):
        sortedArray = [-10, -3, 0, 5, 9]

        self.sortedArrayToBST(sortedArray)

if __name__ == '__main__':
    unittest.main()