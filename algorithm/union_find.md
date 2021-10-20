- [Union Find](#union-find)
  - [Reviewed](#reviewed)
  - [TODO](#todo)
  - [Prime Factors](#prime-factors)
  - [MST](#mst)

# [Union Find](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find)

```py
def findRoot(node: int, nodeToParent: dict) -> int:
  root = nodeToParent[node]
  while root != nodeToParent[root]:
    root = nodeToParent[root]
  return root

def union(nodeX: int, nodeY: int, nodeToParent: dict) -> bool:
  rootX = findRoot(nodeX, nodeToParent)
  rootY = findRoot(nodeY, nodeToParent)
  if rootX != rootY:
    nodeToParent[rootX] = rootY
    return True
  else:
    return False

# use dictionary instead of array to represent the parent mapping
nodeToParent = {x:x for x in range(n)}

# calculate number of components in the graph
numComponents = sum([1 for k,v in nodeToParent.items() if k == v])
```

## Reviewed
[547.Friend-Circles](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/547.Friend-Circles) \(M\)  

## TODO
[200.Number-of-Islands](https://github.com/wisdompeak/LeetCode/tree/master/DFS/200.Number-of-Islands) \(H-\)  
[305.Number-of-Islands-II](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/305.Number-of-Islands-II) \(H-\)  
[130.Surrounded-Regions](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/130.Surrounded-Regions) \(H-\)  
[128.Longest-Consecutive-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/128.Longest-Consecutive-Sequence) \(H-\)  
[684.Redundant-Connection](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/684.Redundant-Connection) \(M\)  
[685.Redundant-Connection-II](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/685.Redundant-Connection-II) \(H\)  
[721.Accounts-Merge](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/721.Accounts-Merge) \(M+\)  
[765.Couples-Holding-Hands](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/765.Couples-Holding-Hands) \(H-\)  
[785.Is-Graph-Bipartite](https://github.com/wisdompeak/LeetCode/tree/master/BFS/785.Is-Graph-Bipartite) \(M+\)  
[924.Minimize-Malware-Spread](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/924.Minimize-Malware-Spread) \(H-\)  
[947.Most-Stones-Removed-with-Same-Row-or-Column](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/947.Most-Stones-Removed-with-Same-Row-or-Column) \(M+\)  
[959.Regions-Cut-By-Slashes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/959.Regions-Cut-By-Slashes) \(H-\)  
[990.Satisfiability-of-Equality-Equations](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/990.Satisfiability-of-Equality-Equations) \(M+\)  
[1061.Lexicographically-Smallest-Equivalent-String](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1061.Lexicographically-Smallest-Equivalent-String) \(M\)  
[1101.The-Earliest-Moment-When-Everyone-Become-Friends](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1101.The-Earliest-Moment-When-Everyone-Become-Friends) \(M+\)  
[1202.Smallest-String-With-Swaps](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1202.Smallest-String-With-Swaps) \(M+\)  
[1319.Number-of-Operations-to-Make-Network-Connected](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1319.Number-of-Operations-to-Make-Network-Connected) \(M+\)  
[1632.Rank-Transform-of-a-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1632.Rank-Transform-of-a-Matrix) \(H\)  
[1631.Path-With-Minimum-Effort](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1631.Path-With-Minimum-Effort) \(H-\)  
[1697.Checking-Existence-of-Edge-Length-Limited-Paths](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1697.Checking-Existence-of-Edge-Length-Limited-Paths) \(H-\)  
[1724.Checking-Existence-of-Edge-Length-Limited-Paths-II](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1724.Checking-Existence-of-Edge-Length-Limited-Paths-II) \(H+\)  
[1722.Minimize-Hamming-Distance-After-Swap-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1722.Minimize-Hamming-Distance-After-Swap-Operations) \(M+\)  
[803.Bricks-Falling-When-Hit](https://github.com/wisdompeak/LeetCode/tree/master/DFS/803.Bricks-Falling-When-Hit) \(H\)  
[1970.Last-Day-Where-You-Can-Still-Cross](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1970.Last-Day-Where-You-Can-Still-Cross) \(H-\)

**Patterns**

* Suitable in a dynamically changing graph. 
  * Complexity: O\(lgn\)
  * Example problems: Number of Island II, find weakly connected components in directed graph, find connected components in undirected graph

```java

int find( int x ) 
{ 
    int parent = x; 
    while ( parent != father.get( parent ) ) 
    { 
        parent = father.get( parent ); 
    } 
    
    return parent; 
}

void union( int x, int y ) 
{ 
    int fa_x = find( x ); 
    int fa_y = find( y ); 
    if ( fa_x != fa_y ) 
    { 
        father.put( fa_x, fa_y );
    } 
}   

```



## Prime Factors

[952.Largest-Component-Size-by-Common-Factor](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/952.Largest-Component-Size-by-Common-Factor) \(H\)  
[1627.Graph-Connectivity-With-Threshold](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1627.Graph-Connectivity-With-Threshold) \(M+\)  
[1998.GCD-Sort-of-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1998.GCD-Sort-of-an-Array) \(H-\)

## MST

[1135.Connecting-Cities-With-Minimum-Cost](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1135.Connecting-Cities-With-Minimum-Cost) \(M+\)  
[1168.Optimize-Water-Distribution-in-a-Village](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1168.Optimize-Water-Distribution-in-a-Village) \(H-\)  
[1489.Find-Critical-and-Pseudo-Critical-Edges-in-Minimum-Spanning-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1489.Find-Critical-and-Pseudo-Critical-Edges-in-Minimum-Spanning-Tree) \(H\)  
[1579.Remove-Max-Number-of-Edges-to-Keep-Graph-Fully-Traversable](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1579.Remove-Max-Number-of-Edges-to-Keep-Graph-Fully-Traversable) \(H-\)  
[1584.Min-Cost-to-Connect-All-Points](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1584.Min-Cost-to-Connect-All-Points) \(H-\)