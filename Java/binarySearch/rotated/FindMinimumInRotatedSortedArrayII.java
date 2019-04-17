package binarySearch.rotated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
    		if ( nums[mid] == nums[end] )
    		{
    			end -= 1;
    		}
    		else if ( nums[mid] < nums[end] )
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
    
    @Test
    public void test()
    {
    	assertEquals( 1, findMin( new int[]{3, 3, 1, 3}) );
    	assertEquals( 3, findMin( new int[]{3, 3, 3 }) );
    }
}