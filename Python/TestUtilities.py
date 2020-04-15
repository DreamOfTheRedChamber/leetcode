# Definition for a binary tree node.
import bisect
import unittest

# Read about enumerate in python

class TestUtilities(unittest.TestCase):

    def test_bisectSearch(self):
        li = [1, 3, 4, 4, 4, 6, 7]

        print("The rightmost index to insert, so list remains sorted is  : ", end="")
        print(bisect.bisect(li, 4))

        print("The leftmost index to insert, so list remains sorted is  : ", end="")
        print(bisect.bisect_left(li, 4))

        print("The rightmost index to insert, so list remains sorted is  : ", end="")
        print(bisect.bisect_right(li, 4))

if __name__ == '__main__':
    unittest.main()