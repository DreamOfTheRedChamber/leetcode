# Definition for a binary tree node.
import unittest
from typing import List

class GenerateParentheses(unittest.TestCase):

    def generateParenthesis(self, n: int) -> List[str]:
        allResults = []
        self.generateRecursively(allResults, "", 0, n)
        return allResults

    def generateRecursively(self, allResults: List[str], oneResult: str, leftUnmatched: int, leftRemained: int):
        if leftUnmatched == 0 and leftRemained == 0:
            allResults.append(oneResult)
            return

        if leftUnmatched > 0:
            self.generateRecursively(allResults, oneResult + ')', leftUnmatched - 1, leftRemained)

        if leftRemained > 0:
            self.generateRecursively(allResults, oneResult + '(', leftUnmatched + 1, leftRemained - 1)

    def test_Normal(self):
        result = self.generateParenthesis(2)
        print(result)

if __name__ == '__main__':
    unittest.main()