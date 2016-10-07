package depthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:
     0          3
     |          |
     1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
     0           4
     |           |
     1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 */

public class NumberOfConnectedComponentsInAnUndirectedGraph
{
    public int countComponents(int n, int[][] edges) 
    {
    	if ( edges.length == 0 )
    	{
    		return n;
    	}
    	
    	// build graph
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	for ( int i = 0; i < n; i++ )
    	{
    		graph.put( i, new HashSet<>() );
    	}    	
    	for ( int[] edge : edges )
    	{
    		graph.get( edge[0] ).add( edge[1] );
    		graph.get( edge[1] ).add( edge[0] );
    	}
    	
    	int numComponents = 0;
    	Set<Integer> visited = new HashSet<>();
    	for ( Integer node : graph.keySet() )
    	{
    		if ( !visited.contains( node ) )
    		{
    			numComponents++;
    			markComponent( graph, visited, node );
    		}
    	}
    	
    	return numComponents;
    }
    
    private void markComponent( Map<Integer, Set<Integer>> graph, Set<Integer> visited, Integer startNode )
    {
    	visited.add( startNode );
    	for ( Integer neighborNode : graph.get( startNode ) )
    	{
    		if ( !visited.contains( neighborNode ) )
    		{
    			markComponent( graph, visited, neighborNode );
    		}
    	}
    }
}
