# Definition for a binary tree node.
import unittest
from collections import defaultdict

# Read about enumerate in python

class TestDataStructureDict(unittest.TestCase):

    @unittest.skip
    def test_CreateDictionary(self):
        # default dictionary for string => string mapping
        ice_cream = defaultdict(lambda: "Vanilla")
        ice_cream['Sarah'] = 'Chunky Monkey'
        ice_cream['Abdul'] = 'Butter Pecan'
        self.assertEqual('Vanilla', ice_cream['joe'])

        # default dictionary for string => int mapping
        food_list = 'spam spam eggs'.split()
        food_count = defaultdict(lambda: 1)
        for food in food_list:
            food_count[food] += 1
        self.assertEqual(2, food_count['eggs'])
        self.assertEqual(3, food_count['spam'])

        # default dictionary for string => list mapping
        city_list = [('TX', 'Austin'), ('TX', 'Houston'), ('NY', 'Albany'), ('NY', 'Syracuse'), ('NY', 'Buffalo'),
                     ('NY', 'Rochester'), ('TX', 'Dallas'), ('CA', 'Sacramento'), ('CA', 'Palo Alto'),
                     ('GA', 'Atlanta')]
        cities_by_state = defaultdict(lambda: [])
        for state, city in city_list:
            cities_by_state[state].append(city)
        for state, cities in cities_by_state.items():
            print(state, ', '.join(cities))

    @unittest.skip
    def test_Loop(self):
        # Loop through tuples, keys, values
        dictionary = {'color': 'blue', 'fruit': 'apple', 'pet': 'dog'}
        for item in dictionary.items():
            print(item)
        for key in dictionary.keys():
            print(key)
        for value in dictionary.values():
            print(value)


    @unittest.skip
    def test_LoopInOrder(self):
        dictionary = {'apple': 5600.00, 'orange': 3500.00, 'banana': 5000.00}

        # Loop through according to key or value
        for key in sorted(dictionary):
            print(key, '->', dictionary[key])
        for key in sorted(dictionary, reverse=True):
            print(key, '->', dictionary[key])
        for value in sorted(dictionary.values()):
            print(value)
        for value in sorted(dictionary.values(), reverse=True):
            print(value)

        # Loop through according to sorted key or value order
        for k, v in sorted(dictionary.items(), key=self.by_value):
            print(k, '->', v)
        for k, v in sorted(dictionary.items(), key=self.by_key):
            print(k, '->', v)

    @unittest.skip
    def test_DeleteElement(self):
        dictionary = {'color': 'blue', 'fruit': 'apple', 'pet': 'dog'}
        removed_value = dictionary.pop('pet')
        print(dictionary)
        print(removed_value)

        del dictionary['fruit']
        print(dictionary)

    def test_NestedDefaultDict(self):
        myDict = defaultdict(lambda: defaultdict(dict))

if __name__ == '__main__':
    unittest.main()