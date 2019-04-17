package facebook.easy;

import utility.TreeNode;

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * */

public class LowestCommonAncestorInBinarySearchTree 
{
    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q )
    {
    	if ( root == null )
    	{
    		return root;
    	}
    	if ( p == null || q == null || p == q )
    	{
    		return p == null ? q : p;
    	}
    	    	
    	if ( p.val < q.val )
    	{
    		return lowestCommonAncestor( root, q, p );
    	}
    	
    	TreeNode currNode = root;
    	while ( currNode != null )
    	{
    		if ( ( currNode.val < p.val && currNode.val > q.val ) || currNode.val == p.val || currNode.val == q.val )
    		{
    			return currNode;
    		}
    		else if ( currNode.val > p.val )
    		{
    			currNode = currNode.left;
    		}
    		else
    		{
    			currNode = currNode.right;
    		}
    	}
    	return currNode;
    }
}