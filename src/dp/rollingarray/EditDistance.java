package dp.rollingarray;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character 
 */

public class EditDistance
{
	@Test
	public void test()
	{
		assertEquals( 2, minDistance( "ab", "bc" ) );
		assertEquals( 3, minDistance( "mart", "karma" ) );
		assertEquals( 1, minDistance( "geek", "gesek" ) );
		assertEquals( 3, minDistance( "sunday", "saturday" ) );

		assertEquals( 27, minDistance( "pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically" ));
	}
	
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
    	
    	int height = word1.length() + 1;
    	int width = word2.length() + 1;
    	int[][] distance = new int[height][width];
    	// init dp table
    	for ( int i = 1; i < height; i++ )
    	{
    		distance[i][0] = i;
    	}
    	for ( int j = 1; j < width; j++ )
    	{
    		distance[0][j] = j;
    	}
    	
    	// fill dp table
    	for ( int i = 1; i < height; i++ )
    	{
    		for ( int j = 1; j < width; j++ )
    		{
    			distance[i][j] = Math.min( Math.min( distance[i-1][j], distance[i][j-1]) + 1, 
    											distance[i-1][j-1] + ( word1.charAt( i - 1 ) == word2.charAt( j - 1 ) ? 0 : 1));
    		}
    	}
    	
    	return distance[height-1][width-1];
    }

}
