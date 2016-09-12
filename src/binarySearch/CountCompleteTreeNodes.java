package binarySearch;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import utility.TreeFactory;
import utility.TreeNode;

/*
 * Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.*/
// TO_TEST
// TODO: provide a more concise solution
public class CountCompleteTreeNodes 
{
    public int countNodes( TreeNode root )
    {
    	if ( root == null )
    	{
    		return 0;
    	}
    	
    	// calc left most branch depth
    	int leftMostDepth = 0;
    	for ( TreeNode currNode = root; currNode != null; currNode = currNode.left )
    	{
    		leftMostDepth++;
    	}
    	// calc right most branch depth
    	int rightMostDepth = 0;
    	for ( TreeNode currNode = root; currNode != null; currNode = currNode.right )
    	{
    		rightMostDepth++;
    	}
    	
    	
    	if ( leftMostDepth == rightMostDepth )
    	{
    		return (int) Math.pow( 2, rightMostDepth ) - 1;
    	}
    	else // tree not a complete tree
    	{
    		int numLeftSubtree = countNodes( root.left );
    		int numRightSubtree = countNodes( root.right );
    		return numLeftSubtree + 1 + numRightSubtree;
    	}
    }
    
    @Test
    public void test()
    {
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 3 );
    	TreeNode node4 = new TreeNode( 4 );
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	assertEquals( 4, countNodes( node1 ) );
    	assertEquals( 11, countNodes( TreeFactory.createCompleteTree() ) );
    	assertEquals( 15, countNodes( TreeFactory.createFullTree() ) );
    }
}