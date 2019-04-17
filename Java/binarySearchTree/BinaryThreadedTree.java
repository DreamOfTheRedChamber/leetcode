package binarySearchTree;

import org.junit.Test;

import utility.TreeNode;

public class BinaryThreadedTree 
{
	public void constantSpaceTraverse( TreeNode root )
	{
		TreeNode currNode = root;
		while ( currNode != null )
		{
			if ( currNode.left == null )
			{
				System.out.println( currNode.val );
				currNode = currNode.right;
			}
			else
			{
				TreeNode rightMostChild = findRightMostChild( currNode );
				if ( rightMostChild.right == currNode )
				{
					System.out.println( currNode.val );
					rightMostChild.right = null;
					currNode = currNode.right;
				}
				else
				{
					rightMostChild.right = currNode;
					currNode = currNode.left;
				}
			}
		}
	}
	
	private TreeNode findRightMostChild( TreeNode root )
	{
		TreeNode currNode = root.left;
		while ( currNode.right != null && currNode.right != root )
		{
			currNode = currNode.right;
		}
		return currNode;
	}	
	
	@Test
	public void test()
	{
		TreeNode node1 = new TreeNode( 6 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 7 );
		TreeNode node4 = new TreeNode( 1 );
		TreeNode node5 = new TreeNode( 4 );
		TreeNode node6 = new TreeNode( 9 );
		TreeNode node7 = new TreeNode( 3 );
		TreeNode node8 = new TreeNode( 5 );
		TreeNode node9 = new TreeNode( 8 );
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		node5.left = node7;
		node5.right = node8;
		node6.left = node9;
		
		constantSpaceTraverse( node1 );
	}
}