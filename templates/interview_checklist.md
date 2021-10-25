- [Typical whiteboard coding workflow](#typical-whiteboard-coding-workflow)
  - [Clarify question](#clarify-question)
  - [Give a small but general enough example for discussing algo/DS](#give-a-small-but-general-enough-example-for-discussing-algods)
  - [Come up with a brute force algorithm](#come-up-with-a-brute-force-algorithm)
  - [Optimize the brute force solution](#optimize-the-brute-force-solution)
  - [Write test cases](#write-test-cases)
  - [Write code](#write-code)
  - [Walk through test cases](#walk-through-test-cases)
  - [Solve follow up questions](#solve-follow-up-questions)
- [Interview mindset](#interview-mindset)
  - [Understanding what interviewers really wants](#understanding-what-interviewers-really-wants)
  - [Checklist](#checklist)
    - [Things to be careful.](#things-to-be-careful)
    - [Phone interviews](#phone-interviews)
    - [Onsite interviews](#onsite-interviews)

## Typical whiteboard coding workflow

### Clarify question

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

### Give a small but general enough example for discussing algo/DS

* Usually a size of 4~5 is enough.

### Come up with a brute force algorithm

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

### Optimize the brute force solution

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

### Write test cases

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

### Write code

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

### Walk through test cases

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

### Solve follow up questions

* Typical follow-up questions
  * No duplicates -&gt; duplicates exist
  * Whether result exist -&gt; return all results
  * One dimension -&gt; two dimension
  * How to avoid global variables
  * How to improve performance

## Interview mindset

### Understanding what interviewers really wants

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
      <th style="text-align:center">Wrong response</th>
      <th style="text-align:right">What they really want</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td style="text-align:left">Tell me what you did for this project</td>
      <td style="text-align:center">
        <p>Describe the process in chronological order</p>
        <p>Recites what&apos;s on their resume</p>
      </td>
      <td style="text-align:right">
        <p>What are you able to do after completing this project4</p>
        <p>How did you overcome obstacles</p>
        <p>Details that are not on your resume</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Tell me what you did for this job</td>
      <td style="text-align:center">
        <p>Describe major projects</p>
        <p>Describe daily tasks</p>
      </td>
      <td style="text-align:right">
        <p>Were you able to learn quickly</p>
        <p>Did you add enough value at your previous job to prove that you can add
          value for me</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Compare data structure A and B</td>
      <td style="text-align:center">
        <p>Explain what A and B are respectively</p>
        <p>List 1 difference between them</p>
      </td>
      <td style="text-align:right">
        <p>Does your explanation show that you have actually used them in a real
          project</p>
        <p>Explain real situations where you would use A vs B.</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Write code to solve problem</td>
      <td style="text-align:center">
        <p>Jumps into writing code</p>
        <p>Awkward silence</p>
      </td>
      <td style="text-align:right">
        <p>Would I want to work with them everyday</p>
        <p>Have they actually written production grade code</p>
        <p>What do they do when stuck</p>
      </td>
    </tr>
    <tr>
      <td style="text-align:left">Maybe you could try this ...</td>
      <td style="text-align:center">Take advice without serious thinking</td>
      <td style="text-align:right">
        <p>Do they think independently</p>
        <p>How fast can they absord new information</p>
        <p>Do they take advice/directions well</p>
        <p>Do they learn quickly and run with it</p>
      </td>
    </tr>
  </tbody>
</table>

### Checklist

#### Things to be careful.

* Do not just give "yes" or "no" answers. Limit initial explanation to short summaries and allow the interviewer to ask follow up questions.
* Your tone of voice and word choice. Interviewers use voice to judge how believable you are. Posture really have impact on your mind.
* Eye contact and shake hands. Say thanks to interviewers at last. 

#### Phone interviews

* Test the online coding environment.
* Make sure your cellphone has enough battery.
* Have a copy of resume in front of you.
* Take notes and write a follow up thank you email with details from the discussion.

#### Onsite interviews

* Show up 15 minutes early and have the interviewer's phone number for last minute changes.
* Things to bring with you
  * Identity card.
  * Bring extra copies of your resume with you - for the interviewer and your own reference.
  * Notes on the detailed schedule. Put interviewers' names and interview topic on a sticker and bring it with me. 
  * Tea/Coffee.
  * Whiteboard pen and erasers.
  * A piece of pen and paper. Take notes when an interviewer speaks to help yourself focus and ask more specific questions. 
  * Computers for last minute warm-up. 
