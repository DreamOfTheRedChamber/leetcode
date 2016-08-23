package binarySearch;

import utility.TreeNode;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * */

// TODO: why cannot have private classes
class ResultWrapper
{
	public final int numNodes;
	public final TreeNode kthNode;
	public ResultWrapper( TreeNode kthNode,  int numNodes )
	{
		this.numNodes = numNodes;
		this.kthNode = kthNode;
	}
}

public class KthSmallestElementInABST 
{
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
    		if ( leftChildResult.kthNode != null )
    		{
    			return leftChildResult;
    		}
    		else
    		{
    			totalNumNodes += leftChildResult.numNodes;
    		}
    	}
    	
    	totalNumNodes += 1;
    	if ( totalNumNodes == kth )
    	{
    		return new ResultWrapper( root, kth );
    	}
    	
    	if ( root.right != null )
    	{
    		return kthSmallestRecurse( root.right, kth - totalNumNodes );
    	}
    	
    	return new ResultWrapper( null, -1 );
    }
}