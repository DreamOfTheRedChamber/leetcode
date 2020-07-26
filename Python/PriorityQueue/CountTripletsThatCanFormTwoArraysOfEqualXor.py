# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class CountTripletsThatCanFormTwoArraysOfEqualXor(unittest.TestCase):

    def countTriplets(self, arr: List[int]) -> int:
        prefixXor = [0 for i in range(len(arr) + 1)]
        for i in range(len(arr)):
            prefixXor[i + 1] = arr[i] ^ prefixXor[i]

        result = 0
        for i in range(len(arr)):
            for k in range(i+1, len(arr)):
                if prefixXor[i] == prefixXor[k + 1]:
                    result += k - i

        return result

    def test_Leetcode(self):
        self.assertEqual(4, self.countTriplets([2, 3, 1, 6, 7]))
        self.assertEqual(10, self.countTriplets([1, 1, 1, 1, 1]))
        self.assertEqual(0, self.countTriplets([2, 3]))
        self.assertEqual(3, self.countTriplets([1, 3, 5, 7, 9]))
        self.assertEqual(8, self.countTriplets([7, 11, 12, 9, 5, 2, 7, 17, 22]))

if __name__ == '__main__':
    unittest.main()