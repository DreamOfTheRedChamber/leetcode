# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class ExpressionAddOperators(unittest.TestCase):

    def addOperators(self, num: str, target: int) -> List[str]:

        def dfs(num: str, start: int, target: int, currValue: int, lastOperandValue: int, currStr: str, result: List[str]):
            # base condition
            if start == len(num):
                if target == currValue:
                    result.append(currStr)
                return

            # recursion
            for i in range(start, len(num)):
                numStr = num[start:i+1]
                numStrValue = int(numStr)
                if len(numStr) > 1 and numStr[0] == "0":
                    continue
                if len(currStr) == 0:
                    dfs(num, i + 1, target, numStrValue, numStrValue, numStr, result)
                else:
                    dfs(num, i + 1, target, currValue + numStrValue, numStrValue, currStr + "+" + numStr, result)
                    dfs(num, i + 1, target, currValue - numStrValue, -numStrValue, currStr + "-" + numStr, result)
                    dfs(num, i + 1, target, currValue - lastOperandValue + lastOperandValue * numStrValue, lastOperandValue * numStrValue, currStr + "*" + numStr, result)

            return

        result = []
        dfs(num, 0, target, 0, 0, "", result)
        return result

    def test_Leetcode(self):
        print(self.addOperators("123", 6))
        print(self.addOperators("232", 8))
        print(self.addOperators("105", 5))
        print(self.addOperators("00", 0))
        print(self.addOperators("3456237490", 9191))

if __name__ == '__main__':
    unittest.main()