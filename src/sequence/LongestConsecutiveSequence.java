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
    	
    	Set<Integer> existingNums = new HashSet<>();
    	for ( int num : nums )
    	{
    		existingNums.add( num );
    	}
    	
    	int longestConsecSeq = 0;
    	for ( int num : nums )
    	{
    		if ( existingNums.contains( num ) )
    		{
    			existingNums.remove( num );
	    		int currConsecSeq = 1;    	
	    		
	    		for ( int nextBigger = num + 1; existingNums.contains( nextBigger ); nextBigger += 1 )
	    		{
	    			currConsecSeq++;
	    			existingNums.remove( nextBigger );
	    			nextBigger += 1;
	    		}	    			    		
	    		for ( int nextSmaller = num - 1; existingNums.contains( nextSmaller ); nextSmaller -= 1 )
	    		{
	    			currConsecSeq++;
	    			existingNums.remove( nextSmaller );	    			
	    		}
	    		
	    		longestConsecSeq = Math.max( longestConsecSeq, currConsecSeq );
    		}
    	}
    	return longestConsecSeq;
     }
    
    @Test
    public void test()
    {
    	assertEquals( 3, longestConsecutive( new int[]{ 1, 0, -1} ) );
    }
}
