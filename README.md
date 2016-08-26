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