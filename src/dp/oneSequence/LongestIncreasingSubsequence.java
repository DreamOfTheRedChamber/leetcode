package dp.oneSequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 */

// TODO: improve complexity to nlogn
public class LongestIncreasingSubsequence
{
    public int lengthOfLIS( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		return 0;
    	}
    	
    	int[] longestSubseq = new int[nums.length];
    	longestSubseq[0] = 1;
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		longestSubseq[i] = 1;
    		for ( int j = 0; j < i; j++ )
    		{
    			if ( nums[i] > nums[j] )
    			{
    				longestSubseq[i] = Math.max( longestSubseq[i], 1 + longestSubseq[j] );
    			}
    		}
    	}
    	
    	int longestLength = 0;
    	for ( int i = 0; i < longestSubseq.length; i++ )
    	{
    		longestLength = Math.max( longestLength, longestSubseq[i] );
    	}
    	return longestLength;
    }
    
    @Test
    public void test()
    {
    	assertEquals( 6, lengthOfLIS( new int[]{ 1, 3, 6, 7, 9, 4, 10, 5, 6 } ) );
    }
}