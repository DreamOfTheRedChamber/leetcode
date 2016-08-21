package bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import utility.TreeNode;

/**
 * 
 */

public class BinaryTreeZigzagLevelOrderTraversal
{

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
    	List<List<Integer>> result = new ArrayList<>();
    	if ( root == null )
    	{
    		return result;
    	}
    	
    	Deque<TreeNode> bfsQueue = new LinkedList<>();
    	bfsQueue.addFirst( root );
    	boolean isOddLevel = true;
    	while ( !bfsQueue.isEmpty() )
    	{
    		int levelSize = bfsQueue.size();
    		List<Integer> levelNodes = new ArrayList<>();
    		for ( int i = 0; i < levelSize; i++ )
    		{
    			TreeNode head = null;
    			if ( isOddLevel )
    			{
    				head = bfsQueue.removeLast();
    			}
    			else
    			{
    				head = bfsQueue.removeFirst();
    			}
    			levelNodes.add( head.val );
    			
    			if ( head.right != null )
    			{
    				bfsQueue.addLast( head.right );
    			}
    			if ( head.left != null )
    			{
    				bfsQueue.addFirst( head.left );
    			}
    		}
    		isOddLevel = !isOddLevel;
    		result.add( levelNodes );
    	}
    	    	
    	return result;
    }

}
