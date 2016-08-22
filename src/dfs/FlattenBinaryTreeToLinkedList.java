package dfs;

import utility.ListNode;
import utility.TreeNode;

/**
 * 
 */

class ListHeadTail
{
	public final ListNode head;
	public final ListNode tail;
	public ListHeadTail( ListNode head, ListNode tail )
	{
		this.head = head;
		this.tail = tail;
	}
}

public class FlattenBinaryTreeToLinkedList
{
    public void flatten( TreeNode root )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	flattenRecurse( root );
    }
    
    private ListHeadTail flattenRecurse( TreeNode root )
    {
    	if ( root.left == null 
    			&& root.right == null )
    	{
    		ListNode node = new ListNode( root.val );
    		return new ListHeadTail( node, node );
    	}
    	else
    	{
    		ListNode head = new ListNode( root.val );
    		ListNode tail = head;
    		if ( root.left != null )
    		{
    			ListHeadTail leftChildList = flattenRecurse( root.left );
    			tail.next = leftChildList.head;
    			tail = leftChildList.tail;
    		}
    		if ( root.right != null )
    		{
    			ListHeadTail rightChildList = flattenRecurse( root.right );
    			tail.next = rightChildList.head;
    			tail = rightChildList.tail;
    		}
    		return new ListHeadTail( head, tail );
    	}
    }
}
