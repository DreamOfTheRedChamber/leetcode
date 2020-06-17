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
        union = set()
        for i in range(len(expression)):
            if expression[i] == "{":
                # normal example without comma: {a{b{c}}}
                # reason to add two if condition:
                # 1. successive left curly: {{{a}bd}c}
                # 2. left curly prefixed by comma: {a{b,{c}}}
                if not token:
                    union.add(token)
                    token = ""
                if not union:
                    expressionStack.append(union)
                    typeStack.append("{")
                    union = set()
            elif expression[i] == ",":
                # normal example with comma: {a, b, cd, e}, {a, {bc}, {d}e}
                union.add(token)
                token = ""

                expressionStack.append(union)
                typeStack.append(",")
                union = set()
            elif expression[i] == "}":
                # example: does not push stack immediately after popping out {{{c}b}a}
                if not token and not union:
                    newUnion = set()
                    for element in union:
                        newUnion.add(element + token)
                    union = newUnion
                    token = ""

                while typeStack and typeStack[-1] == ",":
                    # example: {a,b,d,c}
                    # example: will need to union all ones pushed inside due to comma: {b{a,b,d,c}c}
                    top = expressionStack.pop()
                    union.add(top)
                    typeStack.pop()

                while typeStack and typeStack[-1] == "{":
                    top = expressionStack.pop()
                    union = multiply(top, union)

            else:
                # {{{c}b}abcc}
                token += expression[i]

        return expressionStack[-1] if expressionStack else []

    def test_SimpleCase(self):
        # duplicate from comma
        print(self.braceExpansionII(""))

        # curly + curly
        print(self.braceExpansionII("{a,b}{c,d}"))

        # curly + comma
        print(self.braceExpansionII("{a{b,c}d}"))

        # only curly braces
        print(self.braceExpansionII("{ab{{de}c}}"))

        # only comma
        print(self.braceExpansionII("{a, b, c}"))

    def test_Leetcode(self):
        print(self.braceExpansionII("{a,b}{c,{d,e}}"))
        print(self.braceExpansionII("{{a,z},a{b,c},{ab,z}}"))

if __name__ == '__main__':
    unittest.main()