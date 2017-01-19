package linkedList;

import utility.ListNode;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * */

public class AddTwoNumbers
{
    public ListNode addTwoNumbers( ListNode l1, ListNode l2 ) 
    {
        ListNode resultHead = new ListNode( 0 );
        ListNode resultTail = resultHead;
        int carry = 0;
        
        while ( l1 != null || l2 != null )
        {
        	if ( l1 != null )
        	{
        		carry += l1.val;
        		l1 = l1.next;
        	}
        	if ( l2 != null )
        	{
        		carry += l2.val;
        		l2 = l2.next;
        	}
        	
        	ListNode newNode = new ListNode( carry % 10 );
        	resultTail.next = newNode;        	
        	resultTail = newNode;
        	
        	carry = carry / 10;
        }
        
        if ( carry == 1 )
        {
        	resultTail.next = new ListNode( 1 );
        }
        
        return resultHead.next;
    }
    
    
}
