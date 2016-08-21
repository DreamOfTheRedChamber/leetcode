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
        if ( root != null )
        {
        	currPath.add( root.val );
        	depthFirstSearch( allPaths, currPath, root, sum - root.val );
        }
        return allPaths;
    }
    
    private void depthFirstSearch( List<List<Integer>> allPaths, List<Integer> currPath, TreeNode currNode, int target )
    {
    	// recurse boundaries
    	if ( target == 0 )
    	{
    		allPaths.add( new LinkedList<>( currPath ) );
    		return;
    	}
    	
    	if ( currNode.left != null )
    	{
    		currPath.add( currNode.left.val );
    		depthFirstSearch( allPaths, currPath, currNode.left, target - currNode.left.val );
    		currPath.remove( currPath.size() - 1 );
    	}
    	
    	if ( currNode.right != null )
    	{
    		currPath.add( currNode.right.val );
    		depthFirstSearch( allPaths, currPath, currNode.right, target - currNode.right.val );
    		currPath.remove( currPath.size() - 1 );
    	}
    }

}
