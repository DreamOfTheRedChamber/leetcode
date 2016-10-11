package twoPointer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*    	
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

 * */
public class MinimumSizeSubarraySum 
{
	@Test
	public void test()
	{
		assertEquals( 0, minSubArrayLen( 8, new int[]{ 2, 5 } ) );		
		assertEquals( 2, minSubArrayLen( 7, new int[]{ 2, 3, 1, 2, 4, 3 } ) );
	}
	
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
    			currWindSum += nums[currWindEnd];
    			currWindEnd++;
    		}
    		
    		while ( currWindStart < currWindEnd
    				&& currWindSum >= s )
    		{
    			minSize = Math.min( currWindEnd-currWindStart, minSize );
    			currWindSum -= nums[currWindStart];
    			currWindStart++;
    		}
    	}
    	if ( minSize == Integer.MAX_VALUE )
    	{
    		return 0;
    	}
    	else
    	{
    		return minSize;
    	}
    }
}
