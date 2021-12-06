package linkedIn;

import utility.TreeNode;

/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: �The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).�

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */

public class LowestCommonAncestorOfBinaryTree
{
	private class ResultWrapper
	{
		public final int numFoundNodes;
		public final TreeNode lcaNode;
		public ResultWrapper( int numFoundNodes, TreeNode lcaNode )
		{
			this.numFoundNodes = numFoundNodes;
			this.lcaNode = lcaNode;
		}
	}
	
    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q )
    {
    	if ( root == null )
    	{
    		return root;
    	}
    	if ( p == null || q == null )
    	{
    		return p == null ? q : p;
    	}
    	
    	ResultWrapper result = lcaRecurse( root, p, q );
    	return result.lcaNode;
    }
    
    private ResultWrapper lcaRecurse( TreeNode root, TreeNode p, TreeNode q )
    {
    	if ( root == null )
    	{
    		return new ResultWrapper( 0, null );
    	}
    	
    	ResultWrapper leftResult = lcaRecurse( root.left, p, q );
    	ResultWrapper rightResult = lcaRecurse( root.right, p, q );
    	
    	if ( leftResult.numFoundNodes == 2 )
    	{
    		return leftResult;
    	}
    	if ( rightResult.numFoundNodes == 2 )
    	{
    		return rightResult;
    	}
    	
    	int numFoundNodes = ( root == p || root == q ) ? 1: 0;
    	numFoundNodes += leftResult.numFoundNodes + rightResult.numFoundNodes;
    	if ( numFoundNodes == 2 )
    	{
    		return new ResultWrapper( 2, root );
    	}
    
    	return new ResultWrapper( numFoundNodes, null );
    }
}
