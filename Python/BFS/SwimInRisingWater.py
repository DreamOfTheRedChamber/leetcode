# Definition for a binary tree node.
import heapq
import unittest

# Read about enumerate in python
from collections import defaultdict, deque
from typing import List

class SwimInRisingWater(unittest.TestCase):

    def swimInWater(self, grid: List[List[int]]) -> int:
        # edge case
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0

        # bfs
        height = len(grid)
        width = len(grid[0])
        currTime = 0
        visited = [[False for j in range(width)] for i in range(height)]
        neighborsNotReachable = [(max(currTime, grid[0][0]), 0, 0)]
        while neighborsNotReachable:
            currTime, neighborX, neighborY = heapq.heappop(neighborsNotReachable)
            # TODO: Watch how others implement the DS
            # TODO: How to initialize deque
            reachableAtTime = deque()
            reachableAtTime.append((neighborX, neighborY))
            visited[neighborX][neighborY] = True
            while reachableAtTime:
                xCor, yCor = reachableAtTime.popleft()

                if xCor == height - 1 and yCor == width - 1:
                    return currTime

                directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
                for dir in directions:
                    nextX = xCor + dir[0]
                    nextY = yCor + dir[1]
                    if 0 <= nextX < height and 0 <= nextY < width and not visited[nextX][nextY]:
                        if grid[nextX][nextY] <= currTime:
                            reachableAtTime.append((nextX, nextY))
                            visited[nextX][nextY] = True
                        else:
                            heapq.heappush(neighborsNotReachable, (grid[nextX][nextY], nextX, nextY))

        return -1

    @unittest.skip
    def test_Leetcode(self):
        self.assertEqual(3, self.swimInWater([[0, 2], [1, 3]]))
        self.assertEqual(2, self.swimInWater([[0, 2, 2], [2, 7, 4], [2, 1, 1]]))

        self.assertEqual(16, self.swimInWater([[0, 1, 2, 3, 4], [24, 23, 22, 21, 5], [12, 13, 14, 15, 16], [11, 17, 18, 19, 20], [10, 9, 8, 7, 6]]))

    @unittest.skip
    def test_Edgecase(self):
        self.assertEqual(0, self.swimInWater([[0, 0], [0, 0]]))
        self.assertEqual(1, self.swimInWater([[1, 0], [0, 0]]))

    def test_TimeLimitExceeded(self):
        print(self.swimInWater([[375,396,190,333,304,65,99,262,214,344,167,328,124,207,253,173,55,243,132,163],[22,12,223,298,387,238,237,213,332,379,228,128,280,225,103,114,109,64,271,172],[359,26,80,18,370,372,206,346,342,363,184,11,393,317,291,362,194,308,274,188],[288,158,153,260,278,296,40,231,397,334,4,7,181,219,189,101,54,112,292,25],[391,195,165,268,248,388,143,266,87,250,204,358,187,275,32,127,66,115,146,234],[313,218,8,19,50,164,279,23,182,73,392,74,149,323,107,283,203,302,148,28],[326,162,301,41,131,306,96,200,160,44,137,300,398,170,94,309,38,16,83,129],[245,339,72,310,117,140,264,366,252,314,361,282,230,353,325,374,180,351,68,77],[205,340,367,169,209,255,221,152,226,354,381,319,285,136,138,175,389,273,35,142],[286,249,395,81,390,37,303,338,220,71,242,399,82,176,168,263,299,51,1,125],[198,355,133,15,210,151,376,294,3,235,336,76,113,281,122,110,257,343,246,159],[394,92,384,316,123,211,324,329,5,284,212,239,48,224,196,9,236,119,147,233],[20,24,331,183,90,45,106,201,70,276,186,320,13,256,202,91,352,69,178,11]]))

if __name__ == '__main__':
    unittest.main()