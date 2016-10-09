package recursionTree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting leaf node to any leaf node in the tree along the parent-child connections. 
The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */


public class BinaryTreeMaximumPathSumLeafToLeaf
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
    		throw new IllegalArgumentException();
    	}
    	ResultWrapper result = maxPathSumRecurse( root );
    	return result.globalMax;
    }
    
    private ResultWrapper maxPathSumRecurse( TreeNode root )
    {
    	if ( root.left == null
    			&& root.right == null )
    	{
    		return new ResultWrapper( root.val, Integer.MIN_VALUE );
    	}    	
    	else if ( root.left == null 
    			&& root.right != null )
    	{
    		ResultWrapper rightResult = maxPathSumRecurse( root.right );
    		return new ResultWrapper( root.val + rightResult.includeRootMax, 
    									rightResult.globalMax );
    	}    	
    	else if ( root.left != null 
    			&& root.right == null )
    	{
    		ResultWrapper leftResult = maxPathSumRecurse( root.left );
    		return new ResultWrapper( root.val + leftResult.includeRootMax,
    									leftResult.globalMax );
    	}
    	else
    	{
    		ResultWrapper leftResult = maxPathSumRecurse( root.left );
    		ResultWrapper rightResult = maxPathSumRecurse( root.right );
    		int includeRootMax = Math.max( leftResult.includeRootMax, rightResult.includeRootMax ) + root.val;
    		int globalMax = Math.max( Math.max( leftResult.globalMax, rightResult.globalMax ), root.val + leftResult.includeRootMax + rightResult.includeRootMax );
    		return new ResultWrapper( includeRootMax, globalMax );
    	}
    	
    }
    
    @Test
    public void test1()
    {
    	TreeNode node1 = new TreeNode( 3 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 1 );
    	TreeNode node4 = new TreeNode( -3 );
    	TreeNode node5 = new TreeNode( 2 );

    	node1.left = node2;
    	node2.left = node3;
    	node3.left = node4;
    	node3.right = node5;
    	assertEquals( 0, maxPathSum( node1 ) );    	    	
    }
    
    @Test
    public void test2()
    {
    	TreeNode node1 = new TreeNode( 2 );
    	TreeNode node2 = new TreeNode( 1 );
    	TreeNode node3 = new TreeNode( 10 );
    	TreeNode node4 = new TreeNode( -3 );
    	TreeNode node5 = new TreeNode( -2 );
    	TreeNode node6 = new TreeNode( 6 );
    	TreeNode node7 = new TreeNode( 7 );
    	TreeNode node8 = new TreeNode( 8 );
    	node1.left = node2;
    	node2.left = node3;
    	node2.right = node6;
    	node3.left = node4;
    	node3.right = node5;
    	node7.right = node8;
    	assertEquals( 15, maxPathSum( node1 ) );
    }
}