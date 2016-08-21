package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */

public class IntersectionOfTwoArrays
{

    public int[] intersection(int[] nums1, int[] nums2) 
    {
    	// compute two set from two arrays
    	Set<Integer> uniqueNums1 = new HashSet<>();
    	Set<Integer> uniqueNums2 = new HashSet<>();
    	for ( int num : nums1 )
    	{
    		uniqueNums1.add( num );
    	}
    	for ( int num : nums2 )
    	{
    		uniqueNums2.add( num );
    	}
    	
    	// compute intersection
    	List<Integer> intersection = new ArrayList<>();
    	for ( Integer num : uniqueNums1 )
    	{
    		if ( uniqueNums2.contains( num ) )
    		{
    			intersection.add( num );
    		}
    	}
    	
    	// convert to array
    	int[] result = new int[intersection.size( )];
    	int pos = 0;
    	for ( Integer num : intersection )
    	{
    		result[pos] = num;
    		pos++;
    	}
    	return result;    	
    }

}
