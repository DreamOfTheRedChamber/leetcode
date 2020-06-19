# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class BasicCalculator(unittest.TestCase):



    def calculate(self, s: str) -> int:
        operatorStack = []
        operandStack = []

        i = 0
        indentLevel = 0
        while i < len(s):
            if s[i] == " ":
                i += 1
            elif s[i].isnumeric():
                end = i + 1
                while end < len(s) and s[end].isnumeric():
                    end += 1
                operandStack.append(int(s[i:end]))
                i = end
            elif s[i] == "(":
                indentLevel += 1
                i += 1
            elif s[i] == ")":
                indentLevel -= 1
                i += 1
            else:
                while operatorStack and operatorStack[-1][1] >= indentLevel:
                    operand1 = operandStack.pop()
                    operand2 = operandStack.pop()
                    operator = operatorStack.pop()
                    if operator[0] == "+":
                        operandStack.append(operand2 + operand1)
                    else:
                        operandStack.append(operand2 - operand1)
                operatorStack.append([s[i], indentLevel])
                i += 1

        while operatorStack:
            operand1 = operandStack.pop()
            operand2 = operandStack.pop()
            operator = operatorStack.pop()
            if operator[0] == "+":
                operandStack.append(operand2 + operand1)
            else:
                operandStack.append(operand2 - operand1)

        return operandStack[-1] if operandStack else 0

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual(2, self.calculate("1 + 1"))
        self.assertEqual(3, self.calculate(" 2-1 + 2 "))
        self.assertEqual(23, self.calculate("(1+(4+5+2)-3)+(6+8)"))

    @unittest.skip
    def test_Edgecase(self):
        self.assertEqual(-15, self.calculate("1-(6-(5-(8+7)))"))
        self.assertEqual(4, self.calculate("(((8+7)-5)-6)"))

    # the commit 1 version of the code only works for non-negative integers, which will fail for the following case
    def test_Negative(self):
        self.assertEqual(-12, self.calculate("-7-8-(-3)"))

    @unittest.skip
    def test_WrongAnswer(self):
        self.assertEqual(23, self.calculate("(3-(-8-(2+(9-(0-(8-2)))-4)-4))"))

if __name__ == '__main__':
    unittest.main()