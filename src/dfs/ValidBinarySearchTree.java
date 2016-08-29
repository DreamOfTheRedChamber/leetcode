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
        
        return isValidBSTRecurse( root, Integer.MIN_VALUE, Integer.MAX_VALUE );
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
    	else if ( root.val == Integer.MIN_VALUE )
    	{
    		if ( root.left != null )
    		{
    			return false;
    		}
    		else
    		{
    			return isValidBSTRecurse( root.right, root.val + 1, upperBound );
    		}
    	}
    	else if ( root.val == Integer.MAX_VALUE )
    	{
    		if ( root.right != null )
    		{
    			return false;
    		}
    		else
    		{
    			return isValidBSTRecurse( root.left, lowerBound, root.val - 1 );
    		}
    	}
    	else
    	{
    		return isValidBSTRecurse( root.left, lowerBound, root.val - 1 )
    				&& isValidBSTRecurse( root.right, root.val + 1, upperBound );
    	}    	    	
    }

}
