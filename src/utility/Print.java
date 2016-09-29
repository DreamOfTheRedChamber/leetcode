package utility;

public class Print 
{
	public static void printListNode( ListNode head )
	{
		ListNode currNode = head;
		while ( currNode != null )
		{
			System.out.print( currNode.val + " -> ");
			currNode = currNode.next;
		}
		System.out.println("");
	}	
}