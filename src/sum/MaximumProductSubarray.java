package sum;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */

public class MaximumProductSubarray
{
    public int maxProduct( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	// compute local peek values
    	int[] localMaxProduct = new int[nums.length];
    	int[] localMinProduct = new int[nums.length];
    	localMaxProduct[0] = nums[0];
    	localMinProduct[0] = nums[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		localMaxProduct[i] = Math.max( nums[i], 
    										Math.max( localMaxProduct[i-1] * nums[i], localMinProduct[i-1] * nums[i] ) );
    		localMinProduct[i] = Math.min( nums[i], 
    										Math.min( localMaxProduct[i-1] * nums[i], localMinProduct[i-1] * nums[i] ));
    	}
    	
    	// compute global peek values
    	int globalMax = localMaxProduct[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		globalMax = Math.max( globalMax, localMaxProduct[i] );
    	}
    	
    	return globalMax;
    }
}
