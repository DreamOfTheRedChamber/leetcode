- [Linked List](#linked-list)
  - [Dummy node trick](#dummy-node-trick)
  - [Common tasks](#common-tasks)

# [Linked List](https://github.com/wisdompeak/LeetCode/tree/master/Linked_List)

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

## Dummy node trick

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

## Common tasks

* Find median
* Reverse list
* Merge sorted list
