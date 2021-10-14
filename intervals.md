# intervals

## Sort by ending points - Max num of non-overlapping intervals inside a range

[452.Minimum-Number-of-Arrows-to-Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/452.Minimum-Number-of-Arrows-to-Burst-Balloons) (H-)

[435.Non-overlapping-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/435.Non-overlapping-Intervals) (M+) (aka. [646.Maximum-Length-of-Pair-Chain](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/646.Maximum-Length-of-Pair-Chain))

[757.Set-Intersection-Size-At-Least-Two](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/757.Set-Intersection-Size-At-Least-Two) (H)

```python
# Sample Pattern: Two while loop (the return value is the opposite per problem description)
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

#### Interval + DP + Binary search

* TODO
  * Use named tuples
  * Limitations of lru_cache
  * Sorted() key word

[1235.Maximum-Profit-in-Job-Scheduling](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1235.Maximum-Profit-in-Job-Scheduling) (H-)

[1751.Maximum-Number-of-Events-That-Can-Be-Attended-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1751.Maximum-Number-of-Events-That-Can-Be-Attended-II) (H)

## Sort by starting points - Min num of intervals to cover the range

[1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden) (M+)

```python
# Using leetcode 1326 as an example.
def minTaps(self, n: int, ranges: List[int]) -> int:
    intervals = [[i - r, i + r] for i, r in enumerate(ranges)]
    sortedIntervals = sorted(intervals, key=lambda x : (x[0], -x[1])) 
        
    nextEnd = currEnd = currIndex = 0
    numTaps = 0
    while currIndex < len(sortedIntervals) and currEnd < n:
        # for intervals overlapping with current interval,
        # pick the one which has farthest reach
        nextIndex = currIndex
        while nextIndex < len(sortedIntervals) and sortedIntervals[nextIndex][0] <= currEnd:

            # greedily pick the overlapping intervals 
            nextEnd = max(sortedIntervals[nextIndex][1], nextEnd)
            nextIndex += 1
                
        if nextIndex == currIndex:
            return -1
        else:            
            numTaps += 1                
            currIndex = nextIndex
            currEnd = nextEnd
                
    return numTaps if currEnd >= n else -1       
```

[045.Jump-Game-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/045.Jump-Game-II) (M)

[1024.Video-Stitching](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1024.Video-Stitching) (M+)

## Sort either by start or endpoint

[1288.Remove-Covered-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1288.Remove-Covered-Intervals) (M+)

```python
# using leetcode 1288 as an example
# Greedily pick the interval which has the earliest starting point and biggest length
def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:    
    sortedInter = sorted(intervals, key=lambda x: (x[0], -x[1]))
    numRemoved = 0
    currIndex = 0
    while currIndex < len(sortedInter):
        nextStart = currIndex + 1
        while nextStart < len(sortedInter) and sortedInter[nextStart][1] <= sortedInter[currIndex][1]:
           nextStart += 1
           numRemoved += 1
        currIndex = nextStart
    return len(intervals) - numRemoved
```

## Sweepline

* Split intervals into Pair(int start, boolean isStart), Pair(int end, boolean isEnd)

```python
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        boundaryPoints = []
        for interval in intervals:
            boundaryPoints.append((interval[0], 1))
            boundaryPoints.append((interval[1], -1))
        boundaryPoints.sort(key=lambda x: (x[0], -x[1]))

        result = []
        start, end = 0, 0
        count = 0
        for point in boundaryPoints:
            if point[1] == 1:
                count += 1
                if count == 1:
                    start = point[0]
            else:
                count -= 1
                if count == 0:
                    end = point[0]
                    result.append([start, end])

        return result
```
[1272.Remove-Interval](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1272.Remove-Interval) (M+)
[252.Meeting-Rooms](https://github.com/wisdompeak/LeetCode/tree/master/Others/252.Meeting-Rooms) (M)\
[253.Meeting-Rooms-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/253.Meeting-Rooms-II) (M+)\
[056.Merge-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Others/056.Merge-Intervals) (M)\
[057.Insert-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Others/057.Insert-Interval) (M)\
[732.My-Calendar-III](https://github.com/wisdompeak/LeetCode/tree/master/Others/732.My-Calendar-III) (M)\
[759.Employee-Free-Time](https://github.com/wisdompeak/LeetCode/tree/master/Others/759.Employee-Free-Time) (M+)\
[798.Smallest-Rotation-with-Highest-Score](https://github.com/wisdompeak/LeetCode/tree/master/Others/798.Smallest-Rotation-with-Highest-Score) (H)\
[995.Minimum-Number-of-K-Consecutive-Bit-Flips](https://github.com/wisdompeak/LeetCode/tree/master/Others/995.Minimum-Number-of-K-Consecutive-Bit-Flips) (H-)\
[1094.Car-Pooling](https://github.com/wisdompeak/LeetCode/tree/master/Others/1094.Car-Pooling) (E)\
[1109.Corporate-Flight-Bookings](https://github.com/wisdompeak/LeetCode/tree/master/Others/1109.Corporate-Flight-Bookings) (M)\
[1589.Maximum-Sum-Obtained-of-Any-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Others/1589.Maximum-Sum-Obtained-of-Any-Permutation) (M)\
[1674.Minimum-Moves-to-Make-Array-Complementary](https://github.com/wisdompeak/LeetCode/tree/master/Others/1674.Minimum-Moves-to-Make-Array-Complementary) (H)\
[1871.Jump-Game-VII](https://github.com/wisdompeak/LeetCode/tree/master/Others/1871.Jump-Game-VII) (M+)\
1893.Check if All the Integers in a Range Are Covered (E)\
[850.Rectangle-Area-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/850.Rectangle-Area-II) (H)\
[1943.Describe-the-Painting](https://github.com/wisdompeak/LeetCode/tree/master/Others/1943.Describe-the-Painting) (H-)