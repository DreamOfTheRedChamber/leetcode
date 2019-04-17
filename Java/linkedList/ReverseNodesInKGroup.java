package linkedList;

import org.junit.Ignore;
import org.junit.Test;

import utility.ListFactory;
import utility.ListNode;
import utility.Print;

/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup
{
	public ListNode reverseKGroup( ListNode head, int k )
	{
		// Start typing your Java solution below
		// DO NOT write main() function
		if ( head == null || k == 1 )
		{
			return head;
		}

		ListNode dummy = new ListNode( 0 );
		dummy.next = head;

		ListNode beforeKGroup = dummy;
		ListNode currNode = head;
		
		for ( int i = 1; currNode != null; i++ )
		{
			if ( i % k == 0 )
			{
				ListNode nextBeforeKGroup = beforeKGroup.next;
				reverse( beforeKGroup, currNode.next );
				beforeKGroup = nextBeforeKGroup;
				currNode = beforeKGroup.next;
			}
			else
			{
				currNode = currNode.next;
			}
		}
		
		return dummy.next;
	}

    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     * after call pre = reverse(pre, next)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param pre 
     * @param next
     */
	public void reverse( ListNode firstNode, ListNode lastNode )
	{
		ListNode dummyHead = new ListNode( 0 );
		ListNode reverseTail = firstNode.next;
		
		ListNode currNode = firstNode.next;
		while ( currNode != lastNode )
		{
			ListNode dummyHeadNext = dummyHead.next;
			ListNode nextNode = currNode.next;
			dummyHead.next = currNode;
			currNode.next = dummyHeadNext;
			currNode = nextNode;
		}
		
		firstNode.next = dummyHead.next;
		reverseTail.next = lastNode;
	}
    
    @Test
    public void test()
    {
    	ListNode head = ListFactory.createSingleNodeList();
    	ListNode result = reverseKGroup( head, 1 );
    	Print.printListNode( result );
    }
    
    @Test
    public void test2()
    {
    	ListNode head = ListFactory.createSingleNodeList();
    	head = reverseKGroup( head, 2 );
    	Print.printListNode( head );
    }
    
    @Test
    public void test3()
    {
    	ListNode head = ListFactory.createOddNodeList();
    	ListNode result = reverseKGroup( head, 2 );
    	Print.printListNode( result );
    }

    @Test
    public void test4()
    {
    	ListNode evenList = ListFactory.createEvenNodeList();
    	ListNode result = reverseKGroup( evenList, 2 );
    	Print.printListNode( result );
    }
}
