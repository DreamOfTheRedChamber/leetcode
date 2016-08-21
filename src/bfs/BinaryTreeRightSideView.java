package bfs;

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
}
