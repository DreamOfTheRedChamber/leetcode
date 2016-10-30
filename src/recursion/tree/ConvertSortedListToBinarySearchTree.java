package recursion.tree;

import utility.ListNode;
import utility.TreeNode;

/**
 * 
 */

public class ConvertSortedListToBinarySearchTree
{
	private ListNode nextNode = null;

    public TreeNode sortedListToBST( ListNode head )
    {
    	ListNode currNode = head;
    	int numListNodes = 0;
    	while ( currNode != null )
    	{
    		numListNodes++;
    		currNode = currNode.next;
    	}
    	
    	nextNode = head;
    	return buildTreeRecurse( 0, numListNodes - 1 );    	
    }
    
    private TreeNode buildTreeRecurse( int start, int end )
    {
    	if ( start > end )
    	{
    		return null;
    	}
    	
    	int rootIndex = ( end - start ) / 2 + start;
    	TreeNode leftSubtree = buildTreeRecurse( start, rootIndex - 1 );
    	TreeNode root = new TreeNode( nextNode.val );
    	nextNode = nextNode.next;
    	TreeNode rightSubtree = buildTreeRecurse( rootIndex + 1, end );
    	root.left = leftSubtree;
    	root.right = rightSubtree;
    	return root;
    }

}