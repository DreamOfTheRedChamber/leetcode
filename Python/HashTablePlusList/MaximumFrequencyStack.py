# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class FreqStack:

    def __init__(self):
        self.valueToFreq = defaultdict(lambda: 0)
        self.freqToElements = defaultdict(list)
        self.maxFreq = 0
        return

    def push(self, x: int) -> None:
        self.valueToFreq[x] += 1
        self.freqToElements[self.valueToFreq[x]].append(x)
        self.maxFreq = max(self.maxFreq, self.valueToFreq[x])
        return

    def pop(self) -> int:
        result = self.freqToElements[self.maxFreq].pop()
        self.valueToFreq[result] -= 1
        if not self.freqToElements[self.maxFreq]:
            self.freqToElements.pop(self.maxFreq)
            self.maxFreq -= 1
        return result

# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(x)
# param_2 = obj.pop()

class MaximumFrequencyStack(unittest.TestCase):

    def test_Errorcase(self):
        # ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "push", "pop", "push", "pop", "push",
        #  "pop", "push", "pop", "pop", "pop", "pop", "pop", "pop"]
        # [[], [4], [0], [9], [3], [4], [2], [], [6], [], [1], [], [1], [], [4], [], [], [], [], [], []]
        freqStack = FreqStack()
        freqStack.push(4)
        freqStack.push(0)
        freqStack.push(9)
        freqStack.push(3)
        freqStack.push(4)
        freqStack.push(2)
        freqStack.pop()

if __name__ == '__main__':
    unittest.main()