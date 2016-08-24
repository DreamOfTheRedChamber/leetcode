package binarySearch;

public class FindMinimumInRotatedSortedArrayII 
{
    public int findMin( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int start = 0;
    	int end = nums.length - 1;
    	while ( start + 1 < end )
    	{
    		int mid = ( end - start ) / 2 + start;
        	// TODO: verify correctness of the abstraction
    		if ( nums[mid] == nums[nums.length - 1] )
    		{
    			end = end - 1;
    		}
    		else if ( nums[mid] < nums[nums.length - 1] )
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