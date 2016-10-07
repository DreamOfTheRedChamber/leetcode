package hashtable;

import org.junit.Test;

// Definition for singly-linked list with a random pointer.
 class RandomListNode 
 {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
 
public class CopyListWithRandomPointer
{
    public RandomListNode copyRandomList( RandomListNode head )
    {
    	if ( head == null )
    	{
    		return null;
    	}
    	
    	// create and link next node
    	RandomListNode currNode = head;
    	while ( currNode != null )
    	{
    		RandomListNode nextNode = currNode.next;
    		
    		RandomListNode copiedNode = new RandomListNode( currNode.label );
    		currNode.next = copiedNode;
    		copiedNode.next = nextNode;
    		
    		currNode = nextNode;
    	}
    	
    	// assign random pointer
    	currNode = head;
    	while ( currNode != null )
    	{
    		RandomListNode nextNode = currNode.next.next;
    		
    		currNode.next.random = currNode.random == null ? null : currNode.random.next;
    		
    		currNode = nextNode;
    	}
    	
    	// assign next pointer
    	RandomListNode copiedHead = head.next;
    	currNode = head;
    	RandomListNode currCopiedNode = copiedHead;
    	while ( currNode != null )
    	{
    		RandomListNode nextNode = currCopiedNode.next;
    		RandomListNode nextCopiedNode = nextNode == null ? null : nextNode.next;
    		
    		currNode.next = nextNode;
    		currCopiedNode.next = nextCopiedNode;
    		
    		currNode = nextNode;
    		currCopiedNode = nextCopiedNode;
    	}
    	
    	return copiedHead;
    }
    
    @Test
    public void test()
    {
    	RandomListNode node = new RandomListNode( 1 );
    	RandomListNode copiedNode = copyRandomList( node );    	
    }
}
