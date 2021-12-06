package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 * */
// TO_TEST
public class PalindromePairs 
{
	@Test
	public void test()
	{
		System.out.println( palindromePairs( new String[]{ "abcd", "dcba", "lls", "s", "sssll" } ) );
		System.out.println( palindromePairs( new String[]{ "bat", "tab", "cat" } ) );
	}
	
 public List<List<Integer>> palindromePairs( String[] words )
 {
 	List<List<Integer>> allPairs = new ArrayList<>();
 	if ( words.length == 0 )
 	{
 		return allPairs;
 	}
 	
 	Map<String, Integer> wordToIndex = new HashMap<>();
 	for ( int i = 0; i < words.length; i++ )
 	{
 		String word = words[i];

 		// add pair to left
 		for ( int j = 0; j < word.length() - 1; j++ )
 		{
 			if ( isPalindrome( word, 0, j ) )
 			{
 				String reversed = new StringBuilder( word.substring( j+1 ) ).reverse().toString();
 				if ( wordToIndex.containsKey( reversed ) )
 				{
 					addNewPair( allPairs, wordToIndex.get( reversed ), i );
 				}
 			}
 		}
 		
 		// add pair to right
 		for ( int j = word.length() - 1; j > 0; j++ )
 		{
 			if ( isPalindrome( word, j, word.length() - 1 ) )
 			{
 				String reversed = new StringBuilder( word.substring( 0, j ) ).reverse().toString();
 				if ( wordToIndex.containsKey( reversed ) )
 				{
 					addNewPair( allPairs, i, wordToIndex.get( reversed ));
 				}
 			}
 		} 		
 	}
 	
 	// edge case for empty string
 	if ( wordToIndex.containsKey( "" ) )
 	{
 		int emptyIndex = wordToIndex.get( "" );
 		for ( String key : wordToIndex.keySet() )
 		{
 			if ( isPalindrome( key, 0, key.length() - 1 ) )
 			{					
					addNewPair( allPairs, emptyIndex, wordToIndex.get( key ) );
					addNewPair( allPairs, wordToIndex.get( key ), emptyIndex );
 			}
 		}
 	}
 	
 	return allPairs;
 }
 
 private void addNewPair( List<List<Integer>> allPairs, int index1, int index2 )
 {
 	List<Integer> onePair = new ArrayList<>();
 	onePair.add( index1 );
 	onePair.add( index2 );
 	allPairs.add( onePair );
 }
 
 private boolean isPalindrome( String s, int start, int end )
 {
 	while ( start < end )
 	{
 		if ( s.charAt( start ) != s.charAt( end ) )
 		{
 			return false;
 		}
 		start++;
 		end--;
 	}
 	return true;
 }
}
