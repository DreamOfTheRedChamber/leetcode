# loop through leetcode one more time, ; )

### code snippets to remember
* Result wrapper class or customized PriorityQueue elems
```java
class NumAndFreq
{
	public final int num;
	public final int freq;
	public NumAndFreq( int num, int freq )
	{
		this.num = num;
		this.freq = freq;
	}
}
```
* Lambda expression inside PriorityQueue elements comparison
	- decreasing order
```java
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) );
```
	- increasing order
```java
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) );
```	

* set.add(elem) return false if set already contains the elem

* If the problem is a recursive problem. But public API does not satisfy the arguments needed by recursive algorithm, consider declare one by yourself. In the example below, declare a private recursive method cloneGraphRecurse(node, Map) for public API cloneGraph(node)
```java
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
		\\ validate input arguments before passing into 
		if ( node == null )
		{
			return null;
		}
		return cloneGraphRecurse( node, new HashMap<Integer, UndirectedGraphNode>() );
	}
	private UndirectedGraphNode cloneGraphRecurse( UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> labelToNodeMap )
	{
		\\...
	}
```

* Detect cycles inside directed graphs with dfs + visited set + discovered set.
	* If during dfs in directed graph, a node discovered but not visited is encountered, then the directed graph has a cycle
```java
	public boolean hasCycle( Graph graph )
	{
	    // topoSort with dfs for detecting cycles
    	Set<Integer> discovered = new HashSet<>();
    	Set<Integer> visited = new HashSet<>();
    	for ( Integer vertex : graph.keySet() )
    	{
    		if ( !visited.contains( vertex ) )
    		{
    			if ( topoSort( graph, vertex, discovered, visited ) )
    			{
    				return false;
    			}
    		}
    	}
    	return true;
	}
    /**
     * @return whether a cycle is detected
     */
    private boolean topoSort ( Map<Integer, Set<Integer>> graph, Integer startNode, Set<Integer> discovered, Set<Integer> visited )
    {
    	discovered.add( startNode );
    	for ( Integer neighbor : graph.get( startNode ) )
    	{
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
    	}
    	visited.add( startNode );
    	return false;
    }
```

### questions to ask
* Array
	* Is array sorted
	* Given two arrays, which one's size is bigger
	* Whether could modify entries inside array
* Hashmap
	* histogram-related problem, character set

## common techniques for solving problems
* Tree
	* Recursion
	* BFS queue
	* return multiple results ( > 1 )
```java
class ListHeadTail
{
	public final ListNode head;
	public final ListNode tail;
	public ListHeadTail( ListNode head, ListNode tail )
	{
		this.head = head;
		this.tail = tail;
	}
}
```


### related errors
* detect cycle in undirected graph
    - pass in super node inside dfs recursive call
* increase/decrease position counter inside foreach loop

### boundary case
* passed in a reference variable (e.g. TreeNode, LinkNode, GraphNode...), check null pointer case
* grid-based problem
	- gridsize == 1, no solution inside grid

### smells for refactoring and optimization
* code length > 100
* too many if statement checking for boundary cases