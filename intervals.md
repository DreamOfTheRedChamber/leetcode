# intervals

* [Intervals](intervals.md#intervals)
  * [Basics](intervals.md#basics)
  * [Max number of non-overlapping intervals inside a range - sort by ending points](intervals.md#max-number-of-non-overlapping-intervals-inside-a-range---sort-by-ending-points)
    * [Interval + DP + Binary search](intervals.md#interval--dp--binary-search)
  * [Min number of intervals to cover the whole range - sort by starting points](intervals.md#min-number-of-intervals-to-cover-the-whole-range---sort-by-starting-points)
  * [Sweepline](intervals.md#sweepline)

## Intervals

[1272.Remove-Interval](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1272.Remove-Interval) (M+)

### Basics

* Interval-related
  * Judge whether intervals overlap

```java
boolean isOverlapping( Interval o1, Interval o2 )
{
  if ( o1.start >= o2.end || o2.start >= o1.end )
  {
    return false;
  }
  else
  {
    return true;
  }
}
```

*   Sort intervals

    ```java
    List<Interval> list = //...
    // sort according to starting point
    list.sort( (o1,o2) -> o1.start - o2.start );
    // or sort according to ending point
    list.sort( (o1,o2) -> o1.end - o2.end );
    // sort according to both starting and ending point
    list.sort( (o1,o2) -> o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end );
    ```

### Max number of non-overlapping intervals inside a range - sort by ending points

[452.Minimum-Number-of-Arrows-to-Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/452.Minimum-Number-of-Arrows-to-Burst-Balloons) (H-)

[435.Non-overlapping-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/435.Non-overlapping-Intervals) (M+) (aka. [646.Maximum-Length-of-Pair-Chain](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/646.Maximum-Length-of-Pair-Chain))

[757.Set-Intersection-Size-At-Least-Two](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/757.Set-Intersection-Size-At-Least-Two) (H)

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

#### Interval + DP + Binary search

* TODO
  * Use named tuples
  * Limitations of lru_cache
  * Sorted() key word

[1235.Maximum-Profit-in-Job-Scheduling](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1235.Maximum-Profit-in-Job-Scheduling) (H-)

[1751.Maximum-Number-of-Events-That-Can-Be-Attended-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1751.Maximum-Number-of-Events-That-Can-Be-Attended-II) (H)

### Min number of intervals to cover the whole range - sort by starting points

![Algorithm: to cover the black interval,  for a given blue interval, pick the overlapping red interval which has the farthest ending point. ](<.gitbook/assets/image (1).png>)

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

[1288.Remove-Covered-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1288.Remove-Covered-Intervals) (M+)

[1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden) (M+)

### Sweepline

*   Split intervals into Pair(int start, boolean isStart), Pair(int end, boolean isEnd)

    ```java
    List<Interval> intervalList = //...
    List<Pair> pairList = //...
    for ( Interval interval : intervalList )
    {
    pairList.add( new Pair(interval.start, true) );
    pairList.add( new Pair(interval.end, false) );
    }
    pairList.sort( (o1, o2) -> (o1.start-o2.start) );
    ```

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
