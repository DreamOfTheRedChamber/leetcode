# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

from sortedcontainers import SortedDict


class NumOfFlowersInFullBloom(unittest.TestCase):

    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        entries = SortedDict()
        for flower in flowers:
            if flower[0] not in entries:
                entries[flower[0]] = 0
            if flower[1] + 1 not in entries:
                entries[flower[1] + 1] = 0

            entries[flower[0]] += 1
            entries[flower[1] + 1] -= 1

        prefixSum = SortedDict()
        lastValue = 0
        for key, value in entries.items():
            if key not in prefixSum:
                prefixSum[key] = 0
            prefixSum[key] = lastValue + value
            lastValue = prefixSum[key]

        prefixSum[0] = 0
        result = []
        for one in people:
            index = prefixSum.bisect_right(one)
            key, value = prefixSum.peekitem(index - 1)
            result.append(value)

        return result

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