# Definition for a binary tree node.
import unittest
from typing import List

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

            if source[pos] == "0":
                dfs(result, pos+1, source, target, currStr + "+" + source[pos], currValue)
                dfs(result, pos+1, source, target, currStr + "-" + source[pos], currValue)
                return

            for i in range(pos, len(source)):
                numStr = source[pos: i+1]
                num = int(numStr)

                if len(currStr) == 0:
                    dfs(result, i + 1, source, target, numStr, num)
                    dfs(result, i + 1, source, target, "-" + numStr, - num)
                else:
                    dfs(result, i + 1, source, target, currStr + "+" + numStr, currValue + num)
                    dfs(result, i + 1, source, target, currStr + "-" + numStr, currValue - num)

            return

        result = []
        dfs(result, 0, input, target, "", 0)
        return result



if __name__ == '__main__':
    unittest.main()