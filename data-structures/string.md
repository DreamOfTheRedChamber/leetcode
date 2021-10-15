- [String](#string)
  - [Rolling Hash](#rolling-hash)
  - [KMP](#kmp)
  - [Manacher](#manacher)
  - [Palindrome](#palindrome)

# [String](https://github.com/wisdompeak/LeetCode/tree/master/String)

[006.ZigZag-Conversion](https://github.com/wisdompeak/LeetCode/tree/master/String/006.ZigZag-Conversion) \(M+\)  
[336.Palindrome-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/String/336.Palindrome-Pairs) \(H-\)  
[388.Longest-Absolute-File-Path](https://github.com/wisdompeak/LeetCode/tree/master/String/388.Longest-Absolute-File-Path) \(M+\)  
[408.Valid-Word-Abbreviation](https://github.com/wisdompeak/LeetCode/tree/master/String/408.Valid-Word-Abbreviation) \(M\)  
411.Minimum-Unique-Word-Abbreviation \(H\)  
[418.Sentence-Screen-Fitting](https://github.com/wisdompeak/LeetCode/tree/master/String/418.Sentence-Screen-Fitting) \(M+\)  
[423.Reconstruct-Original-Digits-from-English](https://github.com/wisdompeak/LeetCode/tree/master/Others/423.Reconstruct-Original-Digits-from-English) \(H-\)  
[527.Word-Abbreviation](https://github.com/wisdompeak/LeetCode/tree/master/String/527.Word-Abbreviation) \(M+\)  
[556.Next Greater Element III](https://github.com/wisdompeak/LeetCode/tree/master/String/556.Next-Greater-Element-III) \(H-\)  
616.Add-Bold-Tag-in-String \(M\)  
[467.Unique-Substrings-in-Wraparound-String](https://github.com/wisdompeak/LeetCode/tree/master/String/467.Unique-Substrings-in-Wraparound-String) \(H-\)  
[564.Find-the-Closest-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/String/564.Find-the-Closest-Palindrome) \(H\)  
722.Remove-Comments \(H\)  
[736.Parse-Lisp-Expression](https://github.com/wisdompeak/LeetCode/tree/master/String/736.Parse-Lisp-Expression) \(H-\)  
[816.Ambiguous-Coordinates](https://github.com/wisdompeak/LeetCode/tree/master/String/816.Ambiguous-Coordinates) \(M+\)  
[844.Backspace-String-Compare](https://github.com/wisdompeak/LeetCode/tree/master/String/844.Backspace-String-Compare) \(M+\)  
[1616.Split-Two-Strings-to-Make-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/String/1616.Split-Two-Strings-to-Make-Palindrome) \(M+\)  
[1754.Largest-Merge-Of-Two-Strings](https://github.com/wisdompeak/LeetCode/tree/master/String/1754.Largest-Merge-Of-Two-Strings) \(M+\)  
[1849.Splitting-a-String-Into-Descending-Consecutive-Values](https://github.com/wisdompeak/LeetCode/tree/master/String/1849.Splitting-a-String-Into-Descending-Consecutive-Values) \(M+\)

## Rolling Hash

[1044.Longest-Duplicate-Substring](https://github.com/wisdompeak/LeetCode/tree/master/String/1044.Longest-Duplicate-Substring) \(H\)  
[1062.Longest-Repeating-Substring](https://github.com/wisdompeak/LeetCode/tree/master/String/1062.Longest-Repeating-Substring) \(H-\)  
[1554.Strings-Differ-by-One-Character](https://github.com/wisdompeak/LeetCode/tree/master/String/1554.Strings-Differ-by-One-Character) \(H\)  
[1698.Number-of-Distinct-Substrings-in-a-String](https://github.com/wisdompeak/LeetCode/tree/master/String/1698.Number-of-Distinct-Substrings-in-a-String) \(H-\)  
[1923.Longest-Common-Subpath](https://github.com/wisdompeak/LeetCode/tree/master/String/1923.Longest-Common-Subpath) \(H\)

## KMP

[1392.Longest-Happy-Prefix](https://github.com/wisdompeak/LeetCode/tree/master/String/1392.Longest-Happy-Prefix) \(H\)  
[028.Implement-strStr](https://github.com/wisdompeak/LeetCode/tree/master/String/028.Implement-strStr) \(H\)  
[214.Shortest-Palindrome](https://github.com/wisdompeak/LeetCode/blob/master/String/214.Shortest-Palindrome) \(H\)  
[459.Repeated-Substring-Pattern](https://github.com/wisdompeak/LeetCode/tree/master/String/459.Repeated-Substring-Pattern) \(H\)  
[572.Subtree-of-Another-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/572.Subtree-of-Another-Tree) \(H\)  
[1367.Linked-List-in-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/String/1367.Linked-List-in-Binary-Tree) \(H\)  
1397.Find All Good Strings \(TBD\)  
[1764.Form-Array-by-Concatenating-Subarrays-of-Another-Array](https://github.com/wisdompeak/LeetCode/tree/master/String/1764.Form-Array-by-Concatenating-Subarrays-of-Another-Array) \(H\)

## Manacher

[005.Longest-Palindromic-Substring](https://github.com/wisdompeak/LeetCode/tree/master/String/005.Longest-Palindromic-Substring) \(H\)  
[214.Shortest-Palindrome](https://github.com/wisdompeak/LeetCode/blob/master/String/214.Shortest-Palindrome) \(H\)  
[647.Palindromic-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/String/647.Palindromic-Substrings) \(M+\)  
[1960.Maximum-Product-of-the-Length-of-Two-Palindromic-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/String/1960.Maximum-Product-of-the-Length-of-Two-Palindromic-Substrings) \(H\)

## Palindrome

* Several ways to solve the Longest palindrome substring problem
  * DP-based solution: O\(n^2\) space and time, if need to storing palindrome result, this is always better \(e.g. palindrome partitioning\)
  * Start looping from middle: O\(n^2\) time
  * Manacher's algorithm: O\(n\) time, not generic enough.
