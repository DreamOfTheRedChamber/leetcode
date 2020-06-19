# Definition for a binary tree node.
import collections
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class NumberOfAtoms(unittest.TestCase):

    def countOfAtoms(self, formula: str) -> str:
        stack = []
        token = ""

        i = 0
        while i < len(formula):
            if formula[i].isalpha():
                token += formula[i]
                i += 1
            elif formula[i].isnumeric():
                end = i + 1
                while end < len(formula) and formula[end].isnumeric():
                    end += 1
                number = int(formula[i:end])
                lastChar = token[-1]
                token += (number - 1) * lastChar
                i = end
            elif formula[i] == "(":
                stack.append(token)
                token = ""
                i += 1
            else:
                end = i + 1
                while end < len(formula) and formula[end].isnumeric():
                    end += 1
                if end > i + 1:
                    number = int(formula[i+1:end])
                    token = token * number
                i = end
                if stack:
                    token = stack.pop() + token

        result = ""
        histogram = collections.Counter(token)
        for key in sorted(histogram.keys()):
            result += key
            if histogram[key] != 1:
                result += str(histogram[key])

        return result

    def test_Leetcode(self):
        self.assertEqual("H2O", self.countOfAtoms("H2O"))
        self.assertEqual("H2MgO2", self.countOfAtoms("Mg(OH)2"))
        self.assertEqual("K4N2O14S4", self.countOfAtoms("K4(ON(SO3)2)2"))

    def test_Edgecase(self):
        self.assertEqual("H2O2", self.countOfAtoms("(H2O2)"))
        self.assertEqual("M2R2T4g2", self.countOfAtoms("((Mg)RT2)2"))
        self.assertEqual("Mg2M2")

if __name__ == '__main__':
    unittest.main()