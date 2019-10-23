## Why should I be confident
* Work through leetcode two years ago, have systematic summarization. 
* Have a great circle (Huanmin Wu, Timothy Liu)
* Have enough time and could be consistent myself
* Use another language Python which interests me
* Practice speaking with coaches
* Participate on weekly Leetcode contest
* Have monthly mock interviews on Leetcode
* Focus on target companies

## Why it is time to change
* Want to change to the open source community and mac environment
* Things are too slow in big companies

#### Graph 
##### Edge list vs Adjacent list vs Adjacent matrix
* Time complexity comparison between different graph representation
 * Use cases for different representations
  * Edge list is usually not used because looping through neighbor of a vertex is too expensive. This makes it really appropriate for many graph algo (bfs, dfs).
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

##### Build graph 
* **Building graph**, it is will be less error-prone to separate the phase of building vertexes and edges. When they are merged together, it is easy to forget about the isolated vertexes. In a common setting, usually asked to build a graph given the number of vertex int n and an array of edges. 
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

##### Detect cycles inside undirected graph

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

##### Detect cycles inside directed graph

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
