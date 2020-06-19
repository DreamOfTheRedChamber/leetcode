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
        curHistogram = defaultdict(lambda: 0)
        i = 0

        while i < len(formula):
            if formula[i] >= "A" and formula[i] <= "Z":
                end = i + 1
                while end < len(formula) and formula[end] >= "a" and formula[end] <= "z":
                    end += 1
                token = formula[i:end]

                i = end
                while end < len(formula) and formula[end].isnumeric():
                    end += 1
                number = int(formula[i:end]) if i < end else 1
                i = end

                curHistogram[token] += number
            elif formula[i] == "(":
                stack.append(curHistogram)
                curHistogram = defaultdict(lambda: 0)
                i += 1
            else:
                end = i + 1
                while end < len(formula) and formula[end].isnumeric():
                    end += 1
                if end > i + 1:
                    number = int(formula[i+1:end])
                    for key in curHistogram.keys():
                        curHistogram[key] = curHistogram[key] * number

                i = end
                if stack:
                    top = stack.pop()
                    for key in top.keys():
                        curHistogram[key] += top[key]

        result = ""
        for key in sorted(curHistogram.keys()):
            result += key
            if curHistogram[key] != 1:
                result += str(curHistogram[key])

        return result

    def test_Leetcode(self):
        self.assertEqual("H2O", self.countOfAtoms("H2O"))
        self.assertEqual("H2MgO2", self.countOfAtoms("Mg(OH)2"))
        self.assertEqual("K4N2O14S4", self.countOfAtoms("K4(ON(SO3)2)2"))

    def test_Edgecase(self):
        self.assertEqual("H2O2", self.countOfAtoms("H2O2"))

if __name__ == '__main__':
    unittest.main()