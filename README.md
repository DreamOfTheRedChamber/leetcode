- [LeetCode problem types](#leetcode-problem-types)
  - [Amortized analysis](#amortized-analysis)
    - [Input Size V.S. Time Complexity](#input-size-vs-time-complexity)
  - [Hash Table](#hash-table)
    - [LRU cache implementation](#lru-cache-implementation)
    - [Hash+Prefix](#hashprefix)
  - [Design](#design)
  - [Deque](#deque)
  - [Linked List](#linked-list)
    - [Dummy node trick](#dummy-node-trick)
    - [Common tasks](#common-tasks)
  - [Divide and Conquer](#divide-and-conquer)
  - [Recursion](#recursion)
    - [Min-Max Strategy](#min-max-strategy)
  - [Math](#math)
    - [Distances](#distances)
    - [Geometry](#geometry)
    - [Random Pick](#random-pick)
    - [Combinatorics](#combinatorics)
    - [Numerical Theory](#numerical-theory)
  - [Others](#others)
    - [扫描线 / 差分数组](#扫描线--差分数组)
    - [Enumeration](#enumeration)
    - [Presum](#presum)
    - [Quick Select](#quick-select)
  - [LeetCode Cup](#leetcode-cup)
  - [Templates](#templates)
- [Online IDE templates](#online-ide-templates)
  - [Coderpad](#coderpad)

## LeetCode problem types

### Amortized analysis
* https://www.youtube.com/watch?v=OwMhWDOxX94&ab_channel=HuaHua

#### Input Size V.S. Time Complexity
* https://www.youtube.com/watch?v=eG99FDBeuJo&ab_channel=HuaHua

### [Hash Table](https://github.com/wisdompeak/LeetCode/tree/master/Hash)

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

#### LRU cache implementation

* HashMap + DDL
* LinkedHashMap + manual removing oldest entry and reset
* LinkedHashMap \( access order + removeEldestEntry\(\) \)
  * Access order
    * When specified: The accessOrder flag is set when creating the LinkedHashMap instance using the LinkedHashMap\(int initialCapacity, float loadFactor, boolean accessOrder\) constructor
    * accessOrder=true: The elements are ordered according to their access: When iterating over the map the most recently accessed entry is returned first and the least recently accessed element is returned last. Only the get, put, and putAll methods influence this ordering.
    * accessOrder=false: The elements are ordered according to their insertion. This is the default if any of the other LinkedHashMap constructors is used. In this ordering read access to the map has no influence on element ordering.
  * removeEldestEntry\(Entry\)
    * This method is called with the eldest entry whenever an element is added to the map. Eldest means the element which is returned last when iterating over the map. So the notion of eldest is influenced by accessOrder set on the map. The removeEldestElement in its default implementation just returns false to indicate, that nothing should happen. An extension of the LinkedHashMap may overwrite the default implementation to do whatever would be required:

#### Hash+Prefix

[525.Contiguous-Array](https://github.com/wisdompeak/LeetCode/tree/master/Hash/525.Contiguous-Array) \(M\)  
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


### [Design](https://github.com/wisdompeak/LeetCode/tree/master/Design)

[146.LRU-Cache](https://github.com/wisdompeak/LeetCode/tree/master/Design/146.LRU-Cache) \(H-\)  
[460.LFU Cache](https://github.com/wisdompeak/LeetCode/tree/master/Design/460.LFU-Cache) \(H\)  
[432.All-O-one-Data-Structure](https://github.com/wisdompeak/LeetCode/tree/master/Design/432.All-O-one-Data-Structure) \(H\)  
[380.Insert-Delete-GetRandom-O\(1\)](https://github.com/wisdompeak/LeetCode/tree/master/Design/380.Insert-Delete-GetRandom-O-1/) \(M+\)  
[381.Insert-Delete-GetRandom-O1-Duplicates-allowed](https://github.com/wisdompeak/LeetCode/tree/master/Design/381.Insert-Delete-GetRandom-O1-Duplicates-allowed) \(H-\)  
[716.Max-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Design/716.Max-Stack) \(M+\)  
[355.Design-Twitter](https://github.com/wisdompeak/LeetCode/tree/master/Design/355.Design-Twitter) \(H\)  
[535.Encode-and-Decode-TinyURL](https://github.com/wisdompeak/LeetCode/tree/master/Design/535.Encode-and-Decode-TinyURL) \(M\)  
[631.Design-Excel-Sum-Formula](https://github.com/wisdompeak/LeetCode/tree/master/Design/631.Design-Excel-Sum-Formula) \(H\)  
[642.Design-Search-Autocomplete-System](https://github.com/wisdompeak/LeetCode/tree/master/Design/642.Design-Search-Autocomplete-System) \(M+\)  
[895.Maximum-Frequency-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Design/895.Maximum-Frequency-Stack) \(H\)  
[1146.Snapshot-Array](https://github.com/wisdompeak/LeetCode/tree/master/Design/1146.Snapshot-Array) \(H\)  
[1172.Dinner-Plate-Stacks](https://github.com/wisdompeak/LeetCode/tree/master/Design/1172.Dinner-Plate-Stacks) \(H\)  
[1381.Design-a-Stack-With-Increment-Operation](https://github.com/wisdompeak/LeetCode/tree/master/Design/1381.Design-a-Stack-With-Increment-Operation) \(H-\)  
[1352.Product-of-the-Last-K-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Design/1352.Product-of-the-Last-K-Numbers) \(M+\)  
[1418.Display-Table-of-Food-Orders-in-a-Restaurant](https://github.com/wisdompeak/LeetCode/tree/master/Design/1418.Display-Table-of-Food-Orders-in-a-Restaurant) \(H-\)  
[1622.Fancy-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Design/1622.Fancy-Sequence) \(H+\)


### [Deque](https://github.com/wisdompeak/LeetCode/tree/master/Deque)

[239.Sliding-Window-Maximum](https://github.com/wisdompeak/LeetCode/tree/master/Deque/239.Sliding-Window-Maximum) \(H-\)  
[862.Shortest-Subarray-with-Sum-at-Least-K](https://github.com/wisdompeak/LeetCode/tree/master/Deque/862.Shortest-Subarray-with-Sum-at-Least-K) \(H\)  
[1425.Constrained-Subsequence-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1425.Constrained-Subsequence-Sum) \(H\)  
[1438.Longest-Continuous-Subarray-With-Absolute-Diff-Less-Than-or-Equal-to-Limit](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1438.Longest-Continuous-Subarray-With-Absolute-Diff-Less-Than-or-Equal-to-Limit) \(H\)  
[1499.Max-Value-of-Equation](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1499.Max-Value-of-Equation) \(M+\)  
[1562.Find-Latest-Group-of-Size-M](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1562.Find-Latest-Group-of-Size-M) \(H\)  
[1696.Jump-Game-VI](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1696.Jump-Game-VI) \(M+\)  
[1776.Car-Fleet-II](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1776.Car-Fleet-II) \(H\)




### [Linked List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List)

[025.Reverse-Nodes-in-k-Group](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/025.Reverse-Nodes-in-k-Group) \(H-\)  
[061.Rotate-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/061.Rotate-List) \(M\)  
082.Remove-Duplicates-from-Sorted-List-II \(M+\)  
[086.Partition-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/086.Partition-List) \(M\)  
[142.Linked-List-Cycle-II](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/142.Linked-List-Cycle-II) \(M+\)  
[109.Convert-Sorted-List-to-Binary-Search-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/109.Convert-Sorted-List-to-Binary-Search-Tree) \(M\)  
[092.Reverse-Linked-List-II](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/092.Reverse-Linked-List-II) \(H-\)  
[143.Reorder-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/143.Reorder-List) \(H-\)  
[369.Plus-One-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/369.Plus-One-Linked-List) \(M\)  
[430.Flatten-a-Multilevel-Doubly-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/430.Flatten-a-Multilevel-Doubly-Linked-List) \(H-\)  
[457.Circular-Array-Loop](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/457.Circular-Array-Loop) \(H-\)  
[708.Insert-into-a-Cyclic-Sorted-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/708.Insert-into-a-Cyclic-Sorted-List) \(H-\)  
[1474.Delete-N-Nodes-After-M-Nodes-of-a-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/1474.Delete-N-Nodes-After-M-Nodes-of-a-Linked-List) \(M+\)  
[1670.Design-Front-Middle-Back-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/1670.Design-Front-Middle-Back-Queue) \(M+\)  
[1756.Design-Most-Recently-Used-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/1756.Design-Most-Recently-Used-Queue) \(H\)

#### Dummy node trick

* Dummy Node trick: Maintain a list dummy head and actual tail pointer
  * Used across all linked list modification operations

```java
LinkedListNode dummy = new LinkedListNode( 0 );
LinkedListNode tail = dummy;

// append one more element to the tail
tail.next = appendedNode;
// move tail pointer forward
tail = appendedNode;

return dummy.next; // pointing to the actual list head
```

#### Common tasks

* Find median
* Reverse list
* Merge sorted list

### [Divide and Conquer](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer)

[315.Count-of-Smaller-Numbers-After-Self](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/315.Count-of-Smaller-Numbers-After-Self) \(H-\)  
[327.Count-of-Range-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/327.Count-of-Range-Sum) \(H-\)  
[493.Reverse-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/493.Reverse-Pairs) \(M+\)  
[1649.Create-Sorted-Array-through-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/1649.Create-Sorted-Array-through-Instructions) \(H\)


### [Recursion](https://github.com/wisdompeak/LeetCode/tree/master/Recursion)

[087.Scramble-String](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/087.Scramble-String) \(H-\)  
[133.Clone-Graph](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/133.Clone-Graph) \(M+\)  
[213.House-Robber-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/213.House-Robber-II) \(H-\)  
[337.House-Robber-III](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/337.House-Robber-III) \(M+\)  
[241.Different-Ways-to-Add-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/241.Different-Ways-to-Add-Parentheses) \(H-\)  
[390.Elimination-Game](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/390.Elimination-Game) \(H\)  
[395.Longest-Substring-with-At-Least-K-Repeating-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/395.Longest-Substring-with-At-Least-K-Repeating-Characters) \(H\)  
[397.Integer-Replacement](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/397.Integer-Replacement) \(M+\)  
440.K-th-Smallest-in-Lexicographical-Order \(H\)  
[679.24-Game](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/679.24-Game) \(H\)  
[761.Special-Binary-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/761.Special-Binary-String) \(H\)  
779.K-th-Symbol-in-Grammar \(M\)  
[780.Reaching-Points](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/780.Reaching-Points) \(H-\)  
[808.Soup-Servings](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/808.Soup-Servings) \(H\)  
[880.Decoded-String-at-Index](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/880.Decoded-String-at-Index) \(H-\)  
[902.Numbers-At-Most-N-Given-Digit-Set](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/902.Numbers-At-Most-N-Given-Digit-Set) \(M\)  
[964.Least-Operators-to-Express-Number](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/964.Least-Operators-to-Express-Number) \(H\)  
[991.Broken-Calculator](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/991.Broken-Calculator) \(M\)  
[1088.Confusing-Number-II](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1088.Confusing-Number-II) \(H\)  
[1199.Minimum-Time-to-Build-Blocks](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1199.Minimum-Time-to-Build-Blocks) \(H+\)  
[1274.Number-of-Ships-in-a-Rectangle](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1274.Number-of-Ships-in-a-Rectangle) \(M\)  
[1415.The-k-th-Lexicographical-String-of-All-Happy-Strings-of-Length-n](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1415.The-k-th-Lexicographical-String-of-All-Happy-Strings-of-Length-n) \(H-\)  
1545. Find Kth Bit in Nth Binary String \(TBD\)  
[1553.Minimum-Number-of-Days-to-Eat-N-Oranges](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1553.Minimum-Number-of-Days-to-Eat-N-Oranges) \(H\)  
[1611.Minimum-One-Bit-Operations-to-Make-Integers-Zero](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1611.Minimum-One-Bit-Operations-to-Make-Integers-Zero) \(H\)

#### Min-Max Strategy

[464.Can-I-Win](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/464.Can-I-Win) \(M+\)  
[877.Stone-Game](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/877.Stone-Game) \(M+\) \(aka. 486.Predict-the-Winner\)  
[1140.Stone-Game-II](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1140.Stone-Game-II) \(M\)  
[1406.Stone-Game-III](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1406.Stone-Game-III) \(M+\)  
[1510.Stone-Game-IV](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1510.Stone-Game-IV) \(M\)  
[1563.Stone-Game-V](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1563.Stone-Game-V) \(H-\)

### [Math](https://github.com/wisdompeak/LeetCode/tree/master/Math)

[089.Gray-Code](https://github.com/wisdompeak/LeetCode/tree/master/Math/089.Gray-Code) \(M+\) \(aka. 1238. Circular Permutation in Binary Representation\)  
[233.Number-of-Digit-One](https://github.com/wisdompeak/LeetCode/tree/master/Math/233.Number-of-Digit-One) \(H-\)  
458.Poor-Pigs \(H\)  
[400.n-th-digit](https://github.com/wisdompeak/LeetCode/tree/master/Math/400.n-th-digit) \(M\)  
[441.Arranging-Coins](https://github.com/wisdompeak/LeetCode/tree/master/Math/441.Arranging-Coins) \(M-\)  
[628.Maximum-Product-of-Three-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/628.Maximum-Product-of-Three-Numbers) \(M\)  
[672.Bulb-Switcher-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/672.Bulb-Switcher-II) \(H\)  
[754.Reach-a-Number](https://github.com/wisdompeak/LeetCode/tree/master/Math/754.Reach-a-Number) \(H\)  
[829.Consecutive-Numbers-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Math/829.Consecutive-Numbers-Sum) \(M\)  
[878.Nth-Magical-Number](https://github.com/wisdompeak/LeetCode/tree/master/Math/878.Nth-Magical-Number) \(M+\)  
[883.Projection-Area-of-3D-Shapes](https://github.com/wisdompeak/LeetCode/tree/master/Math/883.Projection-Area-of-3D-Shapes) \(E+\)  
[891.Sum-of-Subsequence-Widths](https://github.com/wisdompeak/LeetCode/tree/master/Math/891.Sum-of-Subsequence-Widths) \(M+\)  
[899.Orderly-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Math/899.Orderly-Queue) \(M\)  
[963.Minimum-Area-Rectangle-II](https://github.com/wisdompeak/LeetCode/tree/master/Math/963.Minimum-Area-Rectangle-II) \(H-\)  
[964.Least-Operators-to-Express-Number](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/964.Least-Operators-to-Express-Number) \(H\)  
[972.Equal-Rational-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/972.Equal-Rational-Numbers) \(H\)  
[1012.Numbers-With-Repeated-Digits](https://github.com/wisdompeak/LeetCode/tree/master/Math/1012.Numbers-With-Repeated-Digits) \(H-\)  
[1017.Convert-to-Base--2](https://github.com/wisdompeak/LeetCode/tree/master/Math/1017.Convert-to-Base--2) \(M+\)  
[1073.Adding-Two-Negabinary-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/1073.Adding-Two-Negabinary-Numbers) \(H-\)  
[1025.Divisor-Game](https://github.com/wisdompeak/LeetCode/tree/master/Math/1025.Divisor-Game) \(M\)  
[1040.Moving-Stones-Until-Consecutive-II](https://github.com/wisdompeak/LeetCode/tree/master/Math/1040.Moving-Stones-Until-Consecutive-II) \(H\)  
[1015.Smallest-Integer-Divisible-by-K](https://github.com/wisdompeak/LeetCode/tree/master/Math/1015.Smallest-Integer-Divisible-by-K) \(M+\)  
[1103.Distribute-Candies-to-People](https://github.com/wisdompeak/LeetCode/tree/master/Math/1103.Distribute-Candies-to-People) \(M+\)  
1330.Reverse-Subarray-To-Maximize-Array-Value \(TBD\)  
[1250.Check-If-It-Is-a-Good-Array](https://github.com/wisdompeak/LeetCode/tree/master/Math/1250.Check-If-It-Is-a-Good-Array) \(M+\)  
[1605.Find-Valid-Matrix-Given-Row-and-Column-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Math/1605.Find-Valid-Matrix-Given-Row-and-Column-Sums) \(M+\)  
[1680.Concatenation-of-Consecutive-Binary-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/1680.Concatenation-of-Consecutive-Binary-Numbers) \(M\)  
[1739.Building-Boxes](https://github.com/wisdompeak/LeetCode/tree/master/Math/1739.Building-Boxes) \(H-\)  
[1806.Minimum-Number-of-Operations-to-Reinitialize-a-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Math/1806.Minimum-Number-of-Operations-to-Reinitialize-a-Permutation) \(H\)  
[1969.Minimum-Non-Zero-Product-of-the-Array-Elements](https://github.com/wisdompeak/LeetCode/tree/master/Math/1969.Minimum-Non-Zero-Product-of-the-Array-Elements) \(M+\)

#### Distances

[296.Best-Meeting-Point](https://github.com/wisdompeak/LeetCode/tree/master/Math/296.Best-Meeting-Point) \(M+\)  
[1131.Maximum-of-Absolute-Value-Expression](https://github.com/wisdompeak/LeetCode/tree/master/Math/1131.Maximum-of-Absolute-Value-Expression) \(H\)  
1515.Best Position for a Service Centre \(TBD\)  
[1703.Minimum-Adjacent-Swaps-for-K-Consecutive-Ones](https://github.com/wisdompeak/LeetCode/tree/master/Math/1703.Minimum-Adjacent-Swaps-for-K-Consecutive-Ones) \(H\)  
[1956.Minimum-Time-For-K-Virus-Variants-to-Spread](https://github.com/wisdompeak/LeetCode/tree/master/Math/1956.Minimum-Time-For-K-Virus-Variants-to-Spread) \(H+\)

#### Geometry

[223.Rectangle-Area](https://github.com/wisdompeak/LeetCode/tree/master/Math/223.Rectangle-Area) \(M+\)  
[335.Self-Crossing](https://github.com/wisdompeak/LeetCode/tree/master/Math/335.Self-Crossing) \(H\)  
391.Perfect-Rectangle \(H\)  
[587.Erect-the-Fence](https://github.com/wisdompeak/LeetCode/tree/master/Math/587.Erect-the-Fence) \(H\)  
[593.Valid-Square](https://github.com/wisdompeak/LeetCode/tree/master/Math/593.Valid-Square) \(H\)  
[858.Mirror-Reflection](https://github.com/wisdompeak/LeetCode/tree/master/Math/858.Mirror-Reflection) \(H\)  
[1401.Circle-and-Rectangle-Overlapping](https://github.com/wisdompeak/LeetCode/tree/master/Math/1401.Circle-and-Rectangle-Overlapping) \(H\)  
[1453.Maximum-Number-of-Darts-Inside-of-a-Circular-Dartboard](https://github.com/wisdompeak/LeetCode/tree/master/Math/1453.Maximum-Number-of-Darts-Inside-of-a-Circular-Dartboard) \(H\)  
[1610.Maximum-Number-of-Visible-Points](https://github.com/wisdompeak/LeetCode/tree/master/Math/1610.Maximum-Number-of-Visible-Points) \(H\)

#### Random Pick

[382.Linked-List-Random-Node](https://github.com/wisdompeak/LeetCode/tree/master/Math/382.Linked-List-Random-Node) \(H\)  
[470.Implement-Rand10\(\)-Using-Rand7\(\)](https://github.com/wisdompeak/LeetCode/tree/master/Math/470.Implement-Rand10--Using-Rand7) \(M+\)  
[478.Generate-Random-Point-in-a-Circle](https://github.com/wisdompeak/LeetCode/tree/master/Math/478.Generate-Random-Point-in-a-Circle) \(H-\)  
[497.Random-Point-in-Non-overlapping-Rectangles](https://github.com/wisdompeak/LeetCode/tree/master/Math/497.Random-Point-in-Non-overlapping-Rectangles) \(M+\)  
[519.Random-Flip-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Math/519.Random-Flip-Matrix) \(H-\)  
[528.Random-Pick-with-Weight](https://github.com/wisdompeak/LeetCode/tree/master/Math/528.Random-Pick-with-Weight) \(H-\)  
[710.Random-Pick-with-Blacklist](https://github.com/wisdompeak/LeetCode/tree/master/Math/710.Random-Pick-with-Blacklist) \(M+\)  
[1227.Airplane-Seat-Assignment-Probability](https://github.com/wisdompeak/LeetCode/tree/master/Math/1227.Airplane-Seat-Assignment-Probability) \(M+\)

**Random pattern**

* Reservoir sampling: sample k from n
  * Example problems: Shuffle an array, Random pick index, Linked list random node.

```java
public List<Integer> sample( List<Integer> list, int k )
{
    final List<Integer> samples = new ArrayList<Integer>( k );
    int count = 0;
    final Random random = new Random();
    for ( Integer item : list ) 
    {
        if ( count < k ) 
        {
            samples.add( item );
        } 
        else 
        {
            // http://en.wikipedia.org/wiki/Reservoir_sampling
            // In effect, for all i, the ith element of S is chosen to be included in the reservoir with probability
            // k/i.
            int randomPos = random.nextInt( count );
            if ( randomPos < k ) 
            {
                samples.set( randomPos, item );
            }
        }
        count++;
    }
    return samples;
}
```

#### Combinatorics

[046.Permutations](https://github.com/wisdompeak/LeetCode/tree/master/Math/046.Permutations) \(M+\)  
[047.Permutations-II](https://github.com/wisdompeak/LeetCode/tree/master/Math/047.Permutations-II) \(H\)  
[060.Permutation-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Math/060.Permutation-Sequence) \(H\)  
[077.Combinations](https://github.com/wisdompeak/LeetCode/blob/master/Math/077.Combinations) \(H-\)  
[1286.Iterator-for-Combination](https://github.com/wisdompeak/LeetCode/tree/master/Math/1286.Iterator-for-Combination) \(M+\)  
[1359.Count-All-Valid-Pickup-and-Delivery-Options](https://github.com/wisdompeak/LeetCode/tree/master/Math/1359.Count-All-Valid-Pickup-and-Delivery-Options) \(M+\)  
[1467.Probability-of-a-Two-Boxes-Having-The-Same-Number-of-Distinct-Balls](https://github.com/wisdompeak/LeetCode/tree/master/Math/1467.Probability-of-a-Two-Boxes-Having-The-Same-Number-of-Distinct-Balls) \(H-\)  
[1641.Count-Sorted-Vowel-Strings](https://github.com/wisdompeak/LeetCode/tree/master/Math/1641.Count-Sorted-Vowel-Strings) \(M+\)  
[1643.Kth-Smallest-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Math/1643.Kth-Smallest-Instructions) \(M+\)  
[1735.Count-Ways-to-Make-Array-With-Product](https://github.com/wisdompeak/LeetCode/tree/master/Math/1735.Count-Ways-to-Make-Array-With-Product) \(H\)  
[1830.Minimum-Number-of-Operations-to-Make-String-Sorted](https://github.com/wisdompeak/LeetCode/tree/master/Math/1830.Minimum-Number-of-Operations-to-Make-String-Sorted) \(H\)  
[1866.Number-of-Ways-to-Rearrange-Sticks-With-K-Sticks-Visible](https://github.com/wisdompeak/LeetCode/tree/master/Math/1866.Number-of-Ways-to-Rearrange-Sticks-With-K-Sticks-Visible) \(H\)  
[1916.Count-Ways-to-Build-Rooms-in-an-Ant-Colony](https://github.com/wisdompeak/LeetCode/tree/master/Math/1916.Count-Ways-to-Build-Rooms-in-an-Ant-Colony) \(H\)

**Generate all unique permutations**

```java
void generatePerms( List<List<Integer>> allPerms, List<Integer> onePerm, int[] nums, boolean[] isUsed )
{     
  if ( onePerm.size() == nums.length )
  {
    allPerms.add( new LinkedList<>( onePerm ) );
    return;
  }

  for ( int i = 0 ; i < nums.length; i++ )
  {       
    if ( !isUsed[i] )
    {
      if ( i > 0 && nums[i] == nums[i-1] && !isUsed[i-1] )
      {
        continue;
      }

      isUsed[i] = true;
      onePerm.add( nums[i] );
      generatePerms( allPerms, onePerm, nums, isUsed );
      onePerm.remove( onePerm.size( ) - 1 );
      isUsed[i] = false;
    }
  }
}
```

**Generate all subsets**

```java
void generateSubsets( List<List<Integer>> allSubsets, LinkedList<Integer> oneSubset, int[] nums, int startPos )
{
  if ( startPos > nums.length )
  {
    return;
  }

  allSubsets.add( new LinkedList<>( oneSubset ) );

  for ( int i = startPos; i < nums.length; i++ )
  {
    if ( i > startPos 
        && nums[i] == nums[i-1] )
    {
      continue;
    }

    oneSubset.addLast( nums[i] );
    generateSubsets( allSubsets, oneSubset, nums, i + 1 );
    oneSubset.removeLast( );
  }
}
```

**Generate all combinations summing to a target**

```java
void generateCombs( List<List<Integer>> allCombs, LinkedList<Integer> oneComb, int[] nums, int startPos, int targetSum )
{
  if ( targetSum < 0 || startPos >= nums.length )
  {
    return;
  }

  if ( targetSum == 0 )
  {
    allCombs.add( new LinkedList<>( oneComb ) );
    return;
  }

  for ( int i = startPos; i < nums.length; i++ )
  {
    oneComb.addLast( nums[i] );
    generateCombs( allCombs, oneComb, nums, i, targetSum - nums[i] );
    oneComb.removeLast( );
  }
}
```

#### Numerical Theory

[343.Integer-Break](https://github.com/wisdompeak/LeetCode/tree/master/Math/343.Integer-Break) \(H-\)  
[365.Water-and-Jug-Problem](https://github.com/wisdompeak/LeetCode/tree/master/Math/365.Water-and-Jug-Problem) \(H\)  
[1808.Maximize-Number-of-Nice-Divisors](https://github.com/wisdompeak/LeetCode/tree/master/Math/1808.Maximize-Number-of-Nice-Divisors) \(H-\)

### [Others](https://github.com/wisdompeak/LeetCode/tree/master/Others)

[007.Reverse-Integer](https://github.com/wisdompeak/LeetCode/tree/master/Others/007.Reverse-Integer) \(M\)  
[048.Rotate-Image](https://github.com/wisdompeak/LeetCode/tree/master/Others/048.Rotate-Image) \(M+\)  
[065.Valid-Number](https://github.com/wisdompeak/LeetCode/tree/master/Others/065.Valid-Number) \(H-\)  
[158.Read-N-Characters-Given-Read4-II-Call-multiple-times](https://github.com/wisdompeak/LeetCode/tree/master/Others/158.Read-N-Characters-Given-Read4-II-Call-multiple-times) \(H-\)  
[240.Search-a-2D-Matrix-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/240.Search-a-2D-Matrix-II) \(M+\)  
[277.Find-the-Celebrity](https://github.com/wisdompeak/LeetCode/tree/master/Others/277.Find-the-Celebrity) \(H-\)  
[311.Sparse-Matrix-Multiplication](https://github.com/wisdompeak/LeetCode/tree/master/Others/311.Sparse-Matrix-Multiplication) \(M\)  
168.Excel-Sheet-Column-Title \(H\)  
453.Minimum-Moves-to-Equal-Array-Elements \(M\)  
689.Maximum-Sum-of-3-Non-Overlapping-Subarrays \(M+\)  
[782.Transform-to-Chessboard](https://github.com/wisdompeak/LeetCode/tree/master/Others/782.Transform-to-Chessboard) \(H+\)  
[466.Count-The-Repetitions](https://github.com/wisdompeak/LeetCode/tree/master/Others/466.Count-The-Repetitions) \(H\)  
[810.Chalkboard-XOR-Game](https://github.com/wisdompeak/LeetCode/tree/master/Others/810.Chalkboard-XOR-Game) \(H\)  
420.Strong-Password-Checker \(H\)  
[775.Global-and-Local-Inversions](https://github.com/wisdompeak/LeetCode/tree/master/Others/775.Global-and-Local-Inversions) \(M\)  
[348.Design-Tic-Tac-Toe](https://github.com/wisdompeak/LeetCode/tree/master/Others/348.Design-Tic-Tac-Toe) \(M\)  
[794.Valid-Tic-Tac-Toe-State](https://github.com/wisdompeak/LeetCode/tree/master/Others/794.Valid-Tic-Tac-Toe-State) \(M+\)  
825.Friends-Of-Appropriate-Ages \(M+\)  
[835.Image-Overlap](https://github.com/wisdompeak/LeetCode/tree/master/Others/835.Image-Overlap) \(H\)  
[843.Guess-the-Word](https://github.com/wisdompeak/LeetCode/tree/master/Others/843.Guess-the-Word) \(M\)  
855.Exam-Room \(M+\)  
918.Maximum-Sum-Circular-Subarray \(H-\)  
[927.Three-Equal-Parts](https://github.com/wisdompeak/LeetCode/tree/master/Others/927.Three-Equal-Parts) \(M\)  
[978.Longest-Turbulent-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Others/978.Longest-Turbulent-Subarray) \(H-\)  
1067.Digit-Count-in-Range \(H\)  
1183.Maximum-Number-of-Ones \(H\)  
[1267.Count-Servers-that-Communicate](https://github.com/wisdompeak/LeetCode/tree/master/Others/1267.Count-Servers-that-Communicate) \(M+\)  
[1538.Guess-the-Majority-in-a-Hidden-Array](https://github.com/wisdompeak/LeetCode/tree/master/Others/1538.Guess-the-Majority-in-a-Hidden-Array) \(M+\)  
[1706.Where-Will-the-Ball-Fall](https://github.com/wisdompeak/LeetCode/tree/master/Others/1706.Where-Will-the-Ball-Fall) \(M+\)  
[1749.Maximum-Absolute-Sum-of-Any-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Others/1749.Maximum-Absolute-Sum-of-Any-Subarray) \(M+\)  
[1752.Check-if-Array-Is-Sorted-and-Rotated](https://github.com/wisdompeak/LeetCode/tree/master/Others/1752.Check-if-Array-Is-Sorted-and-Rotated) \(M\)  
[1826.Faulty-Sensor](https://github.com/wisdompeak/LeetCode/tree/master/Others/1826.Faulty-Sensor) \(M+\)  
[1861.Rotating-the-Box](https://github.com/wisdompeak/LeetCode/tree/master/Others/1861.Rotating-the-Box) \(M\)  
[1862.Sum-of-Floored-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/Others/1862.Sum-of-Floored-Pairs) \(M+\)  
[1904.The-Number-of-Full-Rounds-You-Have-Played](https://github.com/wisdompeak/LeetCode/tree/master/Others/1904.The-Number-of-Full-Rounds-You-Have-Played) \(M\)  
[1997.First-Day-Where-You-Have-Been-in-All-the-Rooms](https://github.com/wisdompeak/LeetCode/tree/master/Others/1997.First-Day-Where-You-Have-Been-in-All-the-Rooms) \(H\)

#### Enumeration

[479.Largest-Palindrome-Product](https://github.com/wisdompeak/LeetCode/tree/master/Others/479.Largest-Palindrome-Product) \(M+\)  
[866.Prime-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/Others/866.Prime-Palindrome) \(H-\)  
[906.Super-Palindromes](https://github.com/wisdompeak/LeetCode/tree/master/Others/906.Super-Palindromes) \(H-\)  
[795.Number-of-Subarrays-with-Bounded-Maximum](https://github.com/wisdompeak/LeetCode/tree/master/Others/795.Number-of-Subarrays-with-Bounded-Maximum) \(M+\)  
[1625.Lexicographically-Smallest-String-After-Applying-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Others/1625.Lexicographically-Smallest-String-After-Applying-Operations) \(H-\)  
[1714.Sum-Of-Special-Evenly-Spaced-Elements-In-Array](https://github.com/wisdompeak/LeetCode/tree/master/Others/1714.Sum-Of-Special-Evenly-Spaced-Elements-In-Array) \(H\)  
[1737.Change-Minimum-Characters-to-Satisfy-One-of-Three-Conditions](https://github.com/wisdompeak/LeetCode/tree/master/Others/1737.Change-Minimum-Characters-to-Satisfy-One-of-Three-Conditions) \(M+\)

#### Presum

[1878.Get-Biggest-Three-Rhombus-Sums-in-a-Grid](https://github.com/wisdompeak/LeetCode/tree/master/Others/1878.Get-Biggest-Three-Rhombus-Sums-in-a-Grid) \(M+\)  
[1906.Minimum-Absolute-Difference-Queries](https://github.com/wisdompeak/LeetCode/tree/master/Others/1906.Minimum-Absolute-Difference-Queries) \(M+\)

#### Quick Select

[215.Kth-Largest-Element-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/215.Kth-Largest-Element-in-an-Array) \(M\)  
[347.Top-K-Frequent-Elements](https://github.com/wisdompeak/LeetCode/tree/master/Others/347.Top-K-Frequent-Elements) \(M+\)  
[973.K-Closest-Points-to-Origin](https://github.com/wisdompeak/LeetCode/tree/master/Others/973.K-Closest-Points-to-Origin) \(M\)  
[324.Wiggle-Sort-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/324.Wiggle-Sort-II) \(H\)

### [LeetCode Cup](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP)

[LCP23.魔术排列](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2020Fall/LCP23.%E9%AD%94%E6%9C%AF%E6%8E%92%E5%88%97)  
[LCP24.数字游戏](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2020Fall/LCP24.%E6%95%B0%E5%AD%97%E6%B8%B8%E6%88%8F)  
[LCP25.古董键盘](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2020Fall/LCP25.%E5%8F%A4%E8%91%A3%E9%94%AE%E7%9B%98)  
[LCP32.批量处理任务](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Spring/LCP32.%E6%89%B9%E9%87%8F%E5%A4%84%E7%90%86%E4%BB%BB%E5%8A%A1)  
[LCP35.电动车游城市](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Spring/LCP35.%E7%94%B5%E5%8A%A8%E8%BD%A6%E6%B8%B8%E5%9F%8E%E5%B8%82)  
[LCP36.最多牌组数](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Spring/LCP36.%E6%9C%80%E5%A4%9A%E7%89%8C%E7%BB%84%E6%95%B0)  
[LCP43.十字路口的交通](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Fall/LCP43.%E5%8D%81%E5%AD%97%E8%B7%AF%E5%8F%A3%E7%9A%84%E4%BA%A4%E9%80%9A)

### [Templates](https://github.com/wisdompeak/LeetCode/tree/master/Template)

[Math](https://github.com/wisdompeak/LeetCode/tree/master/Template/Math)  
[Binary\_Index\_Tree](https://github.com/wisdompeak/LeetCode/tree/master/Template/Binary_Index_Tree)  
[Segment Tree](https://github.com/wisdompeak/LeetCode/tree/master/Template/SegmentTree)  
[Inverse\_Element](https://github.com/wisdompeak/LeetCode/tree/master/Template/Inverse_Element)  
[Graph](https://github.com/wisdompeak/LeetCode/tree/master/Template/Graph)  
[Bit\_Manipulation](https://github.com/wisdompeak/LeetCode/tree/master/Template/Bit_manipulation)  
[Combination-Number](https://github.com/wisdompeak/LeetCode/tree/master/Template/Combination-Number)  
[RB\_Tree](https://github.com/wisdompeak/LeetCode/tree/master/Template/RB_Tree)  
[IO](https://github.com/wisdompeak/LeetCode/tree/master/Template/IO)

## Online IDE templates

### Coderpad

```java
import org.junit.*;
import org.junit.runner.*;
import java.io.*;
import java.util.*;

public class Solution 
{

    @Test
    public void test1()
    {
      /* 

      */
    }    

    @Ignore
    @Test
    public void test3()
    {
        /* 

        */
    }

    public static void main(String[] args) 
    {
        JUnitCore.main("Solution");
    }    

}
```

