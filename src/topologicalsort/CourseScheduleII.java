package topologicalsort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 
 */

public class CourseScheduleII
{

	@Test
	public void test()
	{
		System.out.println( Arrays.toString( findOrder(2, new int[][]{ {1, 0}, {0, 1} } ) ) );
	}
	
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
    	if ( numCourses < 0)
    	{
    		throw new IllegalArgumentException("");
    	}
    	// other assertions for prere...
    	
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
    	
    	// topo sort with dfs
    	Set<Integer> discovered = new HashSet<>(); // discovered in dfs
    	Set<Integer> visited = new LinkedHashSet<>(); // visited in dfs
    	for ( Integer vertex : graph.keySet() )
    	{
    		if ( !discovered.contains( vertex ) 
    				&& hasCycle( graph, vertex, discovered, visited ) )
	    		{
	    			return new int[]{};
	    		}
    	}
    	
    	// build result
    	int[] result = new int[visited.size()];
    	int pos = result.length - 1;
    	for ( Integer vertex : visited )
    	{
    		result[pos] = vertex;
    		pos--;
    	}
    	return result;
    }

    private boolean hasCycle( Map<Integer, Set<Integer>> graph, Integer startNode, Set<Integer> discovered, Set<Integer> visited )
    {
    	discovered.add( startNode );
    	
    	for ( Integer neighborNode : graph.get( startNode ) )
    	{
    		if ( !discovered.contains( neighborNode ) 
    				&& hasCycle( graph, neighborNode, discovered, visited ) )
    		{
    				return true;
    		}
    		else if ( discovered.contains( neighborNode )
    				&& !visited.contains( neighborNode ) )
    		{
    			return true;
    		}
    	}
    	
    	visited.add( startNode );
    	return true;
    }
}
