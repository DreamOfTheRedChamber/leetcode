package linkedIn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

( followup, input is stream)
 */
public class MaximumSubarray
{
    public int maxSubArray( int[] nums )
    {
    	if ( nums == null || nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int localMaxSum = nums[0];
    	int globalMaxSum = nums[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		localMaxSum = Math.max( localMaxSum + nums[i], nums[i] );
    		globalMaxSum = Math.max( globalMaxSum, localMaxSum );
    	}
    	return globalMaxSum;
    }
    
    @Test
    public void test()
    {    	
    	// normal
    	assertEquals( 6, maxSubArray( new int[]{ 4, -1, 2, 1 } ) );
    	
    	// extreme case, all pos/neg
    	assertEquals( -1, maxSubArray( new int[]{ -5, -1, -2, -3 } ) );    	
    	assertEquals( 10, maxSubArray( new int[]{ 4, 3, 2, 1 } ) );

    	// edge case
    	assertEquals( 4, maxSubArray( new int[]{ 4 } ) );
    	assertEquals( 0, maxSubArray( new int[]{ } ) );
    }
}