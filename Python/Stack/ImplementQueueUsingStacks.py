# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inStack = []
        self.outStack = []

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.inStack.append(x)

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        result = self.peek()
        self.outStack.pop()
        return result

    def peek(self) -> int:
        """
        Get the front element.
        """
        if not self.outStack:
            while self.inStack:
                self.outStack.append(self.inStack.pop())
        return self.outStack[-1]

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.inStack and not self.outStack

class ImplementQueueUsingStacks(unittest.TestCase):

    def test_Leetcode(self):
        return

if __name__ == '__main__':
    unittest.main()