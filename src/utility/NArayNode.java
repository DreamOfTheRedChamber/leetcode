package utility;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 */


public class NArayNode
{
	public int value;
	public List<NArayNode> children;
	public NArayNode( int value )
	{
		this.value = value;
		children = new LinkedList<>();
	}
	public void addChild( NArayNode node )
	{
		children.add( node );
	}
}
