
# https://www.nowcoder.com/practice/97ba57c35e9f4749826dc3befaeae109?tpId=37&tqId=21300&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=hj77
from collections import deque
from typing import List

def dfs(trains: deque, stack: List[int], oneResult: List[int], allResults: List[List[int]]):
    if len(trains) == 0 and len(stack) == 0:
        allResults.append(oneResult)
        return

    if len(trains) > 0:
        train = trains.popleft()
        oneResult.append(train)
        dfs(trains, stack, oneResult, allResults)
        oneResult.pop()

    if len(stack) > 0:
        train = stack.pop()
        oneResult.append(train)
        dfs(trains, stack, oneResult, allResults)
        oneResult.pop()

    return

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
