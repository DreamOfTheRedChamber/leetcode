# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class CustomStack(unittest.TestCase):

    def __init__(self, maxSize: int):
        self.size = maxSize
        self.stack = []
        self.inc = []

    def push(self, x: int) -> None:
        if len(self.stack) == self.size:
            return
        self.stack.append(x)
        self.inc.append(0)

    def pop(self) -> int:
        if len(self.stack) == 0:
            return -1
        elif len(self.stack) == 1:
            return self.stack.pop() + self.inc.pop()
        else:
            self.inc[-2] += self.inc[-1]
            return self.stack.pop() + self.inc.pop()

    def increment(self, k: int, val: int) -> None:
        if not self.inc:
            return
        if k >= len(self.stack):
            self.inc[-1] += val
        else:
            self.inc[k - 1] += val


if __name__ == '__main__':
    unittest.main()