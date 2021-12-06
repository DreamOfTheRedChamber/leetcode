- [Stack](#stack)
  - [monotonic stack](#monotonic-stack)
  - [parse expression](#parse-expression)
  - [Calculator](#calculator)
  - [Parentheses \[TODO\]](#parentheses-todo)

# [Stack](https://github.com/wisdompeak/LeetCode/tree/master/Stack)

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

## monotonic stack

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

## parse expression

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

## Calculator

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

## Parentheses \[TODO\]

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