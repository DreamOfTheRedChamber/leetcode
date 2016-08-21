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
    	for ( int[] edge : edges )
    	{
    		graph.putIfAbsent( edge[0], new HashSet<>() );
    		graph.putIfAbsent( edge[1], new HashSet<>() );
    		graph.get( edge[0] ).add( edge[1] );
    		graph.get( edge[1] ).add( edge[0] );
    	}
    	
    	int numComponents = 0;
    	Set<Integer> visited = new HashSet<>();
    	for ( Integer vertex : graph.keySet() )
    	{
    		if ( !visited.contains( vertex ) )
    		{
    			numComponents++;
    			markComponent( graph, visited, vertex );
    		}
    	}
    	
    	return numComponents;
    }
    
    private void markComponent( Map<Integer, Set<Integer>> graph, Set<Integer> visited, Integer startVertex )
    {
    	visited.add( startVertex );
    	for ( Integer vertex : graph.get( startVertex) )
    	{
    		if ( !visited.contains( vertex) )
    		{
    			markComponent( graph, visited, startVertex );
    		}
    	}
    }
}
