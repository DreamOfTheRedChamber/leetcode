package sequence.subsequence;

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
 
 public int lengthOfLISBinarySearch( int[] nums )
 {
 	int[] minLast = new int[nums.length + 1];
 	minLast[0] = Integer.MIN_VALUE;
 	for ( int i = 1; i <= nums.length; i++ )
 	{
 		minLast[i] = Integer.MAX_VALUE;
 	}
 	
 	for ( int i = 0; i < nums.length; i++ )
 	{
 		// find the first number in minLast > nums[i]
 		int index = binarySearch( minLast, nums[i] );
 		minLast[index] = nums[i];
 	}
 	
 	for ( int i = nums.length; i >= 1; i-- )
 	{
 		if ( minLast[i] != Integer.MAX_VALUE )
 		{
 			return i;
 		}
 	}
 	
 	return 0;
 }
 
 private int binarySearch( int[] minLast, int num )
 {
 	int start = 0, end = minLast.length - 1;
 	while ( start + 1 < end )
 	{
 		int mid = ( end - start ) / 2 + start;
 		if ( minLast[mid] < num )
 		{
 			start = mid;
 		}
 		else
 		{
 			end = mid;
 		}
 	}
 	
 	if ( minLast[start] > num )
 	{
 		return start;
 	}
 	return end;
 }
 
 @Test
 public void test()
 {
 	assertEquals( 6, lengthOfLIS( new int[]{ 1, 3, 6, 7, 9, 4, 10, 5, 6 } ) );
 }
}