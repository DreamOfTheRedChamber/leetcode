package facebook.medium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
 * */

public class IncreasingTripleetSubsequence 
{
    public boolean increasingTriplet( int[] nums )
    {
        if ( nums == null || nums.length <= 2 )
        {
        	return false;
        }

        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        for ( int i = 0; i < nums.length; i++ )
        {
        	if ( nums[i] > secondSmallest )
        	{
        		return true;
        	}
        	else if ( nums[i] <= smallest )
        	{
        		smallest = nums[i];
        	}
        	else
        	{
        		secondSmallest = nums[i];
        	}        	
        }
        return false;
    }
    
    @Test
    public void test()
    {
    	assertTrue( increasingTriplet( new int[]{ 1, 4, 3, 2, 5 } ) );
    	assertFalse( increasingTriplet( new int[]{ 1, 1, -2, 6 } ) ); // smallest, second smallest must be different
    }
}
