package facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class IntersectionOfTwoArraysII
{

    public int[] intersect(int[] nums1, int[] nums2) 
    {
    	// compute histogram for nums1 and nums2
    	Map<Integer, Integer> histogramNums1 = new HashMap<>();
    	for ( int num : nums1 )
    	{
    		histogramNums1.put( num, histogramNums1.getOrDefault( num, 0 ) + 1 );
    	}
    	
    	Map<Integer, Integer> histogramNums2 = new HashMap<>();
    	for ( int num : nums2 )
    	{
    		histogramNums2.put( num, histogramNums2.getOrDefault( num, 0 ) + 1 );
    	}
    	
    	// compute intersection
    	List<Integer> intersection = new ArrayList<>();
    	for ( Map.Entry<Integer, Integer> entry : histogramNums1.entrySet( ) )
    	{
    		if ( histogramNums2.containsKey( entry.getKey( ) ) )
    		{
    			int minFreq = Math.min( entry.getValue( ), histogramNums2.get( entry.getKey( ) ) );
    			for ( int i = 0; i < minFreq; i++ )
    			{
    				intersection.add( entry.getKey( ) );
    			}
    		}
    	}
    	
    	// convert to array
    	int[] result = new int[intersection.size( )];
    	int pos = 0;
    	for ( int num : intersection )
    	{
    		result[pos] = num;
    		pos++;
    	}
    	return result;
    }

}