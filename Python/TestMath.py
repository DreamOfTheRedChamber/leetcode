# Definition for a binary tree node.
import bisect
import unittest
from dataclasses import dataclass

class TestMath(unittest.TestCase):

    @unittest.skip
    def test_divide(self):

        # integer divide
        abc = 1 // 2
        print("a // b = " + str(abc))

        # decimal divide
        efg = 1 / 2
        print("a / b = " + str(efg))
        return

    @unittest.skip
    def test_intConversion(self):
        print(int("0123"))
        print(int("+124"))

    def test_twoDMax(self):
        array2D = [[1, 2, 9], [7, 3, 6]]
        maxVal = max(map(max, array2D))
        print(maxVal)

if __name__ == '__main__':
    unittest.main()