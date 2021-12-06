package utility;

public class ListFactory 
{
	public static ListNode createSingleNodeList()
	{
		ListNode node1 = new ListNode( 1 );
		return node1;
	}
	
	public static ListNode createEvenNodeList()
	{
 	ListNode node1 = new ListNode( 1 );
 	ListNode node2 = new ListNode( 2 );
 	ListNode node3 = new ListNode( 3 );
 	ListNode node4 = new ListNode( 4 );
 	node1.next = node2;
 	node2.next = node3;
 	node3.next = node4;
 	return node1;
	}
	
	public static ListNode createOddNodeList()
	{
 	ListNode node1 = new ListNode( 1 );
 	ListNode node2 = new ListNode( 2 );
 	ListNode node3 = new ListNode( 3 );
 	ListNode node4 = new ListNode( 4 );
 	ListNode node5 = new ListNode( 5 );
 	node1.next = node2;
 	node2.next = node3;
 	node3.next = node4;
 	node4.next = node5;
 	return node1;
	}
}
