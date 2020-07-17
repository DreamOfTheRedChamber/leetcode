# Definition for a binary tree node.
import heapq
import random
import unittest

# Read about enumerate in python
from collections import defaultdict
from math import floor
from typing import List


class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.valueToIndex = dict()
        self.values = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.valueToIndex:
            return False

        self.values.append(val)
        self.valueToIndex[val] = len(self.values) - 1
        return True

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.valueToIndex:
            return False

        targetIndex = self.valueToIndex[val]
        self.values[targetIndex] = self.values[len(self.values) - 1]
        self.valueToIndex[self.values[targetIndex]] = targetIndex
        self.values.pop()
        self.valueToIndex.pop(val)
        return True

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        randomNum = floor(random.random() * len(self.values))
        return self.values[randomNum]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

class InsertDeleteGetRandomO1(unittest.TestCase):

    def test_Leetcode(self):
        # Input
        # ["RandomizedSet", "insert", "insert", "remove", "insert", "remove", "getRandom"]
        # [[], [0], [1], [0], [2], [1], []]
        # Output
        # [null, true, true, true, true, true, 1]
        # Expected
        # [null, true, true, true, true, true, 2]
        print([1])

if __name__ == '__main__':
    unittest.main()