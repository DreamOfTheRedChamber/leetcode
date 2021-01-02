<!-- MarkdownTOC -->

- [Data structures](#data-structures)
  - [Data structure relationships](#data-structure-relationships)
  - [Type size](#type-size)
  - [Type conversions](#type-conversions)
    - [Automated cast](#automated-cast)
    - [Between string and primitive types](#between-string-and-primitive-types)
    - [Between array and collections](#between-array-and-collections)
    - [Between collections](#between-collections)
  - [Array](#array)
    - [Circular array](#circular-array)
    - [Array sum](#array-sum)
    - [Forward backward traversal](#forward-backward-traversal)
  - [String](#string)
    - [Why String is immutable or final](#why-string-is-immutable-or-final)
    - [String vs StringBuilder vs StringBuffer](#string-vs-stringbuilder-vs-stringbuffer)
    - [Word reverse](#word-reverse)
    - [Palindrome](#palindrome)
  - [Collections](#collections)
    - [Iterator](#iterator)
    - [Immutability](#immutability)
  - [List](#list)
    - [ArrayList vs LinkedList](#arraylist-vs-linkedlist)
    - [LinkedListNode](#linkedlistnode)
    - [Common tasks](#common-tasks)
  - [Stack](#stack)
    - [Calculator](#calculator)
    - [Parentheses](#parentheses)
  - [Queue](#queue)
    - [Interfaces](#interfaces)
  - [PriorityQueue](#priorityqueue)
    - [Internal structure](#internal-structure)
    - [Heapify](#heapify)
    - [Sift up/down](#sift-updown)
    - [Improve built-in remove O\(n\)](#improve-built-in-remove-on)
    - [Lambda expression as comparator](#lambda-expression-as-comparator)
    - [Top K problems](#top-k-problems)
  - [Tree](#tree)
    - [Build](#build)
    - [Traversal](#traversal)
    - [View](#view)
    - [Serialize/Deserialize](#serializedeserialize)
    - [Path on tree](#path-on-tree)
    - [Segment tree](#segment-tree)
    - [Binary search tree](#binary-search-tree)
  - [HashMap](#hashmap)
    - [Use case](#use-case)
    - [Best practices](#best-practices)
    - [Collision resolution](#collision-resolution)
    - [Intersection](#intersection)
    - [Histogram and hashmap list](#histogram-and-hashmap-list)
    - [Anagram](#anagram)
    - [Sparse Vector/matrix](#sparse-vectormatrix)
    - [LRU Cache](#lru-cache)
  - [TreeMap](#treemap)
  - [Graph](#graph)
    - [Edge list vs Adjacent list vs Adjacent matrix](#edge-list-vs-adjacent-list-vs-adjacent-matrix)
    - [Build graph](#build-graph)
    - [Detect cycles inside undirected graph](#detect-cycles-inside-undirected-graph)
    - [Detect cycles inside directed graph](#detect-cycles-inside-directed-graph)
  - [Trie](#trie)
    - [Use case](#use-case-1)
    - [Trie definition and common tasks](#trie-definition-and-common-tasks)
- [Algorithms](#algorithms)
  - [Math](#math)
    - [Random](#random)
    - [Mod](#mod)
    - [Power](#power)
    - [Sqrt](#sqrt)
    - [Divide](#divide)
    - [Multiply](#multiply)
    - [Prime](#prime)
  - [Bit manipulation](#bit-manipulation)
    - [Arithmetic vs logic right shift](#arithmetic-vs-logic-right-shift)
    - [Common tasks](#common-tasks-1)
  - [Non-DP Memorization](#non-dp-memorization)
    - [Array](#array-1)
    - [Binary indexed tree / Fenwick tree](#binary-indexed-tree--fenwick-tree)
    - [Segment tree](#segment-tree-1)
    - [Stack](#stack-1)
    - [HashMap](#hashmap-1)
  - [Two pointers](#two-pointers)
    - [Begin and end type](#begin-and-end-type)
    - [Slow and fast type](#slow-and-fast-type)
    - [Window type](#window-type)
    - [Two arrays type](#two-arrays-type)
  - [Sort](#sort)
    - [Common sorting algorithms](#common-sorting-algorithms)
    - [Built-in sort interfaces](#built-in-sort-interfaces)
    - [Types](#types)
    - [Top K](#top-k)
    - [Stream API](#stream-api)
  - [Binary search](#binary-search)
    - [Best practices](#best-practices-1)
    - [How to handle duplicates](#how-to-handle-duplicates)
    - [Types](#types-1)
  - [Recursive functions](#recursive-functions)
    - [Recursive vs iterative solutions](#recursive-vs-iterative-solutions)
    - [Recursion time complexity cheat sheet](#recursion-time-complexity-cheat-sheet)
    - [Steps in using recursion](#steps-in-using-recursion)
    - [How to return multiple results from recursive functions](#how-to-return-multiple-results-from-recursive-functions)
    - [Avoid duplicated recursion](#avoid-duplicated-recursion)
    - [Types](#types-2)
  - [Backtrack](#backtrack)
    - [Best practices](#best-practices-2)
    - [Types](#types-3)
  - [Graph](#graph-1)
    - [Grid-based graph best practices](#grid-based-graph-best-practices)
    - [Grid-based breath first search](#grid-based-breath-first-search)
    - [Grid-based depth first search](#grid-based-depth-first-search)
    - [Count number of components](#count-number-of-components)
    - [Word-based breath first search](#word-based-breath-first-search)
    - [Topological sort](#topological-sort)
    - [Union find](#union-find)
  - [Greedy](#greedy)
  - [Dynamic-programming](#dynamic-programming)
    - [Use cases](#use-cases)
    - [Problems to consider](#problems-to-consider)
    - [Implementation methods:](#implementation-methods)
    - [Memorization array tricks](#memorization-array-tricks)
    - [Type](#type)

<!-- /MarkdownTOC -->


# Data structures 

## Data structure relationships

| Enhancements | Original          | Improved  |
| --------------------- |:-------------:| -----:|
| Accuracy  | float/double      |  BigDecimal |
| Insert/Delete at begin/end/any pos | Stack/Queue     |   Deque/LinkedList |
| Fixed sized to resizable  | Array/String | ArrayList/StringBuilder |
| No order to insertion/sorted order  | Hashmap      |   linkedHashMap/TreeMap |
| Partial to complete order | Priorityqueue | Treeset |

## Type size
* Reference types: 32-bit system (32 bit), 64-bit system (64 bit)
* Enumeration type: 
* Primitive types: boolean (8 bit), byte (8 bit), char (16 bit), short (16 bit), int (32 bit), long (64 bit), float (32 bit), double (64 bit)

## Type conversions
### Automated cast
* Convert char to int, does not need explicit conversion
```java
value = value * 10 +  s.charAt( currPos ) - '0' ; 
```

### Between string and primitive types 
* Convert string to primitive types: parseXXX(String) or valueOf(String)
* Convert primitive types to string: String.valueOf() or add with an empty string ""

### Between array and collections 
* Array to collections 
  + To convert array of reference types into collections, there is an API Arrays.asList(). Then List collection could be easily casted to set/map collections. 
  + To convert array of primtive types into collections, need to do it manually.
```java
Element[] array = { new Element(1), new Element(2), new Element(3) };

// wrong way
List<Element> list = Arrays.asList( array );
list.add(1); // UnsupportedOperationException

// correct way
List<Element> list = new ArrayList<>( Arrays.asList( array ) );


// list 
List<Integer> list = ...//
for ( int num : nums )
{
  list.add( num );
}
```

* Collections to array
  + There are built-in interfaces for this such as Object[] collections.toArray() or collections.toArray(T[] array)
  + Honestly, both of them are really ugly and would better to do it manually.

### Between collections 
* Map and list
* Set and list
* Map and set
```java
// hashmap keys to list and set
Map<String, List<String>> map = new HashMap<>();
List<String> list = map.keySet().stream().collect(Collectors.toList() );
Set<String> set = map.keySet();

// set to list
Set<String> set = //...
List<String> list = set.stream().collect( Collectors.toList() );

// list to set
List<String> list = //...
Set<String> set = list.stream().collect( Collectors.toSet() );
```

## Array 
### Circular array 
* Common techniques used in circular arrays
  - double the array to 2n by concatenating original array to the end and then apply a sliding window of size n on it (whether is a sorted rotated array)
  - invert the sign of the array (circular array maximum sum)
  - break the circle (house robber II)

### Array sum<a id="ds-array-array-sum">
* Array sum related questions can be divided into the following categories (see algorithm section of this readme for furture details)
  - Two pointers
    + Begin and end type: Two sum II and variants (3Sum, 3Sum closest, 3Sum smaller)
    + Window type: Minimize size subarray sum
  - Hashmap
    + Two sum
    + Maximize size subarray sum equals K
  - Backtrack
    + Combination sum I/II/II
  - Dynamic programming
    + One sequence: maximum subarray
    + Backpack type: Combination sum IV
* KSum
```java
private List<List<Integer>> kSum( int kVal, int target, int startIndex, int[] nums ) 
{
  List<List<Integer>> result = new LinkedList<>();
  if ( kVal == 0 ) 
  {
    if ( target == 0 )
    {
      result.add( new LinkedList<>() );
    }
    return result;
  }
        
  for ( int i = startIndex; i < nums.length - kVal + 1; i++ ) 
  {
    if ( ( i > startIndex ) && ( nums[i] == nums[i - 1] ) ) 
    {
      continue;
    }
    for ( List<Integer> partialResult : kSum( kVal - 1, target - nums[i], i + 1, nums ) )
    {
        partialResult.add( 0, nums[i] );
        result.add( partialResult );
    }
  }
  return result;
}
```

### Forward backward traversal 
* Trapping rain water, Best time to buy and sell stock III, product of array exclude itself

## String 
### Why String is immutable or final 
* By design: 
  - **String pool**: Strings are cached in String pool and shared between multiple clients. 
  - **Security**: No one could override the behavior of String class and don't need to worry about many security threats.
  - **Performance**: Cache its hashcode. Avoid synchronization.

### String vs StringBuilder vs StringBuffer 

| Comparison | String         | StringBuilder | StringBuffer  |
| --------------------- |:-------------:| -----:|-----:|
| Storage area  | Constant string pool    | Heap | Heap |
| Modifiable    | Immutable     |   Mutable | Mutable |
| Thread safe   | Yes     |   No | Yes | 
| Performance   | Fast    |   Fast | very slow| 

### Word reverse 



### Palindrome 
* Several ways to solve the Longest palindrome substring problem
  - DP-based solution: O(n^2) space and time, if need to storing palindrome result, this is always better (e.g. palindrome partitioning)
  - Start looping from middle: O(n^2) time
  - Manacher's algorithm: O(n) time, not generic enough.

## Collections 
### Iterator 
* When implementing hasNext() and next() function for an interator, should put the logic checking whether next elemement exists inside hasNext() function. 

### Immutability 
* If do not want to change the original array/list, could create a copy instead.
```java
// array
int[] nums = new int[]{-1, 0, 1, 2};
int[] numsCopy = nums.clone();
// list
// java best practice: Given all of the problems associated with Cloneable, it’s safe to say that other interfaces should not extend it, and that classes designed for inheritance (Item 17) 
List<Integer> list = new ArrayList<>();
List<Integer> listCopy = new ArrayList<>( list );
```
* Collections.unmodifiableList/unmodifiableSet/unmodifiableMap()

## List 
### ArrayList vs LinkedList 
* Both implements List interface, maintain the insertion-order, non-synchronized collections

| Comparison | arraylist         | linkedlist  |
| --------------------- |:-------------:| -----:|
| Internal structure  | array    |  doubly linked list |
| Insert performance  | O(n)     |   O(1) |
| Search performance  | O(1)     |   O(n) |
| Memory overhead  | array and element      | two pointers and element |

### LinkedListNode
* Dummy Node trick: Maintain a list dummy head and actual tail pointer
  - Used across all linked list modification operations
```java
LinkedListNode dummy = new LinkedListNode( 0 );
LinkedListNode tail = dummy;

// append one more element to the tail
tail.next = appendedNode;
// move tail pointer forward
tail = appendedNode;

return dummy.next; // pointing to the actual list head
```

### Common tasks
* Median
```java
  public ListNode findMedian( ListNode head )
  {
    ListNode fast = head, slow = head;
    while ( fast != null && fast.next != null )
    {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
```
* Reverse list 
```java
// recursively, the key point here is record the reversed list tail before recursion
  public ListNode reverseListRecusively( ListNode head )
  {
    if ( head == null
        || head.next == null )
    {
      return head;
    }
    
    ListNode reversedListTail = head.next;
    ListNode reversedListHead = reverseList( head.next );
    reversedListTail.next = head;
    head.next = null;
    return reversedListHead;
  }
 
  private ListNode reverseListIteratively( ListNode head )
  {
    ListNode prev = null;
        
    while (head != null) 
    {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
        
    return prev;
  }
```
* Merge sorted list. 
  - The number of list K
    + if K == 2
      - Inputs
        * ListNode l1, ListNode l2
        * List<T> l1, List<T> l2
        * Iterator<T> iter1, Iterator<T> iter2
      - Solutions
        * Similar to merge sort process
    + if K > 2
      - Inputs
        * ListNode[] / List<ListNode> input
        * List<List<T>> input
        * List<Iterator<T>> input
      - Solutions: assume n is the total number of nodes
        * Merge list two by two: O( n^2 )
        * Divide and conquer: O( nlogn )
        * Heap: O( nlogk )
  - When there is any one list left, could merge directly
```java
// k == 2 case
private ListNode merge( ListNode list1, ListNode list2 )
{
  ListNode dummy = new ListNode( 0 );
  ListNode tail = dummy;
  while ( list1 != null && list2 != null ) 
  {
    if ( list1.val < list2.val ) 
    {
      tail.next = list1;
      list1 = list1.next;
    } 
    else 
    {
      tail.next = list2;
      list2 = list2.next;
    }
    
    tail = tail.next;
  }
        
  if ( list1 != null ) 
  {
    tail.next = list1;
  } 
  else 
  {
    tail.next = list2;
  }
        
  return dummy.next;
}

private List<Integer> merge( List<Integer> list1, List<Integer> l2 )
{
  List<Integer> result = new LinkedList<>();
  Iterator<Integer> iter1 = list1.iterator();
  Iterator<Integer> iter2 = list2.iterator();

  int head1 = iter1.hasNext() ? iter1.next() : null;
  int head2 = iter2.hasNext() ? iter2.next() : null;
  while ( head1 != null && head2 != null )
  {
    if ( head1 <= head2 )
    {
      result1.add( head1 );
      head1 = iter1.hasNext() ? iter1.next() : null;
    }
    else
    {
      result.add( head2 );
      head2 = iter2.hasNext() ? iter2.next() : null;
    }
  }

  while ( iter1.hasNext() )
  {
    result.add( iter1.next() );
  }

  while ( iter2.hasNext() )
  {
    result.add( iter2.next() );
  }

  return result;
}

K > 2 case:
// Heap based method is usually the most efficient one. The hard part is how to define the priority queue in case of different inputs.
// for ListNode[] / List<ListNode> input
Queue<ListNode> minQueue = new PriorityQueue<>( ( o1, o2 ) -> o1.val - o2.val );
// for List<List<T>> / List<Iterator<T>> input
Queue<ValAndIter> minQueue = new PriorityQueue<>( ( o1, o2 ) -> o1.val - o2.val );

```

## Stack 
### Calculator 
* Evaluate infix expression. The problem can have various follow-ups
  - How to define input: String s or String[] tokens. If input is defined as String s and numbers might include negative numbers, then parsing negative numbers can be kind of cumbersome. When possible, define input as String[] tokens. Even when required to define input as String s, double check whether we need to deal with negative numbers.
  - Whether contain space
  - Whether need to deal with parentheses
```java
    public int calculate( String s )
    {
      // assertions on validity
      
      Stack<Integer> valStack = new Stack<>();
      Stack<Character> opStack = new Stack<>();
      for ( int i = 0; i < s.length( ); i++ )
      {
        char token = s.charAt( i );
        if ( token == ' ' )
        {
          continue;
        }
        else if ( token == '(' )
        {
          opStack.push( token );
        }
        else if ( token == ')' )
        {
          while ( opStack.peek() != '(' )
          {
            valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
          }
          opStack.pop();
        }
        else if ( Character.isDigit( token ) )
        {
          int start = i;
          while ( i + 1 < s.length() && Character.isDigit( s.charAt( i + 1 ) ) )
          { 
            i++;
          }
          valStack.push( Integer.parseInt( s.substring( start, i + 1 ) ) );
        }
        else
        {
          while ( !opStack.isEmpty() && isLowerPrece( token, opStack.peek() ) )
          {
            valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
          }
          opStack.push( token );
        }
      }
      
      while ( !opStack.isEmpty( ) )
      {
        valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
      }
      return valStack.pop();      
    }
        
    private boolean isLowerPrece( char curr, char toBeCompared )
    {
      return ( toBeCompared == '*' || toBeCompared == '/' ) 
          || ( toBeCompared == '-' && ( curr == '+' || curr == '-' ) );
    }
    
    private int calc( char operator, int operand1, int operand2 )
    {
      if ( operator == '+' )
      {
        return operand2 + operand1;
      }
      else if ( operator == '-' )
      {
        return operand2 - operand1;
      }
      else if ( operator == '*' )
      {
        return operand2 * operand1;
      }
      else
      {
        return operand2 / operand1;
      }
    }
```

### Parentheses 
* Check if string s contains valid parenthese
  - Questions to confirm
    + Whether the string contains non-parentheses characters
    + Whether the string contains curly braces, brackets or parentheses
    + Need to calculate the invalid number or just judge it is valid or not
```java
// Case 1: When only contains parentheses
// Judge whether a string is valid or not
boolean isValid( String s )
{
  int count = 0;
  for ( char ch : s.toCharArray() )
  {
    if ( ch == '(' )
    {
      count++;
    }
    else if ( ch == ')' )
    {
      if ( count == 0 )
      {
        return false;
      }
      count--;
    }
    // for non-parenthese chars, we will not process them
  }
  return count == 0;
}
int calcNumInvalid( String s )
{
  Stack<Character> stack = new Stack<>();
  for ( char ch : s.toCharArray() )
  {
    if ( ch == '(' ) 
    {
      stack.push( ch );
    }
    else if ( ch == ')' )
    {
      if ( !stack.isEmpty() && stack.peek() == '(' )
      {
        stack.pop();
      }
      else
      {
        stack.push( ch );
      }
    }
  }
  return stack.size();
}

// Case 2: If contains curly braces and brackets
// The basic idea is similar to Case 1. Things need to be changed here is using a Map<Ch, Ch> to store open and close mapping. 
boolean isValid( String s )
{
  Stack<Character> stack = new Stack<>();
  Map<Character, Character> openToClose = new HashMap<>();
  openToClose.put( '(', ')' );
  openToClose.put( '[', ']' );
  openToClose.put( '{', '}' );
        
  for ( char ch : s.toCharArray() )
  {
    if ( openToClose.containsKey( ch ) )
    {
      stack.push( ch );
    }
    else if ( openToClose.values.contains( ch ))
    {
      if ( stack.isEmpty() || ch != openToClose.get( stack.peek() ) )
      {
        return false;
      }
      stack.pop();
    }
  }
        
  return stack.size() == 0;
}
```
* Modifiy parenthese to make string valid
  - Questions to confirm
    + Contains other chars
    + min modification or not
    + return all valid solutions or just one solution
    + remove or insert parenthese
  - Return only one solution
    + Stack-based O(n) time and space
    + Forward/backward sweep O(n) time and O(1) space
  - Return all solutions
    + BFS-based. The hard part of this problem is how to avoid generate duplicate strings. A straightforward solution is to use HashSet to avoid. The other solution is to avoid generating using heuristics. 
    + Observations for further trunning

> 1. When we want to remove a ')' or '(' from several consecutive ones we only remove the first one, because remove any one the result will be the same. For example
> "())" ---> "()"
> only remove the first one of '))'    
>
> 2. When we remove a character it must behind it's parent removal position. 
> we need remove 2 from "(())(("
> we want to remove positions combination i,j with no duplicate
> so we let i < j then it will not generate duplicate combinations
> in practice, we record the position i and put it in to queue
> which is then polled out and used as the starting point of the next removal
> 
> 3. If the previous step we removed a "(", we should never remove a ")" in the following steps. This is obvious since otherwise we could just save these two removals and still be valid with less removals. With this observation all the possible removals will be something like this
> ")))))))))((((((((("


## Queue 
### Interfaces 
| Comparison | throws exception         | return special value  |
| --------------------- |:-------------:| -----:|
| insert  | boolean add(E e)    |  boolean offer(E e) |
| remove  | E remove()     |   E poll() |
| examine  | E element()     |   E peek() |


## PriorityQueue
### Internal structure
* An unbounded priority queue based on a priority heap. Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

### Heapify 
* Def: Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
* Heapify is an O(n) operation. The reason is as follows:
  - At the bottommost level, there are 2^(h)nodes, but we do not call heapify on any of these, so the work is 0. At the next to level there are 2^(h − 1) nodes, and each might move down by 1 level. At the 3rd level from the bottom, there are 2^(h − 2) nodes, and each might move down by 2 levels.

### Sift up/down 

```java
private void siftdown( int[] A, int k ) 
{
    while ( k < A.length ) 
    {
        int smallest = k;
        if ( k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest] )
        {
            smallest = k * 2 + 1;
        }
        if ( k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest] )
        {
            smallest = k * 2 + 2;
        }

        if ( smallest == k )
        {        
            break;
        }
        else
        {
          swap( A, smallest, k );
          k = smallest;
        }
    }
}

private void swap( int[] A, int pos1, int pos2 )
{
  if ( pos1 != pos2 )
  {
        int temp = A[smallest];
        A[smallest] = A[k];
        A[k] = temp;  
  }
}

public void heapify(int[] A) {
    for (int i = A.length / 2; i >= 0; i--) {
        siftdown(A, i);
    } 
}
```

### Improve built-in remove O(n)
* Built-in implementation remove() method for priorityqueue has O(n) time complexity.
  -  O(n) time is spent on looping through entire queue to find the element to be removed. O(logn) is used to remove the element
  -  But O(n) could be easily improved to O(logn) by adding an additional Map&lt;T, Node&gt; existingNodes. When Node has duplicate values, a counter could be added as Node class instance variable.

### Lambda expression as comparator 
```java
PriorityQueue<NumAndFreq> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
```

### Top K problems 
* Calculate the top K most frequent characters in a string 
  - Use TreeMap to maintain topK sorted order. Suppose m is the number of input and n is the number of distinct input, then build treemap requires O(mlogn),  + nlogn) complexity.
  - A more efficient approach is to use HashMap + PriorityQueue. 
```java      
      // initialize
      Map<Character, Integer> histogram = new HashMap<>();
      histogram.put( 'c', 10 );
      histogram.put( 'a', 12 );
      histogram.put( 'b', 6 );
      // output according to priorityqueue
      Queue<Map.Entry<Character, Integer>> maxQueue = new PriorityQueue<>( ( o1, o2 ) ->  o2.getValue() - o1.getValue() );
      maxQueue.addAll( histogram.entrySet() );
      return maxQueue.stream()
                     .sorted( ( o1, o2 ) -> ( o2.getValue() - o1.getValue() ) )
                     .limit( k )
                     .map( o -> o.getKey() )
                     .collect( Collectors.toList() );
```
* The largest Kth element in an array
  - PriorityQueue O(nlogk)
  - Quicksort O(n)

## Tree 
### Build 
### Traversal 
* Classic tree level order traversal with O(n) space
```java
Queue<TreeNode> bfsQueue = new LinkedList<>();
bfsQueue.offer( root );
while ( !bfsQueue.isEmpty() )
{
  TreeNode head = bfsQueue.poll();
  // do stuff
  if ( head.left != null )
  {
    bfsQueue.offer( head.left );
  }
  if ( head.right != null )
  {
    bfsQueue.offer( head.right );
  }  
}
```
* Special tree level order traversal with O(1) space: example problem (populate next right pointers in each node II)

### View 
* Right side view (Binary tree right side view)
  - Use List + tree traversal ( level order / preorder / reverse-preorder )
* Outer-inner order / Vertical order (Find binary tree leaves / Binary tree vertical order traversal)
  - Use HashMap + tree traversal ( level order / preorder )

### Serialize/Deserialize 
* Two popular ways:
  - Preorder: preorder leads to a recursive dfs-like implementation. Since Java is passed by value, it is really hard to implement elegantly without using a global variable.
  - Level-order: Level-order leads to a iterative bfs-like implementation. Elegant solution.
* How to mark the ending of a tree:
  - For binary tree, each node only has two children. The most easy way is to simply mark empty left/right child with special character like '#'. Use O(2n) space, n is the number of treenodes.
  - For n-ary tree, each node has variable number of children. 
    + The first way is to record the number of children it has explicitly. After serializing a node's value, record the number of children it has. If treenode value also contains special characters like '#', there will be problems adopting this approach.
    + The second way is to record the number of children it has implicitly. After serializing a node's value, continue with serializing its children node, then finish with a special character like '#'. 
```java
/*
binary tree
        1
      /   \ 
     2     3
    / \
   4   5
        \
         6
Steps:
serialize 1:
 1, 
serialize 1's children:
 2, 3, 
serialize 2's children:
 4, 5,
serialize 3's children:
 #, #, 
......

         1
   /  /  |  \   \
  2  3   4   5   6
    / \
    7  8     
        \
         9 
Steps:
serialize 1                             
 1,   
serialize 1's children  
 2, 3, 4, 5, 6, #,     
serialize 2's children
 #,           
serialize 3's children 
 7, 8, #,                
......

```

### Path on tree 


### Segment tree 
* Segment Tree: Range sum query and update in O(logn) time
```java
class SegmentTreeNode
{
  int start;
  int end;
  SegmentTreeNode left;
  SegmentTreeNode right;
  int sum;
  public SegmentTreeNode( int start, int end )
  {
    this.start = start;
    this.end = end;
    this.left = null;
    this.right = null;
    this.sum = 0;
  }
}

  private SegmentTreeNode build( int[] nums, int start, int end )
  {
    if ( start > end )
    {
      return null;
    }
    
    SegmentTreeNode root = new SegmentTreeNode( start, end );
    if ( start == end )
    {
      root.sum = nums[end];
    }
    else
    {
      int mid = start + ( end - start ) / 2;
      root.left = build( nums, start, mid );
      root.right = build( nums, mid + 1, end );
      root.sum = root.left.sum + root.right.sum;
    }
    return root;
  }
    
  private void update( SegmentTreeNode root, int index, int newValue )
  {
    if ( root.start == root.end )
    {
      root.sum = newValue;
      return;
    }
    int mid = root.start + ( root.end - root.start ) / 2;
    if ( mid >= index )
    {
      update( root.left, index, newValue );
    }
    else
    {
      update( root.right, index, newValue );
    }
    root.sum = root.left.sum + root.right.sum;
  }
  
  private int sumRange( SegmentTreeNode root, int start, int end )
  {
    if ( root.end == end && root.start == start )
    {
      return root.sum;
    }
    int mid = root.start + ( root.end - root.start ) / 2;
    if ( mid >= end )
    {
      return sumRange( root.left, start, end );
    }
    else if ( mid < start )
    {
      return sumRange( root.right, start, end );
    }
    else
    {
      return sumRange( root.left, start, mid ) + sumRange( root.right, mid + 1, end );
    }
  }
```

### Binary search tree
* Used to store a collection of items in sorted form
* How to handle duplicates inside binary search tree
  - Allow same keys on left side ( or right side )
  - Augment every tree node with a count field.
    + Benefits 1: Reduce height of tree, complexity of search/insert/delete operations
    + Benefits 2: Search/Insert/Delete easier to do
    + Benefits 3: Suited for rotation operation inside self balancing BSTs.
* Validate binary search tree
  - Iterative inorder traversal, current node > successor (stack top). Works for BST with no duplication constraints
  - Divide and conquer, pass down value range in children nodes

* Generic tree preorder/inorder/postorder iterative traversal with O(logn) space. Three types of implementation could be changed with minimal code change.
```java
class Pair
{
    TreeNode node;
    boolean isFirst; // 0 for first time, 1 for second time
    public Pair( TreeNode node, boolean isFirst )
    {
        this.node = node;
        this.isFirst = isFirst;
    }
}

/** 
 * @param order  0 preorder; 1 inorder; 2 postorder
*/
public void treeHighSpaceTraverse( TreeNode root, int order ) 
{
    Stack<Pair> stack = new Stack<>();
    stack.push( new Pair( root, true ) );
    while ( !stack.isEmpty() )
    {
        Pair stackTop = stack.pop();
        if ( stackTop.node == null )
        {
            continue;
        }
        if ( !stackTop.isFirst )
        {
            System.out.println(stackTop.node.value);
            continue;
        }
        switch ( order )
        {
            case 0:
                stack.push( new Pair( stackTop.node.right, true ) );
                stack.push( new Pair( stackTop.node.left, true ) );
                stack.push( new Pair( stackTop.node, false ) );
                break;
            case 1:
                stack.push( new Pair( stackTop.node.right, true ) );
                stack.push( new Pair( stackTop.node, false ) );
                stack.push( new Pair( stackTop.node.left, true ) );
                break;
            case 2:
                stack.push( new Pair( stackTop.node, false ) );
                stack.push( new Pair( stackTop.node.right, true ) );
                stack.push( new Pair( stackTop.node.left, true ) );
                break;              
        }
    }
}
```
* Tree iterative traversal with O(1) space: Binary threaded tree
```java
  public void constantSpaceTraverse( TreeNode root )
  {
    TreeNode currNode = root;
    while ( currNode != null )
    {
      if ( currNode.left == null )
      {
        System.out.println( currNode.val );
        currNode = currNode.right;
      }
      else
      {
        TreeNode rightMostChild = findRightMostChild( currNode );
        // second time traverse the node
        if ( rightMostChild.right == currNode )
        {
          System.out.println( currNode.val );
          rightMostChild.right = null;
          currNode = currNode.right;
        }
        // first time traverse the node
        else
        {
          rightMostChild.right = currNode;
          currNode = currNode.left;
        }
      }
    }
  }
  
  private TreeNode findRightMostChild( TreeNode root )
  {
    TreeNode currNode = root.left;
    while ( currNode.right != null && currNode.right != root )
    {
      currNode = currNode.right;
    }
    return currNode;
  } 
``` 
* Get inorder traversal predecessor/successor
```java
    TreeNode getPredecessor( TreeNode root, TreeNode target )
    {
      if ( target.left != null )
      {
        TreeNode currNode = target.left;
        while ( currNode.right != null )
        {
          currNode = currNode.right;
        }
        return currNode;
      }
      else
      {
        TreeNode predecessor = null;
        TreeNode currNode = root;
        while ( currNode != target )
        {
          if ( currNode.val >= target.val )
          {
            currNode = currNode.left;
          }
          else
          {
            predecessor = currNode;
            currNode = currNode.right;
          }
        }
        return predecessor;
      }
    }
    
    TreeNode getSuccessor( TreeNode root, TreeNode target )
    {
      if ( target.right != null )
      {
        TreeNode currNode = target.right;
        while ( currNode.left != null )
        {
          currNode = currNode.left;
        }
        return currNode;
      }
      else
      {
        TreeNode successor = null;
        TreeNode currNode = root;
        while ( currNode != target )
        {
          if ( currNode.val >= target.val )
          {
            successor = currNode;
            currNode = currNode.left;
          }
          else
          {
            currNode = currNode.right;
          }
        }
        return successor;
      }
    }
```

## HashMap 
### Use case 
* need a symbol table with search, insert and delete operations

### Best practices 
* Use Double as hashmap keys is a bad practice. Especially if needing to perform calculations on double keys, the hash of double could mess up.
* Use Object as hashmap keys. When the hashCode() and equals(Object o) methods are not overriden by your class, the default implementation are used. The default behavior is to treat all objects as different, unless they are the same object. IdentityHashMap always does this by using reference-equality in place of object-equality

### Collision resolution 
| Strategies | Use case         | 
| --------------------- |:-------------:| 
| Chaining with linked list  | worst case O(n), most commonly used    |
| Chaining with BST  | worst case O(logn), input extremely nonuniform distribution     |
| Open addressing with probing  | number of collisions really low  |

### Intersection 
```java
// Compute the intersection of two hashmap/hashset

Map<Integer, String> mapA = ...; 
Map<Integer, String> mapB = ...; 
// will remove all non-matching Map.Entry pairs in mapB from mapA
mapA.entrySet().retainsAll( mapB.entrySet() );
// will remove non-existing key in mapB from mapA
mapA.keySet().retainsAll( mapB.keySet() );

Set<Integer> setA = ...;
Set<Integer> setB = ...;
// will remove all non-matching Integer from A
setA.retainsAll( setB );

```

### Histogram and hashmap list 
```java
// more concise code for histogram with getOrDefault() API
map.put( key, 1 + map.getOrDefault( key, 0 ) );
// more concise code for hashmap list with putIfAbsent() API
map.putIfAbsent( key, new ArrayList<>() );
```

### Anagram 
* Given an array of string, group it into anagrams (the number of strings is m, the number of chars in a string is n). The key of the problem is how to identify anagrams:
  - Use sorted string as key, T.C. O(mnlogn), S.C. O(mn)
  - If the charset is not too big (like lowercase/uppercase letters), use histogram of string as key (like counting sort) T.C. O(mn), S.C. O(mn)
```java
private final static int CHARSET_SIZE = 26;
public List<List<String>> groupAnagrams( String[] strs )
{
  Map<String, List<String>> groupedAnagrams = new HashMap<>();
  for ( String str : strs )
  {
    char[] histogram = new char[CHARSET_SIZE];
    for ( char ch : str.toCharArray() )
    {
      histogram[ch-'a']++;
    }
          
    String key = new String( histogram ) ;
    groupedAnagrams.putIfAbsent( key, new ArrayList<>() );
    groupedAnagrams.get( key ).add( str );
  }
  return groupedAnagrams.values( ).stream( ).collect( Collectors.toList( ) );
}
```

### Sparse Vector/matrix 
* What are the operations that need to be supported
  - Look up
  - Iterate through the array
  - Add/Delete

* Sparse vector representation comparison

| Representation    | In-order iteration | Add/Delete complexity | Lookup Complexity | 
| ------------------|:------------------:|:---------------------:| -----------------:|
| List of pairs     |     Support        |        O(n)           |      O(n)         |
| Array of pairs    |     Support        |        O(n)           |      O(lgn)         |
| Map&lt;Index,Value&gt; |       No        |        O(1)           |      O(1)         |
| TreeMap&lt;Index,Value&gt;   |       Support       |        O(lgn)           |      O(lgn) | 

* Sparse matrix representation comparison

| Representation    | In-order iteration | Add/Delete complexity | Lookup Complexity | 
| ------------------|:------------------:|:---------------------:| -----------------:|
| List of List     |     Support        |        O(m+n)           |      O(m+n)         |
| Array of Array    |     Support        |        O(m+n)           |      O(lgm+lgn)         |
| Map of Map |       No        |        O(1)           |      O(1)         |
| TreeMap of TreeMap  |       Support       |        O(lgn)           |      O(lgn) | 

* Sparse vector m * Sparse vector n
  - Array-based and TreeMap-based representation both work here
  - Similar size: Two pointers O(m + n)
  - Small + large size: Iterate one while binary search on the other one O(nlogm)

* Sparse matrix
  - The straightforward way to do this will result in three-level for loop. To reduce the complexity, needs to eliminate inner loop number.
  - Solution1: detecting empty entries on the fly
  - Solution2: compress one matrix as hashtable first and then multiply with the other one
```java
// the most naive way: O(m*n*t)
for ( int i = 0; i < A.length; i++ )
{
  for ( int j = 0; j < B[0].length; j++ )
  {
    for ( int k = 0; k < A[0].length; k++ )
    {
      result[i][j] += A[i][k] * B[k][j];
    }
  }
}
// move looping order
for ( int i = 0; i < A.length; i++ )
{
  for ( int k = 0; k < A[0].length; k++ )
  {
    if ( A[i][k] != 0 )
    {
      for ( int j = 0; j < B[0].length; j++ )
      {
        if ( B[k][j] != 0 )
        {
          result[i][j] += A[i][k] * B[k][j];
        }
      }
    }
  }
}
```

### LRU Cache 
* HashMap + DDL
* LinkedHashMap + manual removing oldest entry and reset
* LinkedHashMap ( access order + removeEldestEntry() )
  - Access order
    + When specified: The accessOrder flag is set when creating the LinkedHashMap instance using the LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) constructor
    + accessOrder=true: The elements are ordered according to their access: When iterating over the map the most recently accessed entry is returned first and the least recently accessed element is returned last. Only the get, put, and putAll methods influence this ordering.
    + accessOrder=false: The elements are ordered according to their insertion. This is the default if any of the other LinkedHashMap constructors is used. In this ordering read access to the map has no influence on element ordering.
  - removeEldestEntry(Entry)
    + This method is called with the eldest entry whenever an element is added to the map. Eldest means the element which is returned last when iterating over the map. So the notion of eldest is influenced by accessOrder set on the map. The removeEldestElement in its default implementation just returns false to indicate, that nothing should happen. An extension of the LinkedHashMap may overwrite the default implementation to do whatever would be required:
```java
public class LRUCache<K, V> extends LinkedHashMap<K, V> 
{
  private final int limit;
  public LRUCache( int limit ) 
  {
    super( 16, 0.75f, true );
    this.limit = limit;
  }

  @Override
  protected boolean removeEldestEntry( Map.Entry<K,V> eldest )
  {
    return size() > limit;
  }
}

```

## TreeMap 
* Get Key/Entry APIs: firstKey/firstEntry, lastKey/lastEntry, lowerKey/lowerEntry, higherKey/higherEntry, CeilingKey/CeilingEntry, floorKey/floorEntry
* Remove Key/Entry APIs: pollFirstEntry/pollLastEntry, remove
* Get Subset APIs: tailMap/headMap/subMap

## Graph 
### Edge list vs Adjacent list vs Adjacent matrix
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

### Build graph 
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

### Detect cycles inside undirected graph

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

### Detect cycles inside directed graph

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

## Trie 
### Use case 
* Find prefix of string
* Traverse character by character
* Compared with hashmap: 
   - Space complexity: when storing a list of words (Especially when these words share prefix), using trie save space. 
   - Time complexity: to compute hashcode for a string, O(n) time complexity; find/insert a string in a trie, the same

### Trie definition and common tasks
* Depending on the size of charset, children pointers could be either stored in a bitmap or hashmap. Although slightly suffering performance, hashmap implementation is more concise and generic.
* Common tasks such as search() and startwith() can be implemented in a similar way. 

```java
  class Trie
  {

    class TrieNode 
    {
        public Map<Character, TrieNode> children;
        public boolean isLeaf;
        public char val;
        
        public TrieNode() 
        {
            children = new HashMap<>();
        }
        
        public TrieNode( char val )
        {
            this();
            this.val = val;
        }
    }

    public TrieNode root;

    // Inserts a word into the trie.
    public void insert( String word )
    {
      TrieNode currNode = root;
      for ( int i = 0; i < word.length(); i++ )
      {
        currNode.children.putIfAbsent( word.charAt( i ), new TrieNode( word.charAt( i ) ) );
        currNode = currNode.children.get( word.charAt( i ) );
      }
      currNode.isLeaf = true;
    }

    public boolean searchIterative( String word )
    {
      TrieNode currNode = root;
      for ( int i = 0; i < word.length(); i++ )
      {
        currNode = currNode.children.get( word.charAt( i ) );
        if ( currNode == null )
        {
          return false;
        }
      }
      return currNode.isLeaf;
    }
        
    public boolean startWithIterative( String word )
    {
      TrieNode currNode = root;
      for ( int i = 0; i < word.length(); i++ )
      {
        currNode = currNode.children.get( word.charAt( i ) );
        if ( currNode == null )
        {
          return false;
        }
      }
      return true;
    }
    
    // Returns if the word is in the trie.
    public boolean searchRecursive( String word )
    {
        if ( root == null )
        {
            throw new IllegalStateException( "" );
        }
        return searchRecursive( word, 0, root );
    }

    private boolean searchRecursive( String word, int wordPos, TrieNode currNode )
    {
      if ( currNode == null )
      {
        return false;
      }
      else if ( wordPos == word.length() )
      {
        return currNode.isLeaf;
      }
      else
      {
        return searchRecursive( word, wordPos + 1, currNode.children.get( word.charAt( wordPos ) ) );
      }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWithRecursive( String prefix )
    {
      return startsWithRecursive( prefix, 0, root );
    }
    
    private boolean startsWithRecursive( String prefix, int prefixPos, TrieNode currNode )
    {
      if ( currNode == null )
      {
        return false;
      }
      else if ( prefixPos == prefix.length() )
      {
        return true;
      }
      else
      {
        return startsWithRecursive( prefix, prefixPos + 1, currNode.children.get( prefix.charAt( prefixPos ) ) );
      }
    }

  }

```


# Algorithms 

## Math 
### Random 
* Reservoir sampling: sample k from n
  - Example problems: Shuffle an array, Random pick index, Linked list random node.
```java
public List<Integer> sample( List<Integer> list, int k )
{
    final List<Integer> samples = new ArrayList<Integer>( k );
    int count = 0;
    final Random random = new Random();
    for ( Integer item : list ) 
    {
        if ( count < k ) 
        {
            samples.add( item );
        } 
        else 
        {
            // http://en.wikipedia.org/wiki/Reservoir_sampling
            // In effect, for all i, the ith element of S is chosen to be included in the reservoir with probability
            // k/i.
            int randomPos = random.nextInt( count );
            if ( randomPos < k ) 
            {
                samples.set( randomPos, item );
            }
        }
        count++;
    }
    return samples;
}
```
* Generate weighted random number
  - Build a prefix sum array of frequency
  - Generate random number and use binary search for last smaller entry

### Mod 
* judge whether a value is even or odd
  - Use num % 2 != 0 rather than num % 2 == 1 because of negative number mod ( e.g. -5 % 2 == -1 )
  - To guarantee mod result is always positive, if knowing num range RANGE, could consider ( num + RANGE ) % RANGE 

### Power 
* Power of integer: Java does not provide a built-in function for Integer values
  - solution 1: It has a built-in function double Math.pow( double, double ). But the computation cost for double is much higher than int and the result needs to be downcasted.
  - solution 2: Use multiply instead when exponent is low. 
  - solution 3: When 2 is radix, use bit shifting
  - solution 4: Implement in-house pow for integers based on divide and conquer

### Sqrt 

### Divide 
* Divide two integers ( useful names: dividend/numerator, divisor/denominator, quotient, residue )
  * handle boundary cases ( 0, Integer.MIN_VALUE )
    + return int quotient
    + return double quotient
        - record quotient symbol ( neg/pos )
        - convert dividend and divisor to positive
        - calculate integer part 
        - calculate fraction part 
            + quotient = ( residue * 10 ) / divisor
            + residue = ( residue * 10 ) % divisor
            + use hashmap to record residue and occuring positions to handle recurring
        - concatenate symbol, integer part, dot, fraction part (possibly with parentheses)

### Multiply 

### Prime 
* Check for primality
  * Naive solution: Iterate from 2 through i
  * Slightly better: Iterate from 2 through sqrt(i)
* Generate a list of primes: the sieve of eratosthenes
  * Start with a list of all the numbers up through some value max.
  * First cross off all numbers divisible by 2.
  * Then look for the next prime and cross off all numbers divisible by it. 
  * By continuing doing this, we wind up with a list of prime numbers from 2 through max.
```java
boolean[] sieveOfEratosthenes( int max )
{
    boolean[] flags = new boolean[max + 1];
    int count = 0;
    
    init(flags);
    int prime = 2;
    
    while ( prime <= Math.square(max))
    {
        // cross off remaining multiples of prime
        crossOff( flags, prime );
        
        // find next value which is prime
        prime = getNextPrime( flags, prime );
    }
    return flags;
}

void crossOff( boolean[] flags, int prime )
{
    for (int i = prime * prime; i < flags.length; i += prime )
    {
        flags[i] = false;
    }
}

int getNextPrime( boolean[] flags, int prime )
{
    int next = prime + 1;
    while ( next < flags.length && !flags[next] )
    {
        next++;
    }
    return next;
}
```

## Bit manipulation 
### Arithmetic vs logic right shift 
  * Arithmetic right shift >>, shift bits to the right but fill in the new bits with the value of the sign bit
  * Logic right shift >>>, shift bits to the right but fill in the new bits with 0.

### Common tasks 
* get bit, set bit, clear bit and update bit
```java
boolean getBit( int num, int i )
{
    return ((num & (1 << i)) != 0 );
}

int setBit( int num, int i )
{
    return num | (1 << i);
}

int clearBit( int num, int i )
{
    int mask = ~(1 << i);
    return num & mask;
}

// clear all bits from the most significant bit through i (inclusive)
int clearBitsMSBthroughI( int num, int i )
{
    int mask = (1 << i) - 1;
    return num & mask;
}

// clear all bits from i (inclusive) through 0
int clearBitsIthrough0( int num, int i )
{
    int mask = ~(-1 >>> (31 - i));
    return num & mask;
}

// set the ith bit to a value v
int updateBit(int num, int i, boolean bitIs1)
{
    int value = bitIs1 ? 1 : 0;
    int mask = ~(1 << i);
    return (num & mask) | (value << i);
}
```

## Non-DP Memorization 
### Array 
* 1D/2D Prefix sum
```java
// 1D prefix sum
int[] array1D = new int[n];
int[] prefixSum1D = new int[array1D.length+1];
for ( int i = 1; i <= array1D.length; i++ )
{
  prefixSum1D[i] = array1D[i] + prefixSum1D[i-1];
}
// to calculate range sum from i to j
int rangeSum = prefixSum1D[j] - prefixSum1D[i-1];

// 2D prefix sum
int[][] array2D = new int[m][n];
int[][] prefixSum2D = new int[m+1][n+1];
for ( int i = 1; i <= array2D.length; i++ )
{
  for ( int j = 1; j <= array2D[0].length; j++ )
  {
    prefixSum2D[i][j] = array2D[i-1][j-1] + prefixSum2D[i-1][j];
  }
}
// to calculate range sum from (x_s, y_s) to (x_e, y_e)
int areaSum = prefixSum2D[x_e][y_e] - prefixSum2D[x_s-1][y_e] - prefixSum2D[x_e][y_s-1] + prefixSum2D[x_s-1][y_s-1]
```

### Binary indexed tree / Fenwick tree

```python
# source: https://www.hrwhisper.me/binary-indexed-tree-fenwick-tree/
class BinaryIndexTree(object):
    def __init__(self, nums):
        n = len(nums)
        self.nums = [0 for _ in xrange(n+1)]
        self.N = [0 for _ in xrange(n+1)]
        for i, v in enumerate(nums):
            self.set(i+1, v)

    def _lowbit(self, a):
        return a & -a

    def set(self, i, val):
        diff = val - self.nums[i]
        self.nums[i] = val
        while i < len(self.N):
            self.N[i] += diff
            i += self._lowbit(i)

    def get(self, i):
        ret = 0
        while i > 0:
            ret += self.N[i]
            i -= self._lowbit(i)

        return ret

```

### Segment tree

```python
class TreeNode:
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.left = None
        self.right = None
        self.sum = 0
        
class SegmentTree:
    def __init__(self, arr):
        self.root = self.buildTree(arr, 0, len(arr)-1)
        
    def buildTree(self, arr, l, r):
        if l > r: return None
        root = TreeNode(l, r)
        if l == r: root.sum = arr[l]; return root
        m = l + (r - l) // 2
        root.left = self.buildTree(arr, l, m)
        root.right = self.buildTree(arr, m+1, r)
        root.sum = root.left.sum + root.right.sum
        return root
        
    def update(self, index, val, node=None):
        if node is None: 
          node = self.root
        if node.start == node.end: 
          node.sum = val; 
          return 
        m = node.start + (node.end - node.start) // 2
        if index <= m: 
          self.update(index, val, node.left)
        else: 
          self.update(index, val, node.right)
        node.sum = node.left.sum + node.right.sum
        
    def sumRange(self, st, end, node=None): 
        if node is None: 
          node = self.root
        if node.start == st and node.end == end: 
          return node.sum
        m = node.start + (node.end - node.start) // 2
        if end <= m: 
          return self.sumRange(st, end, node.left)
        if st >= m+1: 
          return self.sumRange(st, end, node.right)
        return self.sumRange(st, m, node.left) + self.sumRange(m+1, end, node.right)

```

### Stack 
* Maintain inc/dec sequences
  + Example problems: min stack, trapping rain water, largest rectangle in histogram, longest valid parentheses

### HashMap 
* Maximum size subarray sums to K, clone graph, two sum

## Two pointers 
### Begin and end type 
* Two sum type
  - example problems: two sum (sorted), three sum, four sum, three sum closest, three sum smaller
```python
while i < j:
  if  A[i] and A[j] satisfy some condition:
    j--; 
    ...
  elif A[i] and A[j] do not satisfy some condition:
    i++; 
    ...
  else
    i++ 
    j--
```

* Partition (quick select) type - calculate kth largest element O(n) = n + 1/2 n + 1/4 n + 1/8 n + ..... < 2n. E.g. Sort colors, wiggle sort II, Valid palindrome, partition array by odd and even
```java
// int[] input, int left, int right
    int pivot = input[(left+right)/2];
    while(i <= j)
    {
          while(input[i] < pivot)
          {
              i++;
          }
          while(input[j] > pivot)
          {
              j--;
          }
         
          if(i <= j)
          {
                swap(data, i, j);
                i++;
                j--;
          }         
     }
```

### Slow and fast type 
* Find the middle of linked list
* Find linked list cycle

### Window type 
* Improve naive two level for loop to for-outer loop + while inner loop 
* E.g. minimum window substring, minimum size subarray sum, Longest substring with at most K distinct characters, Longest substring without repeating characters
```java
for ( i = 0; i < n; i++ )
{
  while ( j < n )
  {
    // update j status
    if ( satisfy some condition )
    {
      j++;
    }
    else
    {
      break;
    }    
  }
}
```

### Two arrays type 
* Interval related (merge interval, insert interval)
```java
public List<Interval> insert( List<Interval> intervals, Interval newInterval )
{
      
  List<Interval> result = new ArrayList<>();
  if ( intervals == null || intervals.size() == 0 )
  {
    result.add( newInterval );
    return result;
  }
      
  Interval curr = newInterval;
  for ( Interval interval : intervals )
  {
    if ( isOverlap( interval, curr ) )
    {
      curr = new Interval( Math.min( curr.start, interval.start ), Math.max( curr.end, interval.end ) );
    }
    else if ( isEarlier( interval, curr ) )
    {
      result.add( interval );
    }
    else
    {
      result.add( curr );
      curr = interval;
    }
  }
      
  result.add( curr );
  return result;
}
```

## Sort 
### Common sorting algorithms 

| Algorithm | memory    | Use case  | 
| --------------------- |:---------:| -----:|  
| Mergesort  | O(1)     | external sorting / stable |
| Quicksort  | O(n)     |  usually the quickest O(nlogn) / unstable sort |
| Heapsort   | O(1)     |  unstable sort |
| Bucketsort | O(1)     |  when knowing range and evenly distributed O(n+k) |

### Built-in sort interfaces 
* Sort interfaces: Arrays.sort( array, comparator ) Collections.sort( collection, comparator ) method, list.sort( comparator )

### Types 
* Interval-related
  - Judge whether intervals overlap
```java
boolean isOverlapping( Interval o1, Interval o2 )
{
  if ( o1.start >= o2.end || o2.start >= o1.end )
  {
    return false;
  }
  else
  {
    return true;
  }
}
```
  - Sort intervals
```java
List<Interval> list = //...
// sort according to starting point
list.sort( (o1,o2) -> o1.start - o2.start );
// or sort according to ending point
list.sort( (o1,o2) -> o1.end - o2.end );
// sort according to both starting and ending point
list.sort( (o1,o2) -> o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end );
```
  - Split intervals into Pair(int start, boolean isStart), Pair(int end, boolean isEnd)
```java
List<Interval> intervalList = //...
List<Pair> pairList = //...
for ( Interval interval : intervalList )
{
  pairList.add( new Pair(interval.start, true) );
  pairList.add( new Pair(interval.end, false) );
}
pairList.sort( (o1, o2) -> (o1.start-o2.start) );
```

### Top K
### Stream API
* Get min/max from a list of integer
```java
List<Integer> list = //...
int min = list.stream()
              .min( Integer::compare )
              .get();
int max = list.stream()
              .max( Integer::compare )
              .get();
```

## Binary search 
### Best practices 
```java
public int binarySearchIterative( int[] array, int target)
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

    // take result from start, end or nonexist according to different criteria
    // ......
}

public int binarySearchRecursive( int[] array, int target, int start, int end )
{
    // truning
    if ( start > end )
    {
        return -1;
    }
    // base condition
    if ( start + 1 >= end )
    {
        if ( array[start] == target )
        {
            return start;
        }
        else if ( array[end] == target )
        {
            return end;
        }
        else
        {
            return -1;
        }
    }
    // recursion body
    int mid = ( end - start ) / 2 + start;
    if ( array[mid] < target )
    {
        return binarySearchRecursive( array, target, mid, end );
    }
    else
    {
        return binarySearchRecursive( array, target, start, mid );
    }
}
```
### How to handle duplicates 

### Types 
* First/Last smaller/bigger than target 

* Rotated array 

* Two dimensional array 

## Recursive functions 
### Recursive vs iterative solutions 
  - Recursive algo can be very space inefficient. Each recursive call adds a new layer to the stack. If the algorithm recurses to a depth of n, it uses at least O(n) space.
  - All recursive algo can be implemented iteratively, although sometimes the code is more complex. 
  - Before diving into writing recursive code, ask myself how hard it would be to implement iteratively and discuss tradeoffs with your interviewer.

### Recursion time complexity cheat sheet 

| Recurrence | Algorithm           | Big-O Solution  |
| --------------------- |:-------------:| -----:|
| T(n) = T(n/2) + O(1)  | Binary search | O(lgn) |
| T(n) = T(n-1) + O(1)  | Sequential search      |   O(n) |
| T(n) = 2T(n/2) + O(1) | Tree traversal      |  O(n) |
| T(n) = 2T(n/2) + O(n) | Merge sort      |    O(nlogn) |
| T(n) = T(n-1) + O(n)  | Selection sort      |  O(n^2) |


### Steps in using recursion 
  - What does the recursive function do?
    + Take what parameters
    + Do what
    + return what value and how
  - How does big problems recurse to smaller ones
  - Initialization
  - Prunning

### How to return multiple results from recursive functions
  - Use global variable. 
    + The first is to use private instance variables to store results
    + The second is to use a mutable argument of type ( int[], List&lt;&gt; ). Modify the value of this argument while travering.
  - Use return value
    + If multiple results are of same type, define return type as an array T[]
    + If only two results are returned, consider using AbstractMap.SimpleEntry<K,V>
    + Define a result wrapper class

```java
// 1. not use use global variables
// 1.1. global variables as class instance
public class XXX
{
  private int max;
  // change this global int
}
// 1.2. global variables as mutable function arguments
public void maxNodeValue( TreeNode root, int[] max ) 
public void maxNodeValue( TreeNode root, List<Integer> max )

// 2. use return value
// 2.1. use array T[] as return type
public int[] maxNodeValue( TreeNode root )
// 2.2. AbstractMap.SimpleEntry<K,V>
public Map.Entry function()
{
  new AbstractMap.SimpleEntry<>( key, val );
}
// 2.3. define a result wrapper class as class inner class
private class ResultWrapper
{
  public final int numFoundNodes;
  public final TreeNode lcaNode;
  public ResultWrapper( int numFoundNodes, TreeNode lcaNode )
  {
    this.numFoundNodes = numFoundNodes;
    this.lcaNode = lcaNode;
  }
}
```

### Avoid duplicated recursion 
* ensuring that the never two recursion tree branches overlap 

```java
if ( i > 0 && candidates[i] == candidates[i-1] )
{
  i++;
  continue;
}
// invoking functions based on index i
```

### Types 

* Tree-based recursion 
  - One of the key problems resulting from TreeNode definition is that TreeNode has no info about its parent node. But to resolve a tree-based problem, it is usually required to combine child and parent information.
  - Two basic strategies to solve this problem
    + Pass parent node as an input argument to child recursive function, then resolve problem inside child function. This approach usually needs some global variables, as discussed before.
    + Solve children recursive functions first, then resolve problem inside parent function. This approach usually needs some complex return value types, as discussed before. 
```java
// pass parent node as an input argument to child
public void  firstApproach( TreeNode currNode, TreeNode parentNode, int[] longestPath )
{
  // compare currNode with parentNode and update longestPath
  //...
}

// return value from child
public ResultWrapper secondApproach( TreeNode currNode )
{
  //...
  
  ResultWrapper leftResult = secondApproach( currNode.left);
  ResultWrapper rightResult = secondApproach( currNode.right);
  
  // combine leftResult, rightResult and currNode
  //...

  // return new ResultWrapper(...);
}
```

* Deep copy 
  - Key points: Use a hashmap to store old to new reference mapping
  - Examples: Clone graph, Copy list with random pointer

## Backtrack 
### Best practices 
* There are two popular ways to keep track of traverse path
  * List
    - list.sublist(startIndex, endIndex) returns a sublist of List
    - LinkedList.addFirst(element: Object)/addLast(element: Object)/getFirst()/getLast()/removeFirst()/removeLast(). This could be used in backtracking.
  * StringBuilder
    - strBuilder.append( ch )
    - strBuilder.deleteCharAt( strBuilder.length() - 1 );
```java
// usually occurs at the beginning and ending of a recursive function
public void recursivefunction()
{
    backtracking forward
    // ... other stuff
    backtracking backwards
}
```

### Types 
* Generate all unique permutations 
```java
void generatePerms( List<List<Integer>> allPerms, List<Integer> onePerm, int[] nums, boolean[] isUsed )
{     
  if ( onePerm.size() == nums.length )
  {
    allPerms.add( new LinkedList<>( onePerm ) );
    return;
  }
      
  for ( int i = 0 ; i < nums.length; i++ )
  {       
    if ( !isUsed[i] )
    {
      if ( i > 0 && nums[i] == nums[i-1] && !isUsed[i-1] )
      {
        continue;
      }
          
      isUsed[i] = true;
      onePerm.add( nums[i] );
      generatePerms( allPerms, onePerm, nums, isUsed );
      onePerm.remove( onePerm.size( ) - 1 );
      isUsed[i] = false;
    }
  }
}
```
* Generate all subsets 
```java
void generateSubsets( List<List<Integer>> allSubsets, LinkedList<Integer> oneSubset, int[] nums, int startPos )
{
  if ( startPos > nums.length )
  {
    return;
  }
      
  allSubsets.add( new LinkedList<>( oneSubset ) );
      
  for ( int i = startPos; i < nums.length; i++ )
  {
    if ( i > startPos 
        && nums[i] == nums[i-1] )
    {
      continue;
    }
        
    oneSubset.addLast( nums[i] );
    generateSubsets( allSubsets, oneSubset, nums, i + 1 );
    oneSubset.removeLast( );
  }
}
```
* Generate all combinations summing to a target 
```java
void generateCombs( List<List<Integer>> allCombs, LinkedList<Integer> oneComb, int[] nums, int startPos, int targetSum )
{
  if ( targetSum < 0 || startPos >= nums.length )
  {
    return;
  }
    
  if ( targetSum == 0 )
  {
    allCombs.add( new LinkedList<>( oneComb ) );
    return;
  }
    
  for ( int i = startPos; i < nums.length; i++ )
  {
    oneComb.addLast( nums[i] );
    generateCombs( allCombs, oneComb, nums, i, targetSum - nums[i] );
    oneComb.removeLast( );
  }
}
```
* Generate Decode ways / Gray code
* Grid-based 

## Graph 
### Grid-based graph best practices 
* How to store coordinates: 
   * A customized class Coor
   * If allowing to modify grid, could temporarily place special chars/values to indicate that this position has been visited before. Depending on whether input int grid[][] is a defensive copy, we could decide whether to recover the grid[][] by replacing previously set special chars/values.
* How to track visited coordinates:
   * There are four possible approaches here: 
      * Preferred approach: The first is to use a two-dimensional boolean[][] array. true as visited and false as not visited.
      * The second is to use ( x * grid_width + y ) as Coor hash and put them in a Set&lt;Integer&gt; visited. Integer might overflow but should be enough in an interview setting.
      * Not recommend: The third is replacing entries in grid with some special characters such as '#' to mark as visited. 
      * Not recommend: The fourth is define a customized class Coor to overrided hashCode() and equals() function for Coor class. But this is kind of overkilling for a 45-min interview setting.
```java
class Coor
{
  public final int x;
  public final int y;
  public Coor( int x, int y )
  {
    this.x = x;
    this.y = y;
  } 
}
```

### Grid-based breath first search 
* When the problem asks for the minimum 
```java
public void bfsMainFunction( T[][] grid )
{
  //... other logics

  int height = grid.length;
  int width = grid[0].length;

  Queue<Coor> bfsQueue = new LinkedList<>();
  boolean[][] discovered = new boolean[height][width];

  // suppose the unique starting point is (0,0) here
  bfsQueue.offer( new Coor( 0, 0 ) );
  discoverd[0][0] = true;

  // until queue is empty
  int depth = 1;
  while ( !bfsQueue.isEmpty() )
  {
    // loop through curr level. Note: Do not put bfsQueue.size() inside for loop
    int levelSize = bfsQueue.size();
    for ( int i = 0; i < levelSize; i++ )
    {
      Coor qHead = bfsQueue.poll();

      // try four directions
      for ( int[] direction : directions )
      {
        int neighborX = qHead.x + direction[0];
        int neighborY = qHead.y + direction[1];
        int neighborHash = getCoorHash( neighborX, neighborY, width );
        if ( neighborX < height 
          && neighborY < width
          && !discoverd[neighborX][neighborY] )
        {
          // might include bfs termination logics here
          discoverd[neighborX][neighborY] = true;
          bfsQueue.offer( new Coor( neighborXCoor, neighborYCoor ) );
        }
      } // end of four directions
    } // end of level order

    depth++;
  } 
}
```
* When there are multiple sources/destinations, need to decide whether to start from source/destination according to time complexity analysis
  - Shortest distances to all buildings, walls and gates
  
### Grid-based depth first search 
* When the problem requires a complete search and asks for traversal paths (record path in bfs is much more complicated)
* Grid-based ( e.g. int[][] grid )
```java
public void mainFunc( T[][] grid )
{
  //... other logics
  // suppose the unique starting point is (0,0) here
  boolean[][] discovered = new boolean[][];
  dfs( grid, 0, 0, discovered );
}

private void dfs( T[][] grid, int x, int y, boolean[][] discovered )
{
  int height = grid.length;
  int width = grid[0].length;

  // put boundary/visited check together
  if ( x < 0 
    || x >= height 
    || y < 0 
    || y >= width 
    || discoverd[x][y] )
  {
    return;
  }

  discovered[x][y] = true;
  dfs( grid, x + 1, y, discovered );
  dfs( grid, x - 1, y, discovered );
  dfs( grid, x, y + 1, discovered );
  dfs( grid, x, y - 1, discovered );
}

```

### Count number of components 
```java
int numIsland = 0;
boolean[][] isVisited = new boolean[height][width];
for ( int i = 0; i < height; i++ )
{
  for ( int j = 0; j < width; j++ )
  {
    if ( grid[i][j] == '1' && !isVisited[i][j] )
    {
      numIsland++;
      visitIslandBFS/DFS( grid, isVisited, i, j );
    }
  }
}
```

### Word-based breath first search 
* Example problem: word ladder
* Solution 1: Build a graph explicitly and then search for bfs path. 
  - Use case: When the word list is small
  - Complexity
    + Build a graph: O( list.length() * word.length() * list.length() )
    + Breath first search O( list.length() )
* Solution 2: Do not build graph explicity, start bfs from current word
  - Use case: When the character set is small (e.g. only contains lower case alphabetical letters) and word list length is large
  - Complexity
    + Breath first search O( list.length() * word.length() * 26 )

### Topological sort 
* There are basically two categories of methods for topological sort. The first one is greedy algorithm with O(|V|^2 + |E|) time complexity. The second is based on depth first search with O(|V| + |E|) time complexity. Here only discusses DFS based approach. 
* When using DFS based approach, there are two cases which should be taken care of. The first one is what if there exists no topological order at all. The second is how to return topological order.
   * What if there exists no topological order - a cycle is detected. 
      * How to detect cycle: use UNDISCOVERED, DISCOVERED, VISITED to represent three possible states of graph nodes. Use a Set&lt;?&gt; isDiscovered and Set&lt;?&gt; isVisited to record all history info. If met up with a node which has been discovered but not visited, then a cycle is detected. 
      * How to handle cycle: return a boolean value (preferred) or throw an exception (not really suitable because they are expected cases)
   * What if need to return topological order
      * If do not need to detect cycle, could simply use a Stack&lt;&gt; order to record the visited node, namely using Set&lt;?&gt; discovered, Stack&lt;?&gt; visited 
      * If need to detect cycle, namely using Set&lt;?&gt; discovered, LinkedHashSet&lt;?&gt; visited
```java
    public int[] getTopoOrder(Map<Integer, Set<Integer>> graph)
    {
        Set<Integer> discovered = new HashSet<>();
        Set<Integer> visited = new LinkedHashSet<>();
        for ( Integer node : graph.keySet() )
        {
          if ( !discoverd.contains( node ) )
          {
            if ( !topoSort( graph, node, discovered, visited ) )
            {
              // a cycle is detected....error handling
            }
          }
        }

        return visited.stream().reverse().collect( Collectors.toL);
        int[] topoOrder = new int[visited.size()];
        int pos = topoOrder.length - 1;
        for ( Integer node : visited )
        {
          topoOrder[pos] = node;
          pos--;
        }

        return topoOrder;
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

### Union find 
* Suitable in a dynamically changing graph. 
  - Complexity: O(lgn)
  - Example problems: Number of Island II, find weakly connected components in directed graph, find connected components in undirected graph
```java
Map<Integer, Integer> father = new HashMap<>();

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

## Greedy 
* Usually greedy algo are not covered in an interview setting:
  - Greedy algo do not generalize as a useful way to decompose and solve problems. 
  - Naive greedy algo are usually "short sighted" algo, which will not lead to global maximal. Working greedy algo are usually hard to think of. 
* But there are exceptions
  - Increasing triplet sequence, paint house II

## Dynamic-programming 
### Use cases
* When to use - optimize time complexity from O(n!,2^n) to O(n^2, n^3)
  - Calculate max or min
  - Calculate the number of solutions
  - Calculate whether it is true or not
* When not to use - optimize time complexity from O(n^3, n^2) further
  - Calculate concrete solutions themselves rather than just the number of solutions
  - Input is a collection rather than a sequence (e.g. Longest consecutive sequence)

### Problems to consider
* State: how to define dp[i] or dp[i][j]
* Induction rule: how to calculate big problems into smaller ones
* Initialization: starting point
* Answer: ending point

### Implementation methods: 
* Multi-loop: bottom-up approach
* Memorized search: top-down approach
* Use cases:
  - In most cases, both of them can be applied. Could start with bottom-up approach because it is usually more concise. 
  - But some times memorized search is more appropriate
    + When it is easier to start thinking from the last step rather than the first step. Example: Burst ballons, Stone-game (Lintcode)
    + When the induction rule is not sequential, thus hard to define.  Example: Longest increasing subsequences in 2D (Lintcode)
    + When the initialization state is hard to find. Example: Longest increasing subsequences in 2D (Lintcode)

### Memorization array tricks 
* For non grid-based dynamic programming problems, for N number/character, array of size N+1 is allocated. The position at 0 index is used for specially used for initialization.
* Rolling array
  - for 1D dp, e.g.
    + If induction rule is f[i] = max(f[i-1], f[i-2]) + A[i], namely f[i] only depends on f[i-1] and f[i-2]
    + To use rolling array, induction rule can be rewritten as f[i%2] = max(f[i-1]%2, f[i-2]%2)
  - for 2D dp, e.g.
    + if f[i][j] only depends on f[i][.], namely i th row only depends on i-1 th row
    + To use rolling array, induction rule can be rewritten as f[i%2][j] = f[(i-1)%2] row
  - procedures to use rolling array: write non-rolling version first, then write rolling version 

```java
// this code snippets demonstrate procedures to use rolling array
// 1D case
// first step: write a solution not based on rolling array
public int houseRobber( int[] A )
{
  int n = A.length;
  if ( n == 0 )
  {
    return 0;
  }
  long[] res = new long[n+1];

  res[0] = 0;
  res[1] = A[0];
  for ( int i = 2; i <= n; i++ )
  {
    res[i] = Math.max( res[i-1], res[i-2] + A[i-1]);
  }
  return res[n];
}
// second step: use mod % to transform solution to rolling array
// res[i] is  only related with res[i-1] and res[i-2], mod 2
public int houseRobber_RollingArray( int[] A )
{
  int n = A.length;
  if ( n == 0 )
  {
    return 0;
  }
  long[] res = new long[2];

  res[0] = 0;
  res[1] = A[0];
  for ( int i = 2; i <= n; i++ )
  {
    // key change here: %k, k is related with number of elements being relied on
    res[i%2] = Math.max( res[(i-1)%2], res[(i-2)%2] + A[i-1]);
  }
  return res[n];  
}
```

### Type
- Coordinate based 
  + Patterns:
    * state: f[x,y] represents goes to x,y position from starting point
    * induction rule: f[x,y] from f[x-1, y] or f[x, y-1]
    * initialization: f[0,0~width], f[0~height, 0]
    * answer: usually f[m,n]
  + Examples: Minimum Path Sum, Unique Path I�, Climbing stairs, Jump game I/II
- 1D sequence 
  + Patterns:
    * state: f[i] represents first i position, digits, characters
    * induction rule: f[i] from f[j], j < i
    * initialize: f[0] = 0, f[1]
    * answer: f[n]
  + Examples: Longest increasing subsequence, Word break I, House robber
- 2D sequences 
  + Patterns: 
    * state: f[i,j] represents the results of first i numbers/characters in sequence one matching the first j numbers/characters in sequence two
    * induction rule: how to decide f[i,j] from previous (varies a lot here)
    * initialize: f[0,i] and f[i,0]
    * answer: f[n,m]( n = s1.length(), m = s2.length() )
  + Examples: Edit distance, Regular expression matching, Longest common subsequences, Maximal rectangle/Square
- Range based 
  + Patterns:
    * state: f[i,j] represents whether the substring from i to j is a palindrome
    * induction rule: f[i,j] = f[i+1,j-1] && (s[i] == s[j])
    * initialize: f[i][i] = true, f[i][i+1] = s[i] == s[i+1]
    * answer: f[0,n]
  + Examples: Palindrome partition II, Coins in a line III (Lintcode), Stone game, Burst ballons, Scramble string 
- Game 
  + Patterns:
    * state: f[i] represents win/lose max/min profit for the first person
    * induction rule: avoid defining second person's state because second person always tries his best to defeat first person/make first person profit least.
    * initialize: varies with problem
    * answer: f[n]
  + Examples: Coin in a line (Lintcode), Coin in a line II (Lintcode), Flip game II
- Backpack 
  + Patterns:
    * state: f[i][S]: whether the first i items could form S/Max value/number of ways
    * induction rule: varies with problems
    * initialize: varies with problems
    * answer: varies with problems
  + Examples: Backpack I-VI (Lintcode), K Sum (Lintcode), Minimum adjustment cost (Lintcode)