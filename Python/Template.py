# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class Template(unittest.TestCase):

    def printVertically(self, s: str) -> list:
        splitS = s.split(' ')
        maxLength = 0
        for word in splitS:
            maxLength = max(len(word), maxLength)

        resultList = []
        for i in range(maxLength):
            oneResult = []
            for j in range(len(splitS)):
                if len(splitS[j]) - 1 >= i:
                    oneResult.append(splitS[j][i])
                else:
                    oneResult.append(' ')

            oneResultStr = "".join(oneResult)
            resultList.append(oneResultStr.rstrip(' '))

        finalResult = " ".join(resultList)
        return finalResult

    def test_Test1(self):
        str1 = "TO BE OR NOT TO BE"
        print(self.printVertically(str1))

        str2 = "HOW ARE YOU"
        print(self.printVertically(str2))

    @unittest.skip
    def test_Test2(self):
        str1 = "ab"
        str2 = "bc"
        result = str1 + str2
        print(result)

if __name__ == '__main__':
    unittest.main()