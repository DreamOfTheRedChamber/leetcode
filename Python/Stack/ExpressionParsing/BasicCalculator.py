# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class BasicCalculator(unittest.TestCase):

    def calculate(self, s: str) -> int:
        processedS = "+"
        for i in range(len(s)):
            if s[i] == " ":
                continue
            processedS += s[i]
            if s[i] == "(":
                processedS += "+"

        i = 0
        sign = 0
        sum = 0
        operandStack = []
        signStack = []
        while i < len(processedS):
            if processedS[i] == "+" or processedS[i] == "-":
                sign = 1 if processedS[i] == "+" else -1
                i += 1
            elif processedS[i].isnumeric():
                end = i + 1
                while end < len(processedS) and processedS[end].isnumeric():
                    end += 1
                sum += int(processedS[i:end]) * sign
                i = end
            elif processedS[i] == "(":
                operandStack.append(sum)
                signStack.append(sign)
                sum = 0
                sign = 0
                i += 1
            elif processedS[i] == ")":
                sum = operandStack.pop() + sum * signStack.pop()
                i += 1
            else:
                raise ValueError("unexpected")

        return sum

    def test_Leetcode(self):
        self.assertEqual(2, self.calculate("1 + 1")) # +1+1
        self.assertEqual(3, self.calculate(" 2-1 + 2 ")) # +2-1+2
        self.assertEqual(23, self.calculate("(1+(4+5+2)-3)+(6+8)")) # +(+1+(+4+5+2)-3)+(+6+8)

    def test_Edgecase(self):
        self.assertEqual(-15, self.calculate("1-(6-(5-(8+7)))")) # +1-(+6-(+5-(+8+7)))"
        self.assertEqual(4, self.calculate("(((8+7)-5)-6)")) # "(+(+(+8+7)-5)-6)")

    # the commit 1 version of the code only works for non-negative integers, which will fail for the following case
    def test_Negative(self):
        self.assertEqual(-12, self.calculate("-7-8-(-3)")) # "+-7-8-(+-3)"

    def test_WrongAnswer(self):
        self.assertEqual(28, self.calculate("(3-(-8-(2+(9-(0-(8-2)))-4)-4))"))
        # (+3-(-25))
        # (3-(-25))

if __name__ == '__main__':
    unittest.main()