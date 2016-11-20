package facebook.medium;

import java.util.Stack;

import utility.TreeNode;

/**
 * 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */

public class ValidBinarySearchTree
{

    public boolean isValidBST( TreeNode root )
    {
        if ( root == null )
        {
        	return true;
        }
        
        return isValidBSTRecurse( root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    
    private boolean isValidBSTRecurse( TreeNode root, long lowerBound, long upperBound )
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	else if ( root.val <= lowerBound
    			|| root.val >= upperBound )
    	{
    		return false;
    	}
    	else
    	{
    		return isValidBSTRecurse( root.left, lowerBound, root.val )
    				&& isValidBSTRecurse( root.right, root.val, upperBound );
    	}    	    	
    }

    public boolean isValidBSTTraversal( TreeNode root )
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	Stack<TreeNode> stack = new Stack<>();
    	pushLeftChild( root, stack );
    	TreeNode prevNode = null;
    	while ( !stack.isEmpty() )
    	{
    		TreeNode top = stack.pop();
    		if ( prevNode != null && top.val <= prevNode.val )
    		{
    			return false;
    		}
    		prevNode = top;
    		if ( top.right != null )
    		{
    			pushLeftChild( top.right, stack );
    		}
    	}
    	return true;
    }
    
    private void pushLeftChild( TreeNode root, Stack<TreeNode> stack )
    {
    	TreeNode currNode = root;
    	while ( currNode != null )
    	{
    		stack.push( currNode );
    		currNode = currNode.left;
    	}
    }
}
