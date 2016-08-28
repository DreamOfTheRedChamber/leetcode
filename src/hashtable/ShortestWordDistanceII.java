package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = �coding�, word2 = �practice�, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

public class ShortestWordDistanceII
{

	private Map<String, List<Integer>> wordToPositions;
	
    public WordDistance(String[] words) 
    {
        wordToPositions = new HashMap<>();
        for ( int i = 0; i < words.length; i++ )
        {
        	wordToPositions.putIfAbsent( words[i], new ArrayList<>() );
        	wordToPositions.get( words[i] ).add( i );
        }
    }

    public int shortest(String word1, String word2) 
    {
        List<Integer> word1Positions = wordToPositions.get( word1 );
        List<Integer> word2Positions = wordToPositions.get( word2 );
        Iterator<Integer> word1PosIterator = word1Positions.iterator( );
        Iterator<Integer> word2PosIterator = word2Positions.iterator( );
        int word1CurrPos = word1PosIterator.next( );
        int word2CurrPos = word2PosIterator.next( );
        int minDistance = Math.abs( word1CurrPos - word2CurrPos );
        while ( word1PosIterator.hasNext( )
        		|| word2PosIterator.hasNext( ) )
        {
        	if ( word1CurrPos == word2CurrPos )
        	{
        		throw new IllegalStateException("");
        	}
        	else if ( word1CurrPos < word2CurrPos )
        	{
        		if ( !word1PosIterator.hasNext( ) )
        		{
        			break;
        		}
        		else
        		{
        			word1CurrPos = word1PosIterator.next( );
        			minDistance = Math.min( minDistance, Math.abs( word1CurrPos - word2CurrPos ) );
        		}
        	}
        	else
        	{
        		if ( !word2PosIterator.hasNext( ) )
        		{
        			break;
        		}
        		else
        		{
        			word2CurrPos = word2PosIterator.next( );
        			minDistance = Math.min( minDistance, Math.abs( word1CurrPos - word2CurrPos ) );
        		}
        	}
        }
        return minDistance;
    }

}
