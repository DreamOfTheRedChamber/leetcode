package linkedIn;

import java.util.Stack;

import utility.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *  int val;
 *  TreeNode left;
 *  TreeNode right;
 *  TreeNode(int x) { val = x; }
 * }
 */


public class BSTIterator 
{
	class Pair
	{
		public TreeNode node;
		public boolean isFirst;
		public Pair( TreeNode node, boolean isFirst )
		{
			this.node = node;
			this.isFirst = isFirst;
		}
	}
	
	Stack<Pair> stack = new Stack<>();
	
 public BSTIterator(TreeNode root) 
 {
 	if ( root != null )
 	{
 		stack.push( new Pair( root, true ) );
 	}
 }

 /** @return whether we have a next smallest number */
 public boolean hasNext() 
 {
 	return !stack.isEmpty();
 }

 /** @return the next smallest number */
 public int next() 
 {
 	int result = 0;
 	while ( !stack.isEmpty() )
 	{
 		Pair top = stack.pop();
 		if ( top.isFirst )
 		{
 			if ( top.node.right != null )
 			{
 				stack.push( new Pair( top.node.right, true ) );
 			}
 			top.isFirst = false;
 			stack.push( top );
 			if ( top.node.left != null )
 			{
 				stack.push( new Pair( top.node.left, true ) );
 			}

 		}
 		else
 		{
 			result = top.node.val;
 			break;
 		}
 	}
 	return result;
 }  
 
// Original version:  
// private Stack<TreeNode> inorderTravStack;
//
// public BSTIterator(TreeNode root) 
// {
//  inorderTravStack = new Stack<>();
//  pushAllPureLeftChildren( inorderTravStack, root );
// }
//
// /** @return whether we have a next smallest number */
// public boolean hasNext() 
// {
//  return !inorderTravStack.isEmpty();
// }
//
// /** @return the next smallest number */
// public int next() 
// {
//  TreeNode nextSmallestNode = inorderTravStack.pop();
//  if ( nextSmallestNode.right != null )
//  {
//   pushAllPureLeftChildren( inorderTravStack, nextSmallestNode.right);
//  }
//  return nextSmallestNode.val;
// }
// 
// private void pushAllPureLeftChildren( Stack<TreeNode> inorderTravStack, TreeNode root )
// {
//  TreeNode currNode = root;
//  while ( currNode != null )
//  {
//   inorderTravStack.push( currNode );
//   currNode = currNode.left;
//  }
// }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
