# Definition for a binary tree node.
import bisect
import unittest
from dataclasses import dataclass

class TestDataStructuresBinaryAlgo(unittest.TestCase):

    def test_binaryInsertNativeNumber(self):
        result = []
        bisect.insort(result, 4)
        bisect.insort(result, 2)
        bisect.insort(result, 9)
        bisect.insort(result, 1)
        print(result)
        return

    @unittest.skip
    def test_binaryInsertObject(self):

        @dataclass
        class Person:
            first_name: str
            last_name: str
            age: int

            def __lt__(self, other):
                return self.age < other.age

        persons = []

        bisect.insort(persons, Person('John', 'Doe', 30))
        bisect.insort(persons, Person('Jane', 'Doe', 28))
        bisect.insort(persons, Person('Santa', 'Claus', 1750))

        print(persons)

if __name__ == '__main__':
    unittest.main()