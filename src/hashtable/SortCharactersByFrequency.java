package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 * */

public class SortCharactersByFrequency
{
    public String frequencySort( String s )
    {
    	if ( s == null || s.length() == 0 )
    	{
    		return "";
    	}
    	
    	Map<Character, Integer> histogram = new HashMap<>();
    	for ( Character ch : s.toCharArray() )
    	{
    		histogram.put( ch, histogram.getOrDefault( ch, 0 ) + 1 );
    	}
    	
    	PriorityQueue<Map.Entry<Character,Integer>> maxQueue = new PriorityQueue<>( ( o1, o2 ) -> o2.getValue() - o1.getValue() );
    	for ( Map.Entry<Character, Integer> entry : histogram.entrySet() )
    	{
    		maxQueue.offer( entry );
    	}
    	
    	StringBuilder result = new StringBuilder();
    	while ( !maxQueue.isEmpty() )
    	{
    		Map.Entry<Character, Integer> entry = maxQueue.poll();
    		for ( int i = 0; i < entry.getValue(); i++ )
    		{
    			result.append( entry.getKey() );
    		}
    	}
    	return result.toString();
    }    
}
