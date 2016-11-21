package facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
Given a linked list, in addition to the next pointer, each node has a child pointer that can point to a separate list. 
With the head node, flatten the list to a single-level linked list.

For instance, the above linked list should be flattened to 1→2->3→4->5->6->7->8->9. 
The idea is to flatten the linked list by level. Note: this question was asked by Facebook a month ago.

http://blog.gainlo.co/index.php/2016/06/12/flatten-a-linked-list/
 * */

public class FlattenALinkedList
{	
	class SpecialNode
	{
		public int val;
		public SpecialNode child;
		public SpecialNode next;		
		public SpecialNode( int val )
		{
			this.val = val;
		}
	}
	
	@Test
	public void test()
	{
		SpecialNode node1 = new SpecialNode( 1 );
		SpecialNode node2 = new SpecialNode( 2 );
		SpecialNode node3 = new SpecialNode( 3 );
		SpecialNode node4 = new SpecialNode( 4 );
		SpecialNode node5 = new SpecialNode( 5 );
		SpecialNode node6 = new SpecialNode( 6 );
		SpecialNode node7 = new SpecialNode( 7 );
		SpecialNode node8 = new SpecialNode( 8 );
		SpecialNode node9 = new SpecialNode( 9 );
		node1.next = node2;
		node2.child = node5;
		node2.next = node3;
		node5.child = node8;
		node5.next = node6;
		node3.next = node4;
		node4.child = node7;
		node7.child = node9;
		printList( flattenALinkedList( node1 ) );
	}

	private void printList( SpecialNode head )
	{
		SpecialNode currNode = head;
		while ( currNode != null )
		{
			System.out.println( currNode.val + "->" );	
			currNode = currNode.next;
		}
	}
	
	public SpecialNode flattenALinkedList( SpecialNode root )
	{
		if ( root == null )
		{
			return root;
		}
		SpecialNode dummyHead = new SpecialNode( 0 );
		SpecialNode resultTail = dummyHead;
		Queue<SpecialNode> currLevel = new LinkedList<>();
		Queue<SpecialNode> nextLevel = new LinkedList<>();
		currLevel.add( root );
		while ( !currLevel.isEmpty() )
		{
			SpecialNode head = currLevel.poll();
			resultTail.next = head;
			resultTail = head;
			
			if ( head.next != null )
			{
				currLevel.offer( head.next );
			}
			if ( head.child != null )
			{
				nextLevel.offer( head.child );
				head.child = null;
			}
			
			if ( currLevel.size() == 0 )
			{
				currLevel.addAll( nextLevel );
				nextLevel = new LinkedList<>();
			}
		}
		
		return dummyHead.next;
	}
}
