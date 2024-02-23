# Definition for a binary tree node.
import bisect
import unittest
from dataclasses import dataclass

class TestMath(unittest.TestCase):

    def test_math(self):

        # integer divide
        abc = 1 // 2
        print("a // b = " + str(abc))

        # decimal divide
        efg = 1 / 2
        print("a / b = " + str(efg))
        return

if __name__ == '__main__':
    unittest.main()