package hashtable.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 */

public class GroupAnagrams
{
    public List<List<String>> groupAnagrams( String[] strs )
    {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for ( String str : strs )
        {
        	String anagramKey = getAnagramKey( str );
        	groupedAnagrams.putIfAbsent( anagramKey, new ArrayList<>() );
        	groupedAnagrams.get( anagramKey ).add( str );
        }
        return groupedAnagrams.values( ).stream( ).collect( Collectors.toList( ) );
    }
    
    public String getAnagramKey( String s )
    {
    	int[] histogram = new int[26];
    	for ( char ch : s.toCharArray() )
    	{
    		histogram[ch - 'a']++;
    	}
    	StringBuilder result = new StringBuilder();
    	for ( int i = 0; i < histogram.length; i++ )
    	{
    		if ( histogram[i] > 0 )
    		{
    			result.append( ( char ) ( i + 'a' ) );
    			result.append( histogram[i] );
    		}
    	}
    	return result.toString();
    }
        
    public String getAnagramKeyUnicode( String s )
    {
    	Map<Character, Integer> histogram = new HashMap<>();
    	for ( char ch : s.toCharArray() )
    	{
    		histogram.put( ch, histogram.getOrDefault( ch, 0) + 1 );
    	}
    	StringBuilder result = new StringBuilder();
    	for ( char i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++ )
    	{
    		if ( histogram.containsKey( i ) )
    		{
    			result.append( i );
    			result.append( histogram.get( i ) );
    		}
    	}
    	return result.toString();
    }
    
    @Test
    public void test()
    {
    	Character a = (char) 4000;
    	System.out.println( (int) a );
    	System.out.println( (int) Character.MAX_VALUE );
    	System.out.println( (int) Character.MIN_VALUE );    	
    }
}
