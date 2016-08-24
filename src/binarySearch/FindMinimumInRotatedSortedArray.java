package binarySearch;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * */
public class FindMinimumInRotatedSortedArray 
{
    public int findMin( int[] nums ) 
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	// find first element smaller than end
        int start = 0;
        int end = nums.length - 1;
        while ( start + 1 < end )
        {
        	int mid = ( end - start ) / 2 + start;
        	if ( nums[mid] < nums[nums.length-1] )
        	{
        		end = mid;
        	}
        	else
        	{
        		start = mid;
        	}        	
        }
                
        if ( nums[start] < nums[end] )
        {
        	return nums[start];
        }
        else
        {
        	return nums[end];
        }
    }
}
