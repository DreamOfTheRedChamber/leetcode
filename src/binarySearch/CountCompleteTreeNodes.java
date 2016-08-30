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
    	
    	// calc tree depth
        int treeDepth = 0;
        TreeNode currNode = root;
        while ( currNode != null )
        {
        	treeDepth++;
        	currNode = currNode.left;
        }
        
        // binary search
        int start = 1;
        int end = (int) Math.pow( 2, treeDepth );
        while ( start + 1 < end )
        {
        	int mid = ( end - start ) / 2 + start;
        	if ( doesLeafExist( root, mid, treeDepth ) )
        	{
        		start = mid;
        	}
        	else
        	{
        		end = mid;
        	}
        }

        int numNonLeafNodes = ( int )( Math.pow( 2, treeDepth-1) ) - 1;
        if ( doesLeafExist( root, end, treeDepth ) )
        {
        	return numNonLeafNodes + end;
        }
        else
        {
        	return numNonLeafNodes + start;
        }
    }
    
    private boolean doesLeafExist( TreeNode root, int kthLeaf, int treeDepth )
    {
    	Stack<Boolean> rootToKthLeafPath = new Stack<>(); // false -> left, true -> right
    	int numNonLeafNodes = ( int )( Math.pow( 2, treeDepth-1) ) - 1;
    	
    	// go from leaf to root, put path in a stack
    	int currNodeOrder = numNonLeafNodes + kthLeaf;
    	while ( currNodeOrder != 1 )
    	{
    		if ( currNodeOrder % 2 == 1 )
    		{
    			rootToKthLeafPath.push( true );
    		}
    		else
    		{
    			rootToKthLeafPath.push( false );
    		}
    		currNodeOrder /= 2;
    	}
    	
    	// go from root to leaf, check node existence
    	TreeNode currNode = root;
    	while ( !rootToKthLeafPath.isEmpty() )
    	{
    		boolean shouldGoRight = rootToKthLeafPath.pop();
    		if ( shouldGoRight )
    		{
    			currNode = currNode.right;
    		}
    		else
    		{
    			currNode = currNode.left;
    		}
    	}
    	
    	// whether specific leaf exists
    	if ( currNode == null )
    	{
    		return false;
    	}
    	else
    	{
    		return true;
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
    	assertEquals( 4, countNodes(node1) );
    	assertEquals( 11, countNodes( TreeFactory.createCompleteTree() ) );
    	assertEquals( 15, countNodes( TreeFactory.createFullTree() ) );
    }
}