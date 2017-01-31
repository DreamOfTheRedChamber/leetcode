package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * */

public class FindAllAnagramsInAString
{
	public List<Integer> findAnagrams( String s, String p )
	{
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> currWind = new HashMap<>();

		for ( Character ch : p.toCharArray() )
		{
			currWind.put( ch, currWind.getOrDefault( ch, 0 ) + 1 );
		}

		int match = 0;
		for ( int i = 0; i < s.length(); i++ )
		{
			// add char
			char chToAdd = s.charAt( i );
			if ( currWind.containsKey( chToAdd ) )
			{
				currWind.put( chToAdd, currWind.get( chToAdd ) - 1 );
				if ( currWind.get( chToAdd ) == 0 )
				{
					match++;
				}
			}

			// remove char
			if ( i >= p.length() )
			{
				char chToRemove = s.charAt( i - p.length() );
				if ( currWind.containsKey( chToRemove ) )
				{
					currWind.put( chToRemove, currWind.get( chToRemove ) + 1 );
				}
				if ( currWind.get( chToRemove ) == 1 )
				{
					match--;
				}
			}

			// verify match
			if ( match == currWind.size() )
			{
				result.add( i - p.length() + 1 );
			}
		}
		
		return result;
	}
}
