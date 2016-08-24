package bitmanipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 * */

//todo
public class MaximumProductOfWordLength 
{
    public int maxProduct( String[] words )
    {
    	Map<String, Integer> strCharEncoding = new HashMap<>();
    	for ( String word : words )
    	{
    		strCharEncoding.put( word, calcEncoding( word ) );
    	}
    	
    	int maxLength = 0;
    	// TODO: two for each loop
    	for ( Entry<String, Integer> entry1 : strCharEncoding.entrySet( ) )
    	{
    		for ( Entry<String, Integer> entry2 : strCharEncoding.entrySet( ) )
    		{
    			if ( !( entry1.getKey( ).equals( entry2.getKey( ) )) 
    					&& ( ( entry1.getValue( ) & entry2.getValue( ) ) != 0 ) )
    			{
    				maxLength = Math.max( maxLength, entry1.getKey( ).length( ) * entry2.getKey( ).length( ) );
    			}
    		}
    	}
    	return maxLength;
    }
    
    private int calcEncoding( String word )
    {
    	int encodedNum = 0;
    	// TODO: loop through chars inside an array
    	for ( char ch : word.toCharArray( ) )
    	{
    		int pos = ( int )( ch - 'a' );
    		encodedNum |= ( 1 << pos );
    	}
    	return encodedNum;
    }
}
