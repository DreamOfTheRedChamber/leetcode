package linkedIn;

/**
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

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
 	while ( start + 1 < end )
 	{
 		int mid = ( end - start ) / 2 + start;
 		if ( nums[mid] == nums[end] )
 		{
 			end = end - 1;
 		}
 		else if ( nums[mid] < nums[end] )	// pivot point inside [start,mid]
 		{
 			if ( target > nums[mid] 
 					&& target <= nums[end] )
 			{
 				start = mid;
 			}
 			else
 			{
 				end = mid;
 			}
 		}
 		else	// pivot point inside [mid, end]
 		{
 			if ( target < nums[mid] 
 					&& target >= nums[start] )
 			{
 				end = mid;
 			}
 			else
 			{
 				start = mid;
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
