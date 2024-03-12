# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumOfFlowersInFullBloom(unittest.TestCase):

    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        
        return []

    def test_example1(self):
        flowers = [[1, 6], [3, 7], [9, 12], [4, 13]]
        people = [2, 3, 7, 11]

        # [1,2,2,2]
        print(self.fullBloomFlowers(flowers, people))

    def test_example2(self):
        flowers = [[1, 10], [3, 3]]
        people = [3, 3, 2]

        # [2,2,1]
        print(self.fullBloomFlowers(flowers, people))


if __name__ == '__main__':
    unittest.main()