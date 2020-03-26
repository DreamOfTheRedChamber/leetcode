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

    def test_AppendList(self):
        arr = [0, 2, 4, 5]
        print(arr + [0, 5])

    @unittest.skip
    def test_RemoveItemFromList(self):
        arr = [1, 9, 10, 4, 25, 2]

        # remove an item by index and get its value: pop()
        print(arr.pop(3))
        print(arr.pop(-3))
        print(arr.pop())  # the last item will be removed by default

        # remove an item by value
        itemList = ['Alice', 'Bob', 'Charlie', 'Bob', 'Dave']
        # the first one will be deleted
        print(itemList.remove('Bob'))

        # list comprehensions
        l = list(range(10))
        print([i for i in l if i % 2 == 0])


if __name__ == '__main__':
    unittest.main()