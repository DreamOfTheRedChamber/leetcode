package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 */

public class ReconstructItinerary
{
    public List<String> findItinerary( String[][] tickets )
    {    	
    	// build graph
    	Map<String, List<String>> graph = new HashMap<>();
    	for ( String[] ticket : tickets )
    	{
    		graph.putIfAbsent( ticket[0], new ArrayList<>() );
    		graph.putIfAbsent( ticket[1], new ArrayList<>() );
    		graph.get( ticket[0] ).add( ticket[1] );
    	}
    	for ( List<String> outEdges : graph.values() )
    	{
    		Collections.sort( outEdges );
    	}
    	
    	String startNode = "JFK";
    	List<String> itinerary = new LinkedList<>();
    	itinerary.add( startNode );
    	depthFirstSearch( graph, startNode, itinerary, tickets.length );
    	return itinerary;
    }
    
    private void depthFirstSearch( Map<String, List<String>> graph, String startNode, List<String> itinerary, int numTickets )
    {
    	if ( itinerary.size() == numTickets )
    	{
    		return;
    	}

    	List<String> neighbors = graph.get( startNode );
    	for ( int i = 0; i < neighbors.size(); i++ )
    	{
    		String neighbor = neighbors.get( i );
    		itinerary.add( neighbor );
    		neighbors.remove( i );
    		depthFirstSearch( graph, neighbor, itinerary, numTickets );
    		neighbors.add( i, neighbor );
    		itinerary.remove( itinerary.size() - 1 );
    	}
    }
}