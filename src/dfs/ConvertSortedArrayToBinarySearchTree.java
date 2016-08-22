package dfs;

import utility.TreeNode;

/**
 * 
 */

public class ConvertSortedArrayToBinarySearchTree
{

    public TreeNode sortedArrayToBST( int[] nums )
    {
        return buildTreeRecurse( nums, 0, nums.length - 1 );
    }

    private TreeNode buildTreeRecurse( int[] nums, int start, int end )
    {
    	if ( start > end )
    	{
    		return null;
    	}
    	
    	int rootIndex = ( end - start ) / 2 + start;
    	TreeNode root = new TreeNode( nums[rootIndex] );
    	root.left = buildTreeRecurse( nums, start, rootIndex - 1 );
    	root.right = buildTreeRecurse( nums, rootIndex + 1, end );
    	return root;
    }
}
