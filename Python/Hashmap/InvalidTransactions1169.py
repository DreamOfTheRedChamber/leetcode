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

            if int(amount) > 1000:
                invalid.append(tran)

            if name in mapping:
                for existingTime, existingAmount, existingCity in mapping[name]:
                    if abs(existingTime - int(time)) <= 60 and existingCity != city:
                        existingEntry = name + ',' + str(existingTime) + ',' + str(existingAmount) + ',' + existingCity
                        invalid.append(existingEntry)
                        invalid.append(tran)

            mapping[name].append((int(time), int(amount), city))

        return invalid

    def test_example1(self):
        transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
        # ["alice,20,800,mtv","alice,50,100,beijing"]
        result = self.invalidTransactions(transactions)
        print(result)

if __name__ == '__main__':
    unittest.main()