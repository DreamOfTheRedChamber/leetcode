package binarySearch;

public class SearchInRotatedSortedArrayII 
{
    public boolean search(int[] nums, int target) 
    {
    	if ( nums.length == 0 )
    	{
    		return false;
    	}
    	
    	int start = 0;
    	int end = nums.length - 1;
    	int pivotEnd = nums.length - 1;
    	while ( start + 1 < end 
    			&& start + 1 < pivotEnd )
    	{
    		int mid = ( end - start ) / 2 + start;
    		// TODO: how to handle pivotEnd and end inconsistent problem
    		if ( nums[mid] == nums[pivotEnd] )
    		{
    			pivotEnd--;
    		}    		
    		else if ( nums[mid] < nums[pivotEnd] )
    		{
    			// TODO: put redundant logic into else, smart!!!
    			if ( target == nums[mid] )
    			{
    				return true;
    			}
    			else if ( target < nums[mid] )
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
    			if ( target == nums[mid] )
    			{
    				return true;
    			}
    			else if ( target > nums[mid] )
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
    		return true;
    	}
    	else if ( nums[end] == target )
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
