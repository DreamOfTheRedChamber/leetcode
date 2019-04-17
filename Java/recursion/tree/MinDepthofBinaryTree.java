package recursion.tree;

import utility.TreeNode;

/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

public class MinDepthofBinaryTree
{
    public int minDepth( TreeNode root )
    {
    	if ( root == null )
    	{
    		return 0;
    	}
    	int[] min = new int[1];
    	min[0] = Integer.MAX_VALUE;
    	minDepth( root, 1, min );
    	return min[0];
    }
    
    private void minDepth( TreeNode root, int depth, int[] min )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	if ( root.left == null
    			&& root.right == null )
    	{
    		min[0] = Math.min( depth, min[0] );
    		return;
    	}
    	
    	minDepth( root.left, depth + 1, min );
    	minDepth( root.right, depth + 1, min );
    }
    
    public int minDepth2( TreeNode root )
    {
    	return minDepthUpdateAtParent( root, 1 );
    }
    
    private int minDepthUpdateAtParent( TreeNode root, int depth )
    {
    	if ( root == null )
    	{
    		return depth - 1;
    	}
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		return depth;
    	}
    	
    	return Math.min( minDepthUpdateAtParent( root.left, depth + 1 ),
    					 minDepthUpdateAtParent( root.right, depth + 1 ) );
    }
}