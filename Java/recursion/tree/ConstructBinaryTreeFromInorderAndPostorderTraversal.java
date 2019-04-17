package recursion.tree;

import utility.TreeNode;

/**
 * 
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal
{
    public TreeNode buildTree( int[] inorder, int[] postorder )
    {
    	return buildTreeRecurse( inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1 );
    }
    
    private TreeNode buildTreeRecurse( int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd )
    {
    	// trunning
    	if ( inorderStart > inorderEnd )
    	{
    		return null;
    	}
    	
    	TreeNode root = new TreeNode( postorder[postorderEnd] );
    	
    	// find root inside inOrder sequence
    	int rootInorderIndex = inorderStart;
    	for ( int i = inorderStart; i <= inorderEnd; i++ )
    	{
    		if ( inorder[i] == postorder[postorderEnd] )
    		{
    			rootInorderIndex = i;
    			break;
    		}
    	}
    	
    	// build subtree
    	int leftSubtreeSize = rootInorderIndex - inorderStart;
    	TreeNode leftChild = buildTreeRecurse( inorder, postorder, inorderStart, inorderStart + leftSubtreeSize - 1, postorderStart, postorderStart + leftSubtreeSize - 1 );
    	root.left = leftChild;
    	int rightSubtreeSize = inorderEnd - rootInorderIndex;    	
    	TreeNode rightChild = buildTreeRecurse( inorder, postorder, inorderEnd - rightSubtreeSize + 1, inorderEnd, postorderEnd - rightSubtreeSize, postorderEnd - 1 );
    	root.right = rightChild;
    	return root;
    }
}