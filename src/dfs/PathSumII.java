package dfs;

import java.util.LinkedList;
import java.util.List;

import utility.TreeNode;

/**
 * 
 */

public class PathSumII
{
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        List<List<Integer>> allPaths = new LinkedList<>();
        List<Integer> currPath = new LinkedList<>();
        depthFirstSearch( allPaths, currPath, root, sum );
        return allPaths;
    }
    
    private void depthFirstSearch( List<List<Integer>> allPaths, List<Integer> currPath, TreeNode currNode, int target )
    {
    	if ( currNode == null )
    	{
    		return;
    	}
    	
    	if ( currNode.left == null 
    			&& currNode.right == null 
    			&& target == currNode.val )
    	{
        	currPath.add( currNode.val );
    		allPaths.add( new LinkedList<>( currPath ) );
    		currPath.remove( currPath.size() - 1 );
    		return;
    	}
    		    	
    	currPath.add( currNode.val );
    	depthFirstSearch( allPaths, currPath, currNode.left, target - currNode.val );
    	currPath.remove( currPath.size() - 1 );
    	
    	currPath.add( currNode.val );
    	depthFirstSearch( allPaths, currPath, currNode.right, target - currNode.val );
    	currPath.remove( currPath.size() - 1 );
    }
}
