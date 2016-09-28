package bfs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

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
    	if ( beginWord == null 
    			|| endWord == null 
    			|| wordList == null )
    	{
    		throw new IllegalArgumentException();
    	}
    	// equal case
    	
    	Map<String, Set<String>> graph = buildGraph( beginWord, endWord, wordList );
    	
    	// bfs for shortest transformation
    	Set<String> visited = new HashSet<>();
    	Queue<String> bfsQueue = new LinkedList<>();
    	bfsQueue.offer( beginWord );
    	visited.add( beginWord );
    	int distance = 1;
    	while ( !bfsQueue.isEmpty() )
    	{
    		int levelSize = bfsQueue.size();
    		for ( int i = 0; i < levelSize; i++ )
    		{
    			String head = bfsQueue.poll( );
    			if ( head.equals( endWord ) )
    			{
    				return distance;
    			}
    			for ( String neighbor : graph.get( head ) )
    			{
    				if ( !visited.contains( neighbor ) )
    				{
    					visited.add( neighbor );
    					bfsQueue.add( neighbor );
    				}
    			}
    		}
    		distance++;
    	}
    	
    	return 0;
    }
    
    private Map<String, Set<String>> buildGraph( String beginWord, String endWord, Set<String> wordList )
    {
    	Map<String, Set<String>> graph = new HashMap<>();
    	Set<String> allUniqueNodes = new HashSet<>( wordList );
    	allUniqueNodes.add( beginWord );
    	allUniqueNodes.add( endWord );
    	List<String> allNodes = allUniqueNodes.stream().collect( Collectors.toList() );
    	
    	for ( String node : allNodes )
    	{
    		graph.put( node, new HashSet<>() );
    	}
    	
    	for ( int i = 0; i < allNodes.size() - 1; i++ )
    	{
    		for ( int j = i + 1; j < allNodes.size(); j++ )
    		{
    			if ( isAdjacent( allNodes.get( i ), allNodes.get( j ) ) )
    			{
    				graph.get( allNodes.get( i ) ).add( allNodes.get( j ) );
    				graph.get( allNodes.get( j ) ).add( allNodes.get( i ) );
    			}
    		}
    	}
    	
    	return graph;
    }
    
    private boolean isAdjacent( String word1, String word2 )
    {
    	if ( word1.length( ) != word2.length( ) )
    	{
    		return false;
    	}
    	
    	boolean isFirstDiffFound = false;
    	for ( int i = 0; i < word1.length( ); i++ )
    	{
    		if ( word1.charAt( i ) != word2.charAt( i ) )
    		{
    			if ( !isFirstDiffFound )
    			{
    				isFirstDiffFound = true;
    			}
    			else
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
