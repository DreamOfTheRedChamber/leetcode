package facebook.medium;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

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
public class MaximumSizeSubarraySumEqualsK
{
	@Test
	public void test()
	{
		assertEquals( 4, maxSubArrayLen( new int[]{ 1, -1, 5, -2, 3 }, 3 ) );
		assertEquals( 2, maxSubArrayLen( new int[]{ -2, -1, 2, 1 }, 1 ) );
		assertEquals( 2, maxSubArrayLen( new int[]{ -1, 1 }, 0 ) );
		assertEquals( 4, maxSubArrayLen( new int[]{ 0, 1, -1, 2 }, 2) );
	}
	
    public int maxSubArrayLen( int[] nums, int k )
    {
    	if ( nums.length == 0 )
    	{
    		return 0;
    	}
    	Map<Integer, Integer> prefixSumToIndex = new HashMap<>();
    	int prefixSum = 0;
    	int maxLength = 0;
    	
    	prefixSumToIndex.put( 0, -1 ); // for edge case starting from zero position
    	for ( int i = 0; i < nums.length; i++ )
    	{
    		prefixSum += nums[i];
    		if ( prefixSumToIndex.containsKey( prefixSum - k ) )
    		{
    			maxLength = Math.max( maxLength, 
    									i - prefixSumToIndex.get( prefixSum - k ) );
    		}
    		if ( !prefixSumToIndex.containsKey( prefixSum ) )
    		{
    			prefixSumToIndex.put( prefixSum, i );
    		}
    	}
    	return maxLength;
    }
}
