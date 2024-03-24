# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List

class NumOfVisiblePeopleInQueue(unittest.TestCase):

    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        decStack = []
        result = []
        for i in reversed(range(len(heights))):
            if not decStack:
                result.append(0)
                decStack.append(heights[i])
            else:
                poppedNum = 0
                while decStack and decStack[-1] < heights[i]:
                    decStack.pop()
                    poppedNum += 1

                if decStack:
                    result.append(poppedNum+1)
                else:
                    result.append(poppedNum)

                decStack.append(heights[i])

        return reversed(result)

    def test_example1(self):
        heights = [10, 6, 8, 5, 11, 9]
        # [3,1,2,1,1,0]
        result = self.canSeePersonsCount(heights)
        print(' '.join(map(str, result)))

    def test_example2(self):
        heights = [5, 1, 2, 3, 10]
        # [4,1,1,1,0]
        result = self.canSeePersonsCount(heights)
        print(' '.join(map(str, result)))

if __name__ == '__main__':
    unittest.main()