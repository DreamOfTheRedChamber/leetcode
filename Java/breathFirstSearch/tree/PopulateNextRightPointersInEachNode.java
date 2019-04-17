package breathFirstSearch.tree;

import utility.TreeLinkNode;

/**
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
Show Company Tags
Show Tags
Show Similar Problems

 */

public class PopulateNextRightPointersInEachNode
{

    public void connect( TreeLinkNode root )
    {
        if ( root == null )
        {
        	return;
        }
        
        // connect nodes at upper layer
        if ( root.left != null )
        {
        	root.left.next = root.right;
        	if ( root.right != null )
        	{
        		if ( root.next == null )
        		{
        			root.right.next = null;
        		}
        		else
        		{
        			root.right.next = root.next.left;
        		}
        	}
        }
        
        // recurse
        connect( root.left );
        connect( root.right );
    }

}
