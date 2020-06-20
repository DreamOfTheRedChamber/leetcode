# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NestedInteger:
    def __init__(self, value=None):
        return

    def isInteger(self):
        return

    def add(self, elem):
        return

    def setInteger(self, value):
        return

    def getInteger(self):
        return

    def getList(self):
        return

class MiniParser(unittest.TestCase):

    def deserialize(self, s: str) -> NestedInteger:
        if s[0].isnumeric() or s[0] == "-":
            end = 1
            while end < len(s) and s[end].isnumeric():
                end += 1
            return NestedInteger(int(s[:]))

        i = 0
        stack = []
        while i < len(s):
            if s[i] == "[":
                stack.append(NestedInteger())
                i += 1
            elif s[i].isnumeric() or s[i] == "-":
                end = i + 1
                while end < len(s) and s[end].isnumeric():
                    end += 1
                stack[-1].add(NestedInteger(int(s[i:end])))
                i = end
            elif s[i] == "]":
                top = stack.pop()
                if stack:
                    # [789,[234]]
                    stack[-1].add(top)
                else:
                    # [], [789]
                    stack.append(top)
                i += 1
            else:
                i += 1

        return stack[-1]


if __name__ == '__main__':
    unittest.main()