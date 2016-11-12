package facebook.easy;

import utility.ListNode;

/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space? 
 * */

public class PalindromeLinkedList 
{
    public boolean isPalindrome( ListNode head )
    {
    	if ( head == null )
    	{
    		return true;
    	}
    	
    	ListNode middle = findMiddle( head );
    	ListNode secondHalf = reverse( middle.next );
    	ListNode p1 = head, p2 = secondHalf;
    	while ( p1 != null && p2 != null && p1.val == p2.val )
    	{
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	return p2 == null;
    }
    
    private ListNode findMiddle( ListNode head )
    {
    	if ( head == null )
    	{
    		return null;
    	}
    	ListNode slow = head, fast = head.next;
    	while ( fast != null && fast.next != null )
    	{
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    
    private ListNode reverse( ListNode head )
    {
    	ListNode prev = null;
    	while ( head != null )
    	{
    		ListNode temp = head.next;
    		head.next = prev;
    		prev = head;
    		head = temp;
    	}
    	return prev;
    }
}