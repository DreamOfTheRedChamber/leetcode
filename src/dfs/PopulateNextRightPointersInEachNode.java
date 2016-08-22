package dfs;

import utility.TreeLinkNode;

/**
 * 
 */

public class PopulateNextRightPointersInEachNode
{

    public void connect( TreeLinkNode root )
    {
        if ( root == null )
        {
        	return;
        }
        
        // connect nodes at upper layer
        if ( root.left != null )
        {
        	root.left.next = root.right;
        	if ( root.right != null )
        	{
        		if ( root.next == null )
        		{
        			root.right.next = null;
        		}
        		else
        		{
        			root.right.next = root.next.left;
        		}
        	}
        }
        
        // recurse
        connect( root.left );
        connect( root.right );
    }

}
