package dynamicprogramming;

/**
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character 
 */

public class EditDistance
{
    public int minDistance( String word1, String word2 )
    {
    	if ( word1 == null 
    			|| word2 == null )
    	{
    		throw new IllegalArgumentException("...");
    	}
    	if ( word1.length() == 0 )
    	{
    		return word2.length();
    	}
    	if ( word2.length() == 0 )
    	{
    		return word1.length();
    	}
    	
    	int[][] distance = new int[word1.length()][word2.length()];
    	distance[0][0] = word1.charAt( 0 ) == word2.charAt( 0 ) ? 0 : 1;
    	for ( int i = 1; i < word1.length(); i++ )
    	{
    		distance[i][0] = distance[i-1][0] + 1;
    	}
    	for ( int j = 1; j < word2.length(); j++ )
    	{
    		distance[0][j] = distance[0][j-1] + 1;
    	}
    	
    	for ( int i = 1; i < word1.length(); i++ )
    	{
    		for ( int j = 1; j < word2.length(); j++ )
    		{
    			if ( word1.charAt( i ) == word2.charAt( j ) )
    			{
    				distance[i][j] = Math.min( distance[i-1][j-1], Math.min( distance[i-1][j], distance[i][j-1] ) + 1 );
    			}
    			else
    			{
    				distance[i][j] = Math.min( distance[i][j-1], distance[i-1][j] ) + 1;
    			}
    		}
    	}
    	
    	return distance[word1.length() - 1][word2.length() - 1];
    }
}
