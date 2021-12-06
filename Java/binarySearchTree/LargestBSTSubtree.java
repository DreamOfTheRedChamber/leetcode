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
	private class Wrapper
	{
		public boolean isBST;
		public int size;
		public int lower;
		public int upper;
		
		public Wrapper() 
		{
			lower = Integer.MAX_VALUE;
			upper = Integer.MIN_VALUE;
			isBST = false;
			size = 0;
		}
	}
	
	public int largestBSTSubtree( TreeNode root )
	{
		if ( root == null )
		{
			return 0;
		}

		Wrapper result = helper( root );
		return result.size;
	}
		
 private Wrapper helper( TreeNode root )
 {
 	Wrapper result = new Wrapper();
 	
 	if ( root == null )
 	{
 		result.isBST = true;
 		return result;
 	}
 	
 	Wrapper leftResult = helper( root.left );
 	Wrapper rightResult = helper( root.right );
 	
 	result.lower = Math.min( root.val, leftResult.lower );
 	result.upper = Math.max( root.val, rightResult.upper );
 	
 	if ( leftResult.isBST 
 			&& rightResult.isBST 
 			&& leftResult.upper <= root.val 
 			&& rightResult.lower >= root.val )
 	{
 		result.size = leftResult.size + rightResult.size + 1;
 		result.isBST = true;
 	}
 	else
 	{
 		result.size = Math.max( leftResult.size, rightResult.size );
 		result.isBST = false;
 	}
 	
 	return result;
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
