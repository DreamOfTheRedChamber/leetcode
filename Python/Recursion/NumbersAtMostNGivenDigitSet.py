# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumbersAtMostNGivenDigitSet(unittest.TestCase):

    def atMostNGivenDigitSet(self, D: List[str], N: int) -> int:

        def recursion(currNum: str, N: str, pos: int, D: List[str]) -> int:
            if pos > len(N):
                return 0

            if len(currNum) == len(N):
                return 1

            result = 0
            for candidate in D:
                if candidate < N[pos]:
                    result += len(D) ** (len(N) - 1 - pos)
                    for i in range(pos+1, len(N)):
                        result += len(D) ** i
                elif candidate == N[pos]:
                    currNum += candidate
                    result += recursion(currNum, N, pos + 1, D)
                else:
                    continue

            return result

        result = 0
        length = len(str(N))
        for i in range(1, length):
            result += len(D) ** i

        result += recursion("", str(N), 0, D)
        return result

    def test_Leetcode(self):
        self.assertEqual(20, self.atMostNGivenDigitSet(["1","3","5","7"], 100))
        self.assertEqual(29523, self.atMostNGivenDigitSet(["1","4","9"], 1000000000))

if __name__ == '__main__':
    unittest.main()