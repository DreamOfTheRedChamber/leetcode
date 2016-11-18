package hashtable.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
	private final static int CHARSET_SIZE = 26;
    public List<List<String>> groupAnagrams( String[] strs )
    {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for ( String str : strs )
        {
        	char[] freqMap = new char[CHARSET_SIZE];
        	for ( char ch : str.toCharArray() )
        	{
        		freqMap[ch-'a']++;
        	}
        	String anagramKey = String.valueOf( freqMap );
        	groupedAnagrams.putIfAbsent( anagramKey, new ArrayList<>() );
        	groupedAnagrams.get( anagramKey ).add( str );
        }
        return groupedAnagrams.values( ).stream( ).collect( Collectors.toList( ) );
    }
    
    
}
