- [Tree](#tree)
  - [Serialization & Hashing](#serialization--hashing)
  - [Tree & Sequence](#tree--sequence)
  - [LCA](#lca)
  - [N-ary Tree](#n-ary-tree)
  - [似树非树](#似树非树)
- [Segment Tree](#segment-tree)
  - [Basics](#basics)
  - [Lazy Tag](#lazy-tag)
  - [Others](#others)
- [\[Binary Index Tree\]](#binary-index-tree)

# [Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree)

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

## Serialization & Hashing

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

## Tree & Sequence

[105.Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/105.Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal) \(H-\)  
[106.Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/106.Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal) \(M+\)  
[331.Verify-Preorder-Serialization-of-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/331.Verify-Preorder-Serialization-of-a-Binary-Tree) \(H\)  
[449.Serialize-and-Deserialize-BST](https://github.com/wisdompeak/LeetCode/tree/master/Tree/449.Serialize-and-Deserialize-BST) \(H\)  
[971.Flip-Binary-Tree-To-Match-Preorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/971.Flip-Binary-Tree-To-Match-Preorder-Traversal) \(M+\)  
[1028.Recover-a-Tree-From-Preorder-Traversal](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1028.Recover-a-Tree-From-Preorder-Traversal) \(H-\)  
[1569.Number-of-Ways-to-Reorder-Array-to-Get-Same-BST](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1569.Number-of-Ways-to-Reorder-Array-to-Get-Same-BST) \(H\)  
[1597.Build-Binary-Expression-Tree-From-Infix-Expression](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1597.Build-Binary-Expression-Tree-From-Infix-Expression) \(H\)  
[1902.Depth-of-BST-Given-Insertion-Order](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1902.Depth-of-BST-Given-Insertion-Order) \(H-\)

## LCA

[236.Lowest-Common-Ancestor-of-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/236.Lowest-Common-Ancestor-of-a-Binary-Tree) \(H\)  
[1676.Lowest-Common-Ancestor-of-a-Binary-Tree-IV](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1676.Lowest-Common-Ancestor-of-a-Binary-Tree-IV) \(M+\)  
[1740.Find-Distance-in-a-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1740.Find-Distance-in-a-Binary-Tree) \(H\)

## N-ary Tree

[428.Serialize-and-Deserialize-N-ary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/428.Serialize-and-Deserialize-N-ary-Tree) \(H\)  
[431.Encode-N-ary-Tree-to-Binary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/431.Encode-N-ary-Tree-to-Binary-Tree) \(H-\)  
[1516.Move-Sub-Tree-of-N-Ary-Tree](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1516.Move-Sub-Tree-of-N-Ary-Tree) \(H-\)

## 似树非树

[823](https://github.com/wisdompeak/LeetCode/tree/master/Dynamic_Programming/823.Binary-Trees-With-Factors), [1902](https://github.com/wisdompeak/LeetCode/tree/master/Tree/1902.Depth-of-BST-Given-Insertion-Order),

# [Segment Tree](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/)

## Basics

[307.Range-Sum-Query-Mutable](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/307.Range-Sum-Query-Mutable/) \(H-\)  
[1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1526.Minimum-Number-of-Increments-on-Subarrays-to-Form-a-Target-Array) \(H-\)  
[1649.Create-Sorted-Array-through-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/1649.Create-Sorted-Array-through-Instructions) \(H-\)  
[1157.Online-Majority-Element-In-Subarray](https://github.com/wisdompeak/LeetCode/tree/master/Binary_Search/1157.Online-Majority-Element-In-Subarray) \(H\)

## Lazy Tag

[370.Range-Addition](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/370.Range-Addition) \(H\)  
[218.The-Skyline-Problem](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/218.The-Skyline-Problem) \(H+\)  
[699.Falling-Squares](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/699.Falling-Squares) \(H\)

## Others

[715.Range-Module](https://github.com/wisdompeak/LeetCode/tree/master/Segment_Tree/715.Range-Module) \(H\)

# \[Binary Index Tree\]

[307.Range-Sum-Query-Mutable](https://github.com/wisdompeak/LeetCode/blob/master/Segment_Tree/307.Range-Sum-Query-Mutable/) \(M\)  
[1649.Create-Sorted-Array-through-Instructions](https://github.com/wisdompeak/LeetCode/tree/master/Divide_Conquer/1649.Create-Sorted-Array-through-Instructions) \(H\)
