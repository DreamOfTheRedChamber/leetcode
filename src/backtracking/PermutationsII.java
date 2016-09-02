package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * */
public class PermutationsII 
{
    public List<List<Integer>> permuteUnique( int[] nums ) 
    {
    	List<List<Integer>> allPerms = new LinkedList<>();
    	List<Integer> onePerm = new LinkedList<>();
    	Arrays.sort( nums );
    	boolean[] isUsed = new boolean[nums.length];
    	generatePerms( allPerms, onePerm, nums, isUsed, 0 );
    	return allPerms;
    }
    
    private void generatePerms( List<List<Integer>> allPerms, List<Integer> onePerm, int[] nums, boolean[] isUsed, int totalNumUsed )
    {   	
    	// recursion base
    	if ( totalNumUsed == nums.length )
    	{
    		allPerms.add( new LinkedList<>( onePerm ) );
    		return;
    	}
    	
    	// recursion body
    	for ( int i = 0 ; i < nums.length; i++ )
    	{    		
    		if ( !isUsed[i] )
    		{
	    		if ( i > 0 
	    				&& nums[i] == nums[i-1]
	    				&& !isUsed[i-1] )
	    		{
	    			continue;
	    		}
	    		
	    		isUsed[i] = true;
	    		onePerm.add( nums[i] );
	    		generatePerms( allPerms, onePerm, nums, isUsed, totalNumUsed + 1 );
	    		onePerm.remove( onePerm.size( ) - 1 );
	    		isUsed[i] = false;
    		}
    	}
    }
        
    @Test
    public void test()
    {
    	System.out.println( permuteUnique( new int[]{ 1, 1, 2 } ) );    	
    }
}