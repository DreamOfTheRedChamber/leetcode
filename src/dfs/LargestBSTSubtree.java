package dfs;

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

// TO_TEST
// TODO: improve complexity
public class LargestBSTSubtree
{
    public int largestBSTSubtree( TreeNode root )
    {
    	if ( root == null )
    	{
    		return 0;
    	}
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		return 1;
    	}
    	
    	int leftResult = largestBSTSubtree( root.left );
    	int rightResult = largestBSTSubtree( root.right );
    	
    	if ( leftResult >= 0 
    			&& rightResult >= 0 )
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
    			return largestLeftChild + smallestRightChild + 1;
    		}
    	}
    	return Math.max( leftResult, rightResult );
    }
}
