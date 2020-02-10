# Definition for a binary tree node.
import unittest

# Read about enumerate in python

class TestDataStructuresSet(unittest.TestCase):

    def test_SetOperations(self):
        setA = {0, 2, 4, 6, 8}
        setB = {1, 2, 3, 4, 5}
        print("Union :", setA | setB)
        print("Intersection :", setA & setB)
        print("Symmetric difference: ", setA ^ setB)

    def test_Iterate(self):
        # with single forloop
        testSet = set("geEks")
        for val in testSet:
            print(val)

        # enumeration
        for id, val in enumerate(testSet):
            print(id, val)

        # comprehension
        com = [print(val) for val in testSet]

if __name__ == '__main__':
    unittest.main()