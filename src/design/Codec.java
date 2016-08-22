package design;

import org.junit.Test;

import utility.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class NodeAndPosWrapper
{
	public final TreeNode node;
	public final int nextPos;
	public NodeAndPosWrapper( TreeNode node, int nextPos )
	{
		this.node = node;
		this.nextPos = nextPos;
	}
}

public class Codec
{

	// Encodes a tree to a single string.
	public String serialize( TreeNode root )
	{
		StringBuilder result = new StringBuilder();
		serializeRecurse( root, result );
		return result.toString();
	}

	private void serializeRecurse( TreeNode root, StringBuilder result )
	{
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
		
	// Decodes your encoded data to tree.
	public TreeNode deserialize( String data )
	{
		NodeAndPosWrapper result = deserializeRecurse( data, 0 );
		return result.node;
	}
	
	private NodeAndPosWrapper deserializeRecurse( String data, int pos )
	{
		if ( pos > data.length() - 1 )
		{
			return new NodeAndPosWrapper( null, pos );
		}
		
		// parse for root value
		if ( data.charAt( pos ) == '#' )
		{
			return new NodeAndPosWrapper( null, pos + 2 );
		}
		else
		{
			int rootValue = 0;
			boolean isNeg = false;
			while ( pos < data.length()
					&& data.charAt( pos ) != ',' )
			{
				if ( data.charAt( pos ) == '-' )
				{
					isNeg = true;
					pos++;
					continue;
				}
				else
				{
					rootValue = (int)( data.charAt( pos ) - '0' ) + rootValue * 10;
					pos++;
				}
			}
			if ( isNeg )
			{
				rootValue = -rootValue;
			}
			
			TreeNode root = new TreeNode( rootValue );
			
			NodeAndPosWrapper leftChildResult = deserializeRecurse( data,  pos + 1 );
			NodeAndPosWrapper rightChildResult = deserializeRecurse( data, leftChildResult.nextPos );
			root.left = leftChildResult.node;
			root.right = rightChildResult.node;
			return new NodeAndPosWrapper( root, rightChildResult.nextPos );
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
		
		String serializedResult = codec.serialize( node1 );
		System.out.println( serializedResult );
		TreeNode root = codec.deserialize( serializedResult );
		System.out.println( root.val );
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));