package twoPointer;

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * */

public class ShortestWordDistance 
{
    public int shortestDistance( String[] words, String word1, String word2 )
    {    	
    	int minDistance = Integer.MAX_VALUE;
    	int word1Pos = findNextAppear( words, word1, 0 );
    	int word2Pos = findNextAppear( words, word2, 0 );
    	while ( word1Pos < words.length && word2Pos < words.length )
    	{
    		minDistance = Math.min( minDistance, Math.abs( word1Pos - word2Pos ) );
    		if ( word1Pos < word2Pos )
    		{
    			word1Pos = findNextAppear( words, word1, word1Pos + 1 );
    		}
    		else
    		{
    			word2Pos = findNextAppear( words, word2, word2Pos + 1 );
    		}
    	}
    	return minDistance;
    }
    
    private int findNextAppear( String[] words, String word, int startPos )
    {
    	for ( int i = startPos; i < words.length; i++ )
    	{
    		if ( words[i].equals( word ) )    			
    		{
    			return i;
    		}
    	}
    	return words.length;
    }
}