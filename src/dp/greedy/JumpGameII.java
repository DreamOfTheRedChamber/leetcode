package dp.greedy;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII 
{
	
    @Test
    public void test()
    {
    	assertEquals( 2, jumpDP( new int[]{2, 3, 1, 1, 4} ) );
    	assertEquals( 0, jumpDP( new int[]{1} ) );
    	assertEquals( 2, jumpDP( new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}) );
    }

    public int jumpDP( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		return 0;
    	}
    	
        int[] minSteps = new int[nums.length];
        Arrays.fill( minSteps, Integer.MAX_VALUE );
        minSteps[0] = 0;
        for ( int i = 0; i < nums.length; i++ )
        {
        	for ( int j = 1; j <= nums[i] && i + j < nums.length ; j++ )
        	{
        		minSteps[i+j] = Math.min( minSteps[i+j], minSteps[i] + 1 );
        	}
        }
        
        return minSteps[nums.length-1];
    }
    
}
