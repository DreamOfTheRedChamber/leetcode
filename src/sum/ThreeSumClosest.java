package sum;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest
{
	@Test
	public void test()
	{
		assertEquals( 2, threeSumClosest( new int[]{-1, 2, 1, -4}, 1 ) );
	}
	
    public int threeSumClosest( int[] nums, int target )
    {
    	if ( nums.length < 3 )
    	{
    		throw new IllegalArgumentException();
    	}
    	Arrays.sort( nums );
    	int closestDis = Integer.MAX_VALUE;
    	int closestSum = Integer.MAX_VALUE;
        for ( int i = 0; i < nums.length - 2; i++ )
        {
        	int currSum = twoSumClosest( nums, target - nums[i], i + 1 );
        	int currDis = Math.abs( target - nums[i] - currSum );
        	if ( currDis < closestDis )
        	{
        		closestDis = currDis;
        		closestSum = currSum + nums[i];
        	}
        }
        return closestSum;
    }
    
    private int twoSumClosest( int[] nums, int target, int start )
    {
    	int closestDis = Integer.MAX_VALUE;
    	int closestSum = Integer.MAX_VALUE;
    	int end = nums.length - 1;
    	while ( start < end )
    	{    		
    		int currDis = Math.abs( nums[start] + nums[end] - target );
    		if ( currDis == 0 )
    		{
    			return nums[start] + nums[end];
    		}
    		
    		if ( currDis < closestDis )
    		{
    			closestDis = currDis;
    			closestSum = nums[start] + nums[end];
    		}
    		
    		if ( nums[start] + nums[end] < target )
    		{
    			start++;
    		}
    		else
    		{
    			end--;
    		}
    	}
    	return closestSum;
    }
}
