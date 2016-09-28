package dfs;

import utility.TreeNode;

/**
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

class ResultWrapper
{
	public final int maxSubtreeFromRoot;
	public final int maxSubtree;
	public ResultWrapper( int maxSubtreeFromRoot, int maxSubtree )
	{
		
	}
}

public class BinaryTreeMaximumPathSum
{
    public int maxPathSum( TreeNode root ) 
    {
    	if ( root == null )
    	{
    		return 0;
    	}
    	ResultWrapper result = maxPathSumRecurse( root );
    	return Math.max( result.maxSubtree, result.maxSubtreeFromRoot );
    }
    
    private ResultWrapper maxPathSumRecurse( TreeNode root )
    {
    	if ( root == null )
    	{
    		return new ResultWrapper( 0, 0 );
    	}
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		return new ResultWrapper( root.val, root.val );
    	}
    	
    	ResultWrapper leftChildResult = maxPathSumRecurse( root.left );
    	ResultWrapper rightChildResult = maxPathSumRecurse( root.right );
    	int maxSubtreeFromRoot = Math.max( root.val,
    										Math.max( leftChildResult.maxSubtreeFromRoot + root.val, rightChildResult.maxSubtreeFromRoot + root.val ) );
    	int maxSubtree = Math.max( maxSubtreeFromRoot, 
    										Math.max( leftChildResult.maxSubtree, rightChildResult.maxSubtree ) );

    	return new ResultWrapper( maxSubtreeFromRoot, maxSubtree );
    }
}