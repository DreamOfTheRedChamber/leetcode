package hashtable;

import java.util.HashMap;
import java.util.Map;

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
	public RandomListNode copyRandomListHashMap( RandomListNode head )
	{
        if ( head == null ) 
        {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;
        while ( head != null ) 
        {
            if ( map.containsKey( head ) ) 
            {
                newNode = map.get( head );
            } 
            else 
            {
                newNode = new RandomListNode( head.label );
                map.put( head, newNode );
            }
            pre.next = newNode;

            if ( head.random != null ) 
            {
                if ( map.containsKey( head.random ) ) 
                {
                    newNode.random = map.get( head.random );
                } 
                else 
                {
                    newNode.random = new RandomListNode( head.random.label );
                    map.put( head.random, newNode.random );
                }
            }

            pre = newNode;
            head = head.next;
        }

        return dummy.next;		
	}
	
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
