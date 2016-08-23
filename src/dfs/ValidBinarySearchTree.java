package dfs;

import utility.TreeNode;

/**
 * 
 */

public class ValidBinarySearchTree
{

    public boolean isValidBST( TreeNode root )
    {
        if ( root == null )
        {
        	return true;
        }
        
        return isValidBSTRecurse( root.left, Integer.MIN_VALUE, root.val - 1 )
        		&& isValidBSTRecurse( root.right, root.val + 1, Integer.MAX_VALUE );
    }
    
    private boolean isValidBSTRecurse( TreeNode root, int lowerBound, int upperBound )
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	else if ( root.val < lowerBound
    			|| root.val > upperBound )
    	{
    		return false;
    	}
    	else
    	{
    		return isValidBSTRecurse( root.left, lowerBound, root.val - 1 )
    				&& isValidBSTRecurse( root.right, root.val + 1, upperBound + 1 );
    	}    	    	
    }

}
