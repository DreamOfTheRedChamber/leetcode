package recursionTree;

import java.util.ArrayList;
import java.util.List;

import utility.TreeNode;

/**
 * 
 */

public class SumRootToLeafNumbers
{
    public int sumNumbers( TreeNode root )
    {
        List<Integer> rootToLeafNumbers = new ArrayList<>();
        if ( root != null )
        {
        	depthFirstSearch( rootToLeafNumbers, root, 0 );
        }
        
        int sum = 0;
        for ( Integer num : rootToLeafNumbers )
        {
        	sum += num;
        }
        return sum;
    }
    
    private void depthFirstSearch( List<Integer> rootToLeafNumbers, TreeNode root, int baseNum )
    {
    	// assert root != null 
    	int newBaseNum = baseNum * 10 + root.val;
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		rootToLeafNumbers.add( newBaseNum );
    	}
    	else
    	{
    		if ( root.left != null )
    		{
    			depthFirstSearch( rootToLeafNumbers, root.left, newBaseNum );
    		}
    		if ( root.right != null )
    		{
    			depthFirstSearch( rootToLeafNumbers, root.right, newBaseNum );
    		}
    	}
    }
}
