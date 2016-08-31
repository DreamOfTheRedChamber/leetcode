package bitmanipulation;

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

// TO_START
public class CountingBits 
{
    public int[] countBits( int num )
    {
    	if ( num < 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
        	
    	int[] numOfOnes = new int[num + 1];
    	numOfOnes[0] = 0;
    	numOfOnes[1] = 1;
    	
    	// TODO: will it generate all nums?
    	for ( int i = 1; i <= num; i++ )
    	{    	
    		//TODO: overflow
    		int parentOne = ( i << 1 );
    		if ( parentOne < num )
    		{
    			numOfOnes[parentOne] = numOfOnes[i];
    		}
    		int parentTwo = ( i << 1) + 1;
    		if ( parentTwo < num )
    		{
    			numOfOnes[parentTwo] = numOfOnes[i] + 1;
    		}
    	}
    	
    	return numOfOnes;
    }
}
