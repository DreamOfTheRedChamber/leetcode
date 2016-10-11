# loop through leetcode one more time, ; )
* [Core strategies](#strategy)
    * [Thinking perspectives](#think-perspectives)
    * [Faster responses](#faster-responses)
    * [When met with easy/hard/tricky problems](#met-with-easy-hard-tricky-problems)
* [Practice patterns](#practice-patterns)
    * [Tools](#practice-tools)
    * [Habits](#practice-habits)
* [Interview patterns](#interview-patterns)
    * [Before coding](#interview-before-coding)
    * [While coding](#interview-while-coding)
    * [Clean up](#interview-after-coding)
* [Questions to confirm about input](#questions-to-confirm-about-input)
    * [Field types](#question-field-type)
    * [Array](#question-array)
    * [Linkedlist](#question-linkedlist)
    * [Binary search](#question-binary-search)
    * [String](#question-string)
    * [Tree](#question-tree)
    * [Graph](#question-graph)
* [Questions to confirm about output](#questions-to-confirm-about-output)
* [Typical follow up questions](#questions-follow-up)
* [Learned lessons: Java basics](#learned-lessons-java-basics)
    * [Type size](#basics-type-size) 
    * [Error-prone APIs](#basics-error-prone-apis)
    * [Rarely mentioned APIs](#basics-rarely-mentioned-apis)
    * [Math](#basics-math)
    * [Type conversions](#basics-type-conversions)
    * [Iterator](#basics-iterator)
    * [Error handling](#error-handling)
    * [Collections internals](#basics-collections-internals)
* [Learned lessons: data structures](#learned-lessons-data-structures)
    * [Progressive enhancement on data structures](#progressive-enhancement-on-ds)
    * [Array](#ds-array)
    * [String](#ds-string)
    * [Linkedlist](#ds-linkedlist) 
    * [Stack](#ds-stack)
    * [Queue](#ds-queue)
    * [PriorityQueue](#ds-priorityqueue)
    * [Tree](#ds-tree)
    * [Binary search tree](#ds-binary-search-tree)
    * [HashMap](#ds-hashmap)
    * [TreeMap](#ds-treemap)
    * [Graph](#ds-graph)
    * [Trie](#ds-trie)
* [Learned lessons: algorithms](#learned-lessons-algorithms)
    * [Progressive enhancement on algorithms](#progressive-enhancement-on-algorithms)
    * [Two pointers](#algorithms-two-pointer)
       * [Begin and end type](#algorithms-boundary-to-center)
       * [Slow and fast type](#algorithms-slow-and-fast)
       * [Window type](#algorithms-window)
       * [Two arrays type](#algorithms-two-arrays)
    * [Sort](#algorithms-sort)
    * [Binary search](#algorithms-binary-search) 
    * [Recursion](#algorithms-recursive)
    * [Backtrack](#algorithms-backtrack)
    * [Graph](#algorithms-graph)
       * [Grid-based graph patterns](#algorithms-grid)
       * [Breath first search](#algorithms-bfs)
       * [Depth first search](#algorithms-dfs)
       * [Topological sort](#algorithms-topo)
       * [Union find](#algorithms-union-find)
    * [Dynamic programming](#algorithms-dynamic-programming)
       * [One dimension](#dynamic-programming-1d)
       * [Two dimensions](#dynamic-programming-2d)
       * [Memorization](#dynamic-programming-memo)
       * [Game](#dynamic-programming-game)
* [Edge case tests](#edge-case-tests)  
* [Bad smells for refactoring and optimization](#bad-smells)
* [Sins](#sins)
   * [Java sins](#sins-java)
   * [Whiteboard coding sins](#sins-whiteboard-coding) 
   * [Leetcode sins](#sins-leetcode)

### Core Strategies <a id="core-strategies"></a>
#### Think perspectives: how to understand interviewer's expectations <a id="think-perspectives"></a>
  * Think as if you are desigining product
    * identify problems
    * make tradeoffs
    * attention to details
    * be passionate
  * Think as if you are talking to your teammates
    * be a logical person, optimize from brute force to best
    * speak out your thoughts for discussion when stuck
    * be humble, always quick to take ideas from others
    * demonstrate strong engineering skills/habits
  * Think as if this is the last time that you are doing this in such a detailed way in your life. Next time when I hunt for jobs, either HRs will find me or I will have far less time to prepare

#### Faster responses: how to load previously solved problems more quickly into my memory <a id="faster-responses"></a>
  * Use a concrete example to wake up associated memory
  * Identify problem types and key points for that type of problems. e.g.
    * For stack type of problems, think about when to push/pop out of stack
    * For breath first search type of problems, think about starting point
    * For two-pointer type of problems, think about pointer start position(start/end position), increment/decrement pointer conditions
    * For binary search type of problems, think about whether to go left/right once mid is determined
    * For recursion type of problems, think about recursion base(arguments passed in), truning techniques, recursion order(child/parent first), recursion body, need backtracking

#### When met with easy/hard/tricky problems (although most time medium problems): <a id="met-with-easy-hard-tricky-problems"></a>
* always smile no matter how easy/hard/tricky the problem is, ;)
* for problems of easy/medium difficulty level
  * the hard part usually lies in interviewers' follow-up questions 
* for problems of hard difficulty level
  * summarize an easy-to-remember pattern for each popular hard problem (e.g. regular expression matching, iterative post-order traversal)
  * talk aloud so when stuck, interviewer could help
* for problems which has lots of tricky test cases
    * clarify assumptions about the problem, what are possible inputs/what are not.

### Practice patterns <a id="practice-patterns"></a>
#### Tools<a id="practice-tools"></a>
  * Task planning: Use tags ( TO_START, TO_HURRY, TO_TEST ) to manage algorithm question status and prioritize important tasks
  * Feedbacks: Use git commit number per day as feedback for progress
  * Summarizing lessons: Use git commit message as a place to learn from mistakes and summarize lessons

#### Habits<a id="practice-habits"></a>
  * Check code after finishing: Use JUnit to write and run test cases locally before going to online judge
  * Review your own code for variance: when writing the code once again, which section is the most possible to look different. These easy to change sections are usually error-prone in an time-limited interview setting
  * Think about big picture before going to details: Never use debugger before thinking it through
  * Perfectionism: not just satisfied with running code but always pick the most elegant/efficient ways
  * Think behind the scenes: not just satisfied with fixing the bug but always think and generalize why the bug occurs
  * First things first: Thought process first, then coding
  * Never be lazy: As long as you have not got 100% confidence that I will get the problem right, you should practice coding the problem by hand if time is enough
  
### Interview patterns <a id="interview-patterns"></a>
#### Before coding <a id="interview-before-coding"></a>
1. Make sure I understand the problem
  1. Declare interface in a strategic way (talk about different ways of defining it and trade-offs. e.g. do not define input as string when possible)
  2. (Optional) Clarify ambiguous problem statement, need to gather all requirements before implementing one. 
     1. Refer to "questions to confirm about input" 
     2. "***Whether a valid solution always exist***" 
     3. "***If input is like this, what should output be***"
2. Synchronize with interviewer "***Let's come up with a brute force solution first.***"
3. Work out a brute force solution
  1. Work through a concrete example to abstract the problem
  2. Guarantee to come up with a brute force solution 
    * How I will enumerate all possible solutions / how will I do it in the most stupid way
    * Unstuck strategy: Clear problem abstraction: What kind of ds/algo might be used"
      * Brain storm problem types (min/max, shortest distance, output solutions, search, topo sort), algorithms (recursion, backtracking, sorting, breath/depth-first search, two pointers) / data types (stack, heap, undirected/directed graph, trie)
    * Unstuck strategy: Simplify problem: "***This problem seems kind of complicated. Let's try to solve a simpler problem first***"
    * Unstuck strategy: Give it a try: "***Let's try doing it with XX DS/Algorithm. Not sure if it will work or not.***"
  3. Calc time/space complexity: "***The time complexity of the algorithm is O(XXX) and space complexity is O(XXX)***"
4. Synchronize with interviewer "***Now we have a brute force solution. Let's think ways to improve this***"
5. Optimize
  * Unstuck strategy: Think about upper bound: what are the best time/space complexity I could achieve. "***Since I have to look through all items, so I cann't do better than O(n).***"
  * Unstuck strategy: Identify bad smell for efficiency: whether repetitive computation, redundant space usage appears. "***We have done a lot of repetitive computation in the recursion tree.***"
  * Unstuck strategy: Trade space for time complexity: Identify the bottleneck of brute force solution. "***The bottleneck of the algorithm lies in this section of code***"
  * Unstuck strategy: Give it a try: "***Let's try doing it with XX DS/Algorithm. Not sure if it will work or not.***"
  * Unstuck strategy: Discuss with interviewer for help: Stand back for a while and talk about the challegning you are facing. The interviewer might come in for help when necessary
  * Unstuck strategy: Be keen to what interviewer is saying: Every word the interviewer is saying has its meanings
6. Synchronize with interviewer "***Should we write code for this***"

#### While coding <a id="interview-while-coding"></a>
  1. Write edge/normal test cases first
  2. Synchronize with interviewer: tell my plan first. What are the first step, second step and third step to implement
  3. Check input validity (throw exception or return directly)
  4. Use // or empty line as separator different steps.
  5. Avoid get caught up in trivialities
    * When forget some language-specific trivial: "***I do not remember exactly how the interface looks like, but I'd guess it has an API like this.***"
    * When need a subroutine: "***I am going to use a subroutine with the following interface. I will implement later***".
    * When need double check: Not sure whether my loop should have "<" or "<=". Write a checkmark to remind yourself to check it at the end. Just get the general algorithm down first. 

#### Clean up <a id="interview-after-coding"></a>
  1. Synchronize with interviewer: "***Then I would usually check against some edge cases, should we do that next?***" 
  2. Check the code by myself
     * Check steps:
       1. review the entire code, check whether there are unused variables, loop counters while does not change as expected, unnecessary edge case checkings, boundaries index overflow/underflow 
       2. review the problem description, check whether there are unhandled problem assumptions
       3. use small test cases to test different logical branches of the code
     * When there is a bug: do not rush to change. Identify the root cause first.
       * "***Give me a moment, I feel there is a bug here. Let's have a double check.***"
       * "***The root cause of the problem is XXX.***"
  3. Explain shortcuts I have taken: Talk about sections which could be refactored/improved, but was done in a certain way in an interview setting
     * "***If I were writing this for a production use, I would avoid using this global variable.***"
  4. Synchronize with interviewer: "***I think I am done with the problem***".

### Questions to confirm about input <a id="questions-to-confirm-about-input"></a>
#### Field types<a id="question-field-type"></a>
* integer or double
* positive or negative, non-positive or non-negative

#### Array<a id="question-array"></a>
* sorted or unsorted
* given two arrays, which one's size is bigger
* whether could modify entries inside array

#### LinkedList<a id="question-linkedlist"></a>
* doubly or singly linkedlist

#### Binary search<a id="question-binary-search"></a>
* return boolean or specific result
* whether duplicates exist inside array

#### String<a id="question-string"></a>
* whether the string contains space
* how are tokens separated, using comma, slash or something else

#### Tree<a id="question-tree"></a>
* whether binary search tree

#### Graph<a id="question-graph"></a>
* directed or undirected

### Questions to confirm about output <a id="questions-to-confirm-about-output"></a>
#### List of List
* any order requirements on internal list
* should duplicates be removed

### Typical follow-up questions <a id="questions-follow-up"></a>
* no duplicates -> duplicates exist
* judge whether result exist -> return all results
* one dimension -> two dimension
* how to avoid global variables

### Learned lessons: Java basics <a id="learned-lessons-java-basics"></a>
#### Type size<a id="basics-type-size"></a>
* Reference types: 32-bit system (32 bit), 64-bit system (64 bit)
* Primitive types: boolean (8 bit), byte (8 bit), char (16 bit), short (16 bit), int (32 bit), long (64 bit), float (32 bit), double (64 bit)

#### Error-prone APIs<a id="basics-error-prone-apis"></a>
* Java list remove interface. Two list.remove() interface ( list.remove(int index), list.remove( Object object ) )
    - List<Integer> input
    - list.remove(index) will always take precedence because it does not require type casting
* Ternary operator ?: priority is only higher than assignment. If it is used in combination with other operators, parentheses should be added.
* Generate a random number
```java
Random rand = new Random();
int n = rand.nextInt( 50 ) + 1; // 1 ~ 50, specified number is exclusive
```

#### Data structure important APIs<a id="basics-rarely-mentioned-apis"></a>
* String
  - StringTokenizer ( like an iterator, has built-in hasNext() and next() func ). Could be used instead of a global position pointer inside recursive function (e.g. tree serialization and deserialization)
```java
String str = "This is String , split by StringTokenizer, created by mkyong";
StringTokenizer st = new StringTokenizer( str, "," );
while (st.hasMoreElements()) 
{
    System.out.println(st.nextElement());
}
```
  - String[] split( String regex )
```java
String string = "004-034556";
String[] parts = string.split("-");
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556
```
  - Parsing integer from a string. When possible, use Java's built-in function Integer Integer.ValueOf(String) or int Integer.ParseInt(String) instead of doing it manually
* Array
  - Print arrays in Java
```java
int[] array1D = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
int[][] array2D = { { 1, 2 }, {2, 5}, {3, 7} };
System.out.println( Arrays.toString( array1D ) );
System.out.println( Arrays.deepToString( array2D ));
```
* LinkedList
  - list.sublist(startIndex, endIndex) returns a sublist of List
  - LinkedList.addFirst(element: Object)/addLast(element: Object)/getFirst()/getLast()/removeFirst()/removeLast(). This could be used in backtracking.
* Queue
  - peek() vs element(), poll() vs remove(), add() vs offer(): when queue is empty, the former returns null and the latter throws exception. Most times in an interview setting, use the former one is appropriate. The first reason is that it is not an exceptional case that the queue is empty. The second reason is that throwsing exceptions incurs a performance penalty.
```java
// implements inside abstractQueue<E>
public E remove()
{
  E x = poll();
  if ( x != null )
  {
    return x;
  }
  else
  {
    throw new NoSuchElementException();
  }
}
```
* Set
  - set.add(elem) return false if set already contains the elem. 
* Map
  - frequency count with hashmap
```java
map.put( key, 1 + map.getOrDefault( key, 0 ) );
```
* put if not exist
```java
map.putIfAbsent( key, new ArrayList<>() );
```
* Collections
  - Collections.unmodifiableList/unmodifiableSet/unmodifiableMap()
  - Collections.reverse(List<?>) reverses a linkedlist

#### Math<a id="basics-math"></a>
* divide two integers ( useful names: dividend/numerator, divisor/denominator, quotient, residue )
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
* mod
        - judge whether a value is even or odd
            + Use num % 2 != 0 rather than num % 2 == 1 because of negative number mod ( e.g. -5 % 2 == -1 )
            + To guarantee mod result is always positive, if knowing num range RANGE, could consider ( num + RANGE ) % RANGE 
* power of integer: Java does not provide a built-in function for Integer values
        - solution 1: It has a built-in function double Math.pow( double, double ). But the computation cost for double is much higher than int and the result needs to be downcasted.
        - solution 2: Use multiply instead when exponent is low. 
        - solution 3: When 2 is radix, use bit shifting
        - solution 4: Implement in-house pow for integers based on divide and conquer
```java
// convert int decimal to binary format
int decimalNum = RANDOM_VALUE;
int[] binaryRepr = new int[32]; // for simplicity, binary format as an array
for ( int i = 0; i < 32; i++ )
{
    binaryRepr[i] = ( decimalNum >> i ) & 1;
}

// convert int binary to decimal format
int[] binaryRepr = new int[32];
int decimalNum = 0;
for ( int i = 0; i < 32; i++ )
{
    decimalNum |= ( binaryRepr[i] << i );
}
```

#### Type conversions<a id="basics-type-conversions"></a>
* Convert char to int, does not need explicit conversion
```java
value = value * 10 +  s.charAt( currPos ) - '0' ; 
```

* Convert string to int
```java
String str = "-2";
int intValue = Integer.parseInt( str );
```

* Convert reference type of list to array, 
```java
List<Integer> list = ...; // {1,2,3}
Integer[] array = new Integer[list.size()];
list.toArray( array );
```

* Convert reference type of array to list, the returned arrayList is based on the array of fixed size. When new item is added, exception will be thrown out.
```java
Element[] array = { new Element(1), new Element(2), new Element(3) };

// wrong way
List<Element> list = Arrays.asList( array );
list.add(1); // UnsupportedOperationException

// correct way
List<Element> list = new ArrayList<>( Arrays.asList( array ) );
```


* Convert between collection types - stream apis Collectors
```java
// hashmap keys to list
Map<String, List<String>> map = new HashMap<>();
List<String> list = map.keySet().stream().collect(Collectors.toList() );
```

#### Iterator<a id="basics-iterator"></a>
* ListIterator vs iterator: additional interface for 
  * iterating bidirectional
  * remove elements while iterating
* iterator vs for-each loop: remove elements while iterating/avoid ConcurrentModificationException
```java
List<Integer> list = ...; // 1, 2, 3, 4
Iterator<Integer> iterator = list.iterator();
while ( iterator.hasNext() )
{
    if ( iterator.next() == 3 )
    {
        iterator.remove()
    }
}
// list 1, 2, 4
```

#### Error handling<a id="error-handling"></a>
* Types
  * logs (handle errors later, first restart)
  * assertions (internal use only, function arguments)
  * dialogue (let user decides what to do next)
  * exception - checked/unchecked(point out what (exception type), where (exact location), why (message))
  * errors ( usually used by the JVM to indicate resource deficiencies )
* Use runtime exceptions to indicate precondition violations
  * IllegalArgumentException ( check input of function arguments )
  * IllegalStateException ( illegal state of variables )
  * ArithmeticException ( 1 / 0 )
  * IndexOutOfBoundaryException ( example problem: search in unknown size sorted array )

#### Collections internals<a id="basics-collection-internals"></a>
* deque/stack: linkedlist
* hashmap: chaining ( array + list )
  * compute array index based on **public int hashCode()** method
  * decide list index based on **public boolean equals()** method
* hashset: implemented based on hashmap with dummy values
* linkedhashmap: hashtable with a linkedlist
* treemap: red-black tree
* priorityqueue: array

### Learned lessons: data structures <a id="learned-lessons-datat-structures"></a>

#### Progressive enhancement on data structures <a id="prog-ds"></a>
* support accuracy: float/double -> BigDecimal
* support array resize: array -> arrayList
* support lookup/delete by key: priorityqueue -> treemap
* support enqueue/dequeue from both ends: queue -> deque
* support insertion -> customized order on hashset/hashmap: hashset/hashmap -> linkedhashset/linkedhashmap -> treeset/treemap
* support larger character set for histogram problem: array -> map
* support append/insert/delete more efficiently: string -> stringbuilder
* space efficiency in dynamic programming: 2D memorization array -> rolling 1D memorization array
* space efficiency in boolean array: Boolean[] -> boolean[] -> BitSet

#### Array <a id="ds-array"></a>

#### String <a id="ds-string"></a>

#### LinkedList <a id="ds-linkedlist"></a>
* When linked list is used in combination with counters inside a while loop, it is really error-prone because the programmer needs to increment two places inside each loop. For while loop, it is a better practice to use blank space to separate the three sections including preparing for next round loop, do job in this round loop and move to next round loop.
```java
    private ListNode reverseKNodes( ListNode head, int k )
    {
      ListNode dummyHead = new ListNode( 0 );
      ListNode currNode = head;
      int count = 0;
      while ( currNode != null 
          && count < k )
      {
        // prepare for next round loop
        ListNode dummyHeadNextBuffer = dummyHead.next;
        ListNode currNodeNextBuffer = currNode.next;
        
        // ... do job in  this round loop
        dummyHead.next = currNode;
        currNode.next = dummyHeadNextBuffer;
        
        // move to next round loop
        currNode = currNodeNextBuffer;
        count++;
      }
      return dummyHead.next;
    }
```
* Reverse list recursively, the key point here is record the reversed list tail before recursion
```java
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
```

#### Stack <a id="ds-stack"></a>
* When popping elements from stack, always check if the stack is empty. Otherwise, there might be a EmptyStackException()

#### Queue <a id="ds-queue"></a>

#### PriorityQueue <a id="ds-priorityqueue"></a>
* Built-in implementation remove() method for priorityqueue has O(n) time complexity.
  -  O(n) time is spent on looping through entire queue to find the element to be removed. O(logn) is used to remove the element
  -  But O(n) could be easily improved to O(logn) by adding an additional Map<T, Node> existingNodes. When Node has duplicate values, a counter could be added as Node class instance variable.

* Lambda expression inside PriorityQueue elements comparison
```java
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> mostFreqPrioQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
```

#### Tree <a id="ds-tree"></a>
* Tree iterative traversal with O(logn) space: preorder/inorder/postorder traversal
```java
class Pair
{
    TreeNode node;
    int type; // 0 for first time, 1 for second time
    public Pair( TreeNode node, int type )
    {
        this.node = node;
        this.type = type;
    }
}

/** 
 * @param order  0 preorder; 1 inorder; 2 postorder
*/
public void treeHighSpaceTraverse( TreeNode root, int order ) 
{
    Stack<Pair> stack = new Stack<>();
    stack.push( new Pair( root, 0 ) );
    while ( !stack.isEmpty() )
    {
        Pair stackTop = stack.pop();
        if ( stackTop.node == null )
        {
            continue;
        }
        if ( stackTop.type == 1 )
        {
            System.out.println(stackTop.node.value);
            continue;
        }
        switch ( order )
        {
            case 0:
                stack.push( new Pair( stackTop.node.rigth, 0 ) );
                stack.push( new Pair( stackTop.node.left, 0 ) );
                stack.push( new Pair( stackTop.node, 1 ) );
                break;
            case 1:
                stack.push( new Pair( stackTop.node.rigth, 0 ) );
                stack.push( new Pair( stackTop.node.left, 0 ) );
                stack.push( new Pair( stackTop.node, 1 ) );
                break;
            case 2:
                stack.push( new Pair( stackTop.node.rigth, 0 ) );
                stack.push( new Pair( stackTop.node.left, 0 ) );
                stack.push( new Pair( stackTop.node, 1 ) );
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

#### Binary search tree<a id="ds-binary-search-tree"></a>
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

#### HashMap <a id="ds-hashmap"></a>
* Use Double as hashmap keys is a bad practice. Especially if needing to perform calculations on double keys, the hash of double could mess up.
* Use Object as hashmap keys. When the hashCode() and equals(Object o) methods are not overriden by your class, the default implementation are used. The default behavior is to treat all objects as different, unless they are the same object. IdentityHashMap always does this by using reference-equality in place of object-equality
* HashMap.keySet().retainAll( Set ) computes intersection of two sets

#### TreeMap <a id="ds-treemap"></a>
* Get Key/Entry APIs: firstKey/firstEntry, lastKey/lastEntry, lowerKey/lowerEntry, higherKey/higherEntry, CeilingKey/CeilingEntry, floorKey/floorEntry
* Remove Key/Entry APIs: pollFirstEntry/pollLastEntry, remove
* Get Subset APIs: tailMap/headMap/subMap

#### Graph <a id="ds-graph"></a>
* Graph definition, there are multiple ways to define graphs in Java. To represent a sparse graph, one typical classical way is to define class GraphNode and then graph can be defined as List<GraphNode>. The other way is to define graph as Map<Integer, Set<Integer>> graph.
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
* **Count number of connected components in an undirected graph** with dfs + discovered set. 
* **Detect cycles inside undirected graph** with dfs + discovered set. 
* **Detect cycles inside directed graph** with dfs + visited set + discovered set.

#### Trie <a id="ds-trie"></a>
* Use cases: 
   * find prefix of string
   * traverse character by character
   * compared with hashmap: 
      * space complexity: when storing a list of words (Especially when these words share prefix), using trie save space. 
      * time complexity: to compute hashcode for a string, O(n) time complexity; find/insert a string in a trie, the same
   * but no built-in implementation in Java core
* Definitions: iterative implementation much more concise than recursive implementation.
```java
class TrieNode 
{
    private final static int CHARSET_SIZE = 26;
    public TrieNode[] children;
    public boolean isLeaf;
    public char val;
    
    // Initialize your data structure here.
    public TrieNode() 
    {
        children = new TrieNode[CHARSET_SIZE];
    }
    
    public TrieNode( char val )
    {
        this();
        this.val = val;
    }
}

public class TrieIterative
{
    private TrieNode root;

    public TrieIterative() 
    {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) 
    {
        TrieNode currNode = root;
        for ( int i = 0; i < word.length(); i++ )
        {
            int nextNodePos = (int)( word.charAt( i ) - 'a' );
            if ( currNode.children[nextNodePos] == null )
            {
                TrieNode node = new TrieNode( word.charAt( i ) );
                currNode.children[nextNodePos] = node;
            }
            currNode = currNode.children[nextNodePos];

            if ( i == word.length() - 1 )
            {
                currNode.isLeaf = true;
            }
        }
    }
    
    // Returns if the word is in the trie.
    public boolean search( String word )
    {
        TrieNode currNode = root;
        for ( int i = 0; i < word.length(); i++ )
        {
            int nextNodePos = (int)( word.charAt( i ) - 'a' );

            if ( currNode.children[nextNodePos] == null )
            {
                return false;
            }
            // prefix exists, but not word
            if ( i == word.length() - 1 
                && !currNode.children[nextNodePos].isLeaf )
            {
                return false;
            }                

            currNode = currNode.children[nextNodePos];
        }
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) 
    {
        TrieNode currNode = root;
        for ( int i = 0; i < prefix.length(); i++ )
        {
            int nextNodePos = (int)( prefix.charAt( i ) - 'a' );

            if ( currNode.children[nextNodePos] == null )
            {
                return false;
            }

            currNode = currNode.children[nextNodePos];
        }
        return true;        
    }    
}
```


### Learned lessons: algorithms <a id="learned-lessons-algorithms"></a>
#### Progressive enhancement on algorithms and data structures <a id="algorithms-progressive-enhancement-on-algorithms"></a>
* algorithms
  * brute force first
  * trade space for time: e.g. hashmap in two-sum
  * pre-process data: e.g. sorting
  * divide into subproblems: e.g. recursion, discuss by different conditions
  * save time by avoid solving repeated problems: e.g. recursion -> dynamic programming

#### Two pointers <a id="algorithms-two-pointer"></a>
##### Begin and end type <a id="algorithms-boundary-to-center"></a>
##### Slow and fast type <a id="algorithms-slow-and-fast"></a>
##### Window type <a id="algorithms-window"></a>
##### Two arrays type <a id="algorithms-two-arrays"></a>

#### Sort <a id="algorithms-sort"></a>
* Sort classification ( only for O(nlogn) and O(n) algorithms )

| Algorithm | memory    | Use case  | 
| --------------------- |:---------:| -----:|  
| Mergesort  | O(1)     | external sorting / stable |
| Quicksort  | O(n)     |  usually the quickest O(nlogn) / unstable sort |
| Heapsort   | O(1)     |  unstable sort |
| Bucketsort | O(1)     |  when knowing range and faster (non-comparison) |

* Judge whether intervals overlap
```java
private boolean isOverlap( Interval o1, Interval o2 )
{
    return !( o1.start >= o2.end 
            || o2.start >= o1.end );
}
```
* Arrays.sort( array, comparator ) and Collections.sort( collection, comparator ) method
* Partition algorithm used in quick sort O(n)
```java
// int[] input, int left, int right
    int pivotValue = input[(left+right)/2];
    while(i >= j)
    {
          while(input[i] < pivotValue)
          {
              i++;
          }
          while(input[j] > pivotValue)
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
 
#### Binary search <a id="algorithms-binary-search"></a>
* Universal templates - iterative/recursive version 
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
    // take result from start/end/non-exist
    // sometimes need to compare target directly to array[end], array[start]
    // sometimes need to see where target falls e.g. [~, array[start]), [array[start], array[end]), [array[end], ~)
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

* convert a range of binary search problem into variants of essence form
    - find first element smaller than target
        - e.g. find minimum element in rotated sorted array ( target: array[array.length-1])
    - find last element smaller than target
        - e.g. search insertion position
* how to handle duplicates in binary search


#### Recursive functions <a id="algorithms-recursion"></a>
* How to remove duplicates (avoid duplicate recursion beforehand or use hashset afterwards)

* Time complexity:

| Recurrence | Algorithm           | Big-O Solution  |
| --------------------- |:-------------:| -----:|
| T(n) = T(n/2) + O(1)  | Binary search | O(lgn) |
| T(n) = T(n-1) + O(1)  | Sequential search      |   O(n) |
| T(n) = 2T(n/2) + O(1) | Tree traversal      |  O(n) |
| T(n) = 2T(n/2) + O(n) | Merge sort      |    O(nlogn) |
| T(n) = T(n-1) + O(n)  | Selection sort      |  O(n^2) |

* How to return multiple results from recursive functions
  - not use return value: use global variable. 
    + The first is to use private instance variables to store results
    + The second is to use a mutable argument of type ( int[], List<> ). Modify the value of this argument while travering.
  - use return value
    + If multiple results are of same type, define return type as an array T[]
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
// 2.2. define a result wrapper class as class inner class
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

* How to avoid recomputation inside recursive function - memorize already computed searched results
  - use hashmap (example problems include House Robber III, Clone Graph)
  - use dynamic programming (see dynamic programming section for details) 
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

#### Backtrack <a id="algorithms-backtrack"></a>
* usually occurs at the beginning and ending of a recursive function
```java
public void recursivefunction()
{
    backtracking forward
    // ... other stuff
    backtracking backwards
}
```
* remove duplicates inside result
* mark visited locations inside a 2D grid
  * use set<Integer> to store position hash (x * width + height)
  * if could modify the grid, place special char such as '#' for already discovered nodes

#### Graph <a id="algorithms-graph"></a>
##### Grid-based graph patterns <a id="algorithms-grid"></a>
* How to store coordinates: 
   * A customized class Coor
   * If allowing to modify grid, could temporarily place special chars/values to indicate that this position has been visited before. Depending on whether input int grid[][] is a defensive copy, we could decide whether to recover the grid[][] by replacing previously set special chars/values.
* How to track visited coordinates:
   * There are four possible approaches here: 
      * Preferred approach: The first is to use a two-dimensional boolean[][] array. true as visited and false as not visited.
      * The second is to use ( x * grid_width + y ) as Coor hash and put them in a Set<Integer> visited. Integer might overflow but should be enough in an interview setting.
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

##### Breath first search <a id="algorithms-bfs"></a>
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
    // loop through curr level
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
  
##### Depth first search <a id="algorithms-dfs"></a>
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

##### Topological sort <a id="algorithms-topo"></a>
* There are basically two categories of methods for topological sort. The first one is greedy algorithm with O(|V|^2 + |E|) time complexity. The second is based on depth first search with O(|V| + |E|) time complexity. Here only discusses DFS based approach. 
* When using DFS based approach, there are two cases which should be taken care of. The first one is what if there exists no topological order at all. The second is how to return topological order.
   * what if there exists no topological order - a cycle is detected. 
      * How to detect cycle: use UNDISCOVERED, DISCOVERED, VISITED to represent three possible states of graph nodes. Use a Set<?> isDiscovered and Set<?> isVisited to record all history info. If met up with a node which has been discovered but not visited, then a cycle is detected. 
      * How to handle cycle: return a boolean value (preferred) or throw an exception (not really suitable because they are expected cases)
   * what if need to return topological order
      * If do not need to detect cycle, could simply use a Stack<> order to record the visited node, namely using Set<?> discovered, Stack<?> visited 
      * If need to detect cycle, namely using Set<?> discovered, LinkedHashSet<?> visited
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

##### Union find <a id="algorithms-union-find"></a>
* Suitable in a dynamically changing graph. Example problems: Number of Island II, find weakly connected components in directed graph, find connected components in undirected graph

#### Dynamic-programming <a id="algorithms-dynamic-programming"></a>

* Rebuild the results from memorization array
* One dimension <a id="dynamic-programming-1d"></a>
* Two dimension <a id="dynamic-programming-2d"></a>
* Memorization <a id="dynamic-programming-memo"></a>
* Game <a id="dynamic-programming-game"></a>
* when allocate dynamic programming table size, allocate additional one row/col for generalization


### Edge case tests <a id="edge-case-tests"></a>
* Single element 2D grid
* Integer.MIN_VALUE, Integer.MAX_VALUE
* LinkedList: single node, even node, odd node, pointer pointing to null
* Tree: single node tree, flattened tree, normal tree, complete tree
* While loop: flow control counters

### Bad smells for refactoring and optimization <a id="bad-smells"></a>
* code length > 100
* too many if statement checking for boundary cases
* code do not generalize well. Only work for current problem. e.g. merge 2 sorted list -> merge k sorted List
* too deep nesting due to if/else blocks

### Sins <a id="sins"></a>
#### Java sins <a id="sins-java"></a>
* linkedhashset could not be iterated reversely
* hard to return tuple values
* only pass by values
* lambda expressions are still not closures

#### Whiteboard coding sins <a id="sins-whiteboard-coding"></a>
* whiteboard coding does not simulate daily workflow of software engineers, thus might generate high false positives and false negatives. 
  * finish algorithms in 20 min in a bug-free and clean way requires lots of practice. It does not only require interviewee to understand algorithms and data structures, but also really proficient in these, sometimes even remember pretty tricky test cases. 
  * the optimization process in algorithm questions is over-optimization. In practice, only improve performance when necessary.
  * stand and write code on whiteboard is really exhausting if lasting for 4-5 hours.

#### Leetcode sins <a id="sins-leetcode"></a>
* When problem occurs, too few stack trace
* No online debuggers
* No history track along time axis. Really bad synchronous workflow
* Assumptions about validity of input. They usually do not appear in interview settings
* Unable to mark different stages in solving a problem ( e.g. thought-out, implemented, optimized, on-line judged, summarized )
* Cannot add enough comments along the code
* Never-ending, ever-increasing number of problems
* Time exceed limit exception sometimes dependes on Leetcode.org machine status
* Could not search problems by specifying multiple tags

#### References
* Core Java Interview questions: [blog: java-success.com](http://www.java-success.com/)
* Coding and system design [blog: massive tech interview](http://massivetechinterview.blogspot.com/)