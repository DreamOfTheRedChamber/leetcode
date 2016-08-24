package binarySearch;

/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/


// TODO: find pivot point in rotated sorted array, duplicates
// TODO: find target elements in rotated sorted array, duplicates

public class SearchInRotatedSortedArray 
{
    public int search( int[] nums, int target )
    {
    	if ( nums.length == 0 )
    	{
    		return -1;
    	}
    	
    	int start = 0;
    	int end = nums.length - 1;
    	int pivotEnd = nums.length - 1;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
    		if ( nums[mid] < nums[pivotEnd] )
    		{
    			// TODO: put redundant logic into else, smart!!!
    			if ( target < nums[mid] )
    			{
    				end = mid;
    			}
    			else
    			{
    				start = mid;
    			}
    		}
    		else
    		{
    			if ( target > nums[mid] )
    			{
    				start = mid;
    			}
    			else
    			{
    				end = mid;
    			}
    		}
    	}
    	
    	if ( nums[start] == target )
    	{
    		return start;
    	}
    	else if ( nums[end] == target )
    	{
    		return end;
    	}
    	else
    	{
    		return -1;
    	}
    }
}
