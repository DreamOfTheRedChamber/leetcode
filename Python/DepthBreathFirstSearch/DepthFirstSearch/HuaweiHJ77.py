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

count = 0
numTrains = 0
trains = []
for line in sys.stdin:
    if count == 0:
        numTrains = int(line.split()[0])
    if count == 1:
        trains = list(map(int, line.split(" ")))

allResults = []
dfs(trains, 0, [], [], allResults)
for item in allResults:
    print(item)
