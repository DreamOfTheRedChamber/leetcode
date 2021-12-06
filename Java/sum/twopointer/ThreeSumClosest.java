package sum.twopointer;

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
    	return 0;
    }
}
