package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utility.TreeNode;

/**
 * 
 */

public class BinaryTreeLevelOrderTraversal
{

    public List<List<Integer>> levelOrder( TreeNode root ) 
    {
        List<List<Integer>> allLevelNums = new ArrayList<>();
        List<Integer> currLevelNums = new ArrayList<>();

        if ( root == null )
        {
        	return allLevelNums;
        }
    	Queue<TreeNode> currLevelNodes = new LinkedList<>();
        Queue<TreeNode> nextLevelNodes = new LinkedList<>();

        currLevelNodes.add( root );        
        
        while ( !currLevelNodes.isEmpty( ) )
        {
        	// dequeue curr level elem, add to result and enqueue its children
        	TreeNode queueHead = currLevelNodes.remove( );
        	currLevelNums.add( queueHead.val );
        	if ( queueHead.left != null )
        	{
        		nextLevelNodes.add( queueHead.left );
        	}
        	if ( queueHead.right != null )
        	{
        		nextLevelNodes.add( queueHead.right );
        	}
        	
        	// currLevel used up
        	if ( currLevelNodes.isEmpty( ) )
        	{
        		allLevelNums.add( currLevelNums );
        		currLevelNums = new ArrayList<>();
        		
        		currLevelNodes.addAll( nextLevelNodes );
        		nextLevelNodes = new LinkedList<>();
        	}
        }
        
        return allLevelNums;
    }

}
