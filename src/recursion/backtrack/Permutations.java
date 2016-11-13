package recursion.backtrack;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * */
public class Permutations 
{
    public List<List<Integer>> permute( int[] nums ) 
    {
    	List<List<Integer>> allPerms = new LinkedList<>();
    	LinkedList<Integer> onePerm = new LinkedList<>();
    	boolean[] isUsed = new boolean[nums.length];
    	generatePermutation( allPerms, onePerm, nums, isUsed );    	
    	return allPerms;
    }
    
    public void generatePermutation( List<List<Integer>> allPerms, LinkedList<Integer> onePerm, int[] nums, boolean[] isUsed )
    {
    	if ( onePerm.size() == nums.length )
    	{
    		allPerms.add( new LinkedList<>( onePerm ) );
    		return;
    	}
    	
    	for ( int i = 0; i < nums.length; i++ )
    	{
    		if ( !isUsed[i] )
    		{
    			isUsed[i] = true;
    			onePerm.addLast( nums[i] );
    			generatePermutation( allPerms, onePerm, nums, isUsed );
    			onePerm.removeLast();
    			isUsed[i] = false;
    		}
    	}
    }
    
    @Test
    public void test()
    {
    	System.out.println( permute( new int[]{ 1, 2, 3 } ) );
    }
}
