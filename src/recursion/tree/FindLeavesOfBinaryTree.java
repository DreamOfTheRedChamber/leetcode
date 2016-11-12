package recursion.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

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
    	List<List<Integer>> result = new ArrayList<>();
    	helper( result, root );    	
    	return result;
    }
    
    private int helper( List<List<Integer>> result, TreeNode root )
    {
    	if ( root == null )
    	{
    		return -1;
    	}
    	
    	int left = helper( result, root.left );
    	int right = helper( result, root.right );
    	int curr = Math.max( left, right ) + 1;
    	if ( result.size() == curr )
    	{
    		result.add( new ArrayList<>() );
    	}
    	result.get( curr ).add( root.val );
    	return curr;
    }
}
