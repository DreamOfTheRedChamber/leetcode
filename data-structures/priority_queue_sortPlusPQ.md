# Sort+PQ

## [502.IPO](https://github.com/wisdompeak/LeetCode/blob/master/Priority_Queue/502.IPO/) （M+）  

* Brute force EE link with Treemap: https://drive.explaineverything.com/thecode/VKVPTJN
* Improved nlogn EE link with linear array: https://expl.ai/CGYXYTF

## [630.Course-Schedule-III](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/630.Course-Schedule-III) \(H\)  

## [857.Minimum-Cost-to-Hire-K-Workers](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/857.Minimum-Cost-to-Hire-K-Workers) \(H\)  

## [1353.Maximum-Number-of-Events-That-Can-Be-Attended](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1353.Maximum-Number-of-Events-That-Can-Be-Attended) \(H-\)  

## [1383.Maximum-Performance-of-a-Team](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1383.Maximum-Performance-of-a-Team) \(M+\)  

* 25min come up with solution: Https://expl.ai.TEHUMSC
  * T.C.: O(nlogn) + O(nlogk) 
* One small error: Don't mod result before finishing

```py
class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        modNum = 10 ** 9 + 7
        effiSpee = sorted(zip(efficiency, speed))
        minHeap = []
        heapSum = 0
        result = 0        

        for i in reversed(range(n)):
            thisEffi, thisSpee = effiSpee[i]
            
            heapq.heappush(minHeap, (thisSpee, thisEffi))
            heapSum += thisSpee

            if len(minHeap) > k:
                topSpeed, topEffi = heapq.heappop(minHeap)
                heapSum -= topSpeed
            
            result = max(result, heapSum * thisEffi)
            
        return result % modNum
```

## [1834.Single-Threaded-CPU](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1834.Single-Threaded-CPU) \(M\)  

* 15 min come up with solution: https://expl.ai/TXGGTSP
* Four attempts before reaching the correct solution ......
  1. Did not handle the case where cpu could be idle 
  2. When cpu is idle, increment the timer instead of directly jumping to the correct ts, resulting in TLE. 
  3. Similar to 2, but only set the start time, not update time. 

```py
class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        if len(tasks) == 0:
            return []
        
        tupleList = []
        for i in range(len(tasks)):
            tupleList.append((tasks[i][0], tasks[i][1], i))
        sortedT = sorted(tupleList)
        ptr = 0
        currT = sortedT[0][0]
        minHeap = []
        result = []

        while len(result) < len(tasks):
            while ptr < len(sortedT) and sortedT[ptr][0] <= currT:
                heapq.heappush(minHeap, (sortedT[ptr][1], sortedT[ptr][2]))
                ptr += 1
            if len(minHeap) != 0: 
                proTime, index = heapq.heappop(minHeap)
                result.append(index)
                currT += proTime
            else: 
                currT = max(currT, sortedT[ptr][0])
        return result
```

## [1851.Minimum-Interval-to-Include-Each-Query](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1851.Minimum-Interval-to-Include-Each-Query) \(H\)

