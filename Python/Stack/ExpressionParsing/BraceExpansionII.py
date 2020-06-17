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
            for aElement in setA:
                for bElement in setB:
                    result.add(aElement+bElement)
            return result

        typeStack = []
        expressionStack = []
        token = ""
        curSet = set()
        for i in range(len(expression)):
            if expression[i] == "{":
                # normal example without comma: {a{b{c}}}
                # reason to add two if condition:
                # 1. successive left curly: {{{a}bd}c}
                # 2. left curly prefixed by comma: {a{b,{c}}}
                if token and curSet:
                    newUnion = set()
                    for element in curSet:
                        newUnion.add(element + token)
                    curSet = newUnion
                    token = ""
                if token:
                    curSet.add(token)
                    token = ""
                if curSet:
                    expressionStack.append(curSet)
                    typeStack.append("{")
                    curSet = set()
            elif expression[i] == ",":
                # normal example with comma: {a, b, cd, e}, {a, {bc}, {d}e}
                # avoid pushing empty token and union: {a{b,c},{ab,z}}
                if token:
                    curSet.add(token)
                    token = ""
                if curSet:
                    expressionStack.append(curSet)
                    typeStack.append(",")
                    curSet = set()
            elif expression[i] == "}":
                # example: does not push stack immediately after popping out {{{c}b}a}

                if token:
                    curSet.add(token)
                    token = ""

                while typeStack and typeStack[-1] == ",":
                    # example: {a,b,d,c}
                    # example: will need to curSet all ones pushed inside due to comma: {b{a,b,d,c}c}
                    top = expressionStack.pop()
                    curSet = curSet.union(top)
                    typeStack.pop()

                while typeStack and typeStack[-1] == "{":
                    top = expressionStack.pop()
                    typeStack.pop()
                    curSet = multiply(top, curSet)

            else:
                # {{{c}b}abcc}
                token += expression[i]

        return list(sorted(curSet)) if curSet else []

    def test_SimpleCase(self):
        # only comma
        print(self.braceExpansionII("{a,b,c}"))

        # curly + comma
        print(self.braceExpansionII("{a{b,c}d}"))

        # duplicate from comma
        print(self.braceExpansionII(""))

        # curly + curly
        print(self.braceExpansionII("{a,b}{c,d}"))

        # only curly braces
        print(self.braceExpansionII("{ab{{de}c}}"))

    @unittest.skip
    def test_Leetcode(self):
        print(self.braceExpansionII("{a,b}{c,{d,e}}"))
        print(self.braceExpansionII("{{a,z},a{b,c},{ab,z}}"))

    @unittest.skip
    def test_WrongAnswer(self):
        print(self.braceExpansionII("{a,b}c{d,e}f"))

if __name__ == '__main__':
    unittest.main()