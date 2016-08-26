package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
 * 
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
    	List<List<Integer>> allLevels = new ArrayList<>();
    	if ( root == null )
    	{
    		return allLevels;
    	}
    	
    	Stack<TreeNode> oddLevelStack = new Stack<>();
    	Stack<TreeNode> evenLevelStack = new Stack<>();
    	oddLevelStack.push( root );
    	
    	while ( !oddLevelStack.isEmpty() 
    			|| !evenLevelStack.isEmpty() )
    	{
    		List<Integer> oneLevel = new LinkedList<>();
    		// odd layer, push right child first, left child last
    		if ( !oddLevelStack.isEmpty() )
    		{    			
    			while ( !oddLevelStack.isEmpty() )
    			{
    				TreeNode stackTop = oddLevelStack.pop();
    				oneLevel.add( stackTop.val );
    				if ( stackTop.left != null )
    				{
    					evenLevelStack.push( stackTop.left );
    				}
    				if ( stackTop.right != null )
    				{
    					evenLevelStack.push( stackTop.right );
    				}
    			}
    		}
    		// even layer, push left child first, right child last
    		else
    		{
    			while ( !evenLevelStack.isEmpty() )
    			{
    				TreeNode stackTop = evenLevelStack.pop();
    				oneLevel.add( stackTop.val );
    				if ( stackTop.right != null )
    				{
    					oddLevelStack.push( stackTop.right );
    				}
    				if ( stackTop.left != null )
    				{
    					oddLevelStack.push( stackTop.left );
    				}
    			}
    		}
    		allLevels.add( oneLevel );
    	}
    	return allLevels;
    }

}
