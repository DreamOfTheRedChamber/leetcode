package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 */

public class MinimumHeightTrees
{

    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
    	// build graph
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	for ( int[] edge : edges )
    	{
    		graph.putIfAbsent( edge[0], new HashSet<>() );
    		graph.putIfAbsent( edge[1], new HashSet<>() );
    		
    		graph.get( edge[0] ).add( edge[1] );
    		graph.get( edge[1] ).add( edge[0] );
    	}
    	
    	// remove leaves of the tree until 0~1 nodes, add to result
    	while ( graph.size() > 1 )
    	{
    		List<Integer> leaves = new ArrayList<>();
    		for ( Map.Entry<Integer, Set<Integer>> entry : graph.entrySet() )
    		{
    			int node = entry.getKey();
    			Set<Integer> neighbors = entry.getValue();
    			if ( neighbors.size() == 1 )
    			{
    				leaves.add( node );
    			}
    		}
    		
    		for ( Integer leaf : leaves )
    		{
    			graph.remove( leaf );
    		}
    	}
    	
    	return graph.keySet().stream().collect( Collectors.toList() );    	
    }

}
