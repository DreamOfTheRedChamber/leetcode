

# Binary Search 

## Enhancement of LT1779
* https://www.1point3acres.com/bbs/thread-798058-1-1.html
* Clarify the method signature: 

```python
def GetClosestCity(cityNames: List[str], cityX: List[int], cityY: List[int], queriedCity: List[str]) -> str:
```

### Clarification questions:
0. How will the input and output be represented? 
1. Will queried city always be included in cityNames? 
2. Will there be multiple closest city with multiple result?
3. What's the scale of input
    * Suppose cityNames length O(N), queriedCity length O(Q) and maxNumber of nodes with same x/y is O(K)

### Solutions
1. Brute force: for each queried city, pass through the cityNames, compute the distance, compare with minimum and swap if needed
    * T.C.: O(N*Q)
    * S.C.: O(1)
2. Map x => set(pointName), Map y => set(pointName), calculate intersection first; Then calculate manhattan distance with queried node (by priorityQueue) and find the min
    * T.C.: O(N) + O(QKlogK)
    * S.C.: O(N)
3. Preprocessing: Preprocess the cityX and cityY so that given an (x,y), the closest could be found in O(logK)
    * T.C.: O(N/K*K*logK) + O(Q*logK)
    * S.C.: O(N)