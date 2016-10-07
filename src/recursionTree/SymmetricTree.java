package recursionTree;

import utility.TreeNode;

/**
 * 
 */

public class SymmetricTree
{
    public boolean isSymmetric( TreeNode root )
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	
    	return isSymmetricRecurse( root.left, root.right );
    }
    
    boolean isSymmetricRecurse( TreeNode left, TreeNode right )
    {
    	if ( left == null )
    	{
    		return right == null;
    	}
    	else if ( right == null )
    	{
    		return left == null;
    	}
    	else if ( left.val != right.val )
    	{
    		return false;
    	}
    	else if ( !isSymmetricRecurse( left.left, right.right ) )
    	{
    		return false;
    	}
    	else if ( !isSymmetricRecurse( left.right, right.left ) )
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
}
