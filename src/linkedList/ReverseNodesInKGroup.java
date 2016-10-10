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
    	ListNode dummyHead = new ListNode( 0 );
    	dummyHead.next = head;
    	ListNode tailNode = dummyHead;
    	
    	ListNode currNode = head;
    	while ( currNode != null )
    	{
    		// find the next k th node
    		int nodeCounter = 1;
    		ListNode kthNode = currNode;
    		while ( nodeCounter < k
    				&& kthNode != null )
    		{
    			nodeCounter++;
    			kthNode = kthNode.next;
    		}    			
    		if ( kthNode == null )
    		{
    			break;
    		}
    		
    		// reverse the next k nodes
    		ListNode beforeThisRoundStart = tailNode;
    		ListNode nextRoundStart = kthNode.next;		
    		ListNode reversedListTail = currNode;
    		ListNode reversedListHead = reverseKNodes( currNode, k );
    		
    		// concatenate list
    		beforeThisRoundStart.next = reversedListHead;
    		reversedListTail.next = nextRoundStart;
    		
    		// move to next round
    		tailNode = reversedListTail;
    		currNode = nextRoundStart;
    	}
    	
    	return dummyHead.next;
    }
    
    private ListNode reverseKNodes( ListNode head, int k )
    {
    	ListNode dummyHead = new ListNode( 0 );
    	ListNode currNode = head;
    	int count = 0;
    	while ( currNode != null 
    			&& count < k )
    	{
    		// prepare for next round loop
    		ListNode dummyHeadNextBuffer = dummyHead.next;
    		ListNode currNodeNextBuffer = currNode.next;
    		
    		// ... do job in  this round loop
    		dummyHead.next = currNode;
    		currNode.next = dummyHeadNextBuffer;
    		
    		// move to next round loop
    		currNode = currNodeNextBuffer;
    		count++;
    	}
    	return dummyHead.next;
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
