
# https://www.nowcoder.com/practice/97ba57c35e9f4749826dc3befaeae109?tpId=37&tqId=21300&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=hj77
import sys
from collections import deque
from typing import List


"""
numTrains = int(input())
trains = []
for i in range(numTrains):
    trains = list(map(int, input().split(" ")))
"""

"""
count = 0
numTrains = 0
trains = []
for line in sys.stdin:
    if count == 0:
        numTrains = int(line.split()[0])
    if count == 1:
        trains = list(map(int, line.split(" ")))
    if count == 2:
        break
    count += 1
"""

def validateStackSequences(pushed: List[int], popped: List[int]) -> bool:
    pos = 0
    stack = []
    for i in range(len(pushed)):
        if pushed[i] != popped[pos]:
            stack.append(pushed[i])
        else:
            pos += 1
            while stack and stack[-1] == popped[pos]:
                pos += 1
                stack.pop()

    if pos == len(popped):
        return True
    else:
        return False

def dfs(nums: List[int], visited: List[bool], oneResult: List[int], allResults: List[List[int]]):
    if len(oneResult) == len(nums):
        allResults.append(oneResult.copy())
        return

    for i in range(len(visited)):
        if not visited[i]:
            visited[i] = True
            oneResult.append(nums[i])
            dfs(nums, visited, oneResult, allResults)
            oneResult.pop()
            visited[i] = False

    return

"""
count = 0
numTrains = 0
trains = []
for line in sys.stdin:
    if count == 0:
        numTrains = int(line.split()[0])
    if count == 1:
        trains = list(map(int, line.split(" ")))
    if count == 2:
        break
    count += 1
"""

allPerms = []
# dfs(trains, [False] * numTrains, [], allPerms)
trains = [1, 2, 3]
dfs(trains, [False] * 3, [], allPerms)
valid = []
for one in allPerms:
    if validateStackSequences(trains, one):
        valid.append(one)

results = []
for one in valid:
    line = ' '.join(map(str, one))
    results.append(line)

results.sort()

for one in results:
    print(one)

