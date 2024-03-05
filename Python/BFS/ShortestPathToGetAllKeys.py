# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class ShortestPathToGetAllKeys(unittest.TestCase):

    def shortestPathAllKeys(self, grid: List[str]) -> int:

        if len(grid) == 0 or len(grid[0]) == 0:
            return 0

        # count unique keys
        height = len(grid)
        width = len(grid[0])
        startX, startY = 0, 0
        count = 0
        for i in range(height):
            for j in range(width):
                if "a" <= grid[i][j] <= "z":
                    count += 1
                if grid[i][j] == "@":
                    startX = i
                    startY = j

        if count == 0:
            return 0
        finalState = 0
        for i in range(count):
            finalState |= (1 << i)

        # bfs
        visited = defaultdict(set)
        state = 0
        bfsQueue = deque([(startX, startY, state)])
        visited[(startX,startY)].add(state)
        distance = 1
        while bfsQueue:
            levelSize = len(bfsQueue)
            for i in range(levelSize):
                headX, headY, state = bfsQueue.popleft()
                directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
                for dir in directions:
                    nextX = headX + dir[0]
                    nextY = headY + dir[1]
                    if 0 <= nextX < height and 0 <= nextY < width:
                        nextState = state
                        if grid[nextX][nextY] == "#":
                            continue
                        elif "a" <= grid[nextX][nextY] <= "z":
                            nextState |= 1 << (ord(grid[nextX][nextY]) - ord("a"))
                            if nextState not in visited[(nextX, nextY)]:
                                bfsQueue.append((nextX, nextY, nextState))
                                visited[(nextX, nextY)].add(nextState)
                                if nextState == finalState:
                                    return distance

                        elif "A" <= grid[nextX][nextY] <= "Z":
                            requiredKey = ord(grid[nextX][nextY]) - ord("A")
                            hasKey = (1 << requiredKey) & state
                            if hasKey and state not in visited[(nextX, nextY)]:
                                bfsQueue.append((nextX, nextY, nextState))
                                visited[(nextX, nextY)].add(nextState)
                        else:
                            if state not in visited[(nextX, nextY)]:
                                bfsQueue.append((nextX, nextY, nextState))
                                visited[(nextX, nextY)].add(nextState)

            distance += 1

        return -1

    def test_Leetcode(self):
        self.assertEqual(8, self.shortestPathAllKeys(["@.a.#","###.#","b.A.B"]))
        self.assertEqual(6, self.shortestPathAllKeys(["@..aA","..B#.","....b"]))

    def test_Edgecase(self):
        self.assertEqual(-1, self.shortestPathAllKeys(["@....","ABCDE","abcde"]))
        self.assertEqual(0, self.shortestPathAllKeys(["@"]))

        # @ is not at 0,0
        self.assertEqual(8, self.shortestPathAllKeys(["..a.#","###@#","b.A.B"]))

    def test_WrongAnswer(self):
        self.assertEqual(10, self.shortestPathAllKeys(["@...a",".###A","b.BCc"]))

if __name__ == '__main__':
    unittest.main()