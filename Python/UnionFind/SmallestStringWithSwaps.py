# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class SmallestStringWithSwaps(unittest.TestCase):

    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        def find(a: int) -> int:
            if a != ancestors[a]:
                ancestors[a] = find(ancestors[a])
            return ancestors[a]

        def union(a: int, b: int):
            rootA, rootB = find(a), find(b)
            if rootA != rootB:
                ancestors[rootA] = ancestors[rootB]

        ancestors = [i for i in range(len(s))]
        for pair in pairs:
            union(pair[0], pair[1])

        groupToChars = defaultdict(list)
        for i in range(len(s)):
            heapq.heappush(groupToChars[find(i)], s[i])

        result = ""
        for i in range(len(s)):
            result += heapq.heappop(groupToChars[find(i)])

        return result

    def test_Leetcode(self):
        self.assertEqual("bacd", self.smallestStringWithSwaps("dcab", [[0,3],[1,2]]))
        self.assertEqual("abcd", self.smallestStringWithSwaps("dcab", [[0,3],[1,2],[0,2]]))
        self.assertEqual("abc", self.smallestStringWithSwaps("cba", [[0,1],[1,2]]))

if __name__ == '__main__':
    unittest.main()