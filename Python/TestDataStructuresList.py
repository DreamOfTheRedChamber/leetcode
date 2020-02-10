# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TestDataStructuresList(unittest.TestCase):

    @unittest.skip
    def test_Create1DList(self):
        array2 = [1 for x in range(10)]
        print(array2)

    @unittest.skip
    def test_LoopThrough1DList(self):
        # Loop without index
        nameList = ['Lily', 'Brad', 'Fatima', 'Zining']
        for name in nameList:
            print(name)

        for i in range(len(nameList)):
            print(nameList[i])

    @unittest.skip
    def test_Create2DLists(self):
        array2D2 = [[0 for i in range(3)] for j in range(5)]
        print(array2D2)

    @unittest.skip
    def test_LoopThrough2DList(self):
        array2D2 = [[1, 2, 5], [3, 4]]
        for row in array2D2:
            for col in row:
                print(col)

        for row in range(len(array2D2)):
            for col in range(len(array2D2[row])):
                print(array2D2[row][col])


if __name__ == '__main__':
    unittest.main()