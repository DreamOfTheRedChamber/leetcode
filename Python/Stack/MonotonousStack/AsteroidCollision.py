# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict
from typing import List


class AsteroidCollision(unittest.TestCase):

    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        result = []
        i = 0
        while i < len(asteroids):

            if result and result[-1] > 0 and asteroids[i] < 0:

                if asteroids[i] > -result[-1]:
                    i += 1
                elif asteroids[i] == -result[-1]:
                    result.pop()
                    i += 1
                else:
                    result.pop()
            else:
                result.append(asteroids[i])
                i += 1

        return result

    def test_Leetcode(self):
        print(self.asteroidCollision([5, 10, -5]))
        print(self.asteroidCollision([8, -8]))
        print(self.asteroidCollision([10, 2, -5]))
        print(self.asteroidCollision([-2, -1, 1, 2]))

if __name__ == '__main__':
    unittest.main()