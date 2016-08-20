package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
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
        	char[] chArray = str.toCharArray( );
        	Arrays.sort( chArray );
        	groupedAnagrams.putIfAbsent( String.valueOf( chArray ), new ArrayList<>() );
        	groupedAnagrams.get( String.valueOf( chArray ) ).add( str );
        }
        return groupedAnagrams.values( ).stream( ).collect( Collectors.toList( ) );
    }

    @Test
    public void test()
    {
    	char[] array = new char[]{'a', 'b', 'c'};
    	System.out.println( array.toString( ) );
    }
}
