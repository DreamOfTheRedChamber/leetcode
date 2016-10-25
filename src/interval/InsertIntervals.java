package interval;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import utility.Interval;

/**
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 */
public class InsertIntervals
{
	@Test
	public void test()
	{
		List<Interval> list = new ArrayList<>();
		list.add( new Interval( 1, 3 ) );
		list.add( new Interval( 6, 9 ) );
		List<Interval> result = insert( list, new Interval( 2, 5 ) );
		for ( Interval interval : result )
		{
			System.out.println("interval.start=" + interval.start + " interval.end=" + interval.end );
		}
	}
	
	@Test
	public void test2()
	{
		List<Interval> list = new ArrayList<>();
		list.add( new Interval( 1, 2 ) );
		list.add( new Interval( 3, 5 ) );
		list.add( new Interval( 6, 7 ) );
		list.add( new Interval( 8, 10 ) );
		list.add( new Interval( 12, 16 ) );

		List<Interval> result = insert( list, new Interval( 4, 9 ) );
		for ( Interval interval : result )
		{
			System.out.println("interval.start=" + interval.start + " interval.end=" + interval.end );
		}
	}
		
    public List<Interval> insert( List<Interval> intervals, Interval newInterval )
    {
    	List<Interval> result = new ArrayList<>();
    	if ( intervals == null || intervals.size() == 0 )
    	{
    		result.add( newInterval );
    		return result;
    	}
    	
    	boolean hasInserted = false;
    	Interval toBeInserted = newInterval;
    	for ( Interval interval : intervals )
    	{
    		if ( !hasInserted )
    		{
    			if ( isOverlap( interval, toBeInserted ) )
    			{
    				toBeInserted = new Interval( Math.min( interval.start, toBeInserted.start ), 
    											Math.max( interval.end, toBeInserted.end ) );
    			}
    			else if ( interval.start < toBeInserted.start )
    			{
    				result.add( interval );
    			}
    			else
    			{
    				result.add( toBeInserted );
    				result.add( interval );
    				hasInserted = true;
    			}
    		}
    		else
    		{
    			result.add( interval );
    		}    		
    	}
    	
    	if ( !hasInserted )
    	{
    		result.add( toBeInserted );
    	}
    	
    	return result;
    }
    
    private boolean isOverlap( Interval o1, Interval o2 )
    {
    	if ( ( o1.start > o2.end ) || ( o2.start > o1.end ) )
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
}

