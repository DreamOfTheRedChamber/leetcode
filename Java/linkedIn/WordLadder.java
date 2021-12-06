package linkedIn;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

/**
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

http://massivealgorithms.blogspot.com/search?q=word+ladder
 */
public class WordLadder
{
	
	@Test
	public void test2()
	{
		List<Integer> list1 = new LinkedList<>();
		System.out.println( list1.iterator().next() );
	}
	
	@Ignore
	@Test
	public void test()
	{
		Set<String> words = new HashSet<>();
		words.add( "hot" );
		words.add( "dog" );
		words.add( "dot" );
		assertEquals( 3, ladderLength( "hot", "dog", words ) );
		
		Set<String> words2 = new HashSet<>();
		words2.add( "hot" );
		words2.add( "dog" );
		assertEquals(  -1, ladderLength( "hot", "dog", words2 ) );				
	}
	
 public int ladderLength( String beginWord, String endWord, Set<String> wordList )
 { 	
 	if ( beginWord == null || endWord == null )
 	{
 		throw new IllegalArgumentException();
 	}
 	if ( beginWord.equals( endWord ) )
 	{
 		return 0;
 	}
 	if ( wordList.size() == 0 )
 	{
 		return -1;
 	}
 	
 	Set<String> toBeVisited = new HashSet<>( wordList );
 	toBeVisited.add( endWord );
 	toBeVisited.remove( beginWord );
 	Queue<String> bfsQueue = new LinkedList<>();
 	bfsQueue.add( beginWord );
 	int level = 0;
 	while ( !bfsQueue.isEmpty() )
 	{
 		int size = bfsQueue.size();
 		for ( int i = 0; i < size; i++ )
 		{
 			String head = bfsQueue.poll();
 			if ( head.equals( endWord ) )
 			{
 				return level + 1;
 			}
 			generateNextLevel( head, bfsQueue, toBeVisited );
 		} 		
			level++;
 	}
 	return 0;
 }
 
 private void generateNextLevel( String currWord, Queue<String> bfsQueue, Set<String> toBeVisited )
 {
		char[] word = currWord.toCharArray();
 	for ( int i = 0; i < currWord.length(); i++ )
 	{
 		char chBeforeChange = word[i];
 		for ( char ch = 'a'; ch <= 'z'; ch++ )
 		{
 			word[i] = ch;
 			String nextStr = new String( word );
 			if ( toBeVisited.contains( nextStr ) )
 			{
 				bfsQueue.add( nextStr );
 				toBeVisited.remove( nextStr );
 			}
 		}
 		word[i] = chBeforeChange;
 	}
 }
 
}
