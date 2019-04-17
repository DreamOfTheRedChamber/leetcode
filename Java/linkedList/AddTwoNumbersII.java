package linkedList;

import java.util.Stack;

import utility.ListNode;

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 * */

public class AddTwoNumbersII
{
	public ListNode addTwoNumbers( ListNode l1, ListNode l2 )
	{
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		while ( l1 != null )
		{
			s1.push( l1.val );
			l1 = l1.next;
		}
		
		while ( l2 != null )
		{
			s2.push( l2.val );
			l2 = l2.next;
		}
		
		int carryBit = 0;
		ListNode dummyHead = new ListNode( 0 );
		while ( !s1.isEmpty() || !s2.isEmpty() )
		{
			if ( !s1.isEmpty() )
			{
				carryBit += s1.pop();
			}
			if ( !s2.isEmpty() )
			{
				carryBit += s2.pop();
			}
			
			ListNode newNode = new ListNode( carryBit % 10 );			
			ListNode dummyHeadNext = dummyHead.next;
			dummyHead.next = newNode;
			newNode.next = dummyHeadNext;
			
			carryBit = carryBit / 10;
		}
		
		if ( carryBit == 1 )
		{
			ListNode dummyHeadNext = dummyHead.next;
			ListNode newNode = new ListNode( 1 );
			newNode.next = dummyHeadNext;
			dummyHead.next = newNode;			
		}
		
		return dummyHead.next;
		
	}
}
