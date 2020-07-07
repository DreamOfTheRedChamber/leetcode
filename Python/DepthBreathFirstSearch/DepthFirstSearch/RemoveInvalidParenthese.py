# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from typing import List

class RemoveInvalidParentheses(unittest.TestCase):

    def removeInvalidParentheses(self, s: str) -> List[str]:

        def countInvalidLeftRight(s: str) -> (int, int):
            leftPar, rightPar = 0, 0
            for char in s:
                if char == "(":
                    leftPar += 1
                elif char == ")":
                    if leftPar > 0:
                        leftPar -= 1
                    else:
                        rightPar += 1
                else:
                    continue
            return leftPar, rightPar

        def isValid(s: str) -> bool:
            count = 0
            for char in s:
                if char == "(":
                    count += 1
                elif char == ")":
                    if count == 0:
                        return False
                    else:
                        count -= 1
                else:
                    continue
            return count == 0

        def dfs(origin: str, start: int, leftInvalid: int, rightInvalid: int, result: List[str]):

            if leftInvalid < 0 or rightInvalid < 0:
                return

            if leftInvalid == 0 and rightInvalid == 0 and isValid(origin):
                result.append(origin)
                return

            for i in range(start, len(origin)):
                if origin[i] != "(" and origin[i] != ")":
                    continue

                if i > start and origin[i] == origin[i-1]:
                    continue

                if origin[i] == "(":
                    dfs(origin[:i] + origin[i+1:], i + 1, leftInvalid - 1, rightInvalid, result)
                else:
                    dfs(origin[:i] + origin[i+1:], i + 1, leftInvalid, rightInvalid - 1, result)

            return

        result = []
        leftInvalid, rightInvalid = countInvalidLeftRight(s)
        dfs(s, 0, leftInvalid, rightInvalid, result)
        return result

    def test_Leetcode(self):
        # expected ["()()()", "(())()"]
        print(self.removeInvalidParentheses("()())()"))

        # expected ["(a)()()", "(a())()"]
        print(self.removeInvalidParentheses("(a)())()"))

        # expected [""]
        print(self.removeInvalidParentheses(")("))

        print(self.removeInvalidParentheses("()"))

if __name__ == '__main__':
    unittest.main()