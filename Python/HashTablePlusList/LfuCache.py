# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, OrderedDict
from typing import List


class LFUCache:

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.keyToFreq = {}  # K: key, V: (val, freq)
        # E.g. { freq 1 : {2 : None, 4 : None, 6: None}, freq 2 : {1 : None, 3 : None, 5 : None} }
        self.freqToKeyValue = defaultdict(OrderedDict)  # K: freq, V: {key : None}
        self.capacity = capacity  # self.capacity does not change
        self.minFreq = 1  # reset to 1 when new element added

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self.keyToFreq:
            return -1
        freq = self.keyToFreq.pop(key)
        value = self.freqToKeyValue[freq].pop(key)
        if len(self.freqToKeyValue[freq]) == 0 and freq == self.minFreq:
            self.minFreq = freq + 1
        self.freqToKeyValue[freq + 1][key] = value
        self.keyToFreq[key] = freq + 1
        return value

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        # Need to handle edge case of LFU cache capacity = 0.
        if self.capacity <= 0:
            return

        if key in self.keyToFreq:
            self.get(key)  # Update the key freq in dict
            self.freqToKeyValue[self.keyToFreq[key]][key] = value
            return

        if self.capacity <= len(self.keyToFreq):
            delKey, _ = self.freqToKeyValue[self.minFreq].popitem(last=False)  # pop first
            self.keyToFreq.pop(delKey)

        self.keyToFreq[key] = 1
        self.freqToKeyValue[1][key] = value
        self.minFreq = 1

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

class LFUCacheTest(unittest.TestCase):

    @unittest.skip
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
        self.assertEqual(-1, lfuCache.get(1))
        self.assertEqual(3, lfuCache.get(3))
        self.assertEqual(4, lfuCache.get(4))

    @unittest.skip
    def test_ErrorCase(self):
#        ["LFUCache", "put", "get"]
#        [[0], [0, 0], [0]]
        lfuCache = LFUCache(0)
        lfuCache.put(0,0)
        lfuCache.get(0)

    @unittest.skip
    def test_Errorcase2(self):
        lfuCache = LFUCache(10)
        lfuCache.put(10,13)
        lfuCache.put(3,17)
        lfuCache.put(6,11)
        lfuCache.put(10,5)
        lfuCache.put(9,10)
        lfuCache.get(13)
        lfuCache.put(2,19)
        lfuCache.get(2)
        lfuCache.get(3)

    def test_Errorcase3(self):
        # ["LFUCache", "put", "put", "put", "put", "get"]
        # [[2], [3, 1], [2, 1], [2, 2], [4, 4], [2]]
        lfuCache = LFUCache(2)
        lfuCache.put(3,1)
        lfuCache.put(2,1)
        lfuCache.put(2,2)
        lfuCache.put(4,4)
        lfuCache.get(2)

if __name__ == '__main__':
    unittest.main()