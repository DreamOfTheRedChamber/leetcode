- [Graph](#graph)
  - [Edge list vs Adjacent list vs Adjacent matrix](#edge-list-vs-adjacent-list-vs-adjacent-matrix)
  - [Build graph](#build-graph)
  - [Detect cycles inside undirected graph](#detect-cycles-inside-undirected-graph)
  - [Detect cycles inside directed graph](#detect-cycles-inside-directed-graph)

# [Graph](https://github.com/wisdompeak/LeetCode/tree/master/Graph/)

## Edge list vs Adjacent list vs Adjacent matrix

* Time complexity comparison between different graph representation
  * Use cases for different representations
  * Edge list is usually not used because looping through neighbor of a vertex is too expensive. This makes it really appropriate for many graph algo \(bfs, dfs\).
  * Adjacent matrix is usually used for dense graph, where vertexes are seldomly added or removed.
  * Adjacent list is usually used for sparse graph to save space.
* Adjacent list representation is the most commonly used graph representation in an interview setting. There are two common ways to realize this. One typical classical way is to define class GraphNode and then graph can be defined as List &lt; GraphNode &gt;. The other way is to define graph as Map&lt;Integer, Set&lt;Integer&gt;&gt; graph. Map&lt;Integer&gt;

```java 
// first way, more official
// but if there are redundant edges in input, might need to implement hashcode() and equal() methods to avoid add redundant nodes into neighbors. Kind of overkilling in an interview setting
class GraphNode 
{
  int val;
  int status; // used for track visiting status in DFS
  List<GraphNode> neighbor;
  // ...
}
List<GraphNode> graph =...;

// second way, graph itself is more concise. But need additional data structures like Set<Integer> visited and Set<Integer> discovered to track dfs traverse status
Map<Integer, Set<Integer>> graph 

```

## Build graph 
* it is will be less error-prone to separate the phase of building vertexes and edges. When they are merged together, it is easy to forget about the isolated vertexes. In a common setting, usually asked to build a graph given the number of vertex int n and an array of edges. 

```java
public Map<Integer, Set<Integer>> buildGraph( int n, int[][] edges )
{
  Map<Integer, Set<Integer>> graph = new HashMap<>();

  // build vertex
  for ( int i = 0; i < n; i++ )
  {
    graph.put( i, new HashSet<>() );
  }

  // build edges
  for ( int[] edge : edges  )
  {
    // undirected graph needs to add the edge twice
    graph.get( edge[0] ).add( edge[1] );
    graph.get( edge[1] ).add( edge[0] );
  }
}
```

## Detect cycles inside undirected graph

```java
// Graph is represented by class GraphNode
class GraphNode
{
  int nodeIndex;
  List<GraphNode> neighbors;
}

private boolean hasCycle( GraphNode root )
{
  return hasCycle( root, new HashSet<>() );
}

private boolean hasCycle( GraphNode root, Set<GraphNode> isDiscovered )
{
  if ( isDiscovered.contains( root ) )
  {
    return true;
  }

  isDiscovered.add( root );
  for ( List<GraphNode> neighbor : root.neighbors )
  {
    if ( hasCycle( neighbor, isVisited  ) )
    {
      return true;
    }
  }

  return false;
}
```

## Detect cycles inside directed graph

```java
// Graph is represented by class GraphNode
class GraphNode
{
  int nodeIndex;
  List<GraphNode> neighbors;
}

private boolean hasCycle( GraphNode root )
{
  Set<GraphNode> isDiscovered = new HashSet<>();
  Set<GraphNode> isVisited = new HashSet<>();
  return hasCycle( root, isDiscovered, isVisited );
}

private boolean hasCycle( GraphNode root, Set<GraphNode> isDiscovered, Set<GraphNode> isVisited )
{
  if ( isVisited.contains( root ) )
  {
    return false;
  }
  if ( isDiscovered.contains( root ) && !isVisited.contains( root ) )
  {
    return true;
  }

  isDiscovered.add( root );
  for ( List<GraphNode> neighbor : root.neighbors )
  {
    if ( hasCycle( neighbor, isDiscovered, isVisited  ) )
    {
      return true;
    }
  }
  isVisited.add( root );
  return false;
}
```

[332.Reconstruct-Itinerary](https://github.com/wisdompeak/LeetCode/tree/master/DFS/332.Reconstruct-Itinerary) \(H\)  
[753.Cracking-the-Safe](https://github.com/wisdompeak/LeetCode/tree/master/Hash/753.Cracking-the-Safe) \(H\)  
[1059.All-Paths-from-Source-Lead-to-Destination](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1059.All-Paths-from-Source-Lead-to-Destination) \(H\)  
[1192.Critical-Connections-in-a-Network](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1192.Critical-Connections-in-a-Network) \(H\)  
1334.Find-the-City-With-the-Smallest-Number-of-Neighbors-at-a-Threshold-Distance \(TBD\)  
1361.Validate-Binary-Tree-Nodes \(TBD\)  
[1719.Number-Of-Ways-To-Reconstruct-A-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1719.Number-Of-Ways-To-Reconstruct-A-Tree) \(H+\)  
[1761.Minimum-Degree-of-a-Connected-Trio-in-a-Graph](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1761.Minimum-Degree-of-a-Connected-Trio-in-a-Graph) \(M+\)  
[1782.Count-Pairs-Of-Nodes](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1782.Count-Pairs-Of-Nodes) \(H\)  
[1820.Maximum-Number-of-Accepted-Invitations](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1820.Maximum-Number-of-Accepted-Invitations) \(H\)
