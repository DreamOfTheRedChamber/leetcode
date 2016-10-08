package hashtable;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters
{

    public int lengthOfLongestSubstring( String s )
    {
    	if ( s == null )
    	{
    		return 0;
    	}
    	Set<Character> currWindChars = new HashSet<>();
    	int windStart = 0;
    	int windEnd = 0;
    	int maxLength = 0;
    	while ( windEnd < s.length() )
    	{
    		// increase windEnd as much as possible
    		while ( windEnd < s.length()
    				&& !currWindChars.contains( s.charAt( windEnd ) ) )
    		{
    			currWindChars.add( s.charAt( windEnd ) );
    			windEnd++;
    			maxLength = Math.max( maxLength, windEnd - windStart );
    		}    		
    	
    		// increase windStart as less as possible
    		if ( windEnd < s.length() )
    		{
    			while ( currWindChars.contains( s.charAt( windEnd ) ) )
    			{
    				currWindChars.remove( s.charAt( windStart ) );
    				windStart++;
    			}
    		}
    	}
    	return maxLength;
    }

    @Test
    public void test()
    {
    	assertEquals( 3, lengthOfLongestSubstring( "abcabcbb" ));
    }
}
