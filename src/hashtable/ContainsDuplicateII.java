package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 */

public class ContainsDuplicateII
{

    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
    	Map<Integer, Integer> numToLatestPos = new HashMap<>();
    	for ( int i = 0; i < nums.length; i++ )
    	{
    		int num = nums[i];
    		if ( numToLatestPos.containsKey( num ) 
    				&& i - numToLatestPos.get( num ) <= k)
    		{
    			return true;
    		}
    		
    		numToLatestPos.put( num, i );
    	}
    	return false;
    }

}
