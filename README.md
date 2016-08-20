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

### questions to ask
* Array
	* Is array sorted
	* Given two arrays, which one's size is bigger
* Hashmap
	* histogram-related problem, character set

### Graph related errors
* detect cycle in undirected graph
    - pass in super node inside dfs recursive call

### boundary case
* passed in a reference variable, check null pointer case
* grid-based problem
	- gridsize == 1, no solution inside grid

### smells for refactoring and optimization
* code length > 100
* too many if statement checking for boundary cases