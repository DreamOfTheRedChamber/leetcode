package binarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utility.TreeNode;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * */

public class KthSmallestElementInABST 
{
	private class ResultWrapper
	{
		public final int numNodes;	// do not rely on num count 
		public final TreeNode kthNode;
		public final boolean isKthNodeFound;
		public ResultWrapper( TreeNode kthNode,  int numNodes, boolean isKthNodeFound )
		{
			this.numNodes = numNodes;
			this.kthNode = kthNode;
			this.isKthNodeFound = isKthNodeFound;
		}
	}
	
    public int kthSmallest( TreeNode root, int k )
    {
    	if ( root == null 
    			|| k <= 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	ResultWrapper result = kthSmallestRecurse( root, k );
    	return result.kthNode.val;
    }
    
    private ResultWrapper kthSmallestRecurse( TreeNode root, int kth )
    {
    	int totalNumNodes = 0;    	
    	if ( root.left != null )
    	{
    		ResultWrapper leftChildResult = kthSmallestRecurse( root.left, kth );
    		if ( leftChildResult.isKthNodeFound )
    		{
    			// kth node exist in left subtree
    			return leftChildResult;
    		}
    		else
    		{
    			totalNumNodes += leftChildResult.numNodes;
    		}
    	}
    	
    	// kth node is root
    	totalNumNodes += 1;
    	if ( totalNumNodes == kth )
    	{
    		return new ResultWrapper( root, kth, true );
    	}    	
    	
    	if ( root.right != null )
    	{
    		ResultWrapper rightChildResult = kthSmallestRecurse( root.right, kth - totalNumNodes );
    		if ( rightChildResult.isKthNodeFound )
    		{
    			return rightChildResult;
    		}
    		else
    		{	
    			totalNumNodes += rightChildResult.numNodes;
    		}
    	}
    	
    	return new ResultWrapper( null, totalNumNodes, false );
    }
    
    @Test
    public void test()
    {
    	TreeNode node1 = new TreeNode( 2 );
    	TreeNode node2 = new TreeNode( 1 );
    	node1.left = node2;
    	assertEquals( 2, kthSmallest( node1, 2 ) );
    }
}