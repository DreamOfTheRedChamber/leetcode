package facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format

The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:

How many MHTs can a graph have at most?

Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf. 
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
		List<Integer> leaves = null;
    	while ( graph.size() != 0 )
    	{
    		// collect leaves
    		leaves = new ArrayList<>();
    		for ( Map.Entry<Integer, Set<Integer>> entry : graph.entrySet() )
    		{
    			int node = entry.getKey();
    			Set<Integer> neighbors = entry.getValue();
    			if ( neighbors.size() == 1 )
    			{
    				leaves.add( node );
    			}
    		}
    		
    		// remove vertex and edges
    		for ( Integer leaf : leaves )
    		{
    			Set<Integer> neighbors = graph.remove( leaf );
    			for ( Integer neighbor : neighbors )
    			{
    				graph.get( neighbor ).remove( leaf );
    			}
    		}
    	}
    	
    	return leaves;  	
    }

}
