# Definition for a binary tree node.
import heapq
import random
import unittest
from collections import defaultdict
from math import floor


class RandomizedCollection:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.valueToIndexList = defaultdict(set)
        self.values = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        """
        result = True
        if val in self.valueToIndexList:
            result = False

        self.values.append(val)
        self.valueToIndexList[val].add(len(self.values) - 1)
        return result

    def remove(self, val: int) -> bool:
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        """
        if val not in self.valueToIndexList:
            return False

        firstIndex = next(iter(self.valueToIndexList[val]))
        lastIndex = len(self.values) - 1

        # error condition where firstIndex != lastIndex
        if firstIndex not in self.valueToIndexList[self.values[-1]]:
            lastIndexVal = self.values[-1]

            # swap
            tmp = self.values[firstIndex]
            self.values[firstIndex] = lastIndexVal
            self.values[lastIndex] = tmp

            self.valueToIndexList[lastIndexVal].remove(lastIndex)
            self.valueToIndexList[lastIndexVal].add(firstIndex)
            self.valueToIndexList[val].remove(firstIndex)
            self.valueToIndexList[val].add(lastIndex)

        # remove
        self.values.pop()
        self.valueToIndexList[val].remove(lastIndex)
        if not self.valueToIndexList[val]:
            self.valueToIndexList.pop(val)

        return True

    def getRandom(self) -> int:
        """
        Get a random element from the collection.
        """
        randomNum = floor(random.random() * len(self.values))
        return self.values[randomNum]


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

class InsertDeleteGetRandomO1Duplicate(unittest.TestCase):

    @unittest.skip
    def test_WrongAnswer(self):
        # ["RandomizedCollection", "insert", "insert", "remove", "insert", "remove", "getRandom"]
        # [[], [0], [1], [0], [2], [1], []]
        collect = RandomizedCollection()
        collect.insert(0)
        collect.insert(1)
        collect.remove(0)
        collect.insert(2)
        collect.remove(1)
        print(collect.getRandom())
        return

    def test_WrongAnswer2(self):
        # ["RandomizedCollection", "insert", "insert", "insert", "insert", "insert", "insert", "remove", "remove",
        # "remove", "remove", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom",
        # "getRandom", "getRandom", "getRandom"]
        # [[], [1], [1], [2], [1], [2], [2], ------ [1], [2], [2], [2], [], [], [], [], [], [], [], [], [], []]
        # output:   [null,true,false,true,false,false,false,true,true,true,true,2,2,2,2,2,1,1,1,2,2]
        # expected: [null,true,false,true,false,false,false,true,true,true,true,1,1,1,1,1,1,1,1,1,1]
        collect = RandomizedCollection()
        collect.insert(1)
        collect.insert(1)
        collect.insert(2)
        collect.insert(1)
        collect.insert(2)
        collect.insert(2)

        collect.remove(1)
        collect.remove(2)
        collect.remove(2)
        collect.remove(2)
        return

if __name__ == '__main__':
    unittest.main()