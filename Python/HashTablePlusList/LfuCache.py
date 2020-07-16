# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, OrderedDict
from typing import List


class LFUCache:

    def __init__(self, capacity: int):
        self.keyToFreq = defaultdict(lambda: 0)
        self.freqToItems = defaultdict(OrderedDict)
        self.minFreq = 1
        self.capacity = capacity
        return

    def get(self, key: int) -> int:
        if key not in self.keyToFreq:
            return -1

        if self.keyToFreq[key] == 1 and len(self.freqToItems[1]) == 1:
            self.minFreq += 1

        originFreq = self.keyToFreq[key]
        result = self.freqToItems[originFreq].pop(key)

        self.keyToFreq[key] += 1
        self.freqToItems[self.keyToFreq[key]][key] = result

        return result

    def put(self, key: int, value: int) -> None:
        if self.capacity <= 0:
            return

        if key in self.keyToFreq:
            self.get(key)
            self.freqToItems[self.keyToFreq[key]][key] = value
        else:
            if len(self.keyToFreq) == self.capacity:
                minFreqCollection = self.freqToItems[self.minFreq]
                oldestKey = next(iter(minFreqCollection.keys()))
                self.freqToItems[self.minFreq].pop(oldestKey)
                self.keyToFreq.pop(oldestKey)

            self.keyToFreq[key] = 1
            self.freqToItems[1][key] = value
            self.minFreq = 1

        return

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

class LFUCacheTest(unittest.TestCase):

    def test_Leetcode(self):
 #       ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 #       [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
        lfuCache = LFUCache(2)
        lfuCache.put(1,1)
        lfuCache.put(2,2)
        self.assertEqual(1, lfuCache.get(1))
        lfuCache.put(3,3)
        self.assertEqual(-1, lfuCache.get(2))
        self.assertEqual(3, lfuCache.get(3))
        lfuCache.put(4,4)

    def test_ErrorCase(self):
#        ["LFUCache", "put", "get"]
#        [[0], [0, 0], [0]]
        lfuCache = LFUCache(0)
        lfuCache.put(0,0)
        lfuCache.get(0)
    def test_Errorcase2(self):
 #       ["LFUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put",
 #        "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get",
 #        "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put",
 #        "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put",
 #        "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put",
 #        "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put",
 #        "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"]
 #       [[10], [10, 13], [3, 17], [6, 11], [10, 5], [9, 10], [13], [2, 19], [2], [3], [5, 25], [8], [9, 22], [5, 5],
 #        [1, 30], [11], [9, 12], [7], [5], [8], [9], [4, 30], [9, 3], [9], [10], [10], [6, 14], [3, 1], [3], [10, 11],
 #        [8], [2, 14], [1], [5], [4], [11, 4], [12, 24], [5, 18], [13], [7, 23], [8], [12], [3, 27], [2, 12], [5],
 #        [2, 9], [13, 4], [8, 18], [1, 7], [6], [9, 29], [8, 21], [5], [6, 30], [1, 12], [10], [4, 15], [7, 22],
 #        [11, 26], [8, 17], [9, 29], [5], [3, 4], [11, 30], [12], [4, 29], [3], [9], [6], [3, 4], [1], [10], [3, 29],
 #        [10, 28], [1, 20], [11, 13], [3], [3, 12], [3, 8], [10, 9], [3, 26], [8], [7], [5], [13, 17], [2, 27],
 #        [11, 15], [12], [9, 19], [2, 15], [3, 16], [1], [12, 17], [9, 1], [6, 19], [4], [5], [5], [8, 1], [11, 7],
 #        [5, 2], [9, 28], [1], [2, 2], [7, 4], [4, 22], [7, 24], [9, 26], [13, 28], [11, 26]]

if __name__ == '__main__':
    unittest.main()