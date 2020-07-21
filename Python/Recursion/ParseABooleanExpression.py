# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ParseABooleanExpression(unittest.TestCase):

    def parseBoolExpr(self, expression: str) -> bool:

        def findEnding(expression: str, start: int, end: int) -> int:
            i = start + 2
            count = 1
            while i <= end and count != 0:
                if expression[i] == "(":
                    count += 1
                    i += 1
                elif expression[i] == ")":
                    count -= 1
                    i += 1
                else:
                    i += 1
                    continue
            return i - 1

        def recursion(expression: str, start: int, end: int) -> bool:
            if start == end:
                return True if expression[start] == "t" else "f"

            values = []
            i = start + 2
            while i <= end - 1:
                if expression[i] == "|" or expression[i] == "&" or expression[i] == "!":
                    endParen = findEnding(expression, i, end)
                    partialResult = recursion(expression, i, endParen)
                    values.append(partialResult)
                    i = endParen + 1
                elif expression[i] == ",":
                    i += 1
                else:
                    if expression[i] == "t":
                        values.append(True)
                    else:
                        values.append(False)
                    i += 1

            if expression[start] == "|":
                result = values[0]
                for i in range(1, len(values)):
                    result = result or values[i]
                return result
            elif expression[start] == "&":
                result = values[0]
                for i in range(1, len(values)):
                    result = result and values[i]
                return result
            else:
                return not values[0]

        return recursion(expression, 0, len(expression) - 1)

    def test_Leetcode(self):
        # self.assertTrue(self.parseBoolExpr("!(f)"))
        # self.assertTrue(self.parseBoolExpr("|(f,t)"))
        # self.assertFalse(self.parseBoolExpr("&(t,f)"))
        self.assertFalse(self.parseBoolExpr("|(&(t,f,t),!(t))"))

if __name__ == '__main__':
    unittest.main()