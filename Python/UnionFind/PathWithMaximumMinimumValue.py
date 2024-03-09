import unittest
from typing import List

class PathWithMaximumMinimumValue(unittest.TestCase):

    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        def find(x):
            if x != root[x]:
                root[x] = find(root[x])
            return root[x]

        # Union the roots of x and y.
        def union(x, y):
            root_x = find(x)
            root_y = find(y)
            if root_x != root_y:
                if rank[root_x] > rank[root_y]:
                    root[root_y] = root_x
                elif rank[root_x] < rank[root_y]:
                    root[root_x] = root_y
                else:
                    root[root_y] = root_x
                    rank[root_x] += 1

        if len(grid) == 0 or len(grid[0]) == 0:
            print("Error")

        height = len(grid)
        width = len(grid[0])

        # ds for union-find algorithm
        root = [i for i in range(height * width)]
        rank = [1 for i in range(height * width)]

        cors = []
        for i in range(height):
            for j in range(width):
                cors.append((i, j))
        cors.sort(key=lambda x: grid[x[0]][x[1]], reverse=True)

        visited = [[False for j in range(width)] for i in range(height)]

        # for items in descending order
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        for i in range(len(cors)):
            xCor, yCor = cors[i]
            index = xCor * width + yCor
            visited[xCor][yCor] = True

            for dir in dirs:
                xNext = xCor + dir[0]
                yNext = yCor + dir[1]
                nextIndex = xNext * width + yNext

                if 0 <= xNext < height and 0 <= yNext < width and visited[xNext][yNext]:
                    union(index, nextIndex)

            rootStart = find(0)
            rootEnd = find(height * width - 1)
            if rootStart == rootEnd:
                return grid[xCor][yCor]

        return -1

    def test_example1(self):
        matrix = [[5,4,5],[1,2,6],[7,4,6]]
        self.assertEqual(4, self.maximumMinimumPath(matrix))

    def test_example2(self):
        matrix = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
        self.assertEqual(2, self.maximumMinimumPath(matrix))

    def test_example3(self):
        matrix = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
        self.assertEqual(3, self.maximumMinimumPath(matrix))

if __name__ == '__main__':
    unittest.main()