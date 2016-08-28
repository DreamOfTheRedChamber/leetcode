# loop through leetcode one more time, ; )
* [code snippets to remember](#snippets)
	* [Java basic apis](#basic-apis)
	* [math](#math)
	* [array](#array)
	* [string](#string)
	* [linkedlist](#linkedlist)
	* [binary-search](#binary-search)
	* [stack](#stack)
	* [queue](#queue)
	* [hashtable](#hashtable)
	* [recursive functions](#recursive)
	* [graph](#graph)
	* [dynamic-programming](#dynamic-programming)
* [questions to ask](#questions)
* [error-prone cases](#error-prone)
* [smells for refactoring and optimization](#bad-smells)
* [leetcode sins](#sins)

### code snippets to remember <a id="snippets"></a>
#### Java basic apis <a id="basic-apis"></a>

* set.add(elem) return false if set already contains the elem

#### math <a id="math"></a>
* divide two integers ( useful names: dividend/numerator, divisor/denominator, quotient, residue )
	* handle boundary cases ( 0, Integer.MIN_VALUE )
		- return int quotient
		- return double quotient
	* record quotient symbol ( neg/pos )
	* convert dividend and divisor to positive
	* calculate integer part 
	* calculate fraction part 
		- quotient = ( residue * 10 ) / divisor
		- residue = ( residue * 10 ) % divisor
		- use hashmap to record residue and occuring positions to handle recurring
	* concatenate symbol, integer part, dot, fraction part (possibly with parentheses)
	
#### array <a id="array"></a>
* Print arrays in Java
```java
int[] array1D = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
int[][] array2D = { { 1, 2 }, {2, 5}, {3, 7} };
System.out.println( Arrays.toString( array1D ) );
System.out.println( Arrays.deepToString( array2D ));
```

#### string <a id="string"></a>
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

#### linkedList <a id="linkedlist"></a>
#### binary search <a id="binary-search"></a>
* universal templates 
```java
public int binarySearch( int[] array, int target)
{
	int start = 0;
	int end = array.length - 1;
	while ( start + 1 < end )
	{
		int mid = ( end - start ) / 2 + start; // write in this way to avoid overflowing from " end + start "
		if ( array[mid] < target )
		{
			start = mid; // instead of mid + 1 to generalize the algorithm well
		}
		else
		{
			end = mid;
		}
	}
	// take result from start/end/non-exist
	if ( array[end] == target )
	{
		return end;
	}
	else if ( array[start] == target )
	{
		return start;
	}
	else
	{
		return -1;
	}
}
```

* convert a range of binary search problem into variants of essence form
	- find first element smaller than target
		- find minimum element in rotated sorted array ( target: array[array.length-1])

* how to handle duplicates in binary search

#### stack <a id="stack"></a>
* Binary tree inorder traversal
```java
    public List<Integer> inorderTraversal( TreeNode root )
    {
    	List<Integer> inorderSeqs = new ArrayList<>();
    	Stack<TreeNode> inorderStack = new Stack<>();
    	pushAllNodesOnLeftPath( root, inorderStack );
    	while ( !inorderStack.isEmpty( ) )
    	{
    		TreeNode top = inorderStack.pop( );
    		inorderSeqs.add( top.val );
    		if ( top.right != null )
    		{
    			pushAllNodesOnLeftPath( top.right, inorderStack );
    		}
    	}
    	return inorderSeqs;
    }
	
    private void pushAllNodesOnLeftPath( TreeNode root, Stack<TreeNode> inorderStack )
    {
    	TreeNode currNode = root;
    	while ( currNode != null )
    	{
    		inorderStack.push( currNode );
    		currNode = currNode.left;
    	}
    }
```
* Binary tree preorder traversal
	* There are two classical ways to implement iterative preorder traversal. The first one follows basically the same code structure as iterative inorder traversal. The second one is more concise and has a more recursive like structure.
```java
    public List<Integer> preorderTraversal(TreeNode root) {
     	List<Integer> result = new ArrayList<>();
    	if ( root == null )
    	{
    		return result;
    	}
    	
    	Stack<TreeNode> preorderStack = new Stack<>();
    	pushAllLeftChildren( root, preorderStack, result );    	
    	
    	while ( !preorderStack.isEmpty() )
    	{
    		TreeNode top = preorderStack.pop();
    		if ( top.right != null )
    		{
    			pushAllLeftChildren( top.right, preorderStack, result );
    		}
    	}   
    	return result;       
    }
    
    private void pushAllLeftChildren( TreeNode root, Stack<TreeNode> preorderStack, List<Integer> result )
	{
		TreeNode currNode = root;
		while ( currNode != null )
		{
			result.add( currNode.val );
			preorderStack.push( currNode );
			currNode = currNode.left;
		}
	}
	
	public List<Integer> preorderTraversal(TreeNode root) 
	{
     	List<Integer> result = new ArrayList<>();
    		if ( root == null )
    		{
    			return result;
    		}
    	
	    	Stack<TreeNode> preorderBuf = new Stack<>();
    		preorderBuf.push( root );
    		while ( !preorderBuf.isEmpty() )
    		{
    			TreeNode stackTop = preorderBuf.pop();
    			result.add( stackTop.val );
    			if ( stackTop.right != null )
    			{
    				preorderBuf.push( stackTop.right );
    			}
    			if ( stackTop.left != null )
    			{
    				preorderBuf.push( stackTop.left );
    			}
    		}
    		return result;       
    }
```

#### queue <a id="queue"></a>
* Lambda expression inside PriorityQueue elements comparison
```java
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
```
* use breath-first search queue for shortest path 
```java
 int bfsLevel = 0;
Queue<Integer> bfsQueue = new LinkedList<>();
bfsQueue.add( i * width + j );
while ( !bfsQueue.isEmpty() )
{
	int levelSize = bfsQueue.size(); // the number of nodes in one level can be obtained from the size of queue
	for ( int t = 0; t < levelSize; t++ )
	{
		int head = bfsQueue.remove();
  		// ... other stuff
    }
	bfsLevel++;
}
``` 

#### hashtable <a id="hashtable"></a>
#### recursive functions <a id="recursive"></a>

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

* Modify java function primitive parameters ( Java so heavy, missing pointers inside C++, -_- )
	* Example problem: deserialize tree from String input. Return value is occupied by something else ( in this case TreeNode), but still want to change int argument position
```java
public TreeNode changePos( int position, String input ) // problem

public TreeNode changePos( int[] position, String input ) // Solution1: declare a global instance variable as position
public TreeNode changePos( List<Integer> position, String input ) // Solution2: Use an array/collection/customized type to wrap the primitive number
public TreeNode changePos( Position position, String input )
```	

#### graph <a id="graph"></a>
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


#### dynamic-programming <a id="dynamic-programming"></a>




### questions to ask <a id="questions"></a>
* Array
	* Is array sorted
	* Given two arrays, which one's size is bigger
	* Whether could modify entries inside array
* LinkedList
	* Convert tree to linkedlist, doubly or singly linkedlist
* Hashmap
	* histogram-related problem, character set

### error-prone cases <a id="error-prone"></a>
* detect cycle in undirected graph
    - pass in super node inside dfs recursive call
* increase/decrease position counter inside foreach loop
* java list remove interface. Two list.remove() interface ( list.remove(int index), list.remove( Object object ) )
	- List<Integer> input
	- list.remove(index) will always take precedence because it does not require type casting

* passed in a reference variable (e.g. TreeNode, LinkNode, GraphNode...), check null pointer case
* grid-based problem
	- gridsize == 1, no solution inside grid

### smells for refactoring and optimization <a id="bad-smells"></a>
* code length > 100
* too many if statement checking for boundary cases
* code do not generalize well. Only work for current problem. e.g. merge 2 sorted list -> merge k sorted List

### Leetcode sins <a id="sins"></a>
* When problem occurs, too few stack trace
* No online debuggers
* No history track along time axis. Really bad synchronous workflow
* Unable to mark different stages in solving a problem ( e.g. thought-out, implemented, optimized, on-line judged, summarized )
* Cannot add enough comments along the code
* Never-ending, too many problems