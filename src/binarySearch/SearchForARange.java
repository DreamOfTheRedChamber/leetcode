package binarySearch;

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
		if ( nums.length == 0 )
		{
			return new int[]{ -1, -1 };
		}
		int firstAppearPos = findFirstAppear( nums, target );
		int lastAppearPos = ( firstAppearPos == -1 ) ? -1 : findLastAppear( nums, target );
		return new int[]{ firstAppearPos, lastAppearPos };
    }

	private int findFirstAppear( int[] nums, int target )
	{
		int start = 0;
		int end = nums.length - 1;
		while ( start + 1 < end )
		{
			int mid = ( end - start ) / 2 + start;
			if ( nums[mid] == target )
			{
				end = mid;
			}
			else if ( nums[mid] < target )
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
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
	
	private int findLastAppear( int[] nums, int target )
	{
		int start = 0;
		int end = nums.length - 1;
		while ( start + 1 < end )
		{
			int mid = ( end - start ) / 2 + start;
			if ( nums[mid] == target )
			{
				start = mid;
			}
			else if ( nums[mid] < target )
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}
		
		if ( nums[end] == target )
		{
			return end;
		}
		else if ( nums[start] == target )
		{
			return start;
		}
		else
		{
			return -1;
		}		
	}
}
