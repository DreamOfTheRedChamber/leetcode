package facebook.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

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
    	List<String> currPath = new LinkedList<>();
    	List<String> itinerary = new LinkedList<>();
    	currPath.add( startNode );
    	depthFirstSearch( graph, startNode, currPath, itinerary, tickets.length );
    	return itinerary;
    }
    
    private void depthFirstSearch( Map<String, List<String>> graph, String startNode, List<String> currPath, List<String> itinerary, int numTickets )
    {
    	if ( itinerary.size() > 0 )
    	{
    		return;
    	}
    	
    	if ( currPath.size() == numTickets + 1 )
    	{
    		itinerary.addAll( currPath );
    		return;
    	}

    	List<String> neighbors = graph.get( startNode );
    	for ( int i = 0; i < neighbors.size(); i++ )
    	{
    		String neighbor = neighbors.get( i );
    		currPath.add( neighbor );
    		neighbors.remove( i );
    		depthFirstSearch( graph, neighbor, currPath, itinerary, numTickets );
    		neighbors.add( i, neighbor );
    		currPath.remove( currPath.size() - 1 );
    	}
    }
    
    @Test
    public void test()
    {
    	System.out.println( findItinerary( new String[][]{ { "MUC", "LHR" }, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"} } ) );
    }
}