package sum.dp;

/**
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray
{
    public int maxSubArray( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int maxEndingAtCurrPos = nums[0];
    	int globalMaxSum = nums[0];
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		maxEndingAtCurrPos = Math.max( maxEndingAtCurrPos + nums[i], nums[i] );
    		globalMaxSum = Math.max( globalMaxSum, maxEndingAtCurrPos );
    	}
    	return globalMaxSum;
    }
}
