- [DFS](#dfs)
    - [Topological sort](#topological-sort)
  - [search in an array](#search-in-an-array)
  - [memorization](#memorization)

# [DFS](https://github.com/wisdompeak/LeetCode/tree/master/DFS)

[037.Sudoku-Solver](https://github.com/wisdompeak/LeetCode/tree/master/DFS/037.Sudoku-Solver) \(M+\)  
[040.Combination-Sum-II](https://github.com/wisdompeak/LeetCode/tree/master/DFS/040.Combination-Sum-II) \(M+\)  
[051.N-Queens](https://github.com/wisdompeak/LeetCode/tree/master/DFS/051.N-Queens) \(M\)  
[131.Palindrome-Partitioning](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/131.Palindrome-Partitioning) \(M+\)  
[291.Word-Pattern-II](https://github.com/wisdompeak/LeetCode/tree/master/DFS/291.Word-Pattern-II) \(M\)  
[417.Pacific-Atlantic-Water-Flow](https://github.com/wisdompeak/LeetCode/tree/master/DFS/417.Pacific-Atlantic-Water-Flow) \(M\)  
[200.Number-of-Islands](https://github.com/wisdompeak/LeetCode/tree/master/DFS/200.Number-of-Islands) \(M\)  
[282.Expression-Add-Operators](https://github.com/wisdompeak/LeetCode/tree/master/DFS/282.Expression-Add-Operators) \(H\)  
[312.Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/DFS/312.Burst-Balloons) \(H-\)  
[351.Android-Unlock-Patterns](https://github.com/wisdompeak/LeetCode/tree/master/DFS/351.Android-Unlock-Patterns) \(H-\)  
[399.Evaluate-Division](https://github.com/wisdompeak/LeetCode/tree/master/DFS/399.Evaluate-Division) \(H-\)  
[488.Zuma-Game](https://github.com/wisdompeak/LeetCode/tree/master/DFS/488.Zuma-Game) \(H-\)  
[425.Word-Squares](https://github.com/wisdompeak/LeetCode/tree/master/DFS/425.Word-Squares) \(H-\)  
[959.Regions-Cut-By-Slashes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/959.Regions-Cut-By-Slashes) \(M+\)  
[1306.Jump-Game-III](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1306.Jump-Game-III) \(M\)  
[1718.Construct-the-Lexicographically-Largest-Valid-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1718.Construct-the-Lexicographically-Largest-Valid-Sequence) \(H-\)  
[1723.Find-Minimum-Time-to-Finish-All-Jobs](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1723.Find-Minimum-Time-to-Finish-All-Jobs) \(H-\)  
[1766.Tree-of-Coprimes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1766.Tree-of-Coprimes) \(H-\)  
[1778.Shortest-Path-in-a-Hidden-Grid](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1778.Shortest-Path-in-a-Hidden-Grid) \(H-\)

### Topological sort

* There are basically two categories of methods for topological sort. The first one is greedy algorithm with O\(\|V\|^2 + \|E\|\) time complexity. The second is based on depth first search with O\(\|V\| + \|E\|\) time complexity. Here only discusses DFS based approach. 
* When using DFS based approach, there are two cases which should be taken care of. The first one is what if there exists no topological order at all. The second is how to return topological order.
  * What if there exists no topological order - a cycle is detected. 
    * How to detect cycle: use UNDISCOVERED, DISCOVERED, VISITED to represent three possible states of graph nodes. Use a Set&lt;?&gt; isDiscovered and Set&lt;?&gt; isVisited to record all history info. If met up with a node which has been discovered but not visited, then a cycle is detected. 
    * How to handle cycle: return a boolean value \(preferred\) or throw an exception \(not really suitable because they are expected cases\)
  * What if need to return topological order

    * If do not need to detect cycle, could simply use a Stack&lt;&gt; order to record the visited node, namely using Set&lt;?&gt; discovered, Stack&lt;?&gt; visited 
    * If need to detect cycle, namely using Set&lt;?&gt; discovered, LinkedHashSet&lt;?&gt; visited

      \`\`\`java public int\[\] getTopoOrder\(Map&gt; graph\) { Set discovered = new HashSet&lt;&gt;\(\); Set visited = new LinkedHashSet&lt;&gt;\(\); for \( Integer node : graph.keySet\(\) \) { if \( !discoverd.contains\( node \) \) { if \( !topoSort\( graph, node, discovered, visited \) \) { // a cycle is detected....error handling } } }

      return visited.stream\(\).reverse\(\).collect\( Collectors.toL\); int\[\] topoOrder = new int\[visited.size\(\)\]; int pos = topoOrder.length - 1; for \( Integer node : visited \) { topoOrder\[pos\] = node; pos--; }

      return topoOrder; }

    /\*\*

    * @return whether a cycle is detected

      \*/ 

      private boolean topoSort \( Map&gt; graph, Integer startNode, Set discovered, Set visited \)

      {

       discovered.add\( startNode \);

       for \( Integer neighbor : graph.get\( startNode \) \)

       {

      ```text
       if ( !discovered.contains( neighbor ) )
       {
           if ( topoSort( graph, neighbor, discovered, visited ) )
           {
               return true;
           }
       }
       else if ( discovered.contains( neighbor ) 
               && !visited.contains( neighbor ) )
       {
           return true;
       }
       else
       {
           // already visited, do nothing
           ;
       }
      ```

       }

       visited.add\( startNode \);

       return false;

      }

      \`\`\`

## search in an array

[090.Subsets-II](https://github.com/wisdompeak/LeetCode/tree/master/DFS/090.Subsets-II) \(M+\)  
[301.Remove-Invalid-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/DFS/301.Remove-Invalid-Parentheses) \(H\)  
[473.Matchsticks-to-Square](https://github.com/wisdompeak/LeetCode/tree/master/DFS/473.Matchsticks-to-Square) \(M+\)  
[491.Increasing-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/DFS/491.Increasing-Subsequences) \(M\)  
[698.Partition-to-K-Equal-Sum-Subsets](https://github.com/wisdompeak/LeetCode/tree/master/DFS/698.Partition-to-K-Equal-Sum-Subsets) \(H-\)  
[996.Number-of-Squareful-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/DFS/996.Number-of-Squareful-Arrays) \(H-\)  
[1307.Verbal-Arithmetic-Puzzle](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1307.Verbal-Arithmetic-Puzzle) \(H\)  
[1593.Split-a-String-Into-the-Max-Number-of-Unique-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1593.Split-a-String-Into-the-Max-Number-of-Unique-Substrings) \(M\)  
[1681.Minimum-Incompatibility](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1681.Minimum-Incompatibility) \(H\)

## memorization

[329.Longest-Increasing-Path-in-a-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/DFS/329.Longest-Increasing-Path-in-a-Matrix) \(M\)  
[638.Shopping-Offers](https://github.com/wisdompeak/LeetCode/tree/master/DFS/638.Shopping-Offers) \(M+\)  
[403.Frog-Jump](https://github.com/wisdompeak/LeetCode/tree/master/DFS/403.Frog-Jump) \(M+\)  
[489.Robot-Room-Cleaner](https://github.com/wisdompeak/LeetCode/blob/master/DFS/489.Robot-Room-Cleaner) \(H\)  
[546.Remove-Boxes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/546.Remove-Boxes) \(H+\)  
[1340.Jump-Game-V](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1340.Jump-Game-V) \(M+\)  
[1815.Maximum-Number-of-Groups-Getting-Fresh-Donuts](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1815.Maximum-Number-of-Groups-Getting-Fresh-Donuts) \(H-\)
