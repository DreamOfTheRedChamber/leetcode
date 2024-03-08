t = input().strip()
s = input().strip()

dp = [[0 for j in range(len(t) + 1)] for i in range(len(s) + 1)]
for j in range(len(t) + 1):
    dp[0][j] = j
for i in range(len(s) + 1):
    dp[i][0] = i

for i in range(1, len(s) + 1):
    for j in range(1, len(t) + 1):
        if s[i - 1] == t[j - 1]:
            dp[i][j] = dp[i - 1][j - 1]
        else:
            # the distance between s[i] and t[j-1], add one letter to end of s[:j] to match t[j]
            add = dp[i][j-1] + 1

            # the distance between s[i-1] and t[j]
            delete = dp[i-1][j] + 1

            replace = dp[i-1][j-1] + 1
            dp[i][j] = min(add, delete, replace)

print(dp[len(s)][len(t)])