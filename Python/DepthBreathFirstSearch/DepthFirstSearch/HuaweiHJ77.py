
# https://www.nowcoder.com/practice/97ba57c35e9f4749826dc3befaeae109?tpId=37&tqId=21300&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=hj77

import sys
from typing import List

def dfs(trains: List[int], pos: int, stack: List[int], oneResult: List[int], allResults: List[List[int]]):
    if pos == len(trains):
        result = oneResult.copy()
        for i in reversed(range(len(stack))):
            result.append(stack[i])
        allResults.append(result)
        return

    stack.append(trains[pos])
    dfs(trains, pos + 1, stack, oneResult, allResults)
    stack.pop()

    oneResult.append(trains[pos])
    dfs(trains, pos + 1, stack, oneResult, allResults)
    oneResult.pop()

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

allResults = []
dfs([1, 2, 3], 0, [], [], allResults)
for item in allResults:
    print(item)
