package binarySearch;

/*    	
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

 * */

public class MinimumSizeSubarraySum 
{
	// TODO: what if both postive and negative integers
    public int minSubArrayLen( int s, int[] nums )
    {
    	int currWindStart = 0;
    	int currWindEnd = 0;
    	int currWindSum = 0;
    	int minSize = Integer.MAX_VALUE;
    	while ( currWindEnd < nums.length )
    	{
    		while ( currWindEnd < nums.length
    				&& currWindSum < s )
    		{    			
    			s += nums[currWindEnd];
    			currWindEnd++;
    		}
    		
    		if ( currWindSum < s )
    		{
    			while ( currWindStart < currWindEnd
    					&& currWindSum >= s )
    			{
    				minSize = Math.min( currWindEnd-currWindStart, minSize );
    				s -= nums[currWindStart];
    				currWindStart++;
    			}
    		}
    	}
    	return minSize;
    }
}
