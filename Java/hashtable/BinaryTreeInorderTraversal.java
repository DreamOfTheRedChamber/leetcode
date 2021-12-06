package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
 \
  2
 /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal
{

 public List<Integer> inorderTraversal( TreeNode root )
 {
 	List<Integer> result = new ArrayList<>();
 	Stack<TreeNode> stack = new Stack<>();
 	pushAllLeftChild( root, stack );
 	while ( !stack.isEmpty( ) )
 	{
 		TreeNode top = stack.pop( );
 		result.add( top.val );
 		if ( top.right != null )
 		{
 			pushAllLeftChild( top.right, stack );
 		}
 	}
 	return result;
 }
 
 private void pushAllLeftChild( TreeNode root, Stack<TreeNode> stack )
 {
 	TreeNode currNode = root;
 	while ( currNode != null )
 	{
 		stack.push( currNode );
 		currNode = currNode.left;
 	}
 }
 
 public List<Integer> inorderTraversalRecursively( TreeNode root )
 {
 	List<Integer> result = new ArrayList<>();
 	traverse( root, result );
 	return result;
 }
 
 private void traverse( TreeNode root, List<Integer> result )
 {
 	if ( root == null )
 	{
 		return;
 	}
 	traverse( root.left, result );
 	result.add( root.val );
 	traverse( root.right, result );
 }
 
 @Test
 public void test()
 {
 	TreeNode node1 = new TreeNode( 3 );
 	TreeNode node2 = new TreeNode( 1 );
 	TreeNode node3 = new TreeNode( 2 );
 	node1.left = node2;
 	node2.right = node3;
 	System.out.println( inorderTraversal( node1 ) );
 }
}