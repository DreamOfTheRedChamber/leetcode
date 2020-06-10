# Definition for a binary tree node.
import unittest
from collections import deque

# Read about enumerate in python

class EvaluateReversePolishNotation(unittest.TestCase):

    def test_NormalTest(self):
        self.assertEqual(9, self.evalRPN(["2", "1", "+", "3", "*"]))
        self.assertEqual(6, self.evalRPN(["4", "13", "5", "/", "+"]))
        self.assertEqual(22, self.evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]))

    def evalRPN(self, tokens: list) -> int:
        numStack = deque()
        operators = {"+", "*", "/", "-"}
        for token in tokens:
            if token in operators:
                operantRight = numStack.pop()
                operantLeft = numStack.pop()
                if token == "+":
                    numStack.append(operantLeft + operantRight)
                elif token == "-":
                    numStack.append(operantLeft - operantRight)
                elif token == "*":
                    numStack.append(operantLeft * operantRight)
                else:
                    numStack.append(int(operantLeft / operantRight))
            else:
                numStack.append(int(token))

        return numStack.pop()

if __name__ == '__main__':
    unittest.main()