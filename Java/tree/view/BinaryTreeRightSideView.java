package tree.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utility.TreeNode;

/**
 * 
 */

public class BinaryTreeRightSideView
{
    public List<Integer> rightSideView( TreeNode root ) 
    {    	
        List<Integer> rightMostNodes = new ArrayList<>();
        if ( root == null )
        {
        	return rightMostNodes;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add( root );
        while ( !bfsQueue.isEmpty() )
        {
        	int levelSize = bfsQueue.size();
        	for ( int i = 0; i < levelSize; i++ )
        	{
        		TreeNode head = bfsQueue.remove();
        		if ( head.left != null )
        		{
        			bfsQueue.add( head.left );
        		}
        		if ( head.right != null )
        		{
        			bfsQueue.add( head.right );
        		}
        		
        		if ( i == levelSize - 1 )
        		{        			
        			rightMostNodes.add( head.val );
        		}
        	}
        	
        }
        return rightMostNodes;
    }
    
    public List<Integer> rightSideViewRecurse( TreeNode root )
    {
    	List<Integer> result = new LinkedList<>();
    	rightViewRecurse( root, result, 0 );
    	return result;
    }
    
    private void rightViewRecurse( TreeNode root, List<Integer> result, int currDepth )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	if ( currDepth == result.size() )
    	{
    		result.add( root.val );
    	}
    	
    	rightViewRecurse( root.right, result, currDepth + 1 );
    	rightViewRecurse( root.left, result, currDepth + 1 );
    }
}
