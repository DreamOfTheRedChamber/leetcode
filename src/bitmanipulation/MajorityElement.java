package bitmanipulation;

/**
 * 
 */

// TO_TEST 
public class MajorityElement
{
    public int majorityElement( int[] nums )
    {
    	if ( nums.length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	int candidate = nums[0];
    	int candidateFreq = 1;
    	for ( int i = 1; i < nums.length; i++ )
    	{
    		if ( candidateFreq == 0 )
    		{
    			candidate = nums[i];
    			candidateFreq = 1;
    		}
    		else
    		{
    			if ( candidate == nums[i] )
    			{
    				candidateFreq++;
    			}
    			else
    			{
    				candidateFreq--;
    			}
    		}
    	}
    	return candidate;
    }
}
