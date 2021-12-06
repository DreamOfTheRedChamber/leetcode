package sequence;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence
{
    public int longestConsecutive( int[] nums )
    {
    	if ( nums == null || nums.length == 0 )
    	{
    		return 0;
    	}    	
    	
    	Set<Integer> numSet = new HashSet<>();
    	for ( int num : nums )
    	{
    		numSet.add( num );
    	}
    	
    	int longestLength = 0;
    	for ( int num : nums )
    	{
    		if ( !numSet.contains( num ) )
    		{
    			continue;
    		}
    		
    		numSet.remove( num );
	    	int currLength = 1;    	
	    		
	    	for ( int nextBigger = num + 1; numSet.contains( nextBigger ); nextBigger += 1 )
	    	{
	    		currLength++;
	    		numSet.remove( nextBigger );
	    	}	    			    		
	    	for ( int nextSmaller = num - 1; numSet.contains( nextSmaller ); nextSmaller -= 1 )
	    	{
	    		currLength++;
	    		numSet.remove( nextSmaller );	    			
	    	}
	    		
	    	longestLength = Math.max( longestLength, currLength );
    	}
    	return longestLength;
     }
    
    @Test
    public void test()
    {
    	assertEquals( 3, longestConsecutive( new int[]{ 1, 0, -1} ) );
    }
}
