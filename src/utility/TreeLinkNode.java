package utility;

public class TreeLinkNode 
{
	public int val;
	public TreeLinkNode left;
	public TreeLinkNode right;
	public TreeLinkNode next;

	public TreeLinkNode( int val )
	{
		this.val = val;
	}
	
	public TreeLinkNode(TreeLinkNode left, TreeLinkNode right, TreeLinkNode next) {
		super();
		this.left = left;
		this.right = right;
		this.next = next;
	}
}
