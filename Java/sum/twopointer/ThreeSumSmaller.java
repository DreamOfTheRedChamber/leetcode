package sum.twopointer;

import java.util.Arrays;

/**
Given an array of n integers nums and a target, 
find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?
 */

public class ThreeSumSmaller
{
 public int threeSumSmaller( int[] nums, int target )
 {
 	if ( nums.length < 3 )
 	{
 		return 0;
 	}
 	
 	Arrays.sort( nums );
 	int totalNum = 0;
 	for ( int i = 0; i < nums.length - 2; i++ )
 	{ 		
 		totalNum += twoSumSmaller( nums, target - nums[i], i + 1 );
 	}
 	return totalNum;
 }
 
 private int twoSumSmaller( int[] nums, int target, int start )
 {
 	int totalNum = 0;
 	
 	int left = start;
 	int right = nums.length - 1;
 	while ( left < right )
 	{
 		int sum = nums[left] + nums[right];
 		if ( sum < target )
 		{
 			totalNum += right - left;
 			left++;
 		}
 		else
 		{
 			right--;
 		}
 	}
 	
 	return totalNum;
 }
}