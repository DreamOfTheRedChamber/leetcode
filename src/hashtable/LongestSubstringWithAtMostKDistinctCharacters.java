package hashtable;

import java.util.HashMap;
import java.util.Map;

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
        
        int windStart = 0; // inclusive
        int windEnd = 0; // exclusive
        int maxLength = 0;
        Map<Character, Integer> histogram = new HashMap<>();
        while ( windEnd < s.length() )
        {
        	// TODO: simplify condition
        	// increase windEnd as much as possible
        	while ( windEnd < s.length() 
        			 && ( histogram.size() < k || ( histogram.size() == k  && histogram.containsKey( s.charAt( windEnd ) ) ) ) )
        	{
        		histogram.put( s.charAt( windEnd ), 1 + histogram.getOrDefault( s.charAt( windEnd ), 0 ) );
        		maxLength = Math.max( maxLength, windEnd - windStart );
        	}
        	
        	// increase windStart as less as possible
        	if ( windEnd < s.length() )
        	{
        		while ( histogram.size() == k 
        				&& histogram.containsKey( s.charAt( windStart) ) )
        		{
        			if ( histogram.get( s.charAt( windStart ) ) == 1 )
        			{
        				histogram.remove( s.charAt( windStart ) );
        			}
        			else
        			{
        				histogram.put( s.charAt( windStart ), histogram.get( s.charAt( windStart ) ) - 1 );
        			}
        			windStart++;
        		}
        	}
        }
        
        return maxLength;
    }
}
