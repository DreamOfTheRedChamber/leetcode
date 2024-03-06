import copy
import sys
from typing import List

# don't pass single array reference as parameter in functions

def findPath(xCor: int, yCor: int, maze: List[List[int]], visited: List[List[bool]], path: List):
    height, width = len(maze), len(maze[0])
    if xCor == height - 1 and yCor == width - 1:
        for item in path:
            print('(' + str(item[0]) + ',' + str(item[1]) + ')')
        return

    direcs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    for direc in direcs:
        xNext = xCor + direc[0]
        yNext = yCor + direc[1]
        if 0 <= xNext < height and 0 <= yNext < width and not visited[xNext][yNext] and maze[xNext][yNext] == 0:
            path.append((xNext, yNext))
            visited[xNext][yNext] = True
            findPath(xNext, yNext, maze, visited, path)
            visited[xNext][yNext] = False
            path.pop()

    return

[N, M] = map(int, input().strip().split(' '))
maze = []
for i in range(N):
    # return a map object, which could be passed to List/Set, etc
    line = map(int, input().strip().split(' '))
    maze.append(list(line))
result = [[0,0]]
visited = [[False for j in range(M)] for i in range(N)]
findPath(0, 0, maze, visited, result)

# maze = [[0, 1, 0, 0, 0], [0, 1, 1, 1, 0], [0, 0, 0, 0, 0], [0, 1, 1, 1, 0], [0, 0, 0, 1, 0]]

maze = [[0, 1], [0, 0]]
# 初始值需包括[0, 0]
visited = [[False for j in range(2)] for i in range(2)]
visited[0][0] = True
path = [[0, 0]]

findPath(0, 0, maze, visited, path)

