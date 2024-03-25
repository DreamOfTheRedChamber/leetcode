# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class InvalidTransactions(unittest.TestCase):

    def invalidTransactions(self, transactions: List[str]) -> List[str]:
        invalid = []
        existingDup = set()
        mapping = defaultdict(list)

        for tran in transactions:
            name, time, amount, city = tran.split(',')

            if int(amount) > 1000:
                invalid.append(tran)

            elif name in mapping:
                isInvalid = False
                for existingTime, existingAmount, existingCity in mapping[name]:
                    if abs(existingTime - int(time)) <= 60 and existingCity != city:
                        existingEntry = name + ',' + str(existingTime) + ',' + str(existingAmount) + ',' + existingCity
                        existingDup.add(existingEntry)
                        isInvalid = True

                if isInvalid:
                    invalid.append(tran)

            mapping[name].append((int(time), int(amount), city))

        for entry in existingDup:
            invalid.append(entry)

        return invalid

    @unittest.skip
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

    @unittest.skip
    def test_example3(self):
        transactions = ["alice,20,1220,mtv", "alice,20,1220,mtv"]
        result = self.invalidTransactions(transactions)

        # ["alice,20,1220,mtv", "alice,20,1220,mtv"]
        print(result)

if __name__ == '__main__':
    unittest.main()