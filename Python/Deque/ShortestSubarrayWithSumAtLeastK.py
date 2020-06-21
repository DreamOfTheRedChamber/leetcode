# Definition for a binary tree node.
import heapq
import sys
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class ShortestSubarrayWithSumAtLeastK(unittest.TestCase):

    def shortestSubarray(self, A: List[int], K: int) -> int:

        prefixSum = [0 for i in range(len(A) + 1)]
        for i in range(len(A)):
            prefixSum[i+1] = prefixSum[i] + A[i]

        result = float('inf')
        incDeque = deque()
        incDeque.append(0)
        for j in range(1, len(prefixSum)):
            while incDeque and prefixSum[incDeque[0]] + K <= prefixSum[j]:
                result = min(result, j - incDeque[0])
                incDeque.popleft()
            while incDeque and prefixSum[incDeque[-1]] >= prefixSum[j]:
                incDeque.pop()

            incDeque.append(j)

        return -1 if result == float('inf') else result

    def test_Leetcode(self):
        self.assertEqual(1, self.shortestSubarray([1], 1))
        self.assertEqual(-1, self.shortestSubarray([1, 2], 4))
        self.assertEqual(3, self.shortestSubarray([2, -1, 2], 3))

    def test_Edgecase(self):
        self.assertEqual(2, self.shortestSubarray([1, 3, -2, 3, -5, 3, 2], 5))
        self.assertEqual(1, self.shortestSubarray([1, 3, -2, 4, -5, 3, 2], 4))

#                  5

# prefix sum [0, 1, 4, 2, 5, 0, 3, 5]
# [0]
# [0 1]
# [0 1 4]
# [0 1 2]
# [1 2 5] result = 4
# [0]
# [0 3]
# [0 3 5] result = 2

# prefix[j] - K >= prefix[i]

# deque maintains a decreasing order
# put into deque tail: put prefix[j] into deque, pop out when prefix[k] > prefix[j] because k won't be selected when compared with j

# delete from deque head: look from head, pop out when prefix[k] > prefix[j] - K



if __name__ == '__main__':
    unittest.main()