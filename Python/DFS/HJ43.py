import sys

def findPath(xCor: int, yCor: int, maze: List[List[int]], visited: List[List[int]], path: List[tuple], result: List[tuple]):
    height, width = len(maze), len(maze[0])
    if xCor == height - 1 and yCor == width - 1:
        result = path.copy()
        return

    direcs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    for direc in direcs:
        xNext = xCor + direc[0]
        yNext = yCor + direc[1]
        if 0 <= xNext < height and 0 <= yNext < width and not visited[xNext][yNext] and maze[xNext][yNext] == 0:
            path.append((xNext, yNext))
            visited[xNext][yNext] = True
            findPath(xNext, yNext, maze, visited, path, result)
            visited[xNext][yNext] = False
            path.pop()

    return

[N, M] = map(int, input().strip().split(' '))
maze = []
for i in range(N):
    # return a map object, which could be passed to List/Set, etc
    line = map(int, input().strip().split(' '))
    maze.append(list(line))
result = []
findPath(0, 0, maze, [[False] * M] * N, [], result)
for item in result:
    print(item)