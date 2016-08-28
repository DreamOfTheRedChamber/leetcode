package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreeInorderTraversal
{

    public List<Integer> inorderTraversal( TreeNode root )
    {
    	List<Integer> inorderSeqs = new ArrayList<>();
    	Stack<TreeNode> inorderStack = new Stack<>();
    	pushAllNodesOnLeftPath( root, inorderStack );
    	while ( !inorderStack.isEmpty( ) )
    	{
    		TreeNode top = inorderStack.pop( );
    		inorderSeqs.add( top.val );
    		if ( top.right != null )
    		{
    			pushAllNodesOnLeftPath( top.right, inorderStack );
    		}
    	}
    	return inorderSeqs;
    }

    private void pushAllNodesOnLeftPath( TreeNode root, Stack<TreeNode> inorderStack )
    {
    	TreeNode currNode = root;
    	while ( currNode != null )
    	{
    		inorderStack.push( currNode );
    		currNode = currNode.left;
    	}
    }
    
    @Test
    public void test()
    {
    	TreeNode node1 = new TreeNode( 3 );
    	TreeNode node2 = new TreeNode( 1 );
    	TreeNode node3 = new TreeNode( 2 );
    	node1.left = node2;
    	node2.right = node3;
    	System.out.println( inorderTraversal( node1 ) );
    }
}