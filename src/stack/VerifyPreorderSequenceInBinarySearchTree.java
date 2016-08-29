package stack;

/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
 * */

// TODO: handle duplicates inside BST
public class VerifyPreorderSequenceInBinarySearchTree 
{
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
    	
    	return verifyPreorderRecurse( preorder, 0, preorder.length - 1 );    	
    }
    
    private boolean verifyPreorderRecurse( int[] preorder, int startPos, int endPos )
    {
    	if ( endPos <= startPos )
    	{
    		return true;
    	}
    	
    	int firstBiggerPos = 0; // first pos bigger than tree root
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
    	
    	return verifyPreorderRecurse( preorder, startPos + 1, firstBiggerPos - 1 )
    			&& verifyPreorderRecurse( preorder, firstBiggerPos, endPos );
    }
}