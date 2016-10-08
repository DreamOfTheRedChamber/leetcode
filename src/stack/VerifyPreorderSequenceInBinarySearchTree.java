package stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
 * */

public class VerifyPreorderSequenceInBinarySearchTree 
{
	@Test
	public void test()
	{
		assertTrue( verifyPreorder( new int[]{ 4, 2, 3, 6, 5 } ) );
		assertFalse( verifyPreorder( new int[]{ 4, 2, 6, 5, 3 } ) );		
		assertFalse( verifyPreorder( new int[]{ 4, 5, 3, 2, 9, 6, 1, 8, 7, 10, 11 } ) );
	}
	
    public boolean verifyPreorder( int[] preorder )
    {
    	if ( preorder == null )
    	{
    		throw new IllegalArgumentException("");
    	}
    	if ( preorder.length == 0 )
    	{
    		return true;
    	}
    	
    	return verifyPreorder( preorder, 0, preorder.length - 1 );    	
    }
    
    private boolean verifyPreorder( int[] preorder, int startPos, int endPos )
    {
    	if ( endPos <= startPos )
    	{
    		return true;
    	}
    	
    	int firstBiggerPos = endPos + 1; // first pos bigger than tree root
    	// assume no duplicates
    	// left subtree all smaller
    	for ( int i = startPos; i <= endPos; i++ )
    	{
    		if ( preorder[i] > preorder[startPos] )
    		{
    			firstBiggerPos = i;
    			break;
    		}
    	}
	    	// right subtree all bigger
	    for ( int i = firstBiggerPos; i <= endPos; i++ )
	    {
	    	if ( preorder[i] < preorder[startPos] )
	    	{
	    		return false;
	    	}
	    }
    	
    	return verifyPreorder( preorder, startPos + 1, firstBiggerPos - 1 )
    			&& verifyPreorder( preorder, firstBiggerPos, endPos );
    }
}