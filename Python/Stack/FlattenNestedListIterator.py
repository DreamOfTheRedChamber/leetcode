# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class NestedInteger:
    def isInteger(self) -> bool:
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        """
        return True

    def getInteger(self) -> int:
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        """
        return 0

    def getList(self) -> []:
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        """
        return []

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.stack = []
        for i in reversed(range(len(nestedList))):
            self.stack.append(nestedList[i])

    def next(self) -> int:
        return self.stack[-1].getInteger()

    def hasNext(self) -> bool:
        while self.stack and not self.stack[-1].isInteger():
            stackTopList = self.stack.pop().getList()
            for i in reversed(range(len(stackTopList))):
                self.stack.append(stackTopList[i])

        if self.stack and self.stack[-1].isInteger():
            return True
        else:
            return False

class FlattenNestedListIterator(unittest.TestCase):

    def test_Leetcode(self):
        str1 = "Cannot test here"

if __name__ == '__main__':
    unittest.main()