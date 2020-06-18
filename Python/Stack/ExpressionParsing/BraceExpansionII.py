# Definition for a binary tree node.
import heapq
import string
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class BraceExpansionII(unittest.TestCase):

    def braceExpansionII(self, expression: str) -> List[str]:

        def multiply(setA: set, setB: set) -> set:
            result = set()
            if not setA:
                setA.add("")
            if not setB:
                setB.add("")
            for aElement in setA:
                for bElement in setB:
                    result.add(aElement+bElement)
            return result

        processedExp = ""
        for i in range(len(expression)):
            if expression[i].isalpha():
                processedExp += "{"
                processedExp += expression[i]
                processedExp += "}"
            else:
                processedExp += expression[i]

        typeStack = []
        expressionStack = []
        curSet = set()
        i = 0
        while i < len(processedExp):
            if processedExp[i] == "{":
                # normal example without comma: {a{b{c}}}
                # reason to add two if condition:
                # 1. successive left curly: {{{a}bd}c}
                # 2. left curly prefixed by comma: {a{b,{c}}}
                expressionStack.append(curSet)
                typeStack.append("{")
                curSet = set()
                i += 1
            elif processedExp[i] == ",":
                # normal example with comma: {a, b, cd, e}, {a, {bc}, {d}e}
                # avoid pushing empty token and union: {a{b,c},{ab,z}}
                expressionStack.append(curSet)
                typeStack.append(",")
                curSet = set()
                i += 1
            elif processedExp[i] == "}":
                # example: does not push stack immediately after popping out {{{c}b}a}
                while typeStack and typeStack[-1] == ",":
                    # example: {a,b,d,c}
                    # example: will need to curSet all ones pushed inside due to comma: {b{a,b,d,c}c}
                    curSet = curSet.union(expressionStack[-1])
                    expressionStack.pop()
                    typeStack.pop()
                if typeStack and typeStack[-1] == "{":
                    curSet = multiply(expressionStack[-1], curSet)
                    typeStack.pop()
                    expressionStack.pop()
                i += 1
            else:
                # {{{c}b}{a}{b}{c}{c}}
                end = i + 1
                while end < len(processedExp) and processedExp[end].isalpha():
                    end += 1
                curSet = {processedExp[i: end]}
                i = end

        return list(sorted(curSet)) if curSet else []

    def test_SimpleCase(self):
        # only comma
        # print(self.braceExpansionII("{a,b,c}"))

        # curly + comma
        print(self.braceExpansionII("{a{b,c}d}"))

        # duplicate from comma
        # print(self.braceExpansionII(""))

        # curly + curly
        # print(self.braceExpansionII("{a,b}{c,d}"))

        # only curly braces
        # print(self.braceExpansionII("{ab{{de}c}}"))

    @unittest.skip
    def test_Leetcode(self):
        print(self.braceExpansionII("{a,b}{c,{d,e}}"))
        print(self.braceExpansionII("{{a,z},a{b,c},{ab,z}}"))

    @unittest.skip
    def test_WrongAnswer(self):
        print(self.braceExpansionII("{a,b}c{d,e}f"))

if __name__ == '__main__':
    unittest.main()