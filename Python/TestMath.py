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

    def test_intConversion(self):
        print(int("0123"))
        print(int("+124"))

if __name__ == '__main__':
    unittest.main()