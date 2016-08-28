package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
 * 
 */

public class FlattenBinaryTreeToLinkedList
{
    public void flatten( TreeNode root )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	Stack<TreeNode> preorderStack = new Stack<>();
    	preorderStack.push( root );
    	TreeNode sentinelHead = new TreeNode( 0 );
    	TreeNode sentinelTail = sentinelHead;
    	while ( !preorderStack.isEmpty() )
    	{
    		TreeNode stackTop = preorderStack.pop();
    		if ( stackTop.right != null )
    		{
    			preorderStack.push( stackTop.right );
    		}
    		if ( stackTop.left != null )
    		{
    			preorderStack.push( stackTop.left );
    		}
    		sentinelTail.right = stackTop;
    		sentinelTail = stackTop;

    		stackTop.left = null;
    		stackTop.right = null;
    	}   	
    }

    @Test
    public void test()
    {
    	TreeNode node0 = new TreeNode( 0 );
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 3 );
    	TreeNode node4 = new TreeNode( 4 );
    	TreeNode node5 = new TreeNode( 5 );
    	node0.left = node1;
    	node0.right = node4;
    	node1.left = node2;
    	node1.right = node3;
    	node4.right = node5;
    	flatten( node0 );
    }
}
