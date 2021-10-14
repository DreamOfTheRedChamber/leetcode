- [Beauty of Python](#beauty-of-python)
  - [Collections \[TODO\]](#collections-todo)
    - [Compare heapq and SortedList complexity \[TODO\]](#compare-heapq-and-sortedlist-complexity-todo)
    - [Sort comparator \[TODO\]](#sort-comparator-todo)
  - [Type conversions](#type-conversions)
    - [int and char](#int-and-char)
  - [f-string](#f-string)
  - [Walrus operator :=](#walrus-operator-)
    - [used in assignment expressions](#used-in-assignment-expressions)
    - [Used in list comprehension](#used-in-list-comprehension)
  - [Decorator](#decorator)
  - [Slicing](#slicing)
    - [Stride syntax](#stride-syntax)
  - [List comprehension](#list-comprehension)
    - [Number of expressions](#number-of-expressions)
    - [Generator expressions](#generator-expressions)
      - [Yield](#yield)
      - [Yield from](#yield-from)
      - [Example](#example)
  - [Iterator](#iterator)
    - [Iterables](#iterables)
    - [Enumerate over range](#enumerate-over-range)
    - [Zip for iterators in parallel](#zip-for-iterators-in-parallel)
  - [References](#references)

# Beauty of Python

## Collections \[TODO\]

| `data type` | `Original` | `Improved` |
| :--- | :---: | ---: |
| priorityQueue | heapq.\* methods | SortedList |
| list / stack / queue | \[\] |  |
| deque | deque |  |
| dictionary | dict | defaultdict |

### Compare heapq and SortedList complexity \[TODO\]

### Sort comparator \[TODO\]

* Pass comparator to Sorted\(\) and sort\(\)
* Pass comparator to SortedContainers 

## Type conversions

### int and char

* ord: int to char
* char: char to int

## f-string

## Walrus operator :=
### used in assignment expressions

```py
n = len(a)
if n > 10:
    print(f"List is too long ({n} elements, expected <= 10)")

# need parenthese because its priority order is low
if (x := len(a)) > 10:     
    print(f"List is too long ({x} elements, expected <= 10)")
```

### Used in list comprehension

```py
prog_langs = {'c++', 'python', 'java'}
langs = {'C++', 'Java', 'PYthon', 'English', '中文'}

l1 = [lang.lower() for lang in langs if lang.lower() in prog_langs]
print(l1)

l2 = [l for lang in langs if (l := lang.lower()) in prog_langs]
print(l2)
```

## Decorator
* the mechanism behind @lru_cache

## Slicing
* The result of slicing a list is a whole new list. References to the ojbects from the original list are maintained. 
* Assigning to a list slice will replace that range in the original sequence with what's referenced even if their lengths are different. 
* Slicing is forgiving of start or end indexes that are out of bounds, making it easy to express slices on the front or back boundaries of a sequence (like a[:20] or a[-20:]).

### Stride syntax
* somelist[start:end:stride]
* Prefer to use positive stride values in slices without start or end indexes. Avoid negative stride values if possible. 

## List comprehension
* List comprehensions allow you to create a new list from an existing one. 
* List comprehensions are clearer than the map and filter because they don't require lambda expressions. 
* List comprehensions allow you to easily skip items from the input list, a behavior map doesn't support without help from filter. 
* Dictionaries and sets also support comprehension expressions. 

```py
a = [1, 2, 5]
squares = [x ** 2 for x in a]
even_squares = [x ** 2 for x in a if x % 2 == 0]
```

### Number of expressions
* If the expression included another loop, the list comprehension would get so long that you'd have to split it over multiple lines. 
* List comprehensions also support multiple if conditions. 

```py
a = [1, 2, 4, 5]
b = [x for x in a if x > 4 if x % 2 == 0]

matrix = [[1, 2, 3], [4, 5, 6]]
filtered = [[x for x in row if x % 3 == 0] for row in matrix if sum(row) >= 10]
```

### Generator expressions
* The problem with list comprehension is that they may create a whole new list containing one item for each value in the input sequence. This is fine for small inputs, but for large inputs this could consume significant amounts of memory. 

#### Yield
* yield keyword returns a generator that could be iterated upon. 
  * What the yield keyword does is as follows: Each time you iterate, Python runs the code until it encounters a yield statement inside the function. Then, it sends the yielded value and pauses the function in that state without exiting. When the function is invoked the next time, the state at which it was last paused is remembered and execution is continued from that point onwards. This continues until the generator is exhausted.
  * How is it different from return keyword: Had you used return in place of yield, the function would have returned the respective value, all the local variable values that the function had earlier computed would be cleared off and the next time the function is called, the function execution will start fresh.

#### Yield from


#### Example

```py
def pre_order_traverse(root: TreeNode):
    if root is None: return
    yield root.val
    yield from root.left
    yield from root.right

# Materialize the generator with list
list(pre_order_traverse(root))
```

## Iterator
### Iterables

### Enumerate over range
* Prefer Enumerate instead of range to index into a sequence. 
* You can supply a second parameter to enumerate to specify the number from which to begin counting. 

```py
for i, flavor in enumerate(flavor_list, 1):
    print('%d: %s' % (i, flavor))
```

### Zip for iterators in parallel
* The zip built-in function can be used to iterate over multiple iterators in parallel. 
* In Python 3, zip is a lazy generator that produces tuples. 

## References
* Effective Python: 59 Ways to write better Python code
* [Python probably the best language for interview](https://www.kunxi.org/2020/01/python-probably-best-language-for-interview/) 
* [Youtube video for Python Beginners](https://m.youtube.com/channel/UC46xhU1EH7aywEgvA9syS3w)