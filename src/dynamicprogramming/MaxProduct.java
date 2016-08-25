package dynamicprogramming;

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
    	int maxProductEndingAtI = nums[0]; // ending at index i
    	int minProductEndingAtI = nums[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		// max product ending at i
    		maxProductEndingAtI = Math.max( Math.max( nums[i] * maxProductEndingAtI, // nums[i] > 0
    										nums[i] * minProductEndingAtI), // nums[i] < 0
    										nums[i] );			   // nums[i-1] == 0
    		minProductEndingAtI = Math.min( Math.min( nums[i] * maxProductEndingAtI, 
    										nums[i] * minProductEndingAtI), 
    										nums[i] );
    		globalMaxProduct = Math.max( globalMaxProduct, maxProductEndingAtI );
    	}
    	
    	return globalMaxProduct;
    }
}
