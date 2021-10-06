- [Intervals](#intervals)
  - [Maximum number of non-overlapping intervals - sort by ending points](#maximum-number-of-non-overlapping-intervals---sort-by-ending-points)
    - [Interval + DP + Binary search](#interval--dp--binary-search)
  - [Minimum number of intervals to cover the whole range - sort by starting points](#minimum-number-of-intervals-to-cover-the-whole-range---sort-by-starting-points)

# Intervals
[1272.Remove-Interval](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1272.Remove-Interval) \(M+\)  

## Maximum number of non-overlapping intervals - sort by ending points

[452.Minimum-Number-of-Arrows-to-Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/452.Minimum-Number-of-Arrows-to-Burst-Balloons) \(H-\)  

[435.Non-overlapping-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/435.Non-overlapping-Intervals) \(M+\) \(aka. [646.Maximum-Length-of-Pair-Chain](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/646.Maximum-Length-of-Pair-Chain)\)  

[757.Set-Intersection-Size-At-Least-Two](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/757.Set-Intersection-Size-At-Least-Two) \(H\)  

```python
# Sample Pattern1: For loop based
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0:
            return 0
        
        # calc max number of non-overlapping, then substract
        sortedInter = sorted(intervals, key=lambda x: (x[1], -x[0]))
        curr = sortedInter[0]
        numOverlapped = 0
        for i in range(1, len(sortedInter)):
            if sortedInter[i][0] < curr[1]:
                numOverlapped += 1
            else:
                curr = sortedInter[i]
        
        return numOverlapped       

# Sample Pattern2: Two while loop (the return value is the opposite per problem description)
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        sortedIn = sorted(pairs, key=lambda x: (x[1], x[0]))
        i = 0
        result = 0
        while i < len(sortedIn):
            j = i + 1
            result += 1
            while j < len(sortedIn) and sortedIn[j][0] <= sortedIn[i][1]:
                j += 1
            i = j
        return result
```

### Interval + DP + Binary search
* TODO
  * Use named tuples
  * Limitations of lru_cache
  * Sorted() key word

[1235.Maximum-Profit-in-Job-Scheduling](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1235.Maximum-Profit-in-Job-Scheduling) \(H-\)  

[1751.Maximum-Number-of-Events-That-Can-Be-Attended-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1751.Maximum-Number-of-Events-That-Can-Be-Attended-II) \(H\)

## Minimum number of intervals to cover the whole range - sort by starting points
[045.Jump-Game-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/045.Jump-Game-II) \(M\)  

[1024.Video-Stitching](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1024.Video-Stitching) \(M+\)  

[1288.Remove-Covered-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1288.Remove-Covered-Intervals) \(M+\)  

[1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden) \(M+\)  
