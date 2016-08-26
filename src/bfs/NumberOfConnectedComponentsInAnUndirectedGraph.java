package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
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
