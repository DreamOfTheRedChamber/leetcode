package dfs;

import utility.TreeNode;

/**
 * 
 */

public class HouseRobberIII
{
    public int rob( TreeNode root )
    {
        if ( root == null )
        {
        	return 0;
        }
        int[] possibleRobResults = robRecurse( root, 0 );
        return Math.max( possibleRobResults[0], possibleRobResults[1] );
    }
    
    /**
     * 
     * @param root
     * @param depth  tree depth
     * @return int[]  two possible rob results starting from root node down to leaves, int[0] for even layer, int[1] for odd layer
     */
    private int[] robRecurse( TreeNode root, int depth )
    {    	
    	if ( root == null )
    	{
    		return new int[2];
    	}
    	
    	int[] leftChildResults = robRecurse( root.left, depth + 1 );
    	int[] rightChildResults = robRecurse( root.right, depth + 1 );
    	if ( depth % 2 == 0 )
    	{
    		return new int[]{ leftChildResults[0] + root.val + rightChildResults[0], leftChildResults[1] + rightChildResults[1] };
    	}
    	else
    	{
    		return new int[]{ leftChildResults[0] + rightChildResults[0], leftChildResults[1] + root.val + rightChildResults[1] };    		
    	}
    }
}