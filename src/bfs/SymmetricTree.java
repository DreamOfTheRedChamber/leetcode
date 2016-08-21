package bfs;

/**
 * 
 */

public class SymmetricTree
{
    public boolean isSymmetric(TreeNode root) 
    {
    	if ( root == null )
    	{
    		return true;
    	}
    	else if ( root.left == null || root.right == null )
    	{
    		return true;
    	}
    	else if ( root.left != null && root.right != null )
    	{
    		if ( root.left.val == root.right.val 
    				&& isSymmetric( root.left )
    				&& isSymmetric( root.right ) )
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else
    	{
    		return false;
    	}    	    	
    }
}
