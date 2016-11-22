package facebook.medium;

import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Node;

import utility.TreeNode;

/**
 * 顺时针的print binary tree boundary, 就是从根开始，先打右边界，再打叶子，最后打左边界。
 */

public class PrintTreeBoundary
{
	public void printBoundary( TreeNode root )
	{
		if ( root == null )
		{
			return;
		}
		System.out.println( root.val );
		printRightBoundary( root.right );				

		printLeaves( root.right );
		printLeaves( root.left );
		
		printLeftBoundary( root.left );		
	}

	private void printLeaves( TreeNode root )
	{
		if ( root == null )
		{
			return;
		}

		printLeaves( root.right );
		if ( root.left == null && root.right == null )
		{
			System.out.println( root.val );
		}
		printLeaves( root.left );

	}
	
	private void printRightBoundary( TreeNode root )
	{
		if ( root == null )
		{
			return;
		}

		if ( root.right != null )
		{
			System.out.println( root.val );
			printRightBoundary( root.right );
		}
		else if ( root.left != null )
		{
			System.out.println( root.val );		
			printRightBoundary( root.left );
		}
	}
	
	private void printLeftBoundary( TreeNode root )
	{
		if ( root == null )
		{
			return;
		}

		if ( root.left != null )
		{
			printLeftBoundary( root.left );
			System.out.println( root.val );		
		}
		else if ( root.right != null )
		{
			printLeftBoundary( root.right );
			System.out.println( root.val );		
		}
	}
	
	@Ignore
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
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node5.left = node7;
		printBoundary( node1 );
	}
	
	@Test
	public void test2()
	{
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		TreeNode node7 = new TreeNode( 7 );
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node5.left = node7;
		printBoundary( node1 );		
	}
}
