import sys

[m, n] = map(int, input().strip().split(' '))
ways = [[1 for j in range(n+1)] for i in range(m+1)]

for i in range(1, m + 1):
    for j in range(1, n + 1):
        ways[i][j] = ways[i-1][j] + ways[i][j-1]

print(ways[m][n])