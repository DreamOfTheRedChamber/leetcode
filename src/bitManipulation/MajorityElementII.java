package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII 
{
    public List<Integer> majorityElement( int[] nums )
    {
    	List<Integer> result = new ArrayList<>();
    	int candidateOne = 0;
    	int candidateOneFreq = 0;
    	int candidateTwo = 0;
    	int candidateTwoFreq = 0;
    	for ( int num : nums )
    	{
    		if ( candidateOneFreq == 0 
    				&& ( candidateTwoFreq == 0 
    						|| ( candidateTwoFreq != 0 && candidateTwo != num ) ) )
    		{
    			// candidateOne empty, set
    			candidateOne = num;
    			candidateOneFreq++;
    		}
    		else if ( candidateTwoFreq == 0 
    					&& ( candidateOneFreq == 0
    							|| ( candidateOneFreq != 0 && candidateOne != num) ) )
    		{
    			// candidateTwo empty, set
    			candidateTwo = num;
    			candidateTwoFreq++;
    		}
    		else if ( num == candidateOne )
    		{
    			candidateOneFreq++;
    		}
    		else if ( num == candidateTwo )
    		{
    			candidateTwoFreq++;
    		}
    		else
    		{
    			candidateOneFreq--;
    			candidateTwoFreq--;
    		}
    	}
    	
    	if ( candidateOneFreq != 0 
    			&& validateMajority( nums, candidateOne ) )
    	{
    		result.add( candidateOne );
    	}
    	
    	if ( candidateTwoFreq != 0 
    			&& validateMajority( nums, candidateTwo ) )
    	{
    		result.add( candidateTwo );
    	}
    	
    	return result;
    }
    
    private boolean validateMajority( int[] nums, int candidate )
    {
    	int candidateFreq = 0;
    	for ( int num : nums )
    	{
    		if ( num == candidate )
    		{
    			candidateFreq++;
    		}
    	}
    	
    	if ( candidateFreq > nums.length / 3 )
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
