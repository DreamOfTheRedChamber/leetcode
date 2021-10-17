- [Amortized analysis](#amortized-analysis)
- [Operation complexity for python collections](#operation-complexity-for-python-collections)
  - [List](#list)
    - [Inter working](#inter-working)
  - [Dictionary](#dictionary)
  - [Set](#set)

# Amortized analysis
* Amortized Analysis is used for algorithms where an occasional operation is very slow, but most of the other operations are faster. 
* The example data structures whose operations are analyzed using Amortized Analysis are Hash Tables, Disjoint Sets and Splay Trees. 
* The complexity analysis using worst case gives a loose upper bound. Amortized analysis gives a tighter upper bound. In Amortized Analysis, we analyze a sequence of operations and guarantee a worst case average time which is lower than the worst case time of a particular expensive operation. 

![](../gitbook/../.gitbook/assets/timecomplexity.png)

# Operation complexity for python collections
## List

| `Operation`| `Examples`| `Amortized complexity` | 
|---|---|---|
| `Append`| l.append(item) | O(1) |
| `Clear` | l.clear() |O(1) |
| `Contain item` |  in/not in l |O(N) |
|`Copy`|l.copy()|O(N)|
|`Delete`|del l[i]|O(N)|
|`Extend`|l.extend(…)|O(N)|
|`Equality`|l1==l2, l1!=l2|O(N)|
|`Index`|l[i]|O(1)|
|`Iteration`|for item in l:|O(N)|
|`Length`|len(l)|O(1)|
|`Multiply`|k*l|O(k*N)|
|`Min, Max`|min(l), max(l)|O(N)|
|`Pop from end`|l.pop(-1)|O(1)|
|`Pop intermediate`|l.pop(item)|O(N)|O(N)|Remove|l.remove(…)|O(N)|
|`Reverse`|l.reverse()|O(N)|
|`Slice`|l[x:y]|O(y-x)|
|`Sort`|l.sort()|O(N*log(N))|
|`Store`|l[i]=item|O(1)|

### Inter working

## Dictionary

| `Operation`| `Examples`| `Amortized complexity` | 
|---|---|---|
|`Clear`|d.clear()|O(1)|O(1)
|`Construction`|dict(…)|O(len(d))|O(len(d))
|`Delete`|del d[k]|O(1)|O(N)
|`Get`|d.get()|O(1)|O(N)
|`Iteration(key, value, item)`|for item in d:|O(N)|O(N)
|`Length`|len(d)|O(1)|O(1)
|`Pop`|d.pop(item)|O(1)|O(N)
|`Pop Item`|d.popitem()|O(1)|O(1)
|`Returning Views`|d.keys()|O(1)|O(1)
|`Fromkeys`|d.fromkeys(seq)|O(len(seq))|O(len(seq))

## Set

| `Operation`| `Examples`| `Amortized complexity` | 
|---|---|---|
|`Add`|s.add(item)|O(1)|
|`Clear`|s.clear()|O(1)|
|`Copy`|s.copy()|O(N)|
|`Containment`|item in/not in s|O(1)|
|`Creation`|set(…)|O(len(s))|
|`Discard`|s.discard(item)|O(1)|
|`Difference`|s1-s2|O(len(s1))|
|`Difference Update`|s1.difference_update(s2)|O(len(s2))|
|`Equality`|s1==s2, s1!=s2|O(min(len(s1), len(s2)))|
|`Intersection`|s1 & s2|O(min(len(s1), len(s2)))|
|`Iteration`|for item in s:|O(N)|
|`Is Subset`|s1<=s2|O(len(s1))|
|`Is Superset`|s1>=s2|O(len(s2))|
|`Pop`|s.pop()|O(1)|
|`Union`|s1|s2|O(len(s1)+len(s2))|
|`Symmetric Difference`|s1^s2|len(s1)|