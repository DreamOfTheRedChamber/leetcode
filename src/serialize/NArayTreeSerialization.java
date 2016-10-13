package serialize;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import utility.NArayNode;

/**
 * 
 */

public class NArayTreeSerialization
{
	@Test
	public void test()
	{
		NArayNode node1 = new NArayNode( 1 );
		NArayNode node2 = new NArayNode( 2 );
		NArayNode node3 = new NArayNode( 3 );
		NArayNode node4 = new NArayNode( 4 );
		NArayNode node5 = new NArayNode( 5 );
		NArayNode node6 = new NArayNode( 6 );
		NArayNode node7 = new NArayNode( 7 );
		node1.addChild( node2 );
		node1.addChild( node3 );
		node2.addChild( node4 );
		node2.addChild( node5 );
		node2.addChild( node6 );
		node6.addChild( node7 );
		
		String serialized =  serialize( node1 );
		NArayNode root = deserialize( serialized );
		System.out.println( serialized );
	}
	
	public String serialize( NArayNode root )
	{
		if ( root == null )
		{
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		Queue<NArayNode> bfsQueue = new LinkedList<>();
		result.append( root.value );
		result.append( ',' );
		bfsQueue.offer( root );
		while ( !bfsQueue.isEmpty( ) )
		{
			NArayNode qHead = bfsQueue.poll( );
			for ( NArayNode childNode : qHead.children )
			{			
				result.append( childNode.value );
				result.append( ',' );
				bfsQueue.offer( childNode );
			}
			result.append( ')' );
			result.append( ',' );
		}
		return result.toString( );
	}
	
	public NArayNode deserialize( String input )
	{
		if ( input == null )
		{
			return null;
		}
		
		String[] tokens = input.split( "," );		
		Queue<NArayNode> bfsQueue = new LinkedList<>();
		NArayNode root = new NArayNode( Integer.parseInt( tokens[0] ) );
		bfsQueue.offer( root );
		
		int index = 1;
		while ( !bfsQueue.isEmpty( ) )			
		{
			NArayNode qHead = bfsQueue.poll( );
			while ( index < tokens.length && !tokens[index].equals( ")" ) )
			{
				NArayNode newNode = new NArayNode( Integer.parseInt( tokens[index] ) );
				qHead.addChild( newNode );
				bfsQueue.offer( newNode );
				index++;
			}
			index++;
		}
		
		return root;
	}
}
