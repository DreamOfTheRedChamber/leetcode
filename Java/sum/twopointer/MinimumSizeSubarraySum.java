package sum.twopointer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/* 	
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

 * */
public class MinimumSizeSubarraySum 
{
	@Test
	public void test()
	{
		assertEquals( 0, minSubArrayLen( 8, new int[]{ 2, 5 } ) );		
		assertEquals( 2, minSubArrayLen( 7, new int[]{ 2, 3, 1, 2, 4, 3 } ) );
	}
	
 public int minSubArrayLen( int s, int[] nums )
 {
 	if ( nums == null || nums.length == 0 || s <= 0 )
 	{
 		return 0;
 	}
 	
 	int right = 0;
 	int windSum = 0;
 	Integer minLength = null;
 	for ( int left = 0; left < nums.length; windSum -= nums[left], left++  )
 	{
 		while ( right < nums.length && windSum < s )
 		{
 			windSum += nums[right];
 			right++;
 		}
 		
 		if ( windSum >= s )
 		{
 			minLength = minLength == null ? right - left : Math.min( minLength, right - left ); 			
 		}
 		else
 		{
 			break;
 		}
 	}
 	
 	if ( minLength == null )
 	{
 		return 0;
 	}
 	else
 	{
  	return minLength; 		
 	}
 }
}
