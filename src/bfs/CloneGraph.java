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
		return cloneGraphRecurse( node, new HashMap<Integer, UndirectedGraphNode>() );
	}

	private UndirectedGraphNode cloneGraphRecurse( UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> labelToVertexMap )
	{
		UndirectedGraphNode clonedNode = new UndirectedGraphNode( node.label );
		labelToVertexMap.put( node.label, clonedNode );
		for ( UndirectedGraphNode neighbor : node.neighbors )
		{
			// if clonedNeighbor exists
			if ( !labelToVertexMap.containsKey( neighbor.label ) )
			{
				UndirectedGraphNode clonedNeighbor = cloneGraphRecurse( neighbor, labelToVertexMap );
				clonedNode.neighbors.add( clonedNeighbor );
			}
			else
			{
				clonedNode.neighbors.add( labelToVertexMap.get( neighbor.label ) );
			}			
		}
		return clonedNode;
	}
}
