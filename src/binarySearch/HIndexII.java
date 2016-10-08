package binarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 * */
public class HIndexII 
{
    public int hIndex( int[] citations )
    {
     	if ( citations.length == 0 )
    	{
    		return 0;
    	}
    	
    	// find last position where length - pos >= citations[pos]
    	int start = 0;
    	int end = citations.length - 1;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
    		if ( citations[mid] > citations.length - mid )
    		{
    			end = mid;
    		}
    		else
    		{
    			start = mid;
    		}
    	}
    	
    	if ( citations[start] >= citations.length - start )
    	{
    		return citations.length - start;
    	}
    	else if ( citations[end] >= citations.length - end ) 
    	{
    		return citations.length - end;
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    @Test
    public void test()
    {   
    	assertEquals( 1, hIndex( new int[]{ 100 } ) );
    	    	
    	assertEquals( 2, hIndex( new int[]{ 11, 15 } ) );
    	assertEquals( 1, hIndex( new int[]{ 1, 2 } ) );
    	assertEquals( 2, hIndex( new int[]{ 2, 4 } ) );    	
   		assertEquals( 1, hIndex( new int[]{ 0, 0, 1 } ) );    	
     	assertEquals( 3, hIndex( new int[]{ 3, 3, 3, 3, 3 } ) );

   		assertEquals( 2, hIndex( new int[]{ 0, 0, 4, 4 } ) );
   		
   		assertEquals( 0, hIndex( new int[]{ 0 }) );
    }
}
