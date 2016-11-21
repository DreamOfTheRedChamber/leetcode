package facebook.medium;

import java.util.Stack;

import org.junit.Test;

import utility.TreeNode;

/**
 * 第一题 flatten tree to linked list
      a
   b   c
d   e  f      to     d->b->e->a->f->c

 */

public class FlattenTreeToLinkedList
{
	@Test
	public void test()
	{
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		TreeNode node6 = new TreeNode( 6 );
		TreeNode node7 = new TreeNode( 7 );
		TreeNode node8 = new TreeNode( 8 );
		node4.left = node1;
		node1.right = node3;
		node3.left = node2;
		node4.right = node5;
		node5.right = node7;
		node7.left = node6;
		node7.right = node8;
		
		TreeNode result = flattenBST( node4 );
		printList( result );
	}
	
	private void printList( TreeNode head )
	{
		TreeNode currNode = head;
		while ( currNode != null )
		{
			System.out.print( currNode.val + "->" );
			currNode = currNode.right;
		}
	}
	
	public TreeNode flattenBST( TreeNode root )
	{
		if ( root == null )
		{
			return root;
		}
		TreeNode dummyHead = new TreeNode( 0 );
		TreeNode resultTail = dummyHead;
		Stack<TreeNode> stack = new Stack<>();
		pushAllLeft( root, stack );
		while ( !stack.isEmpty() )
		{
			TreeNode top = stack.pop();
			if ( top.right != null )
			{
				pushAllLeft( top.right, stack );
			}
			resultTail.right = top;
			top.left = resultTail;
			resultTail = resultTail.right;
		}
		
		if ( dummyHead.right != null )
		{
			dummyHead.right.left = null;
		}
		return dummyHead.right;
	}
	
	private void pushAllLeft( TreeNode root, Stack<TreeNode> stack )
	{
		TreeNode currNode = root;
		while ( currNode != null )
		{
			stack.push( currNode );
			currNode = currNode.left;
		}
	}
}