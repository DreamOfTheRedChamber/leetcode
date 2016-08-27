package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utility.UndirectedGraphNode;

/**
 * 
 */

public class CloneGraph 
{

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
		if ( node == null )
		{
			return null;
		}
		return cloneGraphRecurse( node, new HashMap<Integer, UndirectedGraphNode>() );
	}

	private UndirectedGraphNode cloneGraphRecurse( UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> labelToNodeMap )
	{
		UndirectedGraphNode clonedNode = new UndirectedGraphNode( node.label );
		labelToNodeMap.put( node.label, clonedNode );
		for ( UndirectedGraphNode neighbor : node.neighbors )
		{
			if ( !labelToNodeMap.containsKey( neighbor.label ) )
			{
				// if clonedNeighbor does not exist
				UndirectedGraphNode clonedNeighbor = cloneGraphRecurse( neighbor, labelToNodeMap );
				clonedNode.neighbors.add( clonedNeighbor );
			}
			else
			{
				clonedNode.neighbors.add( labelToNodeMap.get( neighbor.label ) );
			}			
		}
		return clonedNode;
	}
}