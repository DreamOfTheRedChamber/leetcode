# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import deque

class TestDataStructuresDeque(unittest.TestCase):

    def orderPizza(self, orderPlaced, size):
        # Write your code here
        queue = deque()
        for i in range(size):
            if orderPlaced[i] < 0:
                queue.append((orderPlaced[i], i))

        result = []
        for i in range(size, len(orderPlaced)):
            if len(queue) > 0:
                headVal, headPos = queue[0]
                currStart = i - size
                if currStart <= headPos <= currStart + size - 1:
                    result.append(headVal)
                    if headPos == currStart:
                        queue.popleft()
                else:
                    result.append(0)
            else:
                result.append(0)

            if orderPlaced[i] < 0:
                queue.append((orderPlaced[i], i))

        return result

    def test_AppendRemove(self):
        result = self.orderPizza([-11, -2, 19, 37, 64, -18], 3)

        print(" ".join([str(res) for res in result]))

if __name__ == '__main__':
    unittest.main()