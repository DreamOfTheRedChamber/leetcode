package hashtable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
"A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. 
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */

public class HIndex
{

    public int hIndex( int[] citations )
    {
    	// citation from 0 to Math.min(citations.length, Math.max(int[] citations)) 
    	int startPos = 0;
    	int endPos = citations.length;
   	
    	// binary search between startpos to endPos
    	while ( startPos + 1 < endPos )
    	{
    		int midPos = ( endPos - startPos ) / 2 + startPos;
    		int numQualified = calcNumPapersWithHigherCitations( citations, midPos );
    		if ( numQualified < midPos )
    		{
    			endPos = midPos;
    		}
    		else
    		{
    			startPos = midPos;
    		}
    	}
    	
    	// always take the bigger when possible
    	int numQualified = calcNumPapersWithHigherCitations( citations, endPos );
    	if ( numQualified == endPos )
    	{
    		return endPos;
    	}
    	else
    	{
    		return startPos;
    	}
    }

    private int calcNumPapersWithHigherCitations( int[] citations, int target )
    {
    	int numQualifiedPapers = 0;
    	for ( int num : citations )
    	{
    		if ( num >= target )
    		{
    			numQualifiedPapers++;
    		}
    	}
    	return numQualifiedPapers;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 1, hIndex( new int[]{ 1, 1 } ) );
    	assertEquals( 3, hIndex( new int[]{ 3, 0, 6, 1, 5} ) );
    }
}
