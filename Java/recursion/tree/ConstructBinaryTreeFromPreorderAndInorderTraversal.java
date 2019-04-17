package recursion.tree;

import utility.TreeNode;

/**
 * 
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{

    public TreeNode buildTree( int[] preorder, int[] inorder )
    {
        return buildTreeRecurse( preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1 );
    }

    private TreeNode buildTreeRecurse( int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart, int inorderEnd )
    {
    	// trunning
    	if ( preorderStart > preorderEnd )
    	{
    		return null;
    	}
    	
    	// build root
    	TreeNode root = new TreeNode( preorder[preorderStart] );
    	
    	// find root index inside inorder
    	int rootInorderIndex = inorderStart;
    	for ( int i = inorderStart; i <= inorderEnd; i++ )
    	{
    		if ( inorder[i] == preorder[preorderStart] )
    		{
    			rootInorderIndex = i;
    			break;
    		}
    	}
    	
    	// build child
    	int leftSubtreeSize = rootInorderIndex - inorderStart;
    	TreeNode leftChild = buildTreeRecurse( preorder, inorder, preorderStart + 1, preorderStart + leftSubtreeSize, inorderStart, inorderStart + leftSubtreeSize - 1 );
    	root.left = leftChild;
    	int rightSubtreeSize = inorderEnd - rootInorderIndex;
    	TreeNode rightChild = buildTreeRecurse( preorder, inorder, preorderEnd - rightSubtreeSize + 1, preorderEnd, inorderEnd - rightSubtreeSize + 1, inorderEnd );
    	root.right = rightChild;
    	return root;
    }
}
