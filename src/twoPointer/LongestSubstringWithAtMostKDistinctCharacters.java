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
        int windStart = 0; // inclusive
        int windEnd = 0; // exclusive
        int maxLength = 0;
        Map<Character, Integer> histogram = new HashMap<>();
        while ( windEnd < s.length() )
        {
        	// increase windEnd as much as possible
        	while ( windEnd < s.length() 
        			 && ( histogram.size() < k || ( histogram.size() == k  && histogram.containsKey( s.charAt( windEnd ) ) ) ) )
        	{
        		histogram.put( s.charAt( windEnd ), 1 + histogram.getOrDefault( s.charAt( windEnd ), 0 ) );
        		windEnd++;
        		maxLength = Math.max( maxLength, windEnd - windStart );
        	}
        	
        	// increase windStart as less as possible
        	if ( windEnd < s.length() )
        	{
        		while ( histogram.size() == k )
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
    
    @Test
    public void test()
    {
    	// boundary case
    	assertEquals( 0, lengthOfLongestSubstringKDistinct( "a", 0 ) );

    	assertEquals( 3, lengthOfLongestSubstringKDistinct( "eceba", 2 ) );
    	assertEquals( 5, lengthOfLongestSubstringKDistinct( "ccaccbba", 2 ) );
    	assertEquals( 8, lengthOfLongestSubstringKDistinct( "ccaccbba", 4 ) );
    }
    
    public class Solution {
        /**
         * @param s : A string
         * @return : The length of the longest substring 
         *           that contains at most k distinct characters.
         */
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
              // write your code here
          int maxLen = 0;

          // Key: letter; value: the number of occurrences.
          Map<Character, Integer> map = new HashMap<Character, Integer>();
          int i, j = 0;
          char c;
          for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
              c = s.charAt(j);
              if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
              } else {
                if(map.size() ==k) 
                  break;
                map.put(c, 1);
              }
              j++;
            }
          
            maxLen = Math.max(maxLen, j - i);
            c = s.charAt(i);
            if(map.containsKey(c)){
              int count = map.get(c);
              if (count > 1) {
                map.put(c, count - 1);
              } else {
                map.remove(c);
              }
            }
          }
          return maxLen; 
      }  
    }
}
