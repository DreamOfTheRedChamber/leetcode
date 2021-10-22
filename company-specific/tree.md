

- [Tree](#tree)
  - [Compare tree](#compare-tree)

# Tree
## Compare tree

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

* Solution: Recursion. Please see [tree.py](./tree.py) inside github repo. 
