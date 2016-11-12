package recursion.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utility.TreeNode;

/**
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
 */

public class FindLeavesOfBinaryTree
{
    public List<List<Integer>> findLeaves( TreeNode root )
    {
    	Map<Integer, List<Integer>> indexToNodes = new HashMap<>();
    	helper( indexToNodes, root );
    	return indexToNodes.values().stream().collect( Collectors.toList() );
    }
    
    private int helper( Map<Integer, List<Integer>> indexToNodes, TreeNode root )
    {
    	if ( root == null )
    	{
    		return -1;
    	}
    	
    	int lIndex = helper( indexToNodes, root.left );
    	int rIndex = helper( indexToNodes, root.right );
    	int currIndex = Math.max( lIndex, rIndex ) + 1;
    	indexToNodes.putIfAbsent( currIndex, new LinkedList<>() );
    	
    	indexToNodes.get( currIndex ).add( root.val );
    	return currIndex;
    }
}
