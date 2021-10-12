- [Greedy](#greedy)
  - [LIS](#lis)
  - [Two-pass distribution](#two-pass-distribution)
  - [Three-pass](#three-pass)
  - [State Machine](#state-machine)
  - [Sort](#sort)
  - [Indexing Sort](#indexing-sort)
  - [Parenthesis](#parenthesis)
  - [Constructive Problems](#constructive-problems)

# [Greedy](https://github.com/wisdompeak/LeetCode/tree/master/Greedy)

[055.Jump-Game](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/055.Jump-Game) \(E+\)  
[134.Gas-Station](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/134.Gas-Station) \(H\)  
[221.Maximal-Square](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/221.Maximal-Square) \(H\)  
[229.Majority-Element-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/229.Majority-Element-II) \(H\)  
[659.Split-Array-into-Consecutive-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/659.Split-Array-into-Consecutive-Subsequences) \(H\)  
[484.Find-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/484.Find-Permutation) \(H\)  
[386.Lexicographical-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/386.Lexicographical-Numbers) \(H\)  
624.Maximum-Distance-in-Arrays \(M\)  
[665.Non-decreasing-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/665.Non-decreasing-Array) \(H\)  
670.Maximum-Swap \(M+\)  
[321.Create-Maximum-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/321.Create-Maximum-Number) \(H\)  
649.Dota2-Senate \(H\)  
[330.Patching-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/330.Patching-Array) \(H\)  
[683.K-Empty-Slots](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/683.K-Empty-Slots) \(H\)  
[517.Super-Washing-Machines](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/517.Super-Washing-Machines) \(H\)  
870.Advantage-Shuffle \(M\)  
[781.Rabbits-in-Forest](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/781.Rabbits-in-Forest) \(M+\)  
[881.Boats-to-Save-People](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/881.Boats-to-Save-People) \(H-\)  
[910.Smallest-Range-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/910.Smallest-Range-II) \(M+\)  
916.Word-Subsets \(M+\)  
[936.Stamping-The-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/936.Stamping-The-Sequence) \(H\)  
[948.Bag-of-Tokens](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/948.Bag-of-Tokens) \(M+\)  
[968.Binary-Tree-Cameras](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/968.Binary-Tree-Cameras) \(H\)  
[955.Delete-Columns-to-Make-Sorted-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/955.Delete-Columns-to-Make-Sorted-II) \(M+\)  
[1040.Moving-Stones-Until-Consecutive-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1040.Moving-Stones-Until-Consecutive-II) \(H\)  
1121.Divide Array Into Increasing Sequences \(TBD\)  
[1191.K-Concatenation-Maximum-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1191.K-Concatenation-Maximum-Sum) \(M+\)  
[1253.Reconstruct-a-2-Row-Binary-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1253.Reconstruct-a-2-Row-Binary-Matrix) \(M\)  
[1354.Construct-Target-Array-With-Multiple-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1354.Construct-Target-Array-With-Multiple-Sums) \(H-\)  
[1414.Find-the-Minimum-Number-of-Fibonacci-Numbers-Whose-Sum-Is-K](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1414.Find-the-Minimum-Number-of-Fibonacci-Numbers-Whose-Sum-Is-K) \(M+\)  
[1488.Avoid-Flood-in-The-City](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1488.Avoid-Flood-in-The-City) \(H-\)  
[1505.Minimum-Possible-Integer-After-at-Most-K-Adjacent-Swaps-On-Digits](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1505.Minimum-Possible-Integer-After-at-Most-K-Adjacent-Swaps-On-Digits) \(H\)  
[1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array) \(H-\)  
[1535.Find-the-Winner-of-an-Array-Game](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1535.Find-the-Winner-of-an-Array-Game) \(M+\)  
[1536.Minimum-Swaps-to-Arrange-a-Binary-Grid](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1536.Minimum-Swaps-to-Arrange-a-Binary-Grid) \(H-\)  
[1540.Can-Convert-String-in-K-Moves](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1540.Can-Convert-String-in-K-Moves) \(M+\)  
[1567.Maximum-Length-of-Subarray-With-Positive-Product](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1567.Maximum-Length-of-Subarray-With-Positive-Product) \(M+\)  
[1578.Minimum-Deletion-Cost-to-Avoid-Repeating-Letters](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1578.Minimum-Deletion-Cost-to-Avoid-Repeating-Letters) \(M\)  
[1585.Check-If-String-Is-Transformable-With-Substring-Sort-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1585.Check-If-String-Is-Transformable-With-Substring-Sort-Operations) \(H\)  
[1657.Determine-if-Two-Strings-Are-Close](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1657.Determine-if-Two-Strings-Are-Close) \(M\)  
[1702.Maximum-Binary-String-After-Change](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1702.Maximum-Binary-String-After-Change) \(H-\)  
[1717.Maximum-Score-From-Removing-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1717.Maximum-Score-From-Removing-Substrings) \(M+\)  
[1727.Largest-Submatrix-With-Rearrangements](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1727.Largest-Submatrix-With-Rearrangements) \(M\)  
[1744.Can-You-Eat-Your-Favorite-Candy-on-Your-Favorite-Day](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1744.Can-You-Eat-Your-Favorite-Candy-on-Your-Favorite-Day) \(M\)  
[1788.Maximize-the-Beauty-of-the-Garden](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1788.Maximize-the-Beauty-of-the-Garden) \(M+\)  
[1818.Minimum-Absolute-Sum-Difference](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1818.Minimum-Absolute-Sum-Difference) \(M+\)  
[1850.Minimum-Adjacent-Swaps-to-Reach-the-Kth-Smallest-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1850.Minimum-Adjacent-Swaps-to-Reach-the-Kth-Smallest-Number) \(M+\)  
[1911.Maximum-Alternating-Subsequence-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1911.Maximum-Alternating-Subsequence-Sum) \(M+\)  
[1982.Find-Array-Given-Subset-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1982.Find-Array-Given-Subset-Sums) \(H\)

## LIS

[300.Longest-Increasing-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/300.Longest-Increasing-Subsequence) \(M+\)  
[354.Russian-Doll-Envelopes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/354.Russian-Doll-Envelopes) \(H-\)  
[1713.Minimum-Operations-to-Make-a-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1713.Minimum-Operations-to-Make-a-Subsequence) \(H-\)  
[1964.Find-the-Longest-Valid-Obstacle-Course-at-Each-Position](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1964.Find-the-Longest-Valid-Obstacle-Course-at-Each-Position) \(M+\)

## Two-pass distribution

[135.Candy](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/135.Candy) \(M+\)  
[1840.Maximum-Building-Height](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1840.Maximum-Building-Height) \(H\)  
[1846.Maximum-Element-After-Decreasing-and-Rearranging](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1846.Maximum-Element-After-Decreasing-and-Rearranging) \(M+\)

## Three-pass

[042.Trapping-Rain-Water](https://github.com/wisdompeak/LeetCode/tree/master/Others/042.Trapping-Rain-Water) \(H-\)  
[334.Increasing-Triplet-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/334.Increasing-Triplet-Subsequence) \(H-\)  
[907.Sum-of-Subarray-Minimums](https://github.com/wisdompeak/LeetCode/tree/master/Stack/907.Sum-of-Subarray-Minimums) \(H\)  
[1525.Number-of-Good-Ways-to-Split-a-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1525.Number-of-Good-Ways-to-Split-a-String) \(M\)  
[1638.Count-Substrings-That-Differ-by-One-Character](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1638.Count-Substrings-That-Differ-by-One-Character) \(M+\)  
[1653.Minimum-Deletions-to-Make-String-Balanced](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1653.Minimum-Deletions-to-Make-String-Balanced) \(M\)  
[1664.Ways-to-Make-a-Fair-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1664.Ways-to-Make-a-Fair-Array) \(M\)  
[1671.Minimum-Number-of-Removals-to-Make-Mountain-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1671.Minimum-Number-of-Removals-to-Make-Mountain-Array) \(M+\)  
[1769.Minimum-Number-of-Operations-to-Move-All-Balls-to-Each-Box](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1769.Minimum-Number-of-Operations-to-Move-All-Balls-to-Each-Box) \(M+\)  
[1888.Minimum-Number-of-Flips-to-Make-the-Binary-String-Alternating](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1888.Minimum-Number-of-Flips-to-Make-the-Binary-String-Alternating) \(M+\)

## State Machine

[524.Longest-Word-in-Dictionary-through-Deleting](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/524.Longest-Word-in-Dictionary-through-Deleting) \(M+\)  
[727.Minimum-Window-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/727.Minimum-Window-Subsequence) \(H-\)  
[792.Number-of-Matching-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/792.Number-of-Matching-Subsequences) \(H-\)  
[1055.Shortest-Way-to-Form-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1055.Shortest-Way-to-Form-String) \(M+\)

## Sort

164.Maximum-Gap \(H\)  
[179.Largest-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/179.Largest-Number) \(H-\)  
[581.shortest-unsorted-continuous-subarray](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/581.shortest-unsorted-continuous-subarray) \(M+\)  
[275.H-Index-II](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/275.H-Index-II) \(M+\)  
[406.Queue-Reconstruction-by-Height](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/406.Queue-Reconstruction-by-Height) \(M+\)  
[731.My-Calendar-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/731.My-Calendar-II) \(M+\)  
826.Most-Profit-Assigning-Work \(M\)  
[1268.Search-Suggestions-System](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1268.Search-Suggestions-System) \(H-\)  
[1402.Reducing-Dishes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1402.Reducing-Dishes) \(M\)  
[1520.Maximum-Number-of-Non-Overlapping-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1520.Maximum-Number-of-Non-Overlapping-Substrings) \(H-\)  
[1564.Put-Boxes-Into-the-Warehouse-I](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1564.Put-Boxes-Into-the-Warehouse-I) \(M+\)  
[1665.Minimum-Initial-Energy-to-Finish-Tasks](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1665.Minimum-Initial-Energy-to-Finish-Tasks) \(H-\)  
[1686.Stone-Game-VI](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1686.Stone-Game-VI) \(H-\)  
[1996.The-Number-of-Weak-Characters-in-the-Game](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1996.The-Number-of-Weak-Characters-in-the-Game) \(M+\)

## Indexing Sort

[041.First-Missing-Positive](https://github.com/wisdompeak/LeetCode/blob/master/Greedy/041.First-Missing-Positive/Readme.md) \(H\)  
[268.Missing-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/268.Missing-Number) \(H-\)  
[287.Find-the-Duplicate-Number](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/287.Find-the-Duplicate-Number) \(H\)  
[442.Find-All-Duplicates-in-an-Array](https://github.com/wisdompeak/LeetCode/blob/master/Greedy/442.Find-All-Duplicates-in-an-Array) \(M\)  
[448.Find-All-Numbers-Disappeared-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/448.Find-All-Numbers-Disappeared-in-an-Array) \(M\)  
[645.Set-Mismatch](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/645.Set-Mismatch) \(M\)

## Parenthesis

[921.Minimum-Add-to-Make-Parentheses-Valid](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/921.Minimum-Add-to-Make-Parentheses-Valid) \(M+\)  
[1249.Minimum-Remove-to-Make-Valid-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1249.Minimum-Remove-to-Make-Valid-Parentheses) \(M+\)  
[1541.Minimum-Insertions-to-Balance-a-Parentheses-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1541.Minimum-Insertions-to-Balance-a-Parentheses-String) \(M+\)  
[678.Valid-Parenthesis-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/678.Valid-Parenthesis-String) \(H-\)  
[1963.minimum-number-of-swaps-to-make-the-string-balanced](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1963.minimum-number-of-swaps-to-make-the-string-balanced) \(M+\)


## Constructive Problems

[324.Wiggle-Sort-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/324.Wiggle-Sort-II) \(H\)  
[667.Beautiful-Arrangement-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/667.Beautiful-Arrangement-II) \(M\)  
[932.Beautiful-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/932.Beautiful-Array) \(H\)
