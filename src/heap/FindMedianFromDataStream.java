package heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream 
{
	// larger half
	private PriorityQueue<Integer> minQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o1 - o2 ) );
	// smaller half
	private PriorityQueue<Integer> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> ( o2 - o1 ) );
	
    // Adds a number into the data structure.
    public void addNum( int num )
    {
    	if ( minQueue.size() == 0 )
    	{
    		// TODO: bug here simplify logic
    		minQueue.add( num );
    	}
    	else if ( maxQueue.size( ) == 0 )
    	{
    		maxQueue.add( num );
    	}
    	else if ( minQueue.size() == maxQueue.size() + 1 )
    	{
    		if ( minQueue.peek( ) > num )
    		{
    			maxQueue.add( minQueue.remove( ) );
    			minQueue.add( num );
    		}
    		else
    		{
    			maxQueue.add( num );
    		}
    	}
    	else if ( minQueue.size() == maxQueue.size() )
    	{
    		if ( maxQueue.peek() < num )
    		{
    			minQueue.add( maxQueue.remove( ) );
    			maxQueue.add( num );
    		}
    		else
    		{
    			minQueue.add( num );
    		}
    	}
    	else
    	{
    		throw new IllegalStateException();
    	}
    	
    }

    // Returns the median of current data stream
    public double findMedian() 
    {
        if ( minQueue.size() == maxQueue.size() )
        {
        	return ( ( double ) minQueue.peek( ) + maxQueue.peek( ) ) / 2;
        }
        else
        {
        	return ( double ) minQueue.peek( );
        }
    }
}
