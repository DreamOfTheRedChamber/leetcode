package utility;

public class TreeFactory 
{
	public static TreeNode createFullTree()
	{		
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		TreeNode node6 = new TreeNode( 6 );
		TreeNode node7 = new TreeNode( 7 );
		TreeNode node8 = new TreeNode( 8 );
		TreeNode node9 = new TreeNode( 9 );
		TreeNode node10 = new TreeNode( 10 );
		TreeNode node11 = new TreeNode( 11 );
		TreeNode node12 = new TreeNode( 12 );
		TreeNode node13 = new TreeNode( 13 );
		TreeNode node14 = new TreeNode( 14 );

		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		node4.left = node9;
		node4.right = node10;
		node5.left = node11;
		node5.right = node12;
		node6.left = node13;
		node6.right = node14;
		
		return node0;
	}

	public static TreeNode createCompleteTree()
	{		
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		TreeNode node6 = new TreeNode( 6 );
		TreeNode node7 = new TreeNode( 7 );
		TreeNode node8 = new TreeNode( 8 );
		TreeNode node9 = new TreeNode( 9 );
		TreeNode node10 = new TreeNode( 10 );

		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		node4.left = node9;
		node4.right = node10;
		
		return node0;
	}

	
	public static TreeNode createNormalTree()
	{
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		TreeNode node6 = new TreeNode( 6 );
		TreeNode node7 = new TreeNode( 7 );
		TreeNode node8 = new TreeNode( 8 );

		node0.left = node1;
		node0.right = node2;
		node1.right = node3;
		node3.left = node6;
		node2.left = node4;
		node2.right = node5;
		node4.right = node7;
		node5.right = node8;
		
		return node0;
	}
	
	public static TreeNode createFlattenedTree()
	{
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		TreeNode node6 = new TreeNode( 6 );
		TreeNode node7 = new TreeNode( 7 );
		TreeNode node8 = new TreeNode( 8 );
		
		node0.left = node1;
		node1.left = node2;
		node2.left = node3;
		node3.left = node4;
		node4.left = node5;
		node5.left = node6;
		node6.left = node7;
		node7.left = node8;
		
		return node0;
	}
}