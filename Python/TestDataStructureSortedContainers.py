# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from sortedcontainers import SortedList, SortedSet, SortedDict


class TestDataStructuresSortedContainers(unittest.TestCase):

    @unittest.skip
    def test_SortedList(self):
        # construct
        sorted_list = SortedList([1, 2, 3, 4])
        sorted_list = SortedList()

        # add
        for i in range(5, 0, -1):
            sorted_list.add(i)

        # adding elements using the update() function
        elements = [10, 9, 8, 7, 6]
        sorted_list.update(elements)

        # prints the updated list in sorted order
        print('list after updating: ', sorted_list)

        # removing a particular element using value
        sorted_list.discard(8)
        # removing all elements
        sorted_list.clear()
        print('list after removing all elements using clear: ', sorted_list)

        return

    def test_SortedSet(self):
        # construct
        sorted_set = SortedSet([1, 5, 2, 7, 4])

        # inserting values one by one
        for i in range(5, 0, -1):
            sorted_set.add(i)
        print('set after adding elements: ', sorted_set)

        # inserting duplicate value
        sorted_set.add(5)
        print('set after inserting duplicate element: ', sorted_set)

        # discarding an element
        sorted_set.discard(4)
        print('set after discarding: ', sorted_set)

        for i in sorted_set:
            print(i)

    @unittest.skip
    def test_SortedDict(self):
        # construct
        sorted_dict = SortedDict({'a': 1, 'c': 2, 'b': 3})
        print('sorted dict is: ', sorted_dict)

        # adding key => value pairs
        sorted_dict['d'] = 3
        print('sorted dict after adding an element: ', sorted_dict)

        # adding element using setdefault()
        sorted_dict.setdefault('e', 4)
        print('sorted dict after setdefault(): ', sorted_dict)

        # using the get function
        print('using the get function to print the value of a: ', sorted_dict.get('a', 0))
        for key in sorted_dict:
            print('{} -> {}'.format(key, sorted_dict[key]), end=' ')
        print()

        # removing all elements from the dict
        sorted_dict.clear()

    def test_SortedDict_IncDecOrder(self):

        # pop out keys in increasing order
        sorted_dict = SortedDict({'a': 3, 'c': 1, 'b': 2, 'd': 4})
        while sorted_dict:
            print(sorted_dict.peekitem(0))

        print("\n")

        # pop out keys in decreasing order
        sorted_dict = SortedDict({'a': 3, 'c': 1, 'b': 2, 'd': 4})
        while sorted_dict:
            print(sorted_dict.popitem(-1))

if __name__ == '__main__':
    unittest.main()