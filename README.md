# Fight towards 1000 commits !!!
* [Typical whiteboard coding workflow](#whiteboard-workflow)
    * [Clarify questions](#whiteboard-workflow-clarify)
    * [Give a small but general enough example for discussing algo/DS](#whiteboard-workflow-context)
    * [Come up with a brute force algorithm](#whiteboard-workflow-bruteforce)
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
    * [Goal](#practice-goal)
    * [Attitudes](#practice-attitudes)
    * [Tools](#practice-tools)
    * [Strategies](#practice-strategies)
    * [Leetcode pros and cons](#leetcode-pros-cons)
    * [Interview Java pros and cons](#java-pros-cons)
* [Java language](#java-language)
    * [Characteristics of Object oriented](#characteristics)
    * [Java vs C++](#java-vs-c++)
    * [Thread vs process](#thread-vs-process)
    * [Access modifiers](#access-modifiers)
    * [Stack vs heap vs static area](#stack-heap-staticarea)
    * [OutOfMemoryError](#outof-memory-error)
    * [Equals and hashcode](#equals-hashcode)
    * [Overload vs override](#overload-vs-override)
    * [Abstract class vs interface](#abstract-class-vs-interface)
    * [Static](#static-keyword)
    * [Main method](#main-method)
    * [Volatile](#volatile-keyword)
    * [Clone](#clone)
    * [Assert](#assert)
    * [Error vs exception](#error-vs-exception)
    * [Checked vs unchecked exception](#checked-vs-unchecked-exception)
    * [Immutable objects](#immutable-objects)
    * [Final vs finally vs finalize](#final-finally-finalize)
    * [Comparable vs comparator](#comparable-vs-comparator)
    * [Memory leak](#memory-leak)
    * [Garbage collector](#garbage-collector)
    * [JVM](#jvm)
    * [Design pattern](#design-pattern)
      - [Singleton](#design-pattern-singleton)
      - [Factory](#design-pattern-factory)
      - [Template](#design-pattern-template)
      - [Strategy](#design-pattern-strategy)
    * [Multi-threading comparison](#multithreading)
* [Data structures](#ds)
    * [Data structure relationships](#ds-relationship)
    * [Type size](#ds-type-size)
    * [Type conversions](#ds-type-conversions)
      - [Automated cast](#ds-type-conversions-automated-cast)
      - [Between string and primitive types](#ds-type-conversions-string-and-integer)
      - [Between array and collections](#ds-type-conversions-array-and-collections)
      - [Between collections](#ds-type-conversions-collections)
    * [Array](#ds-array)
      - [Circular array](#ds-circular-array)
      - [Array sum](#ds-array-array-sum)
      - [Forward backward traversal](#ds-array-forward-backward-traversal)
    * [String](#ds-string)
      - [Why String is immutable or final](#ds-string-immutable)  
      - [String vs StringBuilder vs StringBuffer](#ds-string-tradeoffs)
      - [String reverse](#ds-string-reverse)
      - [Encode and decode](#ds-string-encode-decode)
      - [Palindrome](#ds-string-palindrome)
      - [String parsing](#ds-string-parsing)
    * [Collections](#ds-collections)
      - [Iterator](#ds-collections-iterator)
      - [Immutability](#ds-collections-immutability)
    * [List](#ds-list) 
      - [ArrayList vs LinkedList](#ds-list-tradeoffs)
      - [LinkedListNode](#ds-list-linkedlistnode)
      - [Common tasks](#ds-list-common-tasks)
    * [Stack](#ds-stack)
      - [Calculator](#ds-stack-calculator)
      - [Parentheses](#ds-stack-parentheses)
    * [Queue](#ds-queue)
      - [Interfaces](#ds-queue-interfaces)
    * [PriorityQueue](#ds-priorityqueue)
      - [Heapify](#ds-priorityqueue-heapify)
      - [Sift up/down](#ds-priorityqueue-sift-up-down)
      - [Improve built-in remove](#ds-priorityqueue-improve-built-in-remove)
      - [Lambda expression as comparator](#ds-priorityqueue-lambda-expression)
    * [Tree](#ds-tree)
      - [Build](#ds-tree-build)
      - [Traversal](#ds-tree-traversal)
      - [View](#ds-tree-view)
      - [Serialize/Deserialize](#ds-tree-serialize-deserialize)
      - [Path on tree](#ds-tree-path)
      - [Segment tree](#ds-tree-segment-tree)
      - [Binary search tree](#ds-tree-binary-search-tree)
    * [HashMap](#ds-hashmap)
      - [Use case](#ds-hashmap-usecase)
      - [Best practices](#ds-hashmap-best-practices)
      - [Collision resolution](#ds-hashmap-collision-resolution)
      - [Intersection](#ds-hashmap-intersection)
      - [Histogram and hashmap list](#ds-hashmap-histogram-hashmap-list)
      - [Anagram](#ds-hashmap-anagram)
      - [Sparse matrix](#ds-hashmap-sparse-matrix)
      - [LRU cache](#ds-hashmap-lru-cache)
    * [TreeMap](#ds-treemap)
    * [Graph](#ds-graph)
      - [Edge list vs Adjacent list vs Adjacent matrix](#ds-graph-tradeoffs)
      - [Build graph](#ds-graph-build)
    * [Trie](#ds-trie)
      - [Use case](#ds-trie-use-case)
      - [Trie definition](#ds-trie-def)
      - [Common tasks](#ds-trie-common-tasks)
* [Algorithms](#algo)
    * [Math](#algo-math)
      - [Random](#algo-math-random)
      - [Mod](#algo-math-mod)
      - [Power](#algo-math-power)
      - [Sqrt](#algo-math-sqrt)
      - [Divide](#algo-math-divide)
      - [Multiply](#algo-math-multiply)
      - [Prime](#algo-math-prime)
    * [Bit manipulation](#algo-bit-manipulation)
      - [Arithmetic vs logic right shift](#algo-bit-manipulation-arithmetic-vs-logic)
      - [Common tasks](#algo-bit-manipulation-common-tasks)
    * [Non-DP memorization](#algo-non-dp-memorization)
      - [Array](#algo-non-dp-memo-array)
      - [Stack](#algo-non-dp-memo-stack)
      - [Hashmap](#algo-non-dp-memo-hashmap)
    * [Two pointers](#algo-two-pointer)
      - [Use case](#algo-two-pointer-use-case)
      - [Types](#algo-two-pointer-types)
        + [Begin and end type](#algo-boundary-to-center)
        + [Slow and fast type](#algo-slow-and-fast)
        + [Window type](#algo-window)
        + [Two arrays type](#algo-two-arrays)
    * [Sort](#algo-sort)
      - [Common sorting algorithms](#algo-sort-common-algo)
      - [Built-in sort interfaces](#algo-built-in-sort-interfaces)
      - [Types](#algo-sort-types)
        + [Interval-related](#algo-sort-types-interval-related)
        + [TopK](#algo-sort-types-topK)
    * [Binary search](#algo-binary-search)
      - [Best practices](#algo-binary-search-best-practices)
      - [How to handle duplicates](#algo-binary-search-handle-duplicates)
      - [Types](#algo-binary-search-types)
        + [First/Last smaller/bigger](#algo-binary-search-first-last-smaller-bigger)
        + [Rotated array](#algo-binary-search-rotated-array)
        + [2D array](#algo-binary-search-2d-array)
    * [Recursion](#algo-recursive)
      - [Recursive vs iterative solutions](#algo-recursive-iterative)
      - [Recursion time complexity cheat sheet](#algo-recursive-tc)
      - [Steps in using recursion](#algo-recursion-problems-to-consider)
      - [Return multiple results](#algo-recursion-return-multiple-results)
      - [Avoid duplicated recursion](#algo-recursion-avoid-duplicated-recursion)
      - [Types](#algo-recursion-types)
        + [Tree-based recursion](#algo-recursion-tree-based)
        + [Deep copy](#algo-recursion-deep-copy)
        + [Array-based recursion](#algo-recursion-array-based)
    * [Backtrack](#algo-backtrack)
      - [Best practices](#algo-backtrack-best-practices)
      - [Types](#algo-recursion-types)
        + [Generate all permutations](#algo-backtrack-permutation)
        + [Generate all subsets](#algo-backtrack-subsets)
        + [Generate all combinations summing to a target](#algo-backtrack-combination-sum)
        + [Generate Decode ways/Gray code](#algo-backtrack-generate-decode-ways)
        + [Grid-based](#algo-backtrack-grid-based)
    * [Graph](#algo-graph)
      - [Grid-based best practices](#algo-grid)
      - [Grid-based breath first search](#algo-grid-based-bfs)
      - [Grid-based depth first search](#algo-grid-based-dfs)
      - [Grid-based count number of components](#algo-grid-based-count-number-of-components)
      - [Word-based breath first search](#algo-word-based-bfs)
      - [Topological sort](#algo-topo)
      - [Union find](#algo-union-find)
    * [Greedy](#algo-greedy)
    * [Dynamic programming](#algo-dynamic-programming)
      - [Use cases](#algo-dp-use-cases)
      - [Problems to consider](#algo-dp-problems-to-consider)
      - [Implementation methods](#algo-dp-implementation-methods)
      - [Memorization array tricks](#algo-dp-memorization-array-tricks)
      - [Types](#algo-dp-types)
        + [Coordinate based](#algo-dp-types-coordinate)
        + [1D sequence](#algo-dp-1d-sequence)
        + [2D sequences](#algo-dp-2d-sequences)
        + [Range based](#algo-dp-range-based)
        + [Game](#algo-dp-game)
        + [Backpack](#algo-dp-backpack)
* [References](#references)
  
### Typical whiteboard coding workflow <a id="whiteboard-workflow"></a>

#### Clarify question <a id="whiteboard-workflow-clarify"></a>
1. Define public APIs to be implemented:
  * Things to define - Input type
  * Things to define - Number of input arguments
  * Things to define - Output type
    - boolean: Whether solutions exist or not
    - int: the number of solutions
    - List&lt;?> : solutions themselves
    - List&lt;?>: solutions without duplicates
    - List&lt;?>: solutions with specific order
     
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
         * Sorted or unsorted, sorted increasingly or decreasingly
         * Given two arrays, which one's size is bigger
         * Whether could modify entries inside array
      * Input - String<a id="question-string"></a>
         * Whether the string contains space
         * How are tokens separated, using comma, slash or something else
         * Alphabetic characters(lower/upper case), ascii characters, or unicode characters  
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
        * Increasing/Decreasing order
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
   3. Whether space complexity is acceptable or not: "***algo with linear space complexity is usually acceptable.***"
   4. Repetitive computation: "***We solve a lot of repetitive problems. If we could cache the solutions, it will be much more efficient.***"
   5. Additional rounds of iterating input: "***We iterate through input twice. If we could reduce it to once, it will boost performance twice.***"
3. Synchronize with interviewer "***The reason we could do better is XXX***."
4. Ask for help when being stuck
   1. Show interviewer all the approaches you tried and difficulties. ""
   2. Be keen to what interviewer is saying: Every word the interviewer is saying has its meanings. ""
5. Synchronize with interviewer "***Do you have any concerns for the proposed algorithm? Should we write code for this***."

#### Write test cases <a id="whiteboard-workflow-test-cases"></a>
* In general, the following types of test cases should be considered 
   * The normal case: e.g. array length of even or odd in sorting algo
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
       1. Look for typos
       1. Look for unused variables, counters, unnecessary edge case checkings, boundaries index overflow/underflow 
       2. Look for unhandled problem assumptions
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
  - Can s/he explain technical solutions well?
  - Does s/he understand basic concepts well?
  - Does s/he has a good grasp of past project experiences?
  - How is his/her attitude?
  - Is s/he a good coder? (proficiency in leetcode and whether error-prone)
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

#### Whiteboard coding pros and cons <a id="whiteboard-coding-pros-cons"></a>
* Pros
  * Every software engineer knows algo and data structures. It provides a common domain for interviewers and interviewees to discuss.
  * Smart people will always be smart wherever they go. There are just too many candidates there and there needs a way to differentiate it. At least, whiteboard coding could reflect candidates' understanding of algo/data structures and communication skills.
  * Whiteboard coding advocates a good workflow for developing code.
* Cons
  * The most important capability for a software engineer is abstraction and skipping complexity. algo questions are usually available in many online forums. Even if candidates could finish the problem in interview, it does not necessarily demonstrate the core perspective here. It might generate high false positives and false negatives. 
  * Finish algo in 20 min in a bug-free and clean way requires lots of practice. It does not only require interviewee to understand algo and data structures, but also really proficient in these, sometimes even remember pretty tricky test cases. 
  * The optimization process in algorithm questions is kind of over-optimization. In practice, only improve performance when necessary.
  * Stand and write code on whiteboard is really exhausting if lasting for 4-5 hours.

### Practice mindset <a id="practice-patterns"></a>
#### Goal <a id="practice-goal"></a>
  * Proficiency: Given an original Leetcode problem you should be able to finish it no more than 10 minutes no matter what its difficulty level is.
  * Understanding: You should be able to start from brute force solution, discuss tradeoffs along the way and optimize to a solution the interviewer is satisfied with.
  * Cleaness: No interview code should be longer than 100 lines. In most cases it is within 50 lines. Keep optimizing your code until it is short enough. 

#### Attitudes <a id="practice-attitudes"></a>
  * This might be the last time in my life that I spent so much time and efforts in algorithm questions. Next time when I hunt for jobs, either HRs will invite me or I will have far less time to prepare.
  * An interview is a matter of preparation. To enable yourself explain solutions well and code in a bug free way, you need to practice a lot. 
  * The way an engineer approach a algorithm problem can reflect their efficiency at work. 
  * Hiring system is broken. But currently there is no better way to do it.

#### Tools<a id="practice-tools"></a>
  * Task planning: Use tags ( TO_START, TO_HURRY, TO_TEST ) to manage algorithm question status and prioritize important tasks
  * Feedbacks: Use git commit number per day as feedback for progress
  * Summarizing lessons: Use git commit message as a place to learn from mistakes and summarize lessons

#### Strategies<a id="practice-strategies"></a>
  * Chunk it up
    * Focus on recently popular, medium to hard questions.
    * For each category of problems, summarize common tricks/techniques used.
  * Deliberate practicing
    * Try new ways to solve problems. 
    * Try to generalize my mistake or lessons.
    * How does current problem relates to other problems.
  * Feedbacks
    * Interview a lot. 
    * Reflection on what I do good and bad

#### Leetcode pros and cons <a id="leetcode-pros-cons"></a>
* Pros
  * Latest interview questions
  * Large pool of different question types
* Cons
  * Testing
    * Input is always valid. 
    * Time exceed limit is too constraint. Sometimes we want to start from inefficient algo, verify its correctness and then optimize performance.
  * Debug
    * When problem occurs, too few stack trace
    * No online debuggers
  * Usability
    * No history track along time axis. Really bad synchronous workflow
    * Unable to mark different stages in solving a problem ( e.g. thought-out, implemented, optimized, on-line judged, summarized )
    * Cannot add enough comments along the code
    * Could not search problems by specifying multiple tags
    * Function names do not follow best practices, which makes variables naming kind of difficult.

#### Interview Java pros and cons <a id="java-pros-cons"></a>
* Pros
  * Readability
* Cons
  * A bit verbose: heavy to return tuple values
  * Only pass by values
  * Lambda expressions are still not closures
  * Linkedhashset could not be iterated reversely

### Java language<a id="java-language"></a>
#### Characteristics of Object oriented<a id="characteristics"></a>
#### Thread vs process<a id="thread-vs-process"></a>
* For most computing tasks, there is great advantage to splitting up workload into multiple actors and partitioning the task into different, multiple tasks for these multiple actors. Two common ways of doing this are multi-threaded programs and multi-process systems.

| Differences |  Thread |  Process  |
| --------------------- |:-------------:| -----:|
| Def | A lightweight process with less resource consumption | A running instance of a program |
| Data sharing | A process has separate virtual address space. Inter process mechanism such as pipes, sockets, shared memory | All threads of a process share its virtual address space and system resources but have their own stack created. No specific mechanism for sharing. |
| Overhead to create/terminate  | Faster due to very little memory copying (just thread stack) | Slower because whole process area needs to be copied |
| Task switching  | Faster because CPU caches and program context can be maintained | Slower because all process area needs to be reloaded |
| Synchronization overhead | Shared data that is modified requires special handling in the form of locks, mutexes and primitives | No synchronization needed |
| Program debugging | More difficulties including synchronization, non-deterministic timing and accidental data corruption | Easier |
| Use cases  | Threads are a useful choice when you have a workload that consists of lightweight tasks (in terms of processing effort or memory size) that come in, for example with a web server servicing page requests. There, each request is small in scope and in memory usage. Threads are also useful in situations where multi-part information is being processed – for example, separating a multi-page TIFF image into separate TIFF files for separate pages. In that situation, being able to load the TIFF into memory once and have multiple threads access the same memory buffer leads to performance benefits. | Processes are a useful choice for parallel programming with workloads where tasks take significant computing power, memory or both. For example, rendering or printing complicated file formats (such as PDF) can sometimes take significant amounts of time – many milliseconds per page – and involve significant memory and I/O requirements. In this situation, using a single-threaded process and using one process per file to process allows for better throughput due to increased independence and isolation between the tasks vs. using one process with multiple threads. |

#### Java vs C++<a id="java-vs-c++"></a>

| Differences | C++          | Java  |
| --------------------- |:-------------:| -----:|
| Design goals  | Extend C but support OOP, can write non-OOP language | OOP language, must write OOP |
| Run env | at OS level, must compiled against particular OS | inside JVM, compiled classes portable |
| Pointers | Could pass value by reference | Only pass by value |
| Memory management  | Managed by developers | Garbage collector |
| Exception handling  | All unchecked | Error and RuntimeException unchecked, others checked |

#### Access modifiers<a id="access-modifiers"></a>

| Access modifiers | Current class | Same package | Children classes | Other packages |
| ---------------- |:-------------:| ------------:| ----------------:| --------------:|
| public           |     Yes       |     Yes      |      Yes         |     Yes        |
| protected        |     Yes       |     Yes      |      Yes         |      No        |
| default          |     Yes       |     Yes      |       No         |      No        |
| private          |     Yes       |      NO      |       No         |      No        |

#### Stack vs heap vs static area<a id="stack-heap-staticarea"></a>
* Stack: local variables
* Heap: new created variables
* Static area: literal and constant variables

#### OutOfMemoryError<a id="outof-memory-error"></a>
* Types
  - java.lang.OutOfMemoryError: Java heap space
  - java.lang.OutOfMemoryError: PermGen space
  - java.lang.OutOfMemoryError: Requested array size exceeds VM limit
  - java.lang.OutOfMemoryError: request "size" bytes for "reason". Out of swap space?
  - java.lang.OutOfMemoryError: "reason" "stack trace" (Native method)
* Solution
  - Step 1: Allow the JVM to use more memory
  - Step 2: Improve/Fix the application to reduce memory usage
    1. Generate a heap dump on OutOfMemoryError
    2. Reproduce the problem
    3. Investigate the issue using heap dump file

#### Equals and hashcode<a id="equals-hashcode"></a>
* The contract between equals and hashCode is
  - If two objects are equal, then they must have the same hash code.
  - If two objects have the same hash code, they may or may not be equal.

#### Overload vs override<a id="overload-vs-override"></a>

| Differences | Overload          | Override  |
| --------------------- |:-------------:| -----:|
| Definition  | Two methods with same name but different signatures      |  Redefine a class already defined in the parent class |
| Execution time | Compile time     |  Run time |

#### Abstract class vs interface<a id="abstract-class-vs-interface"></a>

| Differences | Abstract class          | Interface  |
| --------------------- |:-------------:| -----:|
| Use case  | share code among closely related classes |  share code skeleton among unrelated classes |
| Content  | a mix of methods with/without implementation | Only methods/fields, no implementations |
| Modifiers  | no limits | fields are public/static/final, methods are public automatically |
| Inheritance  | Single  | Multiple |

#### Static keyword <a id="static-keyword"></a>
* Detailed comparison

|                 |    Use case   | Accessibility  |  Benefits |
| --------------- |:-------------:| --------------:| ---------:|
| Static class    | Static classes are nested classes that act like top-level classes, even if they appear somewhere in the middle or the bottom of the program hierarchy (within a class). Static classes do not need the reference of the outer class. They act like an outer class within themselves. Normal non-static nested classes, on the other hand, need reference of the outer class.  In other words, static classes are independent of the outer class, while other inner classes are dependent on the outer class. | Static classes can only access static members of an outer class, while non-static nested classes can interact with both static and non-static members of an outer class. This functionality allows static nested classes to interact with other parts of the program and provides code re-usability. | A static class, like other nested classes, can access the private variables and methods of its outer class. Static classes can be declared to remove restrictions on member classes of an outer class. If we think the outer class is too limiting and we want a member class to perform more functions, we use the “static” keyword to provide that added functionality. A static class can never be instantiated. Static classes can’t directly access non-static members of a class. It can interact with them only through an object reference. This is both a drawback and an advantage of a static class. | 
| Static block    | Static blocks are also called Static initialization blocks . A static initialization block is a normal block of code enclosed in braces, { }, and preceded by the static keyword. Static block is mostly used for changing the default values of static variables. This block get executed when the class is loaded into memory. A class can have multiple static blocks, which will be executed in the same sequence in which they have been written into the program. | non-static variables cannot be accessed in static block.  | <ul><li>If you’re loading drivers and other items into the namespace. For ex, Class class has a static block where it registers the natives.</li><li>If you need to do computation in order to initialize your static variables,you can declare a static block which gets executed exactly once,when the class is first loaded.</li><li>Security related issues or logging related tasks</li></ul> |
| Static method   | A static method belongs to the class rather than instances. You can call a static method without creating any object, just by using it's class name. So if you need a method, which you want to call directly by class name, make that method static. Utility classes e.g. java.lang.Math or StringUtils, are good examples of classes, which uses static methods. Before making a method static, you should look into limitation of static methods as well, as you can not override static method in Java. | <ul><li>Static methods can access static variables and invoke only static methods of the class. The static method cannot use non static data member or call non-static method directly.</li><li>this and super cannot be used in static context.</li></ul> | | 
| Static variable | A static variable is a class variable and doesn't belong to object/instance of the class. Memory allocation for such variables only happens once when the class is loaded in the memory. | These variables can be accessed in any other class using class name. Unlike non-static variables, such variables can be accessed directly in static and non-static methods. | Memory more efficient because the static variable allocate memory only once in class area at the time of class loading. Static variables are shared across all the instances of object, thus not thread-safe. |
| Interface static method |  |  |  |
| static import | | | | 

* Rules to use static method
  1. If a method doesn't modify state of object, or not using any instance variables.
  2. You want to call method without creating instance of that class.
  3. A method is good candidate of being static, if it only work on arguments provided to it e.g. public int factorial(int number){}, this method only operate on number provided as argument.
  4. Utility methods are also good candidate of being static e.g. StringUtils.isEmpty(String text), this a utility method to check if a String is empty or not.
  5. If function of method will remain static across class hierarchy e.g. equals() method is not a good candidate of making static because every Class can redefine equality.

* When to use static method
  - it makes sense to use static methods when 
    + Along with creational design pattern e.g. Factory and Singleton.
    + As utility method, which operate on arguments.
    + A conversion tool e.g. valueOf().
  - Detailed explanation
    1. Factory design pattern provides a good use of static method. You can use static method to create instance of a class. Even Effective Java book advises about using static factory method, couple of example of these in Java library is creating thread pool from Executors class. Executors provides lots of static methods to create different types of thread pool e.g. public static ExecutorService newCachedThreadPool(), public static ExecutorService newFixedThreadPool(int nThreads) etc
    2. Another interesting use of static methods from JDK is collection classes e.g. Collections and Arrays which provides lot of static utility methods to operate on different kinds of collection.
    3. Static method can also be combined with variable arguments to create a collection of explicitly elements e.g. EnumSet.of(E first, E... rest). Apart from these, if you loot at Apache commons lang library, you will find a pattern of utils class e.g. StringUtils, ArrayUtils, which provides utility methods to operate on String and arrays.
    4. One more interesting use of static method I have seen is valueOf() method inside different value classes e.g. java.lang.String, though this is also an example of factory method, but it's also a nice way to convert one type to another. For example valueOf() can also be used to convert String to Integer in Java.
  
* Cannot override static methods in Java
No, you cannot override static method in Java because method overriding is based upon dynamic binding at runtime and static methods are bonded using static binding at compile time. Though you can declare a method with same name and method signature in sub class which does look like you can override static method in Java but in reality that is method hiding. Java won't resolve method call at runtime and depending upon type of Object which is used to call static method, corresponding method will be called. It means if you use Parent class's type to call static method, original static will be called from patent class, on ther other hand if you use Child class's type to call static method, method from child class will be called. In short you can not override static method in Java. If you use Java IDE like Eclipse or Netbeans, they will show warning that static method should be called using class name and not by using object becaues static method can not be overridden in Java.

#### Main method <a id="main-method"></a>
* Why main method is static
  1. Since the main method is static Java virtual Machine can call it without creating any instance of a class which contains the main method.
  2. Since C and C++ also have similar main method which serves as entry point for program execution, following that convention will only help Java.
  3. If main method were not declared static than JVM has to create instance of main Class and since constructor can be overloaded and can have arguments there would not be any certain and consistent way for JVM to find main method in Java.
  4. Anything which is declared in class in Java comes under reference type and requires object to be created before using them but static method and static data are loaded into separate memory inside JVM called context which is created when a class is loaded. If main method is static than it will be loaded in JVM context and are available to execution.
* Why main method is public
Java specifies several access modifiers e.g. private, protected and public. Any method or variable which is declared public in Java can be accessible from outside of that class. Since the main method is public in
Java, JVM can easily access and execute it.
* Why the main method is void
Since the main method in Java is not supposed to return any value, it's made void which simply means main is not returning anything.


#### Volatile keyword <a id="volatile-keyword"></a>

#### Clone<a id="clone"></a>
* Deep and shallow copy
  - Default clone() method creates the shallow copy of an object. 
    + The shallow copy of an object will have exact copy of all the fields of original object.
    + Shallowcopy is preferred if an object has only primitive fields. 
  - In addition to shallow copy,
    + If original object has any references to other objects as fields, then copy of those objects are also created by calling clone() method on them.  
* How to clone an object
  - Implements Cloneable interface and override clone() 
  - Implements serializable interface and clone objects by serialize and deserialize

#### Assertion <a id="assert"></a>
* Assertion. To put it short, assertion are for internal precondition/post-condition violation checking while exception are for external condition checking.
  - Where not to use
    + Implement any application functionality
      * Enable/Disable them may cause severe damage to the state of the application and its usability
    + Check arguments of public methods
      * Public methods should always behave the same. Enable/Disable them will change the behavior of the method dramatically.
  - Where to use: internal logic checking
    + Implement pre-conditions
      * Something that must be true at the time of invoking a method
    + Implement post-conditions
      * Something that must be true after the 
    + Implement class invariants

#### Error vs exception <a id="error-vs-exception"></a>
* Both java.lang.Error and java.lang.Exception classes are sub classes of java.lang.Throwable class
* java.lang.Error class represents the errors which are mainly caused by the environment in which application is running. 
  + For example, OutOfMemoryError occurs when JVM runs out of memory or StackOverflowError occurs when stack overflows.
* java.lang.Exception class represents the exceptions which are mainly caused by the application itself. 
  + For example, NullPointerException occurs when an application tries to access null object or ClassCastException occurs when an application tries to cast incompatible class types. In this article, we will discuss the differences between Error and Exception in java.

#### Checked vs unchecked exception <a id="checked-vs-unchecked-exception"></a>
* **Checked exception**
  - **Def**: Exceptions that are checked at compile time. Must be handled explicitly either by catching or throwing the exception. 
  - **Use condition 1**: Expected but unpreventable (The caller did everything within their power to validate the input parameters, but some condition outside their control has caused the operation to fail. For example, you try reading a file but someone deletes it between the time you check if it exists and the time the read operation begins. By declaring a checked exception, you are telling the caller to anticipate this failure.)
  - **Use condition 2**: Reasonable to recover from (There is no point telling callers to anticipate exceptions that they cannot recover from. If a user attempts to read from an non-existing file, the caller can prompt them for a new filename. On the other hand, if the method fails due to a programming bug (invalid method arguments or buggy method implementation) there is nothing the application can do to fix the problem in mid-execution. The best it can do is log the problem and wait for the developer to fix it at a later time.)
* **Unchecked exception**: 
  - **Runtime exception**
    + **Use case**: Use runtime exceptions to indicate programming errors. Runtime exceptions indicate precondition violations. A precondition violation is simply a failure by the client of an API to adhere to the contract established by the API specification. For example, the contract for array access specifies that the array index must be between zero and the array length minus one. ArrayIndexOutOfBoundsException indicates that this precondition was violated.
    + **Examples**:
      * IllegalArgumentException ( check input of function arguments )
      * IllegalStateException ( illegal state of variables )
      * ArithmeticException ( 1 / 0 )
      * IndexOutOfBoundaryException ( example problem: search in unknown size sorted array )

#### Immutable class <a id="immutable-objects"></a>
* Benefits:
  - **Clone**: Don't need a copy constructor/an implementation of clone()
  - **Defensive copy**: Don't need to be copied defensively when used as a field
  - **Threadsafe**: Are automatically thread-safe and have no synchronization issues
  - **Hashcode cache**: Allow hashCode to use lazy initialization and to cache its return value
  - **Class invariants**: Have their class invariants established once upon construction and it never needs to be checked again.
* Design guidelines:
  - Don't allow subclass to override methods
    + Declare the class as final
    + Make constructor private and construct instances in factory methods
  - Don't provide setter methods
  - Make all fields final and private
  - If the instance fields include references to mutable objects, don't allow those objects to be changed
    + Do not provide methods that modify mutable objects
    + Do not share references of mutable objects. Create defensive copy of internal mutable objects when sharing.

#### Final vs finally vs finalize<a id="final-finally-finalize"></a>
* Final class can't be inherited, final method can't be overriden and final variable can't be changed. A class/Method may never be both abstract and final. Abstract means the class/Method must be extended/Overriden, while final means it cannot be. 


|     Object   |       Meaning        |       Advantage    |     Example      |
| ------------ |:--------------------:| ------------------:| ----------------:|
| Final class  | Cannot be subclassed | Security/Efficiency | String | 
| Final method | Cannot be overriden  | <ul> <li>Preventing unexpected behavior crucial to the funtionality of the class </li> <li>Critical to the consistent state of the object</li> </ul> | <ul><li>Object.getClass()/notify() </li> <li> methods called from constructors should usually be final </li></ul> | 
| Final var    | Cannot be reassigned / Making a reference var final only means the var can not be changed but you can change the referenced object | <ul> <li>Could be cached </li> <li> Safe to share in multi-threading env </li> </ul> | All vars declared inside java interface are implicitly final |

* Finally
  - Use case: Clean up operations like closing the DB resources 
  - Reason: those operations will be always executed irrespective of 
    + Whether exceptions are raised in the try block or not
    + Whether raised exceptions are caught in catch block or not
    + Except 
      * You call JVM to exit by executing System.exit(0)
```java
lock.lock();
try 
{
  // do stuff
}
catch ( SomeException se )
{
  // handle se
}
finally
{
  lock.unlock();
}
```

* Finalize 
  + How it is going to work
    - When the garbage collector is ready to release the storage used for your object, it will first call finalize()
    - Only on the next garbage-collection pass will it reclaim the object's memory. 
  + Use case: 
    - Finalize() should not be used as a general-purpose cleanup method. Finalize() is limited to special cases in which your object can allocate storage in some way other than creating an object. Finalize() is in place because of the possibility that you'll do something C-like by allocating memory using a mechanism other than the normal one in Java. This can happen primarily through native methods, which are a way to call non-Java code from Java. Inside the non-Java code, C's malloc() family of functions might be called to allocate storage, and unless you call free(), that storage will not be released, causing a memory leak. 
    - An interesting use of finalize() is the verification of the termination condition of an object. When the object is ready to be cleaned up - the object should be in a state whereby its memory can be safely released. 
```java
class FinalizeExample
{
  public void finalize()
  {
    System.out.println("finalize called");
  }

  public static void main( String[] args )
  {
    FinalizeExample f1 = new FinalizeExample();
    FinalizeExample f2 = new FinalizeExample();
    f1 = null;
    f2 = null;
    System.gc();
  }
}
```

#### Comparable vs comparator<a id="comparable-vs-comparator"></a>

#### Java memory leak <a id="memory-leak"></a>

#### Garbage collector <a id="garbage-collector"></a>

#### JVM <a id="jvm"></a>

#### Design pattern <a id="design-pattern"></a>
| Name      | Intent                                                                                                                                                                                                               | Real world example                                                                                                                                                                                     | 
|-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| Builder   | Separate the construction of a complex object from its representation so that the same construction process can create different representations.                                                                    | java.lang.StringBuilder#append()/java.lang.StringBuffer#append                                                                                                                                         | 
| Singleton | Ensure a class has only one instance, and provide a global point of access to it.                                                                                                                                    | java.lang.Runtime#getRuntime()                                                                                                                                                                         | 
| Adapter   | Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.                                               |                                                                                                                                                                                                        | 
|           | java.util.Arrays#asList()/java.util.Collections#list()                                                                                                                                                               |                                                                                                                                                                                                        | 
| Flyweight | Use sharing to support large numbers of fine-grained objects efficiently.                                                                                                                                            |                                                                                                                                                                                                        | 
|           | java.lang.Integer#valueOf(int) (also on Boolean, Byte, Character, Short, Long and BigDecimal)                                                                                                                        |                                                                                                                                                                                                        | 
| Command   | Encapsulate a request as an object, thereby letting you parametrize clients with different requests, queue or log requests, and support undoable operations.                                                         |                                                                                                                                                                                                        | 
|           | java.lang.Runnable                                                                                                                                                                                                   |                                                                                                                                                                                                        | 
| Iterator  | Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.                                                                                             | All implementations of java.util.Iterator (thus among others also java.util.Scanner)                                                                                                                   | 
| Mediator  | Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. |                                                                                                                                                                                                        | 
|           | java.util.Timer (all scheduleXXX() methods)/java.util.concurrent.Executor#execute()/java.lang.reflect.Method#invoke()                                                                                                |                                                                                                                                                                                                        | 
| Memento   | Without violating encapsulation, capture and externalize an object's internal state so that the object can be returned to this state later.                                                                          |                                                                                                                                                                                                        | 
|           | java.util.Date (the setter methods do that, Date is internally represented by a long value)/ All implementations of java.io.serializable/                                                                            |                                                                                                                                                                                                        | 
| Strategy  | Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.                                                     | java.util.Comparator#compare(), executed by among others Collections#sort                                                                                                                              | 
| Template  | Define the skeleton of an algorithm in an operation, deferring some steps to client subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.   | All non-abstract methods of java.io.InputStream,java.io.OutputStream,java.io.Reader,java.io.Writer/All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap | 


### Data structures <a id="ds"></a>

#### Data structure relationships<a id="ds-relationship"></a>

| Enhancements | Original          | Improved  |
| --------------------- |:-------------:| -----:|
| Accuracy  | float/double      |  BigDecimal |
| Insert/Delete at begin/end/any pos | Stack/Queue     |   Deque/LinkedList |
| Fixed sized to resizable  | Array/String | ArrayList/StringBuilder |
| No order to insertion/sorted order  | Hashmap      |   linkedHashMap/TreeMap |
| Partial to complete order | Priorityqueue | Treeset |

#### Type size<a id="ds-type-size"></a>
* Reference types: 32-bit system (32 bit), 64-bit system (64 bit)
* Enumeration type: 
* Primitive types: boolean (8 bit), byte (8 bit), char (16 bit), short (16 bit), int (32 bit), long (64 bit), float (32 bit), double (64 bit)

#### Type conversions<a id="ds-type-conversions"></a>
##### Automated cast<a id="ds-type-conversions-automated-cast"></a>
* Convert char to int, does not need explicit conversion
```java
value = value * 10 +  s.charAt( currPos ) - '0' ; 
```

##### Between string and primitive types <a id="ds-type-conversions-string-and-integer"></a>
* Convert string to primitive types: parseXXX(String) or valueOf(String)
* Convert primitive types to string: String.valueOf() or add with an empty string ""

##### Between array and collections <a id="ds-type-conversions-array-and-collections"></a>
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

##### Between collections <a id="ds-type-conversions-collections"></a>
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

#### Array <a id="ds-array"></a>
##### Circular array <a id="ds-array-circular"></a>
* Common techniques used in circular arrays
  - double the array to 2n by concatenating original array to the end and then apply a sliding window of size n on it (whether is a sorted rotated array)
  - invert the sign of the array (circular array maximum sum)
  - break the circle (house robber II)

##### Array sum<a id="ds-array-array-sum">
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

##### Forward backward traversal <a id="ds-array-forward-backward-traversal"></a>
* Trapping rain water, Best time to buy and sell stock III, product of array exclude itself

#### String <a id="ds-string"></a>
##### Why String is immutable or final <a id="ds-string-immutable"></a>
* By design: 
  - **String pool**: Strings are cached in String pool and shared between multiple clients. 
  - **Security**: No one could override the behavior of String class and don't need to worry about many security threats.
  - **Performance**: Cache its hashcode. Avoid synchronization.

##### String vs StringBuilder vs StringBuffer <a id="ds-string-tradeoffs"></a>

| Comparison | String         | StringBuilder | StringBuffer  |
| --------------------- |:-------------:| -----:|-----:|
| Storage area  | Constant string pool    | Heap | Heap |
| Modifiable    | Immutable     |   Mutable | Mutable |
| Thread safe   | Yes     |   No | Yes | 
| Performance   | Fast    |   Fast | very slow| 

##### String reverse <a id="ds-string-reverse"></a>

##### Encode and decode <a id="ds-string-encode-decode"></a>

##### Palindrome <a id="ds-string-palindrome"></a>
* Several ways to solve the Longest palindrome substring problem
  - DP-based solution: O(n^2) space and time, if need to storing palindrome result, this is always better (e.g. palindrome partitioning)
  - Start looping from middle: O(n^2) time
  - Manacher's algorithm: O(n) time, not generic enough.

#### Collections <a id="ds-collections"></a>
##### Iterator <a id="ds-collections-iterator"></a>
* When implementing hasNext() and next() function for an interator, should put the logic checking whether next elemement exists inside hasNext() function. 

##### Immutability <a id=""></a>
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

#### List <a id="ds-list"></a>
##### ArrayList vs LinkedList <a id="ds-list-tradeoffs"></a>
* Both implements List interface, maintain the insertion-order, non-synchronized collections

| Comparison | arraylist         | linkedlist  |
| --------------------- |:-------------:| -----:|
| Internal structure  | array    |  doubly linked list |
| Insert performance  | O(n)     |   O(1) |
| Search performance  | O(1)     |   O(n) |
| Memory overhead  | array and element      | two pointers and element |

##### LinkedListNode<a id="ds-list-linkedlistnode"></a>
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

##### Common tasks<a id="ds-list-common-tasks"></a>
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

#### Stack <a id="ds-stack"></a>
##### Calculator <a id="ds-stack-calculator"></a>
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

##### Parentheses <a id="ds-stack-parent"></a>
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


#### Queue <a id="ds-queue"></a>
##### Interfaces <a id="ds-queue-interfaces"></a>
| Comparison | throws exception         | return special value  |
| --------------------- |:-------------:| -----:|
| insert  | boolean add(E e)    |  boolean offer(E e) |
| remove  | E remove()     |   E poll() |
| examine  | E element()     |   E peek() |


#### PriorityQueue <a id="ds-priorityqueue"></a>
##### Heapify <a id="ds-priorityqueue-heapify"></a>
##### Sift up/down <a id="ds-priorityqueue-sift-up-down"></a>
##### Improve built-in remove O(n)
* Built-in implementation remove() method for priorityqueue has O(n) time complexity.
  -  O(n) time is spent on looping through entire queue to find the element to be removed. O(logn) is used to remove the element
  -  But O(n) could be easily improved to O(logn) by adding an additional Map&lt;T, Node&gt; existingNodes. When Node has duplicate values, a counter could be added as Node class instance variable.

##### Lambda expression as comparator <a id="ds-priorityqueue-lambda-expression"></a>
```java
PriorityQueue<NumAndFreq> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2.freq - o1.freq ) ); // decreasing order
PriorityQueue<NumAndFreq> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.freq - o2.freq ) ); // increasing order
```

##### Top K problems <a id="ds-priorityqueue-top-k"></a>
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

#### Tree <a id="ds-tree"></a>
##### Build <a id="ds-tree-build"></a>
##### Traversal <a id="ds-tree-traversal"></a>
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

##### View <a id="ds-tree-view"></a>
* Right side view (Binary tree right side view)
  - Use List + tree traversal ( level order / preorder / reverse-preorder )
* Outer-inner order / Vertical order (Find binary tree leaves / Binary tree vertical order traversal)
  - Use HashMap + tree traversal ( level order / preorder )

##### Serialize/Deserialize <a id="ds-tree-serialize-deserialize"></a>
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

##### Path on tree <a id="ds-tree-path"></a>

##### Segment tree <a id="ds-tree-segment-tree"></a>
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

##### Binary search tree<a id="ds-tree-binary-search-tree"></a>
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
* Kth node in a BST

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

#### HashMap <a id="ds-hashmap"></a>
##### Use case <a id="ds-hashmap-usecase"></a>
* need a symbol table with search, insert and delete operations

##### Best practices <a id="ds-hashmap-best-practices"></a>
* Use Double as hashmap keys is a bad practice. Especially if needing to perform calculations on double keys, the hash of double could mess up.
* Use Object as hashmap keys. When the hashCode() and equals(Object o) methods are not overriden by your class, the default implementation are used. The default behavior is to treat all objects as different, unless they are the same object. IdentityHashMap always does this by using reference-equality in place of object-equality

##### Collision resolution <a id="ds-hashmap-collision-resolution"></a>
| Strategies | Use case         | 
| --------------------- |:-------------:| 
| Chaining with linked list  | worst case O(n), most commonly used    |
| Chaining with BST  | worst case O(logn), input extremely nonuniform distribution     |
| Open addressing with probing  | number of collisions really low  |

##### Intersection <a id="ds-hashmap-intersection"></a>
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

##### Histogram and hashmap list <a id="ds-hashmap-histogram-hashmap-list"></a>
```java
// more concise code for histogram with getOrDefault() API
map.put( key, 1 + map.getOrDefault( key, 0 ) );
// more concise code for hashmap list with putIfAbsent() API
map.putIfAbsent( key, new ArrayList<>() );
```

##### Anagram <a id="ds-hashmap-anagram"></a>
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

##### Sparse Vector/matrix <a id="ds-hashmap-sparse-matrix"></a>
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

##### LRU Cache <a id="ds-hashmap-lru-cache"></a>
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

#### TreeMap <a id="ds-treemap"></a>
* Get Key/Entry APIs: firstKey/firstEntry, lastKey/lastEntry, lowerKey/lowerEntry, higherKey/higherEntry, CeilingKey/CeilingEntry, floorKey/floorEntry
* Remove Key/Entry APIs: pollFirstEntry/pollLastEntry, remove
* Get Subset APIs: tailMap/headMap/subMap

#### Graph <a id="ds-graph"></a>
##### Edge list vs Adjacent list vs Adjacent matrix<a id="ds-graph-tradeoffs"></a>
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

##### Build graph <a id="ds-graph-build"></a>
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
* **Detect cycles inside undirected graph** with dfs + discovered set. 
* **Detect cycles inside directed graph** with dfs + visited set + discovered set.

#### Trie <a id="ds-trie"></a>
##### Use case <a id="ds-trie-use-case"></a>
* Find prefix of string
* Traverse character by character
* Compared with hashmap: 
   - Space complexity: when storing a list of words (Especially when these words share prefix), using trie save space. 
   - Time complexity: to compute hashcode for a string, O(n) time complexity; find/insert a string in a trie, the same

##### Trie definition <a id="ds-trie-def"></a>
* Depending on the size of charset, children pointers could be either stored in a bitmap or hashmap. Although slightly suffering performance, hashmap implementation is more concise and generic.
```java
class Trie
{
  public TrieNode root;
  // other functions
}

private class TrieNode
{
  public final int CHARSET_SIZE = 26;
  public char val;
  public Map<Character, TrieNode> children;     
  public boolean isLeaf;
  public TrieNode( char val )
  {
    this.val = val;
    children = new HashMap<>( CHARSET_SIZE );
  }     
} 
```
##### Common tasks <a id="ds-trie-common-tasks"></a>
* Add
* Search (regular expression)
* Start with
```java
// Adds a word into the data structure.
public void addWord( String word )
{
  // error handling...
  TrieNode curr = root;
  for ( Character ch : word.toCharArray() )
  {
    curr.children.putIfAbsent( ch, new TrieNode( ch ) );
    curr = curr.children.get( ch );
  }
  curr.isLeaf = true;
}

// Searches whether a word exists or not
// startWith() has fewer constraints: does not need to check the boolean isLeaf flag
public boolean search( String word )
{
  // error handling
  return search( word, 0, root );
}    
private boolean search( String word, int index, TrieNode root )
{
  if ( root == null )
  {
    return false;
  }
  else if ( index == word.length() )
  {
    return root.isLeaf;
  }
  else if ( word.charAt( index ) != '.' )
  {
    return search( word, index + 1, root.children.get( word.charAt( index ) ) );        
  }
  else
  {
    for ( TrieNode child : root.children.values() )
    {
      if ( search( word, index + 1, child ) )
      {
        return true;
      }             
    }
    return false;
  }
}
```

### Algorithms <a id="algo"></a>

#### Math <a id="algo-math"></a>
##### Random <a id="algo-math-random"></a>
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

##### Mod <a id="algo-math-mod"></a>
* judge whether a value is even or odd
  - Use num % 2 != 0 rather than num % 2 == 1 because of negative number mod ( e.g. -5 % 2 == -1 )
  - To guarantee mod result is always positive, if knowing num range RANGE, could consider ( num + RANGE ) % RANGE 

##### Power <a id="algo-math-power"></a>
* Power of integer: Java does not provide a built-in function for Integer values
  - solution 1: It has a built-in function double Math.pow( double, double ). But the computation cost for double is much higher than int and the result needs to be downcasted.
  - solution 2: Use multiply instead when exponent is low. 
  - solution 3: When 2 is radix, use bit shifting
  - solution 4: Implement in-house pow for integers based on divide and conquer

##### Sqrt <a id="algo-math-sqrt"></a>

##### Divide <a id="algo-math-divide"></a>
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

##### Multiply <a id="algo-math-multiply"></a>

##### Prime <a id="algo-math-prime"></a>
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

#### Bit manipulation <a id="algo-bit-manipulation"></a>
##### Arithmetic vs logic right shift <a id="algo-bit-manipulation-arithmetic-vs-logic"></a>
  * Arithmetic right shift >>, shift bits to the right but fill in the new bits with the value of the sign bit
  * Logic right shift >>>, shift bits to the right but fill in the new bits with 0.

##### Common tasks <a id="algo-bit-manipulation-common-tasks"></a>
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

#### Non-DP Memorization <a id="algo-non-dp-memorization"></a>
##### Array <a id="algo-non-dp-memo-array"></a>
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

##### Stack <a id="algo-non-dp-memo-stack"></a>
* Maintain inc/dec sequences
  + Example problems: min stack, trapping rain water, largest rectangle in histogram, longest valid parentheses

##### HashMap <a id="algo-non-dp-memo-hashmap"></a>
* Maximum size subarray sums to K, clone graph, two sum

#### Two pointers <a id="algo-two-pointer"></a>
##### Begin and end type <a id="algo-boundary-to-center"></a>
* Two sum type
  - example problems: two sum (sorted), three sum, four sum, three sum closest, three sum smaller
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

##### Slow and fast type <a id="algo-slow-and-fast"></a>
* Find the middle of linked list
* Find linked list cycle

##### Window type <a id="algo-window"></a>
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

##### Two arrays type <a id="algo-two-arrays"></a>
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

#### Sort <a id="algo-sort"></a>
##### Common sorting algorithms <a id="algo-sort-common-algo"></a>

| Algorithm | memory    | Use case  | 
| --------------------- |:---------:| -----:|  
| Mergesort  | O(1)     | external sorting / stable |
| Quicksort  | O(n)     |  usually the quickest O(nlogn) / unstable sort |
| Heapsort   | O(1)     |  unstable sort |
| Bucketsort | O(1)     |  when knowing range and evenly distributed O(n+k) |

##### Built-in sort interfaces <a id="algo-built-in-sort-interfaces"></a>
* Sort interfaces: Arrays.sort( array, comparator ) Collections.sort( collection, comparator ) method, list.sort( comparator )

##### Types <a id="algo-sort-types"></a>
* Interval-related<a id="algo-sort-types-interval-related"></a>
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

##### Top K<a id="algo-sort-types-topK"></a>
##### Stream API<a id="algo-sort-types-stream-API"></a>
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

#### Binary search <a id="algo-binary-search"></a>
##### Best practices <a id="algo-binary-search-best-practices"></a>
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
##### How to handle duplicates <a id="algo-binary-search-handle-duplicates"></a>

##### Types <a id="algo-binary-search-types"></a>
* First/Last smaller/bigger than target <a id="algo-binary-search-first-last-smaller-bigger"></a>

* Rotated array <a id="algo-binary-search-rotated-array"></a>

* Two dimensional array <a id="algo-binary-search-2d-array"></a>

#### Recursive functions <a id="algo-recursion"></a>
##### Recursive vs iterative solutions <a id="algo-recursive-iterative"></a>
  - Recursive algo can be very space inefficient. Each recursive call adds a new layer to the stack. If the algorithm recurses to a depth of n, it uses at least O(n) space.
  - All recursive algo can be implemented iteratively, although sometimes the code is more complex. 
  - Before diving into writing recursive code, ask myself how hard it would be to implement iteratively and discuss tradeoffs with your interviewer.

##### Recursion time complexity cheat sheet <a id="algo-recursive-tc"></a>

| Recurrence | Algorithm           | Big-O Solution  |
| --------------------- |:-------------:| -----:|
| T(n) = T(n/2) + O(1)  | Binary search | O(lgn) |
| T(n) = T(n-1) + O(1)  | Sequential search      |   O(n) |
| T(n) = 2T(n/2) + O(1) | Tree traversal      |  O(n) |
| T(n) = 2T(n/2) + O(n) | Merge sort      |    O(nlogn) |
| T(n) = T(n-1) + O(n)  | Selection sort      |  O(n^2) |


##### Steps in using recursion <a id="algo-recursion-problems-to-consider"></a>
  - What does the recursive function do?
    + Take what parameters
    + Do what
    + return what value and how
  - How does big problems recurse to smaller ones
  - Initialization
  - Prunning

##### How to return multiple results from recursive functions<a id="algo-recursion-return-multiple-results"></a>
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

##### Avoid duplicated recursion <a id="algo-recursion-avoid-duplicated-recursion"></a>
* ensuring that the never two recursion tree branches overlap 
```java
if ( i > 0 && candidates[i] == candidates[i-1] )
{
  i++;
  continue;
}
// invoking functions based on index i
```
##### Types <a id="algo-recursion-types"></a>

* Tree-based recursion <a id="algo-recursion-tree-based"></a>
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

* Deep copy <a id="algo-backtrack"></a>
  - Key points: Use a hashmap to store old to new reference mapping
  - Examples: Clone graph, Copy list with random pointer

* Array-based recursion <a id="algo-recursion-array-based"></a>

#### Backtrack <a id="algo-backtrack"></a>
##### Best practices <a id="algo-backtrack-best-practices"></a>
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

##### Types <a id="algo-recursion-types"></a>
* Generate all unique permutations <a id="algo-backtrack-permutation"></a>
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
* Generate all subsets <a id="algo-backtrack-subsets"></a>
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
* Generate all combinations summing to a target <a id="algo-backtrack-combination-sum"></a>
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
* Generate Decode ways / Gray code<a id="algo-backtrack-generate-decode-ways"></a>
* Grid-based <a id="algo-backtrack-grid-based"></a>

#### Graph <a id="algo-graph"></a>
##### Grid-based graph best practices <a id="algo-grid"></a>
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

##### Grid-based breath first search <a id="algo-grid-based-bfs"></a>
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
  
##### Grid-based depth first search <a id="algo-grid-based-dfs"></a>
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

##### Count number of components <a id="algo-grid-based-count-number-of-components"></a>
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

##### Word-based breath first search <a id="algo-word-based-bfs"></a>
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

##### Topological sort <a id="algo-topo"></a>
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

##### Union find <a id="algo-union-find"></a>
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

#### Greedy <a id="algo-greedy"></a>
* Usually greedy algo are not covered in an interview setting:
  - Greedy algo do not generalize as a useful way to decompose and solve problems. 
  - Naive greedy algo are usually "short sighted" algo, which will not lead to global maximal. Working greedy algo are usually hard to think of. 
* But there are exceptions
  - Increasing triplet sequence, paint house II

#### Dynamic-programming <a id="algo-dynamic-programming"></a>
* Use cases: <a id="algo-dp-use-cases"></a>
  - When to use - optimize time complexity from O(n!,2^n) to O(n^2, n^3)
    + Calculate max or min
    + Calculate the number of solutions
    + Calculate whether it is true or not
  - When not to use - optimize time complexity from O(n^3, n^2) further
    + Calculate concrete solutions themselves rather than just the number of solutions
    + Input is a collection rather than a sequence (e.g. Longest consecutive sequence)
* Problems to consider: <a id="algo-dp-problems-to-consider"></a>
  - State: how to define dp[i] or dp[i][j]
  - Induction rule: how to calculate big problems into smaller ones
  - Initialization: starting point
  - Answer: ending point
* Implementation methods: <a id="algo-dp-implementation-methods"></a>
  - Multi-loop: bottom-up approach
  - Memorized search: top-down approach
  - Use cases:
    + In most cases, both of them can be applied. Could start with bottom-up approach because it is usually more concise. 
    + But some times memorized search is more appropriate
      * When it is easier to start thinking from the last step rather than the first step. Example: Burst ballons, Stone-game (Lintcode)
      * When the induction rule is not sequential, thus hard to define.  Example: Longest increasing subsequences in 2D (Lintcode)
      * When the initialization state is hard to find. Example: Longest increasing subsequences in 2D (Lintcode)
* Memorization array tricks <a id="algo-dp-memorization-array-tricks"></a>
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

* Type: <a id="algo-dp-types"></a>
  - Coordinate based <a id="algo-dp-types-coordinate"></a>
    + Patterns:
      * state: f[x,y] represents goes to x,y position from starting point
      * induction rule: f[x,y] from f[x-1, y] or f[x, y-1]
      * initialization: f[0,0~width], f[0~height, 0]
      * answer: usually f[m,n]
    + Examples: Minimum Path Sum, Unique Path I�, Climbing stairs, Jump game I/II
  - 1D sequence <a id="algo-dp-1d-sequence"></a>
    + Patterns:
      * state: f[i] represents first i position, digits, characters
      * induction rule: f[i] from f[j], j < i
      * initialize: f[0] = 0, f[1]
      * answer: f[n]
    + Examples: Longest increasing subsequence, Word break I, House robber
  - 2D sequences <a id="algo-dp-2d-sequences"></a>
    + Patterns: 
      * state: f[i,j] represents the results of first i numbers/characters in sequence one matching the first j numbers/characters in sequence two
      * induction rule: how to decide f[i,j] from previous (varies a lot here)
      * initialize: f[0,i] and f[i,0]
      * answer: f[n,m]( n = s1.length(), m = s2.length() )
    + Examples: Edit distance, Regular expression matching, Longest common subsequences, Maximal rectangle/Square
  - Range based <a id="algo-dp-range-based"></a>
    + Patterns:
      * state: f[i,j] represents whether the substring from i to j is a palindrome
      * induction rule: f[i,j] = f[i+1,j-1] && (s[i] == s[j])
      * initialize: f[i][i] = true, f[i][i+1] = s[i] == s[i+1]
      * answer: f[0,n]
    + Examples: Palindrome partition II, Coins in a line III (Lintcode), Stone game, Burst ballons, Scramble string 
  - Game <a id="algo-dp-game"></a>
    + Patterns:
      * state: f[i] represents win/lose max/min profit for the first person
      * induction rule: avoid defining second person's state because second person always tries his best to defeat first person/make first person profit least.
      * initialize: varies with problem
      * answer: f[n]
    + Examples: Coin in a line (Lintcode), Coin in a line II (Lintcode), Flip game II
  - Backpack <a id="algo-dp-backpack"></a>
    + Patterns:
      * state: f[i][S]: whether the first i items could form S/Max value/number of ways
      * induction rule: varies with problems
      * initialize: varies with problems
      * answer: varies with problems
    + Examples: Backpack I-VI (Lintcode), K Sum (Lintcode), Minimum adjustment cost (Lintcode)

#### References <a id="references"></a>
* [Java-success.com](http://www.java-success.com/)
* [Massive tech interview](http://massivetechinterview.blogspot.com/)
* [Java best practices](http://www.javapractices.com/home/HomeAction.do)
* [Java revisited](http://javarevisited.blogspot.com/)
* [Programming interview](http://www.programmerinterview.com/)
* [Java67](http://www.java67.com/)