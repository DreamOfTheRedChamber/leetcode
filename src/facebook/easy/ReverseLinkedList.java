package facebook.easy;

import org.junit.Ignore;
import org.junit.Test;

import utility.ListNode;

/*
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 * */

public class ReverseLinkedList 
{
	@Test
	public void testIterative()
	{
		ListNode node1 = new ListNode( 1 );
		ListNode node2 = new ListNode( 2 );
		ListNode node3 = new ListNode( 3 );
		ListNode node4 = new ListNode( 4 );
		ListNode node5 = new ListNode( 5 );
		ListNode node6 = new ListNode( 6 );
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printList( reverseSinglyLinkedListIteratively( node1 ) );
	}
	
	@Test
	public void testRecursive()
	{
		ListNode node1 = new ListNode( 1 );
		ListNode node2 = new ListNode( 2 );
		ListNode node3 = new ListNode( 3 );
		ListNode node4 = new ListNode( 4 );
		ListNode node5 = new ListNode( 5 );
		ListNode node6 = new ListNode( 6 );
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		printList( reverseSinglyLinkedListRecursively( node1 ) );		
	}
	
	private void printList( ListNode head )
	{
		ListNode currNode = head;
		while ( currNode != null )
		{
			System.out.print( currNode.val + "->");
			currNode = currNode.next;
		}
		System.out.println();
	}
	
    public ListNode reverseSinglyLinkedListRecursively( ListNode head )
    {
    	if ( head == null || head.next == null )
    	{
    		return head;
    	}
    	
    	ListNode reversedListTail = head.next;
    	ListNode reversedListHead = reverseSinglyLinkedListRecursively( head.next );
    	reversedListTail.next = head;
    	head.next = null;
    	
    	return reversedListHead;
    }
    
    public ListNode reverseSinglyLinkedListIteratively( ListNode head )
    {
    	ListNode dummyHead = new ListNode( 0 );
    	ListNode currNode = head;
    	while ( currNode != null )
    	{
    		ListNode oldFirst = dummyHead.next;
    		ListNode nextNode = currNode.next;    		
    		dummyHead.next = currNode;
    		currNode.next = oldFirst;
    		currNode = nextNode;
    	}
    	
    	return dummyHead.next;
    }    
}
