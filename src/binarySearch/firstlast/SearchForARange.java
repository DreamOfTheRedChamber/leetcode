package binarySearch.firstlast;

/**
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */

public class SearchForARange 
{
	public int[] searchRange( int[] nums, int target )
    {
		return searchRangeRecurse( nums, target, 0, nums.length - 1 );
    }
	
	private int[] searchRangeRecurse( int[] nums, int target, int start, int end )
	{
		if ( nums.length == 0 )
		{
			return new int[]{ -1, -1 };
		}
		
		if ( start > end )
		{
			return new int[]{ -1, -1 };
		}
		
		int mid = ( end - start ) / 2 + start;
		if ( nums[mid] < target )
		{
			return searchRangeRecurse( nums, target, mid + 1, end ); 
		}
		else if ( nums[mid] > target )
		{
			return searchRangeRecurse( nums, target, start, mid - 1 );
		}
		else
		{
			int[] leftRange = searchRangeRecurse( nums, target, start, mid - 1 );
			int[] rightRange = searchRangeRecurse( nums, target, mid + 1, end );
	        int leftEnd = (leftRange[0] == -1 ? mid : leftRange[0]);
	        int rightEnd = (rightRange[1] == -1 ? mid : rightRange[1]);
	        return new int[]{leftEnd, rightEnd};
		}
	}
}
