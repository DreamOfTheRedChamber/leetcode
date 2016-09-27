package sort;

/**
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
public class SortColors
{
    public void sortColors( int[] nums )
    {
    	if ( nums.length  == 0 )
    	{
    		return;
    	}
    	
    	int white = 0;
    	int red = 0;
    	int blue = nums.length - 1;
    	while ( red < blue )
    	{
    		if ( nums[red] == 0 )
    		{
    			red++;
    		}
    		else if ( nums[red] == 1 )
    		{
    			swap( nums, red, white );
    			red++;
    			white++;
    		}
    		else
    		{
    			swap( nums, red, blue );
    			red++;
    			blue--;
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
