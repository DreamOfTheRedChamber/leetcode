package facebook.medium;

import utility.TreeLinkNode;

/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

public class PopulateNextRightPointersInEachNodeII
{
    public void connect( TreeLinkNode root )
    {
    	TreeLinkNode leftmostNode = root;
    	while ( leftmostNode != null )
    	{
    		TreeLinkNode node = leftmostNode;
    		TreeLinkNode dummy = new TreeLinkNode( 0 );
    		TreeLinkNode prev = dummy;
    		while ( node != null )
    		{
    			if ( node.left != null )
    			{
    				prev.next = node.left;
    				prev = prev.next;
    			}
    			if ( node.right != null )
    			{
    				prev.next = node.right;
    				prev = prev.next;
    			}
    		}
    		leftmostNode = dummy.next;
    	}
    }
}
