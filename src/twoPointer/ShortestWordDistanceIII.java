package twoPointer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.*/

public class ShortestWordDistanceIII
{
    public int shortestWordDistance( String[] words, String word1, String word2 )
    {
    	if ( word1.equals( word2 ) )
    	{
    		return solveEqualCase( words, word1 );
    	}
    	else
    	{
    		return solveUnequalCase( words, word1, word2 );
    	}
    }
    
    private int solveEqualCase( String[] words, String word )
    {
    	int lastPos = -1;
    	int minDistance = Integer.MAX_VALUE;
    	for ( int i = 0; i < words.length; i++ )
    	{
    		if ( word.equals( words[i] ) )
    		{
    			if ( lastPos != -1 )
    			{    				
    				minDistance = Math.min( minDistance, i - lastPos );    				
    			}
				lastPos = i;
    		}
    	}
    	return minDistance;
    }
    
    private int solveUnequalCase( String[] words, String word1, String word2 )
    {    	
    	int minDistance = Integer.MAX_VALUE;
    	int word1Pos = -1;
    	int word2Pos = -1;
    	for ( int i = 0; i < words.length; i++ )
    	{
    		if ( word1.equals( words[i] ) )
    		{
    			word1Pos = i;
    		}
    		else if ( word2.equals( words[i] ) )
    		{
    			word2Pos = i;
    		}
    		else
    		{
    			continue;
    		}
    		
    		if ( word1Pos != -1 && word2Pos != -1 )
    		{
    			minDistance = Math.min( minDistance, Math.abs( word1Pos - word2Pos ) );
    		}
    	}
    	return minDistance;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 1, shortestWordDistance( new String[]{ "a", "a" }, "a", "a" ) );
    }
}
