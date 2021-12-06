package linkedIn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
 3
   / \
  9  20
 /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

public class BinaryTreeZigzagLevelOrderTraversal
{
	@Test
	public void test()
	{
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		System.out.println( zigzagLevelOrder( root ) );
	}
	
 public List<List<Integer>> zigzagLevelOrder( TreeNode root )
 {
 	List<List<Integer>> result = new ArrayList<>();
 	if ( root == null )
 	{
 		return result;
 	}
 	
 	Stack<TreeNode> currLayer = new Stack<>();
 	currLayer.push( root );
 	Stack<TreeNode> nextLayer = new Stack<>();
 	List<Integer> layerOutput = new ArrayList<>();
 	int direction = 0;
 	
 	while ( !currLayer.isEmpty() )
 	{
 		TreeNode node = currLayer.pop();
 		layerOutput.add( node.val );
 		if ( direction == 0 )
 		{
 			if ( node.left != null )
 			{
 				nextLayer.push( node.left );
 			}
 			if ( node.right != null )
 			{
 				nextLayer.push( node.right );
 			}
 		}
 		else
 		{
 			if ( node.right != null )
 			{
 				nextLayer.push( node.right );
 			}
 			if ( node.left != null )
 			{
 				nextLayer.push( node.left );
 			}
 		}
 		
 		if ( currLayer.isEmpty() )
 		{
 			result.add( layerOutput );
 			layerOutput = new ArrayList<>();
 			currLayer = nextLayer;
 			nextLayer = new Stack<>();
 			
 			direction ^= 1;
 		}
 	}
 	return result; 	
 }

}
