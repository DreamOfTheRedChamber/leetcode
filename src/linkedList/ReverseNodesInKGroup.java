package linkedList;

import utility.ListNode;

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
    		// find the next (k+1)th node
    		int nodeCounter = 1;
    		ListNode kthNode = currNode;
    		while ( nodeCounter < k
    				&& kthNode != null )
    		{
    			nodeCounter++;
    			kthNode = kthNode.next;
    		}
    			
    		if ( kthNode != null )
    		{
    			ListNode reversedListTail = currNode.next;
    			ListNode nextNode = kthNode.next;
    			    			
    			for ( int numReversed = 0; numReversed < k; numReversed++, currNode = currNode.next )
    			{
    				tailNode.next = currNode;
    				tailNode = currNode;
    				currNode = currNode.next;
    			}    			        		    			
        		
    			// move to the (k+1) th nodes for the next round
    			currNode = nextNode;
    		}
    		else
    		{
    			break;
    		}    		
    	}
    	tailNode.next = null;
    	return dummyHead.next;
    }
}
