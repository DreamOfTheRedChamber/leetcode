# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class InvalidTransactions(unittest.TestCase):

    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        invalid = []
        mapping = defaultdict(list)

        for tran in transactions:
            name, time, amount, city = tran.split(',')
            key = name + ',' + city

            if int(amount) > 1000:
                invalid.append(tran)

            if key in mapping:
                for existingTime, existingAmount in mapping[key]:
                    if abs(existingTime - int(time)) <= 60:
                        existingEntry = key + ',' + str(existingTime) + ',' + str(existingAmount)
                        invalid.append(existingEntry)
                        invalid.append(tran)

            mapping[key].append((int(time), int(amount)))

        return invalid

    def test_example1(self):
        transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
        # ["alice,20,800,mtv","alice,50,100,beijing"]
        result = self.invalidTransactions(transactions)

if __name__ == '__main__':
    unittest.main()