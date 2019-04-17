package facebook.easy;

import java.util.Arrays;

import org.junit.Test;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * */

public class MoveZeros 
{
    public void moveZeroes( int[] nums )
    {    	
    	int nonZeroIndex = 0;
    	for ( int i = 0; i < nums.length; i++ )
    	{
    		if ( nums[i] != 0 )
    		{
    			swap( nums, i, nonZeroIndex );
    			nonZeroIndex++;
    		}
    	}
    }
    
    private void swap( int[] nums, int pos1, int pos2 )
    {
    	int temp = nums[pos1];
    	nums[pos1] = nums[pos2];
    	nums[pos2] = temp;
    }
    
    @Test
    public void test()
    {
    	int[] array = new int[]{ 0, 1, 0, 3, 12 };
    	moveZeroes( array );
    	System.out.println( Arrays.toString( array ));
    }
}