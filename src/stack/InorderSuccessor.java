package stack;

import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
 */

public class InorderSuccessor
{
    public TreeNode inorderSuccessor( TreeNode root, TreeNode p ) 
    {
    	if ( root == null 
    			|| p == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	// has right child
    	if ( p.right != null )
    	{
    		TreeNode successor = p.right;
    		while ( successor.left != null )
    		{
    			successor = successor.left;
    		}
    		return successor;
    	}
    	
    	// find node along the path where lower node is left child of upper node
    	Stack<TreeNode> path = new Stack<>();
    	TreeNode currNode = root;
    	while ( currNode != p )
    	{
    		path.push( currNode );
    		if ( currNode.val < p.val )
    		{
    			currNode = currNode.right;
    		}
    		else
    		{
    			currNode = currNode.left;
    		}
    	}

    	TreeNode child = p;
    	while ( !path.isEmpty() )
    	{
    		TreeNode top = path.pop();
    		if ( top.left == child )
    		{
    			return top;
    		}
    		child = top;
    	}
    	
    	return null;
    }    
}
