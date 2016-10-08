package topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

public class CourseSchedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
    	if ( numCourses < 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	// other assertions on prerequisites
    	
    	// build graph
    	Map<Integer, Set<Integer>> graph = new HashMap<>();
    	for ( int i = 0; i < numCourses; i++ )
    	{
    		graph.put( i, new HashSet<>() );
    	}
    	for ( int[] edge : prerequisites )
    	{
    		graph.get( edge[1] ).add( edge[0] );
    	}
    	
    	// topoSort with dfs for detecting cycles
    	Set<Integer> discovered = new HashSet<>();
    	Set<Integer> visited = new HashSet<>();
    	for ( Integer vertex : graph.keySet() )
    	{
    		if ( !visited.contains( vertex ) )
    		{
    			if ( topoSort( graph, vertex, discovered, visited ) )
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * @return whether a cycle is detected
     */
    private boolean topoSort ( Map<Integer, Set<Integer>> graph, Integer startNode, Set<Integer> discovered, Set<Integer> visited )
    {
    	discovered.add( startNode );
    	for ( Integer neighbor : graph.get( startNode ) )
    	{
    		if ( !discovered.contains( neighbor ) )
    		{
    			if ( topoSort( graph, neighbor, discovered, visited ) )
    			{
    				return true;
    			}
    		}
    		else if ( discovered.contains( neighbor ) 
    				&& !visited.contains( neighbor ) )
    		{
    			return true;
    		}
    		else
    		{
    			// already visited, do nothing
    			;
    		}
    	}
    	visited.add( startNode );
    	return false;
    }
}
