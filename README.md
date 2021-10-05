# leetcode/README.md at master · DreamOfTheRedChamber/leetcode



* Leetcode
  * Typical whiteboard coding workflow
    * Clarify question
    * Give a small but general enough example for discussing algo/DS
    * Come up with a brute force algorithm
    * Optimize the brute force solution
    * Write test cases
    * Write code
    * Walk through test cases
    * Solve follow up questions
  * Interview mindset
    * Understanding what interviewers really wants
    * Checklist
      * Things to be careful.
      * Phone interviews
      * Onsite interviews
    * Interview mistakes made in past
    * Whiteboard coding pros and cons
  * Practice mindset
    * Goal
    * Attitudes
    * Tools
    * Strategies
    * Leetcode pros and cons
  * Python data structures
    * Collections \[TODO\]
      * Compare heapq and SortedList complexity \[TODO\]
      * Sort comparator \[TODO\]
    * Type conversions
      * int and char
  * LeetCode problem types
    * Two Pointers
      * Sliding window
      * Begin and end type
        * Greedy
      * Partition type
      * Slow and fast
      * Window type
      * Sliding window : Distinct Characters
      * Two pointers for two seuqences
    * Binary Search
      * Binary Processing
      * Binary Search by Value
    * Hash Table
      * LRU cache implementation
      * Hash+Prefix
    * Heap
    * Tree
      * Serialization & Hashing
      * Tree & Sequence
      * LCA
      * N-ary Tree
      * 似树非树
    * Segment Tree
      * Basics
      * Lazy Tag
      * Others
    * \[Binary Index Tree\]
    * Design
    * Stack
      * monotonic stack
      * parse expression
      * Calculator
      * Parentheses \[TODO\]
    * Deque
    * Priority Queue
      * Sort+PQ
      * Arrangement with Stride
    * Graph \[TODO\]
      * Edge list vs Adjacent list vs Adjacent matrix
    * DFS
      * search in an array
      * memorization
    * BFS
      * Multi State
      * 拓扑排序
      * Dijkstra \(BFS+PQ\)
    * Trie
      * Trie and XOR
    * Linked List
      * Dummy node trick
      * Common tasks
    * Dynamic Programming
      * 基本型 I
      * 基本型 II
      * 走迷宫型
      * 背包型
      * 键盘型
      * To Do or Not To Do
      * 区间型 I
      * 区间型 II
      * 双序列型
      * 状态压缩DP
      * Catalan
      * Permutation
    * Bit Manipulation
      * Common tasks
      * XOR
      * Bit Mask
    * Divide and Conquer
    * String
      * Rolling Hash
      * KMP
      * Manacher
      * Palindrome
    * Union Find
      * Prime Factors
      * MST
    * Recursion
      * Min-Max Strategy
    * Graph
    * Math
      * Distances
      * Geometry
      * Random Pick
      * Combinatorics
      * Numerical Theory
    * Greedy
      * LIS
      * Two-pass distribution
      * Three-pass
      * State Machine
      * Sort
      * Indexing Sort
      * Parenthesis
      * Intervals
        * Maximum number of non-overlapping intervals - sort by ending points
          * Interval + DP + Binary search
        * Minimum number of intervals to cover the whole range - sort by starting points
      * Constructive Problems
    * Others
      * 扫描线 / 差分数组
      * Enumeration
      * Presum
      * Quick Select
    * LeetCode Cup
    * Templates
  * Online IDE templates
    * Coderpad

## Leetcode

### Typical whiteboard coding workflow

#### Clarify question

1. Define public APIs to be implemented:
   * Things to define - Input type
   * Things to define - Number of input arguments
   * Things to define - Output type
     * boolean: Whether solutions exist or not
     * int: the number of solutions
     * List&lt;?&gt; : solutions themselves
     * List&lt;?&gt;: solutions without duplicates
     * List&lt;?&gt;: solutions with specific order
2. Clarify ambiguous problem statements / Gather all requirements
   * Solution existence: "_**What if no solution exists? How should I handle that?**_"
   * Solution uniqueness: "_**Whether there are multiple solutions?**_"
   * Input emptiness: "_**How should I handle null pointers and input of size zero?**_"
   * Input validity: "_**Could I assume input is always invalid?**_" 
   * Input types:
     * Typical scenarios
       * In most cases, one single public API
       * Multiple public APIs inside a class
       * Two associated APIs, like serialize and deserialize
     * Input - Field types
       * Integer or double
       * Positive or negative, non-positive or non-negative
     * Input - Array
       * Sorted or unsorted, sorted increasingly or decreasingly
       * Given two arrays, which one's size is bigger
       * Whether could modify entries inside array
     * Input - String
       * Whether the string contains space
       * How are tokens separated, using comma, slash or something else
       * Alphabetic characters\(lower/upper case\), ascii characters, or unicode characters  
     * Input - LinkedList
       * Doubly or singly linkedlist
     * Input - Tree
       * Binary tree
       * Binary search tree
       * Complete tree
     * Input - Graph
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
   * Edge cases: "_**If input is like this, then what should I output?**_"

#### Give a small but general enough example for discussing algo/DS

* Usually a size of 4~5 is enough.

#### Come up with a brute force algorithm

1. Synchronize with interviewer "_**Let's come up with a brute force solution first.**_"
2. Unstuck strategy:
   1. The most straightforward way to list all possible solutions
   2. Whether I could decompose the problem into subproblems and solve them individually
      * Divide and conquer "_**The problem could be decomposed into X subproblems.**_"
   3. Brainstorm DS/Algo which might be used / Give it a try
      * Give it a try: "_**Let's try a graph-based solution**_"
3. Talk about the data structures to be used.
4. Talk about the algorithm to be used.
5. Calc time/space complexity: "_**The time complexity of the algorithm is O\(XXX\) and space complexity is O\(XXX\)**_"

#### Optimize the brute force solution

1. Synchronize with interviewer "_**The time/space complexity of the brute force solution is too high and will be impractical.**_"
2. Consider the typical optimizing patterns below:
   1. Where the bottleneck is: "_**The bottleneck of the algorithm lies in this section of code**_"
   2. What the time complexity upper bound is: "_**Theoretically, the best time complexity I could achieve is O\(n\) because I need to look through all items.**_"
   3. Whether space complexity is acceptable or not: "_**algo with linear space complexity is usually acceptable.**_"
   4. Repetitive computation: "_**We solve a lot of repetitive problems. If we could cache the solutions, it will be much more efficient.**_"
   5. Additional rounds of iterating input: "_**We iterate through input twice. If we could reduce it to once, it will boost performance twice.**_"
3. Synchronize with interviewer "_**The reason we could do better is XXX**_."
4. Ask for help when being stuck
   1. Show interviewer all the approaches you tried and difficulties. ""
   2. Be keen to what interviewer is saying: Every word the interviewer is saying has its meanings. ""
5. Synchronize with interviewer "_**Do you have any concerns for the proposed algorithm? Should we write code for this**_."

#### Write test cases

* In general, the following types of test cases should be considered 
  * The normal case: e.g. array length of even or odd in sorting algo
  * The extremes: e.g. empty array, one element array, extremely large one array
  * Nulls and "illegal" input: e.g. input is negative when positive is expected 
  * Strange input: an array already sorted
* Typical test cases for different input types
  * Integer
    * Integer.MAX\_VALUE, Integer.MIN\_VALUE
    * 0
    * Positive/negative numbers
  * String
    * NULL
    * Single character
    * Two characters
    * Contains duplicated characters
    * Contains space, tab or other separators
  * Array/List &lt;?&gt; list
    * NULL
    * One element List/Array
    * List/Array entry is NULL
    * List/Array of even length
    * List/Array of odd length

#### Write code

1. Synchronize with interviewer "_**There are XXX steps in this algorithm. The first is XXX. The second....**_"
2. Check input validity \(already discussed thoroughly before\)
3. Use // or empty line to separate different steps and a place to synchronize with interviewer.
4. Just get the general algorithm down first and avoid getting caught up in trivialities
   * When forget some language-specific trivial
     * "_**I do not remember exactly how the interface looks like, but I'd guess it has an API like this.**_"
   * When need implement a large code block, or nested for/while loop, or repeated needed util methods, consider using a subroutine
     * "_**I am going to use a subroutine with the following interface. I will implement later**_".
   * When need double check trivials \(like +1 or plus two, loop termination conditions \): 
     * "_**Not sure whether my loop should have "&lt;" or "&lt;=". Write a checkmark to remind yourself to figure out the details at the end.**_""

#### Walk through test cases

1. Synchronize with interviewer: "_**Then I would usually check my code against tests**_" 
2. Check the code by myself
   * Check steps:
     1. Look for typos
     2. Look for unused variables, counters, unnecessary edge case checkings, boundaries index overflow/underflow 
     3. Look for unhandled problem assumptions
     4. Use small test cases to test different logical branches of the code
   * When there is a bug: do not rush to change. Identify the root cause first.
     * "_**Give me a moment, I feel there is a bug here. Let's have a double check.**_"
     * "_**The root cause of the problem is XXX.**_"
3. Explain shortcuts I have taken: Talk about sections which could be refactored/improved, but was done in a certain way in an interview setting
   * Bad smells for refactoring and optimization 
     * Code/function length &gt; 100
     * Too many if statement checking for boundary cases
     * Code do not generalize well. Only work for current problem. e.g. merge 2 sorted list -&gt; merge k sorted List
     * Nested while loops \( really error prone \)
     * Global variables
4. Synchronize with interviewer: "_**I think I am done with the problem**_".

#### Solve follow up questions

* Typical follow-up questions
  * No duplicates -&gt; duplicates exist
  * Whether result exist -&gt; return all results
  * One dimension -&gt; two dimension
  * How to avoid global variables
  * How to improve performance

### Interview mindset

#### Understanding what interviewers really wants

* Evaluation criteria
  * Can s/he explain technical solutions well?
  * Does s/he understand basic concepts well?
  * Does s/he has a good grasp of past project experiences?
  * How is his/her attitude?
  * Is s/he a good coder? \(proficiency in leetcode and whether error-prone\)
* What are interviewers really asking

<table>
  <thead>
    <tr>
      <th style="text-align:left">What they ask</th>
      <th style="text-align:left">Wrong response</th>
      <th style="text-align:left">What they really want</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left">Tell me what you did for this project</td>
      <td style="text-align:left">
        <p>Describe the process in chronological order</p>
        <p>Recites what&apos;s on their resume</p>
      </td>
      <td style="text-align:left">
        <p>What are you able to do after completing this project4</p>
        <p>How did you overcome obstacles</p>
        <p>Details that are not on your resume</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Tell me what you did for this job</td>
      <td style="text-align:left">
        <p>Describe major projects</p>
        <p>Describe daily tasks</p>
      </td>
      <td style="text-align:left">
        <p>Were you able to learn quickly</p>
        <p>Did you add enough value at your previous job to prove that you can add
          value for me</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Compare data structure A and B</td>
      <td style="text-align:left">
        <p>Explain what A and B are respectively</p>
        <p>List 1 difference between them</p>
      </td>
      <td style="text-align:left">
        <p>Does your explanation show that you have actually used them in a real
          project</p>
        <p>Explain real situations where you would use A vs B.</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Write code to solve problem</td>
      <td style="text-align:left">
        <p>Jumps into writing code</p>
        <p>Awkward silence</p>
      </td>
      <td style="text-align:left">
        <p>Would I want to work with them everyday</p>
        <p>Have they actually written production grade code</p>
        <p>What do they do when stuck</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Maybe you could try this ...</td>
      <td style="text-align:left">Take advice without serious thinking</td>
      <td style="text-align:left">
        <p>Do they think independently</p>
        <p>How fast can they absord new information</p>
        <p>Do they take advice/directions well</p>
        <p>Do they learn quickly and run with it</p>
      </td>
    </tr>
  </tbody>
</table>

#### Checklist

**Things to be careful.**

* Do not just give "yes" or "no" answers. Limit initial explanation to short summaries and allow the interviewer to ask follow up questions.
* Your tone of voice and word choice. Interviewers use voice to judge how believable you are. Posture really have impact on your mind.
* Eye contact and shake hands. Say thanks to interviewers at last. 

**Phone interviews**

* Test the online coding environment.
* Make sure your cellphone has enough battery.
* Have a copy of resume in front of you.
* Take notes and write a follow up thank you email with details from the discussion.

**Onsite interviews**

* Show up 15 minutes early and have the interviewer's phone number for last minute changes.
* Things to bring with you
  * Identity card.
  * Bring extra copies of your resume with you - for the interviewer and your own reference.
  * Notes on the detailed schedule. Put interviewers' names and interview topic on a sticker and bring it with me. 
  * Tea/Coffee.
  * Whiteboard pen and erasers.
  * A piece of pen and paper. Take notes when an interviewer speaks to help yourself focus and ask more specific questions. 
  * Computers for last minute warm-up. 

#### Interview mistakes made in past

* Too nervous: When I become too nervous, I just could not speak. This is the number one red flag during interviews. No one wants to work with people who cannot speak.
* Ignore first impression importance: Don't smile/handshake/look into interviewers' eyes.
* Wrong expectations about interviewers: You need to acknowledge that there are so many different types of interviewers. Some like to follow rules but others don't. For example, expecting all algorithm interview questions are under leetcode's company tag or from past interview experiences in 1acre3points is not practical. Some interviewers are bored with Leetcode and really want to ask unique questions to truely evaluate interviewees.
* Anxious because too many things need to be prepared: Always prioritize and then act. You just cannot practice every possible question before interviews because there are too many. What you can do is to practice typical problems under each category and practice the most popular interview questions. Make sure that you practice each problem as if you are interviewing.
* Preparation time allocation: 70% should be on coding. 15% on system design. 15% on behavior questions.
* Do not go straight to coding during interviews, give yourself a minute to think before speak. Thought well before speak and coding.
* I am used to good words. When interviewer doubts/challenges me, I become kind of sad. Always stay in calm and smiles. 
* Give myself a little break between interviews. Either sit down or drink some beverages. 
* When interviewers keep interrupting me, do not be nervous. They are trying to help me!!! Always stay in calm and take their hints. No matter whether I could finish my current solution. Communication is the most important thing. 
* Preparing interview: What really matters is how many times you practice the leetcode problem, rather than how long you spend during a single practice round.

#### Whiteboard coding pros and cons

* Pros
  * Every software engineer knows algo and data structures. It provides a common domain for interviewers and interviewees to discuss.
  * Smart people will always be smart wherever they go. There are just too many candidates there and there needs a way to differentiate it. At least, whiteboard coding could reflect candidates' understanding of algo/data structures and communication skills.
  * Whiteboard coding advocates a good workflow for developing code.
* Cons
  * The most important capability for a software engineer is abstraction and skipping complexity. algo questions are usually available in many online forums. Even if candidates could finish the problem in interview, it does not necessarily demonstrate the core perspective here. It might generate high false positives and false negatives. 
  * Finish algo in 20 min in a bug-free and clean way requires lots of practice. It does not only require interviewee to understand algo and data structures, but also really proficient in these, sometimes even remember pretty tricky test cases. 
  * The optimization process in algorithm questions is kind of over-optimization. In practice, only improve performance when necessary.
  * Stand and write code on whiteboard is really exhausting if lasting for 4-5 hours.

### Practice mindset

#### Goal

* Proficiency: Given an original Leetcode problem you should be able to finish it no more than 10 minutes no matter what its difficulty level is.
* Understanding: You should be able to start from brute force solution, discuss tradeoffs along the way and optimize to a solution the interviewer is satisfied with.
* Cleaness: No interview code should be longer than 100 lines. In most cases it is within 50 lines. Keep optimizing your code until it is short enough. 

#### Attitudes

* This might be the last time in my life that I spent so much time and efforts in algorithm questions. Next time when I hunt for jobs, either HRs will invite me or I will have far less time to prepare.
* An interview is a matter of preparation. To enable yourself explain solutions well and code in a bug free way, you need to practice a lot. 
* The way an engineer approach a algorithm problem can reflect their efficiency at work. 
* Hiring system is broken. But currently there is no better way to do it.

#### Tools

* Task planning: Use tags \( TO\_START, TO\_HURRY, TO\_TEST \) to manage algorithm question status and prioritize important tasks
* Feedbacks: Use git commit number per day as feedback for progress
* Summarizing lessons: Use git commit message as a place to learn from mistakes and summarize lessons

#### Strategies

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

#### Leetcode pros and cons

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
    * Unable to mark different stages in solving a problem \( e.g. thought-out, implemented, optimized, on-line judged, summarized \)
    * Cannot add enough comments along the code
    * Could not search problems by specifying multiple tags
    * Function names do not follow best practices, which makes variables naming kind of difficult.

### Python data structures

#### Collections \[TODO\]

| `data type` | `Original` | `Improved` |
| :--- | :---: | ---: |
| priorityQueue | heapq.\* methods | SortedList |
| list / stack / queue | \[\] |  |
| deque | deque |  |
| dictionary | dict | defaultdict |

**Compare heapq and SortedList complexity \[TODO\]**

**Sort comparator \[TODO\]**

* Pass comparator to Sorted\(\) and sort\(\)
* Pass comparator to SortedContainers 

#### Type conversions

**int and char**

* ord: int to char
* char: char to int

### LeetCode problem types

#### [Two Pointers](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers)

[011.Container-With-Most-Water](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/011.Container-With-Most-Water) \(M+\)  
[015.3Sum](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/015.3Sum) \(M\)  
[016.3Sum-Closet](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/016.3Sum-Closest) \(M\)  
[018.4Sum](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/018.4Sum) \(M\)  
[259.3Sum-Smaller](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/259.3Sum-Smaller) \(M+\)  
[030.Substring-with-Concatenation-of-All-Words](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/030.Substring-with-Concatenation-of-All-Words) \(H\)  
[075.Sort-Colors](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/075.Sort-Colors) \(M+\)  
[026.Remove Duplicates from Sorted Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/026.Remove-Duplicates-from-Sorted-Array) \(H-\)  
[080.Remove Duplicates from Sorted Array II](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/080.Remove-Duplicates-from-Sorted-Array-II) \(H\)  
[209.Minimum-Size-Subarray-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/209.Minimum-Size-Subarray-Sum) \(M\)  
[088.Merge Sorted Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/088.Merge-Sorted-Array) \(M\)  
[283.Move-Zeroes](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/283.Move-Zeroes) \(M\)  
[141.Linked-List-Cycle](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/141.Linked-List-Cycle) \(E+\)  
[142.Linked-List-Cycle-II](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/142.Linked-List-Cycle-II) \(M+\)  
[360.Sort-Transformed-Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/360.Sort-Transformed-Array) \(M\)  
[713.Subarray-Product-Less-Than-K](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/713.Subarray-Product-Less-Than-K) \(M+\)  
[923.3Sum-With-Multiplicity](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/923.3Sum-With-Multiplicity) \(H-\)  
[1234.Replace-the-Substring-for-Balanced-String](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1234.Replace-the-Substring-for-Balanced-String) \(H-\)  
[1498.Number-of-Subsequences-That-Satisfy-the-Given-Sum-Condition](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1498.Number-of-Subsequences-That-Satisfy-the-Given-Sum-Condition) \(H-\)  
[1574.Shortest-Subarray-to-be-Removed-to-Make-Array-Sorted](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1574.Shortest-Subarray-to-be-Removed-to-Make-Array-Sorted) \(H-\)  
[1687.Delivering-Boxes-from-Storage-to-Ports](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1687.Delivering-Boxes-from-Storage-to-Ports) \(H\)  
[1793.Maximum-Score-of-a-Good-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1793.Maximum-Score-of-a-Good-Subarray) \(M+\)

**Sliding window**

[532.K-diff-Pairs-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/532.K-diff-Pairs-in-an-Array) \(H-\)  
[611.Valid-Triangle-Number](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/611.Valid-Triangle-Number) \(M+\)  
[1004.Max-Consecutive-Ones-III](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1004.Max-Consecutive-Ones-III) \(M\)  
[1052.Grumpy-Bookstore-Owner](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1052.Grumpy-Bookstore-Owner) \(M\)  
[1838.Frequency-of-the-Most-Frequent-Element](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1838.Frequency-of-the-Most-Frequent-Element) \(H-\)  
[395.Longest-Substring-with-At-Least-K-Repeating-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/395.Longest-Substring-with-At-Least-K-Repeating-Characters) \(H\)  
[1763.Longest-Nice-Substring](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1763.Longest-Nice-Substring) \(H\)

**Begin and end type**

* example problems: two sum \(sorted\), three sum, four sum, three sum closest, three sum smaller

```python
if A[i] and A[j] satisfy some condition:
  j--; // do not need to consider pairs composed of [i+1, j-1] and j
  // do something
elif A[i] and A[j] do not satisfy some condition:
  i++; // do not need to consider pairs composed of [i+1, j-1] and i
  // do something
else:
  // do something
  i++ or j--
```

* Example problem: KSum

```python
def kSum(kVal: int, target: int, startIndex: int, nums: List[int]) -> List[List[int]]:
  result = []
  if kVal == 0:
    if target == 0:
      result.append([]);
    return result;

  for i in range(startIndex, len(nums) - kVal + 1):
    if (i > startIndex) and (nums[i] == nums[i - 1]):
      continue;

    for partialResult in kSum( kVal - 1, target - nums[i], i + 1, nums )
        partialResult.add( 0, nums[i] );
        result.add( partialResult );

  return result;
```

**Greedy**

* Squeeze the biggest first [1580.Put-Boxes-Into-the-Warehouse-II](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1580.Put-Boxes-Into-the-Warehouse-II) \(H-\)  
* Put in the first [1798.Maximum-Number-of-Consecutive-Values-You-Can-Make/Readme.md](https://github.com/wisdompeak/LeetCode/blob/master/Greedy/1798.Maximum-Number-of-Consecutive-Values-You-Can-Make) \(H-\)

**Partition type**

* example problems: two sum \(sorted\), three sum, four sum, three sum closest, three sum smaller

```python
# int[] input, int left, int right
pivot = input[(left+right)/2];
while i <= j:
    while input[i] < pivot:
        i++

    while input[j] > pivot:
        j--

    if i <= j:
        swap(data, i, j);
        i++;
        j--;
```

**Slow and fast**

* Find the middle of linked list
* Find linked list cycle

**Window type**

* Improve naive two level for loop to for-outer loop + while inner loop
* E.g. minimum window substring, minimum size subarray sum, Longest substring with at most K distinct characters, Longest substring without repeating characters

```python
for i in range(n):
  while j < n:
    # update j status
    if satisfy some condition:
      j++
    else:
      break
  }
}
```

**Sliding window : Distinct Characters**

[076.Minimum-Window-Substring](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/076.Minimum-Window-Substring) \(M+\)  
[003.Longest-Substring-Without-Repeating-Character](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/003.Longest%20Substring%20Without%20Repeating%20Characters) \(E+\)  
[159.Longest-Substring-with-At-Most-Two-Distinct-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/159.Longest-Substring-with-At-Most-Two-Distinct-Characters)\(H-\)  
[340.Longest-Substring-with-At-Most-K-Distinct-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/340.Longest-Substring-with-At-Most-K-Distinct-Characters) \(H\)  
[992.Subarrays-with-K-Different-Integers](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/992.Subarrays-with-K-Different-Integers) \(H-\)

**Two pointers for two seuqences**

[986.Interval-List-Intersections](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/986.Interval-List-Intersections) \(M\)  
[1229.Meeting-Scheduler](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1229.Meeting-Scheduler) \(M+\)  
[1537.Get-the-Maximum-Score](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1537.Get-the-Maximum-Score) \(H-\)  
[1577.Number-of-Ways-Where-Square-of-Number-Is-Equal-to-Product-of-Two-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1577.Number-of-Ways-Where-Square-of-Number-Is-Equal-to-Product-of-Two-Numbers) \(H-\)  
[1775.Equal-Sum-Arrays-With-Minimum-Number-of-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1775.Equal-Sum-Arrays-With-Minimum-Number-of-Operations) \(M+\)  
[1868.Product-of-Two-Run-Length-Encoded-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/Two_Pointers/1868.Product-of-Two-Run-Length-Encoded-Arrays) \(M+\)

#### [Binary Search](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search)

[004.Median-of-Two-Sorted-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/004.Median-of-Two-Sorted-Arrays) \(H\)  
[153.Find-Minimum-in-Rotated-Sorted-Array](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/153.Find-Minimum-in-Rotated-Sorted-Array) \(M+\)  
[154.Find-Minimum-in-Rotated-Sorted-Array-II](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/154.Find-Minimum-in-Rotated-Sorted-Array-II) \(H-\)  
[033.Search-in-Rotated-Sorted-Array](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/033.Search-in-Rotated-Sorted-Array) \(M\)  
[081.Search-in-Rotated-Sorted-Array-II](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/081.Search-in-Rotated-Sorted-Array-II) \(M\)  
[034.Search-for-a-Range](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/034.Search-for-a-Range) \(M\)  
[162.Find-Peak-Element](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/162.Find-Peak-Element) \(H-\)  
[222.Count-Complete-Tree-Nodes](https://github.com/wisdompeak/LeetCode/tree/master/Tree/222.Count-Complete-Tree-Nodes) \(H-\)  
[275.H-index II](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/275.H-Index-II) \(H\)  
[302.Smallest-Rectangle-Enclosing-Black-Pixels](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/302.Smallest-Rectangle-Enclosing-Black-Pixels) \(M+\)  
[410.Split-Array-Largest-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/410.Split-Array-Largest-Sum) \(H\)  
[475.Heaters](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/475.Heaters) \(H-\)  
[483.Smallest-Good-Base](https://github.com/wisdompeak/LeetCode/blob/master/Binary_Search/483.Smallest-Good-Base) \(H\)  
[029.Divide-Two-Integers](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/029.Divide-Two-Integers) \(M+\)  
[644.Maximum-Average-Subarray-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/644.Maximum-Average-Subarray-II) \(H\)  
[658.Find-K-Closest-Elements](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/658.Find-K-Closest-Elements) \(H\)  
1095.Find-in-Mountain-Array \(TBD\)  
[1157.Online-Majority-Element-In-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1157.Online-Majority-Element-In-Subarray) \(H-\)  
1201.Ugly-Number-III \(TBD\)  
[1533.Find-the-Index-of-the-Large-Integer](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1533.Find-the-Index-of-the-Large-Integer) \(M\)  
[1712.Ways-to-Split-Array-Into-Three-Subarrays](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1712.Ways-to-Split-Array-Into-Three-Subarrays) \(H\)  
[1889.Minimum-Space-Wasted-From-Packaging](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1889.Minimum-Space-Wasted-From-Packaging) \(H-\)  
[1901.Find-a-Peak-Element-II](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1901.Find-a-Peak-Element-II) \(H\)

**Binary Processing**

[1483.Kth-Ancestor-of-a-Tree-Node](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1483.Kth-Ancestor-of-a-Tree-Node) \(H\)  
[1922.Count-Good-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1922.Count-Good-Numbers) \(M\)

**Binary Search by Value**

[215.Kth-Largest-Element-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/215.Kth-Largest-Element-in-an-Array) \(M\)  
[287.Find-the-Duplicate-Number](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/287.Find-the-Duplicate-Number) \(H-\)  
[378.Kth-Smallest-Element-in-a-Sorted-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/378.Kth-Smallest-Element-in-a-Sorted-Matrix) \(H-\)  
[373.Find-K-Pairs-with-Smallest-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/373.Find-K-Pairs-with-Smallest-Sums) \(H\)  
[668.Kth-Smallest-Number-in-Multiplication-Table](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/668.Kth-Smallest-Number-in-Multiplication-Table) \(H-\)  
[719.Find-K-th-Smallest-Pair-Distance](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/719.Find-K-th-Smallest-Pair-Distance) \(H-\)  
[774.Minimize-Max-Distance-to-Gas-Station](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/774.Minimize-Max-Distance-to-Gas-Station) \(H\)  
[786.K-th-Smallest-Prime-Fraction](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/786.K-th%20Smallest-Prime-Fraction) \(H-\)  
[793.Preimage-Size-of-Factorial-Zeroes-Function](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/793.Preimage-Size-of-Factorial-Zeroes-Function) \(H-\)  
[1011.Capacity-To-Ship-Packages-Within-D-Days](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1011.Capacity-To-Ship-Packages-Within-D-Days) \(M\)  
[1060.Missing-Element-in-Sorted-Array](https://github.com/wisdompeak/LeetCode/blob/master/Binary_Search/1060.Missing-Element-in-Sorted-Array) \(H\)  
[1102.Path-With-Maximum-Minimum-Value](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1102.Path-With-Maximum-Minimum-Value) \(H-\)  
[1539.Kth-Missing-Positive-Number](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1539.Kth-Missing-Positive-Number) \(H-\)  
[1201.Ugly-Number-III](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1201.Ugly-Number-III) \(H-\)  
[1231.Divide-Chocolate](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1231.Divide-Chocolate) \(M\)  
[1283.Find-the-Smallest-Divisor-Given-a-Threshold](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1283.Find-the-Smallest-Divisor-Given-a-Threshold) \(M\)  
[1292.Maximum-Side-Length-of-a-Square-with-Sum-Less-than-or-Equal-to-Threshold](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1292.Maximum-Side-Length-of-a-Square-with-Sum-Less-than-or-Equal-to-Threshold) \(H-\)  
[1300.Sum-of-Mutated-Array-Closest-to-Target](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1300.Sum-of-Mutated-Array-Closest-to-Target) \(M+\)  
[1439.Find-the-Kth-Smallest-Sum-of-a-Matrix-With-Sorted-Rows](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1439.Find-the-Kth-Smallest-Sum-of-a-Matrix-With-Sorted-Rows) \(H\)  
[1482.Minimum-Number-of-Days-to-Make-m-Bouquets](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1482.Minimum-Number-of-Days-to-Make-m-Bouquets) \(M\)  
[1508.Range-Sum-of-Sorted-Subarray-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1508.Range-Sum-of-Sorted-Subarray-Sums) \(M+\)  
[1552.Magnetic-Force-Between-Two-Balls](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1552.Magnetic-Force-Between-Two-Balls) \(M\)  
[1608.Special-Array-With-X-Elements-Greater-Than-or-Equal-X](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1608.Special-Array-With-X-Elements-Greater-Than-or-Equal-X) \(M+\)  
[1648.Sell-Diminishing-Valued-Colored-Balls](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1648.Sell-Diminishing-Valued-Colored-Balls) \(H-\)  
[1802.Maximum-Value-at-a-Given-Index-in-a-Bounded-Array](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1802.Maximum-Value-at-a-Given-Index-in-a-Bounded-Array) \(M+\)  
[1870.Minimum-Speed-to-Arrive-on-Time](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1870.Minimum-Speed-to-Arrive-on-Time) \(M\)  
[1898.Maximum-Number-of-Removable-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1898.Maximum-Number-of-Removable-Characters) \(H-\)  
[1891.Cutting-Ribbons](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1891.Cutting-Ribbons) \(E\)  
[1918.Kth-Smallest-Subarray-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1918.Kth-Smallest-Subarray-Sum) \(M+\)

#### [Hash Table](https://github.com/wisdompeak/LeetCode/tree/master/Hash)

[049.Group-Anagrams](https://github.com/wisdompeak/LeetCode/tree/master/Hash/049.Group-Anagrams) \(M+\)  
[149.Max-Points-on-a-Line](https://github.com/wisdompeak/LeetCode/tree/master/Hash/149.Max-Points-on-a-Line) \(H\)  
[166.Fraction-to-Recurring-Decimal](https://github.com/wisdompeak/LeetCode/tree/master/Hash/166.Fraction-to-Recurring-Decimal) \(M\)  
[170.Two-Sum-III-Data-structure-design](https://github.com/wisdompeak/LeetCode/tree/master/Hash/170.Two-Sum-III-Data-structure-design) \(M\)  
[392.Is-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/392.Is-Subsequence) \(H-\)  
[204.Count Primes](https://github.com/wisdompeak/LeetCode/tree/master/Hash/204.Count-Primes) \(M\)  
[274.H-Index](https://github.com/wisdompeak/LeetCode/tree/master/Hash/274.H-Index) \(H\)  
[325.Maximum-Size-Subarray-Sum-Equals-k](https://github.com/wisdompeak/LeetCode/tree/master/Hash/325.Maximum-Size-Subarray-Sum-Equals-k) \(M\)  
[409.Longest-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/Hash/409.Longest-Palindrome) \(M\)  
[447.Number-of-Boomerangs](https://github.com/wisdompeak/LeetCode/tree/master/Hash/447.Number-of-Boomerangs) \(E+\)  
[438.Find-All-Anagrams-in-a-String](https://github.com/wisdompeak/LeetCode/tree/master/Hash/438.Find-All-Anagrams-in-a-String) \(M+\)  
[356.Line-Reflection](https://github.com/wisdompeak/LeetCode/tree/master/Hash/356.Line-Reflection) \(H-\)  
[594.Longest-Harmonious-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/594.Longest-Harmonious-Subsequence) \(M+\)  
[532.K-diff-Pairs-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Hash/532.K-diff-Pairs-in-an-Array) \(E+\)  
[424.Longest-Repeating-Character-Replacement](https://github.com/wisdompeak/LeetCode/tree/master/Hash/424.Longest-Repeating-Character-Replacement) （H）  
[446.Arithmetic-Slices-II-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/446.Arithmetic-Slices-II-Subsequence) \(H\)  
[128.Longest-Consecutive-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/128.Longest-Consecutive-Sequence) \(H-\)  
[753.Cracking-the-Safe](https://github.com/wisdompeak/LeetCode/tree/master/Hash/753.Cracking-the-Safe) \(H\)  
[890.Find-and-Replace-Pattern](https://github.com/wisdompeak/LeetCode/tree/master/Hash/890.Find-and-Replace-Pattern) \(M+\)  
[939.Minimum-Area-Rectangle](https://github.com/wisdompeak/LeetCode/tree/master/Hash/939.Minimum-Area-Rectangle) \(M+\)  
982.Triples-with-Bitwise-AND-Equal-To-Zero \(M+\) \(TBD\)  
[1074.Number-of-Submatrices-That-Sum-to-Target](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1074.Number-of-Submatrices-That-Sum-to-Target) \(M+\)  
1224.Maximum-Equal-Frequency \(H-\)  
[1487.Making-File-Names-Unique](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1487.Making-File-Names-Unique) \(M+\)  
[1573.Number-of-Ways-to-Split-a-String](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1573.Number-of-Ways-to-Split-a-String) \(M\)

**LRU cache implementation**

* HashMap + DDL
* LinkedHashMap + manual removing oldest entry and reset
* LinkedHashMap \( access order + removeEldestEntry\(\) \)
  * Access order
    * When specified: The accessOrder flag is set when creating the LinkedHashMap instance using the LinkedHashMap\(int initialCapacity, float loadFactor, boolean accessOrder\) constructor
    * accessOrder=true: The elements are ordered according to their access: When iterating over the map the most recently accessed entry is returned first and the least recently accessed element is returned last. Only the get, put, and putAll methods influence this ordering.
    * accessOrder=false: The elements are ordered according to their insertion. This is the default if any of the other LinkedHashMap constructors is used. In this ordering read access to the map has no influence on element ordering.
  * removeEldestEntry\(Entry\)
    * This method is called with the eldest entry whenever an element is added to the map. Eldest means the element which is returned last when iterating over the map. So the notion of eldest is influenced by accessOrder set on the map. The removeEldestElement in its default implementation just returns false to indicate, that nothing should happen. An extension of the LinkedHashMap may overwrite the default implementation to do whatever would be required:

**Hash+Prefix**

[525.Contiguous-Array](https://github.com/wisdompeak/LeetCode/tree/master/Hash/525.Contiguous-Array) \(M\)  
[930.Binary-Subarrays-With-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Hash/930.Binary-Subarrays-With-Sum) \(M\)  
[1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR) \(H-\)  
[1524.Number-of-Sub-arrays-With-Odd-Sum ](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1524.Number-of-Sub-arrays-With-Odd-Sum) \(M\)  
[974.Subarray-Sums-Divisible-by-K](https://github.com/wisdompeak/LeetCode/tree/master/Hash/974.Subarray-Sums-Divisible-by-K) \(M\)  
[1590.Make-Sum-Divisible-by-P](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1590.Make-Sum-Divisible-by-P) \(M+\)  
[1658.Minimum-Operations-to-Reduce-X-to-Zero](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1658.Minimum-Operations-to-Reduce-X-to-Zero) \(M\)  
[1371.Find-the-Longest-Substring-Containing-Vowels-in-Even-Counts](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1371.Find-the-Longest-Substring-Containing-Vowels-in-Even-Counts) \(H-\)  
[1542.Find-Longest-Awesome-Substring](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1542.Find-Longest-Awesome-Substring) \(H-\)  
[1915.Number-of-Wonderful-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1915.Number-of-Wonderful-Substrings) \(M+\)  
[1983.Widest-Pair-of-Indices-With-Equal-Range-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Hash/1983.Widest-Pair-of-Indices-With-Equal-Range-Sum) \(M+\)

#### [Heap](https://github.com/wisdompeak/LeetCode/tree/master/Heap)

[220.Contains-Duplicate-III](https://github.com/wisdompeak/LeetCode/tree/master/Heap/220.Contains-Duplicate-III) \(M\)  
[295.Find-Median-from-Data-Stream](https://github.com/wisdompeak/LeetCode/tree/master/Heap/295.Find-Median-from-Data-Stream) \(M\)  
[363.Max-Sum-of-Rectangle-No-Larger-Than-K](https://github.com/wisdompeak/LeetCode/tree/master/Heap/363.Max-Sum-of-Rectangle-No-Larger-Than-K) \(H\)  
[352.Data-Stream-as-Disjoint-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Heap/352.Data-Stream-as-Disjoint-Intervals) \(H\)  
[480.Sliding-Window-Median](https://github.com/wisdompeak/LeetCode/blob/master/Heap/480.Sliding-Window-Median) \(H\)  
[218.The-Skyline-Problem](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/218.The-Skyline-Problem) \(H\)  
[699.Falling-Squares](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/699.Falling-Squares) \(H\)  
[715.Range-Module](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/715.Range-Module) \(H\)  
[729.My-Calendar-I](https://github.com/wisdompeak/LeetCode/tree/master/Heap/729.My-Calendar-I) \(M\)  
[975.Odd-Even-Jump](https://github.com/wisdompeak/LeetCode/tree/master/Heap/975.Odd-Even-Jump) \(H-\)  
[632.Smallest-Range-Covering-Elements-from-K-Lists](https://github.com/wisdompeak/LeetCode/tree/master/Heap/632.Smallest-Range-Covering-Elements-from-K-Lists) \(H-\)  
[1675.Minimize-Deviation-in-Array](https://github.com/wisdompeak/LeetCode/tree/master/Heap/1675.Minimize-Deviation-in-Array) \(H\)  
[1296.Divide-Array-in-Sets-of-K-Consecutive-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Heap/1296.Divide-Array-in-Sets-of-K-Consecutive-Numbers) \(M\)  
1348.Tweet-Counts-Per-Frequency \(H-\)  
[1606.Find-Servers-That-Handled-Most-Number-of-Requests](https://github.com/wisdompeak/LeetCode/tree/master/Heap/1606.Find-Servers-That-Handled-Most-Number-of-Requests) \(M\)  
1797.Design Authentication Manager \(M\)  
[1825.Finding-MK-Average](https://github.com/wisdompeak/LeetCode/tree/master/Heap/1825.Finding-MK-Average) \(H\)  
[1847.Closest-Room](https://github.com/wisdompeak/LeetCode/tree/master/Heap/1847.Closest-Room) \(M+\)  
[1912.Design-Movie-Rental-System](https://github.com/wisdompeak/LeetCode/tree/master/Heap/1912.Design-Movie-Rental-System) \(M+\)

#### [Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree)

[144.Binary-Tree-Preorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/144.Binary-Tree-Preorder-Traversal) \(M+\)  
[145.Binary-Tree-Postorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/145.Binary-Tree-Postorder-Traversal) \(H-\)  
[270.Closest-Binary-Search-Tree-Value](https://github.com/wisdompeak/LeetCode/tree/master/Tree/270.Closest-Binary-Search-Tree-Value) \(M+\)  
[095.Unique-Binary-Search-Trees-II](https://github.com/wisdompeak/LeetCode/tree/master/Tree/095.Unique-Binary-Search-Trees-II) \(H\)  
[094.Binary Tree Inorder Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/094.Binary-Tree-Inorder-Traversal) \(H-\)  
[110.Balanced-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/110.Balanced-Binary-Tree) \(M+\)  
[124.Binary-Tree-Maximum-Path-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Tree/124.Binary-Tree-Maximum-Path-Sum) \(M+\)  
[222.Count-Complete-Tree-Nodes](https://github.com/wisdompeak/LeetCode/tree/master/Tree/222.Count-Complete-Tree-Nodes) \(M+\)  
[099.Recover-Binary-Search-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/099.Recover-Binary-Search-Tree) \(H\)  
[114.Flatten-Binary-Tree-to-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Tree/114.Flatten-Binary-Tree-to-Linked-List) \(M+\)  
[098.Validate-Binary-Search-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/098.Validate-Binary-Search-Tree) \(M\)  
[117.Populating Next Right Pointers in Each Node II](https://github.com/wisdompeak/LeetCode/tree/master/Tree/117.Populating-Next-Right-Pointers-in-Each-Node-II) \(H\)  
[156.Binary-Tree-Upside-Down](https://github.com/wisdompeak/LeetCode/blob/master/Tree/156.Binary-Tree-Upside-Down) \(H\)  
[285.Inorder-Successor-in-BST](https://github.com/wisdompeak/LeetCode/blob/master/Tree/285.Inorder-Successor-in-BST) \(M\)  
[298.Binary-Tree-Longest-Consecutive Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Tree/298.Binary-Tree-Longest-Consecutive-Sequence) \(M+\)  
[450.Delete-Node-in-a-BST](https://github.com/wisdompeak/LeetCode/tree/master/Tree/450.Delete-Node-in-a-BST) \(H\)  
[437.Path-Sum-III](https://github.com/wisdompeak/LeetCode/tree/master/Tree/437.Path-Sum-III) \(H-\)  
[333.Largest-BST-Subtree](https://github.com/wisdompeak/LeetCode/blob/master/Tree/333.Largest-BST-Subtree) \(H\)  
[543.Diameter-of-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/543.Diameter-of-Binary-Tree) \(M+\)  
[572.Subtree-of-Another-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/572.Subtree-of-Another-Tree) \(M\)  
[549.Binary-Tree-Longest-Consecutive-Sequence-II](https://github.com/wisdompeak/LeetCode/tree/master/Tree/549.Binary-Tree-Longest-Consecutive-Sequence-II) \(M\)  
[173.Binary-Search-Tree-Iterator](https://github.com/wisdompeak/LeetCode/tree/master/Stack/173.Binary-Search-Tree-Iterator) \(M\)  
[545.Boundary-of-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/545.Boundary-of-Binary-Tree) \(H-\)  
[272.Closest-Binary-Search-Tree-Value-II](https://github.com/wisdompeak/LeetCode/tree/master/Tree/272.Closest-Binary-Search-Tree-Value-II) \(M+\)  
[310.Minimum-Height-Trees](https://github.com/wisdompeak/LeetCode/tree/master/Tree/310.Minimum-Height-Trees) \(H-\)  
[226.Invert-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/226.Invert-Binary-Tree) \(M\)  
[655.Print-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/655.Print-Binary-Tree) \(M+\)  
[897.Increasing-Order-Search-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/897.Increasing-Order-Search-Tree) \(M+\)  
501.Find-Mode-in-Binary-Search-Tree \(M+\)  
558.Quad-Tree-Intersection \(M+\)  
[662.Maximum-Width-of-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/662.Maximum-Width-of-Binary-Tree) \(H-\)  
[687.Longest-Univalue-Path](https://github.com/wisdompeak/LeetCode/tree/master/Tree/687.Longest-Univalue-Path) \(M+\)  
742.Closest-Leaf-in-a-Binary-Tree \(H\)  
834.Sum-of-Distances-in-Tree \(H\)  
[863.All-Nodes-Distance-K-in-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/863.All-Nodes-Distance-K-in-Binary-Tree) \(H-\)  
[958.Check-Completeness-of-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/blob/master/Tree/954.Check-Completeness-of-a-Binary-Tree/) \(M+\)  
1339. Maximum-Product-of-Splitted-Binary-Tree \(TBD\)  
[1104.Path-In-Zigzag-Labelled-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1104.Path-In-Zigzag-Labelled-Binary-Tree) \(M+\)  
[1660.Correct-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1660.Correct-a-Binary-Tree) \(M+\)  
[1666.Change-the-Root-of-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1666.Change-the-Root-of-a-Binary-Tree) \(H-\)  
[1932.Merge-BSTs-to-Create-Single-BST](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1932.Merge-BSTs-to-Create-Single-BST) \(H\)  
[2003.Smallest-Missing-Genetic-Value-in-Each-Subtree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/2003.Smallest-Missing-Genetic-Value-in-Each-Subtree) \(H\)

**Serialization & Hashing**

[297.Serialize-and-Deserialize-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/297.Serialize-and-Deserialize-Binary-Tree) （H-）  
[652.Find-Duplicate-Subtrees](https://github.com/wisdompeak/LeetCode/tree/master/Tree/652.Find-Duplicate-Subtrees) \(H\)  
[1948.Delete-Duplicate-Folders-in-System](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1948.Delete-Duplicate-Folders-in-System) \(H\)

**Traversal**

* Classic tree level order traversal with O\(n\) space

```python
bfsQueue = deque()
bfsQueue.append( root )
while bfsQueue:
  head = bfsQueue.popleft()
  // do stuff
  if head.left is not None:
    bfsQueue.append(head.left)
  if head.right is not None:
    bfsQueue.append(head.right)
```

* Special tree level order traversal with O\(1\) space: example problem \(populate next right pointers in each node II\)

**Get inorder traversal predecessor/successor**

```python
    def getPredecessor(root: TreeNode, target: TreeNode) -> TreeNode:
      if target.left:
        currNode = target.left
        while currNode.right:
          currNode = currNode.right
        return currNode
      else:
        predecessor = None
        currNode = root
        while currNode != target:
          if currNode.val >= target.val:
            currNode = currNode.left
          else:
            predecessor = currNode
            currNode = currNode.right
        return predecessor

    def getSuccessor(root: TreeNode, target: TreeNode) -> TreeNode:
      if target.right:
        currNode = target.right
        while currNode.left != null:
          currNode = currNode.left
        return currNode
      else:
        successor = None
        currNode = root
        while currNode != target:
          if currNode.val >= target.val:
            successor = currNode
            currNode = currNode.left
          else:
            currNode = currNode.right
        return successor
```

**Tree & Sequence**

[105.Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/105.Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal) \(H-\)  
[106.Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/106.Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal) \(M+\)  
[331.Verify-Preorder-Serialization-of-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/331.Verify-Preorder-Serialization-of-a-Binary-Tree) \(H\)  
[449.Serialize-and-Deserialize-BST](https://github.com/wisdompeak/LeetCode/tree/master/Tree/449.Serialize-and-Deserialize-BST) \(H\)  
[971.Flip-Binary-Tree-To-Match-Preorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/971.Flip-Binary-Tree-To-Match-Preorder-Traversal) \(M+\)  
[1028.Recover-a-Tree-From-Preorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1028.Recover-a-Tree-From-Preorder-Traversal) \(H-\)  
[1569.Number-of-Ways-to-Reorder-Array-to-Get-Same-BST](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1569.Number-of-Ways-to-Reorder-Array-to-Get-Same-BST) \(H\)  
[1597.Build-Binary-Expression-Tree-From-Infix-Expression](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1597.Build-Binary-Expression-Tree-From-Infix-Expression) \(H\)  
[1902.Depth-of-BST-Given-Insertion-Order](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1902.Depth-of-BST-Given-Insertion-Order) \(H-\)

**LCA**

[236.Lowest-Common-Ancestor-of-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/236.Lowest-Common-Ancestor-of-a-Binary-Tree) \(H\)  
[1676.Lowest-Common-Ancestor-of-a-Binary-Tree-IV](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1676.Lowest-Common-Ancestor-of-a-Binary-Tree-IV) \(M+\)  
[1740.Find-Distance-in-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1740.Find-Distance-in-a-Binary-Tree) \(H\)

**N-ary Tree**

[428.Serialize-and-Deserialize-N-ary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/428.Serialize-and-Deserialize-N-ary-Tree) \(H\)  
[431.Encode-N-ary-Tree-to-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/431.Encode-N-ary-Tree-to-Binary-Tree) \(H-\)  
[1516.Move-Sub-Tree-of-N-Ary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1516.Move-Sub-Tree-of-N-Ary-Tree) \(H-\)

**似树非树**

[823](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/823.Binary-Trees-With-Factors), [1902](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1902.Depth-of-BST-Given-Insertion-Order),

#### [Segment Tree](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/)

**Basics**

[307.Range-Sum-Query-Mutable](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/307.Range-Sum-Query-Mutable/) \(H-\)  
[1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array) \(H-\)  
[1649.Create-Sorted-Array-through-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/1649.Create-Sorted-Array-through-Instructions) \(H-\)  
[1157.Online-Majority-Element-In-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1157.Online-Majority-Element-In-Subarray) \(H\)

**Lazy Tag**

[370.Range-Addition](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/370.Range-Addition) \(H\)  
[218.The-Skyline-Problem](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/218.The-Skyline-Problem) \(H+\)  
[699.Falling-Squares](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/699.Falling-Squares) \(H\)

**Others**

[715.Range-Module](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/715.Range-Module) \(H\)

#### \[Binary Index Tree\]

[307.Range-Sum-Query-Mutable](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/307.Range-Sum-Query-Mutable/) \(M\)  
[1649.Create-Sorted-Array-through-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/1649.Create-Sorted-Array-through-Instructions) \(H\)

#### [Design](https://github.com/wisdompeak/LeetCode/tree/master/Design)

[146.LRU-Cache](https://github.com/wisdompeak/LeetCode/tree/master/Design/146.LRU-Cache) \(H-\)  
[460.LFU Cache](https://github.com/wisdompeak/LeetCode/tree/master/Design/460.LFU-Cache) \(H\)  
[432.All-O-one-Data-Structure](https://github.com/wisdompeak/LeetCode/tree/master/Design/432.All-O-one-Data-Structure) \(H\)  
[380.Insert-Delete-GetRandom-O\(1\)](https://github.com/wisdompeak/LeetCode/tree/master/Design/380.Insert-Delete-GetRandom-O-1/) \(M+\)  
[381.Insert-Delete-GetRandom-O1-Duplicates-allowed](https://github.com/wisdompeak/LeetCode/tree/master/Design/381.Insert-Delete-GetRandom-O1-Duplicates-allowed) \(H-\)  
[716.Max-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Design/716.Max-Stack) \(M+\)  
[355.Design-Twitter](https://github.com/wisdompeak/LeetCode/tree/master/Design/355.Design-Twitter) \(H\)  
[535.Encode-and-Decode-TinyURL](https://github.com/wisdompeak/LeetCode/tree/master/Design/535.Encode-and-Decode-TinyURL) \(M\)  
[631.Design-Excel-Sum-Formula](https://github.com/wisdompeak/LeetCode/tree/master/Design/631.Design-Excel-Sum-Formula) \(H\)  
[642.Design-Search-Autocomplete-System](https://github.com/wisdompeak/LeetCode/tree/master/Design/642.Design-Search-Autocomplete-System) \(M+\)  
[895.Maximum-Frequency-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Design/895.Maximum-Frequency-Stack) \(H\)  
[1146.Snapshot-Array](https://github.com/wisdompeak/LeetCode/tree/master/Design/1146.Snapshot-Array) \(H\)  
[1172.Dinner-Plate-Stacks](https://github.com/wisdompeak/LeetCode/tree/master/Design/1172.Dinner-Plate-Stacks) \(H\)  
[1381.Design-a-Stack-With-Increment-Operation](https://github.com/wisdompeak/LeetCode/tree/master/Design/1381.Design-a-Stack-With-Increment-Operation) \(H-\)  
[1352.Product-of-the-Last-K-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Design/1352.Product-of-the-Last-K-Numbers) \(M+\)  
[1418.Display-Table-of-Food-Orders-in-a-Restaurant](https://github.com/wisdompeak/LeetCode/tree/master/Design/1418.Display-Table-of-Food-Orders-in-a-Restaurant) \(H-\)  
[1622.Fancy-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Design/1622.Fancy-Sequence) \(H+\)

#### [Stack](https://github.com/wisdompeak/LeetCode/tree/master/Stack)

[032.Longest-Valid-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Stack/032.Longest-Valid-Parentheses) \(H\)  
[155.Min-Stack](https://github.com/wisdompeak/LeetCode/tree/master/Stack/155.Min-Stack) \(M\)  
[225.Implement Stack using Queues](https://github.com/wisdompeak/LeetCode/tree/master/Stack/225.Implement-Stack-using-Queues) \(H-\)  
[232.Implement-Queue-using-Stacks](https://github.com/wisdompeak/LeetCode/tree/master/Stack/232.Implement-Queue-using-Stacks) \(H-\)  
[341.Flatten-Nested-List-Iterator](https://github.com/wisdompeak/LeetCode/blob/master/Stack/341.Flatten-Nested-List-Iterator/Readme.md) \(M\)  
[173.Binary-Search-Tree-Iterator](https://github.com/wisdompeak/LeetCode/tree/master/Stack/173.Binary-Search-Tree-Iterator) \(M\)  
[536.Construct-Binary-Tree-from-String](https://github.com/wisdompeak/LeetCode/tree/master/Stack/536.Construct-Binary-Tree-from-String) \(M\)  
[456.132-Pattern](https://github.com/wisdompeak/LeetCode/tree/master/Stack/456.132-Pattern) \(H-\)  
[636.Exclusive-Time-of-Functions](https://github.com/wisdompeak/LeetCode/tree/master/Stack/636.Exclusive-Time-of-Functions) \(H-\)  
[856.Score-of-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Stack/856.Score-of-Parentheses) \(M+\)  
[946.Validate-Stack-Sequences](https://github.com/wisdompeak/LeetCode/tree/master/Stack/946.Validate-Stack-Sequences)（H-）  
[1190.Reverse-Substrings-Between-Each-Pair-of-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1190.Reverse-Substrings-Between-Each-Pair-of-Parentheses) \(H-\)  
[1209.Remove-All-Adjacent-Duplicates-in-String-II](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1209.Remove-All-Adjacent-Duplicates-in-String-II) \(M+\)  
[1586.Binary-Search-Tree-Iterator-II](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1586.Binary-Search-Tree-Iterator-II) \(H\)

**monotonic stack**

[042.Trapping-Rain-Water](https://github.com/wisdompeak/LeetCode/tree/master/Others/042.Trapping-Rain-Water) \(H\)  
[084.Largest-Rectangle-in-Histogram](https://github.com/wisdompeak/LeetCode/tree/master/Stack/084.Largest-Rectangle-in-Histogram) \(H\)  
[085.Maximal-Rectangle](https://github.com/wisdompeak/LeetCode/tree/master/Stack/085.Maximal-Rectangle) \(H-\)  
[255.Verify-Preorder-Sequence-in-Binary-Search-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/255.Verify-Preorder-Sequence-in-Binary-Search-Tree) \(H\)  
[402.Remove-K-Digits](https://github.com/wisdompeak/LeetCode/tree/master/Stack/402.Remove-K-Digits) \(H-\)  
[316.Remove-Duplicate-Letters](https://github.com/wisdompeak/LeetCode/tree/master/Stack/316.Remove-Duplicate-Letters) \(H\)  
[496.Next-Greater-Element-I](https://github.com/wisdompeak/LeetCode/tree/master/Stack/496.Next-Greater-Element-I) \(H-\)  
[503.Next-Greater-Element-II](https://github.com/wisdompeak/LeetCode/blob/master/Stack/503.Next-Greater-Element-II) \(H-\)  
[221.Maximal-Square](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/221.Maximal-Square) \(H-\)  
[739.Daily-Temperatures](https://github.com/wisdompeak/LeetCode/tree/master/Stack/739.Daily-Temperatures) \(H-\)  
[768.Max-Chunks-To-Make-Sorted-II](https://github.com/wisdompeak/LeetCode/tree/master/Stack/768.Max-Chunks-To-Make-Sorted-II) \(H-\)  
[901.Online-Stock-Span](https://github.com/wisdompeak/LeetCode/tree/master/Stack/901.Online-Stock-Span) \(H-\)  
[907.Sum-of-Subarray-Minimums](https://github.com/wisdompeak/LeetCode/tree/master/Stack/907.Sum-of-Subarray-Minimums) \(H\)  
[1856.Maximum-Subarray-Min-Product](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1856.Maximum-Subarray-Min-Product) \(M+\)  
[962.Maximum-Width-Ramp](https://github.com/wisdompeak/LeetCode/tree/master/Stack/962.Maximum-Width-Ramp) \(H\)  
[1019.Next-Greater-Node-In-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1019.Next-Greater-Node-In-Linked-List) \(M\)  
[1063.Number-of-Valid-Subarrays](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1063.Number-of-Valid-Subarrays) \(M+\)  
[1124.Longest-Well-Performing-Interval](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1124.Longest-Well-Performing-Interval) \(H\)  
[1130.Minimum-Cost-Tree-From-Leaf-Values](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1130.Minimum-Cost-Tree-From-Leaf-Values) \(H\)  
[1673.Find-the-Most-Competitive-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1673.Find-the-Most-Competitive-Subsequence) \(M\)  
[1944.Number-of-Visible-People-in-a-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1944.Number-of-Visible-People-in-a-Queue) \(H\)  
[1950.Maximum-of-Minimum-Values-in-All=Subarrays](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1950.Maximum-of-Minimum-Values-in-All-Subarrays) \(H-\)  
[1966.Binary-Searchable-Numbers-in-an-Unsorted-Array](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1966.Binary-Searchable-Numbers-in-an-Unsorted-Array) \(M+\)

**parse expression**

[071.Simplify-Path](https://github.com/wisdompeak/LeetCode/tree/master/Stack/071.Simplify-Path) \(M\)  
[224.Basic-Calculator](https://github.com/wisdompeak/LeetCode/tree/master/Stack/224.Basic-Calculator)\(H-\)  
[227.Basic-Calculator-II](https://github.com/wisdompeak/LeetCode/tree/master/Stack/227.Basic-Calculator-II) \(H-\)  
[772.Basic-Calculator-III](https://github.com/wisdompeak/LeetCode/tree/master/Stack/772.Basic-Calculator-III) \(H\)  
[385.Mini-Parser](https://github.com/wisdompeak/LeetCode/tree/master/Stack/385.Mini-Parser) \(H\)  
[439.Ternary-Expression-Parser](https://github.com/wisdompeak/LeetCode/tree/master/Stack/439.Ternary-Expression-Parser) \(H-\)  
[591.Tag-Validator](https://github.com/wisdompeak/LeetCode/blob/master/Stack/591.Tag-Validator/) \(H\)  
[726.Number-of-Atoms](https://github.com/wisdompeak/LeetCode/tree/master/Stack/726.Number-of-Atoms) \(M+\)  
[1087.Brace-Expansion](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1087.Brace-Expansion) \(H\)  
[1096.Brace-Expansion-II](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1096.Brace-Expansion-II) \(H\)  
[1106.Parsing-A-Boolean-Expression](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1106.Parsing-A-Boolean-Expression) \(H-\)  
[1896.Minimum-Cost-to-Change-the-Final-Value-of-Expression](https://github.com/wisdompeak/LeetCode/tree/master/Stack/1896.Minimum-Cost-to-Change-the-Final-Value-of-Expression) \(H+\)

**Calculator**

* Evaluate infix expression. The problem can have various follow-ups
  * How to define input: String s or String\[\] tokens. If input is defined as String s and numbers might include negative numbers, then parsing negative numbers can be kind of cumbersome. When possible, define input as String\[\] tokens. Even when required to define input as String s, double check whether we need to deal with negative numbers.
  * Whether contain space
  * Whether need to deal with parentheses

```python
    def calculate(s: str) -> int:
      valStack = []
      opStack = []
      for i in range(s.length()):
        char token = s[i]
        if token == " ":
          continue
        elif token == "(":
          opStack.append(token)
        elif token == ")":
          while opStack[-1] != "(":
            valStack.append( calc( opStack.pop(), valStack.pop(), valStack.pop() ) )
          opStack.pop()
        elif token.isnumeric():
          start = i
          while i + 1 < s.len() and s[i+1].isnumeric():
            i++
          valStack.append(int(s[start:i + 1]))
        else:
          while !opStack.isEmpty() and isLowerPrece(token, opStack[-1]):
            valStack.append( calc( opStack.pop(), valStack.pop(), valStack.pop() ) )
          opStack.append( token )

      while opStack:
        valStack.append(calc( opStack.pop(), valStack.pop(), valStack.pop() ))

      return valStack.pop()
    }

    def isLowerPrece(curr: str, toBeCompared: str ) -> bool:
      return toBeCompared == '*' or toBeCompared == '/'
          or ( toBeCompared == '-' and ( curr == '+' or curr == '-' ) )

    def calc(operator: str, operand1: int, operand2: int) -> int:
      if operator == '+':
        return operand2 + operand1
      elif operator == '-':
        return operand2 - operand1
      elif operator == '*':
        return operand2 * operand1
      else
        return operand2 / operand1
```

**Parentheses \[TODO\]**

* Check if string s contains valid parenthese
  * Questions to confirm
    * Whether the string contains non-parentheses characters
    * Whether the string contains curly braces, brackets or parentheses
    * Need to calculate the invalid number or just judge it is valid or not

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

#### [Deque](https://github.com/wisdompeak/LeetCode/tree/master/Deque)

[239.Sliding-Window-Maximum](https://github.com/wisdompeak/LeetCode/tree/master/Deque/239.Sliding-Window-Maximum) \(H-\)  
[862.Shortest-Subarray-with-Sum-at-Least-K](https://github.com/wisdompeak/LeetCode/tree/master/Deque/862.Shortest-Subarray-with-Sum-at-Least-K) \(H\)  
[1425.Constrained-Subsequence-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1425.Constrained-Subsequence-Sum) \(H\)  
[1438.Longest-Continuous-Subarray-With-Absolute-Diff-Less-Than-or-Equal-to-Limit](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1438.Longest-Continuous-Subarray-With-Absolute-Diff-Less-Than-or-Equal-to-Limit) \(H\)  
[1499.Max-Value-of-Equation](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1499.Max-Value-of-Equation) \(M+\)  
[1562.Find-Latest-Group-of-Size-M](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1562.Find-Latest-Group-of-Size-M) \(H\)  
[1696.Jump-Game-VI](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1696.Jump-Game-VI) \(M+\)  
[1776.Car-Fleet-II](https://github.com/wisdompeak/LeetCode/tree/master/Deque/1776.Car-Fleet-II) \(H\)

#### [Priority Queue](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue)

[004.Median-of-Two-Sorted-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/004.Median-of-Two-Sorted-Arrays) \(H\)  
[378.Kth-Smallest-Element-in-a-Sorted-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/378.Kth-Smallest-Element-in-a-Sorted-Matrix) \(H-\)  
[373.Find-K-Pairs-with-Smallest-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/373.Find-K-Pairs-with-Smallest-Sums) \(H\)  
[642.Design-Search-Autocomplete-System](https://github.com/wisdompeak/LeetCode/tree/master/Design/642.Design-Search-Autocomplete-System) \(M+\)  
[774.Minimize-Max-Distance-to-Gas-Station](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/774.Minimize-Max-Distance-to-Gas-Station) \(H\)  
[871.Minimum-Number-of-Refueling-Stops](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/871.Minimum-Number-of-Refueling-Stops) \(H-\)  
[1057.Campus-Bikes](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1057.Campus-Bikes) \(H-\)  
[1167.Minimum-Cost-to-Connect-Sticks](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1167.Minimum-Cost-to-Connect-Sticks) \(H-\)  
[1439.Find-the-Kth-Smallest-Sum-of-a-Matrix-With-Sorted-Rows](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1439.Find-the-Kth-Smallest-Sum-of-a-Matrix-With-Sorted-Rows) \(H-\)  
[1642.Furthest-Building-You-Can-Reach](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1642.Furthest-Building-You-Can-Reach) \(H-\)  
[1705.Maximum-Number-of-Eaten-Apples](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1705.Maximum-Number-of-Eaten-Apples) \(M+\)  
[1792.Maximum-Average-Pass-Ratio](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1792.Maximum-Average-Pass-Ratio) \(M+\)  
[1801.Number-of-Orders-in-the-Backlog](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1801.Number-of-Orders-in-the-Backlog) \(M\)  
[1882.Process-Tasks-Using-Servers](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1882.Process-Tasks-Using-Servers) \(H\)  
[1942.The-Number-of-the-Smallest-Unoccupied-Chair](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1942.The-Number-of-the-Smallest-Unoccupied-Chair) \(M+\)

**Sort+PQ**

[502.IPO](https://github.com/wisdompeak/LeetCode/blob/master/Priority_Queue/502.IPO/) （M+）  
[630.Course-Schedule-III](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/630.Course-Schedule-III) \(H\)  
[857.Minimum-Cost-to-Hire-K-Workers](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/857.Minimum-Cost-to-Hire-K-Workers) \(H\)  
[1353.Maximum-Number-of-Events-That-Can-Be-Attended](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1353.Maximum-Number-of-Events-That-Can-Be-Attended) \(H-\)  
[1383.Maximum-Performance-of-a-Team](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1383.Maximum-Performance-of-a-Team) \(M+\)  
[1834.Single-Threaded-CPU](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1834.Single-Threaded-CPU) \(M\)  
[1851.Minimum-Interval-to-Include-Each-Query](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1851.Minimum-Interval-to-Include-Each-Query) \(H\)

**Arrangement with Stride**

[767.Reorganize-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/767.Reorganize-String) \(M+\)  
[1054.Distant-Barcodes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1054.Distant-Barcodes) \(M+\)  
[358.Rearrange-String-k-Distance-Apart](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/358.Rearrange-String-k-Distance-Apart) \(H-\)  
[621.Task-Scheduler](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/621.Task-Scheduler) \(H-\)  
[984.String-Without-AAA-or-BBB](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/984.String-Without-AAA-or-BBB) \(M+\)  
[1405.Longest-Happy-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1405.Longest-Happy-String) \(H-\)  
[1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work) \(M+\)

#### Graph \[TODO\]

**Edge list vs Adjacent list vs Adjacent matrix**

* Time complexity comparison between different graph representation
  * Use cases for different representations
  * Edge list is usually not used because looping through neighbor of a vertex is too expensive. This makes it really appropriate for many graph algo \(bfs, dfs\).
  * Adjacent matrix is usually used for dense graph, where vertexes are seldomly added or removed.
  * Adjacent list is usually used for sparse graph to save space.
* Adjacent list representation is the most commonly used graph representation in an interview setting. There are two common ways to realize this. One typical classical way is to define class GraphNode and then graph can be defined as List &lt; GraphNode &gt;. The other way is to define graph as Map&lt;Integer, Set&lt;Integer&gt;&gt; graph. Map&lt;Integer&gt;

  \`\`\`java // first way, more official // but if there are redundant edges in input, might need to implement hashcode\(\) and equal\(\) methods to avoid add redundant nodes into neighbors. Kind of overkilling in an interview setting class GraphNode { int val; int status; // used for track visiting status in DFS List neighbor; // ... } List graph =...;

// second way, graph itself is more concise. But need additional data structures like Set visited and Set discovered to track dfs traverse status Map&gt; graph

```text
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

**Detect cycles inside undirected graph**

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

**Detect cycles inside directed graph**

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

#### [DFS](https://github.com/wisdompeak/LeetCode/tree/master/DFS)

[037.Sudoku-Solver](https://github.com/wisdompeak/LeetCode/tree/master/DFS/037.Sudoku-Solver) \(M+\)  
[040.Combination-Sum-II](https://github.com/wisdompeak/LeetCode/tree/master/DFS/040.Combination-Sum-II) \(M+\)  
[051.N-Queens](https://github.com/wisdompeak/LeetCode/tree/master/DFS/051.N-Queens) \(M\)  
[131.Palindrome-Partitioning](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/131.Palindrome-Partitioning) \(M+\)  
[291.Word-Pattern-II](https://github.com/wisdompeak/LeetCode/tree/master/DFS/291.Word-Pattern-II) \(M\)  
[417.Pacific-Atlantic-Water-Flow](https://github.com/wisdompeak/LeetCode/tree/master/DFS/417.Pacific-Atlantic-Water-Flow) \(M\)  
[200.Number-of-Islands](https://github.com/wisdompeak/LeetCode/tree/master/DFS/200.Number-of-Islands) \(M\)  
[282.Expression-Add-Operators](https://github.com/wisdompeak/LeetCode/tree/master/DFS/282.Expression-Add-Operators) \(H\)  
[312.Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/DFS/312.Burst-Balloons) \(H-\)  
[351.Android-Unlock-Patterns](https://github.com/wisdompeak/LeetCode/tree/master/DFS/351.Android-Unlock-Patterns) \(H-\)  
[399.Evaluate-Division](https://github.com/wisdompeak/LeetCode/tree/master/DFS/399.Evaluate-Division) \(H-\)  
[488.Zuma-Game](https://github.com/wisdompeak/LeetCode/tree/master/DFS/488.Zuma-Game) \(H-\)  
[425.Word-Squares](https://github.com/wisdompeak/LeetCode/tree/master/DFS/425.Word-Squares) \(H-\)  
[959.Regions-Cut-By-Slashes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/959.Regions-Cut-By-Slashes) \(M+\)  
[1306.Jump-Game-III](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1306.Jump-Game-III) \(M\)  
[1718.Construct-the-Lexicographically-Largest-Valid-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1718.Construct-the-Lexicographically-Largest-Valid-Sequence) \(H-\)  
[1723.Find-Minimum-Time-to-Finish-All-Jobs](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1723.Find-Minimum-Time-to-Finish-All-Jobs) \(H-\)  
[1766.Tree-of-Coprimes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1766.Tree-of-Coprimes) \(H-\)  
[1778.Shortest-Path-in-a-Hidden-Grid](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1778.Shortest-Path-in-a-Hidden-Grid) \(H-\)

**search in an array**

[090.Subsets-II](https://github.com/wisdompeak/LeetCode/tree/master/DFS/090.Subsets-II) \(M+\)  
[301.Remove-Invalid-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/DFS/301.Remove-Invalid-Parentheses) \(H\)  
[473.Matchsticks-to-Square](https://github.com/wisdompeak/LeetCode/tree/master/DFS/473.Matchsticks-to-Square) \(M+\)  
[491.Increasing-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/DFS/491.Increasing-Subsequences) \(M\)  
[698.Partition-to-K-Equal-Sum-Subsets](https://github.com/wisdompeak/LeetCode/tree/master/DFS/698.Partition-to-K-Equal-Sum-Subsets) \(H-\)  
[996.Number-of-Squareful-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/DFS/996.Number-of-Squareful-Arrays) \(H-\)  
[1307.Verbal-Arithmetic-Puzzle](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1307.Verbal-Arithmetic-Puzzle) \(H\)  
[1593.Split-a-String-Into-the-Max-Number-of-Unique-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1593.Split-a-String-Into-the-Max-Number-of-Unique-Substrings) \(M\)  
[1681.Minimum-Incompatibility](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1681.Minimum-Incompatibility) \(H\)

**memorization**

[329.Longest-Increasing-Path-in-a-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/DFS/329.Longest-Increasing-Path-in-a-Matrix) \(M\)  
[638.Shopping-Offers](https://github.com/wisdompeak/LeetCode/tree/master/DFS/638.Shopping-Offers) \(M+\)  
[403.Frog-Jump](https://github.com/wisdompeak/LeetCode/tree/master/DFS/403.Frog-Jump) \(M+\)  
[489.Robot-Room-Cleaner](https://github.com/wisdompeak/LeetCode/blob/master/DFS/489.Robot-Room-Cleaner) \(H\)  
[546.Remove-Boxes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/546.Remove-Boxes) \(H+\)  
[1340.Jump-Game-V](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1340.Jump-Game-V) \(M+\)  
[1815.Maximum-Number-of-Groups-Getting-Fresh-Donuts](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1815.Maximum-Number-of-Groups-Getting-Fresh-Donuts) \(H-\)

#### [BFS](https://github.com/wisdompeak/LeetCode/tree/master/BFS)

[127.Word-Ladder](https://github.com/wisdompeak/LeetCode/tree/master/BFS/127.Word-Ladder) \(M+\)  
[126.Word-Ladder-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/126.Word-Ladder-II) \(M+\)  
[130.Surrounded-Regions](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/130.Surrounded-Regions) \(H-\)  
[200.Number-of-Islands](https://github.com/wisdompeak/LeetCode/tree/master/DFS/200.Number-of-Islands) \(H-\)  
[529.Minesweeper](https://github.com/wisdompeak/LeetCode/tree/master/BFS/529.Minesweeper) \(M+\)  
[637.Average-of-Levels-in-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/BFS/637.Average-of-Levels-in-Binary-Tree) \(M\)  
[675.Cut-Off-Trees-for-Golf-Event](https://github.com/wisdompeak/LeetCode/tree/master/BFS/675.Cut-Off-Trees-for-Golf-Event) \(M\)  
694.Number-of-Distinct-Islands \(M+\)  
[785.Is-Graph-Bipartite](https://github.com/wisdompeak/LeetCode/tree/master/BFS/785.Is-Graph-Bipartite) \(M+\)  
[815.Bus-Routes](https://github.com/wisdompeak/LeetCode/tree/master/BFS/815.Bus-Routes) \(M+\)  
[838.Push-Dominoes](https://github.com/wisdompeak/LeetCode/tree/master/BFS/838.Push-Dominoes) \(M+\)  
[847.Shortest-Path-Visiting-All-Nodes](https://github.com/wisdompeak/LeetCode/tree/master/BFS/847.Shortest-Path-Visiting-All-Nodes) \(H-\)  
[864.Shortest-Path-to-Get-All-Keys](https://github.com/wisdompeak/LeetCode/tree/master/BFS/864.Shortest-Path-to-Get-All-Keys) \(H-\)  
[928.Minimize-Malware-Spread-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/928.Minimize-Malware-Spread-II) \(H-\)  
[1036.Escape-a-Large-Maze](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1036.Escape-a-Large-Maze) \(H\)  
[1245.Tree-Diameter](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1245.Tree-Diameter) \(H\)  
[1263.Minimum-Moves-to-Move-a-Box-to-Their-Target-Location](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1263.Minimum-Moves-to-Move-a-Box-to-Their-Target-Location) \(H\)  
[1293.Shortest-Path-in-a-Grid-with-Obstacles-Elimination](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1293.Shortest-Path-in-a-Grid-with-Obstacles-Elimination) \(H-\)  
[1298.Maximum-Candies-You-Can-Get-from-Boxes](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1298.Maximum-Candies-You-Can-Get-from-Boxes) \(M+\)  
[1311.Get-Watched-Videos-by-Your-Friends](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1311.Get-Watched-Videos-by-Your-Friends) \(M\)  
[1345.Jump-Game-IV](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1345.Jump-Game-IV) \(M+\)  
[1559.Detect-Cycles-in-2D-Grid](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1559.Detect-Cycles-in-2D-Grid) \(M\)  
[1568.Minimum-Number-of-Days-to-Disconnect-Island](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1568.Minimum-Number-of-Days-to-Disconnect-Island) \(H-\)  
[1617.Count-Subtrees-With-Max-Distance-Between-Cities](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1617.Count-Subtrees-With-Max-Distance-Between-Cities) \(H-\)  
[1654.Minimum-Jumps-to-Reach-Home](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1654.Minimum-Jumps-to-Reach-Home) \(H-\)  
[1905.Count-Sub-Islands](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1905.Count-Sub-Islands) \(M+\)

**Multi State**

[913.Cat-and-Mouse](https://github.com/wisdompeak/LeetCode/tree/master/BFS/913.Cat-and-Mouse) \(H+\)  
[1728.Cat-and-Mouse-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1728.Cat-and-Mouse-II) \(H+\)  
[1928.Minimum-Cost-to-Reach-Destination-in-Time](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1928.Minimum-Cost-to-Reach-Destination-in-Time) \(H-\)

**拓扑排序**

[207.Course-Schedule](https://github.com/wisdompeak/LeetCode/tree/master/BFS/207.Course-Schedule) \(H-\)  
[210.Course-Schedule-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/210.Course-Schedule-II) \(M\)  
[269.Alien-Dictionary](https://github.com/wisdompeak/LeetCode/tree/master/BFS/269.Alien-Dictionary) \(H-\)  
[310.Minimum-Height-Trees](https://github.com/wisdompeak/LeetCode/tree/master/Tree/310.Minimum-Height-Trees) \(H-\)  
[444.Sequence-Reconstruction](https://github.com/wisdompeak/LeetCode/tree/master/BFS/444.Sequence-Reconstruction) \(H\)  
[802.Find-Eventual-Safe-States](https://github.com/wisdompeak/LeetCode/tree/master/BFS/802.Find-Eventual-Safe-States) \(H-\)  
[1136.Parallel-Courses](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1136.Parallel-Courses) \(M\)  
[1203.Sort-Items-by-Groups-Respecting-Dependencies](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1203.Sort-Items-by-Groups-Respecting-Dependencies) \(H\)  
[1462.Course-Schedule-IV](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1462.Course-Schedule-IV) \(M\)  
[1591.Strange-Printer-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1591.Strange-Printer-II) \(H-\)  
[1857.Largest-Color-Value-in-a-Directed-Graph](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1857.Largest-Color-Value-in-a-Directed-Graph) \(H-\)

**Patterns**

* There are basically two categories of methods for topological sort. The first one is greedy algorithm with O\(\|V\|^2 + \|E\|\) time complexity. The second is based on depth first search with O\(\|V\| + \|E\|\) time complexity. Here only discusses DFS based approach. 
* When using DFS based approach, there are two cases which should be taken care of. The first one is what if there exists no topological order at all. The second is how to return topological order.
  * What if there exists no topological order - a cycle is detected. 
    * How to detect cycle: use UNDISCOVERED, DISCOVERED, VISITED to represent three possible states of graph nodes. Use a Set&lt;?&gt; isDiscovered and Set&lt;?&gt; isVisited to record all history info. If met up with a node which has been discovered but not visited, then a cycle is detected. 
    * How to handle cycle: return a boolean value \(preferred\) or throw an exception \(not really suitable because they are expected cases\)
  * What if need to return topological order

    * If do not need to detect cycle, could simply use a Stack&lt;&gt; order to record the visited node, namely using Set&lt;?&gt; discovered, Stack&lt;?&gt; visited 
    * If need to detect cycle, namely using Set&lt;?&gt; discovered, LinkedHashSet&lt;?&gt; visited

      \`\`\`java public int\[\] getTopoOrder\(Map&gt; graph\) { Set discovered = new HashSet&lt;&gt;\(\); Set visited = new LinkedHashSet&lt;&gt;\(\); for \( Integer node : graph.keySet\(\) \) { if \( !discoverd.contains\( node \) \) { if \( !topoSort\( graph, node, discovered, visited \) \) { // a cycle is detected....error handling } } }

      return visited.stream\(\).reverse\(\).collect\( Collectors.toL\); int\[\] topoOrder = new int\[visited.size\(\)\]; int pos = topoOrder.length - 1; for \( Integer node : visited \) { topoOrder\[pos\] = node; pos--; }

      return topoOrder; }

    /\*\*

    * @return whether a cycle is detected

      \*/

      private boolean topoSort \( Map&gt; graph, Integer startNode, Set discovered, Set visited \)

      {

      discovered.add\( startNode \);

      for \( Integer neighbor : graph.get\( startNode \) \)

      {

      ```text
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
      ```

      }

      visited.add\( startNode \);

      return false;

      }

      \`\`\`

**Dijkstra \(BFS+PQ\)**

[743.Network-Delay-Time](https://github.com/wisdompeak/LeetCode/tree/master/BFS/743.Network-Delay-Time) \(H\)  
[407.Trapping-Rain-Water-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/407.Trapping-Rain-Water-II) \(H\)  
[778.Swim-in-Rising-Water](https://github.com/wisdompeak/LeetCode/tree/master/BFS/778.Swim-in-Rising-Water) \(H\)  
[505.The-Maze-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/505.The-Maze-II) \(H\)  
[787.Cheapest-Flights-Within-K-Stops](https://github.com/wisdompeak/LeetCode/tree/master/Graph/787.Cheapest-Flights-Within-K-Stops) \(H-\)  
[882.Reachable-Nodes-In-Subdivided-Graph](https://github.com/wisdompeak/LeetCode/tree/master/BFS/882.Reachable-Nodes-In-Subdivided-Graph%20) \(H\)  
[1066.Campus-Bikes-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1066.Campus-Bikes-II) \(H+\)  
[1879.Minimum-XOR-Sum-of-Two-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1879.Minimum-XOR-Sum-of-Two-Arrays) \(H\)  
[1947.Maximum-Compatibility-Score-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1947.Maximum-Compatibility-Score-Sum) \(H\)  
[1368.Minimum-Cost-to-Make-at-Least-One-Valid-Path-in-a-Grid](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1368.Minimum-Cost-to-Make-at-Least-One-Valid-Path-in-a-Grid) \(H\)  
[1514.Path-with-Maximum-Probability](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1514.Path-with-Maximum-Probability) \(H\)  
[1786.Number-of-Restricted-Paths-From-First-to-Last-Node](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1786.Number-of-Restricted-Paths-From-First-to-Last-Node) \(H-\)  
[1810.Minimum-Path-Cost-in-a-Hidden-Grid](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1810.Minimum-Path-Cost-in-a-Hidden-Grid) \(M+\)  
[1976.Number-of-Ways-to-Arrive-at-Destination](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1976.Number-of-Ways-to-Arrive-at-Destination) \(H-\)

#### [Trie](https://github.com/wisdompeak/LeetCode/tree/master/Trie)

[208.Implement-Trie--Prefix-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Trie/208.Implement-Trie--Prefix-Tree) \(M+\)  
\[1804.Implement-Trie-II-\(Prefix-Tree\)\]\([https://github.com/wisdompeak/LeetCode/tree/master/Trie/1804.Implement-Trie-II-\(Prefix-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1804.Implement-Trie-II-%28Prefix-Tree)\)\) \(M+\)  
[211.Add-and-Search-Word](https://github.com/wisdompeak/LeetCode/tree/master/Trie/211.Add-and-Search-Word) \(H-\)  
[472.Concatenated-Words](https://github.com/wisdompeak/LeetCode/tree/master/Trie/472.Concatenated-Words) \(H-\)  
[648.Replace-Words](https://github.com/wisdompeak/LeetCode/tree/master/Trie/648.Replace-Words) \(H\)  
[588.Design-In-Memory-File-System](https://github.com/wisdompeak/LeetCode/tree/master/Trie/588.Design-In-Memory-File-System) \(H-\)  
[677.Map-Sum-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/Trie/677.Map-Sum-Pairs) \(M\)  
676.Implement-Magic-Dictionary \(H-\)  
[139.Word-Break](https://github.com/wisdompeak/LeetCode/tree/master/Trie/139.Word-Break) \(M+\)  
[140.Word-Break-II](https://github.com/wisdompeak/LeetCode/tree/master/Trie/140.Word-Break-II) \(M+\)  
[212.Word-Search-II](https://github.com/wisdompeak/LeetCode/tree/master/Trie/212.Word-Search-II) \(H\)  
[745.Prefix-and-Suffix-Search](https://github.com/wisdompeak/LeetCode/tree/master/Trie/745.Prefix-and-Suffix-Search) \(H-\)  
[1268.Search-Suggestions-System](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1268.Search-Suggestions-System) \(H-\)  
1032. Stream of Characters \(TBD\)  
[1858.Longest-Word-With-All-Prefixes](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1858.Longest-Word-With-All-Prefixes) \(M\)

**Trie and XOR**

[421.Maximum-XOR-of-Two-Numbers-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Trie/421.Maximum-XOR-of-Two-Numbers-in-an-Array) \(H-\)  
[1707.Maximum-XOR-With-an-Element-From-Array](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1707.Maximum-XOR-With-an-Element-From-Array) \(H-\)  
[1803.Count-Pairs-With-XOR-in-a-Range](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1803.Count-Pairs-With-XOR-in-a-Range) \(H\)  
[1938.Maximum-Genetic-Difference-Query](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1938.Maximum-Genetic-Difference-Query) \(H\)

#### [Linked List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List)

[025.Reverse-Nodes-in-k-Group](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/025.Reverse-Nodes-in-k-Group) \(H-\)  
[061.Rotate-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/061.Rotate-List) \(M\)  
082.Remove-Duplicates-from-Sorted-List-II \(M+\)  
[086.Partition-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/086.Partition-List) \(M\)  
[142.Linked-List-Cycle-II](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/142.Linked-List-Cycle-II) \(M+\)  
[109.Convert-Sorted-List-to-Binary-Search-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/109.Convert-Sorted-List-to-Binary-Search-Tree) \(M\)  
[092.Reverse-Linked-List-II](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/092.Reverse-Linked-List-II) \(H-\)  
[143.Reorder-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/143.Reorder-List) \(H-\)  
[369.Plus-One-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/369.Plus-One-Linked-List) \(M\)  
[430.Flatten-a-Multilevel-Doubly-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/430.Flatten-a-Multilevel-Doubly-Linked-List) \(H-\)  
[457.Circular-Array-Loop](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/457.Circular-Array-Loop) \(H-\)  
[708.Insert-into-a-Cyclic-Sorted-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/708.Insert-into-a-Cyclic-Sorted-List) \(H-\)  
[1474.Delete-N-Nodes-After-M-Nodes-of-a-Linked-List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/1474.Delete-N-Nodes-After-M-Nodes-of-a-Linked-List) \(M+\)  
[1670.Design-Front-Middle-Back-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/1670.Design-Front-Middle-Back-Queue) \(M+\)  
[1756.Design-Most-Recently-Used-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List/1756.Design-Most-Recently-Used-Queue) \(H\)

**Dummy node trick**

* Dummy Node trick: Maintain a list dummy head and actual tail pointer
  * Used across all linked list modification operations

```java
LinkedListNode dummy = new LinkedListNode( 0 );
LinkedListNode tail = dummy;

// append one more element to the tail
tail.next = appendedNode;
// move tail pointer forward
tail = appendedNode;

return dummy.next; // pointing to the actual list head
```

**Common tasks**

* Find median
* Reverse list
* Merge sorted list

#### [Dynamic Programming](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming)

[264.Ugly-Number-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/264.Ugly-Number-II) \(H-\)  
[313.Super-Ugly-Number](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/313.Super-Ugly-Number) \(H-\)  
[091.Decode-Ways](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/091.Decode-Ways) \(M\)  
[639.Decode-Ways-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/639.Decode-Ways-II) \(H\)  
[634.Find-the-Derangement-of-An-Array](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/634.Find-the-Derangement-of-An-Array) \(H\)  
823.Binary-Trees-With-Factors \(M+\)  
[221.Maximal-Square](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/221.Maximal-Square) \(H-\)  
[1277.Count-Square-Submatrices-with-All-Ones](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1277.Count-Square-Submatrices-with-All-Ones) \(M+\)  
[600.Non-negative-Integers-without-Consecutive-Ones](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/600.Non-negative-Integers-without-Consecutive-Ones) \(H\)  
[656.Coin-Path](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/656.Coin-Path) \(H-\)  
[053.Maximum-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/053.Maximum-Subarray) \(E+\)  
[152.Maximum-Product-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/152.Maximum-Product-Subarray) \(M+\)  
[818.Race-Car](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/818.Race-Car) \(H\)  
[377.Combination-Sum-IV](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/377.Combination-Sum-IV) \(M\)  
[837.New-21-Game](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/837.New-21-Game) \(H-\)  
[887.Super-Egg-Drop](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/887.Super-Egg-Drop) \(H\)  
[1884.Egg-Drop-With-2-Eggs-and-N-Floors](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1884.Egg-Drop-With-2-Eggs-and-N-Floors) \(H-\)  
[920.Number-of-Music-Playlists](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/920.Number-of-Music-Playlists) \(H\)  
[940.Distinct-Subsequences-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/940.Distinct-Subsequences-II) \(H\)  
[1987.Number-of-Unique-Good-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1987.Number-of-Unique-Good-Subsequences) \(H\)  
[446.Arithmetic-Slices-II-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Hash/446.Arithmetic-Slices-II-Subsequence) \(H-\)  
[1027.Longest-Arithmetic-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1027.Longest-Arithmetic-Sequence) \(M+\)  
[1269.Number-of-Ways-to-Stay-in-the-Same-Place-After-Some-Steps](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1269.Number-of-Ways-to-Stay-in-the-Same-Place-After-Some-Steps) \(M+\)  
[1316.Distinct-Echo-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1316.Distinct-Echo-Substrings) \(M+\)  
[1420.Build-Array-Where-You-Can-Find-The-Maximum-Exactly-K-Comparisons](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1420.Build-Array-Where-You-Can-Find-The-Maximum-Exactly-K-Comparisons) \(H-\)  
1444. Number of Ways of Cutting a Pizza \(TBD\)  
[1531.String-Compression-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1531.String-Compression-II) \(H+\)  
[1575.Count-All-Possible-Routes](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1575.Count-All-Possible-Routes) \(M+\)  
[1621.Number-of-Sets-of-K-Non-Overlapping-Line-Segments](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1621.Number-of-Sets-of-K-Non-Overlapping-Line-Segments) \(H\)  
[1639.Number-of-Ways-to-Form-a-Target-String-Given-a-Dictionary](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1639.Number-of-Ways-to-Form-a-Target-String-Given-a-Dictionary) \(H-\)  
[1692.Count-Ways-to-Distribute-Candies](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1692.Count-Ways-to-Distribute-Candies) \(H-\)  
[1787.Make-the-XOR-of-All-Segments-Equal-to-Zero](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1787.Make-the-XOR-of-All-Segments-Equal-to-Zero) \(H\)  
[1872.Stone-Game-VIII](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1872.Stone-Game-VIII) \(H-\)  
[1900.The-Earliest-and-Latest-Rounds-Where-Players-Compete](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1900.The-Earliest-and-Latest-Rounds-Where-Players-Compete) \(H\)  
[1937.Maximum-Number-of-Points-with-Cost](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1937.Maximum-Number-of-Points-with-Cost) \(H-\)  
[1955.Count-Number-of-Special-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1955.Count-Number-of-Special-Subsequences) \(H-\)

**基本型 I**

[198.House-Robber](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/198.House-Robber) \(E\)  
[213.House-Robber-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/213.House-Robber-II) \(M+\)  
[1388.Pizza-With-3n-Slices](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1388.Pizza-With-3n-Slices) \(H-\)  
[276.Paint-Fence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/276.Paint-Fence) \(H-\)  
[265.Paint-House-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/265.Paint-House-II) \(H\)  
[1473.Paint-House-III](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1473.Paint-House-III) \(H-\)  
[376.Wiggle-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/376.Wiggle-Subsequence) \(H-\)  
[123.Best-Time-to-Buy-and-Sell-Stock-III](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/123.Best-Time-to-Buy-and-Sell-Stock-III) \(M+\)  
[188.Best-Time-to-Buy-and-Sell-Stock-IV](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/188.Best-Time-to-Buy-and-Sell-Stock-IV) \(H\)  
[309.Best-Time-to-Buy-and-Sell-Stock-with-Cooldown](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/309.Best-Time-to-Buy-and-Sell-Stock-with-Cooldown) \(H-\)  
[714.Best-Time-to-Buy-and-Sell-Stock-with-Transaction-Fee](https://github.com/wisdompeak/LeetCode/blob/master/Dynamic_Programming/714.Best-Time-to-Buy-and-Sell-Stock-with-Transaction-Fee) \(M+\)  
[514.Freedom-Trail](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/514.Freedom-Trail) \(H-\)  
[740.Delete-and-Earn](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/740.Delete-and-Earn) \(H-\)  
[552.Student-Attendance-Record-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/552.Student-Attendance-Record-II) \(H\)  
[801.Minimum-Swaps-To-Make-Sequences-Increasing](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/801.Minimum-Swaps-To-Make-Sequences-Increasing) \(M\)  
[1223.Dice-Roll-Simulation](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1223.Dice-Roll-Simulation) \(H-\)  
[1262.Greatest-Sum-Divisible-by-Three](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1262.Greatest-Sum-Divisible-by-Three) \(M+\)  
[1363.Largest-Multiple-of-Three](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1363.Largest-Multiple-of-Three) \(H\)  
[1419.Minimum-Number-of-Frogs-Croaking](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1419.Minimum-Number-of-Frogs-Croaking) \(M\)  
[1548.The-Most-Similar-Path-in-a-Graph](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1548.The-Most-Similar-Path-in-a-Graph) \(M+\)  
[1746.Maximum-Subarray-Sum-After-One-Operation](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1746.Maximum-Subarray-Sum-After-One-Operation) \(M+\)  
[1824.Minimum-Sideway-Jumps](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1824.Minimum-Sideway-Jumps) \(M\)  
[1839.Longest-Substring-Of-All-Vowels-in-Order](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1839.Longest-Substring-Of-All-Vowels-in-Order) \(M\)  
[1883.Minimum-Skips-to-Arrive-at-Meeting-On-Time](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1883.Minimum-Skips-to-Arrive-at-Meeting-On-Time) \(H\)

**基本型 II**

[368.Largest-Divisible-Subset](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/368.Largest-Divisible-Subset) \(M+\)  
[300.Longest-Increasing-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/300.Longest-Increasing-Subsequence) \(M+\)  
[673.Number-of-Longest-Increasing-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/673.Number-of-Longest-Increasing-Subsequence) \(M+\)  
[960.Delete-Columns-to-Make-Sorted-III](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/960.Delete-Columns-to-Make-Sorted-III) \(H-\)  
[983.Minimum-Cost-For-Tickets](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/983.Minimum-Cost-For-Tickets) \(H-\)  
[1043.Partition-Array-for-Maximum-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1043.Partition-Array-for-Maximum-Sum)\(M+\)  
[1105.Filling-Bookcase-Shelves](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1105.Filling-Bookcase-Shelves) \(H-\)  
[1959.minimum-total-space-wasted-with-k-resizing-operations](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1959.minimum-total-space-wasted-with-k-resizing-operations) \(H-\)  
[1416.Restore-The-Array](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1416.Restore-The-Array) \(M+\)  
[1546.Maximum-Number-of-Non-Overlapping-Subarrays-With-Sum-Equals-Target](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1546.Maximum-Number-of-Non-Overlapping-Subarrays-With-Sum-Equals-Target) \(M+\)  
[1626.Best-Team-With-No-Conflicts](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1626.Best-Team-With-No-Conflicts) \(M\)  
[1691.Maximum-Height-by-Stacking-Cuboids](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1691.Maximum-Height-by-Stacking-Cuboids) \(H\)

**走迷宫型**

[120.Triangle](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/120.Triangle) \(E\)  
[174.Dungeon-Game](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/174.Dungeon-Game) \(H-\)  
[741.Cherry-Pickup](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/741.Cherry-Pickup) \(H-\)  
[1463.Cherry-Pickup-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1463.Cherry-Pickup-II) \(M\)  
[576.Out-of-Boundary-Paths](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/576.Out-of-Boundary-Paths) \(H\)  
[931.Minimum-Falling-Path-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/931.Minimum-Falling-Path-Sum) \(M\)  
[1289.Minimum-Falling-Path-Sum-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1289.Minimum-Falling-Path-Sum-II) \(M+\)  
[1301.Number-of-Paths-with-Max-Score](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1301.Number-of-Paths-with-Max-Score) \(M+\)  
[1594.Maximum-Non-Negative-Product-in-a-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1594.Maximum-Non-Negative-Product-in-a-Matrix) \(M\)

**背包型**

[322.Coin-Change](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/322.Coin-Change) \(M\)  
[416.Partition-Equal-Subset-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/416.Partition-Equal-Subset-Sum) \(M+\)  
[518.Coin-Change-2](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/518.Coin-Change-2) \(H-\)  
[474.Ones-and-Zeroes](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/474.Ones-and-Zeroes) \(H-\)  
[494.Target-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/494.Target-Sum) \(M+\)  
[805.Split-Array-With-Same-Average](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/805.Split-Array-With-Same-Average) \(H\)  
[879.Profitable-Schemes](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/879.Profitable-Schemes) \(M+\)  
[956.Tallest-Billboard](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/956.Tallest-Billboard) \(H\)  
[1049.Last-Stone-Weight-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1049.Last-Stone-Weight-II) \(H-\)  
[1449.Form-Largest-Integer-With-Digits-That-Add-up-to-Target](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1449.Form-Largest-Integer-With-Digits-That-Add-up-to-Target) \(H-\)  
[1981.Minimize-the-Difference-Between-Target-and-Chosen-Elements](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1981.Minimize-the-Difference-Between-Target-and-Chosen-Elements) \(M+\)

**键盘型**

[650.2-Keys-Keyboard](https://github.com/wisdompeak/LeetCode/blob/master/Dynamic_Programming/650.2-Keys-Keyboard) \(M+\)  
[651.4-Keys-Keyboard](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/651.4-Keys-Keyboard) \(M+\)  
[935.Knight-Dialer](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/935.Knight-Dialer) \(M\)  
[1320.Minimum-Distance-to-Type-a-Word-Using-Two-Fingers](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1320.Minimum-Distance-to-Type-a-Word-Using-Two-Fingers) \(H\)

**To Do or Not To Do**

[487.Max-Consecutive-Ones-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/487.Max-Consecutive-Ones-II) \(H-\)  
[1186.Maximum-Subarray-Sum-with-One-Deletion](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1186.Maximum-Subarray-Sum-with-One-Deletion) \(H-\)  
[1187.Make-Array-Strictly-Increasing](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1187.Make-Array-Strictly-Increasing) \(H-\)  
[1909.Remove-One-Element-to-Make-the-Array-Strictly-Increasing](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1909.Remove-One-Element-to-Make-the-Array-Strictly-Increasing) \(H-\)

**区间型 I**

[132.Palindrome-Partitioning-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/132.Palindrome-Partitioning-II) \(H-\)  
[410.Split-Array-Largest-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/410.Split-Array-Largest-Sum) \(H\)  
[813.Largest-Sum-of-Averages](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/813.Largest-Sum-of-Averages) \(H-\)  
[1278.Palindrome-Partitioning-III](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1278.Palindrome-Partitioning-III) \(H\)  
[1335.Minimum-Difficulty-of-a-Job-Schedule](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1335.Minimum-Difficulty-of-a-Job-Schedule) \(M+\)  
[1478.Allocate-Mailboxes](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1478.Allocate-Mailboxes) \(H\)  
[1977.Number-of-Ways-to-Separate-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1977.Number-of-Ways-to-Separate-Numbers) \(H\)

**区间型 II**

[131.Palindrome-Partitioning](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/131.Palindrome-Partitioning) \(M+\)  
[312.Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/DFS/312.Burst-Balloons) \(H-\)  
[375.Guess-Number-Higher-or-Lower-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/375.Guess-Number-Higher-or-Lower-II) \(H\)  
[471.Encode-String-with-Shortest-Length](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/471.Encode-String-with-Shortest-Length) \(H\)  
[516.Longest-Palindromic-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/516.Longest-Palindromic-Subsequence) \(H-\)  
[546.Remove-Boxes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/546.Remove-Boxes) \(H+\)  
[664.Strange-Printer](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/664.Strange-Printer) \(H\)  
[730.Count-Different-Palindromic-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/730.Count-Different-Palindromic-Subsequences) \(H\)  
[1000.Minimum-Cost-to-Merge-Stones](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1000.Minimum-Cost-to-Merge-Stones) \(H\)  
[1130.Minimum-Cost-Tree-From-Leaf-Values](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1130.Minimum-Cost-Tree-From-Leaf-Values) \(M+\)  
[1246.Palindrome-Removal](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1246.Palindrome-Removal) \(H\)  
[1039.Minimum-Score-Triangulation-of-Polygon](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1039.Minimum-Score-Triangulation-of-Polygon) \(H\)  
[1547.Minimum-Cost-to-Cut-a-Stick](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1547.Minimum-Cost-to-Cut-a-Stick) \(M\)  
[1682.Longest-Palindromic-Subsequence-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1682.Longest-Palindromic-Subsequence-II) \(H\)  
[1690.Stone-Game-VII](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1690.Stone-Game-VII) \(H-\)  
[1745.Palindrome-Partitioning-IV](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1745.Palindrome-Partitioning-IV) \(M\)  
[1770.Maximum-Score-from-Performing-Multiplication-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1770.Maximum-Score-from-Performing-Multiplication-Operations) \(H-\)

**双序列型**

[010.Regular-Expression-Matching](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/010.Regular-Expression-Matching) \(H\)  
[044.Wildcard-Matching](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/044.Wildcard-Matching) \(H-\)  
[097.Interleaving-String](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/097.Interleaving-String) \(H-\)  
[072.Edit-Distance](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/072.Edit-Distance) \(H-\)  
[115.Distinct-Subsequences](https://github.com/wisdompeak/LeetCode/blob/master/Dynamic_Programming/115.Distinct-Subsequences/) \(H-\)  
[583.Delete-Operation-for-Two-Strings](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/583.Delete-Operation-for-Two-Strings) \(M+\)  
[712.Minimum-ASCII-Delete-Sum-for-Two-Strings](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/712.Minimum-ASCII-Delete-Sum-for-Two-Strings) \(M+\)  
[718.Maximum-Length-of-Repeated-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/718.Maximum-Length-of-Repeated-Subarray) \(M\)  
[727.Minimum-Window-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/727.Minimum-Window-Subsequence) \(H-\)  
[1035.Uncrossed-Lines](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1035.Uncrossed-Lines) \(M\)  
[1092.Shortest-Common-Supersequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1092.Shortest-Common-Supersequence) \(H-\)  
[1143.Longest-Common-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1143.Longest-Common-Subsequence) \(M\)  
[1216.Valid-Palindrome-III](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1216.Valid-Palindrome-III) \(M+\)  
[1312.Minimum-Insertion-Steps-to-Make-a-String-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1312.Minimum-Insertion-Steps-to-Make-a-String-Palindrome) \(M+\)  
[1458.Max-Dot-Product-of-Two-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1458.Max-Dot-Product-of-Two-Subsequences) \(M\)  
[1771.Maximize-Palindrome-Length-From-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1771.Maximize-Palindrome-Length-From-Subsequences) \(H\)

**状态压缩DP**

[465.Optimal-Account-Balancing](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/465.Optimal-Account-Balancing) \(H\)  
[691.Stickers-to-Spell-Word](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/691.Stickers-to-Spell-Word) \(H\)  
[943.Find-the-Shortest-Superstring](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/943.Find-the-Shortest-Superstring) \(H+\)  
[1125.Smallest-Sufficient-Team](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1125.Smallest-Sufficient-Team) \(H\)  
[1349.Maximum-Students-Taking-Exam](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1349.Maximum-Students-Taking-Exam) \(H\)  
[1411.Number-of-Ways-to-Paint-N×3-Grid](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1411.Number-of-Ways-to-Paint-N%C3%973-Grid) \(M\)  
[1434.Number-of-Ways-to-Wear-Different-Hats-to-Each-Other](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1434.Number-of-Ways-to-Wear-Different-Hats-to-Each-Other) \(H-\)  
[1595.Minimum-Cost-to-Connect-Two-Groups-of-Points](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1595.Minimum-Cost-to-Connect-Two-Groups-of-Points) \(H\)  
[1659.Maximize-Grid-Happiness](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1659.Maximize-Grid-Happiness) \(H\)  
[1681.Minimum-Incompatibility](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1681.Minimum-Incompatibility) \(H\)  
[1723.Find-Minimum-Time-to-Finish-All-Jobs](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1723.Find-Minimum-Time-to-Finish-All-Jobs) \(H-\)  
[1799.Maximize-Score-After-N-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1799.Maximize-Score-After-N-Operations) \(H-\)  
[1931.Painting-a-Grid-With-Three-Different-Colors](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1931.Painting-a-Grid-With-Three-Different-Colors) \(M+\)  
[1994.The-Number-of-Good-Subsets](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1994.The-Number-of-Good-Subsets) \(H\)

**枚举集合的子集**

[1494.Parallel-Courses-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1494.Parallel-Courses-II) \(H\)  
[1655.Distribute-Repeating-Integers](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1655.Distribute-Repeating-Integers) \(H\)  
[1986.Minimum-Number-of-Work-Sessions-to-Finish-the-Tasks](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1986.Minimum-Number-of-Work-Sessions-to-Finish-the-Tasks) \(M+\)

**二分图**

[1066.Campus-Bikes-II](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1066.Campus-Bikes-II) \(H+\)  
[1879.Minimum-XOR-Sum-of-Two-Arrays](https://github.com/wisdompeak/LeetCode/tree/master/BFS/1879.Minimum-XOR-Sum-of-Two-Arrays) \(H\)  
[1947.Maximum-Compatibility-Score-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1947.Maximum-Compatibility-Score-Sum) \(H\)

**Catalan**

[096.Unique-Binary-Search-Trees](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/096.Unique-Binary-Search-Trees) \(M+\)  
\[1259.Handshakes-That-Don't-Cross\]\(\[[https://github.com/wisdompeak/LeetCode/tree/master/Dynamic\_Programming/1259.Handshakes-That-Don't-Cross\]\(https://github.com/wisdompeak/LeetCode/tree/master/Dynamic\_Programming/1259.Handshakes-That-Don't-Cross\)\](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1259.Handshakes-That-Don't-Cross]%28https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1259.Handshakes-That-Don't-Cross%29\)\) \(M+\)

**Permutation**

[629.K-Inverse-Pairs-Array](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/629.K-Inverse-Pairs-Array) \(H\)  
[903.Valid-Permutations-for-DI-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/903.Valid-Permutations-for-DI-Sequence) \(H\)  
[1866.Number-of-Ways-to-Rearrange-Sticks-With-K-Sticks-Visible](https://github.com/wisdompeak/LeetCode/tree/master/Math/1866.Number-of-Ways-to-Rearrange-Sticks-With-K-Sticks-Visible) \(H\)

#### [Bit Manipulation](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation)

[137.Single-Number-II](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/137.Single-Number-II) \(H-\)  
[260.Single-Number-III](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/260.Single-Number-III) \(H\)  
371.Sum-of-Two-Integers \(H\)  
[318.Maximum-Product-of-Word-Lengths](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/318.Maximum-Product-of-Word-Lengths) \(M+\)  
342.Power-of-Four \(H\)  
[957.Prison-Cells-After-N-Days](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/957.Prison-Cells-After-N-Days) \(H\)  
1461.Check-If-a-String-Contains-All-Binary-Codes-of-Size-K \(TBD\)  
[1521.Find-a-Value-of-a-Mysterious-Function-Closest-to-Target](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1521.Find-a-Value-of-a-Mysterious-Function-Closest-to-Target) \(H-\)

**Common tasks**

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

**XOR**

[136.Single-Number](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/136.Single-Number) \(M\)  
[268.Missing-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/268.Missing-Number) \(H-\)  
[1310.XOR-Queries-of-a-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1310.XOR-Queries-of-a-Subarray) \(M\)  
[1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1442.Count-Triplets-That-Can-Form-Two-Arrays-of-Equal-XOR) \(M+\)  
[1506.Find-Root-of-N-Ary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1506.Find-Root-of-N-Ary-Tree) \(M+\)  
[1734.Decode-XORed-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1734.Decode-XORed-Permutation) \(M+\)  
[1738.Find-Kth-Largest-XOR-Coordinate-Value](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1738.Find-Kth-Largest-XOR-Coordinate-Value) \(M+\)  
[1835.Find-XOR-Sum-of-All-Pairs-Bitwise-AND](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1835.Find-XOR-Sum-of-All-Pairs-Bitwise-AND) \(M\)

**Bit Mask**

[1239.Maximum-Length-of-a-Concatenated-String-with-Unique-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1239.Maximum-Length-of-a-Concatenated-String-with-Unique-Characters) \(M+\)  
[1284.Minimum-Number-of-Flips-to-Convert-Binary-Matrix-to-Zero-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1284.Minimum-Number-of-Flips-to-Convert-Binary-Matrix-to-Zero-Matrix) \(M+\)  
[1452.People-Whose-List-of-Favorite-Companies-Is-Not-a-Subset-of-Another-List](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1452.People-Whose-List-of-Favorite-Companies-Is-Not-a-Subset-of-Another-List) \(H-\)  
[1601.Maximum-Number-of-Achievable-Transfer-Requests](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1601.Maximum-Number-of-Achievable-Transfer-Requests) \(H-\)  
[1755.Closest-Subsequence-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1755.Closest-Subsequence-Sum) \(H\)  
[1774.Closest-Dessert-Cost](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/1774.Closest-Dessert-Cost) \(M\)  
[2002.Maximum-Product-of-the-Length-of-Two-Palindromic-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Bit_Manipulation/2002.Maximum-Product-of-the-Length-of-Two-Palindromic-Subsequences)

#### [Divide and Conquer](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer)

[315.Count-of-Smaller-Numbers-After-Self](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/315.Count-of-Smaller-Numbers-After-Self) \(H-\)  
[327.Count-of-Range-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/327.Count-of-Range-Sum) \(H-\)  
[493.Reverse-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/493.Reverse-Pairs) \(M+\)  
[1649.Create-Sorted-Array-through-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/1649.Create-Sorted-Array-through-Instructions) \(H\)

#### [String](https://github.com/wisdompeak/LeetCode/tree/master/String)

[006.ZigZag-Conversion](https://github.com/wisdompeak/LeetCode/tree/master/String/006.ZigZag-Conversion) \(M+\)  
[336.Palindrome-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/String/336.Palindrome-Pairs) \(H-\)  
[388.Longest-Absolute-File-Path](https://github.com/wisdompeak/LeetCode/tree/master/String/388.Longest-Absolute-File-Path) \(M+\)  
[408.Valid-Word-Abbreviation](https://github.com/wisdompeak/LeetCode/tree/master/String/408.Valid-Word-Abbreviation) \(M\)  
411.Minimum-Unique-Word-Abbreviation \(H\)  
[418.Sentence-Screen-Fitting](https://github.com/wisdompeak/LeetCode/tree/master/String/418.Sentence-Screen-Fitting) \(M+\)  
[423.Reconstruct-Original-Digits-from-English](https://github.com/wisdompeak/LeetCode/tree/master/Others/423.Reconstruct-Original-Digits-from-English) \(H-\)  
[527.Word-Abbreviation](https://github.com/wisdompeak/LeetCode/tree/master/String/527.Word-Abbreviation) \(M+\)  
[556.Next Greater Element III](https://github.com/wisdompeak/LeetCode/tree/master/String/556.Next-Greater-Element-III) \(H-\)  
616.Add-Bold-Tag-in-String \(M\)  
[467.Unique-Substrings-in-Wraparound-String](https://github.com/wisdompeak/LeetCode/tree/master/String/467.Unique-Substrings-in-Wraparound-String) \(H-\)  
[564.Find-the-Closest-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/String/564.Find-the-Closest-Palindrome) \(H\)  
722.Remove-Comments \(H\)  
[736.Parse-Lisp-Expression](https://github.com/wisdompeak/LeetCode/tree/master/String/736.Parse-Lisp-Expression) \(H-\)  
[816.Ambiguous-Coordinates](https://github.com/wisdompeak/LeetCode/tree/master/String/816.Ambiguous-Coordinates) \(M+\)  
[844.Backspace-String-Compare](https://github.com/wisdompeak/LeetCode/tree/master/String/844.Backspace-String-Compare) \(M+\)  
[1616.Split-Two-Strings-to-Make-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/String/1616.Split-Two-Strings-to-Make-Palindrome) \(M+\)  
[1754.Largest-Merge-Of-Two-Strings](https://github.com/wisdompeak/LeetCode/tree/master/String/1754.Largest-Merge-Of-Two-Strings) \(M+\)  
[1849.Splitting-a-String-Into-Descending-Consecutive-Values](https://github.com/wisdompeak/LeetCode/tree/master/String/1849.Splitting-a-String-Into-Descending-Consecutive-Values) \(M+\)

**Rolling Hash**

[1044.Longest-Duplicate-Substring](https://github.com/wisdompeak/LeetCode/tree/master/String/1044.Longest-Duplicate-Substring) \(H\)  
[1062.Longest-Repeating-Substring](https://github.com/wisdompeak/LeetCode/tree/master/String/1062.Longest-Repeating-Substring) \(H-\)  
[1554.Strings-Differ-by-One-Character](https://github.com/wisdompeak/LeetCode/tree/master/String/1554.Strings-Differ-by-One-Character) \(H\)  
[1698.Number-of-Distinct-Substrings-in-a-String](https://github.com/wisdompeak/LeetCode/tree/master/String/1698.Number-of-Distinct-Substrings-in-a-String) \(H-\)  
[1923.Longest-Common-Subpath](https://github.com/wisdompeak/LeetCode/tree/master/String/1923.Longest-Common-Subpath) \(H\)

**KMP**

[1392.Longest-Happy-Prefix](https://github.com/wisdompeak/LeetCode/tree/master/String/1392.Longest-Happy-Prefix) \(H\)  
[028.Implement-strStr](https://github.com/wisdompeak/LeetCode/tree/master/String/028.Implement-strStr) \(H\)  
[214.Shortest-Palindrome](https://github.com/wisdompeak/LeetCode/blob/master/String/214.Shortest-Palindrome) \(H\)  
[459.Repeated-Substring-Pattern](https://github.com/wisdompeak/LeetCode/tree/master/String/459.Repeated-Substring-Pattern) \(H\)  
[572.Subtree-of-Another-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/572.Subtree-of-Another-Tree) \(H\)  
[1367.Linked-List-in-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/String/1367.Linked-List-in-Binary-Tree) \(H\)  
1397.Find All Good Strings \(TBD\)  
[1764.Form-Array-by-Concatenating-Subarrays-of-Another-Array](https://github.com/wisdompeak/LeetCode/tree/master/String/1764.Form-Array-by-Concatenating-Subarrays-of-Another-Array) \(H\)

**Manacher**

[005.Longest-Palindromic-Substring](https://github.com/wisdompeak/LeetCode/tree/master/String/005.Longest-Palindromic-Substring) \(H\)  
[214.Shortest-Palindrome](https://github.com/wisdompeak/LeetCode/blob/master/String/214.Shortest-Palindrome) \(H\)  
[647.Palindromic-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/String/647.Palindromic-Substrings) \(M+\)  
[1960.Maximum-Product-of-the-Length-of-Two-Palindromic-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/String/1960.Maximum-Product-of-the-Length-of-Two-Palindromic-Substrings) \(H\)

**Palindrome**

* Several ways to solve the Longest palindrome substring problem
  * DP-based solution: O\(n^2\) space and time, if need to storing palindrome result, this is always better \(e.g. palindrome partitioning\)
  * Start looping from middle: O\(n^2\) time
  * Manacher's algorithm: O\(n\) time, not generic enough.

#### [Union Find](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find)

[547.Friend-Circles](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/547.Friend-Circles) \(M\)  
[200.Number-of-Islands](https://github.com/wisdompeak/LeetCode/tree/master/DFS/200.Number-of-Islands) \(H-\)  
[305.Number-of-Islands-II](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/305.Number-of-Islands-II) \(H-\)  
[130.Surrounded-Regions](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/130.Surrounded-Regions) \(H-\)  
[128.Longest-Consecutive-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/128.Longest-Consecutive-Sequence) \(H-\)  
[684.Redundant-Connection](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/684.Redundant-Connection) \(M\)  
[685.Redundant-Connection-II](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/685.Redundant-Connection-II) \(H\)  
[721.Accounts-Merge](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/721.Accounts-Merge) \(M+\)  
[765.Couples-Holding-Hands](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/765.Couples-Holding-Hands) \(H-\)  
[785.Is-Graph-Bipartite](https://github.com/wisdompeak/LeetCode/tree/master/BFS/785.Is-Graph-Bipartite) \(M+\)  
[924.Minimize-Malware-Spread](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/924.Minimize-Malware-Spread) \(H-\)  
[947.Most-Stones-Removed-with-Same-Row-or-Column](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/947.Most-Stones-Removed-with-Same-Row-or-Column) \(M+\)  
[959.Regions-Cut-By-Slashes](https://github.com/wisdompeak/LeetCode/tree/master/DFS/959.Regions-Cut-By-Slashes) \(H-\)  
[990.Satisfiability-of-Equality-Equations](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/990.Satisfiability-of-Equality-Equations) \(M+\)  
[1061.Lexicographically-Smallest-Equivalent-String](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1061.Lexicographically-Smallest-Equivalent-String) \(M\)  
[1101.The-Earliest-Moment-When-Everyone-Become-Friends](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1101.The-Earliest-Moment-When-Everyone-Become-Friends) \(M+\)  
[1202.Smallest-String-With-Swaps](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1202.Smallest-String-With-Swaps) \(M+\)  
[1319.Number-of-Operations-to-Make-Network-Connected](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1319.Number-of-Operations-to-Make-Network-Connected) \(M+\)  
[1632.Rank-Transform-of-a-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1632.Rank-Transform-of-a-Matrix) \(H\)  
[1631.Path-With-Minimum-Effort](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1631.Path-With-Minimum-Effort) \(H-\)  
[1697.Checking-Existence-of-Edge-Length-Limited-Paths](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1697.Checking-Existence-of-Edge-Length-Limited-Paths) \(H-\)  
[1724.Checking-Existence-of-Edge-Length-Limited-Paths-II](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1724.Checking-Existence-of-Edge-Length-Limited-Paths-II) \(H+\)  
[1722.Minimize-Hamming-Distance-After-Swap-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1722.Minimize-Hamming-Distance-After-Swap-Operations) \(M+\)  
[803.Bricks-Falling-When-Hit](https://github.com/wisdompeak/LeetCode/tree/master/DFS/803.Bricks-Falling-When-Hit) \(H\)  
[1970.Last-Day-Where-You-Can-Still-Cross](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1970.Last-Day-Where-You-Can-Still-Cross) \(H-\)

**Patterns**

* Suitable in a dynamically changing graph. 
  * Complexity: O\(lgn\)
  * Example problems: Number of Island II, find weakly connected components in directed graph, find connected components in undirected graph

```java
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

**Prime Factors**

[952.Largest-Component-Size-by-Common-Factor](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/952.Largest-Component-Size-by-Common-Factor) \(H\)  
[1627.Graph-Connectivity-With-Threshold](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1627.Graph-Connectivity-With-Threshold) \(M+\)  
[1998.GCD-Sort-of-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1998.GCD-Sort-of-an-Array) \(H-\)

**MST**

[1135.Connecting-Cities-With-Minimum-Cost](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1135.Connecting-Cities-With-Minimum-Cost) \(M+\)  
[1168.Optimize-Water-Distribution-in-a-Village](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1168.Optimize-Water-Distribution-in-a-Village) \(H-\)  
[1489.Find-Critical-and-Pseudo-Critical-Edges-in-Minimum-Spanning-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1489.Find-Critical-and-Pseudo-Critical-Edges-in-Minimum-Spanning-Tree) \(H\)  
[1579.Remove-Max-Number-of-Edges-to-Keep-Graph-Fully-Traversable](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1579.Remove-Max-Number-of-Edges-to-Keep-Graph-Fully-Traversable) \(H-\)  
[1584.Min-Cost-to-Connect-All-Points](https://github.com/wisdompeak/LeetCode/tree/master/Union_Find/1584.Min-Cost-to-Connect-All-Points) \(H-\)

#### [Recursion](https://github.com/wisdompeak/LeetCode/tree/master/Recursion)

[087.Scramble-String](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/087.Scramble-String) \(H-\)  
[133.Clone-Graph](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/133.Clone-Graph) \(M+\)  
[213.House-Robber-II](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/213.House-Robber-II) \(H-\)  
[337.House-Robber-III](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/337.House-Robber-III) \(M+\)  
[241.Different-Ways-to-Add-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/241.Different-Ways-to-Add-Parentheses) \(H-\)  
[390.Elimination-Game](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/390.Elimination-Game) \(H\)  
[395.Longest-Substring-with-At-Least-K-Repeating-Characters](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/395.Longest-Substring-with-At-Least-K-Repeating-Characters) \(H\)  
[397.Integer-Replacement](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/397.Integer-Replacement) \(M+\)  
440.K-th-Smallest-in-Lexicographical-Order \(H\)  
[679.24-Game](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/679.24-Game) \(H\)  
[761.Special-Binary-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/761.Special-Binary-String) \(H\)  
779.K-th-Symbol-in-Grammar \(M\)  
[780.Reaching-Points](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/780.Reaching-Points) \(H-\)  
[808.Soup-Servings](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/808.Soup-Servings) \(H\)  
[880.Decoded-String-at-Index](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/880.Decoded-String-at-Index) \(H-\)  
[902.Numbers-At-Most-N-Given-Digit-Set](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/902.Numbers-At-Most-N-Given-Digit-Set) \(M\)  
[964.Least-Operators-to-Express-Number](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/964.Least-Operators-to-Express-Number) \(H\)  
[991.Broken-Calculator](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/991.Broken-Calculator) \(M\)  
[1088.Confusing-Number-II](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1088.Confusing-Number-II) \(H\)  
[1199.Minimum-Time-to-Build-Blocks](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1199.Minimum-Time-to-Build-Blocks) \(H+\)  
[1274.Number-of-Ships-in-a-Rectangle](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1274.Number-of-Ships-in-a-Rectangle) \(M\)  
[1415.The-k-th-Lexicographical-String-of-All-Happy-Strings-of-Length-n](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1415.The-k-th-Lexicographical-String-of-All-Happy-Strings-of-Length-n) \(H-\)  
1545. Find Kth Bit in Nth Binary String \(TBD\)  
[1553.Minimum-Number-of-Days-to-Eat-N-Oranges](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1553.Minimum-Number-of-Days-to-Eat-N-Oranges) \(H\)  
[1611.Minimum-One-Bit-Operations-to-Make-Integers-Zero](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1611.Minimum-One-Bit-Operations-to-Make-Integers-Zero) \(H\)

**Min-Max Strategy**

[464.Can-I-Win](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/464.Can-I-Win) \(M+\)  
[877.Stone-Game](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/877.Stone-Game) \(M+\) \(aka. 486.Predict-the-Winner\)  
[1140.Stone-Game-II](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1140.Stone-Game-II) \(M\)  
[1406.Stone-Game-III](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1406.Stone-Game-III) \(M+\)  
[1510.Stone-Game-IV](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/1510.Stone-Game-IV) \(M\)  
[1563.Stone-Game-V](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1563.Stone-Game-V) \(H-\)

#### [Graph](https://github.com/wisdompeak/LeetCode/tree/master/Graph/)

[332.Reconstruct-Itinerary](https://github.com/wisdompeak/LeetCode/tree/master/DFS/332.Reconstruct-Itinerary) \(H\)  
[753.Cracking-the-Safe](https://github.com/wisdompeak/LeetCode/tree/master/Hash/753.Cracking-the-Safe) \(H\)  
[1059.All-Paths-from-Source-Lead-to-Destination](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1059.All-Paths-from-Source-Lead-to-Destination) \(H\)  
[1192.Critical-Connections-in-a-Network](https://github.com/wisdompeak/LeetCode/tree/master/DFS/1192.Critical-Connections-in-a-Network) \(H\)  
1334.Find-the-City-With-the-Smallest-Number-of-Neighbors-at-a-Threshold-Distance \(TBD\)  
1361.Validate-Binary-Tree-Nodes \(TBD\)  
[1719.Number-Of-Ways-To-Reconstruct-A-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1719.Number-Of-Ways-To-Reconstruct-A-Tree) \(H+\)  
[1761.Minimum-Degree-of-a-Connected-Trio-in-a-Graph](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1761.Minimum-Degree-of-a-Connected-Trio-in-a-Graph) \(M+\)  
[1782.Count-Pairs-Of-Nodes](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1782.Count-Pairs-Of-Nodes) \(H\)  
[1820.Maximum-Number-of-Accepted-Invitations](https://github.com/wisdompeak/LeetCode/tree/master/Graph/1820.Maximum-Number-of-Accepted-Invitations) \(H\)

#### [Math](https://github.com/wisdompeak/LeetCode/tree/master/Math)

[089.Gray-Code](https://github.com/wisdompeak/LeetCode/tree/master/Math/089.Gray-Code) \(M+\) \(aka. 1238. Circular Permutation in Binary Representation\)  
[233.Number-of-Digit-One](https://github.com/wisdompeak/LeetCode/tree/master/Math/233.Number-of-Digit-One) \(H-\)  
458.Poor-Pigs \(H\)  
[400.n-th-digit](https://github.com/wisdompeak/LeetCode/tree/master/Math/400.n-th-digit) \(M\)  
[441.Arranging-Coins](https://github.com/wisdompeak/LeetCode/tree/master/Math/441.Arranging-Coins) \(M-\)  
[628.Maximum-Product-of-Three-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/628.Maximum-Product-of-Three-Numbers) \(M\)  
[672.Bulb-Switcher-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/672.Bulb-Switcher-II) \(H\)  
[754.Reach-a-Number](https://github.com/wisdompeak/LeetCode/tree/master/Math/754.Reach-a-Number) \(H\)  
[829.Consecutive-Numbers-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Math/829.Consecutive-Numbers-Sum) \(M\)  
[878.Nth-Magical-Number](https://github.com/wisdompeak/LeetCode/tree/master/Math/878.Nth-Magical-Number) \(M+\)  
[883.Projection-Area-of-3D-Shapes](https://github.com/wisdompeak/LeetCode/tree/master/Math/883.Projection-Area-of-3D-Shapes) \(E+\)  
[891.Sum-of-Subsequence-Widths](https://github.com/wisdompeak/LeetCode/tree/master/Math/891.Sum-of-Subsequence-Widths) \(M+\)  
[899.Orderly-Queue](https://github.com/wisdompeak/LeetCode/tree/master/Math/899.Orderly-Queue) \(M\)  
[963.Minimum-Area-Rectangle-II](https://github.com/wisdompeak/LeetCode/tree/master/Math/963.Minimum-Area-Rectangle-II) \(H-\)  
[964.Least-Operators-to-Express-Number](https://github.com/wisdompeak/LeetCode/tree/master/Recursion/964.Least-Operators-to-Express-Number) \(H\)  
[972.Equal-Rational-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/972.Equal-Rational-Numbers) \(H\)  
[1012.Numbers-With-Repeated-Digits](https://github.com/wisdompeak/LeetCode/tree/master/Math/1012.Numbers-With-Repeated-Digits) \(H-\)  
[1017.Convert-to-Base--2](https://github.com/wisdompeak/LeetCode/tree/master/Math/1017.Convert-to-Base--2) \(M+\)  
[1073.Adding-Two-Negabinary-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/1073.Adding-Two-Negabinary-Numbers) \(H-\)  
[1025.Divisor-Game](https://github.com/wisdompeak/LeetCode/tree/master/Math/1025.Divisor-Game) \(M\)  
[1040.Moving-Stones-Until-Consecutive-II](https://github.com/wisdompeak/LeetCode/tree/master/Math/1040.Moving-Stones-Until-Consecutive-II) \(H\)  
[1015.Smallest-Integer-Divisible-by-K](https://github.com/wisdompeak/LeetCode/tree/master/Math/1015.Smallest-Integer-Divisible-by-K) \(M+\)  
[1103.Distribute-Candies-to-People](https://github.com/wisdompeak/LeetCode/tree/master/Math/1103.Distribute-Candies-to-People) \(M+\)  
1330.Reverse-Subarray-To-Maximize-Array-Value \(TBD\)  
[1250.Check-If-It-Is-a-Good-Array](https://github.com/wisdompeak/LeetCode/tree/master/Math/1250.Check-If-It-Is-a-Good-Array) \(M+\)  
[1605.Find-Valid-Matrix-Given-Row-and-Column-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Math/1605.Find-Valid-Matrix-Given-Row-and-Column-Sums) \(M+\)  
[1680.Concatenation-of-Consecutive-Binary-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Math/1680.Concatenation-of-Consecutive-Binary-Numbers) \(M\)  
[1739.Building-Boxes](https://github.com/wisdompeak/LeetCode/tree/master/Math/1739.Building-Boxes) \(H-\)  
[1806.Minimum-Number-of-Operations-to-Reinitialize-a-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Math/1806.Minimum-Number-of-Operations-to-Reinitialize-a-Permutation) \(H\)  
[1969.Minimum-Non-Zero-Product-of-the-Array-Elements](https://github.com/wisdompeak/LeetCode/tree/master/Math/1969.Minimum-Non-Zero-Product-of-the-Array-Elements) \(M+\)

**Distances**

[296.Best-Meeting-Point](https://github.com/wisdompeak/LeetCode/tree/master/Math/296.Best-Meeting-Point) \(M+\)  
[1131.Maximum-of-Absolute-Value-Expression](https://github.com/wisdompeak/LeetCode/tree/master/Math/1131.Maximum-of-Absolute-Value-Expression) \(H\)  
1515.Best Position for a Service Centre \(TBD\)  
[1703.Minimum-Adjacent-Swaps-for-K-Consecutive-Ones](https://github.com/wisdompeak/LeetCode/tree/master/Math/1703.Minimum-Adjacent-Swaps-for-K-Consecutive-Ones) \(H\)  
[1956.Minimum-Time-For-K-Virus-Variants-to-Spread](https://github.com/wisdompeak/LeetCode/tree/master/Math/1956.Minimum-Time-For-K-Virus-Variants-to-Spread) \(H+\)

**Geometry**

[223.Rectangle-Area](https://github.com/wisdompeak/LeetCode/tree/master/Math/223.Rectangle-Area) \(M+\)  
[335.Self-Crossing](https://github.com/wisdompeak/LeetCode/tree/master/Math/335.Self-Crossing) \(H\)  
391.Perfect-Rectangle \(H\)  
[587.Erect-the-Fence](https://github.com/wisdompeak/LeetCode/tree/master/Math/587.Erect-the-Fence) \(H\)  
[593.Valid-Square](https://github.com/wisdompeak/LeetCode/tree/master/Math/593.Valid-Square) \(H\)  
[858.Mirror-Reflection](https://github.com/wisdompeak/LeetCode/tree/master/Math/858.Mirror-Reflection) \(H\)  
[1401.Circle-and-Rectangle-Overlapping](https://github.com/wisdompeak/LeetCode/tree/master/Math/1401.Circle-and-Rectangle-Overlapping) \(H\)  
[1453.Maximum-Number-of-Darts-Inside-of-a-Circular-Dartboard](https://github.com/wisdompeak/LeetCode/tree/master/Math/1453.Maximum-Number-of-Darts-Inside-of-a-Circular-Dartboard) \(H\)  
[1610.Maximum-Number-of-Visible-Points](https://github.com/wisdompeak/LeetCode/tree/master/Math/1610.Maximum-Number-of-Visible-Points) \(H\)

**Random Pick**

[382.Linked-List-Random-Node](https://github.com/wisdompeak/LeetCode/tree/master/Math/382.Linked-List-Random-Node) \(H\)  
[470.Implement-Rand10\(\)-Using-Rand7\(\)](https://github.com/wisdompeak/LeetCode/tree/master/Math/470.Implement-Rand10--Using-Rand7) \(M+\)  
[478.Generate-Random-Point-in-a-Circle](https://github.com/wisdompeak/LeetCode/tree/master/Math/478.Generate-Random-Point-in-a-Circle) \(H-\)  
[497.Random-Point-in-Non-overlapping-Rectangles](https://github.com/wisdompeak/LeetCode/tree/master/Math/497.Random-Point-in-Non-overlapping-Rectangles) \(M+\)  
[519.Random-Flip-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Math/519.Random-Flip-Matrix) \(H-\)  
[528.Random-Pick-with-Weight](https://github.com/wisdompeak/LeetCode/tree/master/Math/528.Random-Pick-with-Weight) \(H-\)  
[710.Random-Pick-with-Blacklist](https://github.com/wisdompeak/LeetCode/tree/master/Math/710.Random-Pick-with-Blacklist) \(M+\)  
[1227.Airplane-Seat-Assignment-Probability](https://github.com/wisdompeak/LeetCode/tree/master/Math/1227.Airplane-Seat-Assignment-Probability) \(M+\)

**Random pattern**

* Reservoir sampling: sample k from n
  * Example problems: Shuffle an array, Random pick index, Linked list random node.

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

**Combinatorics**

[046.Permutations](https://github.com/wisdompeak/LeetCode/tree/master/Math/046.Permutations) \(M+\)  
[047.Permutations-II](https://github.com/wisdompeak/LeetCode/tree/master/Math/047.Permutations-II) \(H\)  
[060.Permutation-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Math/060.Permutation-Sequence) \(H\)  
[077.Combinations](https://github.com/wisdompeak/LeetCode/blob/master/Math/077.Combinations) \(H-\)  
[1286.Iterator-for-Combination](https://github.com/wisdompeak/LeetCode/tree/master/Math/1286.Iterator-for-Combination) \(M+\)  
[1359.Count-All-Valid-Pickup-and-Delivery-Options](https://github.com/wisdompeak/LeetCode/tree/master/Math/1359.Count-All-Valid-Pickup-and-Delivery-Options) \(M+\)  
[1467.Probability-of-a-Two-Boxes-Having-The-Same-Number-of-Distinct-Balls](https://github.com/wisdompeak/LeetCode/tree/master/Math/1467.Probability-of-a-Two-Boxes-Having-The-Same-Number-of-Distinct-Balls) \(H-\)  
[1641.Count-Sorted-Vowel-Strings](https://github.com/wisdompeak/LeetCode/tree/master/Math/1641.Count-Sorted-Vowel-Strings) \(M+\)  
[1643.Kth-Smallest-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Math/1643.Kth-Smallest-Instructions) \(M+\)  
[1735.Count-Ways-to-Make-Array-With-Product](https://github.com/wisdompeak/LeetCode/tree/master/Math/1735.Count-Ways-to-Make-Array-With-Product) \(H\)  
[1830.Minimum-Number-of-Operations-to-Make-String-Sorted](https://github.com/wisdompeak/LeetCode/tree/master/Math/1830.Minimum-Number-of-Operations-to-Make-String-Sorted) \(H\)  
[1866.Number-of-Ways-to-Rearrange-Sticks-With-K-Sticks-Visible](https://github.com/wisdompeak/LeetCode/tree/master/Math/1866.Number-of-Ways-to-Rearrange-Sticks-With-K-Sticks-Visible) \(H\)  
[1916.Count-Ways-to-Build-Rooms-in-an-Ant-Colony](https://github.com/wisdompeak/LeetCode/tree/master/Math/1916.Count-Ways-to-Build-Rooms-in-an-Ant-Colony) \(H\)

**Generate all unique permutations**

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

**Generate all subsets**

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

**Generate all combinations summing to a target**

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

**Numerical Theory**

[343.Integer-Break](https://github.com/wisdompeak/LeetCode/tree/master/Math/343.Integer-Break) \(H-\)  
[365.Water-and-Jug-Problem](https://github.com/wisdompeak/LeetCode/tree/master/Math/365.Water-and-Jug-Problem) \(H\)  
[1808.Maximize-Number-of-Nice-Divisors](https://github.com/wisdompeak/LeetCode/tree/master/Math/1808.Maximize-Number-of-Nice-Divisors) \(H-\)

#### [Greedy](https://github.com/wisdompeak/LeetCode/tree/master/Greedy)

[055.Jump-Game](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/055.Jump-Game) \(E+\)  
[134.Gas-Station](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/134.Gas-Station) \(H\)  
[221.Maximal-Square](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/221.Maximal-Square) \(H\)  
[229.Majority-Element-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/229.Majority-Element-II) \(H\)  
[659.Split-Array-into-Consecutive-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/659.Split-Array-into-Consecutive-Subsequences) \(H\)  
[484.Find-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/484.Find-Permutation) \(H\)  
[386.Lexicographical-Numbers](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/386.Lexicographical-Numbers) \(H\)  
624.Maximum-Distance-in-Arrays \(M\)  
[665.Non-decreasing-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/665.Non-decreasing-Array) \(H\)  
670.Maximum-Swap \(M+\)  
[321.Create-Maximum-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/321.Create-Maximum-Number) \(H\)  
649.Dota2-Senate \(H\)  
[330.Patching-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/330.Patching-Array) \(H\)  
[683.K-Empty-Slots](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/683.K-Empty-Slots) \(H\)  
[517.Super-Washing-Machines](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/517.Super-Washing-Machines) \(H\)  
870.Advantage-Shuffle \(M\)  
[781.Rabbits-in-Forest](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/781.Rabbits-in-Forest) \(M+\)  
[881.Boats-to-Save-People](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/881.Boats-to-Save-People) \(H-\)  
[910.Smallest-Range-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/910.Smallest-Range-II) \(M+\)  
916.Word-Subsets \(M+\)  
[936.Stamping-The-Sequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/936.Stamping-The-Sequence) \(H\)  
[948.Bag-of-Tokens](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/948.Bag-of-Tokens) \(M+\)  
[968.Binary-Tree-Cameras](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/968.Binary-Tree-Cameras) \(H\)  
[955.Delete-Columns-to-Make-Sorted-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/955.Delete-Columns-to-Make-Sorted-II) \(M+\)  
[1040.Moving-Stones-Until-Consecutive-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1040.Moving-Stones-Until-Consecutive-II) \(H\)  
1121.Divide Array Into Increasing Sequences \(TBD\)  
[1191.K-Concatenation-Maximum-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1191.K-Concatenation-Maximum-Sum) \(M+\)  
[1253.Reconstruct-a-2-Row-Binary-Matrix](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1253.Reconstruct-a-2-Row-Binary-Matrix) \(M\)  
[1354.Construct-Target-Array-With-Multiple-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1354.Construct-Target-Array-With-Multiple-Sums) \(H-\)  
[1414.Find-the-Minimum-Number-of-Fibonacci-Numbers-Whose-Sum-Is-K](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1414.Find-the-Minimum-Number-of-Fibonacci-Numbers-Whose-Sum-Is-K) \(M+\)  
[1488.Avoid-Flood-in-The-City](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1488.Avoid-Flood-in-The-City) \(H-\)  
[1505.Minimum-Possible-Integer-After-at-Most-K-Adjacent-Swaps-On-Digits](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1505.Minimum-Possible-Integer-After-at-Most-K-Adjacent-Swaps-On-Digits) \(H\)  
[1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array) \(H-\)  
[1535.Find-the-Winner-of-an-Array-Game](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1535.Find-the-Winner-of-an-Array-Game) \(M+\)  
[1536.Minimum-Swaps-to-Arrange-a-Binary-Grid](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1536.Minimum-Swaps-to-Arrange-a-Binary-Grid) \(H-\)  
[1540.Can-Convert-String-in-K-Moves](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1540.Can-Convert-String-in-K-Moves) \(M+\)  
[1567.Maximum-Length-of-Subarray-With-Positive-Product](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1567.Maximum-Length-of-Subarray-With-Positive-Product) \(M+\)  
[1578.Minimum-Deletion-Cost-to-Avoid-Repeating-Letters](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1578.Minimum-Deletion-Cost-to-Avoid-Repeating-Letters) \(M\)  
[1585.Check-If-String-Is-Transformable-With-Substring-Sort-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1585.Check-If-String-Is-Transformable-With-Substring-Sort-Operations) \(H\)  
[1657.Determine-if-Two-Strings-Are-Close](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1657.Determine-if-Two-Strings-Are-Close) \(M\)  
[1702.Maximum-Binary-String-After-Change](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1702.Maximum-Binary-String-After-Change) \(H-\)  
[1717.Maximum-Score-From-Removing-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1717.Maximum-Score-From-Removing-Substrings) \(M+\)  
[1727.Largest-Submatrix-With-Rearrangements](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1727.Largest-Submatrix-With-Rearrangements) \(M\)  
[1744.Can-You-Eat-Your-Favorite-Candy-on-Your-Favorite-Day](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1744.Can-You-Eat-Your-Favorite-Candy-on-Your-Favorite-Day) \(M\)  
[1788.Maximize-the-Beauty-of-the-Garden](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1788.Maximize-the-Beauty-of-the-Garden) \(M+\)  
[1818.Minimum-Absolute-Sum-Difference](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1818.Minimum-Absolute-Sum-Difference) \(M+\)  
[1850.Minimum-Adjacent-Swaps-to-Reach-the-Kth-Smallest-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1850.Minimum-Adjacent-Swaps-to-Reach-the-Kth-Smallest-Number) \(M+\)  
[1911.Maximum-Alternating-Subsequence-Sum](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1911.Maximum-Alternating-Subsequence-Sum) \(M+\)  
[1982.Find-Array-Given-Subset-Sums](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1982.Find-Array-Given-Subset-Sums) \(H\)

**LIS**

[300.Longest-Increasing-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/300.Longest-Increasing-Subsequence) \(M+\)  
[354.Russian-Doll-Envelopes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/354.Russian-Doll-Envelopes) \(H-\)  
[1713.Minimum-Operations-to-Make-a-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1713.Minimum-Operations-to-Make-a-Subsequence) \(H-\)  
[1964.Find-the-Longest-Valid-Obstacle-Course-at-Each-Position](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1964.Find-the-Longest-Valid-Obstacle-Course-at-Each-Position) \(M+\)

**Two-pass distribution**

[135.Candy](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/135.Candy) \(M+\)  
[1840.Maximum-Building-Height](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1840.Maximum-Building-Height) \(H\)  
[1846.Maximum-Element-After-Decreasing-and-Rearranging](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1846.Maximum-Element-After-Decreasing-and-Rearranging) \(M+\)

**Three-pass**

[042.Trapping-Rain-Water](https://github.com/wisdompeak/LeetCode/tree/master/Others/042.Trapping-Rain-Water) \(H-\)  
[334.Increasing-Triplet-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/334.Increasing-Triplet-Subsequence) \(H-\)  
[907.Sum-of-Subarray-Minimums](https://github.com/wisdompeak/LeetCode/tree/master/Stack/907.Sum-of-Subarray-Minimums) \(H\)  
[1525.Number-of-Good-Ways-to-Split-a-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1525.Number-of-Good-Ways-to-Split-a-String) \(M\)  
[1638.Count-Substrings-That-Differ-by-One-Character](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/1638.Count-Substrings-That-Differ-by-One-Character) \(M+\)  
[1653.Minimum-Deletions-to-Make-String-Balanced](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1653.Minimum-Deletions-to-Make-String-Balanced) \(M\)  
[1664.Ways-to-Make-a-Fair-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1664.Ways-to-Make-a-Fair-Array) \(M\)  
[1671.Minimum-Number-of-Removals-to-Make-Mountain-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1671.Minimum-Number-of-Removals-to-Make-Mountain-Array) \(M+\)  
[1769.Minimum-Number-of-Operations-to-Move-All-Balls-to-Each-Box](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1769.Minimum-Number-of-Operations-to-Move-All-Balls-to-Each-Box) \(M+\)  
[1888.Minimum-Number-of-Flips-to-Make-the-Binary-String-Alternating](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1888.Minimum-Number-of-Flips-to-Make-the-Binary-String-Alternating) \(M+\)

**State Machine**

[524.Longest-Word-in-Dictionary-through-Deleting](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/524.Longest-Word-in-Dictionary-through-Deleting) \(M+\)  
[727.Minimum-Window-Subsequence](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/727.Minimum-Window-Subsequence) \(H-\)  
[792.Number-of-Matching-Subsequences](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/792.Number-of-Matching-Subsequences) \(H-\)  
[1055.Shortest-Way-to-Form-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1055.Shortest-Way-to-Form-String) \(M+\)

**Sort**

164.Maximum-Gap \(H\)  
[179.Largest-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/179.Largest-Number) \(H-\)  
[581.shortest-unsorted-continuous-subarray](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/581.shortest-unsorted-continuous-subarray) \(M+\)  
[275.H-Index-II](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/275.H-Index-II) \(M+\)  
[406.Queue-Reconstruction-by-Height](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/406.Queue-Reconstruction-by-Height) \(M+\)  
[731.My-Calendar-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/731.My-Calendar-II) \(M+\)  
826.Most-Profit-Assigning-Work \(M\)  
[1268.Search-Suggestions-System](https://github.com/wisdompeak/LeetCode/tree/master/Trie/1268.Search-Suggestions-System) \(H-\)  
[1402.Reducing-Dishes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1402.Reducing-Dishes) \(M\)  
[1520.Maximum-Number-of-Non-Overlapping-Substrings](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1520.Maximum-Number-of-Non-Overlapping-Substrings) \(H-\)  
[1564.Put-Boxes-Into-the-Warehouse-I](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1564.Put-Boxes-Into-the-Warehouse-I) \(M+\)  
[1665.Minimum-Initial-Energy-to-Finish-Tasks](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1665.Minimum-Initial-Energy-to-Finish-Tasks) \(H-\)  
[1686.Stone-Game-VI](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1686.Stone-Game-VI) \(H-\)  
[1996.The-Number-of-Weak-Characters-in-the-Game](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1996.The-Number-of-Weak-Characters-in-the-Game) \(M+\)

**Indexing Sort**

[041.First-Missing-Positive](https://github.com/wisdompeak/LeetCode/blob/master/Greedy/041.First-Missing-Positive/Readme.md) \(H\)  
[268.Missing-Number](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/268.Missing-Number) \(H-\)  
[287.Find-the-Duplicate-Number](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/287.Find-the-Duplicate-Number) \(H\)  
[442.Find-All-Duplicates-in-an-Array](https://github.com/wisdompeak/LeetCode/blob/master/Greedy/442.Find-All-Duplicates-in-an-Array) \(M\)  
[448.Find-All-Numbers-Disappeared-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/448.Find-All-Numbers-Disappeared-in-an-Array) \(M\)  
[645.Set-Mismatch](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/645.Set-Mismatch) \(M\)

**Parenthesis**

[921.Minimum-Add-to-Make-Parentheses-Valid](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/921.Minimum-Add-to-Make-Parentheses-Valid) \(M+\)  
[1249.Minimum-Remove-to-Make-Valid-Parentheses](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1249.Minimum-Remove-to-Make-Valid-Parentheses) \(M+\)  
[1541.Minimum-Insertions-to-Balance-a-Parentheses-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1541.Minimum-Insertions-to-Balance-a-Parentheses-String) \(M+\)  
[678.Valid-Parenthesis-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/678.Valid-Parenthesis-String) \(H-\)  
[1963.minimum-number-of-swaps-to-make-the-string-balanced](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1963.minimum-number-of-swaps-to-make-the-string-balanced) \(M+\)

**Intervals**

[1272.Remove-Interval](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1272.Remove-Interval) \(M+\)

**Maximum number of non-overlapping intervals - sort by ending points**

[452.Minimum-Number-of-Arrows-to-Burst-Balloons](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/452.Minimum-Number-of-Arrows-to-Burst-Balloons) \(H-\)

[435.Non-overlapping-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/435.Non-overlapping-Intervals) \(M+\) \(aka. [646.Maximum-Length-of-Pair-Chain](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/646.Maximum-Length-of-Pair-Chain)\)

[757.Set-Intersection-Size-At-Least-Two](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/757.Set-Intersection-Size-At-Least-Two) \(H\)

**Interval + DP + Binary search**

* TODO
  * Use named tuples
  * Limitations of lru\_cache
  * Sorted\(\) key word

[1235.Maximum-Profit-in-Job-Scheduling](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1235.Maximum-Profit-in-Job-Scheduling) \(H-\)

[1751.Maximum-Number-of-Events-That-Can-Be-Attended-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1751.Maximum-Number-of-Events-That-Can-Be-Attended-II) \(H\)

**Minimum number of intervals to cover the whole range - sort by starting points**

[045.Jump-Game-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/045.Jump-Game-II) \(M\)

[1024.Video-Stitching](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1024.Video-Stitching) \(M+\)

[1288.Remove-Covered-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1288.Remove-Covered-Intervals) \(M+\)

[1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1326.Minimum-Number-of-Taps-to-Open-to-Water-a-Garden) \(M+\)

**Constructive Problems**

[324.Wiggle-Sort-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/324.Wiggle-Sort-II) \(H\)  
[667.Beautiful-Arrangement-II](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/667.Beautiful-Arrangement-II) \(M\)  
[932.Beautiful-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/932.Beautiful-Array) \(H\)

#### [Others](https://github.com/wisdompeak/LeetCode/tree/master/Others)

[007.Reverse-Integer](https://github.com/wisdompeak/LeetCode/tree/master/Others/007.Reverse-Integer) \(M\)  
[048.Rotate-Image](https://github.com/wisdompeak/LeetCode/tree/master/Others/048.Rotate-Image) \(M+\)  
[065.Valid-Number](https://github.com/wisdompeak/LeetCode/tree/master/Others/065.Valid-Number) \(H-\)  
[158.Read-N-Characters-Given-Read4-II-Call-multiple-times](https://github.com/wisdompeak/LeetCode/tree/master/Others/158.Read-N-Characters-Given-Read4-II-Call-multiple-times) \(H-\)  
[240.Search-a-2D-Matrix-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/240.Search-a-2D-Matrix-II) \(M+\)  
[277.Find-the-Celebrity](https://github.com/wisdompeak/LeetCode/tree/master/Others/277.Find-the-Celebrity) \(H-\)  
[311.Sparse-Matrix-Multiplication](https://github.com/wisdompeak/LeetCode/tree/master/Others/311.Sparse-Matrix-Multiplication) \(M\)  
168.Excel-Sheet-Column-Title \(H\)  
453.Minimum-Moves-to-Equal-Array-Elements \(M\)  
689.Maximum-Sum-of-3-Non-Overlapping-Subarrays \(M+\)  
[782.Transform-to-Chessboard](https://github.com/wisdompeak/LeetCode/tree/master/Others/782.Transform-to-Chessboard) \(H+\)  
[466.Count-The-Repetitions](https://github.com/wisdompeak/LeetCode/tree/master/Others/466.Count-The-Repetitions) \(H\)  
[810.Chalkboard-XOR-Game](https://github.com/wisdompeak/LeetCode/tree/master/Others/810.Chalkboard-XOR-Game) \(H\)  
420.Strong-Password-Checker \(H\)  
[775.Global-and-Local-Inversions](https://github.com/wisdompeak/LeetCode/tree/master/Others/775.Global-and-Local-Inversions) \(M\)  
[348.Design-Tic-Tac-Toe](https://github.com/wisdompeak/LeetCode/tree/master/Others/348.Design-Tic-Tac-Toe) \(M\)  
[794.Valid-Tic-Tac-Toe-State](https://github.com/wisdompeak/LeetCode/tree/master/Others/794.Valid-Tic-Tac-Toe-State) \(M+\)  
825.Friends-Of-Appropriate-Ages \(M+\)  
[835.Image-Overlap](https://github.com/wisdompeak/LeetCode/tree/master/Others/835.Image-Overlap) \(H\)  
[843.Guess-the-Word](https://github.com/wisdompeak/LeetCode/tree/master/Others/843.Guess-the-Word) \(M\)  
855.Exam-Room \(M+\)  
918.Maximum-Sum-Circular-Subarray \(H-\)  
[927.Three-Equal-Parts](https://github.com/wisdompeak/LeetCode/tree/master/Others/927.Three-Equal-Parts) \(M\)  
[978.Longest-Turbulent-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Others/978.Longest-Turbulent-Subarray) \(H-\)  
1067.Digit-Count-in-Range \(H\)  
1183.Maximum-Number-of-Ones \(H\)  
[1267.Count-Servers-that-Communicate](https://github.com/wisdompeak/LeetCode/tree/master/Others/1267.Count-Servers-that-Communicate) \(M+\)  
[1538.Guess-the-Majority-in-a-Hidden-Array](https://github.com/wisdompeak/LeetCode/tree/master/Others/1538.Guess-the-Majority-in-a-Hidden-Array) \(M+\)  
[1706.Where-Will-the-Ball-Fall](https://github.com/wisdompeak/LeetCode/tree/master/Others/1706.Where-Will-the-Ball-Fall) \(M+\)  
[1749.Maximum-Absolute-Sum-of-Any-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Others/1749.Maximum-Absolute-Sum-of-Any-Subarray) \(M+\)  
[1752.Check-if-Array-Is-Sorted-and-Rotated](https://github.com/wisdompeak/LeetCode/tree/master/Others/1752.Check-if-Array-Is-Sorted-and-Rotated) \(M\)  
[1826.Faulty-Sensor](https://github.com/wisdompeak/LeetCode/tree/master/Others/1826.Faulty-Sensor) \(M+\)  
[1861.Rotating-the-Box](https://github.com/wisdompeak/LeetCode/tree/master/Others/1861.Rotating-the-Box) \(M\)  
[1862.Sum-of-Floored-Pairs](https://github.com/wisdompeak/LeetCode/tree/master/Others/1862.Sum-of-Floored-Pairs) \(M+\)  
[1904.The-Number-of-Full-Rounds-You-Have-Played](https://github.com/wisdompeak/LeetCode/tree/master/Others/1904.The-Number-of-Full-Rounds-You-Have-Played) \(M\)  
[1997.First-Day-Where-You-Have-Been-in-All-the-Rooms](https://github.com/wisdompeak/LeetCode/tree/master/Others/1997.First-Day-Where-You-Have-Been-in-All-the-Rooms) \(H\)

**扫描线 / 差分数组**

[252.Meeting-Rooms](https://github.com/wisdompeak/LeetCode/tree/master/Others/252.Meeting-Rooms) \(M\)  
[253.Meeting-Rooms-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/253.Meeting-Rooms-II) \(M+\)  
[056.Merge-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Others/056.Merge-Intervals) \(M\)  
[057.Insert-Intervals](https://github.com/wisdompeak/LeetCode/tree/master/Others/057.Insert-Interval) \(M\)  
[732.My-Calendar-III](https://github.com/wisdompeak/LeetCode/tree/master/Others/732.My-Calendar-III) \(M\)  
[759.Employee-Free-Time](https://github.com/wisdompeak/LeetCode/tree/master/Others/759.Employee-Free-Time) \(M+\)  
[798.Smallest-Rotation-with-Highest-Score](https://github.com/wisdompeak/LeetCode/tree/master/Others/798.Smallest-Rotation-with-Highest-Score) \(H\)  
[995.Minimum-Number-of-K-Consecutive-Bit-Flips](https://github.com/wisdompeak/LeetCode/tree/master/Others/995.Minimum-Number-of-K-Consecutive-Bit-Flips) \(H-\)  
[1094.Car-Pooling](https://github.com/wisdompeak/LeetCode/tree/master/Others/1094.Car-Pooling) \(E\)  
[1109.Corporate-Flight-Bookings](https://github.com/wisdompeak/LeetCode/tree/master/Others/1109.Corporate-Flight-Bookings) \(M\)  
[1589.Maximum-Sum-Obtained-of-Any-Permutation](https://github.com/wisdompeak/LeetCode/tree/master/Others/1589.Maximum-Sum-Obtained-of-Any-Permutation) \(M\)  
[1674.Minimum-Moves-to-Make-Array-Complementary](https://github.com/wisdompeak/LeetCode/tree/master/Others/1674.Minimum-Moves-to-Make-Array-Complementary) \(H\)  
[1871.Jump-Game-VII](https://github.com/wisdompeak/LeetCode/tree/master/Others/1871.Jump-Game-VII) \(M+\)  
1893.Check if All the Integers in a Range Are Covered \(E\)  
[850.Rectangle-Area-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/850.Rectangle-Area-II) \(H\)  
[1943.Describe-the-Painting](https://github.com/wisdompeak/LeetCode/tree/master/Others/1943.Describe-the-Painting) \(H-\)

**Interval**

* Interval-related
  * Judge whether intervals overlap

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

* Sort intervals

  ```java
  List<Interval> list = //...
  // sort according to starting point
  list.sort( (o1,o2) -> o1.start - o2.start );
  // or sort according to ending point
  list.sort( (o1,o2) -> o1.end - o2.end );
  // sort according to both starting and ending point
  list.sort( (o1,o2) -> o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end );
  ```

* Split intervals into Pair\(int start, boolean isStart\), Pair\(int end, boolean isEnd\)

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

**Enumeration**

[479.Largest-Palindrome-Product](https://github.com/wisdompeak/LeetCode/tree/master/Others/479.Largest-Palindrome-Product) \(M+\)  
[866.Prime-Palindrome](https://github.com/wisdompeak/LeetCode/tree/master/Others/866.Prime-Palindrome) \(H-\)  
[906.Super-Palindromes](https://github.com/wisdompeak/LeetCode/tree/master/Others/906.Super-Palindromes) \(H-\)  
[795.Number-of-Subarrays-with-Bounded-Maximum](https://github.com/wisdompeak/LeetCode/tree/master/Others/795.Number-of-Subarrays-with-Bounded-Maximum) \(M+\)  
[1625.Lexicographically-Smallest-String-After-Applying-Operations](https://github.com/wisdompeak/LeetCode/tree/master/Others/1625.Lexicographically-Smallest-String-After-Applying-Operations) \(H-\)  
[1714.Sum-Of-Special-Evenly-Spaced-Elements-In-Array](https://github.com/wisdompeak/LeetCode/tree/master/Others/1714.Sum-Of-Special-Evenly-Spaced-Elements-In-Array) \(H\)  
[1737.Change-Minimum-Characters-to-Satisfy-One-of-Three-Conditions](https://github.com/wisdompeak/LeetCode/tree/master/Others/1737.Change-Minimum-Characters-to-Satisfy-One-of-Three-Conditions) \(M+\)

**Presum**

[1878.Get-Biggest-Three-Rhombus-Sums-in-a-Grid](https://github.com/wisdompeak/LeetCode/tree/master/Others/1878.Get-Biggest-Three-Rhombus-Sums-in-a-Grid) \(M+\)  
[1906.Minimum-Absolute-Difference-Queries](https://github.com/wisdompeak/LeetCode/tree/master/Others/1906.Minimum-Absolute-Difference-Queries) \(M+\)

**Quick Select**

[215.Kth-Largest-Element-in-an-Array](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/215.Kth-Largest-Element-in-an-Array) \(M\)  
[347.Top-K-Frequent-Elements](https://github.com/wisdompeak/LeetCode/tree/master/Others/347.Top-K-Frequent-Elements) \(M+\)  
[973.K-Closest-Points-to-Origin](https://github.com/wisdompeak/LeetCode/tree/master/Others/973.K-Closest-Points-to-Origin) \(M\)  
[324.Wiggle-Sort-II](https://github.com/wisdompeak/LeetCode/tree/master/Others/324.Wiggle-Sort-II) \(H\)

#### [LeetCode Cup](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP)

[LCP23.魔术排列](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2020Fall/LCP23.%E9%AD%94%E6%9C%AF%E6%8E%92%E5%88%97)  
[LCP24.数字游戏](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2020Fall/LCP24.%E6%95%B0%E5%AD%97%E6%B8%B8%E6%88%8F)  
[LCP25.古董键盘](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2020Fall/LCP25.%E5%8F%A4%E8%91%A3%E9%94%AE%E7%9B%98)  
[LCP32.批量处理任务](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Spring/LCP32.%E6%89%B9%E9%87%8F%E5%A4%84%E7%90%86%E4%BB%BB%E5%8A%A1)  
[LCP35.电动车游城市](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Spring/LCP35.%E7%94%B5%E5%8A%A8%E8%BD%A6%E6%B8%B8%E5%9F%8E%E5%B8%82)  
[LCP36.最多牌组数](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Spring/LCP36.%E6%9C%80%E5%A4%9A%E7%89%8C%E7%BB%84%E6%95%B0)  
[LCP43.十字路口的交通](https://github.com/wisdompeak/LeetCode/tree/master/LCCUP/2021Fall/LCP43.%E5%8D%81%E5%AD%97%E8%B7%AF%E5%8F%A3%E7%9A%84%E4%BA%A4%E9%80%9A)

#### [Templates](https://github.com/wisdompeak/LeetCode/tree/master/Template)

[Math](https://github.com/wisdompeak/LeetCode/tree/master/Template/Math)  
[Binary\_Index\_Tree](https://github.com/wisdompeak/LeetCode/tree/master/Template/Binary_Index_Tree)  
[Segment Tree](https://github.com/wisdompeak/LeetCode/tree/master/Template/SegmentTree)  
[Inverse\_Element](https://github.com/wisdompeak/LeetCode/tree/master/Template/Inverse_Element)  
[Graph](https://github.com/wisdompeak/LeetCode/tree/master/Template/Graph)  
[Bit\_Manipulation](https://github.com/wisdompeak/LeetCode/tree/master/Template/Bit_manipulation)  
[Combination-Number](https://github.com/wisdompeak/LeetCode/tree/master/Template/Combination-Number)  
[RB\_Tree](https://github.com/wisdompeak/LeetCode/tree/master/Template/RB_Tree)  
[IO](https://github.com/wisdompeak/LeetCode/tree/master/Template/IO)

### Online IDE templates

#### Coderpad

```java
import org.junit.*;
import org.junit.runner.*;
import java.io.*;
import java.util.*;

public class Solution 
{

    @Test
    public void test1()
    {
      /* 

      */
    }    

    @Ignore
    @Test
    public void test3()
    {
        /* 

        */
    }

    public static void main(String[] args) 
    {
        JUnitCore.main("Solution");
    }    

}
```

