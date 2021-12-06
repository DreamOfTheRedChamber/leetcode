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
  RandomListNode dummyHead = new RandomListNode(0);
  RandomListNode resultTail = dummyHead, newNode;
  RandomListNode currNode = head;
  while ( currNode != null ) 
  {
  	// create node
  	map.putIfAbsent( currNode, new RandomListNode( currNode.label ) );
  	newNode = map.get( currNode );  	

   // assign random pointer
   if ( currNode.random != null ) 
   {
   	map.putIfAbsent( currNode.random, new RandomListNode( currNode.label ) );
   	newNode = map.get( currNode.random );  	
   }
   
   // concatenate
   resultTail.next = newNode;
   resultTail = newNode;
   currNode = currNode.next;
  }

  return dummyHead.next;		
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
