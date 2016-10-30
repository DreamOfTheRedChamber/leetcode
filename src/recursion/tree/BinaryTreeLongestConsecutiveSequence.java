package recursion.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3, not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence
{
	
    public int longestConsecutive( TreeNode root )
    {
    	ResultWrapper result = longestRecurse( root );
    	return result.globalLongest;
    }
    
    private ResultWrapper longestRecurse( TreeNode currNode )
    {
    	if ( currNode.left == null
    			&& currNode.right == null )
    	{
    		return new ResultWrapper( 1, 1 );
    	}
    	
    	int localLongest = 1;
    	int globalLongest = 1;
    	if ( currNode.left != null )
    	{
    		ResultWrapper leftResult = longestRecurse( currNode.left );
    		if ( currNode.val + 1 == currNode.left.val )
    		{
    			localLongest = Math.max( leftResult.localLongest + 1, localLongest );
    		}
			globalLongest = Math.max( globalLongest, Math.max( localLongest, leftResult.globalLongest ) );
    	}
    	if ( currNode.right != null )
    	{
    		ResultWrapper rightResult = longestRecurse( currNode.right );
    		if ( currNode.val + 1 == currNode.right.val )
    		{
    			localLongest = Math.max( rightResult.localLongest + 1, localLongest );
    		}
			globalLongest = Math.max( globalLongest, Math.max( localLongest, rightResult.globalLongest ) );
    	}
    	
    	return new ResultWrapper( localLongest, globalLongest );
    }
    
    private class ResultWrapper
    {
    	public final int globalLongest;
    	public final int localLongest;
    	public ResultWrapper( int localLongest, int globalLongest )
    	{
    		this.globalLongest = globalLongest;
    		this.localLongest = localLongest;
    	}
    }
    
    @Test
    public void test1()
    {
    	TreeNode node1 = new TreeNode( 1 );
    	TreeNode node2 = new TreeNode( 2 );
    	TreeNode node3 = new TreeNode( 3 );
    	TreeNode node4 = new TreeNode( 4 );
    	TreeNode node5 = new TreeNode( 5 );
    	node1.left = node2;
    	node1.right = node3;
    	node3.right = node4;
    	node4.right = node5;
    	assertEquals( 3, longestConsecutive( node1 ) );
    }
    
    @Test
    public void test2()
    {
    	TreeNode node1 = new TreeNode( 2 );
    	TreeNode node2 = new TreeNode( 3 );
    	TreeNode node3 = new TreeNode( 2 );
    	TreeNode node4 = new TreeNode( 1 ); 
    	node1.right = node2;
    	node2.left = node3;
    	node3.left = node4;
    	assertEquals( 2, longestConsecutive( node1 ) );
    }
}