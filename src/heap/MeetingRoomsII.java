package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

import utility.Interval;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 * */

public class MeetingRoomsII 
{
	// TODO: intervals - sort, overlap
    public int minMeetingRooms( Interval[] intervals )
    {
    	// sort intervals array
    	// TODO: Arrays.sort( array, comparator ), Collections.sort( collection, comparator )
    	Arrays.sort( intervals, ( o1, o2 ) -> ( o1.start == o2.start ? o1.start - o2.start : o1.end - o2.end ) );
    	
    	// max size of prio queue is result
    	int maxSize = 0;
    	PriorityQueue<Interval> minQueue = new PriorityQueue<>();
    	for ( Interval interval : intervals )
    	{
    		while ( !minQueue.isEmpty() 
    				&& isOverlapping( interval, minQueue.peek() ) )
    		{
    			minQueue.remove();
    		}
    		minQueue.add( interval );
    		maxSize = Math.max( maxSize, minQueue.size() );
    	}
    	
    	return maxSize;
    }
    
    private boolean isOverlapping( Interval interval1, Interval interval2 )
    {
    	return ( interval1.start < interval2.end ) || ( interval2.start < interval1.end );
    }
}
