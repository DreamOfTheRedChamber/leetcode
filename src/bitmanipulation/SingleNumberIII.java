package bitmanipulation;

/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * */

public class SingleNumberIII 
{
    public int[] singleNumber( int[] nums )
    {
        // xor all numbers
    	int twoNumXor = 0;
    	for ( int num : nums )
    	{
    		twoNumXor ^= num;
    	}
    	
    	// find lowest 1 bit pos: 
    	int lowestOnePos = 0;
    	// TODO: put bit operations in parentheses
    	while ( ( twoNumXor & ( 1 << lowestOnePos ) ) == 0)
    	{
    		lowestOnePos++;
    	}
    	
    	// category int[] nums into two according to previous lowest 1 bit    	
    	// xor two categories separately
    	int singleOne = 0;
    	int singleTwo = 0;
    	for ( int num : nums )
    	{
    		if ( ( num & ( 1 << lowestOnePos ) ) == 0 )
    		{
    			singleOne ^= num;
    		}
    		else
    		{
    			singleTwo ^= num;
    		}
    	}
    	return new int[]{ singleOne, singleTwo };
    }
}
