package dfs;

import utility.TreeNode;

/**
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
 */
public class BinaryTreeUpsideDown
{
    public TreeNode upsideDownBinaryTree( TreeNode root )
    {
    	if ( root == null )
    	{
    		return null;
    	}
    	
    	TreeNode newRoot = root;
    	while( newRoot.left != null )
    	{
    		newRoot = newRoot.left;
    	}
    	
    	upsideDownBinaryTree( root, null );
    	return newRoot;
    }
    
    private void upsideDownBinaryTree( TreeNode root, TreeNode parent )
    {
    	if ( root.left != null )
    	{
    		 upsideDownBinaryTree( root.left, root );
    	}
    	
		root.right = parent;
    	if ( parent != null )
    	{
        	root.left = parent.right;   		
    	}
    	else
    	{
    		root.left = null;
    	}
    }
}