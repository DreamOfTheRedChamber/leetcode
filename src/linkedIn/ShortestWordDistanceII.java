package linkedIn;

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

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

(可能允许重复单词)
 */

public class ShortestWordDistanceII
{

	private Map<String, List<Integer>> wordToIndexes;
	
    public ShortestWordDistanceII(String[] words)
    {
        wordToIndexes = new HashMap<>();
        for ( int i = 0; i < words.length; i++ )
        {
        	wordToIndexes.putIfAbsent( words[i], new ArrayList<>() );
        	wordToIndexes.get( words[i] ).add( i );
        }
    }

    public int shortest(String word1, String word2) 
    {
    	List<Integer> indexes1 = wordToIndexes.get( word1 );
    	List<Integer> indexes2 = wordToIndexes.get( word2 );
    	if (	indexes1 == null 
    			|| indexes2 == null 
    			|| indexes1.size() == 0 
    			|| indexes2.size() == 0 )
    	{
    		throw new IllegalArgumentException(""); 
    	}
    	
    	int index1 = 0;
    	int index2 = 0;
    	int minDis = Integer.MAX_VALUE;
    	while ( index1 < indexes1.size() 
    			&& index2 < indexes2.size() )
    	{
    		minDis = Math.min( minDis, Math.abs( indexes1.get( index1 ) - indexes2.get( index2 ) ) );
    		if ( indexes1.get( index1 ) < indexes2.get( index2 ) )
    		{
    			index1++;
    		}
    		else
    		{
    			index2++;
    		}
    	}
    	return minDis;
    }

}
