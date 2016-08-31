package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 */
// TO_TEST
public class MaximumSizeSubarraySumEqualsK
{
    public int maxSubArrayLen( int[] nums, int k )
    {
    	Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
    	int prefixSum = 0;
    	int maxLength = 0;
    	for ( int i = 0; i < nums.length; i++ )
    	{
    		prefixSum += nums[i];
    		if ( prefixSumToIndex.containsKey( k - prefixSum ) )
    		{
    			maxLength = Math.max( maxLength, i - prefixSumToIndex.get( k - prefixSum ) );
    		}
    		if ( !prefixSumToIndex.containsKey( prefixSum ) )
    		{
    			prefixSumToIndex.put( prefixSum, i );
    		}
    	}
    	return maxLength;
    }
}
