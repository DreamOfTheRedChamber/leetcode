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
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
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
    		if ( !discovered.contains( neighborNode ) )
    		{
    			if ( hasCycle( graph, neighborNode, discovered, visited ) )
    			{
    				return true;
    			}
    		}
    		else if ( discovered.contains( neighborNode )
    				&& !visited.contains( neighborNode ) )
    		{
    			return true;
    		}
    	}
    	
    	visited.add( startNode );
    	return false;
    }
}
