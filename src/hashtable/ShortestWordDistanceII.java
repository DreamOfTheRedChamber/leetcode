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
    	if (	word1Positions == null 
    			|| word2Positions == null 
    			|| word1Positions.size() == 0 
    			|| word2Positions.size() == 0 )
    	{
    		throw new IllegalArgumentException(""); 
    	}
    	
    	int currWord1Pos = 0;
    	int currWord2Pos = 0;
    	int minDis = Integer.MAX_VALUE;
    	while ( currWord1Pos < word1Positions.size() 
    			&& currWord2Pos < word2Positions.size() )
    	{
    		minDis = Math.min( minDis, Math.abs( word1Positions.get( currWord1Pos ) - word2Positions.get( currWord2Pos ) ) );
    		if ( word1Positions.get( currWord1Pos ) < word2Positions.get( currWord2Pos ) )
    		{
    			currWord1Pos++;
    		}
    		else if ( word1Positions.get( currWord1Pos ) > word2Positions.get( currWord2Pos ) ) 
    		{
    			currWord2Pos++;
    		}
    		else
    		{
    			throw new IllegalStateException("");
    		}    			
    	}
    	return minDis;
    }

}
