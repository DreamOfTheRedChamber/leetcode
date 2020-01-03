# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TestDataStructureString(unittest.TestCase):

    @unittest.skip
    def test_CreateString(self):
        str1 = None
        str2 = ""

    @unittest.skip
    def test_ConcatenateString(self):
        str1 = "ab"
        str2 = "bc"
        result = str1 + str2
        print(result)

        # concatenate a list of strings with separator
        str1 = ["ab", "cd", "e", "13"]
        result = " ".join(str1)
        print(result)

    @unittest.skip
    def test_SplitString(self):
        s = " this    is   my string"
        result1 = s.split()
        result2 = s.split(' ')

    @unittest.skip
    def test_Convert(self):
        # convert int to str
        temp = 5
        tempStr = str(temp)

        temp2 = "41"
        temp2Int = int(temp2)

        print(tempStr)
        print(temp2Int)

if __name__ == '__main__':
    unittest.main()