package facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

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
    		TreeLinkNode currNode = leftmostNode;
    		TreeLinkNode nextLevelDummyHead = new TreeLinkNode( 0 );
    		TreeLinkNode nextLevelTail = nextLevelDummyHead;
    		
    		while ( currNode != null )
    		{
    			if ( currNode.left != null )
    			{
    				nextLevelTail.next = currNode.left;
    				nextLevelTail = currNode.left;
    			}
    			if ( currNode.right != null )
    			{
    				nextLevelTail.next = currNode.right;
    				nextLevelTail = currNode.right;
    			}
    			currNode = currNode.next;
    		}
    		
    		leftmostNode = nextLevelDummyHead.next;
    	}
    }
    
    public void connectBFS( TreeLinkNode root )
    {
    	if ( root == null )
    	{
    		return;
    	}
    	
    	Queue<TreeLinkNode> bfsQueue = new LinkedList<>();
    	bfsQueue.add( root );
    	while ( !bfsQueue.isEmpty() )
    	{
    		int levelSize = bfsQueue.size();
    		for ( int i = 0; i < levelSize; i++ )
    		{
    			TreeLinkNode head = bfsQueue.poll();
    			head.next = ( i == levelSize - 1 ) ? null : bfsQueue.peek();

    			if ( head.left != null )
    			{
    				bfsQueue.offer( head.left );
    			}
    			if ( head.right != null )
    			{
    				bfsQueue.offer( head.right );
    			}
    		}    		    		
    	}
    }
}
