package facebook.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import utility.Interval;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
 * */

public class MeetingRooms 
{
    public boolean canAttendMeetings( Interval[] intervals )
    {
    	if ( intervals == null || intervals.length == 0 )
    	{
    		return true;
    	}
    	
    	Arrays.sort( intervals, ( o1, o2 ) ->  o1.start - o2.start );    	
    	Interval curr = intervals[0];
    	for ( int i = 1; i < intervals.length; i++ )
    	{
    		if ( curr.end <= intervals[i].start )
    		{
    			curr = intervals[i];
    		}
    		else
    		{
    			return false;
    		}
    	}
    	return true;
    }
}
