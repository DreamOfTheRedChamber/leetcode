package twoPointer;

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
    	if ( nums.length <= 1 )
    	{
    		return;
    	}
    	
    	int left = 0;
    	int right = nums.length - 1;
    	while ( left < right )
    	{
    		while ( left < right && nums[left] != 0 )
    		{
    			left++;
    		}
    		while ( left < right && nums[right] == 0 )
    		{
    			right--;
    		}
    		if ( left < right )
    		{
    			swap( nums, left, right );
    		}
    	}
    }
    
    private void swap( int[] nums, int left, int right )
    {
    	int temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
    }
}