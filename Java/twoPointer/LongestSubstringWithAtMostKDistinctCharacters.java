package twoPointer;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 
 */

public class LongestSubstringWithAtMostKDistinctCharacters
{

    public int lengthOfLongestSubstringKDistinct( String s, int k )
    {
        if ( k < 0 
        	|| s == null )
        {
        	throw new IllegalArgumentException("");
        }
        if ( k == 0 )
        {
        	return 0;
        }
        
        int longest = 0;
        Map<Character, Integer> histogram = new HashMap<>();
        int rightP = 0;
        for ( int leftP = 0; leftP < s.length(); leftP++ )
        {
        	// move right pointer
        	while ( rightP < s.length() && histogram.size() <= k )
        	{        		
        		histogram.put( s.charAt( rightP ), 1 + histogram.getOrDefault( s.charAt( rightP ), 0 ) );
        		if ( histogram.size() <= k )
        		{
        			longest = Math.max( longest, rightP - leftP + 1 );
        		}
        		rightP++;
        	}
        	
        	// process left pointer
        	if ( histogram.get( s.charAt( leftP ) ) == 1 )
        	{
        		histogram.remove( s.charAt( leftP ) );
        	}
        	else
        	{
        		histogram.put( s.charAt( leftP ), histogram.get( s.charAt( leftP ) ) - 1 );
        	}
        }
        
        return longest;
    }
    
    @Test
    public void test()
    {
    	// boundary case
    	assertEquals( 0, lengthOfLongestSubstringKDistinct( "a", 0 ) );

    	assertEquals( 3, lengthOfLongestSubstringKDistinct( "eceba", 2 ) );
    	assertEquals( 5, lengthOfLongestSubstringKDistinct( "ccaccbba", 2 ) );
    	assertEquals( 8, lengthOfLongestSubstringKDistinct( "ccaccbba", 4 ) );
    }    
}
