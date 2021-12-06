package stack;

import static org.junit.Assert.assertEquals;

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
 	
 	TreeNode target = p;
 	if ( target.right != null )
 	{
 		TreeNode currNode = target.right;
 		while ( currNode.left != null )
 		{
 			currNode = currNode.left;
 		}
 		return currNode;
 	}
 	else
 	{
 		TreeNode successor = null;
 		TreeNode currNode = root;
 		while ( currNode != target )
 		{
 			if ( currNode.val >= target.val )
 			{
 				successor = currNode;
 				currNode = currNode.left;
 			}
 			else
 			{
 				currNode = currNode.right;
 			}
 		}
 		return successor;
 	}
 } 
 
 @Test
 public void test()
 {
 	TreeNode node1 = new TreeNode( 2 );
 	TreeNode node2 = new TreeNode( 1 );
 	node1.left = node2;
 	
 	assertEquals( 2, inorderSuccessor( node1, node2 ).val );
 }
}
