

- [Tree](#tree)
  - [Tree differences](#tree-differences)
    - [Compare tree](#compare-tree)
    - [Door dash menu](#door-dash-menu)
      - [Problem itself](#problem-itself)
      - [Clarifying questions](#clarifying-questions)
    - [Possible solutions](#possible-solutions)

# Tree
## Tree differences
### Compare tree

* Problem description

树的结构如下：
class TreeNode(object):
  key = str
  value = str
  children = List[TreeNode]

def compute_diff(old_tree: TreeNode, new_tree: TreeNode) -> int:
  pass

一些判定规则如下（面试时请与面试官clarify，不要上来就说是这样，至少要会演）：
1. 如果node key一样，value一样，视为同一个节点。
2. 如果node key一样，value不同，视为不同节点，但树的结构保持不变。
3. 如果node key不同，则视为完全不同的两棵树，答案应该返回这两棵树里一共有多少节点。
4. children数组里的顺序无关。

### Door dash menu
#### Problem itself
https://leetcode.com/discuss/interview-question/1367130/doordash-phone-interview/1026887

```
At DoorDash, menus are updated daily even hourly to keep them up-to-date. Each menu can be regarded as a tree. A menu can have many categories; each category can have many menu_items; each menu_item can have many item_extras; An item_extra can have many item_extra_options…

class Node {
        String key;
        int value;
        boolean active;
        List<Node> children;
 }
We will compare the new menu sent from the merchant with our existing menu. Each item can be considered as a node in the tree. The definition of a node is defined above. Either value change or the active status change means the node has been changed. There are times when the new menu tree structure is different from existing trees, which means some nodes are set to null. In this case, we only do soft delete for any nodes in the menu. If that node or its sub-children are null, we will treat them ALL as inactive. There are no duplicate nodes with the same key.

Return the number of changed nodes in the tree.

        Existing tree                                        
         a(1, T)                                                
        /       \                                                          
     b(2, T)   c(3, T)                                               
    /     \           \                                                        
d(4, T) e(5, T)   f(6, T)                                               

        New tree 
        a(1, T)
            \
           c(3, F)
               \
               f(66, T)
```

#### Clarifying questions
* If that node or its sub-children are null, we will treat them ALL as inactive. There are no duplicate nodes with the same key.
  * Will all nodes in original tree exist in the new tree? According to the example, original nodes might be set to NULL (b case) or False (c case) 
  * Will all nodes in original tree active? No, think about a menu which gets deprecated over time and there might be entry marked as obsolete. 
* Either value change or the active status change means the node has been changed.
  * What if keys get changed? According to the description, a node is identified by the key and key change means tree structure changes

### Possible solutions
* Recursion: Possible cases
    * One node is null or inactive, look at the other node. 
    * Both node are non-null and active, 
       * Compare key, if not same count nodes
       * Plus Result of Compare children
* See [CompareTree.py](./CompareTree.py) / [DoordashMenu.py](DoordashMenu.py)
* Complexity: 
    * T.C. O(n) = O((n-1)/M) * M = O(N^2)
    * S.C. O(n) size of the tree