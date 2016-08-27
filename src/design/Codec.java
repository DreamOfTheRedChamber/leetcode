package design;

import org.junit.Test;

import utility.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class Codec
{

	/**
	 * Encodes a tree to a single string.
	 * 
	 * @return ',' to separate nodes, '#' for null, actual int for other node
	 */
	public String serialize( TreeNode root )
	{
		StringBuilder result = new StringBuilder();
		serializeRecurse( root, result );
		return result.toString();
	}

	private void serializeRecurse( TreeNode root, StringBuilder result )
	{
		// preorder serialize
		if ( root == null )
		{
			result.append( "#" );
			result.append( "," );
		}
		else
		{
			result.append( root.val );
			result.append( "," );
			serializeRecurse( root.left, result );
			serializeRecurse( root.right, result );
		}
	}
		
	/**
	 * Decodes your encoded data to tree.
	 * 
	 * @return deserialized tree root node
	 */
	public TreeNode deserialize( String data )
	{
		return deserializeRecurse( new int[]{ 0 }, data.split( "," ) );
	}

	/**
	 * @param pos  pointer position inside nodes
	 */
	private TreeNode deserializeRecurse( int[] pos, String[] nodes )
	{
		if ( nodes[pos[0]].equals( "#" ) )
		{
			pos[0] = pos[0] + 1;
			return null;
		}
		else
		{
			TreeNode root = new TreeNode( Integer.parseInt( nodes[pos[0]] ) );
			pos[0] = pos[0] + 1;
			root.left = deserializeRecurse( pos, nodes );
			root.right = deserializeRecurse( pos, nodes );
			return root;
		}
	}
	
	@Test
	public void test()
	{
		Codec codec = new Codec();
		TreeNode node1 = new TreeNode( 1 );
		TreeNode node2 = new TreeNode( 2 );
		TreeNode node3 = new TreeNode( 3 );
		TreeNode node4 = new TreeNode( 4 );
		TreeNode node5 = new TreeNode( 5 );
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		TreeNode result = deserialize( serialize( node1 ) );
		System.out.println( result.val );
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));