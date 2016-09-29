package dfs;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Show Hint 
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
 */

// TODO: improve complexity

public class LargestBSTSubtree
{
	private class ResultWrapper
	{
		public final boolean isBST;
		public final int largestBSTSize;
		public ResultWrapper( boolean isBST, int largestBSTSize )
		{
			this.isBST = isBST;
			this.largestBSTSize = largestBSTSize;
		}
	}
	
	public int largestBSTSubtree( TreeNode root )
	{
		ResultWrapper result = largestBSTSubtreeRecurse( root );
		return result.largestBSTSize;
	}
		
    private ResultWrapper largestBSTSubtreeRecurse( TreeNode root )
    {
    	if ( root == null )
    	{
    		return new ResultWrapper( true, 0 );
    	}
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		return new ResultWrapper( true, 1 );
    	}
    	
    	ResultWrapper leftResult = largestBSTSubtreeRecurse( root.left );
    	ResultWrapper rightResult = largestBSTSubtreeRecurse( root.right );
    	
    	if ( leftResult.isBST 
    			&& rightResult.isBST )
    	{
    		int largestLeftChild = root.val;
    		TreeNode currNode = root.left;
    		while( currNode != null )
    		{
    			largestLeftChild = currNode.val;
    			currNode = currNode.right;
    		}
    		
    		int smallestRightChild = root.val;
    		currNode = root.right;
    		while ( currNode != null )
    		{
    			smallestRightChild = currNode.val;
    			currNode = currNode.left;
    		}
    		
    		if ( smallestRightChild >= root.val
    				&& largestLeftChild <= root.val )
    		{
    			return new ResultWrapper( true, 
    					leftResult.largestBSTSize + rightResult.largestBSTSize + 1 );
    		}
    	}

    	return new ResultWrapper( false, 
    			Math.max( leftResult.largestBSTSize, rightResult.largestBSTSize ) );
    }
    
    @Ignore
    @Test
    public void test1()
    {
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 3 );
    	node2.right = node3;
    	node2.left = node1;
    	assertEquals( 3, largestBSTSubtree( node2 ) );
    }
    
    @Test
    public void test2()
    {
    	TreeNode node1 = new TreeNode( 10 );
    	TreeNode node2 = new TreeNode( 5 );
    	TreeNode node3 = new TreeNode( 15 );    	
    	TreeNode node4 = new TreeNode( 1 );
    	TreeNode node5 = new TreeNode( 8 );
    	TreeNode node6 = new TreeNode( 7 );
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	node2.right = node5;
    	node3.right = node6;
    	assertEquals( 3, largestBSTSubtree( node1 ) );    	
    }
    
    @Test
    public void test3()
    {
    	TreeNode node1 = new TreeNode( -2 );
    	TreeNode node2 = new TreeNode( -1 );
    	node1.right = node2;
    	assertEquals( 2, largestBSTSubtree( node1 ) );
    }
}
