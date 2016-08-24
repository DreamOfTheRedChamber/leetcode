package hashtable;

import java.util.HashSet;
import java.util.Set;

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
    				&& !currWindChars.contains( windEnd ) )
    		{
    			windEnd++;
    			currWindChars.add( s.charAt( windEnd ) );
    			maxLength = Math.max( maxLength, windEnd - windStart );
    		}    		
    		// increase windStart as less as possible
    		if ( windEnd < s.length() )
    		{
    			while ( currWindChars.contains( windEnd ) )
    			{
    				currWindChars.remove( s.charAt( windStart ) );
    				windStart++;
    			}
    		}
    	}
    	return maxLength;
    }

}
