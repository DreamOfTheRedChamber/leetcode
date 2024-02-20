# Definition for a binary tree node.
import unittest
from typing import List

""""
题目是给一串数字（0 - 9）每个数字之间可以加 + - 号或者不加，组成的表达式计算结果等于 给定的目标数，输出所有满足条件的表达式。
例如： [1 2 3 4 5 6 7 8 9],目标 100
可能的组合：
1 + 23 - 4 + 56 + 7 + 8 + 9
-1 - 2 + 34 - 5 - 6 + 78 + 9
"""

class ExpressionDfs(unittest.TestCase):

    def test_Normal(self):
        result = self.calculateExpression("123456789", 100)
        for entry in result:
            print(entry)
        return

    def calculateExpression(self, input: str, target: int) -> List[str]:

        def dfs(result: List[str], pos: int, source: str, target: int, currStr: str, currValue: int):
            if pos == len(source):
                if currValue == target:
                    result.append(currStr)
                return

            for i in range(pos, len(source)):
                numStr = source[pos: i+1]
                num = int(numStr)

                if len(numStr) > 1 and numStr[0] == "0":
                    continue

                if len(currStr) == 0:
                    dfs(result, i + 1, source, target, numStr, num)
                else:
                    dfs(result, i + 1, source, target, currStr + "+" + numStr, currValue + num)
                    dfs(result, i + 1, source, target, currStr + "-" + numStr, currValue - num)

            return

        expressions = []
        dfs(expressions, 0, input, target, "", 0)
        return expressions

if __name__ == '__main__':
    unittest.main()