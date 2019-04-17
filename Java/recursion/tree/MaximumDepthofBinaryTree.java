package recursion.tree;

import utility.TreeNode;

/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthofBinaryTree
{
    public int maxDepth( TreeNode root )
    {
    	int[] max = new int[1];
    	maxDepthUpdateAtChild( root, 1, max );
    	return max[0];
    }
    
    private void maxDepthUpdateAtChild( TreeNode root, int depth, int[] max )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	max[0] = Math.max( max[0], depth );
    	
    	maxDepthUpdateAtChild( root.left, depth + 1, max );
    	maxDepthUpdateAtChild( root.right, depth + 1, max );
    }
    
    public int maxDepth2( TreeNode root )
    {
    	return maxDepthUpdateAtParent( root, 1 );
    }
    
    private int maxDepthUpdateAtParent( TreeNode root, int depth )
    {
    	if ( root == null )
    	{
    		return depth - 1;
    	}
    	
    	return Math.max( maxDepthUpdateAtParent( root.left, depth + 1 ),
    					 maxDepthUpdateAtParent( root.right, depth + 1 ) );
    }
}
