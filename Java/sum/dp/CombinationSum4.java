package sum.dp;

/**
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
 */
public class CombinationSum4
{
 public int combinationSum4( int[] nums, int target ) 
 {
 	if ( nums == null || nums.length == 0 || target <= 0 )
 	{
 		return 0;
 	}
 	
 	int[] numCombs = new int[target+1];
 	numCombs[0] = 1;
 	for ( int i = 1; i <= target; i++ )
 	{
 		for ( int num : nums )
 		{
 			if ( i - num >= 0 )
 			{
 				numCombs[i] += numCombs[i-num];
 			}
 		}
 	}
 	return numCombs[target];
 }
}
