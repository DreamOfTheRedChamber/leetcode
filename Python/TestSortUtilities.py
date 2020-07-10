# Definition for a binary tree node.
import heapq
import unittest

class TestSortUtilities(unittest.TestCase):


    @unittest.skip
    def test_Sort1DList(self):
        a = [3, 6, 8, 2, 78, 1, 23, 45, 9]

        # sorted() - not modifying the original list and return a new sorted one
        sortedA = sorted(a)

        # .sort() - in-place sorting on the list
        a.sort()

    def test_Sort1DTuple(self):
        tuple = [(4, 2), (0, 3), (0, 1)]
        result = sorted(tuple, key=lambda x: (x[0], -x[1]))
        print(result)

if __name__ == '__main__':
    unittest.main()