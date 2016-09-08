package dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaxProduct
{
    public int maxProduct( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int globalMaxProduct = nums[0];
    	int maxEndingAtPrevPos = nums[0]; // ending at index i
    	int minEndingAtPrevPos = nums[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		// max product ending at i
    		int updatedMaxEndingAtPrevPos = Math.max( Math.max( nums[i] * maxEndingAtPrevPos, // nums[i] > 0
    										nums[i] * minEndingAtPrevPos ), 		   // nums[i] < 0
    										nums[i] ); // nums[i-1] == 0
    		int updatedMinEndingAtPrevPos = Math.min( Math.min( nums[i] * maxEndingAtPrevPos, 
    										nums[i] * minEndingAtPrevPos ), 
    										nums[i] );
    		maxEndingAtPrevPos = updatedMaxEndingAtPrevPos;
    		minEndingAtPrevPos = updatedMinEndingAtPrevPos;
    		globalMaxProduct = Math.max( globalMaxProduct, maxEndingAtPrevPos );
    	}
    	
    	return globalMaxProduct;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 12, maxProduct( new int[]{ -4, -3, -2 } ) );
    	assertEquals( 6, maxProduct( new int[]{ 2, 3, -2, 4 } ) );
    	assertEquals( 25, maxProduct( new int[]{ 2, -4, 0, -5, -5 } ) );
    	assertEquals( 0, maxProduct( new int[]{ -4, 0, -1 } ) );
    }
}
