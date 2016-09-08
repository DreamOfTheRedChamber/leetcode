package bitmanipulation;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/*
Given a non negative integer number num. 
For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * */

// TO_TEST
public class CountingBits 
{
	@Test
	public void test()
	{
		assertArrayEquals( new int[]{ 0, 1, 1, 2, 1, 2 }, countBits( 5 )  ); 
	}
	
    public int[] countBits( int num )
    {
    	if ( num < 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
        	
    	int[] numOfOnes = new int[num + 1];
    	numOfOnes[0] = 0;
    	numOfOnes[1] = 1;
    	
    	for ( int i = 1; i <= num; i++ )
    	{    	
    		int parentOne = ( i << 1 );
    		if ( parentOne > 0 &&
    				parentOne <= num )
    		{
    			numOfOnes[parentOne] = numOfOnes[i];
    		}
    		int parentTwo = ( i << 1) + 1;
    		if ( parentTwo > 0 &&
    				parentTwo <= num )
    		{
    			numOfOnes[parentTwo] = numOfOnes[i] + 1;
    		}
    	}
    	
    	return numOfOnes;
    }
}
