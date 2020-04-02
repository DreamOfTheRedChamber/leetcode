# Definition for a binary tree node.
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class MaxNumberOfFamilies(unittest.TestCase):

    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        leftSet = {2, 3, 4, 5}
        middleSet = {4, 5, 6, 7}
        rightSet = {6, 7, 8, 9}

        sortedReserved = defaultdict(set)
        for seat in reservedSeats:
            sortedReserved[seat[0]].add(seat[1])

        numOfFamilies = 0
        for i in range(1, n + 1):
            reserved = sortedReserved[i]
            left = leftSet & reserved
            right = rightSet & reserved
            middle = middleSet & reserved
            leftSeatAva = len(leftSet & reserved) == 0
            rightSeatAva = len(rightSet & reserved) == 0
            middleSeatAva = len(middleSet & reserved) == 0

            if leftSeatAva and rightSeatAva:
                numOfFamilies += 2
            else:
                if leftSeatAva or rightSeatAva or middleSeatAva:
                    numOfFamilies += 1

        return numOfFamilies

    def test_leetcode(self):
        self.assertEqual(4, self.maxNumberOfFamilies(3, [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]))

if __name__ == '__main__':
    unittest.main()