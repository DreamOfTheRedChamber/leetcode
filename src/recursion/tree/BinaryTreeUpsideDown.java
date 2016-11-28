package recursion.tree;

import utility.TreeNode;

/**
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

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
	public TreeNode upsideDownBinaryTreeIterative( TreeNode root )
	{
		TreeNode currNode = root, parent = null, parentRight = null;
		while ( currNode != null )
		{
			TreeNode nextNode = currNode.left;

			currNode.left = parentRight;
			currNode.right = parent;
			
			// save parent and parentRight pointers
			parentRight = currNode.right;
			parent = currNode;
			
			// move to next level
			currNode = nextNode;
		}
		return parent;
	}

	public TreeNode upsideDownBinaryTreeRecurse( TreeNode root )
	{
		if ( root == null || root.left == null )
		{
			return root;
		}
		
		TreeNode newRoot = upsideDownBinaryTree( root.left );
		root.left.left = root.right;
		root.left.right = root;
		
		root.left = null;
		root.right = null;
		
		return newRoot;
	}
	
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