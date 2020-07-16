# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, OrderedDict
from typing import List

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1

        result = self.cache.pop(key)
        self.cache[key] = result
        return result

    def put(self, key: int, value: int) -> None:
        if key not in self.cache and len(self.cache) == self.capacity:
            oldestKey = next(iter(self.cache.keys()))
            self.cache.pop(oldestKey)

        if key in self.cache:
            self.cache.pop(key)

        self.cache[key] = value

class LruCacheTest(unittest.TestCase):

    def test_Leetcode(self):
        print([1])

if __name__ == '__main__':
    unittest.main()