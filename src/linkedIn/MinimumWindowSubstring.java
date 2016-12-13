package linkedIn;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S. 
 */

public class MinimumWindowSubstring
{
    public String minWindow( String s, String t )
    {
    	if ( s == null || t == null )
    	{
    		return "";
    	}
    	
    	Map<Character, Integer> tHistogram = new HashMap<>();
    	for ( Character ch : t.toCharArray() )
    	{
    		tHistogram.put( ch, tHistogram.getOrDefault( ch, 0 ) + 1 );
    	}
    	
    	int counter = 0;    	
    	int right = 0;
    	int minWinSize = Integer.MAX_VALUE;
    	int minWinLeft = 0;
    	int minWinRight = 0;
    	Map<Character, Integer> sHistogram = new HashMap<>();
    	for ( int left = 0; left < s.length(); left++ )
    	{
    		// move forward right pointer and maintain sHistogram and counter
    		while ( counter < t.length() && right < s.length() )
    		{
    			if ( tHistogram.containsKey( s.charAt( right ) ) )
    			{
    				int freqS = sHistogram.getOrDefault( s.charAt( right ), 0 );
    				int freqT = tHistogram.get( s.charAt( right ) );
    				// update counter
    				if ( freqS < freqT )
    				{
    					counter++;
    				}
    				// update sHistogram
    				sHistogram.put( s.charAt( right ), freqS + 1 );
    			}		
    			right++;
    		}
    		
    		// update minWin, sHistogram and tHistogram
    		if ( counter == t.length() )
    		{
    			if ( right - left + 1 < minWinSize )
    			{
    				minWinRight = right;
    				minWinLeft = left;
    				minWinSize = right - left + 1;
    			}
    			if ( tHistogram.containsKey( s.charAt( left ) ) )
    			{
    				int freqS = sHistogram.get( s.charAt( left ) );
    				int freqT = tHistogram.get( s.charAt( left ) );
    				if ( freqS <= freqT )
    				{
    					counter--;
    				}
    				sHistogram.put( s.charAt( left ), freqS - 1 );
    			}
    		}    		
    	}
    	
    	return s.substring( minWinLeft, minWinRight );
    }
    
    @Test
    public void test()
    {
    	assertEquals( "BANC", minWindow( "ADOBECODEBANC", "ABC" ) );
    }
}
