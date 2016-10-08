package recursionTree;

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
    	maxDepth( root, 1, max );
    	return max[0];
    }
    
    private void maxDepth( TreeNode root, int depth, int[] max )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	max[0] = Math.max( max[0], depth );
    	
    	maxDepth( root.left, depth + 1, max );
    	maxDepth( root.right, depth + 1, max );
    }
}
