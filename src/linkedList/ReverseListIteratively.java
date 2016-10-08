package linkedList;

import utility.ListNode;

public class ReverseListIteratively 
{
	public ListNode reverseList( ListNode head )
	{
		ListNode dummyHead = new ListNode( 0 );
		ListNode currNode = head;
		while ( currNode != null )
		{
			ListNode dummyHeadNextBuffer = dummyHead.next;
			ListNode currNodeNextBuffer = currNode.next;
			
			dummyHead.next = currNode;
			currNode.next = dummyHeadNextBuffer;
			
			currNode = currNodeNextBuffer;
		}
		return dummyHead.next;
	}
}
