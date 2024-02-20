# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import deque

class TestDataStructuresDeque(unittest.TestCase):

    def test_AppendRemove(self):
        queue = deque(['name', 'age', 'DOB'])
        print(queue)

        queue.append('def')
        print(queue)

        queue.appendleft('abc')
        print(queue)

        queue.pop()
        print(queue)

        queue.popleft()
        print(queue)

        # Accessing the front element of the deque
        print("Front element of the deque:", queue[0])

        # Accessing the back element of the deque
        print("Back element of the deque:", queue[-1])

if __name__ == '__main__':
    unittest.main()