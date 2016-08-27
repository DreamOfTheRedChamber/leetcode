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
```java
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
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
* Print arrays in Java
```java
int[] array1D = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
int[][] array2D = { { 1, 2 }, {2, 5}, {3, 7} };
System.out.println( Arrays.toString( array1D ) );
System.out.println( Arrays.deepToString( array2D ));
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

* Tree
	* Recursion
	* BFS queue
	* return multiple results ( Java so heavy, missing tuple return values inside Python, -_- )
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

* Modify java function primitive parameters ( Java so heavy, missing pointers inside C++, -_- )
	* Example problem: deserialize tree from String input. Return value is occupied by something else ( in this case TreeNode), but still want to change int argument position
```java
public TreeNode changePos( int position, String input )
```
	* Solution1: declare a global instance variable as position
	* Solution2: Use an array/collection/customized type to wrap the primitive number
```java
public TreeNode changePos( int[] position, String input ) // personally consider this more concise
public TreeNode changePos( List<Integer> position, String input )
public TreeNode changePos( Position position, String input )
```	

* Break string based on splitters
	* StringTokenizer ( like an iterator, has built-in hasNext() and next() func)
```java
String str = "This is String , split by StringTokenizer, created by mkyong";
StringTokenizer st = new StringTokenizer( str, "," );
while (st.hasMoreElements()) 
{
	System.out.println(st.nextElement());
}
```
	* String[] split( String regex )
```java
String string = "004-034556";
String[] parts = string.split("-");
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556
```

### questions to ask
* Array
	* Is array sorted
	* Given two arrays, which one's size is bigger
	* Whether could modify entries inside array
* Hashmap
	* histogram-related problem, character set

### related errors
* detect cycle in undirected graph
    - pass in super node inside dfs recursive call
* increase/decrease position counter inside foreach loop
* java list remove interface. Two list.remove() interface ( list.remove(int index), list.remove( Object object ) )
	- List<Integer> input
	- list.remove(index) will always take precedence because it does not require type casting

### boundary case
* passed in a reference variable (e.g. TreeNode, LinkNode, GraphNode...), check null pointer case
* grid-based problem
	- gridsize == 1, no solution inside grid

### smells for refactoring and optimization
* code length > 100
* too many if statement checking for boundary cases
* code do not generalize well. Only work for current problem. e.g. merge 2 sorted list -> merge k sorted List