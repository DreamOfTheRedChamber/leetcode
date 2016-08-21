package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

public class PerfectSquares
{
    public int numSquares(int n) 
    {
    	int sqrtRoot = (int) Math.sqrt( n );
    	Map<Integer, List<Integer>> minLengthCombSum = new HashMap<>();
    	for ( int i = 1; i < sqrtRoot; i++ )
    	{
    		minLengthCombSum.put( i * i, new ArrayList<>( i * i ) );
    	}
    	
    	for ( int numOfSquares = 1; numOfSquares <= n; numOfSquares++ )
    	{
    		Map<Integer, List<Integer>> nextRoundMap = new HashMap<>();
    		for ( Map.Entry<Integer, List<Integer>> entry : minLengthCombSum.entrySet() )
    		{
    			nextRoundMap.put( entry.getKey(), new ArrayList<>() );
    			for ( Integer sum : entry.getValue() )
    			{
    				if ( sum == n )
    				{
    					return numOfSquares;
    				}
    				else
    				{
    					nextRoundMap.get( entry.getKey() ).add( entry.getKey() + sum );
    				}
    			}
    		}
    		minLengthCombSum = nextRoundMap;
    	}
    	
    	return -1;
    }
}