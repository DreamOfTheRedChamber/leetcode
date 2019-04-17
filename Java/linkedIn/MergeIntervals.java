package linkedIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import utility.Interval;

/**
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

*/

public class MergeIntervals
{
    public List<Interval> merge( List<Interval> intervals )
    {
    	if ( intervals == null || intervals.size() == 0 )
    	{
    		return intervals;
    	}

    	List<Interval> result = new ArrayList<>();
    	Collections.sort( intervals, ( o1, o2 ) -> ( o1.start - o2.start ) );
    	
    	Iterator<Interval> iterator = intervals.iterator();
    	Interval curr = iterator.next();
    	while ( iterator.hasNext() )
    	{
    		Interval next = iterator.next();
    		if ( isOverlap( curr, next ) )
    		{
    			curr = new Interval( Math.min( curr.start, next.start ), Math.max( curr.end, next.end ));
    		}
    		else
    		{
    			result.add( curr );
    			curr = next;
    		}
    	}    	
    	
    	result.add( curr );
    	return result;
    }
    
    private boolean isOverlap( Interval o1, Interval o2 )
    {
    	if ( o1.start > o2.end || o2.start > o1.end )
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
}
