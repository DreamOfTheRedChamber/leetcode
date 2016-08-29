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
        
        return isValidBSTRecurse( root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    
    private boolean isValidBSTRecurse( TreeNode root, long lowerBound, long upperBound )
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	else if ( root.val <= lowerBound
    			|| root.val >= upperBound )
    	{
    		return false;
    	}
    	else
    	{
    		return isValidBSTRecurse( root.left, lowerBound, root.val )
    				&& isValidBSTRecurse( root.right, root.val, upperBound );
    	}    	    	
    }

}
