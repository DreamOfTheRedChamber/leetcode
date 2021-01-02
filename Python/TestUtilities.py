# Definition for a binary tree node.
import bisect
import collections
import unittest

# Read about enumerate in python
from itertools import product


class TestUtilities(unittest.TestCase):

    @unittest.skip
    def test_bisectSearch(self):
        li = [1, 3, 4, 4, 4, 6, 7]

        print("The rightmost index to insert, so list remains sorted is  : ", end="")
        print(bisect.bisect(li, 4))

        print("The leftmost index to insert, so list remains sorted is  : ", end="")
        print(bisect.bisect_left(li, 4))

        print("The rightmost index to insert, so list remains sorted is  : ", end="")
        print(bisect.bisect_right(li, 4))

    @unittest.skip
    def test_collectionsCounter(self):
        li = [1, 3, 4, 4, 4, 6, 7]

        # returns a default dictionary
        result = collections.Counter(li)
        self.assertEqual(0, result[0])

    @unittest.skip
    def test_mod(self):
        i = -2
        a = i % 4
        print(a)

    def test_product(self):
        a = [1, 2, 3]
        b = [4, 5, 6]
        for i, j in product(a, b):
            print((i, j))

if __name__ == '__main__':
    unittest.main()