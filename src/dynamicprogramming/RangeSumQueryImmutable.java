package dynamicprogramming;

/**
 * 
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */

public class RangeSumQueryImmutable
{
	private int[] prefixSum;
	public RangeSumQueryImmutable( int[] nums )
	{
		prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for ( int i = 1; i < nums.length; i++ )
		{
			prefixSum[i] = prefixSum[i-1] + nums[i];
		}
	}

    public int sumRange( int i, int j )
    {
    	if ( i == 0 )
    	{
    		return prefixSum[j];
    	}
    	else
    	{
    		return prefixSum[j] - prefixSum[i];
    	}
    }

}
