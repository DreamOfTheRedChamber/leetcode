package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * */

public class Subsets 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> oneSubset = new ArrayList<>();
        buildSubsets( allSubsets, oneSubset, nums, 0 );        
        return allSubsets;
    }
    
    private void buildSubsets( List<List<Integer>> allSubsets, List<Integer> oneSubset, int[] nums, int startPos )
    {
    	if ( startPos == nums.length )
    	{
    		allSubsets.add( new ArrayList<>( oneSubset ) );
    		return;
    	}
    	
    	oneSubset.add( nums[startPos] );
    	buildSubsets( allSubsets, oneSubset, nums, startPos + 1 );
    	oneSubset.remove( oneSubset.size( ) - 1 );
    	buildSubsets( allSubsets, oneSubset, nums, startPos + 1 );
    }
}
