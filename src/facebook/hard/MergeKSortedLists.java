package facebook.hard;

import java.util.PriorityQueue;

import utility.ListNode;

public class MergeKSortedLists 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
    	if ( lists.length == 0 )
    	{
    		return null;
    	}

    	PriorityQueue<ListNode> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1.val - o2.val ) );
    	for ( ListNode listHead : lists )
    	{
    		if ( listHead != null )
    		{
    			minQueue.offer( listHead );
    		}
    	}
    	
    	ListNode resultHead = new ListNode( 0 );    	
    	ListNode resultTail = resultHead;
    	while ( !minQueue.isEmpty( ) )
    	{
    		ListNode qHead = minQueue.remove( );
    		if ( qHead.next != null )
    		{
    			minQueue.add( qHead.next );
    		}
    		resultTail.next = qHead;
    		resultTail = qHead;
    	}
    	
    	return resultHead.next;
    }
}
