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

            if leftInvalid == 0 and rightInvalid == 0 and isValid(origin):
                result.append(origin)
                return

            for i in range(start, len(origin)):
                if origin[i] != "(" and origin[i] != ")":
                    continue

                if i > start and origin[i] == origin[i-1]:
                    continue

                if origin[i] == "(" and leftInvalid > 0:
                    # Error case: The index needs to start at i, instead of i + 1
                    dfs(origin[:i] + origin[i+1:], i, leftInvalid - 1, rightInvalid, result)
                elif origin[i] == ")" and rightInvalid > 0:
                    dfs(origin[:i] + origin[i+1:], i, leftInvalid, rightInvalid - 1, result)

            return

        result = []
        leftInvalid, rightInvalid = countInvalidLeftRight(s)
        dfs(s, 0, leftInvalid, rightInvalid, result)

        return result

    @unittest.skip
    def test_Leetcode(self):
        # expected ["()()()", "(())()"]
        print(self.removeInvalidParentheses("()())()"))

        # expected ["(a)()()", "(a())()"]
        print(self.removeInvalidParentheses("(a)())()"))

        print(self.removeInvalidParentheses("()"))

    def test_Edgecase(self):
        # expected [""]
        print(self.removeInvalidParentheses(")("))

        # expected ["f"]
        print(self.removeInvalidParentheses("f)("))


if __name__ == '__main__':
    unittest.main()