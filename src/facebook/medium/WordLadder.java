package facebook.medium;

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
    	wordList.add( endWord );
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
    			for ( int j = 0; j < head.length(); j++ )
    			{
    				char[] word = head.toCharArray();
    				for ( char ch = 'a'; ch <= 'z'; ch++ )
    				{
    					word[j] = ch;
    					String check = new String( word );
    					if ( !check.equals( head ) && wordList.contains( check ) )
    					{
    						bfsQueue.add( check );
    						wordList.remove( check );
    					}
    				}
    			}
    		}    		
			level++;
    	}
    	return 0;
    }
    
}
