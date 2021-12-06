- [Two Pointers](#two-pointers)
  - [Sliding window](#sliding-window)
  - [Begin and end type](#begin-and-end-type)
    - [Greedy](#greedy)
  - [Partition type](#partition-type)
  - [Slow and fast](#slow-and-fast)
  - [Window type](#window-type)
  - [Sliding window : Distinct Characters](#sliding-window--distinct-characters)
  - [Two pointers for two seuqences](#two-pointers-for-two-seuqences)

# [Two Pointers](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers)

[011.Container-With-Most-Water](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/011.Container-With-Most-Water) \(M+\)  
[015.3Sum](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/015.3Sum) \(M\)  
[016.3Sum-Closet](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/016.3Sum-Closest) \(M\)  
[018.4Sum](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/018.4Sum) \(M\)  
[259.3Sum-Smaller](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/259.3Sum-Smaller) \(M+\)  
[030.Substring-with-Concatenation-of-All-Words](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/030.Substring-with-Concatenation-of-All-Words) \(H\)  
[075.Sort-Colors](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/075.Sort-Colors) \(M+\)  
[026.Remove Duplicates from Sorted Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/026.Remove-Duplicates-from-Sorted-Array) \(H-\)  
[080.Remove Duplicates from Sorted Array II](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/080.Remove-Duplicates-from-Sorted-Array-II) \(H\)  
[209.Minimum-Size-Subarray-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/209.Minimum-Size-Subarray-Sum) \(M\)  
[088.Merge Sorted Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/088.Merge-Sorted-Array) \(M\)  
[283.Move-Zeroes](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/283.Move-Zeroes) \(M\)  
[141.Linked-List-Cycle](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/141.Linked-List-Cycle) \(E+\)  
[142.Linked-List-Cycle-II](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/142.Linked-List-Cycle-II) \(M+\)  
[360.Sort-Transformed-Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/360.Sort-Transformed-Array) \(M\)  
[713.Subarray-Product-Less-Than-K](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/713.Subarray-Product-Less-Than-K) \(M+\)  
[923.3Sum-With-Multiplicity](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/923.3Sum-With-Multiplicity) \(H-\)  
[1234.Replace-the-Substring-for-Balanced-String](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1234.Replace-the-Substring-for-Balanced-String) \(H-\)  
[1498.Number-of-Subsequences-That-Satisfy-the-Given-Sum-Condition](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1498.Number-of-Subsequences-That-Satisfy-the-Given-Sum-Condition) \(H-\)  
[1574.Shortest-Subarray-to-be-Removed-to-Make-Array-Sorted](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1574.Shortest-Subarray-to-be-Removed-to-Make-Array-Sorted) \(H-\)  
[1687.Delivering-Boxes-from-Storage-to-Ports](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1687.Delivering-Boxes-from-Storage-to-Ports) \(H\)  
[1793.Maximum-Score-of-a-Good-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1793.Maximum-Score-of-a-Good-Subarray) \(M+\)  

## Sliding window

[532.K-diff-Pairs-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/532.K-diff-Pairs-in-an-Array) \(H-\)  
[611.Valid-Triangle-Number](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/611.Valid-Triangle-Number) \(M+\)  
[1004.Max-Consecutive-Ones-III](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1004.Max-Consecutive-Ones-III) \(M\)  
[1052.Grumpy-Bookstore-Owner](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1052.Grumpy-Bookstore-Owner) \(M\)  
[1838.Frequency-of-the-Most-Frequent-Element](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1838.Frequency-of-the-Most-Frequent-Element) \(H-\)  
[395.Longest-Substring-with-At-Least-K-Repeating-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/395.Longest-Substring-with-At-Least-K-Repeating-Characters) \(H\)  
[1763.Longest-Nice-Substring](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1763.Longest-Nice-Substring) \(H\)

## Begin and end type

* example problems: two sum \(sorted\), three sum, four sum, three sum closest, three sum smaller

```python
if A[i] and A[j] satisfy some condition:
  j--; // do not need to consider pairs composed of [i+1, j-1] and j
  // do something
elif A[i] and A[j] do not satisfy some condition:
  i++; // do not need to consider pairs composed of [i+1, j-1] and i
  // do something
else:
  // do something
  i++ or j--
```

* Example problem: KSum

```python
def kSum(kVal: int, target: int, startIndex: int, nums: List[int]) -> List[List[int]]:
  result = []
  if kVal == 0:
    if target == 0:
      result.append([]);
    return result;

  for i in range(startIndex, len(nums) - kVal + 1):
    if (i > startIndex) and (nums[i] == nums[i - 1]):
      continue;

    for partialResult in kSum( kVal - 1, target - nums[i], i + 1, nums )
        partialResult.add( 0, nums[i] );
        result.add( partialResult );

  return result;
```

### Greedy
* Squeeze the biggest first [1580.Put-Boxes-Into-the-Warehouse-II](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1580.Put-Boxes-Into-the-Warehouse-II) \(H-\)  
* Put in the first [1798.Maximum-Number-of-Consecutive-Values-You-Can-Make/Readme.md](https://github.com/wisdompeak/LeetCode/blob/master/Greedy/1798.Maximum-Number-of-Consecutive-Values-You-Can-Make) \(H-\)


## Partition type

* example problems: two sum \(sorted\), three sum, four sum, three sum closest, three sum smaller

```python
# int[] input, int left, int right
pivot = input[(left+right)/2];
while i <= j:
    while input[i] < pivot:
        i++

    while input[j] > pivot:
        j--

    if i <= j:
        swap(data, i, j);
        i++;
        j--;
```

## Slow and fast

* Find the middle of linked list
* Find linked list cycle

## Window type

* Improve naive two level for loop to for-outer loop + while inner loop
* E.g. minimum window substring, minimum size subarray sum, Longest substring with at most K distinct characters, Longest substring without repeating characters

```python
for i in range(n):
  while j < n:
    # update j status
    if satisfy some condition:
      j++
    else:
      break
  }
}
```

## Sliding window : Distinct Characters

[076.Minimum-Window-Substring](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/076.Minimum-Window-Substring) \(M+\)  
[003.Longest-Substring-Without-Repeating-Character](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/003.Longest%20Substring%20Without%20Repeating%20Characters) \(E+\)  
[159.Longest-Substring-with-At-Most-Two-Distinct-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/159.Longest-Substring-with-At-Most-Two-Distinct-Characters)\(H-\)  
[340.Longest-Substring-with-At-Most-K-Distinct-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/340.Longest-Substring-with-At-Most-K-Distinct-Characters) \(H\)  
[992.Subarrays-with-K-Different-Integers](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/992.Subarrays-with-K-Different-Integers) \(H-\)

## Two pointers for two seuqences

[986.Interval-List-Intersections](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/986.Interval-List-Intersections) \(M\)  
[1229.Meeting-Scheduler](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1229.Meeting-Scheduler) \(M+\)  
[1537.Get-the-Maximum-Score](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1537.Get-the-Maximum-Score) \(H-\)  
[1577.Number-of-Ways-Where-Square-of-Number-Is-Equal-to-Product-of-Two-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1577.Number-of-Ways-Where-Square-of-Number-Is-Equal-to-Product-of-Two-Numbers) \(H-\)  
[1775.Equal-Sum-Arrays-With-Minimum-Number-of-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1775.Equal-Sum-Arrays-With-Minimum-Number-of-Operations) \(M+\)  
[1868.Product-of-Two-Run-Length-Encoded-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1868.Product-of-Two-Run-Length-Encoded-Arrays) \(M+\)