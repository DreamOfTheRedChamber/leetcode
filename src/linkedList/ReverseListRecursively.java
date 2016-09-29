package linkedList;

import utility.ListNode;

public class ReverseListRecursively 
{
	public ListNode reverseList( ListNode head )
	{
		if ( head == null
				|| head.next == null )
		{
			return head;
		}
		
		ListNode reversedListTail = head.next;
		ListNode reversedListHead = reverseList( head.next );
		reversedListTail.next = head;
		head.next = null;
		return reversedListHead;
	}
}
