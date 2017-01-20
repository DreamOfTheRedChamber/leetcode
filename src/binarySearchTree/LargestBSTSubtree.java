package binarySearchTree;

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

public class LargestBSTSubtree
{
	private class ResultWrapper
	{
		public final boolean isBST;
		public final int largestBSTSize;
		public final int minValue;
		public final int maxValue;
		public ResultWrapper( boolean isBST, int largestBSTSize, int minValue, int maxValue )
		{
			this.isBST = isBST;
			this.largestBSTSize = largestBSTSize;
			this.minValue = minValue;
			this.maxValue = maxValue;
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
    		return new ResultWrapper( false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE );
    	}
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		return new ResultWrapper( true, 1, root.val, root.val );
    	}
    	
    	ResultWrapper leftResult = largestBSTSubtreeRecurse( root.left );
    	ResultWrapper rightResult = largestBSTSubtreeRecurse( root.right );
    	
    	if ( leftResult.isBST 
    			&& rightResult.isBST )
    	{
    		if ( leftResult.maxValue < root.val 
    			&& root.val < rightResult.minValue )
    		{
    			return new ResultWrapper( true, leftResult.largestBSTSize + rightResult.largestBSTSize + 1, leftResult.minValue, rightResult.maxValue );
    		}
    		else if ( leftResult.largestBSTSize > rightResult.largestBSTSize )
    		{
    			return new ResultWrapper( false, leftResult.largestBSTSize, leftResult.minValue, leftResult.maxValue );
    		}
    		else
    		{
    			return new ResultWrapper( false, rightResult.largestBSTSize, rightResult.minValue, rightResult.maxValue );
    		}
    	}
    	else if ( leftResult.isBST )
    	{
    		return new ResultWrapper( false, leftResult.largestBSTSize, leftResult.minValue, leftResult.maxValue );
    	}
    	else if ( rightResult.isBST )
    	{
    		return new ResultWrapper( false, rightResult.largestBSTSize, rightResult.minValue, rightResult.maxValue );
    	}
    	else
    	{
    		return new ResultWrapper( false, 1, root.val, root.val );
    	}
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
