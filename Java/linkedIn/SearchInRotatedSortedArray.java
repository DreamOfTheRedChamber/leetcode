package linkedIn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

(找到rotate的点)
*/

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
 	while ( start + 1 < end )
 	{
 		int mid = ( end - start ) / 2 + start;
 		if ( nums[mid] < nums[end] )	// pivot point inside [start,mid]
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

 @Test
 public void test()
 {
 	assertEquals( 1, search( new int[]{3, 5, 1}, 1 ) );
 }
}
