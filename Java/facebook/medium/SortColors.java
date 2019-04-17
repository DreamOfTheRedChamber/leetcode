package facebook.medium;

import java.util.Arrays;

import org.junit.Test;

/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors
{
	@Test
	public void test()
	{
		int[] array = new int[]{ 1, 0 };
		sortColors( array );
		System.out.println( Arrays.toString( array ) );
		
		int[] array2 = new int[]{ 1, 2, 0 };
		sortColors( array2 );
		System.out.println( Arrays.toString( array2 ) );
	}
	
	private final static int RED = 0;
	private final static int WHITE = 1;
	private final static int BLUE = 2;
	
    public void sortColors( int[] nums )
    {
    	if ( nums.length  == 0 )
    	{
    		return;
    	}
    	int redPointer = 0;    	
    	int whitePointer = 0;
    	int bluePointer = nums.length - 1;
    	while ( whitePointer <= bluePointer ) // where error occurs
    	{
    		if ( nums[whitePointer] == RED )
    		{
    			swap( nums, redPointer, whitePointer );
    			redPointer++;
    			whitePointer++;
    		}
    		else if ( nums[whitePointer] == WHITE )
    		{
    			whitePointer++;
    		}
    		else
    		{
    			swap( nums, whitePointer, bluePointer );
    			bluePointer--;
    		}
    	}
    }
    
    private void swap( int[] nums, int start, int end )
    {
    	int buffer = nums[start];
    	nums[start] = nums[end];
    	nums[end] = buffer;
    }
}
