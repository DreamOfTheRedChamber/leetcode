# loop through leetcode one more time, ; )
* [Typical whiteboard coding workflow](#whiteboard-workflow)
    * [Clarify questions](#whiteboard-workflow-clarify)
    * [Give a small but general enough example for discussing algo/DS](#whiteboard-workflow-context)
    * [Come up with a brute force algorithm with an example](#whiteboard-workflow-bruteforce)
    * [Come up with an optimized solution](#whiteboard-workflow-optimize)
    * [Write test cases](#whiteboard-workflow-test-cases)
    * [Write code](#whiteboard-workflow-write-code)
    * [Walk through a test case](#whtieboard-workflow-walk-test-cases)
    * [Solve follow up questions](#whiteboard-workflow-follow-up)
* [Interview mindset](#strategy)
    * [Understanding what interviewers really wants](#undertand-interviewers)
    * [When met with easy/hard/tricky problems](#met-with-easy-hard-tricky-problems)
    * [Whiteboard coding pros and cons](#whiteboard-coding-pros-cons)
* [Practice mindset](#practice-patterns)
    * [Attitudes](#practice-attitudes)
    * [Tools](#practice-tools)
    * [Habits](#practice-habits)
    * [Leetcode pros and cons](#leetcode-pros-cons)
    * [Java pros and cons](#java-pros-cons)
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
    * [Bit manipulation](#algorithms-bit-manipulation)
    * [Two pointers](#algorithms-two-pointer)
       * [Begin and end type](#algorithms-boundary-to-center)
       * [Slow and fast type](#algorithms-slow-and-fast)
       * [Window type](#algorithms-window)
       * [Two arrays type](#algorithms-two-arrays)
    * [Sort](#algorithms-sort)
    * [Binary search](#algorithms-binary-search) 
    * [Recursion](#algorithms-recursive)
      - [Time complexity](#algorithms-recursive-tc)
      - [Problems to consider](#algorithms-recursion-problems-to-consider)
      - [How to return multiple results](#algorithms-recursion-return-multiple-results)
      - [How to avoid repeated recursion](#algorithms-recursion-repeated)
      - [Tree-based recursion](#algorithms-recursion-tree-based)
    * [Backtrack](#algorithms-backtrack)
    * [Graph](#algorithms-graph)
       * [Grid-based graph patterns](#algorithms-grid)
       * [Breath first search](#algorithms-bfs)
       * [Depth first search](#algorithms-dfs)
       * [Topological sort](#algorithms-topo)
       * [Union find](#algorithms-union-find)
    * [Greedy](#algorithms-greedy)
    * [Dynamic programming](#algorithms-dynamic-programming)
      - [Use cases](#algorithms-dp-use-cases)
      - [Problems to consider](#algorithms-dp-problems-to-consider)
      - [Implementation methods](#algorithms-dp-implementation-methods)
      - [Memorization array tricks](#algorithms-dp-memorization-array-tricks)
      - [Types](#algorithms-dp-types)
        + [Coordinate based](#algorithms-dp-types-coordinate)
        + [1D sequence](#algorithms-dp-1d-sequence)
        + [2D sequences](#algorithms-dp-2d-sequences)
        + [Range based](#algorithms-dp-range-based)
        + [Game](#algorithms-dp-game)
        + [Backpack](#algorithms-dp-backpack)
* [References](#references)
  
### Typical whiteboard coding workflow <a id="whiteboard-workflow"></a>

#### Clarify question <a id="whiteboard-workflow-clarify"></a>
1. Define public APIs to be implemented:
   * Things to define - Input type
   * Things to define - Number of input arguments
   * Things to define - Output type
     * Different levels of solutions
       * boolean: Whether solutions exist or not
       * int: the number of solutions
       * List&lt;?> : solutions themselves
       * List&lt;?>: solutions without duplicates
       * List&lt;?>: solutions with specific order
     
2. Clarify ambiguous problem statements / Gather all requirements
   * Solution existence: "***What if no solution exists? How should I handle that?***"
   * Solution uniqueness: "***Whether there are multiple solutions?***"
   * Input emptiness: "***How should I handle null pointers and input of size zero?***"
   * Input validity: "***Could I assume input is always invalid?***" 
   * Input types:
      * Typical scenarios
        * In most cases, one single public API
        * Multiple public APIs inside a class
        * Two associated APIs, like serialize and deserialize
      * Input - Field types<a id="question-field-type"></a>
         * Integer or double
         * Positive or negative, non-positive or non-negative
      * Input - Array<a id="question-array"></a>
         * Sorted or unsorted
         * Given two arrays, which one's size is bigger
         * Whether could modify entries inside array
      * Input - String<a id="question-string"></a>
         * Whether the string contains space
         * How are tokens separated, using comma, slash or something else
         * What characters are contained in the string, only english letters, or ascii characters   
      * Input - LinkedList<a id="question-linkedlist"></a>
         * Doubly or singly linkedlist
      * Input - Tree<a id="question-tree"></a>
         * Binary tree
         * Binary search tree
         * Complete tree
      * Input - Graph<a id="question-graph"></a>
         * Directed or undirected
         * Weighted or not
         * Connected or not
   * Problem types:
      * Sort
        * Stable or not
        * External or internal
        * Input almost sorted or not
        * Input range
      * Search
        * Whether duplicate entries exist
   * Edge cases: "***If input is like this, then what should I output?***"

#### Give a small but general enough example for discussing algo/DS <a id="whiteboard-workflow-context"></a>
* Usually a size of 4~5 is enough.

#### Come up with a brute force algorithm <a id="whiteboard-workflow-bruteforce"></a>
1. Synchronize with interviewer "***Let's come up with a brute force solution first.***"
2. Unstuck strategy:
   1. The most straightforward way to list all possible solutions
   2. Whether I could decompose the problem into subproblems and solve them individually
      * Divide and conquer "***The problem could be decomposed into X subproblems.***"
   3. Brainstorm DS/Algo which might be used / Give it a try
      * Give it a try: "***Let's try a graph-based solution***"
3. Calc time/space complexity: "***The time complexity of the algorithm is O(XXX) and space complexity is O(XXX)***"

#### Optimize the brute force solution <a id="whiteboard-workflow-optimize"></a>
1. Synchronize with interviewer "***The time/space complexity of the brute force solution is too high and will be impractical.***"
2. Consider the typical optimizing patterns below:
   1. Where the bottleneck is: "***The bottleneck of the algorithm lies in this section of code***"
   2. What the time complexity upper bound is: "***Theoretically, the best time complexity I could achieve is O(n) because I need to look through all items.***"
   3. Whether space complexity is acceptable or not: "***Algorithms with linear space complexity is usually acceptable.***"
   4. Repetitive computation: "***We solve a lot of repetitive problems. If we could cache the solutions, it will be much more efficient.***"
   5. Additional rounds of iterating input: "***We iterate through input twice. If we could reduce it to once, it will boost performance twice.***"
3. Synchronize with interviewer "***The reason we could do better is XXX***."
4. Ask for help when being stuck
   1. Show interviewer all the approaches you tried and difficulties. ""
   2. Be keen to what interviewer is saying: Every word the interviewer is saying has its meanings. ""
5. Synchronize with interviewer "***Do you have any concerns for the proposed algorithm? Should we write code for this***."

#### Write test cases <a id="whiteboard-workflow-test-cases"></a>
* In general, the following types of test cases should be considered 
   * The normal case: e.g. array length of even or odd in sorting algorithms
   * The extremes: e.g. empty array, one element array, extremely large one array
   * Nulls and "illegal" input: e.g. input is negative when positive is expected 
   * Strange input: an array already sorted
* Typical test cases for different input types
   * Integer
      * Integer.MAX_VALUE, Integer.MIN_VALUE
      * 0
      * Positive/negative numbers
   * String
      * NULL
      * Single character
      * Two characters
      * Contains duplicated characters
      * Contains space, tab or other separators
   * Array/List &lt;?> list
      * NULL
      * One element List/Array
      * List/Array entry is NULL
      * List/Array of even length
      * List/Array of odd length
   * Topological sort
     * Cycle exist or not

#### Write code <a id="whiteboard-workflow-write-code"></a>
  1. Synchronize with interviewer "***There are XXX steps in this algorithm. The first is XXX. The second....***"
  2. Check input validity (already discussed thoroughly before)
  3. Use // or empty line to separate different steps and a place to synchronize with interviewer.
  4. Just get the general algorithm down first and avoid getting caught up in trivialities
     * When forget some language-specific trivial
       * "***I do not remember exactly how the interface looks like, but I'd guess it has an API like this.***"
     * When need implement a large code block, or nested for/while loop, or repeated needed util methods, consider using a subroutine
       * "***I am going to use a subroutine with the following interface. I will implement later***".
     * When need double check trivials (like +1 or plus two, loop termination conditions ): 
       * "***Not sure whether my loop should have "<" or "<=". Write a checkmark to remind yourself to figure out the details at the end.***""

#### Walk through test cases <a id="whtieboard-workflow-walk-test-cases)"></a>
  1. Synchronize with interviewer: "***Then I would usually check my code against tests***" 
  2. Check the code by myself
     * Check steps:
       1. Review the entire code, check whether there are unused variables, loop counters while does not change as expected, unnecessary edge case checkings, boundaries index overflow/underflow 
       2. Review the problem description, check whether there are unhandled problem assumptions
       3. Use small test cases to test different logical branches of the code
     * When there is a bug: do not rush to change. Identify the root cause first.
       * "***Give me a moment, I feel there is a bug here. Let's have a double check.***"
       * "***The root cause of the problem is XXX.***"
  3. Explain shortcuts I have taken: Talk about sections which could be refactored/improved, but was done in a certain way in an interview setting
     * Bad smells for refactoring and optimization <a id="bad-smells"></a>
       * Code/function length > 100
       * Too many if statement checking for boundary cases
       * Code do not generalize well. Only work for current problem. e.g. merge 2 sorted list -> merge k sorted List
       * Nested while loops ( really error prone )
       * Global variables
  4. Synchronize with interviewer: "***I think I am done with the problem***".

#### Solve follow up questions <a id="whiteboard-workflow-follow-up"></a>
* Typical follow-up questions
    * No duplicates -> duplicates exist
    * Whether result exist -> return all results
    * One dimension -> two dimension
    * How to avoid global variables
    * How to improve performance

### Interview mindset <a id="core-strategies"></a>
#### Understanding what interviewers really wants <a id="#undertand-interviewers"></a>
* Evaluation criteria
  - Is s/he a good coder?
  - Can s/he explain technical solutions well?
  - Does s/he understand basic concepts well?
  - Does s/he has a good grasp of past project experiences?
  - How is his/her attitude?
* What are interviewers really asking

| What they ask | Wrong response    | What they really want  |
| --------------------- |:---------:| -----:|  
| Tell me what you did for this project  | <ul><li>Describe the process in chronological order</li><li>Recites what's on their resume</li></ul>  | <ul><li>What are you able to do after completing this project4</li><li>How did you overcome obstacles</li><li>Details that are not on your resume</li></ul> |
| Tell me what you did for this job  | <ul><li>Describe major projects</li><li>Describe daily tasks</li></ul>  |  <ul><li>Were you able to learn quickly</li><li>Did you add enough value at your previous job to prove that you can add value for me</li></ul> |
| Compare data structure A and B  | <ul><li>Explain what A and B are respectively</li><li>List 1 difference between them</li></ul>     |  <ul><li>Does your explanation show that you have actually used them in a real project</li><li>Explain real situations where you would use A vs B.</li></ul> |
| Write code to solve problem | <ul><li>Jumps into writing code</li><li>Awkward silence</li></ul>     | <ul><li>Would I want to work with them everyday</li><li>Have they actually written production grade code</li><li>What do they do when stuck</li></ul> |
| Maybe you could try this ... | <ul><li>Take advice without serious thinking</li></ul>  | <ul><li>Do they think independently</li><li>How fast can they absord new information</li><li>Do they take advice/directions well</li><li>Do they learn quickly and run with it</li></ul> |

#### When met with easy/hard/tricky problems (although most time medium problems): <a id="met-with-easy-hard-tricky-problems"></a>
* Always smile no matter how easy/hard/tricky the problem is, ;)
* For easy problems,
  * Although interviewer says "I will only give you an easy question". Every interviewing question has its purpose. It might be the corner case, coding style or communication. 
  * There might be some follow-up questions. The easy problem is just for warming up.
* For problems I have seen before, 
  * Notice that the assumption might have been changed. 
  * Still need to walk through the entire thought process instead of jumping to the right answer directly.
* For hard problems,
  * It is not really practical to finish a tricky problems in a 45 minutes setting from scratch perfectly. 
    * Talk with interviewers about my thoughts before implementing.
    * Outline the code skeleton before implement every detail.

#### Whiteboard coding pros and cons <a id="whiteboard-coding-pros-cons"></a>
* Pros
  * Every software engineer knows algorithms and data structures. It provides a common domain for interviewers and interviewees to discuss.
  * Smart people will always be smart wherever they go. There are just too many candidates there and there needs a way to differentiate it. At least, whiteboard coding could reflect candidates' understanding of algorithms/data structures and communication skills.
  * Whiteboard coding advocates a good workflow for developing code.
* Cons
  * The most important capability for a software engineer is abstraction and skipping complexity. Algorithms questions are usually available in many online forums. Even if candidates could finish the problem in interview, it does not necessarily demonstrate the core perspective here. It might generate high false positives and false negatives. 
  * Finish algorithms in 20 min in a bug-free and clean way requires lots of practice. It does not only require interviewee to understand algorithms and data structures, but also really proficient in these, sometimes even remember pretty tricky test cases. 
  * The optimization process in algorithm questions is kind of over-optimization. In practice, only improve performance when necessary.
  * Stand and write code on whiteboard is really exhausting if lasting for 4-5 hours.

### Practice mindset <a id="practice-patterns"></a>
#### Attitudes <a id="practice-attitudes"></a>
  * This might be the last time in my life that I spent so much time and efforts in algorithm questions. Next time when I hunt for jobs, either HRs will invite me or I will have far less time to prepare.
  * The way an engineer approach a algorithm problem can reflect their efficiency at work. Davinci starts from drawing eggs.
  
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

#### Leetcode pros and cons <a id="leetcode-pros-cons"></a>
* Pros
  * Latest interview questions
  * Large pool of different question types
* Cons
  * Testing
    * Input is always valid. 
    * Time exceed limit is too constraint. Sometimes we want to start from inefficient algorithms, verify its correctness and then optimize performance.
  * Debug
    * When problem occurs, too few stack trace
    * No online debuggers
  * Usability
    * No history track along time axis. Really bad synchronous workflow
    * Unable to mark different stages in solving a problem ( e.g. thought-out, implemented, optimized, on-line judged, summarized )
    * Cannot add enough comments along the code
    * Could not search problems by specifying multiple tags
    * Function names do not follow best practices, which makes variables naming kind of difficult.

#### Java pros and cons <a id="java-pros-cons"></a>
* Pros
  * Readability
* Cons
  * A bit verbose: heavy to return tuple values
  * Only pass by values
  * Lambda expressions are still not closures
  * Linkedhashset could not be iterated reversely


### Learned lessons: Java basics <a id="learned-lessons-java-basics"></a>
#### Type size<a id="basics-type-size"></a>
* Reference types: 32-bit system (32 bit), 64-bit system (64 bit)
* Primitive types: boolean (8 bit), byte (8 bit), char (16 bit), short (16 bit), int (32 bit), long (64 bit), float (32 bit), double (64 bit)

#### Error-prone APIs<a id="basics-error-prone-apis"></a>
* Java list remove interface. Two list.remove() interface ( list.remove(int index), list.remove( Object object ) )
    - List&lt;Integer&gt; input
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
  - Collections.reverse(List&lt;?&gt;) reverses a linkedlist

#### Math<a id="basics-math"></a>
* Mod
        - judge whether a value is even or odd
            + Use num % 2 != 0 rather than num % 2 == 1 because of negative number mod ( e.g. -5 % 2 == -1 )
            + To guarantee mod result is always positive, if knowing num range RANGE, could consider ( num + RANGE ) % RANGE 
* Power of integer: Java does not provide a built-in function for Integer values
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
* Prime 
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
* support insertion -> customized order on hashset/hashmap: hashset/hashmap -> linkedhashset/linkedhashmap -> binary search tree (treeset/treemap)
* support larger character set for histogram problem: array -> map
* support append/insert/delete more efficiently: string -> stringbuilder
* space efficiency in dynamic programming: 2D memorization array -> rolling 1D memorization array
* space efficiency in boolean array: Boolean[] -> boolean[] -> BitSet

#### Array <a id="ds-array"></a>
* Common techniques used in circular arrays
  - double the array to 2n by concatenating original array to the end and then apply a sliding window of size n on it (whether is a sorted rotated array)
  - invert the sign of the array (circular array maximum sum)
  - break the circle (house robber II)

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

#### String <a id="ds-string"></a>
* Only alphabetic characters, ascii characters, or any characters

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
  -  But O(n) could be easily improved to O(logn) by adding an additional Map&lt;T, Node&gt; existingNodes. When Node has duplicate values, a counter could be added as Node class instance variable.

* Lambda expression inside PriorityQueue elements comparison
```java
PriorityQueue<NumAndFreq> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
```

* Top K problems

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
* NAray-tree serialization and deserialization
  - There are two popular ways to serialize a N-Aray tree: preorder and level-order. Preorder leads to a natural recursive implementation. Level-order leads to a natural iterative implementation. 
```java
/*
public class NArayNode
{
  public int value;
  public List<NArayNode> children;
  public NArayNode( int value )
  {
    this.value = value;
    children = new LinkedList<>();
  }
  public void addChild( NArayNode node )
  {
    children.add( node );
  }
}
*/

// level order serialization and deserialization
  public String serialize( NArayNode root )
  {
    if ( root == null )
    {
      return "";
    }
    
    StringBuilder result = new StringBuilder();
    Queue<NArayNode> bfsQueue = new LinkedList<>();
    result.append( root.value );
    result.append( ',' );
    bfsQueue.offer( root );
    while ( !bfsQueue.isEmpty( ) )
    {
      NArayNode qHead = bfsQueue.poll( );
      for ( NArayNode childNode : qHead.children )
      {     
        result.append( childNode.value );
        result.append( ',' );
        bfsQueue.offer( childNode );
      }
      result.append( ')' );
      result.append( ',' );
    }
    return result.toString( );
  }
  
  public NArayNode deserialize( String input )
  {
    if ( input == null )
    {
      return null;
    }
    
    String[] tokens = input.split( "," );   
    Queue<NArayNode> bfsQueue = new LinkedList<>();
    NArayNode root = new NArayNode( Integer.parseInt( tokens[0] ) );
    bfsQueue.offer( root );
    
    int index = 1;
    while ( !bfsQueue.isEmpty( ) )      
    {
      NArayNode qHead = bfsQueue.poll( );
      while ( index < tokens.length && !tokens[index].equals( ")" ) )
      {
        NArayNode newNode = new NArayNode( Integer.parseInt( tokens[index] ) );
        qHead.addChild( newNode );
        bfsQueue.offer( newNode );
        index++;
      }
      index++;
    }
    
    return root;
  }
```

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

#### Binary search tree<a id="ds-binary-search-tree"></a>
* Used to store a collection of items in sorted form
* The definition of BST is left <= middle < right. Pay attention to the equals sign.
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
* A popular use case for hashmap in interview is frequency counting, namely histogram. Based on this, it is usually required to output the histogram in desending order. A straightforward approach is to use TreeMap for frequency calculating. But this will result in O(mlogn + nlogn) complexity, where m is the number of input and n is the number of distinct input. A more efficient approach is to use HashMap + PriorityQueue
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

#### TreeMap <a id="ds-treemap"></a>
* Get Key/Entry APIs: firstKey/firstEntry, lastKey/lastEntry, lowerKey/lowerEntry, higherKey/higherEntry, CeilingKey/CeilingEntry, floorKey/floorEntry
* Remove Key/Entry APIs: pollFirstEntry/pollLastEntry, remove
* Get Subset APIs: tailMap/headMap/subMap

#### Graph <a id="ds-graph"></a>
* Time complexity comparison between different graph representation

| Representation\Complexity | Delete a vertex | Delete an edge | Edge exists? | iterating vertex neighbors |
| --------------------- |:-------------:|:-------------:| -----:|-----:|
| Edge List  | O(E) | O(E) | O(E) | O(E) |
| Adjacent matrix  | O(V^2) | O(1) |  O(1) | O(V) |
| Adjacent List | O(E) | O(list length) | O(list length) | O(list length) |

* Use cases for different representations
  * Edge list is usually not used because looping through neighbor of a vertex is too expensive. This makes it really appropriate for many graph algorithms (bfs, dfs).
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
   * Find prefix of string
   * Traverse character by character
   * Compared with hashmap: 
      * Space complexity: when storing a list of words (Especially when these words share prefix), using trie save space. 
      * Time complexity: to compute hashcode for a string, O(n) time complexity; find/insert a string in a trie, the same
   * But no built-in implementation in Java core
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

#### Bit manipulation <a id="algorithms-bit-manipulation"></a>
* Arithmetic vs logic right shift
  * Arithmetic right shift >>, shift bits to the right but fill in the new bits with the value of the sign bit
  * Logic right shift >>>, shift bits to the right but fill in the new bits with 0.
* Common bit tasks: get bit, set bit, clear bit and update bit
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

#### Two pointers <a id="algorithms-two-pointer"></a>
##### Begin and end type <a id="algorithms-boundary-to-center"></a>
* Two sum type - avoid scanning redundant states
```java
if ( A[i] and A[j] satisfy some condition )
{
  j--; // do not need to consider pairs composed of [i+1, j-1] and j
  // do something
}
else if ( A[i] and A[j] do not satisfy some condition )
{
  i++; // do not need to consider pairs composed of [i+1, j-1] and i
  // do something
}
else
{
  // do something
  i++ or j--
}
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

##### Slow and fast type <a id="algorithms-slow-and-fast"></a>
* Find the middle of linked list
* Find linked list cycle

##### Window type <a id="algorithms-window"></a>
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

##### Two arrays type <a id="algorithms-two-arrays"></a>

#### Sort <a id="algorithms-sort"></a>
* Sort classification ( only for O(nlogn) and O(n) algorithms )

| Algorithm | memory    | Use case  | 
| --------------------- |:---------:| -----:|  
| Mergesort  | O(1)     | external sorting / stable |
| Quicksort  | O(n)     |  usually the quickest O(nlogn) / unstable sort |
| Heapsort   | O(1)     |  unstable sort |
| Bucketsort | O(1)     |  when knowing range and evenly distributed O(n+k) |

* Judge whether intervals overlap
```java
private boolean isOverlap( Interval o1, Interval o2 )
{
    return !( o1.start >= o2.end 
            || o2.start >= o1.end );
}
```
* Arrays.sort( array, comparator ) and Collections.sort( collection, comparator ) method
 
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

* Binary search variants:
  - Find first element smaller than target
      - e.g. find minimum element in rotated sorted array ( target: array[array.length-1])
  - Find last element smaller than target
      - e.g. search insertion position
  - Convert a range of binary search problem into variants of essence form

* Binary search in 2D matrix
* How to handle duplicates in binary search

#### Recursive functions <a id="algorithms-recursion"></a>
* Time complexity: <a id="algorithms-recursive-tc"></a>

| Recurrence | Algorithm           | Big-O Solution  |
| --------------------- |:-------------:| -----:|
| T(n) = T(n/2) + O(1)  | Binary search | O(lgn) |
| T(n) = T(n-1) + O(1)  | Sequential search      |   O(n) |
| T(n) = 2T(n/2) + O(1) | Tree traversal      |  O(n) |
| T(n) = 2T(n/2) + O(n) | Merge sort      |    O(nlogn) |
| T(n) = T(n-1) + O(n)  | Selection sort      |  O(n^2) |

* Recursive vs iterative solutions
  - Recursive algorithms can be very space inefficient. Each recursive call adds a new layer to the stack. If the algorithm recurses to a depth of n, it uses at least O(n) space.
  - All recursive algorithms can be implemented iteratively, although sometimes the code is more complex. 
  - Before diving into writing recursive code, ask myself how hard it would be to implement iteratively and discuss tradeoffs with your interviewer.

* Problems to consider: <a id="algorithms-recursion-problems-to-consider"></a>
  - What does the recursive function do?
    + Take what parameters
    + Do what
    + return what value and how
  - How does big problems recurse to smaller ones
  - Initialization
* How to return multiple results from recursive functions<a id="algorithms-recursion-return-multiple-results"></a>
  - Use global variable. 
    + The first is to use private instance variables to store results
    + The second is to use a mutable argument of type ( int[], List&lt;&gt; ). Modify the value of this argument while travering.
  - Use return value
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

* How to avoid repeated recursion - memorize already computed searched results <a id="algorithms-recursion-repeated"></a>
  - Use hashmap (example problems include House Robber III, Clone Graph)
  - Use dynamic programming (see dynamic programming section for details) 
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

* Tree-based recursion <a id="algorithms-recursion-tree-based"></a>
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
* Usually occurs at the beginning and ending of a recursive function
```java
public void recursivefunction()
{
    backtracking forward
    // ... other stuff
    backtracking backwards
}
```
* Avoid generating duplicate results by ensuring that the never two recursion tree branches overlap 
```java
if ( i > 0 && candidates[i] == candidates[i-1] )
{
  i++;
  continue;
}
// invoking functions based on index i
```
* Pruning

#### Graph <a id="algorithms-graph"></a>
##### Grid-based graph patterns <a id="algorithms-grid"></a>
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

##### Union find <a id="algorithms-union-find"></a>
* Suitable in a dynamically changing graph. Example problems: Number of Island II, find weakly connected components in directed graph, find connected components in undirected graph

#### Greedy <a id="algorithms-greedy"></a>
* Usually greedy algorithms are not covered in an interview setting:
  - Greedy algorithms do not generalize as a useful way to decompose and solve problems. 
  - Naive greedy algorithms are usually "short sighted" algorithms, which will not lead to global maximal. Working greedy algorithms are usually hard to think of. 

#### Dynamic-programming <a id="algorithms-dynamic-programming"></a>
* Use cases: <a id="algorithms-dp-use-cases"></a>
  - When to use - optimize time complexity from O(n!,2^n) to O(n^2, n^3)
    + Calculate max or min
    + Calculate the number of solutions
    + Calculate whether it is true or not
  - When not to use - optimize time complexity from O(n^3, n^2) further
    + Calculate concrete solutions themselves rather than just the number of solutions
    + Input is a collection rather than a sequence (e.g. Longest consecutive sequence)
* Problems to consider: <a id="algorithms-dp-problems-to-consider"></a>
  - State: how to define dp[i] or dp[i][j]
  - Induction rule: how to calculate big problems into smaller ones
  - Initialization: starting point
  - Answer: ending point
* Implementation methods: <a id="algorithms-dp-implementation-methods"></a>
  - Multi-loop: bottom-up approach
  - Memorized search: top-down approach
  - Use cases:
    + In most cases, both of them can be applied. Could start with bottom-up approach because it is usually more concise. 
    + But some times memorized search is more appropriate
      * When it is easier to start thinking from the last step rather than the first step. Example: Burst ballons, Stone-game (Lintcode)
      * When the induction rule is not sequential, thus hard to define.  Example: Longest increasing subsequences in 2D (Lintcode)
      * When the initialization state is hard to find. Example: Longest increasing subsequences in 2D (Lintcode)
* Memorization array tricks <a id="algorithms-dp-memorization-array-tricks"></a>
  - For non grid-based dynamic programming problems, for N number/character, array of size N+1 is allocated. The position at 0 index is used for specially used for initialization.
  - Rolling array
    + for 1D dp, e.g.
      * If induction rule is f[i] = max(f[i-1], f[i-2]) + A[i], namely f[i] only depends on f[i-1] and f[i-2]
      * To use rolling array, induction rule can be rewritten as f[i%2] = max(f[i-1]%2, f[i-2]%2)
    + for 2D dp, e.g.
      * if f[i][j] only depends on f[i][.], namely i th row only depends on i-1 th row
      * To use rolling array, induction rule can be rewritten as f[i%2][j] = f[(i-1)%2] row
    + procedures to use rolling array: write non-rolling version first, then write rolling version 
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

* Type: <a id="algorithms-dp-types"></a>
  - Coordinate based <a id="algorithms-dp-types-coordinate"></a>
    + Patterns:
      * state: f[x,y] represents goes to x,y position from starting point
      * induction rule: f[x,y] from f[x-1, y] or f[x, y-1]
      * initialization: f[0,0~width], f[0~height, 0]
      * answer: usually f[m,n]
    + Examples: Minimum Path Sum, Unique Path I�, Climbing stairs, Jump game I/II
  - 1D sequence <a id="algorithms-dp-1d-sequence"></a>
    + Patterns:
      * state: f[i] represents first i position, digits, characters
      * induction rule: f[i] from f[j], j < i
      * initialize: f[0] = 0, f[1]
      * answer: f[n]
    + Examples: Longest increasing subsequence, Word break I, House robber
  - 2D sequences <a id="algorithms-dp-2d-sequences"></a>
    + Patterns: 
      * state: f[i,j] represents the results of first i numbers/characters in sequence one matching the first j numbers/characters in sequence two
      * induction rule: how to decide f[i,j] from previous (varies a lot here)
      * initialize: f[0,i] and f[i,0]
      * answer: f[n,m] ( n = s1.length(), m = s2.length() )
    + Examples: Edit distance, Regular expression matching, Longest common subsequences, Maximal rectangle/Square
  - Range based <a id="algorithms-dp-range-based"></a>
    + Patterns:
      * state: f[i,j] represents whether the substring from i to j is a palindrome
      * induction rule: f[i,j] = f[i+1,j-1] && (s[i] == s[j])
      * initialize: f[i][i] = true, f[i][i+1] = s[i] == s[i+1]
      * answer: f[0,n]
    + Examples: Palindrome partition II, Coins in a line III (Lintcode), Stone game, Burst ballons, Scramble string 
  - Game <a id="algorithms-dp-game"></a>
    + Patterns:
      * state: f[i] represents win/lose max/min profit for the first person
      * induction rule: avoid defining second person's state because second person always tries his best to defeat first person/make first person profit least.
      * initialize: varies with problem
      * answer: f[n]
    + Examples: Coin in a line (Lintcode), Coin in a line II (Lintcode), Flip game II
  - Backpack <a id="algorithms-dp-backpack"></a>
    + Patterns:
      * state: f[i][S]: whether the first i items could form S/Max value/number of ways
      * induction rule: varies with problems
      * initialize: varies with problems
      * answer: varies with problems
    + Examples: Backpack I-VI (Lintcode), K Sum (Lintcode), Minimum adjustment cost (Lintcode)

#### References <a id="references"></a>
* Core Java Interview questions [blog: java-success.com](http://www.java-success.com/)
* Coding and system design [blog: massive tech interview](http://massivetechinterview.blogspot.com/)
* Algorithms tutorial [Algorithm tutorial](http://algorithms.tutorialhorizon.com/)