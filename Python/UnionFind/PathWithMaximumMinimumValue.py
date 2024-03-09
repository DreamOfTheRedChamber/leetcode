from typing import List

class PathWithMaximumMinimumValue:

    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        def union(a: int, b: int):
            ancestors[a] = ancestors[b]
            return

        def find(a: int) -> int:
            if ancestors[a] == a:
                return a
            else:
                return find(ancestors[a])

        if len(grid) == 0 or len(grid[0]) == 0:
            print("Error")

        height = len(grid)
        width = len(grid[0])

        # ds for union-find algorithm
        ancestors = [i for i in range(height * width)]

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

                if 0 <= xNext < height and 0 <= yNext < width and not visited[xNext][yNext]:
                    union(index, nextIndex)

            rootStart = find(0)
            rootEnd = find(height * width - 1)
            if rootStart == rootEnd:
                return grid[xCor][yCor]

        return -1