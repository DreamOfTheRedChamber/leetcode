package dfs;

import java.util.ArrayList;
import java.util.List;

import utility.TreeNode;

/**
 * 
 */

public class FindLeavesOfBinaryTree
{
    public List<List<Integer>> findLeaves(TreeNode root) 
    {
    	List<List<Integer>> result = new ArrayList<>();
    	    	
    	while ( root != null )
    	{
    		List<Integer> leaves = new ArrayList<>();
    		if ( root.left == null 
    				&& root.right == null )
    		{
    			leaves.add( root.val );
    		}
    		else
    		{
    			collectLeaves( root, leaves );
    		}
    		result.add( leaves );
    	}
    	
    	return result;
    }
    
    private void collectLeaves( TreeNode root, List<Integer> leaves )
    {
    	if ( root.left != null )
    	{
    		if ( root.left.left == null 
    				&& root.left.right == null )
    		{
    			leaves.add( root.left.val );
    			root.left = null;
    		}
    		else
    		{
    			collectLeaves( root.left, leaves );
    		}
    	}
    	
    	if ( root.right != null )
    	{
    		if ( root.right.left == null 
    				&& root.right.right == null )
    		{
    			leaves.add( root.right.val );
    			root.right = null;
    		}
    		else
    		{
    			collectLeaves( root.right, leaves );
    		}
    	}
    }
}
