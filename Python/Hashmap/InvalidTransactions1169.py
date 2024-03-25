# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class InvalidTransactions(unittest.TestCase):

    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        invalid = set()
        mapping = defaultdict(list)

        for index, tran in enumerate(transactions):
            name, time, amount, city = tran.split(',')

            if name in mapping:
                for existingTime, existingAmount, existingCity, existingIndex in mapping[name]:
                    if abs(existingTime - int(time)) <= 60 and existingCity != city:
                        invalid.add(existingIndex)
                        invalid.add(index)
            if int(amount) > 1000:
                invalid.add(index)

            mapping[name].append((int(time), int(amount), city, index))

        result = []
        for index in invalid:
            result.append(transactions[index])
        return result

    def test_example1(self):
        transactions = ["alice,20,800,mtv", "alice,50,100,beijing"]
        result = self.invalidTransactions(transactions)

        # ["alice,20,800,mtv","alice,50,100,beijing"]
        print(result)

    def test_example2(self):
        transactions = ["alice,20,800,mtv", "alice,50,100,mtv", "alice,51,100,frankfurt"]
        result = self.invalidTransactions(transactions)

        # ["alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"]
        print(result)

    def test_example3(self):
        transactions = ["alice,20,1220,mtv", "alice,20,1220,mtv"]
        result = self.invalidTransactions(transactions)

        # ["alice,20,1220,mtv", "alice,20,1220,mtv"]
        print(result)

    def test_example4(self):
        transactions = ["alice,20,800,mtv", "bob,50,1200,mtv", "alice,20,800,mtv", "alice,50,1200,mtv", "alice,20,800,mtv", "alice,50,100,beijing"]
        result = self.invalidTransactions(transactions)

        # ["alice,20,800,mtv","bob,50,1200,mtv","alice,20,800,mtv","alice,50,1200,mtv","alice,20,800,mtv","alice,50,100,beijing"]
        print(result)

    def test_example5(self):
        transactions = ["bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona", "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"]
        result = self.invalidTransactions(transactions)

        # ["bob,689,1910,barcelona","bob,832,1726,barcelona","bob,820,596,bangkok"]
        print(result)

    def test_example6(self):
        transactions = ["bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona","alex,587,402,bangkok","chalicefy,973,830,barcelona","alex,932,86,bangkok","bob,188,989,amsterdam"]
        result = self.invalidTransactions(transactions)

        # ["bob,627,1973,amsterdam","alex,387,885,bangkok","alex,355,1029,barcelona"]
        print(result)

if __name__ == '__main__':
    unittest.main()