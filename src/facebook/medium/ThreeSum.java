package facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * */

public class ThreeSum 
{
    public List<List<Integer>> threeSum( int[] nums )
    {    	
    	List<List<Integer>> result = new ArrayList<>();
    	if ( nums == null || nums.length == 0 )
    	{
    		return result;
    	}
    	Arrays.sort( nums );
    	for ( int i = 0; i < nums.length - 2; i++ )
    	{
    		if ( i > 0 && nums[i] == nums[i-1] )
    		{
    			continue;
    		}
    		List<List<Integer>> twoSumPairs = twoSum( nums, i + 1, -nums[i] );
    		for ( List<Integer> twoSumPair : twoSumPairs )
    		{
    			twoSumPair.add( 0, nums[i] );
    			result.add( twoSumPair );
    		}
    	}
    	return result;
    }
    
    private List<List<Integer>> twoSum( int[] nums, int start, int target )
    {
    	List<List<Integer>> result = new ArrayList<>();
    	int left = start;
    	int right = nums.length - 1;
    	while ( left < right )
    	{
    		if ( left > start && nums[left] == nums[left-1] )
    		{
    			left++;
    			continue;
    		}
    		
    		if ( nums[left] + nums[right] == target )
    		{
    			List<Integer> twoSumPair = new ArrayList<>();
    			twoSumPair.add( nums[left] );
    			twoSumPair.add( nums[right] );
    			result.add( twoSumPair );
    			left++;
    			right--;
    		}
    		else if ( nums[left] + nums[right] < target )
    		{
    			left++;
    		}
    		else
    		{
    			right--;
    		}
    	}    	
    	return result;
    }
    
}
