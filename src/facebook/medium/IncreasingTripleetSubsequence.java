package facebook.medium;

/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
 * */

public class IncreasingTripleetSubsequence 
{
    public boolean increasingTriplet( int[] nums )
    {
        if ( nums == null || nums.length <= 2 )
        {
        	return false;
        }
        
        int one = nums[0];
        int two = Integer.MAX_VALUE;
        for ( int i = 1; i < nums.length; i++ )
        {
        	if ( nums[i] > two )
        	{
        		return true;
        	}
        	else if ( nums[i] > one && nums[i] < two )
        	{
        		two = nums[i];
        	}
        	else if ( nums[i] < one )
        	{
        		one = nums[i];
        	}
        }
        return false;
    }
}
