package recursion.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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



public class BinaryTreeMaximumPathSum
{	
	class ResultWrapper
	{
		public final int includeRootMax;
		public final int globalMax;
		public ResultWrapper( int includeRootMax, int globalMax )
		{
			this.includeRootMax = includeRootMax;
			this.globalMax = globalMax;
		}
	}
	
    public int maxPathSum( TreeNode root ) 
    {
    	if ( root == null )
    	{
    		return 0;
    	}
    	ResultWrapper result = maxPathSumRecurse( root );
    	return Math.max( result.globalMax, result.includeRootMax );
    }
    
    private ResultWrapper maxPathSumRecurse( TreeNode root )
    {
    	if ( root == null )
    	{
    		return new ResultWrapper( 0, Integer.MIN_VALUE );
    	}
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		return new ResultWrapper( root.val, root.val );
    	}
    	
    	ResultWrapper leftChildResult = maxPathSumRecurse( root.left );
    	ResultWrapper rightChildResult = maxPathSumRecurse( root.right );
    	int includeRootMax = Math.max( root.val,
    										Math.max( leftChildResult.includeRootMax + root.val, rightChildResult.includeRootMax + root.val ) );
    	int globalMax = Math.max( root.val + Math.max( 0, leftChildResult.includeRootMax ) + Math.max( 0, rightChildResult.includeRootMax ), 
    										Math.max( leftChildResult.globalMax, rightChildResult.globalMax ) );

    	return new ResultWrapper( includeRootMax, globalMax );
    }
    
    @Test
    public void test()
    {
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 3 );
    	node1.left = node2;
    	node1.right = node3;
    	assertEquals( 6, maxPathSum( node1 ) );    	    	
    }
    
    @Test
    public void edgeTest()
    {
    	TreeNode node4 = new TreeNode( -2 );
    	TreeNode node5 = new TreeNode( -1 );
    	node4.left = node5;
    	assertEquals( -1, maxPathSum( node4 ) );
    }
}