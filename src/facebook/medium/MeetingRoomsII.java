package facebook.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

import utility.Interval;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 * */

public class MeetingRoomsII 
{
    public int minMeetingRooms( Interval[] intervals )
    {
		Arrays.sort( intervals, ( o1, o2 ) -> o1.start - o2.start );
    	
    	// max size of PriorityQueue is result
    	int maxSize = 0;
    	PriorityQueue<Interval> minQueue = new PriorityQueue<>( ( o1, o2 ) -> o1.end - o2.end );
    	for ( Interval interval : intervals )
    	{
    		while ( !minQueue.isEmpty() 
    				&& !isOverlapping( interval, minQueue.peek() ) )
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
    	return ! ( ( interval1.start >= interval2.end ) 
    			|| ( interval2.start >= interval1.end ) );
    }
    
    @Test
    public void test()
    {
    	assertEquals( 1, minMeetingRooms( new Interval[]{ new Interval( 7, 10 ), new Interval( 2, 4 ) } ) );
    	assertEquals( 3, minMeetingRooms( new Interval[]{ new Interval( 6, 17 ), new Interval( 8, 9 ), new Interval( 11, 12 ), new Interval( 6, 9 ) } ) );
    	assertEquals( 2, minMeetingRooms( new Interval[]{ new Interval( 1, 17 ), new Interval( 7, 10 ), new Interval( 12, 14 ) } ) );
    }
}
