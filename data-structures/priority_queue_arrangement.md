- [Arrangement with priority queue](#arrangement-with-priority-queue)
  - [767.Reorganize-String \(M+\)](#767reorganize-string-m)
  - [1054.Distant-Barcodes \(M+\)](#1054distant-barcodes-m)
  - [358.Rearrange-String-k-Distance-Apart \(H-\)](#358rearrange-string-k-distance-apart-h-)
  - [621.Task-Scheduler \(H-\)](#621task-scheduler-h-)
  - [984.String-Without-AAA-or-BBB \(M+\)](#984string-without-aaa-or-bbb-m)
  - [1405.Longest-Happy-String \(H-\)](#1405longest-happy-string-h-)
  - [1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work \(M+\)](#1953maximum-number-of-weeks-for-which-you-can-work-m)

# Arrangement with priority queue
## [767.Reorganize-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/767.Reorganize-String) \(M+\)  
## [1054.Distant-Barcodes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1054.Distant-Barcodes) \(M+\)  
## [358.Rearrange-String-k-Distance-Apart](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/358.Rearrange-String-k-Distance-Apart) \(H-\)  
* My original ideas:
  1. Put items in PQ, each time take out K items; Decrement each count value and then put back; Edge condition: Total number of items in count, count remaining ones
     1. Error1: Missed the edge case on K == 0
     2. Error2: Did not handle the edge case: "abb", 2 - Output: "ab", expected "bab"
* Read my previous answer, the basic idea is correct. However, edge cases (two above) are not handled correctly. 

```py
class Solution:
    def rearrangeString(self, s: str, k: int) -> str:
        if k == 0:
            return s
        
        # calculate histogram counter
        charToFreq = collections.Counter(s)
        maxHeap = []
        for key, value in charToFreq.items():
            heapq.heappush(maxHeap, (-value, key))
                    
        # take items from maxHeap and append them behind result
        result = "" 
        while len(maxHeap) > 0:            
            if len(maxHeap) < k:
                negFreq, char = heapq.heappop(maxHeap)
                if abs(negFreq) > 1:
                    break
                heapq.heappush(maxHeap, (negFreq, char))
                
            roundLength = min(k, len(maxHeap))
            queue = []
            for i in range(roundLength):
                negFreq, char = heapq.heappop(maxHeap)
                result += char
                if negFreq + 1 != 0:
                    queue.append((negFreq + 1, char))
            
            while queue:
                heapq.heappush(maxHeap, queue.pop())
            
        return result

```

## [621.Task-Scheduler](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/621.Task-Scheduler) \(H-\)  
* My original ideas:
  1. Calculate histogram. If current len(histogram) > n then no idle otherwise use idle to pad the missing entries. 
     * Error1: cool down period n is actually smaller than interval

```py
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # calculate histogram
        histogram = collections.Counter(tasks)
        maxHeap = []
        for key, value in histogram.items():
            heapq.heappush(maxHeap, (-value, key))
        
        n += 1
        # repeat the loop until maxHeap becomes empty
        result = 0
        while maxHeap:
            thisRound = 0
            fromHeap = min(len(maxHeap), n)
            # for each round take first n items from heap
            # decrement and put back
            queue = []
            result += fromHeap
            for i in range(fromHeap):
                negValue, key = heapq.heappop(maxHeap)
                if negValue + 1 != 0:
                    queue.append((negValue + 1, key))
            
            for item in queue:
                heapq.heappush(maxHeap, item)
            
            if fromHeap < n and len(maxHeap) > 0:
                # when the heap size is smaller than n, use idle to pad
                result += n - fromHeap
                           
        return result
```

## [984.String-Without-AAA-or-BBB](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/984.String-Without-AAA-or-BBB) \(M+\)  
* My original ideas:
  1. Get stuck with 1405 so want to try a simpler verison of it. 
  2. Only two letters, maybe not need a PQ? If just use a PQ, the original solution won't work. 
     1. The idea is (suppose a > b) to construct the result as aab, aab, ..., then followed by abab...ab, or aa only
        * However, this solution does not work because given an example of a=4, b=1, aabaa 
     2. Optimize with three steps, aab...aab, ab...ab, aa

```py
class Solution:
    def strWithout3a3b(self, a: int, b: int) -> str:
        big, bigNum = "a", a
        small, smallNum = "b", b
        if bigNum < smallNum:
            bigNum, smallNum = smallNum, bigNum
            big, small = small, big
        
        result = ""
        
        # first stage, construct aab, if b > 0
        diff = bigNum - smallNum
        result = result + min(diff, smallNum) * (big + big + small) # need to prove two big exist
        bigNum -= 2 * min(diff, smallNum)
        smallNum -= min(diff, smallNum)
        
        # second stage, construct ab if num(b) > 0
        if smallNum > 0:
            result = result + smallNum * (big + small)
            bigNum -= smallNum
            
        # third stage, construct remaining a
        if bigNum > 0:
            result = result + bigNum * big
        
        return result
```

## [1405.Longest-Happy-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1405.Longest-Happy-String) \(H-\)  

## [1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work) \(M+\)
* My original ideas: 
  1. Put items inside PQ, each time take out two different items from heap. Decrement and then put back in PQ. Since complexity O(10^9 * 10^5) = O(10^14)
  2. Decrement is too small step in 1. Minus the biggest with the second biggest element and then put back in PQ. However, this solution does not work because it is incorrect in some cases
* Read the answer: 
  * The only exceptional case where not all milestones could be finished is when the biggest is too big. 
  * So the problem reduces to an edge case handling math problem...... Totally unexpected.