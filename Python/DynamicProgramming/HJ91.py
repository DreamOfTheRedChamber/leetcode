import sys

[m, n] = input().strip().split(' ')
ways = [0 for j in range(n)] for i in range(m)
for i in range(n):
    ways[0][i] = 0
for j in range(m):
    ways[j][0] = 0

for i in range(1, n):
    for j in range(1, m):
        ways[i][j] = ways[i-1][j] + ways[i][j-1]

print(ways[m-1][n-1])