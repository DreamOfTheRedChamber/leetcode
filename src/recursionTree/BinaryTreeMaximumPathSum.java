package recursionTree;

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
		public final int maxSubtreeFromRoot;
		public final int maxSubtree;
		public ResultWrapper( int maxSubtreeFromRoot, int maxSubtree )
		{
			this.maxSubtreeFromRoot = maxSubtreeFromRoot;
			this.maxSubtree = maxSubtree;
		}
	}
	
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
    		return new ResultWrapper( 0, Integer.MIN_VALUE );
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
    	int maxSubtree = Math.max( root.val + Math.max( 0, leftChildResult.maxSubtreeFromRoot ) + Math.max( 0, rightChildResult.maxSubtreeFromRoot ), 
    										Math.max( leftChildResult.maxSubtree, rightChildResult.maxSubtree ) );

    	return new ResultWrapper( maxSubtreeFromRoot, maxSubtree );
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