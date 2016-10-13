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
    	List<List<Integer>> threeSums = new ArrayList<>();
    	if ( nums == null || nums.length == 0 )
    	{
    		return threeSums;
    	}
    	Arrays.sort( nums );
    	for ( int i = 0; i < nums.length - 2; i++ )
    	{
    		if ( i > 0 && nums[i] == nums[i-1] )
    		{
    			continue;
    		}
    		
    		int start = i + 1;
    		int end = nums.length - 1;
    		while ( start < end )
    		{
    			if ( start > i + 1 && nums[start] == nums[start-1] )
    			{
    				start++;
    				continue;
    			}
    			
    			int sum = nums[start] + nums[end];
    			if ( sum < -nums[i] )
    			{
    				start++;
    			}
    			else if ( sum > -nums[i] )
    			{
    				end--;
    			}
    			else
    			{
    				List<Integer> threeSum = new LinkedList<>();
    				threeSum.add( nums[i] );
    				threeSum.add( nums[start] );
    				threeSum.add( nums[end] );
    				threeSums.add( threeSum );
    				start++;
    				end--;
    			}
    		}
    	}
    	return threeSums;
    }
}