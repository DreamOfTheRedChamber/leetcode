package facebook.medium;

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
		if ( root != null )
		{
			return;
		}
		System.out.println( root.val );
				
		printLeftBoundary( root.left );

		printLeaves( root.left );
		printLeaves( root.right );
		
		printRightBoundary( root.right );		
	}

	private void printLeaves( TreeNode root )
	{
		if ( root == null )
		{
			return;
		}
		
		printLeaves( root.left );
		if ( root.left == null && root.right == null )
		{
			System.out.println( root.val );
		}
		printLeaves( root.right );
	}
	
	private void printRightBoundary( TreeNode root )
	{
		if ( root == null )
		{
			return;
		}

		if ( root.right != null )
		{
			printRightBoundary( root.right );
			System.out.println( root.val );		
		}
		else if ( root.left != null )
		{
			printRightBoundary( root.left );
			System.out.println( root.val );		
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
			System.out.println( root.val );		
			printLeftBoundary( root.left );
		}
		else if ( root.right != null )
		{
			System.out.println( root.val );		
			printLeftBoundary( root.right );
		}
	}
	
	@Test
	public void test()
	{
		
	}
}
