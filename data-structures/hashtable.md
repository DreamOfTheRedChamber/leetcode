
- [Hash Table](#hash-table)
  - [Hash+Prefix](#hashprefix)
 - [Reviewed](#reviewed)
 - [Todo](#todo)

# [Hash Table](https://github.com/wisdompeak/LeetCode/tree/master/Hash)

[049.Group-Anagrams](https://github.com/wisdompeak/LeetCode/tree/master/Hash/049.Group-Anagrams) \(M+\)  
[149.Max-Points-on-a-Line](https://github.com/wisdompeak/LeetCode/tree/master/Hash/149.Max-Points-on-a-Line) \(H\)  
[166.Fraction-to-Recurring-Decimal](https://github.com/wisdompeak/LeetCode/tree/master/Hash/166.Fraction-to-Recurring-Decimal) \(M\)  
[170.Two-Sum-III-Data-structure-design](https://github.com/wisdompeak/LeetCode/tree/master/Hash/170.Two-Sum-III-Data-structure-design) \(M\)  
[392.Is-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/392.Is-Subsequence) \(H-\)  
[204.Count Primes](https://github.com/wisdompeak/LeetCode/tree/master/Hash/204.Count-Primes) \(M\)  
[274.H-Index](https://github.com/wisdompeak/LeetCode/tree/master/Hash/274.H-Index) \(H\)  
[325.Maximum-Size-Subarray-Sum-Equals-k](https://github.com/wisdompeak/LeetCode/tree/master/Hash/325.Maximum-Size-Subarray-Sum-Equals-k) \(M\)  
[409.Longest-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/Hash/409.Longest-Palindrome) \(M\)  
[447.Number-of-Boomerangs](https://github.com/wisdompeak/LeetCode/tree/master/Hash/447.Number-of-Boomerangs) \(E+\)  
[438.Find-All-Anagrams-in-a-String](https://github.com/wisdompeak/LeetCode/tree/master/Hash/438.Find-All-Anagrams-in-a-String) \(M+\)  
[356.Line-Reflection](https://github.com/wisdompeak/LeetCode/tree/master/Hash/356.Line-Reflection) \(H-\)  
[594.Longest-Harmonious-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/594.Longest-Harmonious-Subsequence) \(M+\)  
[532.K-diff-Pairs-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Hash/532.K-diff-Pairs-in-an-Array) \(E+\)  
[424.Longest-Repeating-Character-Replacement](https://github.com/wisdompeak/LeetCode/tree/master/Hash/424.Longest-Repeating-Character-Replacement) （H）  
[446.Arithmetic-Slices-II-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/446.Arithmetic-Slices-II-Subsequence) \(H\)  
[128.Longest-Consecutive-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/128.Longest-Consecutive-Sequence) \(H-\)  
[753.Cracking-the-Safe](https://github.com/wisdompeak/LeetCode/tree/master/Hash/753.Cracking-the-Safe) \(H\)  
[890.Find-and-Replace-Pattern](https://github.com/wisdompeak/LeetCode/tree/master/Hash/890.Find-and-Replace-Pattern) \(M+\)  
[939.Minimum-Area-Rectangle](https://github.com/wisdompeak/LeetCode/tree/master/Hash/939.Minimum-Area-Rectangle) \(M+\)  
982.Triples-with-Bitwise-AND-Equal-To-Zero \(M+\) \(TBD\)  
[1074.Number-of-Submatrices-That-Sum-to-Target](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1074.Number-of-Submatrices-That-Sum-to-Target) \(M+\)  
1224.Maximum-Equal-Frequency \(H-\)  
[1487.Making-File-Names-Unique](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1487.Making-File-Names-Unique) \(M+\)  
[1573.Number-of-Ways-to-Split-a-String](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1573.Number-of-Ways-to-Split-a-String) \(M\)

## Hash+Prefix

```python
# using LC 525 as an example
class Solution:
 def findMaxLength(self, nums: List[int]) -> int:

  prefixSumToIndex = dict()
  prefixSumToIndex[0] = -1

  longest = 0
  prefixSum = 0
  for i in range(len(nums)):
   prefixSum += -1 if nums[i] == 0 else 1
   if prefixSum in prefixSumToIndex:
    longest = max(longest, i - prefixSumToIndex[prefixSum])
   else:
    prefixSumToIndex[prefixSum] = i

  return longest
```

### Reviewed

[525.Contiguous-Array](https://github.com/wisdompeak/LeetCode/tree/master/Hash/525.Contiguous-Array) \(M\)  

### Todo
[930.Binary-Subarrays-With-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Hash/930.Binary-Subarrays-With-Sum) \(M\)  
[1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR) \(H-\)  
[1524.Number-of-Sub-arrays-With-Odd-Sum ](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1524.Number-of-Sub-arrays-With-Odd-Sum) \(M\)  
[974.Subarray-Sums-Divisible-by-K](https://github.com/wisdompeak/LeetCode/tree/master/Hash/974.Subarray-Sums-Divisible-by-K) \(M\)  
[1590.Make-Sum-Divisible-by-P](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1590.Make-Sum-Divisible-by-P) \(M+\)  
[1658.Minimum-Operations-to-Reduce-X-to-Zero](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1658.Minimum-Operations-to-Reduce-X-to-Zero) \(M\)  
[1371.Find-the-Longest-Substring-Containing-Vowels-in-Even-Counts](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1371.Find-the-Longest-Substring-Containing-Vowels-in-Even-Counts) \(H-\)  
[1542.Find-Longest-Awesome-Substring](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1542.Find-Longest-Awesome-Substring) \(H-\)  
[1915.Number-of-Wonderful-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1915.Number-of-Wonderful-Substrings) \(M+\)  
[1983.Widest-Pair-of-Indices-With-Equal-Range-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1983.Widest-Pair-of-Indices-With-Equal-Range-Sum) \(M+\)

