package dynamicprogramming;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
//TO_TEST
public class MaxProduct
{
    public int maxProduct( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int globalMaxProduct = nums[0];
    	int maxEndingAtCurrPos = nums[0]; // ending at index i
    	int minEndingAtCurrPos = nums[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		// max product ending at i
    		maxEndingAtCurrPos = Math.max( Math.max( nums[i] * maxEndingAtCurrPos, // nums[i] > 0
    										nums[i] * minEndingAtCurrPos), 		   // nums[i] < 0
    										nums[i] );			   				   // nums[i-1] == 0
    		minEndingAtCurrPos = Math.min( Math.min( nums[i] * maxEndingAtCurrPos, 
    										nums[i] * minEndingAtCurrPos), 
    										nums[i] );
    		globalMaxProduct = Math.max( globalMaxProduct, maxEndingAtCurrPos );
    	}
    	
    	return globalMaxProduct;
    }
}
