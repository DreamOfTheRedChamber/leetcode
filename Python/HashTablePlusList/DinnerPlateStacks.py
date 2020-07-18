# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class DinnerPlates:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.pq = []
        self.stacks = []
        return

    def push(self, val: int) -> None:
        if self.capacity <= 0:
            return

        if not self.pq:
            self.stacks.append([val])
            if self.capacity > 1:
                heapq.heappush(self.pq, len(self.stacks)-1)
        else:
            index = heapq.heappop(self.pq)
            self.stacks[index].append(val)
            if len(self.stacks[index]) < self.capacity:
                heapq.heappush(self.pq, index)
        return

    def pop(self) -> int:

        resultIndex = len(self.stacks) - 1
        while resultIndex >= 0 and len(self.stacks[resultIndex]) == 0:
            resultIndex -= 1

        result = self.popAtStack(resultIndex)
        return result

    def popAtStack(self, index: int) -> int:
        if self.capacity <= 0:
            return -1

        if index >= len(self.stacks):
            return -1

        if len(self.stacks[index]) > 0:
            result = self.stacks[index].pop()
            if len(self.stacks[index]) < self.capacity:
                heapq.heappush(self.pq, index)
            return result

        return -1

class DinnerPlateStacks(unittest.TestCase):

    def test_WrongAnswer(self):
        # ["DinnerPlates", "push", "push", "push", "popAtStack", "pop", "pop"]
        # [[1], [1], [2], [3], [1], [], []]
        # expected: [null,null,null,null,3,2,1]
        # output:   [null,null,null,null,2,3,1]
        dinnerPlates = DinnerPlates(1)
        dinnerPlates.push(1)
        dinnerPlates.push(2)
        dinnerPlates.push(3)
        self.assertEqual(2, dinnerPlates.popAtStack(1))
        self.assertEqual(3, dinnerPlates.pop())
        self.assertEqual(1, dinnerPlates.pop())
        return

if __name__ == '__main__':
    unittest.main()