package utility;

public class TreeFactory 
{
	public static TreeNode createTwoNodesTree()
	{
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		node0.left = node1;
		return node0;
	}
	
	public static TreeNode createCompleteTree()
	{		
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );

		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		return node0;
	}
	
	public static TreeNode createFlattenedTree()
	{
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		
		node0.left = node1;
		node1.left = node2;
		node2.left = node3;
		node3.left = node4;
		
		return node0;
	}

	public static TreeNode createArbitraryTree()
	{
		TreeNode node0 = new TreeNode( 0 );
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );

		node0.left = node1;
		node0.right = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		return node0;
	}
	
}