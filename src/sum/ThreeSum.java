package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
	@Test
	public void test()
	{
		System.out.println( threeSum( new int[]{-1, 0, 1, -1, 2, -1, -4} ) );
	}
	
    public List<List<Integer>> threeSum( int[] nums )
    {
    	List<List<Integer>> allThreeSums = new ArrayList<>();
    	if ( nums == null || nums.length == 0 )
    	{
    		return allThreeSums;
    	}
    	Arrays.sort( nums );
    	for ( int i = 0; i < nums.length - 2; i++ )
    	{
    		if ( i > 0 && nums[i] == nums[i-1] )
    		{
    			continue;
    		}
    		
    		List<List<Integer>> allTwoSums = twoSum( nums, i + 1, -nums[i] );
    		if ( allTwoSums.size() != 0 )
    		{
    			for ( List<Integer> oneTwoSum : allTwoSums )
    			{
	    			List<Integer> oneThreeSum = new LinkedList<>( oneTwoSum );
	    			oneThreeSum.add( 0, nums[i] );
	    			allThreeSums.add( oneThreeSum );
    			}
    		}
    	}
    	return allThreeSums;
    }
    
    private List<List<Integer>> twoSum( int[] nums, int start, int target )
    {
    	List<List<Integer>> allTwoSums = new ArrayList<>();
    	int right = nums.length - 1;
    	int left = start;
    	while ( left < right )
    	{
    		if ( left > start && nums[left] == nums[left-1] )
    		{
    			left++;
    			continue;
    		}
    		
    		if ( nums[left] + nums[right] == target )
    		{
    			List<Integer> oneTwoSum = new LinkedList<>();
    			oneTwoSum.add( nums[left] );
    			oneTwoSum.add( nums[right] );
    			allTwoSums.add( oneTwoSum );
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
    	return allTwoSums;
    }
}